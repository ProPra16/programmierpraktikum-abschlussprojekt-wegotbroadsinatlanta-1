import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

/**
 * Created by Lionel on 29.06.2016.
 */
public class TDDTController {
    @FXML
    private TextArea fieldgreen;
    @FXML
    private TextArea fieldred;

    public TDDTController(){}

    @FXML
    private void initalize(){
        //fieldgreen.setText("ajsdlj");
    }

    @FXML
    public void test(){
        fieldgreen.setText("asdjl");
    }
    @FXML
    public void setTextAreaGreen(String s){
        fieldgreen.setText(s);
    }

}
