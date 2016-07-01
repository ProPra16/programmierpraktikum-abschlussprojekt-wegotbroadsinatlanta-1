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

    //-----API----------------------------
    public void setLeftTextArea(String s){
        fieldgreen.setText(s);
    }
    public void setRightTextArea(String s){
        fieldred.setText(s);
    }
    public String getLeftTextArea(){
        return fieldgreen.getText();
    }
    public String getRightTextArea(){
        return fieldred.getText();
    }


}
