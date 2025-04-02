import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*; 
import javafx.stage.Stage;

public class Calculator extends Application {
    private TextField tfFirstOp = new TextField();
    private TextField tfSecOp = new TextField();
    private TextField tfResult = new TextField();
    private Button add = new Button("Add");
    private Button subtract = new Button("Subtract");
    private Button clear = new Button("Clear");
    
    @Override
    public void start(Stage primaryStage)   {
        GridPane pane = new GridPane();
        pane.setHgap(10);
        pane.setVgap(10);
        
        pane.add(new Label("First Operand"), 0, 0);
        pane.add((tfFirstOp), 1, 0);    
        
        pane.add(new Label("Second Operand"), 0, 1);
        pane.add((tfSecOp), 1, 1);
        
        pane.add(new Label("Result"), 0, 2);
        pane.add((tfResult), 1, 2);
        pane.add(add, 0, 3);
        pane.add(subtract, 1, 3);
        pane.add(clear, 2, 3);
        
        
        pane.setAlignment(Pos.CENTER);
        tfFirstOp.setAlignment(Pos.CENTER_RIGHT);
        
        tfSecOp.setAlignment(Pos.CENTER_RIGHT);
        tfResult.setAlignment(Pos.CENTER_RIGHT);
        
        add.setOnAction(eh -> calculateAdd());
        subtract.setOnAction(eh -> calculateSubtract());
        clear.setOnAction(eh -> calculateClear());

        Scene scene = new Scene(pane, 350, 200);
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
                
    }
    private void calculateAdd()  {
        double first = Double.parseDouble(tfFirstOp.getText());
        double second = Double.parseDouble(tfSecOp.getText());
        tfResult.setText(String.format("%.2f", first + second));
        
    }
    private void calculateSubtract() {
        double first = Double.parseDouble(tfFirstOp.getText());
        double second = Double.parseDouble(tfSecOp.getText());
        tfResult.setText(String.format("%.2f", first - second));
        
    }
    private void calculateClear()   {
        tfFirstOp.clear();
        tfSecOp.clear();
        tfResult.clear();
    }
    
    public static void main(String[] args)  {
        Application.launch();
    }
}
