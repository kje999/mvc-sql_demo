package controller; // Package holding the Controller layer (connects View and Model)

// ============================================================================
// IMPORTS: Required Model, View, Event Listener, and Table Model classes
// ============================================================================
import java.awt.event.MouseAdapter;            // Adapter class for receiving mouse click events on the table
import java.awt.event.MouseEvent;              // Represents a mouse click action on a JTable row
import java.util.List;                         // Holds the list of Student objects returned by the DAO
import javax.swing.JOptionPane;                // Displays pop-up dialog boxes for alerts and confirmations
import javax.swing.table.DefaultTableModel;    // Manages rows and columns inside the Swing JTable
import model.Student;                          // Imports the Student entity class (Model)
import model.StudentDAO;                       // Imports the Student database access class (DAO)
import view.StudentView;                       // Imports the Swing GUI form class (View)

/**
 * StudentController Class (Controller Layer)
 * Listens to user actions in StudentView and coordinates CRUD operations with StudentDAO.
 */
public class StudentController {

    // ========================================================================
    // GROUP 1: Controller Fields (References to the View and Model/DAO)
    // ========================================================================
    private final StudentView view; // Reference to the NetBeans drag-and-drop JFrame form
    private final StudentDAO dao;   // Reference to the Data Access Object that talks to MySQL

