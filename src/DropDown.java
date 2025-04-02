import javafx.application.Application;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class DropDown extends RadioButtons {
    private String[] foodOptions = {"Hot Dog", "Sandwhich", "Hamburger"};
    double food = 0;
    private ComboBox<String> combo = new ComboBox<>();
    
  
    
     @Override
    public void start(Stage primaryStage)   {
        Scene scene = new Scene(getPane(), 300, 200);
        primaryStage.setTitle("Lunch Menu");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    @Override
    protected BorderPane getPane()   {
        BorderPane pane = super.getPane();
        BorderPane paneForDropDown = new BorderPane();
        paneForDropDown.setLeft(new Label("Select an item"));
        paneForDropDown.setLeft(combo);
        pane.setTop(paneForDropDown);
        combo.setPrefWidth(250);
        
        ObservableList<String> items = FXCollections.observableArrayList(foodOptions);
        combo.getItems().addAll(items);
        combo.setValue("Select an item");
        //pane.setCenter(descriptionPane);
    
        Text text = new Text(20, 20, "Total is $" + drink);
        Pane paneForText = new Pane();
        paneForText.getChildren().add(text);
        pane.setCenter(paneForText);
        
        combo.setOnAction(eh -> calculateLunch());
        
        return pane;
    }
    public static void main(String[] args)  {
        launch(args);
    }
    
    private void calculateLunch()   {
        
        
    }
    
}