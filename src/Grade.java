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
        setGradeId();
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
    private Grade[] grades = new Grade[50];

    public void addGrade(Grade grade){
        int gradeCounter = grade.getGradeCounter();
        grades[gradeCounter] = grade;
    }
}