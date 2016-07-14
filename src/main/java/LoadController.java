import FileIO.Aufgabe;
import FileIO.Einlesen;
import FileIO.FileIO;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by Lionel on 28.06.2016.
 */
public class LoadController implements Initializable{       //Design des FXML muss überarbeitet werden  ---> Ando
    @FXML private ListView list;
    @FXML Button startTDDT;
    @FXML
    TextArea description;
    private int currentselection;
    public ArrayList<Aufgabe> kat;
    ObservableList<String> items = FXCollections.observableArrayList (); ///Die Aufgabenstellungen müssen noch eingefügt werden

    public void initialize(URL url, ResourceBundle rb){
        Einlesen e = new Einlesen();
        kat = e.lesen();
        description.setEditable(false);
        for(int i = 0;i<kat.size();i++){items.add(i,kat.get(i).name);}
        list.setItems(items);
        list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {       // Auswahl ohne Select Button
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                currentselection = getIndex(newValue);
                DEBUG.out("Selected item at index: " + currentselection);
                description.setText(kat.get(currentselection).description);

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
        loadTask(kat.get(currentselection).aufgabeklassen,kat.get(currentselection).aufgabetests,kat.get(currentselection).name,kat.get(currentselection).config.babystep.value,kat.get(currentselection).config.timetracking);
    }

    public void loadTask(String code, String test, String taskname, boolean babysteps, boolean Timetracking){
        Main.tcontroller.setLeftTextArea(code);
        Main.tcontroller.setRightTextArea(test);

    }
}

