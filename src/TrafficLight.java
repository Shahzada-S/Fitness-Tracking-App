
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ToggleGroup;

public class TrafficLight extends Application {
    BorderPane pane = new BorderPane();
    Circle top = new Circle(150, 50, 10);
    Circle middle = new Circle(150, 80, 10);
    Circle bottom = new Circle(150, 110, 10);
    Rectangle frame = new Rectangle(130, 30, 40, 105);
    VBox paneForColors = new VBox();
    ToggleGroup group = new ToggleGroup();
    
    @Override
    public void start(Stage primaryStage)   {
        
        openWindow();
        
        Scene scene = new Scene(pane, 300, 200);
        primaryStage.setTitle("Traffic Lights");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args)  {
        launch();
    }
    public void openWindow()    {
        frame.setFill(Color.WHITE);
        frame.setStroke(Color.BLACK);
        top.setFill(Color.WHITE);
        top.setStroke(Color.BLACK);
        middle.setFill(Color.WHITE);
        middle.setStroke(Color.BLACK);
        bottom.setFill(Color.WHITE);
        bottom.setStroke(Color.BLACK);
        
        RadioButton red = new RadioButton("Red");
        RadioButton yellow = new RadioButton("Yellow");
        RadioButton green = new RadioButton("Green");
        paneForColors.setPadding(new Insets(5, 5, 5, 5));
        paneForColors.setAlignment(Pos.CENTER);
        red.setToggleGroup(group);
        yellow.setToggleGroup(group);
        green.setToggleGroup(group);

        red.setOnAction(eh -> {
            top.setFill(Color.RED);
            middle.setFill(Color.WHITE);
            bottom.setFill(Color.WHITE);
        });
        yellow.setOnAction(eh -> {
            top.setFill(Color.WHITE);
            middle.setFill(Color.YELLOW);
            bottom.setFill(Color.WHITE);
        });
        green.setOnAction(eh -> {
            top.setFill(Color.WHITE);
            middle.setFill(Color.WHITE);
            bottom.setFill(Color.GREEN);
        });
        
        paneForColors.getChildren().addAll(red, yellow, green);
        pane.setBottom(paneForColors);
        
        pane.getChildren().addAll(frame, top, middle, bottom);
    }
}
