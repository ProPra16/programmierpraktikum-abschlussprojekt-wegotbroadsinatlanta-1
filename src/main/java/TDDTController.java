import FileIO.Project;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    @FXML
    private Label errorcounter;



    String leapyearcode="public class LeapYear{\n" +
            "  public static boolean isLeapYear(int year) {\n" +
            "    if (year % 400 == 0) return true;\n" +
            "    if (year % 100 == 0) return false;\n" +
            "    if (year % 4 == 0) return true;\n" +
            "    return false;\n" +
            "  }\n" +
            "}\n";

    String leapyeartest = "import static org.junit.Assert.*;\n" +
            "import org.junit.*;\n" +
            "\n" +
            "public class LeapYearTest{\n" +
            "\n" +
            " @Test\n" +
            " public void year2000IsALeapYear()  {\n" +
            "  assertEquals(true, LeapYear.isLeapYear(2019));\n" +
            " }\n" +
            "\n" +
            " @Test\n" +
            " public void year2400IsALeapYear()  {\n" +
            "  assertEquals(false, LeapYear.isLeapYear(2400));\n" +
            " }\n" +
            "\n" +
            " @Test\n" +
            " public void year1900IsNoLeapYear()  {\n" +
            "  assertEquals(false, LeapYear.isLeapYear(1900));\n" +
            " }\n" +
            "\n" +
            " @Test\n" +
            " public void year1800IsNoLeapYear()  {\n" +
            "  assertEquals(false, LeapYear.isLeapYear(1800));\n" +
            " }\n" +
            "\n" +
            " @Test\n" +
            " public void year1904IsALeapYear()  {\n" +
            "  assertEquals(true, LeapYear.isLeapYear(1904));\n" +
            " }\n" +
            "\n" +
            " @Test\n" +
            " public void year1908IsALeapYear()  {\n" +
            "  assertEquals(true, LeapYear.isLeapYear(1908));\n" +
            " }\n" +
            "\n" +
            " @Test\n" +
            " public void year1901IsNoLeapYear()  {\n" +
            "  assertEquals(false, LeapYear.isLeapYear(1901));\n" +
            " }\n" +
            "\n" +
            " @Test\n" +
            " public void year1902IsNoLeapYear()  {\n" +
            "  assertEquals(false, LeapYear.isLeapYear(1902));\n" +
            " }\n" +
            "\n" +
            "\n" +
            "}\n" +
            "\n";



    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setLeftTextArea(leapyearcode);
        setRightTextArea(leapyeartest);
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
        Compile Compile = new Compile();
        //CompilationResult result = Compile.compileCode(findClassName(leapyearcode),leapyearcode,false);
        //CompilationResult result = Compile.compileCodeandTest(findClassName(leapyearcode),leapyearcode,false,findClassName(leapyeartest),leapyeartest,true);
        try{
            if(testMode){
                //TestClassCompilen
                CompilationResult result = Compile.compileCodeandTest(findClassName(getLeftTextArea()),getLeftTextArea(),false,findClassName(getRightTextArea()),getRightTextArea(),true);
            }else{
                //MainCodeCompilen
                CompilationResult result = Compile.compileCode(findClassName(getLeftTextArea()),getLeftTextArea(),false);
            }
        }catch(Exception e){DEBUG.out("Error in Compilation");Main.self.statusBar.output.setText("Error in Compilation");e.printStackTrace();}
        errorcounter.setText("Fehler in Tests: " + result.numberOfFailedTest);
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
