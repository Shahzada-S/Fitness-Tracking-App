import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class AdjustingPosition extends Application {
    Image grape = new Image("grapes.png");
    ImageView grapes = new ImageView(grape);
    TextField gap = new TextField();
    Label graphicTextGap = new Label("graphicTextGap:  ", gap);
    Label label = new Label("Grapes", grapes);
    String[] side = {"LEFT", "RIGHT", "UP", "DOWN"};
    ComboBox<String> side1 = new ComboBox<>();
    Label contentDisplay = new Label("contentDisplay:  ", side1);
    HBox options = new HBox(contentDisplay, graphicTextGap);
    StackPane pane1 = new StackPane(label);
    BorderPane pane = new BorderPane(pane1);
    
    @Override
    public void start(Stage primaryStage)   {
        side1.getItems().addAll(side);
        side1.setValue("LEFT");
        pane.setTop(options);
        graphicTextGap.setContentDisplay(ContentDisplay.RIGHT);
        contentDisplay.setContentDisplay(ContentDisplay.RIGHT);
        gap.setPrefColumnCount(2);
        
        side1.setOnAction(eh -> {
            adjust(side1.getValue());
        });
        
        gap.setOnAction(eh -> {
            label.setGraphicTextGap(Double.parseDouble(gap.getText()));
        });
        
        Scene scene = new Scene(pane, 450, 500);
        primaryStage.setTitle("Set Properties");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args)  {
        launch();
    }
    public void adjust(String position) {
        switch (position)   {
            case "LEFT": label.setContentDisplay(ContentDisplay.LEFT); break;
            case "RIGHT": label.setContentDisplay(ContentDisplay.RIGHT); break;
            case "UP": label.setContentDisplay(ContentDisplay.TOP); break;
            case "DOWN": label.setContentDisplay(ContentDisplay.BOTTOM);
        }
}
}