    // ========================================================================
    // GROUP 2: Constructor & Event Wiring
    // Connects the View buttons and table events to Controller handler methods.
    // ========================================================================
    public StudentController(StudentView view, StudentDAO dao) {
        this.view = view; // Store the passed StudentView instance
        this.dao = dao;   // Store the passed StudentDAO instance

        // Attach action listeners to the 4 buttons created in the NetBeans Palette
        this.view.getBtnAdd().addActionListener(e -> addStudent());       // Run addStudent() when 'Add' button is clicked
        this.view.getBtnUpdate().addActionListener(e -> updateStudent()); // Run updateStudent() when 'Update' button is clicked
        this.view.getBtnDelete().addActionListener(e -> deleteStudent()); // Run deleteStudent() when 'Delete' button is clicked
        this.view.getBtnClear().addActionListener(e -> clearFields());    // Run clearFields() when 'Clear' button is clicked

        // Attach a mouse listener to fill the text boxes when a user clicks a row in the JTable
        this.view.getTblStudents().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                populateFormFromSelectedRow(); // Copy selected table row values into the input fields
            }
        });

        // Load existing student records from MySQL into the JTable as soon as the app starts
        loadStudentTable();
    }

    // ========================================================================
    // GROUP 3: READ Handler (Load all database rows into the JTable)
    // Clears the current JTable rows and refills them with fresh data from MySQL.
    // ========================================================================
    private void loadStudentTable() {
        DefaultTableModel model = (DefaultTableModel) view.getTblStudents().getModel(); // Get the table's data model
        model.setRowCount(0);                                                           // Clear any existing rows in the table

        List<Student> students = dao.getAllStudents(); // Fetch all student records from MySQL via the DAO
        for (Student s : students) {                   // Loop through each Student object in the list
            Object[] row = {                           // Create an array of column values for the current row
                s.getId(),                             // Column 0: Student ID
                s.getName(),                           // Column 1: Full Name
                s.getCourse(),                         // Column 2: Course
                s.getEmail()                           // Column 3: Email
            };
            model.addRow(row);                         // Append the row to the Swing JTable
        }
    }

    // ========================================================================
    // GROUP 4: CREATE Handler (Validate form inputs and save a new student)
    // Reads the text fields, checks they are not empty, and asks DAO to insert.
    // ========================================================================
    private void addStudent() {
        String name = view.getTxtName().getText().trim();     // Read and trim the Full Name text field
        String course = view.getTxtCourse().getText().trim(); // Read and trim the Course text field
        String email = view.getTxtEmail().getText().trim();   // Read and trim the Email text field

        if (name.isEmpty() || course.isEmpty() || email.isEmpty()) { // Check if any required field was left blank
            JOptionPane.showMessageDialog(view, "Please fill in all fields (Name, Course, Email)."); // Alert the user
            return;                                                  // Stop execution until all fields are filled
        }

        Student student = new Student(0, name, course, email); // Create a new Student object (ID is 0 because MySQL auto-increments it)
        if (dao.addStudent(student)) {                         // Call DAO to insert the student and check if it succeeded
            JOptionPane.showMessageDialog(view, "Student added successfully!"); // Show success popup message
            loadStudentTable();                                // Refresh the JTable to show the new student
            clearFields();                                     // Clear the form text boxes for the next entry
        } else {
            JOptionPane.showMessageDialog(view, "Failed to add student. Check database connection."); // Show error popup
        }
    }

    // ========================================================================
    // GROUP 5: UPDATE Handler (Modify the selected student record in MySQL)
    // Ensures a student row is selected, validates inputs, and sends update to DAO.
    // ========================================================================
    private void updateStudent() {
        String idText = view.getTxtId().getText().trim();     // Read the read-only ID field to verify a student is selected
        if (idText.isEmpty()) {                               // If ID is blank, no table row has been clicked yet
            JOptionPane.showMessageDialog(view, "Please select a student from the table to update."); // Prompt user to select a row
            return;                                           // Stop update execution
        }

        String name = view.getTxtName().getText().trim();     // Read updated Full Name from text field
        String course = view.getTxtCourse().getText().trim(); // Read updated Course from text field
        String email = view.getTxtEmail().getText().trim();   // Read updated Email from text field

        if (name.isEmpty() || course.isEmpty() || email.isEmpty()) { // Ensure none of the updated fields are empty
            JOptionPane.showMessageDialog(view, "All fields are required to update a record."); // Warn user
            return;                                                  // Stop update execution
        }

        int id = Integer.parseInt(idText);                      // Convert the student ID string into an integer
        Student student = new Student(id, name, course, email); // Package updated values into a Student model object

        if (dao.updateStudent(student)) {                       // Send updated Student object to DAO and check result
            JOptionPane.showMessageDialog(view, "Student updated successfully!"); // Notify user of success
            loadStudentTable();                                 // Refresh the JTable to display updated values
            clearFields();                                      // Reset the input form fields
        } else {
            JOptionPane.showMessageDialog(view, "Failed to update student."); // Notify user if update failed
        }
    }

    // ========================================================================
    // GROUP 6: DELETE Handler (Confirm and remove the selected student)
    // Asks the user for confirmation before deleting the selected student by ID.
    // ========================================================================
    private void deleteStudent() {
        String idText = view.getTxtId().getText().trim(); // Read the ID field of the currently selected student
        if (idText.isEmpty()) {                           // Check if the user hasn't clicked a row yet
            JOptionPane.showMessageDialog(view, "Please select a student from the table to delete."); // Prompt selection
            return;                                       // Stop delete execution
        }

        int confirm = JOptionPane.showConfirmDialog(      // Show a Yes/No confirmation dialog before deleting
            view,
            "Are you sure you want to delete this student?",
            "Confirm Delete",
            JOptionPane.YES_NO_OPTION
        );

        if (confirm == JOptionPane.YES_OPTION) {          // Proceed only if the user clicked 'Yes'
            int id = Integer.parseInt(idText);            // Convert the ID string into an integer
            if (dao.deleteStudent(id)) {                  // Call DAO to delete the record from MySQL
                JOptionPane.showMessageDialog(view, "Student deleted successfully!"); // Show confirmation popup
                loadStudentTable();                       // Refresh the JTable after deletion
                clearFields();                            // Clear the form text fields
            } else {
                JOptionPane.showMessageDialog(view, "Failed to delete student."); // Show error popup if delete failed
            }
        }
    }

    // ========================================================================
    // GROUP 7: Helper Methods (Populate form on row click & Clear text fields)
    // ========================================================================
    private void populateFormFromSelectedRow() {
        int selectedRow = view.getTblStudents().getSelectedRow(); // Get the index of the clicked row in JTable
        if (selectedRow >= 0) {                                   // Verify a valid row index was clicked
            DefaultTableModel model = (DefaultTableModel) view.getTblStudents().getModel(); // Access table data model
            view.getTxtId().setText(model.getValueAt(selectedRow, 0).toString());           // Copy Column 0 (ID) to txtId
            view.getTxtName().setText(model.getValueAt(selectedRow, 1).toString());         // Copy Column 1 (Name) to txtName
            view.getTxtCourse().setText(model.getValueAt(selectedRow, 2).toString());       // Copy Column 2 (Course) to txtCourse
            view.getTxtEmail().setText(model.getValueAt(selectedRow, 3).toString());        // Copy Column 3 (Email) to txtEmail
        }
    }

    private void clearFields() {
        view.getTxtId().setText("");               // Clear the ID text box
        view.getTxtName().setText("");             // Clear the Full Name text box
        view.getTxtCourse().setText("");           // Clear the Course text box
        view.getTxtEmail().setText("");            // Clear the Email text box
        view.getTblStudents().clearSelection();    // Deselect any highlighted row in the JTable
    }
}
