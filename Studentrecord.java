import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

/**
 * Student class to store student details.
 * As per hint 1: fields for ID, name, marks.
 */
class Student {
    private int id;
    private String name;
    private double marks;

    // Constructor
    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    // Getter methods
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    // Setter for marks (for the Update operation)
    public void setMarks(double marks) {
        this.marks = marks;
    }

    // toString method to print student details easily
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Marks: " + marks;
    }
}

/**
 * Main class to run the CRUD system.
 * Implements the menu and operations.
 */
public class Studentrecord {

    public static void main(String[] args) {
        // As per hint 2: Use ArrayList to store student objects
        ArrayList<Student> studentList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("Welcome to the Student Management System");

        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Add Student (Create)");
            System.out.println("2. View All Students (Read)");
            System.out.println("3. Update Student Marks (Update)");
            System.out.println("4. Delete Student (Delete)");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    // --- CREATE (Add) ---
                    System.out.println("\n--- Add New Student ---");
                    System.out.print("Enter Student ID: ");
                    int id;
                    try {
                        id = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID. Please enter a number.");
                        continue;
                    }

                    // Check for duplicate ID
                    boolean idExists = false;
                    for (Student s : studentList) {
                        if (s.getId() == id) {
                            idExists = true;
                            break;
                        }
                    }

                    if (idExists) {
                        System.out.println("Error: Student ID " + id + " already exists.");
                    } else {
                        System.out.print("Enter Student Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Student Marks: ");
                        double marks;
                        try {
                            marks = Double.parseDouble(scanner.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid marks. Setting to 0.0.");
                            marks = 0.0;
                        }
                        
                        Student newStudent = new Student(id, name, marks);
                        studentList.add(newStudent);
                        System.out.println("Student added successfully!");
                    }
                    break;

                case 2:
                    // --- READ (View) ---
                    System.out.println("\n--- View All Students ---");
                    if (studentList.isEmpty()) {
                        System.out.println("No student records found.");
                    } else {
                        for (Student s : studentList) {
                            System.out.println(s); // Uses the toString() method
                        }
                    }
                    break;

                case 3:
                    // --- UPDATE ---
                    System.out.println("\n--- Update Student Marks ---");
                    if (studentList.isEmpty()) {
                        System.out.println("No student records to update.");
                        break;
                    }
                    System.out.print("Enter Student ID to update: ");
                    int updateId;
                    try {
                        updateId = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID. Please enter a number.");
                        continue;
                    }

                    Student studentToUpdate = null;
                    for (Student s : studentList) {
                        if (s.getId() == updateId) {
                            studentToUpdate = s;
                            break;
                        }
                    }

                    if (studentToUpdate == null) {
                        System.out.println("Student with ID " + updateId + " not found.");
                    } else {
                        System.out.print("Enter new marks for " + studentToUpdate.getName() + ": ");
                        try {
                            double newMarks = Double.parseDouble(scanner.nextLine());
                            studentToUpdate.setMarks(newMarks);
                            System.out.println("Marks updated successfully.");
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid marks. Update failed.");
                        }
                    }
                    break;

                case 4:
                    // --- DELETE ---
                    System.out.println("\n--- Delete Student ---");
                    if (studentList.isEmpty()) {
                        System.out.println("No student records to delete.");
                        break;
                    }
                    System.out.print("Enter Student ID to delete: ");
                    int deleteId;
                    try {
                        deleteId = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID. Please enter a number.");
                        continue;
                    }

                    // Use Iterator for safe removal
                    Iterator<Student> iterator = studentList.iterator();
                    boolean found = false;
                    while (iterator.hasNext()) {
                        Student s = iterator.next();
                        if (s.getId() == deleteId) {
                            iterator.remove(); // Safely removes the element
                            found = true;
                            break;
                        }
                    }

                    if (found) {
                        System.out.println("Student with ID " + deleteId + " deleted successfully.");
                    } else {
                        System.out.println("Student with ID " + deleteId + " not found.");
                    }
                    break;

                case 5:
                    // --- Exit ---
                    System.out.println("Exiting application. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                    break;
            }
        }
    }
}