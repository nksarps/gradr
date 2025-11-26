import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            displayMainMenu();

            System.out.printf("Enter choice: ");
            choice = scanner.nextInt();
            System.out.println();

            switch (choice) {
                case 1:
                    // ADD STUDENT
                    System.out.println("ADD STUDENT");
                    System.out.println("_______________________________________________");
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
