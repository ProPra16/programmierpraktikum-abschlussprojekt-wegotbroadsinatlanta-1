package TDDT.Time;

import javafx.application.Platform;
import javafx.scene.control.Label;

/**
 * Created by Felix Kerlin on 6/28/2016.
 * Multithreading from http://www.tutorialspoint.com/java/java_multithreading.htm
 */
public class timer implements Runnable{
    private long startM;
    private long timerInterval;
    private boolean running = false;
    private Thread timerThread;
    private String timeLeft;
    private Label field;

    public timer(int interval, Label textfield){
        timerInterval = (interval + 1) * 1000;
        System.out.println("Creating Timer");
        field = textfield;
    }

    public void start(){
        System.out.println("Starting Timer");
        startM = timeTools.Milliseconds();
        running = true;
        timeLeft = fTimeLeft();
        if (timerThread == null) {
            System.out.println("1");
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Running Timer");
                    while (running){
                        running = checkNotFinished();
                        if (!running) return;
                        timeLeft = fTimeLeft();
                        out();
                        running = checkNotFinished();
                        try {
                            timerThread.sleep(1000);
                        } catch (InterruptedException e) {
                            //placeholder
                        }
                    }
                }
            });
        }
    }

    public void run(){
        System.out.println("Running Timer");
        while (running){
            running = checkNotFinished();
            if (!running) return;
            timeLeft = fTimeLeft();
            out();
            running = checkNotFinished();
            try {
                timerThread.sleep(1000);
            } catch (InterruptedException e) {
                //placeholder
            }
        }
    }

    public String fTimeLeft() {
        return timeTools.msToText(fmsLeft());
    }

    private boolean checkNotFinished(){
        if ((timeTools.Milliseconds() - startM) >= timerInterval) {
            reset();
            return false;
        }
        return true;
    }

    private long fmsLeft() {
        return timerInterval - (timeTools.Milliseconds() - startM);
    }

    private void reset(){
        startM = 0L;
        timerInterval = 0L;
        if (timerThread != null){
            timerThread.interrupt();
            timerThread = null;
        }
    }

    private void out(){
        System.out.println(timeLeft);
        field.setText("Zeit übrig: " + String.valueOf(timeTools.msToText(fmsLeft())));
    }
}
