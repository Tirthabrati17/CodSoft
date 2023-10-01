import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        while (true) {
            System.out.println("Student Management System Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search for Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Roll Number: ");
                    int rollNumber = scanner.nextInt();
                    System.out.print("Enter Grade: ");
                    String grade = scanner.next();
                    Student student = new Student(name, rollNumber, grade);
                    students.add(student);
                    System.out.println("Student added successfully.");
                    break;
                case 2:
                    System.out.print("Enter Roll Number to remove: ");
                    int rollToRemove = scanner.nextInt();
                    boolean removed = false;
                    for (Student s : students) {
                        if (s.getRollNumber() == rollToRemove) {
                            students.remove(s);
                            removed = true;
                            System.out.println("Student removed successfully.");
                            break;
                        }
                    }
                    if (!removed) {
                        System.out.println("Student not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter Roll Number to search: ");
                    int rollToSearch = scanner.nextInt();
                    boolean found = false;
                    for (Student s : students) {
                        if (s.getRollNumber() == rollToSearch) {
                            System.out.println("Student found:");
                            System.out.println(s);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Student not found.");
                    }
                    break;
                case 4:
                    System.out.println("List of all students:");
                    for (Student s : students) {
                        System.out.println(s);
                    }
                    break;
                case 5:
                    System.out.println("Exiting the Student Management System.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    
                    scanner.close();
            }
        }
    }
}

class Student {
    private String name;
    private int rollNumber;
    private String grade;

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Roll Number: " + rollNumber + ", Grade: " + grade;
    }
}
