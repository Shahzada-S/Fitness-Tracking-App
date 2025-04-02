import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class AddPoint extends Application{
    Pane pane = new Pane();
    
    @Override
    public void start(Stage primaryStage)   {
        pane.setOnMouseClicked(eh -> {
            double x = eh.getX();
            double y = eh.getY();
            if (eh.getButton() == MouseButton.PRIMARY)  {
                Circle point = addPoint(x,y);
                pane.getChildren().add(point);
            }
            else if (eh.getButton() == MouseButton.SECONDARY)  
            erasePoint(x, y);
        });
        Scene scene = new Scene(pane, 350, 150);
        primaryStage.setTitle("Exercise15_15");
        primaryStage.setScene(scene);
        primaryStage.show();  
    }

    public static void main(String[] args)  {
        Application.launch(args);
    }
    public Circle addPoint(double x, double y)  {
        Circle point = new Circle(x, y, 5);
        point.setFill(Color.WHITE);
        point.setStroke(Color.BLACK);
        return point;
    }
    public void erasePoint(double x, double y)  {
        ObservableList<Node> p = pane.getChildren();
        for (int i = p.size() - 1; i >= 0; i--)  {
            Node point = p.get(i);
            if (point instanceof Circle && point.contains(x, y))     
            pane.getChildren().remove(point);
        }
    }
}
