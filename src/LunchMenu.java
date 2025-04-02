import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class LunchMenu extends Application {
    private double drink;
    private double food;
    double lunch = food + drink;
    private String[] foodOptions = {"Hot Dog", "Sandwhich", "Hamburger"};
    
    private ComboBox<String> combo = new ComboBox<>();
    Button submit = new Button("Submit");
    
    @Override
    public void start(Stage primaryStage)   {
        HBox paneForButtons = new HBox(40);
        paneForButtons.getChildren().add(submit);
        paneForButtons.setAlignment(Pos.CENTER);
        BorderPane pane = new BorderPane();
        pane.setBottom(paneForButtons);
            
        BorderPane pane1 = new BorderPane();
        VBox paneForRadioButtons = new VBox(20);
        paneForRadioButtons.setPadding(new Insets(5, 5, 5, 5));
        paneForRadioButtons.setPrefSize(100, 250);
        paneForRadioButtons.setStyle("--fx-border-color: green");
        
        Text drinkOption = new Text("Drink");
        RadioButton coffee = new RadioButton("Coffee");
        RadioButton tea = new RadioButton("Tea");
        RadioButton pop = new RadioButton("Pop");
        paneForRadioButtons.getChildren().addAll(drinkOption, coffee, tea, pop);
        pane.setLeft(paneForRadioButtons);
        
        ToggleGroup group = new ToggleGroup();
        coffee.setToggleGroup(group);
        tea.setToggleGroup(group);
        pop.setToggleGroup(group);
        
        coffee.setOnAction(e -> {
            if (coffee.isSelected())    {    
                drink = 3.5;
            }
        });
        tea.setOnAction(e -> {
            if (tea.isSelected())    {    
                drink = 5.5;
            }
        });
        pop.setOnAction(e -> {
            if (pop.isSelected())    {    
                drink = 2.5;
            }
        }); 
        
        BorderPane paneForDropDown = new BorderPane();
        paneForDropDown.setLeft(new Label("Select an item"));
        paneForDropDown.setLeft(combo);
        pane.setTop(paneForDropDown);
        combo.setPrefWidth(250);
        
        ObservableList<String> items = FXCollections.observableArrayList(foodOptions);
        combo.getItems().addAll(items);
        combo.setValue("Select an item");
    
        Text text = new Text(20, 20, "Total is $" + lunch);
        Pane paneForText = new Pane();
        paneForText.getChildren().add(text);
        pane.setCenter(paneForText);
       
        Scene scene = new Scene(pane, 300, 200);
        primaryStage.setTitle("Lunch Menu");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args)  {
        launch(args);
    }
    
}
