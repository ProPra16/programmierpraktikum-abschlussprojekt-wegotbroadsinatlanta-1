import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Lionel on 28.06.2016.
 */
public class LoadController implements Initializable{       //Design des FXML muss überarbeitet werden  ---> Ando
    @FXML private ListView list;
    @FXML Button startTDDT;
    private int currentselection;
    ObservableList<String> items = FXCollections.observableArrayList ("Aufgabe: 1", "Aufgabe: 2"); ///Die Aufgabenstellungen müssen noch eingefügt werden

    public void initialize(URL url, ResourceBundle rb){
        list.setItems(items);
        list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {       // Auswahl ohne Select Button
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                currentselection = getIndex(newValue);
                DEBUG.out("Selected item at index: " + currentselection);
            }
        });
    }

    private int getIndex(String s) {
        for(int i = 0; i < this.items.size(); ++i) {
            if(this.items.get(i) == s) return i;
        }return -1;
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

