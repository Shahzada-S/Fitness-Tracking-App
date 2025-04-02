
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RadioButtons extends SubmitButton {
    double drink = 0;
    /* @Override
    public void start(Stage primaryStage)   {
        HBox paneForButtons = new HBox(20);
        BorderPane pane = new BorderPane();
        
        Scene scene = new Scene(pane, 200, 200);
        primaryStage.setTitle("Lunch Menu");
        primaryStage.setScene(scene);
        primaryStage.show();
    } */
    
    @Override
    protected BorderPane getPane()  {
        //HBox paneForButtons = new HBox(20);
        BorderPane pane = super.getPane();
        VBox paneForRadioButtons = new VBox(20);
        paneForRadioButtons.setPadding(new Insets(5, 5, 5, 5));
        //paneForRadioButtons.setStyle("-fx−border−color: green");
        paneForRadioButtons.setPrefSize(100, 250);
        //Button submit = new Button("Submit");
        //paneForRadioButtons.getChildren().add(submit);
        //paneForRadioButtons.setAlignment(Pos.CENTER);  
        paneForRadioButtons.setStyle("--fx-border-color: green");
        
        //pane.setBottom(paneForButtons);
        //submit.setOnAction(e -> text.( drink + food));
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
        
        /*Text text = new Text(20, 20, "Total is $" + drink);
        Pane paneForText = new Pane();
        paneForText.getChildren().add(text);
        pane.setCenter(paneForText); */

        return pane;
    }
    
}
