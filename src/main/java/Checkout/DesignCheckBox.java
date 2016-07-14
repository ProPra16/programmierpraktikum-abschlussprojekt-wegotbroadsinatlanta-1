package Checkout;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * Created by Ando Mando on 14.07.2016.
 */
public class DesignCheckBox extends Application {

    Button bestätigen;
    Scene scene;

    public static void main (String[]args){
        launch(args);
    }

   /* public void optioncheck(CheckBox auswahl1, CheckBox auswahl2) {
        String message = "Auswahl:\n";

        if(auswahl1.isSelected()) message += "Timetracking";

        if(auswahl2.isSelected()) message += "Babystep";

        System.out.println();
    }*/

    @Override
    public void start(Stage primarystage) throws Exception{
        primarystage.setTitle("Einstellungen");

        CheckBox auswahl1 = new CheckBox("Timetracking");
        CheckBox auswahl2 = new CheckBox("Babysteps");
        auswahl2.setSelected(true);

        bestätigen = new Button("Bestätigen");
       // bestätigen.setOnAction(e -> optioncheck(auswahl1, auswahl2));

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(auswahl1, auswahl2, bestätigen);

        scene = new Scene(layout, 300, 250);
        primarystage.setScene(scene);
        primarystage.show();
    }


}
