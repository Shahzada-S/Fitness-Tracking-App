import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FourFans extends Application {
   @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane pane = new GridPane();
        Image pic1 = new Image("pic1.jpeg");
        
        ImageView view1 = new ImageView(pic1);

        pane.add(new ImageView(pic1), 1, 1);
        pane.add(new ImageView(pic1), 1, 2);
        pane.add(new ImageView(pic1), 2, 1);
        pane.add(new ImageView(pic1), 2, 2);
        
        Scene scene = new Scene(pane, 1100, 750);
        primaryStage.setTitle("Four 'Fans'");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args)  {
        Application.launch(args);
    }
    
}
