import FileIO.Project;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Lionel on 29.06.2016.
 */
public class TDDTController implements Initializable{
    private boolean testMode = true;
    public CompilationResult result = null;
    @FXML
    private TextArea fieldgreen;
    @FXML
    private TextArea fieldred;
    @FXML
    private Button switchbutton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    /*
    ---------------------------------------------------
    benötigte Klassen:
        getClass() - returnt String mit Namen der aktuellen Klasse für das das Programm testet
        getTestClass() - ^^^^^^^^

    ---------------------------------------------------
     */

    public String findClassName(String code){
        String classname = code.substring(code.indexOf("class") + 6,code.indexOf("{")); //getclass() methode falls nicht in IO implementiert wird
        DEBUG.out("Found Classname: "+ classname);
        return classname;
    }
    public void run(){
        String testclassname = "convert"; //getclass();

        String code="public class RomanNumberConverter{\n" +
                "            public static String convert(){\n" +
                "            return null;\n" +
                "            }\n" +
                "            }";
        //Main.self.playSound();
        Compile Compile = new Compile();
        try{
            if(testMode){
                //TestClassCompilen
                CompilationResult result = Compile.compileCodeandTest(findClassName(getLeftTextArea()),getLeftTextArea(),false,findClassName(getRightTextArea()),getRightTextArea(),true);

            }else{
                //MainCodeCompilen
                CompilationResult result = Compile.compileCode(findClassName(getLeftTextArea()),getLeftTextArea(),false);
            }
        }catch(Exception e){DEBUG.out("Error in Compilation");e.printStackTrace();}
        Main.self.statusBar.output.setText(result.outmessage);
        if(result.hasErrors){ Main.self.statusBar.output.setTextFill(Color.web("#FF6B68"));}else{Main.self.statusBar.output.setTextFill(Color.web("#e3e3e3"));}
    }

    public void switchField(){
        if(testMode){ //&& !result.hasErrors
            //Switching to Code
            fieldgreen.setEditable(true);
            fieldred.setEditable(false);
            testMode = false;
        }else{
            fieldgreen.setEditable(false);
            fieldred.setEditable(true);
            testMode = true;
        }
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
