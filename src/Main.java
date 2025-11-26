import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StudentManager studentManager = new StudentManager(); // studentManager things
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

                    // Adding a student to the array
                    studentManager.addStudent(student);

                    // Using studentCount as studentID
                    System.out.printf("Student ID: %s\n", student.getStudentId());
                    System.out.printf("Name: %s\n", student.getName());
                    System.out.printf("Type: %s\n", student.getStudentType());
                    System.out.printf("Age: %d\n", student.getAge());
                    System.out.printf("Email: %s\n", student.getEmail());
                    System.out.printf("Passing Grade: %d%%\n", (int) student.getPassingGrade());

                    if (student.getStudentType().equals("Honors")) {
                        HonorsStudent honorsStudent = (HonorsStudent) student;
                        // Change the average here
                        String isEligible = honorsStudent.checkHonorsEligibility();

                        System.out.printf("Honors Eligible: %s\n", isEligible);
                    }
                    System.out.printf("Status: %s\n", student.getStatus());

                    System.out.println();
                    break;
                case 2:
                    int studentDisplayCount = 0;
                    int regularStudentsDisplayCount = 0;
                    int honorStudentsDisplayCount = 0;

                    int studentCount = studentManager.getStudentCount();

                    System.out.println("STUDENT LISTING");
                    System.out.println("----------------------------------------------------------------------------------------------------");
                    System.out.println("STU ID   | NAME                    | TYPE               | AVG GRADE         | STATUS                ");
                    System.out.println("----------------------------------------------------------------------------------------------------");

                    if (studentCount == 0) {
                        System.out.println("No students found\n");
                    } else if (studentCount <= 5) {
                        for (int i = 0; i < studentCount; i++) {
                            Student s = studentManager.getStudents()[i];

                            s.displayStudentDetails();
                        }
                    }



                    break;
                case 3:
                    System.out.println("RECORD GRADE");
                    System.out.println("_______________________________________________");
                    System.out.println();

                    System.out.print("Enter Student ID: ");
                    String studentId = scanner.nextLine();
                    System.out.println();

                    Student foundStudent = studentManager.findStudent(studentId);

                    System.out.println("Student Details:");
                    System.out.printf("Name: %s\n", foundStudent.getName());
                    System.out.printf("Type: %s Student\n", foundStudent.getStudentType());
                    System.out.printf("Current Average: %%%.2f\n", foundStudent.getPassingGrade()); // change this to the student's average mark


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
