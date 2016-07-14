package Fensterdesigns;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class Chart extends Application {
    double redprozent;
    double greenprozent;
    double refacprozent;

    final static String eins = "";


    public Chart(double red, double green, double refac){
        double gesamt = red + green + refac;
        redprozent = 100 / gesamt * red;
        greenprozent = 100 / gesamt * green;
        refacprozent = 100 / gesamt * refac;

    }

    @Override public void start(Stage stage) {
        stage.setTitle("Begutachtung der Entwicklungsschritte");

        final CategoryAxis x = new CategoryAxis();
        final NumberAxis y = new NumberAxis();

        final BarChart<String,Number> values = new BarChart<String,Number>(x,y);

        values.setTitle("Zeiteinteilung pro Bereich");

        x.setLabel("Bereich");
        y.setLabel("Prozent");

        XYChart.Series ser1 = new XYChart.Series();
        ser1.setName("Red");
        ser1.getData().add(new XYChart.Data(eins, redprozent));

        XYChart.Series ser2 = new XYChart.Series();
        ser2.setName("Green");
        ser2.getData().add(new XYChart.Data(eins, greenprozent));

        XYChart.Series ser3 = new XYChart.Series();
        ser3.setName("Refactor");
        ser3.getData().add(new XYChart.Data(eins, refacprozent));

        Scene scene  = new Scene(values,800,600);
        values.getData().addAll(ser1, ser2, ser3);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}