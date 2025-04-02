
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Cylinder;

public class Slider extends Application {
    
    
    ScrollBar red = new ScrollBar();
    ScrollBar green = new ScrollBar();
    ScrollBar blue = new ScrollBar();
    ScrollBar opac = new ScrollBar();
    Text text = new Text("Show Colors");
    
    Pane paneForText = new Pane();
    GridPane paneG = new GridPane();
    StackPane paneS = new StackPane(text);
    BorderPane paneB = new BorderPane(paneS);
    Label redC = new Label("Red");
    Label greenC = new Label("Green");
    Label blueC = new Label("Blue");
    Label opacity = new Label("Opacity");
    
    @Override
    public void start(Stage primaryStage)   {
        paneForText.getChildren().add(text);
        paneB.setCenter(paneG);
        paneG.add(text, 1, 0);
        
        paneG.add(redC, 0, 1);
        paneG.add(red, 1, 1);
        paneG.add(greenC, 0, 2);
        paneG.add(green, 1, 2);
        paneG.add(blueC, 0, 3);
        paneG.add(blue, 1, 3);
        paneG.add(opacity, 0, 4);
        paneG.add(opac, 1, 4);
        paneG.setAlignment(Pos.CENTER);
        paneG.setVgap(5);
        paneG.setHgap(15);
        
        red.setMax(255);
        red.setMin(0);
        red.valueProperty().addListener(ov -> text.setFill(getColor()));
        
        green.setMax(255);
        green.setMin(0);
        green.valueProperty().addListener(ov -> text.setFill(getColor()));
        
        blue.setMax(255);
        blue.setMin(0);
        blue.valueProperty().addListener(ov -> text.setFill(getColor()));
        
        opac.setMax(1);
        opac.setMin(0);
        opac.setValue(1);
        opac.valueProperty().addListener(ov -> text.setFill(getColor()));
        
        Scene scene = new Scene(paneB, 230, 130);
        primaryStage.setTitle("Color Slider");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args)  {
        launch();
        
    }
    public Color getColor() {
        double redV = red.getValue();
        double greenV = green.getValue();
        double blueV = blue.getValue();
        double opacV = opac.getValue();

        return Color.rgb((int)redV, (int)greenV, (int)blueV, opacV);
    }
}


// FlowPlane - arranges nodes in the plane horizontally or vertically
// GridPanes - arranges nodes in a grid formation, row and column indices
// BorderPane - arranges nodes in 5 regions, top bottom left right center
