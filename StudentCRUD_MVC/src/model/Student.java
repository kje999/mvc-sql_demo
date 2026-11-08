package model; // Package holding the Model layer classes (Data & Business Logic)

/**
 * Student Class (Model Layer - POJO / Entity)
 * Represents a single student record with properties, constructors, getters, and setters.
 */
public class Student {

    // ========================================================================
    // GROUP 1: Private Data Fields (Encapsulation)
    // These variables match the columns in the MySQL 'students' table.
    // ========================================================================
    private int id;        // Stores the unique auto-incremented student ID
    private String name;   // Stores the student's full name
    private String course; // Stores the student's academic course
    private String email;  // Stores the student's email address

    // ========================================================================
    // GROUP 2: Constructors
    // Used to create empty Student objects or initialize them with values.
    // ========================================================================
    public Student() {
        // Default no-argument constructor for creating an empty Student object
    }

    public Student(int id, String name, String course, String email) {
        this.id = id;         // Assign the passed id to this object's id field
        this.name = name;     // Assign the passed name to this object's name field
        this.course = course; // Assign the passed course to this object's course field
        this.email = email;   // Assign the passed email to this object's email field
    }

    // ========================================================================
    // GROUP 3: Getters and Setters
    // Allow safe reading (get) and modifying (set) of private student fields.
    // ========================================================================
    public int getId() {
        return id; // Return the current student ID
    }

    public void setId(int id) {
        this.id = id; // Update the student ID value
    }

    public String getName() {
        return name; // Return the current student name
    }

    public void setName(String name) {
        this.name = name; // Update the student name value
    }

    public String getCourse() {
        return course; // Return the current student course
    }

    public void setCourse(String course) {
        this.course = course; // Update the student course value
    }

    public String getEmail() {
        return email; // Return the current student email
    }

    public void setEmail(String email) {
        this.email = email; // Update the student email value
    }
}
