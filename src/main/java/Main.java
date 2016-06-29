import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        TDDT TDDT = new TDDT();//loader.getController());
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        BorderPane Bp = new BorderPane();
        Bp.setTop(TDDT.TopMenu());
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
}
