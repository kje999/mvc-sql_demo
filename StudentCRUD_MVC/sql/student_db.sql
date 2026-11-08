-- ============================================================================
-- DATABASE SETUP SCRIPT FOR APACHE NETBEANS MVC CRUD PROJECT
-- Run this script in MySQL Workbench, phpMyAdmin, or MySQL Command Line Client
-- ============================================================================

-- Group 1: Create and select the database
CREATE DATABASE IF NOT EXISTS student_db; -- Create the database if it does not exist yet
USE student_db;                           -- Switch to the newly created student_db database

-- Group 2: Create the students table for CRUD operations
CREATE TABLE IF NOT EXISTS students (
    id INT AUTO_INCREMENT PRIMARY KEY,    -- Unique student ID generated automatically
    name VARCHAR(100) NOT NULL,           -- Student's full name (required)
    course VARCHAR(100) NOT NULL,         -- Enrolled academic course or program (required)
    email VARCHAR(100) NOT NULL           -- Student's contact email address (required)
);

-- Group 3: Insert sample starter records for testing Read/Update/Delete
INSERT INTO students (name, course, email) VALUES
('Juan Dela Cruz', 'BS Computer Science', 'juan.delacruz@example.com'),
('Maria Clara', 'BS Information Technology', 'maria.clara@example.com'),
('Jose Rizal', 'BS Information Systems', 'jose.rizal@example.com');
