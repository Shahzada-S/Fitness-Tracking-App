import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;


public class Flow extends Application {
    
    @Override
    public void start(Stage primaryStage)   {
        FlowPane pane = new FlowPane();
        pane.setHgap(5);
        pane.setVgap(5);
        Image javap = new Image("java.png");
        Image swiftp = new Image("swift.png");
        Image cpp = new Image("cpp.png");
        
        ImageView j1 = new ImageView(javap);
        ImageView s1 = new ImageView(swiftp);
        ImageView c1 = new ImageView(cpp);
        
        
        Label swift = new Label("Swift");
        swift.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));
        
        Label c = new Label("C++");
        c.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));

        Label java = new Label("Java");
        java.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));
        
        pane.getChildren().add(swift);
        pane.getChildren().add(new ImageView(swiftp));
        pane.getChildren().add(c);
        pane.getChildren().add(new ImageView(cpp));
        pane.getChildren().add(java);
        pane.getChildren().add(new ImageView(javap));
        
        
        Scene scene = new Scene(pane, 380, 100);
        primaryStage.setTitle("Programming Languages");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
    public static void main(String[] args)  {
        Application.launch(args);
    }
    
}
