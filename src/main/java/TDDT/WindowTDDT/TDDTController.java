package TDDT.WindowTDDT;

import TDDT.Time.*;
import TDDT.DEBUG;
import TDDT.Compiler.*;
import TDDT.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Lionel on 29.06.2016.
 */
public class TDDTController implements Initializable{
    private boolean testMode = true;
    private boolean refactor = false;
    public CompilationResult result = null;
    @FXML
    private TextArea fieldgreen;
    @FXML
    private TextArea fieldred;
    @FXML
    private Button switchbutton;
    @FXML
    private Label errorcounter;
    @FXML
    private Label status;
    @FXML
    public Label babystepCounter;

    timer timer;
    public static TDDTController self;

    String tempCode = "";

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
            "  assertEquals(true, LeapYear.isLeapYear(2000));\n" +
            " }\n" +
            "\n" +
            " @Test\n" +
            " public void year2400IsALeapYear()  {\n" +
            "  assertEquals(true, LeapYear.isLeapYear(2400));\n" +
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
        status.setStyle("font-weight:bold;letter-spacing:1pt;word-spacing:2pt;font-size:32px;text-align:left;font-family:arial, helvetica, sans-serif;line-height:1;");
        if(testMode){
            setLabel(status,"TESTMODE",Color.RED);
            fieldgreen.setEditable(false);
            switchbutton.setDisable(true);
        }
        self = this;
    }

    public void setLabel(Label l,String s, Color c){
        l.setText(s);
        l.setTextFill(c);
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
        //TDDT.WindowTDDT.TDDT.CompilationResultesult result = TDDT.WindowTDDT.TDDT.Compilerpile.compileCode(findClassName(leapyearcode),leapyearcode,false);
        //TDDT.WindowTDDT.TDDT.CompilationResultesult result = TDDT.WindowTDDT.TDDT.Compilempile.compileCodeandTest(findClassName(leapyearcode),leapyearcode,false,findClassName(leapyeartest),leapyeartest,true);
        try{
            if(testMode){
                //TestClassCompilen
                CompilationResult result = Compile.compileCodeandTest(findClassName(getLeftTextArea()),getLeftTextArea(),false,findClassName(getRightTextArea()),getRightTextArea(),true);
                //Check for Failing Test or not compiling <code></code>
                DEBUG.out(String.valueOf(result.numberOfFailedTest));
                if(result.numberOfFailedTest>0 || result.hasErrors == true){ // or haserrors == true
                    switchbutton.setDisable(false);
                    //set switchbutton color greeen !!!!
                }
            }else{
                //MainCodeCompilen
                CompilationResult result = Compile.compileCode(findClassName(getLeftTextArea()),getLeftTextArea(),false);
            }
        }catch(Exception e){
            DEBUG.out("Error in Compilation");
            Main.self.TDDTStatusBar.output.setText("Error in Compilation");e.printStackTrace();}
        errorcounter.setText("Fehler in Tests: " + result.numberOfFailedTest);
        Main.self.TDDTStatusBar.output.setText(result.outmessage);
        if(result.hasErrors){ Main.self.TDDTStatusBar.output.setTextFill(Color.web("#FF6B68"));}else{
            Main.self.TDDTStatusBar.output.setTextFill(Color.web("#e3e3e3"));}
    }

    public void switchField(){
        CompilationResult result = Compile.compileCodeandTest(findClassName(getLeftTextArea()),getLeftTextArea(),false,findClassName(getRightTextArea()),getRightTextArea(),true);
        errorcounter.setText("Fehler in Tests: " + result.numberOfFailedTest);
        if(refactor && !result.hasErrors){
            fieldgreen.setEditable(false);
            fieldred.setEditable(true);
            testMode = true;
            setLabel(status,"TESTMODE",Color.RED);
        }else{
            if(testMode){ //&& !result.hasErrors
                //Switching to Code
                fieldgreen.setEditable(true);
                fieldred.setEditable(false);
                testMode = false;
                setLabel(status,"CODEMODE",Color.GREEN);
                tempCode = getLeftTextArea();
            }else{
            if(result.hasErrors){   //RESETET Code falls Error  und Switch back
                setLeftTextArea(tempCode);
                fieldgreen.setEditable(false);
                fieldred.setEditable(true);
                testMode = true;
                setLabel(status,"TESTMODE",Color.RED);
            }else if(result.hasErrors == false){
                refactor = true;
                setLabel(status,"REFACTORING",Color.BLACK);
            }
        }
        }
        if (timer != null) timer.stop();
        timer = new timer(180);
    }

    public void timeOver(){
        //do revert
        System.out.println("TIME OVER");
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
