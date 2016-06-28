import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javafx.application.Application;

/**
 * Created by Lionel on 28.06.2016.
 */
public class LoadStage {


    public LoadStage(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("load.fxml"));
            Stage loadStage = new Stage();
            loadStage.setTitle("TDDT - Loader");
            loadStage.setScene(new Scene(root, 1000, 800));
            loadStage.show();
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }
}
