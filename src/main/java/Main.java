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

public class Main extends Application {
    public Stage primaryStage = new Stage();
    public static TDDTController tcontroller;
    public static BorderPane Bp;
    @Override
    public void start(Stage primaryStage2) throws Exception{
        DEBUG.out("Launch Application");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader.load();
        tcontroller = loader.getController();
        playSound();

        Bp = new BorderPane();
        Bp.setTop(new TDDTMenuBar().TopMenu());
        Bp.setCenter(root);
        Scene mainScene = new Scene(Bp,1400,1000);
        primaryStage.setTitle("TDDT");
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    public static void main(String[] args) {  // LAUNCH Parameter
        //launch(args);
        Application.launch(Main.class, args);
    }

    public void playSound() {
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
