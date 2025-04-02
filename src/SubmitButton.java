
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class SubmitButton extends Application {
    //protected Text text = new Text(20, 20, "Total is $" + drink);
    
    protected BorderPane getPane()    {
        
    HBox paneForButtons = new HBox(40);
    Button submit = new Button("Submit");
    paneForButtons.getChildren().add(submit);
    paneForButtons.setAlignment(Pos.CENTER);
    BorderPane pane = new BorderPane();
    pane.setBottom(paneForButtons);
    submit.setOnAction(eh -> calculateLunch());
    
    /* Pane paneForText = new Pane();
    paneForText.getChildren().add(text);
    pane.setCenter(paneForText); */
    
    return pane;
}
    
    @Override
    public void start(Stage primaryStage)   {
        Scene scene = new Scene(getPane(), 300, 200);
        primaryStage.setTitle("Lunch Menu");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    /*public static void main(String[] args)  {
        launch();
    } */
     private void calculateLunch()   {
         double hamB = 10;
         double hot = 5;
         double sand = 8;
         double T = 5.50;
         double P = 3;
         double coff = 3.5;
         
             
        
    }
    
}
