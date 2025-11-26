import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        Student student;

        do {
            displayMainMenu();

            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            switch (choice) {
                case 1:
                    // ADD STUDENT
                    System.out.println("ADD STUDENT");
                    System.out.println("_______________________________________________");
                    System.out.println();

                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter student age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter student email: ");
                    String email = scanner.nextLine();

                    System.out.print("Enter student phone: ");
                    String phone = scanner.nextLine();
                    System.out.println();

                    System.out.println("Student type:");
                    System.out.println("1. Regular Student (Passing grade: 50%)");
                    System.out.println("2. Honors Student: (Passing grade: 60%, honors recognition)");
                    System.out.println();

                    System.out.print("Select type (1-2): ");
                    int studentType = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println();

                    if (studentType == 1) {
                        student = new RegularStudent(name, age, email, phone);
                    } else if (studentType == 2) {
                        student = new HonorsStudent(name, age, email, phone);
                    } else {
                        System.out.println("Invalid student type. Enter details again.");
                        break;
                    }

                    student.setStatus();

                    System.out.println("✔️ Student added successfully!");

                    System.out.printf("Student ID: STU000\n");
                    System.out.printf("Name: %s\n", student.getName());
                    System.out.printf("Type: %s\n", student.getStudentType());
                    System.out.printf("Age: %d\n", student.getAge());
                    System.out.printf("Email: %s\n", student.getEmail());
                    System.out.printf("Passing Grade: %d%%\n", (int) student.getPassingGrade());

                    if (student.getStudentType().equals("Honors")) {
                        HonorsStudent honorsStudent = (HonorsStudent) student;
                        // Change the average here
                        String isEligible = honorsStudent.checkHonorsEligibility(87.00);

                        System.out.printf("Honors Eligible: %s\n", isEligible);
                    }
                    System.out.printf("Status: %s\n", student.getStatus());

                    System.out.println();
                    break;
                case 2:
                    System.out.println("VIEW STUDENTS");
                    System.out.println("_______________________________________________");
                    System.out.println();
                    break;
                case 3:
                    System.out.println("RECORD GRADE");
                    System.out.println("_______________________________________________");
                    System.out.println();
                    break;
                case 4:
                    System.out.println("VIEW GRADE REPORT");
                    System.out.println("_______________________________________________");
                    System.out.println();
                    break;
                case 5:
                    System.out.println("Thank you for using Student Grade Management System!");
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    System.out.println();
            }
        } while (choice != 5);

        scanner.close();
    }

    // Class for displaying the Main Menu
    public static void displayMainMenu() {
        System.out.println("||=============================================||");
        System.out.println("||     STUDENT GRADE MANAGEMENT - MAIN MENU    ||");
        System.out.println("||=============================================||");
        System.out.println();

        System.out.println("1. Add Student");
        System.out.println("2. View Students");
        System.out.println("3. Record Grade");
        System.out.println("4. View Grade Report");
        System.out.println("5. Exit");
        System.out.println();
    }

}
