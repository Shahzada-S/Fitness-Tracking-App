import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

public class RacingCar extends Application{
    private Button resume = new Button("Resume");
    private Button pause = new Button("Pause");

    @Override
    public void start(Stage primaryStage)   { 
        raceCar pane = new raceCar();
        Timeline time = new Timeline(new KeyFrame(Duration.millis(300), eh -> pane.driving(1)));
        time.setCycleCount(pane.length());
        time.play();
        time.setOnFinished(eh -> {
            time.play();
        });
        
        HBox options = new HBox();
        options.getChildren().add(resume);
        options.getChildren().add(pause);
        options.setAlignment(Pos.CENTER);
        
        HBox button = new HBox(pause, resume);
        button.setAlignment(Pos.CENTER);
        BorderPane Bpane = new BorderPane(pane, null, null, button, null);
        
        Scene scene = new Scene(Bpane, 700, 100);
        primaryStage.setTitle("Exercise15_29");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        pause.setOnAction(eh -> time.pause());
        resume.setOnAction(eh -> time.play());
        
        Bpane.setOnKeyPressed(eh -> {
            switch(eh.getCode())    {
                case UP: time.setRate(time.getCurrentRate() + 1); break;
                case DOWN: time.setRate(time.getCurrentRate() - 2); 
            }
        });
        pane.requestFocus();
    }
    public static void main(String[] args)  {
        launch();
    }
}
    class raceCar extends Pane {
        Circle wheelL = new Circle(15, 65, 5);
        Circle wheelR = new Circle(35, 65, 5);
        Rectangle body = new Rectangle(0, 50, 50, 10);
        Rectangle top = new Rectangle(10, 40, 30, 10); 
        
        raceCar()   {
            wheelL.setFill(Color.BLACK);
            wheelR.setFill(Color.BLACK);
            body.setFill(Color.SKYBLUE);
            body.setStroke(Color.BLACK);
            top.setFill(Color.DEEPSKYBLUE);
            top.setStroke(Color.BLACK);
            
            getChildren().addAll(wheelL, wheelR, body, top);
        }
        public void driving(double speed)   {
            speed = 5;
            wheelL.setCenterX(wheelL.getCenterX() + speed);
            wheelR.setCenterX(wheelR.getCenterX() + speed);
            body.setX(body.getX() + speed);
            top.setX(top.getX() + speed);
        } 
        public int length()  {
            return 700;
        }
    }
