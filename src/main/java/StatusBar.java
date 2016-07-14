import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Created by Lionel on 07.07.2016.
 */
public class StatusBar extends StackPane{
    public Label output;

    public StatusBar(){
        Rectangle backrec = new Rectangle(Main.width,100);
        output = new Label("Status...");
        backrec.setFill(Color.web("#3a3a3a"));
        output.setTextFill(Color.web("#e3e3e3"));
        getChildren().addAll(backrec,output);
    }
}
