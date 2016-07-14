package Fensterdesigns;

import javafx.application.Application;
import java.util.Arrays;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis; import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Chart2 extends Application {

    private void init(Stage primaryStage) {

        HBox root = new HBox();
        primaryStage.setScene(new Scene(root));
        TextArea text = new TextArea ("");
        root.getChildren().addAll(Chart(text),text);
    }

        BarChart<String, Number> Chart(final TextArea text) {

        final String[] bereich = {"Red", "Green", "Refactor"};
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();

            final BarChart<String,Number> values = new BarChart<String,Number>(xAxis,yAxis);

        values.setTitle("Einteilung der Zeit pro Bereich");

        xAxis.setCategories(FXCollections.<String>observableArrayList(Arrays.asList(bereich)));
        yAxis.setLabel("Number of individual statistics");

        final XYChart.Series<String,Number> series1 = new XYChart.Series<String,Number>();
        series1.setName("Red");
        final XYChart.Series<String,Number> series2 = new XYChart.Series<String,Number>();
        series2.setName("Green");
        final XYChart.Series<String,Number> series3 = new XYChart.Series<String,Number>();
        series3.setName("Refactor");

        Timeline Updater = new Timeline(new KeyFrame(Duration.seconds(5), new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event) {
                series1.getData().clear();
                text.clear();

                int s1 = 3;

                int s2 = 4;

                int s3 = 5;

                if(s1 == 0 ){
                    s1 = 1;
                }
                if(s2 == 0 ){
                    s2 = 1;
                }
                if(s3 == 0 ){
                    s3 = 1;
                }
                text.appendText("Green : "+String.valueOf(s1));
                text.appendText("\nRed : "+String.valueOf(s2));
                text.appendText("\nRefactor : "+String.valueOf(s3));

                series1.getData().add(new XYChart.Data<String,Number>(bereich[0], s1));
                series1.getData().add(new XYChart.Data<String,Number>(bereich[1], s2));
                series1.getData().add(new XYChart.Data<String,Number>(bereich[2], s3));
            }
        }));

        Updater.setCycleCount(Timeline.INDEFINITE);
        Updater.play();
        values.getData().add(series1);
        return values;
    }

    @Override public void start(Stage primaryStage) throws Exception {
        init(primaryStage);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
