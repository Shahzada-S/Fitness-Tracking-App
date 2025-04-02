import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*; // stacks panes as apposed to Pane
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.text.*; // for Font
import javafx.geometry.Insets;
import javafx.scene.image.*;



/* public class MyJavaFX extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        Button btOK = new Button("OK");
        btOK.setStyle("-fx-border-color: blue;");
        CheckBox A = new CheckBox("YES");
        Circle circle = new Circle();
        StackPane pane = new StackPane();
        
        Color c = new Color(.30, 0.25, 0.89, 0.5);
        Font font1 = new Font("Times New Roman", 80);

        
        circle.centerXProperty().bind(pane.widthProperty().divide(2));
        circle.centerYProperty().bind(pane.heightProperty().divide(2));
        circle.setRadius(60);
        circle.setStroke(Color.BLACK);
        circle.setFill(c);

        
        Label label = new Label("JavaFX");
        label.setFont(font1);
        pane.getChildren().add(label);

        //pane.getChildren().add(A);
        //pane.getChildren().add(New Button("OK"));
        //pane.getChildren().add(btOK);
        pane.setRotate(45);
        pane.setStyle("-fx-border-color: red; -fx-background-color: lightgray;");
        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("New Window");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        // _____________________________
        
        new Image("image.eth.png");
        new Image("bc.jpeg");
        new Image("tron.webp");
        new Image("cd.webp");

        
        
        
    } 
    
    public static void main(String[] args) {
        Application.launch(args);

    } 
    
} */

