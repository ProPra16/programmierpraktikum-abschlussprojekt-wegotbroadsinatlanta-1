package Fensterdesigns;

import javafx.application.Application;
//import javafx.scene.control.Alert;
import javafx.stage.Stage;

/**
 * Created by Ando Mando on 07.07.2016.
 */
public class Zeiteinteilung{

    String bereich;
    long startZeit;
    long endZeit;
    long differenz;

    public void Zeiteinteilung(String bereich, long startZeit, long endZeit){
        this.bereich = bereich;
        this.startZeit = startZeit;
    }

}
