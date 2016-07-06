package Fensterdesigns;

/*
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class Chart extends Application {
    String red = "Schritt 1";
    String green = "Schritt 2";
    String refactory = "Schritt 3";


    ////////////////////////////////////////////77TEST_AUFÜHRUNG
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
            barchart(stage);
    }
    ///////////////////////////////////////////TEST-AUSFÜHRUNG
    public void barchart(Stage stage){

        //Array als Parameter
        //Schritte automatisieren


        stage.setTitle("Auswertung der Entwicklung");

        CategoryAxis bereich = new CategoryAxis();
        NumberAxis prozent = new NumberAxis();

        BarChart<String,Number> information = new BarChart<String,Number>(bereich, prozent);
        information.setTitle("Einteilung der Zeit und die Anzahl der Wechsel für den jeweiligen Bereich");
        bereich.setLabel("Bereich");
        prozent.setLabel("Prozent");

         XYChart.Series schritt1 = new XYChart.Series();
        schritt1.setName("Red");
        schritt1.getData().add(new XYChart.Data(red, 20));
        schritt1.getData().add(new XYChart.Data(green, 20));
        schritt1.getData().add(new XYChart.Data(refactory, 60));

        XYChart.Series schritt2 = new XYChart.Series();
        schritt2.setName("Green");
        schritt2.getData().add(new XYChart.Data(red, 40));
        schritt2.getData().add(new XYChart.Data(green, 10));
        schritt2.getData().add(new XYChart.Data(refactory, 50));

        XYChart.Series schritt3 = new XYChart.Series();
        schritt3.setName("Refactory");
        schritt3.getData().add(new XYChart.Data(red, 30));
        schritt3.getData().add(new XYChart.Data(green, 35));
        schritt3.getData().add(new XYChart.Data(refactory, 35));
////////////////////////////////////////////////////////////////////////////////////

            for(int i = 0; i<array.length; i++){
                XYChart.Series Schritt+i =+ add
        }
        Scene scene  = new Scene(information,800,600);
        information.getData().addAll(schritt1, schritt2, schritt3);
        stage.setScene(scene);
        stage.show();
    }
}*/

import java.util.Arrays;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class Chart extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();

        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();

        xAxis.setLabel("Schritt");
        xAxis.setCategories(FXCollections.<String> observableArrayList(Arrays.asList(
                "1",
                "2",
                "3")));
        yAxis.setLabel("Value");

        final StackedBarChart<String,Number> stackedBarChart = new StackedBarChart<String,Number>(xAxis,yAxis);
        stackedBarChart.setTitle("StackedBarChart");

        XYChart.Series<String,Number> series1 = new XYChart.Series();
        series1.setName("Green");

        series1.getData().add(new XYChart.Data("Red", 20));
        series1.getData().add(new XYChart.Data("Green", 30));
        series1.getData().add(new XYChart.Data("Refactory", 50));

        XYChart.Series<String,Number> series2 = new XYChart.Series();
        series2.setName("Red");

    }
}