package Time;

/**
 * Created by Felix Kerlin on 6/28/2016.
 */
public class timer implements Runnable{
    long startM;
    long timerInterval;
    boolean running = false;
    private Thread timerThread;
    String timeLeft;

    public timer(int interval){
        timerInterval = (interval + 1) * 1000;
        System.out.println("Creating Timer");
    }

    public void start(){
        System.out.println("Starting Timer");
        startM = timeTools.Milliseconds();
        running = true;
        timeLeft = fTimeLeft();
        if (timerThread == null) {
            timerThread = new Thread(this, "Timer");
            timerThread.start();
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

    boolean checkNotFinished(){
        if ((timeTools.Milliseconds() - startM) >= timerInterval) {
            reset();
            return false;
        }
        return true;
    }

    long fmsLeft() {
        return timerInterval - (timeTools.Milliseconds() - startM);
    }

    void reset(){
        startM = 0L;
        timerInterval = 0L;
        if (timerThread != null){
            timerThread.interrupt();
            timerThread = null;
        }
    }

    void out(){
        System.out.println(timeLeft);
    }
}
