import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class MovingBB8 extends Application {
        
    @Override // Override the start method in the Application class
	public void start(Stage primaryStage) { 

		BB8Pane pane = new BB8Pane();
                // Create a scene and place it in the stage
		Scene scene = new Scene(pane, 400, 120);
		primaryStage.setTitle("MovingBB8"); 
		primaryStage.setScene(scene); 
		primaryStage.show();
                
		pane.setOnKeyPressed(e -> { 
                    switch (e.getCode())    {
                        case LEFT: pane.moveLeft(); break;
                        case RIGHT: pane.moveRight();
                    }
		});
		pane.requestFocus();
	}
        public static void main(String[] args)  {
            Application.launch();
        }
} 

class BB8Pane extends Pane{

	private Circle circle1 = new Circle(200, 50, 15);
	private Circle circle2 = new Circle(200, 70, 20);
	private Line line = new Line(200, 25, 200, 35);

	public BB8Pane() {
		line.setStroke(Color.BLACK);
		circle1.setFill(Color.CORAL);
		circle2.setFill(Color.CORAL);

		getChildren().addAll(circle1, circle2, line);
	}

	public void moveLeft() {
            circle1.setCenterX(circle1.getCenterX() - 10);
            circle2.setCenterX(circle2.getCenterX() - 10);
            line.setEndX(line.getEndX() - 10);
            line.setStartX(line.getStartX() - 10);

	}

	public void moveRight() {
            circle1.setCenterX(circle1.getCenterX() + 10);
            circle2.setCenterX(circle2.getCenterX() + 10);
            line.setEndX(line.getEndX() + 10);
            line.setStartX(line.getStartX() + 10);
	}
}

