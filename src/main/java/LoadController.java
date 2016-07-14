//import FileIO.Project;
import FileIO.Aufgabe;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.awt.image.AreaAveragingScaleFilter;
import java.io.File;
import java.util.ArrayList;

import static FileIO.FileIO.readKatalog;
import static FileIO.FileIO.writeKatalog;

/**
 * Created by Lionel on 28.06.2016.
 */
public class LoadController {       //Design des FXML muss überarbeitet werden  ---> Ando
    @FXML
    ListView list;
    @FXML Button startTDDT;
    ObservableList<String> items = FXCollections.observableArrayList (
            "Aufgabe: 1", "Aufgabe: 2", "Aufgabe: 3", "Aufgabe: 4", "Aufgabe: 1", "Aufgabe: 2", "Aufgabe: 3", "Aufgabe: 4", "Aufgabe: 1", "Aufgabe: 2", "Aufgabe: 3", "Aufgabe: 4", "Aufgabe: 1", "Aufgabe: 2", "Aufgabe: 3", "Aufgabe: 4"); ///Die Aufgabenstellungen müssen noch eingefügt werden

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
        int i = 0;
        ArrayList<Aufgabe> katalog = new ArrayList<Aufgabe>();
        writeKatalog(katalog);
        Main.self.Bp.setCenter(Main.self.root);
        ArrayList<Aufgabe> katalog2 = readKatalog();
        loadTask(katalog.get(i).aufgabeklassen.get(0).preset,katalog.get(i).aufgabetests.get(0).preset, katalog.get(i).name, katalog.get(i).config.babystep.value, katalog.get(i).config.timetracking);
    }

    public void loadTask(String code, String test, String taskname, boolean babysteps, boolean Timetracking){
        Main.tcontroller.setLeftTextArea(code);
        Main.tcontroller.setRightTextArea(test);

    }
}
