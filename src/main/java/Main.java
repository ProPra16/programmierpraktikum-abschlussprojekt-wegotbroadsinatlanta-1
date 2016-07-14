import FileIO.FileIO;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
    public Stage primaryStage = new Stage();
    public static TDDTController tcontroller;
    public static BorderPane Bp;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        mainStage.setTitle("TDDT");
        mainStage.setScene(new Scene(root, 1000, 800));
        mainStage.show();
        FileIO.writeKatalog(null);
        FileIO.readKatalog();
    public void start(Stage primaryStage2) throws Exception{
        DEBUG.out("Launch Application");
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

    public static void main(String[] args) {  // LAUNCH Parameter
        //launch(args);
        Application.launch(Main.class, args);
    }
}
