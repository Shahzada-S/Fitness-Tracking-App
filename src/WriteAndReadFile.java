import java.lang.ClassNotFoundException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class WriteAndReadFile {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
    
        int[] numbers = {1, 2, 3, 4, 5};
        double d = 2.5;
        
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("file1.dat", true));) {
            output.writeObject(numbers);
            output.writeObject(d);
            output.writeObject(new java.util.Date());
        }
        
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("file1.dat"));) {
            int[] array = (int[])(input.readObject());
            
            System.out.println(new java.util.Date());
            
            for (int i = 0; i < array.length; i++)    
            System.out.print(array[i] + " ");
            
            System.out.println();
            System.out.println(d);
            
        }
    }
}

