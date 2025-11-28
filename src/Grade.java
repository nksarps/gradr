import java.time.LocalDate;

interface Gradable {
    boolean recordGrade(double grade);
    boolean validateGrade(double grade);
}

public class Grade implements Gradable {
    static int gradeCounter;

    private String gradeId;
    private String studentId;
    private Subject subject;
    private double grade;
    private String date;

    Grade (String studentId, Subject subject, double grade){
        // setGradeId();
        setStudentId(studentId);
        setSubject(subject);
        setGrade(grade);
        setDate();
    }

    public void setGradeId() {
        gradeId = String.format("GRD%03d", ++gradeCounter);
    }

    public void setDate() {
        date = LocalDate.now().toString();
    }

    // Getters
    public int getGradeCounter() {
        return gradeCounter;
    }

    public String getGradeId() {
        return gradeId;
    }

    public String getStudentId() {
        return studentId;
    }

    public Subject getSubject() {
        return subject;
    }

    public double getGrade() {
        return grade;
    }

    public String getDate() {
        return date;
    }

    // Setters
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public void displayGradeDetails() {
        // displays grade details
    }

    public void getLetterGrade() {
        // converts numeric to letter grade
    }

    @Override
    public boolean validateGrade(double grade) {
        return grade >= 0 && grade <= 100;
    }

    @Override
    public boolean recordGrade(double grade) {
        if (validateGrade(grade)) {
            return true;
        }
        return false;
    }

}

class GradeManager{
    private Grade[] grades = new Grade[200];
    private int gradeCount;

    public void addGrade(Grade grade){
        // int gradeCounter = grade.getGradeCounter();
        // using gradeCounter - 1, because gradeCounter is increased by setGradeId in the Grade class
        // and setGradeId comes before this method
        // grades[gradeCounter-1] = grade;

        grades[gradeCount] = grade;
        gradeCount++;
    }

    public void viewGradesByStudent(String studentId) {
        // Print out all the grades by the student with the provided studentID
        // The variable found is for checking if the student has grades added
        boolean found = false;
        int totalCourses = 0;

        for (Grade grade : grades) {
            // To prevent the code from throwing an error when the grades array is empty
            if (grade == null) continue;

            if (grade.getStudentId().equals(studentId)) {
                totalCourses++;

                // Printing the table header once for when a grade for found
                // for the student. It doesn't print again because found is set to true
                if (!found) {
                    System.out.println("GRADE HISTORY");
                    System.out.println("-------------------------------------------------------------------------------------");
                    System.out.println("GRD ID   | DATE       | SUBJECT          | TYPE       | GRADE");
                    System.out.println("-------------------------------------------------------------------------------------");
                    found = true;
                }

                System.out.printf("%-9s | %-10s | %-16s | %-10s | %-5.1f%%\n",
                        grade.getGradeId(),
                        grade.getDate(),
                        grade.getSubject().getSubjectName(),
                        grade.getSubject().getSubjectType(),
                        grade.getGrade());


            }
        }

        // found remain false if there are no grades added for the student
        if (!found) {
            System.out.println("_______________________________________________");
            System.out.println("No grades recorded for this student");
            System.out.println("_______________________________________________");
            System.out.println();
        } else {
            System.out.println();
            System.out.printf("Total Grades: %d\n", totalCourses);
            System.out.printf("Core Subjects Average: %.1f%%\n", calculateCoreAverage(studentId));
            System.out.printf("Elective Subjects Average: %.1f%%\n", calculateElectiveAverage(studentId));
            System.out.printf("Overall Average: %.1f%%\n", calculateOverallAverage(studentId));
            System.out.println();

        }
    }

    // START HERE
    public double calculateCoreAverage(String studentId) {
        // Print out all the grades by the student with the provided studentID
        // Use the Grade class since its constructor takes in studentId as an input
        // Get the subject of the grade using the subject parameter passed to the grade
        // Use subject parameter to get core subjects
        // Calculate the average of these core subjects
        double gradeSum = 0;
        int totalCourses = 0;

        for (Grade grade : grades) {
            if (grade == null) continue;

            if (grade.getStudentId().equals(studentId)) {
                if (grade.getSubject().getSubjectType().equals("Core")) {
                    gradeSum += grade.getGrade();
                    totalCourses++;
                }
            }
        }

        // To prevent the method from throwing an error by dividing by 0
        // if there are no core subjects
        if (totalCourses == 0) return 0.0;

        return gradeSum / totalCourses;
    }

    public double calculateElectiveAverage(String studentId) {
        // Print out all the grades by the student with the provided studentID
        // Use the Grade class since its constructor takes in studentId as an input
        // Get the subject of the grade using the subject parameter passed to the grade
        // Use subject parameter to get elective subjects
        // Calculate the average of these elective subjects
        double gradeSum = 0;
        int totalCourses = 0;

        for (Grade grade : grades) {
            if (grade == null) continue;

            if (grade.getStudentId().equals(studentId)) {
                if (grade.getSubject().getSubjectType().equals("Elective")) {
                    gradeSum += grade.getGrade();
                    totalCourses++;
                }
            }
        }
        // To prevent the method from throwing an error by dividing by 0
        // if there are no elective subjects
        if (totalCourses == 0) return 0.0;

        return gradeSum / totalCourses;
    }

    public double calculateOverallAverage(String studentId) {
        // Get out all the grades by the student with the provided studentID
        // Use the Grade class since its constructor takes in studentId as an input
        // Calculate the average of all the grades for that particular student
        double gradeSum = 0;
        int totalCourses = 0;

        for (Grade grade : grades) {
            // To prevent an error if the grades array is empty
            if (grade == null) continue;

            if (grade.getStudentId().equals(studentId)) {
                gradeSum += grade.getGrade();
                totalCourses++;
            }
        }

        // To prevent the method from throwing an error by dividing by 0
        // if there are no subjects
        if (totalCourses == 0) return 0.0;

        return gradeSum / totalCourses;
    }

    public int getGradeCount() {
        return gradeCount;
    }

    public Grade[] getGrades() {
        return grades;
    }
}