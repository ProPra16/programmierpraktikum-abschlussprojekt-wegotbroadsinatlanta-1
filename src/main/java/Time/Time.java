package Time;
import java.util.concurrent.TimeUnit;

/**
 * Created by Felix Kerlin on 6/28/2016.
 */
public class Time {
    public static long Milliseconds(){
        return System.currentTimeMillis();
    }

    public static String msToText(long ms){
        return String.format("%02d Minuten, %02d Sekunden", TimeUnit.MILLISECONDS.toMinutes(ms), TimeUnit.MILLISECONDS.toSeconds(ms) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(ms)));
    }
}
