package TDDT;

import TDDT.WindowTDDT.TDDTStatusBar;
import TDDT.WindowTDDT.TDDTController;
import TDDT.WindowTDDT.TDDTMenuBar;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class  Main extends Application {
    public Stage primaryStage = new Stage();
    public static TDDTController tcontroller;
    public static BorderPane Bp;
    public static Main self;
    public static int width = 1400;
    public static int heigth = 1000;
    public TDDTStatusBar TDDTStatusBar;
    public Parent root;
    @Override

    public void start(Stage primaryStage2) throws Exception{
        DEBUG.out("Launch Application");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        root = loader.load();
        tcontroller = loader.getController();


        Bp = new BorderPane();
        Bp.setTop(new TDDTMenuBar().TopMenu());
        Bp.setCenter(root);
        TDDTStatusBar = new TDDTStatusBar();
        Bp.setBottom(TDDTStatusBar);
        Scene mainScene = new Scene(Bp,width,heigth);
        primaryStage.setTitle("TDDT");
        primaryStage.setScene(mainScene);
        primaryStage.show();
        self = this;
    }

    public static void main(String[] args) {  // LAUNCH Parameter
        //launch(args);
        //playSound();
        Application.launch(Main.class, args);
    }

    public static void playSound() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:/test.wav").getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch(Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }
}
