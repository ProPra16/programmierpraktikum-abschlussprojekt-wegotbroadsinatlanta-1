package Fensterdesigns;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

//Inspiriert durch Quelle:  http://docs.oracle.com/javafx/2/charts/bar-chart.htm#CIHJFHDE

public class Chart {
    static double redprozent;
    static double greenprozent;
    static double refacprozent;
    final static String bereich = "";

    public static void getchart(double red, double green, double refac) {
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
    }
}