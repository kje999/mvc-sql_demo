package main; // Package containing the application's main entry point

// ============================================================================
// IMPORTS: Model, View, Controller, and Swing Event Queue classes
// ============================================================================
import controller.StudentController; // Imports the Controller that links View and Model
import javax.swing.SwingUtilities;   // Ensures the Swing GUI runs safely on the Event Dispatch Thread
import javax.swing.UIManager;        // Allows setting the Nimbus or System Look-and-Feel
import model.StudentDAO;             // Imports the Data Access Object (Model layer)
import view.StudentView;             // Imports the drag-and-drop JFrame form (View layer)

/**
 * Main Class
 * Launches the MVC Student Management CRUD application.
 */
public class Main {

    // ========================================================================
    // GROUP 1: Main Method (Application Entry Point)
    // Sets a clean UI theme and initializes Model, View, and Controller on the EDT.
    // ========================================================================
    public static void main(String[] args) {
        // Group 1A: Apply the built-in "Nimbus" Look and Feel for a clean modern Swing appearance
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) { // Loop through installed themes
                if ("Nimbus".equals(info.getName())) {                                    // Check if Nimbus theme is available
                    UIManager.setLookAndFeel(info.getClassName());                        // Activate the Nimbus theme
                    break;                                                                // Stop searching once applied
                }
            }
        } catch (Exception e) {
            // Fall back to default Java Swing look and feel if Nimbus cannot be loaded
        }

        // Group 1B: Instantiate the MVC components inside the Swing Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> {
            StudentView view = new StudentView();                       // Create the View (NetBeans Drag-and-Drop JFrame)
            StudentDAO dao = new StudentDAO();                          // Create the Model DAO (MySQL CRUD handler)
            new StudentController(view, dao);                           // Connect View and DAO inside the Controller
            view.setVisible(true);                                      // Display the main window on screen
        });
    }
}
