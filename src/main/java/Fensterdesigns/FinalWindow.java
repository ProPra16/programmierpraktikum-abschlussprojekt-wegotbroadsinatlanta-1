package Fensterdesigns;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import static Fensterdesigns.Chart.getchart;

/**
 * Created by Ando Mando on 05.07.2016.
 */
public class FinalWindow extends Application{
    Stage window;
    Button beenden, neustart, statistik;
   // HBox graph;
    Scene scene;
    Chart bar;
    BorderPane layoutmain;
    Stage window1;
    Node graph;
    double redprozent;
    double greenprozent;
    double refacprozent;
    final static String bereich = "";


    public static void main(String[]args){
        launch(args);
    }

    @Override
    public void start(Stage primarystage){
        window = primarystage;
        window.setTitle("Graph");

        beenden = new Button("Beenden");
        neustart = new Button("Neustart");
        statistik = new Button("Statistik");

        neustart.setOnAction(e -> {
            ///Zurück zu FinalWindow 1
        });

        beenden.setOnAction(e -> {
           window.close();
        });

        statistik.setOnAction(e -> {

            /////Nur für Test
            double red = 10.0;
            double green = 20.0;
            double refac = 30.0;
            /////Nur für Test
            getchart(red,green,refac);

            System.out.println("click");
        });

        Image neustarticon = new Image(getClass().getResourceAsStream(""));
        neustart.setGraphic(new ImageView(neustarticon));

        Image beendenicon = new Image(getClass().getResourceAsStream(""));
        beenden.setGraphic(new ImageView(beendenicon));

        //Image graphicon = new Image(getClass().getResourceAsStream("../report.png"));
        //statistik.setGraphic(new ImageView(graphicon));


        layoutmain = new BorderPane();

        HBox layoutButton = new HBox();
        layoutButton.getChildren().addAll(neustart, beenden, statistik);

        layoutmain.setTop(layoutButton);
        Scene scenenew = new Scene(layoutmain, 300, 300);
        window.setScene(scenenew);
        window.show();

    }


        public void getchart(double red, double green, double refac) {

            double gesamt = red + green + refac;
            redprozent = 100 / gesamt * red;
            greenprozent = 100 / gesamt * green;
            refacprozent = 100 / gesamt * refac;

            final CategoryAxis x = new CategoryAxis();
            final NumberAxis y = new NumberAxis();

            final BarChart<String, Number> values = new BarChart<String, Number>(x, y);

            values.setTitle("Zeiteinteilung pro Bereich");
            x.setLabel("Bereich");
            y.setLabel("Prozent");

            XYChart.Series se1 = new XYChart.Series();
            se1.setName("Red");
            se1.getData().add(new XYChart.Data(bereich, redprozent));

            XYChart.Series se2 = new XYChart.Series();
            se2.setName("Green");
            se2.getData().add(new XYChart.Data(bereich, greenprozent));

            XYChart.Series se3 = new XYChart.Series();
            se3.setName("Refactor");
            se3.getData().add(new XYChart.Data(bereich, refacprozent));

            // HBox h = new HBox();

            values.getData().addAll(se1, se2, se3);
            Scene scene = new Scene(values, 500, 500);
            window.setScene(scene);
            window.show();

    }
}
