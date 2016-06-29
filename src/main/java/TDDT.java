import FileIO.Project;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * Created by Lionel on 28.06.2016.
 */
public class TDDT extends Application {
    public Stage mainStage = new Stage();
    public Project Task = null;
    @FXML private TextArea fieldgreen;

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        LoadStage LoadStage = new LoadStage();
        mainStage.setTitle("TDDT");
        mainStage.setScene(new Scene(root, 1000, 800));
        mainStage.show();
    }

    public void setTask(Project p){
        this.Task = p;
        System.out.println(p.code + p.test); //Debug Project übergabe
        fieldgreen.setText(p.code);
    }

}
