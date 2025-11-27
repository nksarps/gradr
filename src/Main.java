import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StudentManager studentManager = new StudentManager(); // studentManager things
        int choice;
        Student student;
        Subject subject;

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

                    // Move this to displayStudentDetails
                    if (studentCount == 0) {
                        System.out.println("No students found\n");
                    } else if (studentCount <= 5) {
                        for (int i = 0; i < studentCount; i++) {
                            Student s = studentManager.getStudents()[i];

                            s.displayStudentDetails();
                        }
                        System.out.printf("Total Students: %d\n", studentCount);
                        // Change this to the average grade of the class
                        System.out.printf("Average Class Grade: %.2f%%\n", 0.0);
                    }

                    break;
                case 3:
                    System.out.println("RECORD GRADE");
                    System.out.println("_______________________________________________");
                    System.out.println();

                    System.out.print("Enter Student ID: ");
                    String studentId = scanner.nextLine();
                    System.out.println();

                    Student foundStudent = studentManager.getStudent(studentId);

                    System.out.println("Student Details:");
                    System.out.printf("Name: %s\n", foundStudent.getName());
                    System.out.printf("Type: %s Student\n", foundStudent.getStudentType());
                    System.out.printf("Current Average: %.2f%%\n", foundStudent.getPassingGrade()); // change this to the student's average mark
                    System.out.println();

                    System.out.println("Subject type:");
                    System.out.println("1. Core Subject (Mathematics, English, Science)");
                    System.out.println("2. Elective Subject (Music, Art, Physical Education)\n");

                    System.out.printf("Select type (1-2): ");
                    int subjectTypeChoice = scanner.nextInt();
                    scanner.nextLine();

                    // Setting subject type for display in Available Subjects
                    String subjectType;
                    if (subjectTypeChoice == 1) {
                        // subjectType = "Core";
                        subject = new CoreSubject(null, null);
                    } else if (subjectTypeChoice == 2) {
                        // subjectType = "Elective";
                        subject = new ElectiveSubject(null, null);
                    } else {
                        System.out.println("Invalid subject type entered");
                        break;
                    }

                    System.out.println();

                    subjectType = subject.getSubjectType();
                    System.out.printf("Available %s Subjects\n", subjectType);
                    if (subjectType.equals("Core")) {
                        System.out.println("1. Mathematics");
                        System.out.println("2. English");
                        System.out.println("3. Science");
                    } else { // Look more into this
                        System.out.println("1. Music");
                        System.out.println("2. Art");
                        System.out.println("3. Physical Education");
                    }

                    // CONTINUE FROM HERE!!!!!!!!!!!!!!!!!!!!!!!!



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
