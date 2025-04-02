import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*; 
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Polygon;

public class SmileyFace extends Application {
    
    @Override
    public void start(Stage primaryStage)   {
        Pane pane = new Pane();
        
        Circle face = new Circle();
        face.setCenterX(200);
        face.setCenterY(200);
        face.setRadius(150);
        face.setStroke(Color.BLACK);
        face.setFill(Color.WHITE);
        
        Circle eyeLeft = new Circle();
        eyeLeft.setCenterX(130);
        eyeLeft.setCenterY(150);
        eyeLeft.setRadius(27);
        eyeLeft.setStroke(Color.BLACK);
        eyeLeft.setFill(Color.WHITE);
        
        Circle eyeLeft1 = new Circle();
        eyeLeft1.setCenterX(130);
        eyeLeft1.setCenterY(150);
        eyeLeft1.setRadius(15);
        eyeLeft1.setFill(Color.BLACK);
        eyeLeft1.setStroke(Color.BLACK);
        
        Circle eyeRight = new Circle();
        eyeRight.setCenterX(270);
        eyeRight.setCenterY(150);
        eyeRight.setRadius(27);
        eyeRight.setStroke(Color.BLACK);
        eyeRight.setFill(Color.WHITE);
        
        Circle eyeRight1 = new Circle();
        eyeRight1.setCenterX(270);
        eyeRight1.setCenterY(150);
        eyeRight1.setRadius(15);
        eyeRight1.setStroke(Color.BLACK);
        eyeRight1.setFill(Color.BLACK);
        
        Polygon nose = new Polygon();
        nose.getPoints().setAll(200.0, 170.0, 165.0, 235.0, 235.0, 235.0);
        nose.setFill(Color.WHITE);
        nose.setStroke(Color.BLACK);
        
        Arc mouth = new Arc(200, 230, 90, 60, -150, 130);
        mouth.setStroke(Color.BLACK);
        mouth.setFill(Color.WHITE);
        mouth.setStroke(Color.BLACK);
        mouth.setType(ArcType.OPEN);
    
        pane.getChildren().addAll(face, nose, eyeLeft, eyeLeft1, eyeRight, eyeRight1, mouth);
        Scene scene = new Scene(pane, 400, 400);
        primaryStage.setTitle("Smiley Face");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args)  {
        Application.launch(args);
    }
}
    
    
