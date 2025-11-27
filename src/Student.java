abstract class Student {
    private String studentId;
    private String name;
    private int age;
    private String email;
    private String phone;
    private String status;

    static int studentCounter;

    Student() {
        setStudentId();
    }

    abstract void displayStudentDetails();

    abstract String getStudentType();

    // return average of all grades (for the student)
    abstract double getPassingGrade();

    // I will calculate the average grade later
    public double calculateAverageGrade() {
        return 0.0;
    };

    public boolean isPassing(double averageGrade) {
        // use an if statement and let this method take in an attribute of score
        return false;
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