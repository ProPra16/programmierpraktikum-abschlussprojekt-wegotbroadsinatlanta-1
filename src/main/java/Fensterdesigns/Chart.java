package Fensterdesigns;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class Chart extends Application {
    final static String eins = "1";
    final static String zwei = "2";
    final static String drei = "3";

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
        ser1.getData().add(new XYChart.Data(eins, 35.1));
        ser1.getData().add(new XYChart.Data(zwei, 40.0));
        ser1.getData().add(new XYChart.Data(drei, 20.0));

        XYChart.Series ser2 = new XYChart.Series();
        ser2.setName("Green");
        ser2.getData().add(new XYChart.Data(eins, 34.9));
        ser2.getData().add(new XYChart.Data(zwei, 20.0));
        ser2.getData().add(new XYChart.Data(drei, 20.0));

        XYChart.Series ser3 = new XYChart.Series();
        ser3.setName("Refactor");
        ser3.getData().add(new XYChart.Data(eins, 30.0));
        ser3.getData().add(new XYChart.Data(zwei, 40.0));
        ser3.getData().add(new XYChart.Data(drei, 60.0));

        Scene scene  = new Scene(values,800,600);
        values.getData().addAll(ser1, ser2, ser3);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}