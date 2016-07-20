package TDDT.WindowSettings;

import TDDT.Main;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;


/**
 * Created by Ando Mando on 14.07.2016.
 */
public class SettingsFenster {

    Button bestätigen, beenden;
    Scene scene;
    Label label1;

    public Scene DesignCheckBox(){
        //primarystage.setTitle("Feature-Einstellungen");

        CheckBox auswahl1 = new CheckBox("Timetracking");
        auswahl1.setSelected(true);
        CheckBox auswahl2 = new CheckBox("Babysteps");
        auswahl2.setSelected(true);

        bestätigen = new Button("Bestätigen");
        bestätigen.setOnAction(e -> {
            //Weiter zum nächsten FinalWindow, jedoch mit den ausgewählten Einstellungen
            //Überprüfung
            Main.tcontroller.babysteps = auswahl2.isSelected();
            Main.tcontroller.timetracking = auswahl1.isSelected();
        });

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(50, 50, 50, 50));
        layout.getChildren().addAll(auswahl1, auswahl2, bestätigen);

        beenden = new Button("Beenden");
        beenden.setOnAction(e -> {
            //TDDTMenuBar.settings.close();

        });
        layout.getChildren().add(beenden);

        label1 = new Label();
        label1.setText("\nBitte wählen Sie Ihre gewünschten Features aus und bestätigen Sie.");

        layout.getChildren().add(label1);


        scene = new Scene(layout, 800, 500);
        return scene;
        //primarystage.setScene(scene);
        //primarystage.show();
    }


}
