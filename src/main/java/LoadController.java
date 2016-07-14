//import FileIO.Project;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

/**
 * Created by Lionel on 28.06.2016.
 */
public class LoadController {       //Design des FXML muss überarbeitet werden  ---> Ando
    @FXML private ListView list;
    @FXML Button startTDDT;
    ObservableList<String> items = FXCollections.observableArrayList ("Aufgabe: 1", "Aufgabe: 2"); ///Die Aufgabenstellungen müssen noch eingefügt werden

    void initialize(){
        list.setItems(items);
        list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {       // Auswahl ohne Select Button
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.println("Selected item: " + newValue);
            }
        });
    }

    public void startTDDT(){
        Main.self.Bp.setCenter(Main.self.root);
        loadTask("code","test","23",true,true);
    }

    public void loadTask(String code, String test, String taskname, boolean babysteps, boolean Timetracking){
        Main.tcontroller.setLeftTextArea(code);
        Main.tcontroller.setRightTextArea(test);
    }
}
