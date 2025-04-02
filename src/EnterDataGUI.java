
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class EnterDataGUI extends Application {
    Scanner scanner = new Scanner(System.in);
    TextArea grades = new TextArea();
    Label label = new Label("Enter the data");
    Button save = new Button("Save");
    BorderPane textArea = new BorderPane();
    BorderPane pane = new BorderPane();
    BorderPane title = new BorderPane();
    HBox paneForButton = new HBox(save);
    
    @Override
    public void start(Stage primaryStage) throws ClassNotFoundException, IOException {
        
        openWindow();

        Scene scene = new Scene(pane, 300, 150);
        primaryStage.setTitle("Save Data");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        try (DataOutputStream output = new DataOutputStream(new FileOutputStream("EnterData.dat"));)
        {
        save.setOnAction(eh -> {
            try {
                pane.setBottom(new Label("Your file has been saved"));
                
                String userInput = grades.getText();
                byte[] strings = userInput.getBytes();
                output.write(strings);
                output.writeUTF(userInput);
                output.writeInt(0);
                
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    } 
    }
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        Application.launch();
       
    }
    
    public void openWindow()  {
        paneForButton.setAlignment(Pos.CENTER);
        
        title.setLeft(label);
        
        pane.setBottom(paneForButton);
        pane.setTop(title);
        
        grades.setPrefColumnCount(22);
        grades.setPrefRowCount(5);
        textArea.setCenter(grades);
        pane.setCenter(grades);
    }
}
