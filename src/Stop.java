import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Polygon;
import javafx.scene.text.*;


public class Stop extends Application {
    private double radius = 500 * 0.4;
           
    @Override
    public void start(Stage primaryStage) {
        
        StackPane pane = new StackPane();
        Polygon octo = new Polygon();
        octo.setStroke(Color.BLACK);
        octo.setFill(Color.RED);
        ObservableList<Double> list = octo.getPoints();
        for (int i = 0; i < 8; i++) {
            list.add(500 + radius * Math.cos(Math.toRadians(i * 45 + 45/2)));
            list.add(500 - radius * Math.sin(Math.toRadians(i * 45 + 45/2)));
        }
       
        Label stop = new Label("STOP");
        stop.setFont(Font.font("Times new Roman", 100));
        stop.setTextFill(Color.WHITE);
        
        pane.getChildren().add(octo);
        pane.getChildren().add(stop);
        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Stop Sign");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args)  {
        Application.launch(args);
    }
}
