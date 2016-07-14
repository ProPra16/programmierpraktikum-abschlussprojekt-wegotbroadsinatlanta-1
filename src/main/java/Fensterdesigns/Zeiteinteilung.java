//alert erstmal auskommentiert--------------------------------------------------------------------------------
package Fensterdesigns;

import javafx.application.Application;
//import javafx.scene.control.Alert;
import javafx.stage.Stage;

/**
 * Created by Ando Mando on 07.07.2016.
 */
public class Zeiteinteilung extends Application{
    String bereich;
    long startZeit;
    long endZeit;
    long differenz;

    public void Zeiteinteilung(String bereich, long startZeit, long endZeit){
        this.bereich = bereich;
        this.startZeit = startZeit;
    }

    public void zeitunterschied(){
        this.differenz = this.endZeit - this. startZeit;
    }

    public void getzeit(){

    }

    @Override
    public void start(Stage primarystage){

        primarystage.setTitle("Zeit");
        //Alert alert = new Alert(Alert.AlertType.ERROR);
        //alert.setTitle("Deine Zeit");
        //alert.setHeaderText("Du hast insgesamt " + differenz + " Sekunden benötigt.");
        //alert.show();
        //}

}
