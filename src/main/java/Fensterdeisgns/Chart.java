import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class Chart extends Application {
    final static String red = "Red";
    final static String green = "Green";
    final static String refactory = "Refactory";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
            barchart(stage);
    }

    public void barchart(Stage stage){

        stage.setTitle("Auswertung der Entwicklung");
        final CategoryAxis bereich = new CategoryAxis();
        final NumberAxis prozent = new NumberAxis();
        final BarChart<String,Number> bc =
                new BarChart<String,Number>(bereich, prozent);
        bc.setTitle("Einteilung der Zeit und die Anzahl der Wechsel für den jeweiligen Bereich");
        bereich.setLabel("Bereich");
        prozent.setLabel("Prozent");

        Scene scene  = new Scene(bc,800,600);
      //  bc.getData().addAll(schritt1, schritt2, schritt3);
        stage.setScene(scene);
        stage.show();
    }
}