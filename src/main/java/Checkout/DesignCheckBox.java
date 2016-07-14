package Checkout;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * Created by Ando Mando on 14.07.2016.
 */
public class DesignCheckBox extends Application {

    Button bestätigen, abbrechen;
    Scene scene;
    Label label1;

    public static void main (String[]args){
        launch(args);
    }

    @Override
    public void start(Stage primarystage) throws Exception{
        primarystage.setTitle("Feature-Einstellungen");

        CheckBox auswahl1 = new CheckBox("Timetracking");
        CheckBox auswahl2 = new CheckBox("Babysteps");
        //auswahl2.setSelected(true);

        bestätigen = new Button("Bestätigen");
        bestätigen.setOnAction(e -> {
            //Weiter zum nächsten Fenster, jedoch mit den ausgewählten Einstellungen

        });

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(50, 50, 50, 50));
        layout.getChildren().addAll(auswahl1, auswahl2, bestätigen);

        abbrechen = new Button("Abbrechen");
        abbrechen.setOnAction(e -> {
            //Zurürck zum Fenster

        });
        layout.getChildren().add(abbrechen);

        label1 = new Label();
        label1.setText("\nBitte wählen Sie Ihre gewünschten Features aus und bestätigen Sie.");

        layout.getChildren().add(label1);


        scene = new Scene(layout, 800, 500);
        primarystage.setScene(scene);
        primarystage.show();
    }


}
