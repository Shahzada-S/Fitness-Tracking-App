import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FourPictures extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane pane = new GridPane();
        Image pic1 = new Image("pic0.jpeg");
        Image pic2 = new Image("pic1.jpeg");
        Image pic3 = new Image("pic2.jpeg");
        Image pic4 = new Image("pic3.jpeg");
        
        ImageView view1 = new ImageView(pic1);
        ImageView view2 = new ImageView(pic2);
        ImageView view3 = new ImageView(pic3);
        ImageView view4 = new ImageView(pic4); 

        pane.add(view1, 1, 1);
        pane.add(view2, 1, 2);
        pane.add(view3, 2, 1);
        pane.add(view4, 2, 2);

        
        Scene scene = new Scene(pane, 1000, 650);
        primaryStage.setTitle("Four Images");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
    public static void main(String[] args)  {
        Application.launch(args);
    }
    
    
}
