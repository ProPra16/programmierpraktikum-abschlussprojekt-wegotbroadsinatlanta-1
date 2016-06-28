import javafx.application.Application;
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
    private TDDT TDDT;
    @FXML
    ListView list;
    Button but;
    ObservableList<String> items = FXCollections.observableArrayList (
            "Aufgabe: 1", "Aufgabe: 2", "Aufgabe: 3", "Aufgabe: 4", "Aufgabe: 1", "Aufgabe: 2", "Aufgabe: 3", "Aufgabe: 4", "Aufgabe: 1", "Aufgabe: 2", "Aufgabe: 3", "Aufgabe: 4", "Aufgabe: 1", "Aufgabe: 2", "Aufgabe: 3", "Aufgabe: 4"); ///Die Aufgabenstellungen müssen noch eingefügt werden
    @FXML void initialize(){
        System.out.println("init");
        list.setItems(items);

        /*list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {       // Auswahl ohne Select Button
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.println("Selected item: " + newValue);
            }
        });*/
    }

    void startmain(int task) { //Ruft Main mit Parametern auf also Auswahl der Aufgabe
        TDDT.mainStage.show();
    }

    @FXML void selectTask(){
        startmain(1);
        System.out.println(list.getSelectionModel().selectedIndexProperty().toString());     // Get Index to select a Task and start main Stage with selection
    }
}
