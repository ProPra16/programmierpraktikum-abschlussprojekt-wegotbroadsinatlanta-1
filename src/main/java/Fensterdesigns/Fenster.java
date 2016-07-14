package Fensterdesigns;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Created by Ando Mando on 05.07.2016.
 */
public class Fenster extends Application {
    Stage window;
    Button abbrechen, neustart;

    private void fensterkonstrukt(Stage window){
        abbrechen = new Button("Abbrechen");
        neustart = new Button("Neustart");

        neustart.setOnAction(e -> {
            //Zurück zu Fenster 1
        });

        abbrechen.setOnAction(e -> {
           window.close();
        });

        HBox layout = new HBox();
        layout.getChildren().addAll(neustart, abbrechen);

        HBox graph = new HBox();
        //graph.getChildren().add(Chart.getChart(20.0, 20.0, 20.0));

        BorderPane borderpane = new BorderPane();
        borderpane.setTop(layout);

        Scene scene = new Scene(borderpane, 800, 500);
        window.setScene(scene);

        window.show();
    }

    /////////////////////////////////////////////////////TEST-AUSFÜHRUNG
    public static void main(String[]args){
        launch(args);
    }

    @Override
    public void start(Stage primarystage){
        window = primarystage;
        fensterkonstrukt(window);
    }
}
