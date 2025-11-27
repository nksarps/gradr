abstract class Subject {
    private String subjectName;
    private String subjectCode;

    Subject () {
        // Constructors
    }

    // Getters
    public String getSubjectName() {
        return subjectName;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    // Setters
    public void setSubjectName(String name) {
        subjectName = name;
    }

    public void setSubjectCode(String code) {
        subjectCode = code;
    }

    abstract void displaySubjectDetails ();

    abstract String getSubjectType();
}

class CoreSubject extends Subject {
    private static boolean mandatory = true;

    CoreSubject(String subjectName, String subjectCode) {
        setSubjectName(subjectName);
        setSubjectCode(subjectCode);
    }

    @Override
    public void displaySubjectDetails() {
        // Show subject details
    }

    @Override
    public String getSubjectType() {
        return "Core";
    }

    public boolean isMandatory() {
        return true;
    }
}

 class ElectiveSubject extends Subject {
    private static boolean mandatory = false;

    ElectiveSubject(String subjectName, String subjectCode) {
        setSubjectName(subjectName);
        setSubjectCode(subjectCode);
    }

    @Override
     public void displaySubjectDetails() {
        // display subject details
    }

    @Override
     public String getSubjectType() {
        return "Elective";
    }

    public boolean isMandatory() {
        return false;
    }

 }