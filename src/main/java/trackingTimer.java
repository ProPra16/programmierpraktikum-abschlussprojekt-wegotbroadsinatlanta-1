/**
 * Created by Felix Kerlin on 7/14/2016.
 */
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;

public class trackingTimer {

    Timeline timeline;

    public void stop(){
        timeline.stop();
    }

    public void tick(){
        TDDTController.self.track();
    }

    public trackingTimer() {
        timeline = new Timeline(new KeyFrame(new javafx.util.Duration(1000), action -> tick()));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }
}
