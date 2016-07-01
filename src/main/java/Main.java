import FileIO.FileIO;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public Stage mainStage = new Stage();

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        mainStage.setTitle("TDDT");
        mainStage.setScene(new Scene(root, 1000, 800));
        mainStage.show();
        FileIO.writeKatalog(null);
    }


    public static void main(String[] args) {
        launch(args);
    }
    //Mains
}
