package Time;
import Time.Time;

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
    }

    public void start(){
        startM = Time.Milliseconds();
        running = true;
        timeLeft = fTimeLeft();
        if (timerThread == null) {
            timerThread = new Thread(this, "Timer");
        }
    }

    public void run(){
        while (running){
            running = checkNotFinished();
            if (!running) return;
            timeLeft = fTimeLeft();
            System.out.println(timeLeft);
            running = checkNotFinished();
            try {
                timerThread.sleep(1000);
            } catch (InterruptedException e) {
                //placeholder
            }
        }
    }

    public String fTimeLeft() {
        return Time.msToText(fmsLeft());
    }

    boolean checkNotFinished(){
        if ((Time.Milliseconds() - startM) >= timerInterval) {
            reset();
            return false;
        }
        return true;
    }

    long fmsLeft() {
        return timerInterval - (Time.Milliseconds() - startM);
    }

    void reset(){
        startM = 0L;
        timerInterval = 0L;
        if (timerThread != null){
            timerThread.interrupt();
            timerThread = null;
        }
    }
}
