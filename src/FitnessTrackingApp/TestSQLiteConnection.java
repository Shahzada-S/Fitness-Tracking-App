package FitnessTrackingApp;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestSQLiteConnection {
    public static void main(String[] args) {
        try {
            // Path to your SQLite database file
            String url = "jdbc:sqlite:resources/fitness.db";

            // Establish connection
            Connection connection = DriverManager.getConnection(url);
            System.out.println("Connection successful!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

