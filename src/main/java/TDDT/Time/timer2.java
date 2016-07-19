package TDDT.Time;

/**
 * Created by Felix Kerlin on 7/14/2016.
 */
import TDDT.WindowTDDT.TDDTController;
import javafx.application.Platform;

import java.util.Timer;
import java.util.TimerTask;

public class timer2 {

    static int counter = 0;

    public timer2() {

        /*TimerTask timerTask = new TimerTask() {

            @Override
            public void run() {
                System.out.println("TimerTask executing counter is: " + counter);
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        TDDTController.self.babystepCounter.setText("Zeit übrig: " + counter);
                    }
                });
                th
            }
        };*/

        new Thread() {
            public void run() {
                counter++;
                System.out.println("asdf");
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        TDDTController.self.babystepCounter.setText("Zeit übrig: " + counter);
                    }
                });
                try {
                    Thread.sleep(1000);
                } catch (Exception ex) {

                }
            }
        }.start();

        //Timer timer = new Timer("MyTimer");//create a new Timer

        //timer.scheduleAtFixedRate(timerTask, 30, 1000);//this line starts the timer at the same time its executed
    }
}
