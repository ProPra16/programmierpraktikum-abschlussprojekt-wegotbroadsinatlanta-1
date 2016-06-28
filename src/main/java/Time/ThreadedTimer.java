package Time;

/**
 * Created by Felix Kerlin on 6/28/2016.
 */
public class ThreadedTimer {
    public static void run(int sec) {
        timer tTimer = new timer(sec);
        tTimer.start();
    }
}
