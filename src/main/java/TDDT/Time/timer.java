package TDDT.Time;

/**
 * Created by Felix Kerlin on 7/14/2016.
 */
import TDDT.WindowTDDT.TDDTController;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;

public class timer {

    static int counter = 0;
    Timeline timeline;

    public void stop(){
        timeline.stop();
    }

    public void tick(){
        if (counter >= 0) {
            TDDTController.self.babystepCounter.setText(timeTools.msToText(counter * 1000));
            System.out.println(counter);
            counter--;
        } else {
            TDDTController.self.timeOver();
            stop();
        }
    }

    public timer(int seconds) {
        counter = seconds;
        timeline = new Timeline(new KeyFrame(new javafx.util.Duration(1000), action -> tick()));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }
}
