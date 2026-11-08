package model; // Part of the Model layer responsible for database queries

// ============================================================================
// IMPORTS: Required SQL and Collection classes for database CRUD operations
// ============================================================================
import config.DBConnection;          // Imports our custom database connection helper
import java.sql.Connection;          // Represents the active database connection
import java.sql.PreparedStatement;   // Executes parameterized SQL queries safely (prevents SQL injection)
import java.sql.ResultSet;           // Holds the table rows returned from a SELECT query
import java.sql.SQLException;        // Handles SQL database errors
import java.util.ArrayList;          // Resizable array implementation for storing Student objects
import java.util.List;               // Interface for returning a list of Student records

/**
 * StudentDAO Class (Model Layer - Data Access Object)
 * Handles all MySQL CRUD (Create, Read, Update, Delete) queries for the Student model.
 */
public class StudentDAO {

    // ========================================================================
    // GROUP 1: CREATE Operation (Insert a new student into MySQL)
    // Takes a Student object and saves its name, course, and email to the table.
    // ========================================================================
    public boolean addStudent(Student student) {
        String sql = "INSERT INTO students (name, course, email) VALUES (?, ?, ?)"; // SQL INSERT query with 3 parameter placeholders
        try (Connection conn = DBConnection.getConnection();                        // Open connection (auto-closes after try block)
             PreparedStatement pst = conn.prepareStatement(sql)) {                  // Prepare the SQL statement for execution

            pst.setString(1, student.getName());   // Bind the student's name to the 1st placeholder (?)
            pst.setString(2, student.getCourse()); // Bind the student's course to the 2nd placeholder (?)
            pst.setString(3, student.getEmail());  // Bind the student's email to the 3rd placeholder (?)

            int rowsAffected = pst.executeUpdate(); // Execute the INSERT command and get the count of inserted rows
            return rowsAffected > 0;                // Return true if at least 1 row was successfully inserted
        } catch (SQLException e) {                  // Catch any SQL error during the insert process
            System.err.println("Error Adding Student: " + e.getMessage()); // Log the error message to the console
            return false;                           // Return false to indicate the insert operation failed
        }
    }

    // ========================================================================
    // GROUP 2: READ Operation (Retrieve all students from MySQL)
    // Queries the database and returns a List of all Student objects for the table.
    // ========================================================================
    public List<Student> getAllStudents() {
        List<Student> studentList = new ArrayList<>(); // Create an empty list to hold retrieved Student records
        String sql = "SELECT * FROM students";         // SQL query to fetch all columns and rows from 'students'

        try (Connection conn = DBConnection.getConnection();       // Open a connection to the MySQL database
             PreparedStatement pst = conn.prepareStatement(sql);   // Prepare the SELECT query
             ResultSet rs = pst.executeQuery()) {                  // Execute the query and store results in ResultSet

            while (rs.next()) {                                    // Loop through each row returned by the query
                Student s = new Student();                         // Create a new Student object for the current row
                s.setId(rs.getInt("id"));                          // Read the 'id' column and set it on the Student object
                s.setName(rs.getString("name"));                   // Read the 'name' column and set it on the Student object
                s.setCourse(rs.getString("course"));               // Read the 'course' column and set it on the Student object
                s.setEmail(rs.getString("email"));                 // Read the 'email' column and set it on the Student object
                studentList.add(s);                                // Add the populated Student object to our list
            }
        } catch (SQLException e) {                                 // Catch any SQL error during data retrieval
            System.err.println("Error Fetching Students: " + e.getMessage()); // Log the error message to the console
        }
        return studentList; // Return the complete list of students to the Controller
    }

    // ========================================================================
    // GROUP 3: UPDATE Operation (Modify an existing student record by ID)
    // Updates the name, course, and email of a specific student in MySQL.
    // ========================================================================
    public boolean updateStudent(Student student) {
        String sql = "UPDATE students SET name = ?, course = ?, email = ? WHERE id = ?"; // SQL UPDATE query filtered by ID
        try (Connection conn = DBConnection.getConnection();                             // Open connection to MySQL
             PreparedStatement pst = conn.prepareStatement(sql)) {                       // Prepare the UPDATE statement

            pst.setString(1, student.getName());   // Bind the new name to the 1st placeholder (?)
            pst.setString(2, student.getCourse()); // Bind the new course to the 2nd placeholder (?)
            pst.setString(3, student.getEmail());  // Bind the new email to the 3rd placeholder (?)
            pst.setInt(4, student.getId());        // Bind the target student's ID to the 4th placeholder (?)

            int rowsAffected = pst.executeUpdate(); // Execute the UPDATE command in MySQL
            return rowsAffected > 0;                // Return true if the student record was updated
        } catch (SQLException e) {                  // Catch any SQL error during the update
            System.err.println("Error Updating Student: " + e.getMessage()); // Log the error message
            return false;                           // Return false if the update failed
        }
    }

    // ========================================================================
    // GROUP 4: DELETE Operation (Remove a student record from MySQL by ID)
    // Deletes the row matching the provided student ID from the database.
    // ========================================================================
    public boolean deleteStudent(int id) {
        String sql = "DELETE FROM students WHERE id = ?";          // SQL DELETE query targeting a specific student ID
        try (Connection conn = DBConnection.getConnection();       // Open connection to MySQL
             PreparedStatement pst = conn.prepareStatement(sql)) { // Prepare the DELETE statement

            pst.setInt(1, id);                      // Bind the student ID to the 1st placeholder (?)
            int rowsAffected = pst.executeUpdate(); // Execute the DELETE command in MySQL
            return rowsAffected > 0;                // Return true if the record was deleted
        } catch (SQLException e) {                  // Catch any SQL error during deletion
            System.err.println("Error Deleting Student: " + e.getMessage()); // Log the error message
            return false;                           // Return false if deletion failed
        }
    }
}
