import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class MoveBall extends Application {
    @Override
    public void start(Stage primaryStage)   {
        //create pane
        Ball pane = new Ball();
        
        // create scene and display the scene on the primary stage 
        Scene scene = new Scene(pane, 300.5, 300);
        primaryStage.setTitle("Exercise15_03");
        primaryStage.setScene(scene);
        primaryStage.show();
        
       // set the appropriate key pressed to initiate the specific method to move the ball
        pane.setOnKeyPressed(eh -> {
            switch (eh.getCode())   {
                case UP: pane.moveUP(); break;
                case DOWN: pane.moveDOWN(); break;
                case LEFT: pane.moveLEFT(); break;
                case RIGHT: pane.moveRIGHT(); 
            }  
        });
        pane.requestFocus();
    }
    
    public static void main(String[] args)  {
        launch();
    }
}
class Ball extends Pane {
   //create ball from Circle object with parameters: centerX, centerY, radius
        Circle ball = new Circle(150, 150, 20);
        
        // create no arg constructor for Ball and set specifications
        Ball()  {
        //ball.setRadius(15);
        ball.setStroke(Color.BLACK);
        ball.setFill(Color.WHITE);
        
        //position the ball in the center of the scene
        ball.setCenterX(150);
        ball.setCenterY(150);
        
        //add ball to pane
        getChildren().add(ball);
        }
    
    //method to move ball up and attempt to catch out of bounds exception if exceeding y coordinates
    public void moveUP() {
        try {
            if (ball.getCenterY() - ball.getRadius() - 10 < 0)   {
            throw new OutOfBoundsException();
            }
            ball.setCenterY(ball.getCenterY() - 10);
        }
        catch (OutOfBoundsException ex) {
            System.out.println("You are moving the ball out of bounds.");
        }
    }
    //method to move ball down and attempt to catch out of bounds exception if exceeding y coordinates
    public void moveDOWN()  {
        try {
            if(ball.getCenterY() - ball.getRadius() + 10 > 260) {
                throw new OutOfBoundsException();
            }
        ball.setCenterY(ball.getCenterY() + 10);
        }
        catch (OutOfBoundsException ex) {
            System.out.println("You are moving the ball out of bounds");
        }
    }
    //method to move ball left and attempt to catch out of bounds exception if exceeding x coordinates
    public void moveLEFT()  {
        try {
            if (ball.getCenterX() - ball.getRadius() - 10 < 0)  {
                throw new OutOfBoundsException();
            }
        ball.setCenterX(ball.getCenterX() - 10);
        }
        catch (OutOfBoundsException ex) {
            System.out.println("You are moving the ball out of bounds.");
        }
    }
    //method to move ball right and attempt to catch out of bounds exception if exceeding x coordinates
    public void moveRIGHT() {
        try {
            if (ball.getCenterX() - ball.getRadius() + 10 > 260)    {
                throw new OutOfBoundsException();
            }
        ball.setCenterX(ball.getCenterX() + 10);
        }
        catch (OutOfBoundsException ex) {
            System.out.println("You are moving the ball out of bounds.");
        }
        
    }
}















