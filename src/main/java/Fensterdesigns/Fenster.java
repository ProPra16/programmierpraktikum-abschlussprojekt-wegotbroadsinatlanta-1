package Fensterdesigns;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Created by Ando Mando on 05.07.2016.
 */
public class Fenster extends Application {
    Stage window;
    Button beenden, neustart, statistik;
    HBox graph;

    public static void main(String[]args){
        launch(args);
    }

    @Override
    public void start(Stage primarystage){
        window = primarystage;
        beenden = new Button("Beenden");
        neustart = new Button("Neustart");
        statistik = new Button("Statistik");

        neustart.setOnAction(e -> {
            //Zurück zu Fenster 1
        });

        beenden.setOnAction(e -> {
           window.close();
        });

        statistik.setOnAction(e -> {
            /*Graph soll angezeigt werden
            graph = new HBox();
            graph.getChildren().add(getChart());
            */
        });

        Image neustarticon = new Image(getClass().getResourceAsStream(""));
        neustart.setGraphic(new ImageView(neustarticon));

        Image beendenicon = new Image(getClass().getResourceAsStream(""));
        beenden.setGraphic(new ImageView(beendenicon));

        Image graphicon = new Image(getClass().getResourceAsStream("../report.png"));
        statistik.setGraphic(new ImageView(graphicon));

        HBox layoutButton = new HBox();
        layoutButton.getChildren().addAll(neustart, beenden, statistik);

        BorderPane layoutmain = new BorderPane();

        layoutmain.setTop(layoutButton);
        layoutmain.setCenter(graph);

        Scene scene = new Scene(layoutmain, 800, 500);
        window.setScene(scene);

        window.show();
    }
}
