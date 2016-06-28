import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Lionel on 28.06.2016.
 */
public class TDDT extends Application {
    public Stage mainStage = new Stage();

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        LoadStage LoadStage = new LoadStage();
        mainStage.setTitle("TDDT");
        mainStage.setScene(new Scene(root, 1000, 800));
        mainStage.show();
    }

}
