
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.DoubleProperty;


public class MainFX {
    public static void main(String[] args) {
        DoubleProperty d1 = new SimpleDoubleProperty(1);
        DoubleProperty d2 = new SimpleDoubleProperty(2);
        d1.bindBidirectional(d2);
        
        System.out.println("d1 is " + d1.getValue());
        d1.setValue(30);
        System.out.println("d1 is " + d1.getValue());
        System.out.println("d2 is " + d2.getValue());
        
        // both d1 and d2 are now indistinguishable since binded bidirectional
    }
    
}
