import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Lionel on 29.06.2016.
 */
public class TDDTController implements Initializable{
    @FXML
    private TextArea fieldgreen;
    @FXML
    private TextArea fieldred;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fieldgreen.setText("Willkommen");
    }

    //@FXML
    public void test(){
        fieldgreen.setText("asdjl");
    }
    //@FXML
    public void setTextAreaGreen(String s){

        fieldgreen.setText(s);
    }

}
