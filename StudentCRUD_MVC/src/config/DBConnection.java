package config; // Package holding database configuration classes

// ============================================================================
// IMPORTS: Required JDBC classes for connecting to the MySQL database
// ============================================================================
import java.sql.Connection;    // Represents an active connection to the database
import java.sql.DriverManager; // Manages JDBC drivers and establishes connections
import java.sql.SQLException;  // Handles database access errors and exceptions

/**
 * DBConnection Class
 * Provides a reusable method to connect to the MySQL database.
 */
public class DBConnection {

    // ========================================================================
    // GROUP 1: Database Connection Constants
    // Define the MySQL server URL, database username, and password in one place.
    // ========================================================================
    private static final String URL = "jdbc:mysql://localhost:3306/dbstudent"; // JDBC URL pointing to local MySQL and 'student_db'
    private static final String USER = "root";                                  // Default MySQL username (change if different)
    private static final String PASSWORD = "";                                  // Default MySQL password (empty on XAMPP/WAMP by default)

    // ========================================================================
    // GROUP 2: Connection Factory Method
    // Loads the MySQL JDBC driver and returns an active Connection object.
    // ========================================================================
    public static Connection getConnection() {
        Connection conn = null; // Initialize the connection variable as null
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");                  // Load the MySQL Connector/J 8+ JDBC driver class
            conn = DriverManager.getConnection(URL, USER, PASSWORD);    // Open a connection to MySQL using our credentials
        } catch (ClassNotFoundException e) {                            // Catch error if the MySQL Connector JAR is missing from Libraries
            System.err.println("MySQL JDBC Driver not found: " + e.getMessage()); // Print driver error details to the console
        } catch (SQLException e) {                                      // Catch error if MySQL is not running or credentials fail
            System.err.println("Database Connection Failed: " + e.getMessage());  // Print SQL connection error details to the console
        }
        return conn; // Return the active Connection object (or null if it failed)
    }
}
