abstract class Student {
    private String studentId;
    private String name;
    private int age;
    private String email;
    private String phone;
    private String status;

    static int studentCounter;

    Student() {
        // Change to super or something
    }

    abstract void displayStudentDetails();

    abstract String getStudentType();

    abstract double getPassingGrade();

    public double calculateAverageGrade() {
        return 0.0;
    };

    public boolean isPassing() {
        // use an if statement and let this method take in an attribute of score
        return false;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for age
    public int getAge() {
        return age;
    }

    // Setter for age
    public void setAge(int age) {
        this.age = age;
    }

    // Getter for email
    public String getEmail() {
        return email;
    }

    // Setter for email
    public void setEmail(String name) {
        this.email = email;
    }

    // Getter for phone
    public String getPhone() {
        return phone;
    }

    // Setter for phone
    public void setPhone(String name) {
        this.phone = phone;
    }

    // Getter for status
    public String getStatus() {
        return status;
    }

    // Setter for status
    public void setStatus() {
        this.status = "Active";
    }
}


class RegularStudent extends Student {
    private double passingGrade = 50.0;

    RegularStudent(String name, int age, String email, String phone) {
        this.setName(name);
        this.setAge(age);
        this.setEmail(email);
        this.setPhone(phone);
    }

    @Override
    void displayStudentDetails() {
        // Display student details
    }

    @Override
    String getStudentType() {
        return "Regular";
    }

    @Override
    double getPassingGrade() {
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
    }

    @Override
    String getStudentType() {
        return "Honors";
    }

    @Override
    double getPassingGrade() {
        return 60.0;
    }

    public String checkHonorsEligibility(double average) {
        if (average >= 85.0) {
            return "Yes";
        }
        return "No";
    }
}

