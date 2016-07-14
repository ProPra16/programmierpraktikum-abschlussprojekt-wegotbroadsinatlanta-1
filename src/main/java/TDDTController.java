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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.fxmisc.richtext.CodeArea;
import org.fxmisc.richtext.LineNumberFactory;
import org.fxmisc.richtext.StyleSpans;
import org.fxmisc.richtext.StyleSpansBuilder;

import java.net.URL;
import java.util.Collection;
import java.util.Collections;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Lionel on 29.06.2016.
 */
public class TDDTController implements Initializable{
    private boolean testMode = true;
    private boolean refactor = false;
    public CompilationResult result = null;
    @FXML
    private CodeArea fieldgreen;
    @FXML
    private CodeArea fieldred;
    @FXML
    private Button switchbutton;
    @FXML
    private Label errorcounter;
    @FXML
    private Label status;


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

        fieldgreen.setParagraphGraphicFactory(LineNumberFactory.get(fieldgreen));
        fieldred.setParagraphGraphicFactory(LineNumberFactory.get(fieldred));
        fieldgreen.setStyleSpans(0, computeHighlighting(fieldgreen.getText()));
        fieldred.setStyleSpans(0, computeHighlighting(fieldred.getText()));
        fieldgreen.richChanges()
                .filter(ch -> !ch.getInserted().equals(ch.getRemoved())) // XXX
                .subscribe(change -> {
                    fieldgreen.setStyleSpans(0, computeHighlighting(fieldgreen.getText()));
                });
        fieldred.richChanges()
                .filter(ch -> !ch.getInserted().equals(ch.getRemoved())) // XXX
                .subscribe(change -> {
                    fieldred.setStyleSpans(0, computeHighlighting(fieldred.getText()));
                });



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
        //CompilationResult result = Compile.compileCode(findClassName(leapyearcode),leapyearcode,false);
        //CompilationResult result = Compile.compileCodeandTest(findClassName(leapyearcode),leapyearcode,false,findClassName(leapyeartest),leapyeartest,true);
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
        }catch(Exception e){DEBUG.out("Error in Compilation");Main.self.statusBar.output.setText("Error in Compilation");e.printStackTrace();}
        errorcounter.setText("Fehler in Tests: " + result.numberOfFailedTest);
        Main.self.statusBar.output.setText(result.outmessage);
        if(result.hasErrors){ Main.self.statusBar.output.setTextFill(Color.web("#FF6B68"));}else{Main.self.statusBar.output.setTextFill(Color.web("#e3e3e3"));}
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
    }

    //-----API----------------------------
    public void setLeftTextArea(String s){fieldgreen.replaceText(s);}
    public void setRightTextArea(String s){
        fieldred.replaceText(s);
    }
    public String getLeftTextArea(){
        return fieldgreen.getText();
    }
    public String getRightTextArea(){
        return fieldred.getText();
    }



    //----------SYNTAX - HIGHLIGHTING -----------------------   https://github.com/TomasMikula/RichTextFX/blob/master/richtextfx-demos/src/main/java/org/fxmisc/richtext/demo/JavaKeywords.java

    private static final String[] KEYWORDS = new String[] {
            "abstract", "assert", "boolean", "break", "byte",
            "case", "catch", "char", "class", "const",
            "continue", "default", "do", "double", "else",
            "enum", "extends", "final", "finally", "float",
            "for", "goto", "if", "implements", "import",
            "instanceof", "int", "interface", "long", "native",
            "new", "package", "private", "protected", "public",
            "return", "short", "static", "strictfp", "super",
            "switch", "synchronized", "this", "throw", "throws",
            "transient", "try", "void", "volatile", "while"
    };

    private static final String KEYWORD_PATTERN = "\\b(" + String.join("|", KEYWORDS) + ")\\b";
    private static final String PAREN_PATTERN = "\\(|\\)";
    private static final String BRACE_PATTERN = "\\{|\\}";
    private static final String BRACKET_PATTERN = "\\[|\\]";
    private static final String SEMICOLON_PATTERN = "\\;";
    private static final String STRING_PATTERN = "\"([^\"\\\\]|\\\\.)*\"";
    private static final String COMMENT_PATTERN = "//[^\n]*" + "|" + "/\\*(.|\\R)*?\\*/";

    private static final Pattern PATTERN = Pattern.compile(
            "(?<KEYWORD>" + KEYWORD_PATTERN + ")"
                    + "|(?<PAREN>" + PAREN_PATTERN + ")"
                    + "|(?<BRACE>" + BRACE_PATTERN + ")"
                    + "|(?<BRACKET>" + BRACKET_PATTERN + ")"
                    + "|(?<SEMICOLON>" + SEMICOLON_PATTERN + ")"
                    + "|(?<STRING>" + STRING_PATTERN + ")"
                    + "|(?<COMMENT>" + COMMENT_PATTERN + ")"
    );

    private static StyleSpans<Collection<String>> computeHighlighting(String text) {
        Matcher matcher = PATTERN.matcher(text);
        int lastKwEnd = 0;
        StyleSpansBuilder<Collection<String>> spansBuilder
                = new StyleSpansBuilder<>();
        while(matcher.find()) {
            String styleClass =
                    matcher.group("KEYWORD") != null ? "keyword" :
                            matcher.group("PAREN") != null ? "paren" :
                                    matcher.group("BRACE") != null ? "brace" :
                                            matcher.group("BRACKET") != null ? "bracket" :
                                                    matcher.group("SEMICOLON") != null ? "semicolon" :
                                                            matcher.group("STRING") != null ? "string" :
                                                                    matcher.group("COMMENT") != null ? "comment" :
                                                                            null; /* never happens */ assert styleClass != null;
            spansBuilder.add(Collections.emptyList(), matcher.start() - lastKwEnd);
            spansBuilder.add(Collections.singleton(styleClass), matcher.end() - matcher.start());
            lastKwEnd = matcher.end();
        }
        spansBuilder.add(Collections.emptyList(), text.length() - lastKwEnd);
        return spansBuilder.create();
    }

}
