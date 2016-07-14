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
    Button abbrechen, neustart, statistik;
    HBox graph;

    public static void main(String[]args){
        launch(args);
    }

    @Override
    public void start(Stage primarystage){
        window = primarystage;
        fensterkonstrukt(window);
    }

    private void fensterkonstrukt(Stage window){
        abbrechen = new Button("Abbrechen");
        neustart = new Button("Neustart");
        statistik = new Button("Statistik");

        neustart.setOnAction(e -> {
            //Zurück zu Fenster 1
        });

        abbrechen.setOnAction(e -> {
           window.close();
        });

        statistik.setOnAction(e -> {
            /*Graph soll angezeigt werden
            graph = new HBox();
            graph.getChildren().add(getChart());
            */
        });

        HBox layoutButton = new HBox();
        layoutButton.getChildren().addAll(neustart, abbrechen, statistik);

        BorderPane layoutmain = new BorderPane();
        layoutmain.setTop(layoutButton);
        layoutmain.setCenter(graph);

        Scene scene = new Scene(layoutmain, 800, 500);
        window.setScene(scene);

        window.show();
    }
}
