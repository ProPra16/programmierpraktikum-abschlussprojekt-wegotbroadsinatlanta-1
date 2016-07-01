import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public Stage primaryStage = new Stage();
    public static TDDTController tcontroller;
    public static BorderPane Bp;
    @Override
    public void start(Stage primaryStage2) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader.load();
        tcontroller = loader.getController();

        Bp = new BorderPane();
        Bp.setTop(new TDDTMenuBar().TopMenu());
        Bp.setCenter(root);
        Scene mainScene = new Scene(Bp,1400,1000);
        primaryStage.setTitle("TDDT");
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    public void openSettings() throws IOException {
        Scene settingScene = new Scene(FXMLLoader.load(getClass().getResource("sample.fxml")),1400,1000);
        primaryStage.setScene(settingScene);
    }

    public void loadTemplateView() throws IOException{
        FXMLLoader startloader = new FXMLLoader(getClass().getResource("load.fxml"));
        Parent loadroot = startloader.load();
        Bp.setCenter(loadroot);
    }

    public static void main(String[] args) {  // LAUNCH Parameter
        //launch(args);
        Application.launch(Main.class, args);
    }
}
