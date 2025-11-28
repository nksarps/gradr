abstract class Student {
    private String studentId;
    private String name;
    private int age;
    private String email;
    private String phone;
    private String status;

    static int studentCounter;

    // Adding the gradeManager to be able to access the student's grades from here
    private GradeManager gradeManager;

    // Adding a setter to be able to get an instance of gradeManager in the student class
    // This is used after user has been created in Main
    public void setGradeManager(GradeManager gradeManager) {
        this.gradeManager = gradeManager;
    }

    Student() {
        setStudentId();
        setStatus();
    }

    abstract void displayStudentDetails();

    abstract String getStudentType();

    // return average of all grades (for the student)
    abstract double getPassingGrade();

    // Passing the gradeManager as a parameter here.
    // Change if you get a better idea
    public double calculateAverageGrade() {
        // Using the calculateOverallAverage method from GradeManager to get the average of
        // student marks
        if (gradeManager == null) return 0.0;
        return gradeManager.calculateOverallAverage(studentId);
    };

    public boolean isPassing(double averageGrade) {
        return averageGrade >= getPassingGrade();
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getStatus() {
        return status;
    }

    public String getStudentId() {
        return studentId;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String name) {
        this.phone = phone;
    }

    public void setStatus() {
        this.status = "Active";
    }

    public void setStudentId() {
        // Question: Why does ++studentCounter work but studentCounter++ does not
        studentId = String.format("STU%03d", ++studentCounter);
    }
}


class RegularStudent extends Student {
    private double passingGrade = 50.0;

    RegularStudent(String name, int age, String email, String phone) {
        setName(name);
        setAge(age);
        setEmail(email);
        setPhone(phone);
    }

    // Passing gradeManager as an argument here to get the average grade for display
    @Override
    public void displayStudentDetails() {
        // Display student details
        System.out.printf("%-8s | %-23s | %-18s | %-17.2f | %20s\n",
                getStudentId(), getName(), getStudentType(), calculateAverageGrade(), getStatus());
    }

    @Override
    public String getStudentType() {
        return "Regular";
    }

    @Override
    public double getPassingGrade() {
        return 50.0;
    }
}


class HonorsStudent extends Student {
    private double passingGrade = 60.0;
    private boolean honorsEligible;

    HonorsStudent(String name, int age, String email, String phone) {
        setName(name);
        setAge(age);
        setEmail(email);
        setPhone(phone);
    }

    @Override
    void displayStudentDetails() {
        // Display student details + Honors status
        System.out.printf("%-8s | %-23s | %-18s | %-17.2f | %20s\n",
                getStudentId(), getName(), getStudentType(), calculateAverageGrade(), getStatus());
    }

    @Override
    public String getStudentType() {
        return "Honors";
    }

    @Override
    public double getPassingGrade() {
        return 60.0;
    }

    public String checkHonorsEligibility() {
        double averageGrade = calculateAverageGrade();

        if (averageGrade >= 85.0) {
            return "Yes";
        }
        return "No";
    }
}

class StudentManager {
    private Student[] students = new Student[50];
    private int studentCount = 0;

    // added student to the counter array
    public void addStudent(Student student) {
        students[studentCount] = student;
        studentCount++;
    }

    public Student getStudent(String studentId) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }

    // Returns are students
    public void viewAllStudents() {
        // return students; // Return type was Student[]
        System.out.println(students.toString());
    }

    // produces the number of students
    public int getStudentCount() {
        return studentCount;
    }

    // Getter for students array
    public Student[] getStudents() {
        return students;
    }

}