# Gradr
A Java-based console application for managing student grades. 

## Project Overview 
Gradr is a Java-based console application for managing student grades. The project shows key OOP principles like abstraction, inheritance, polymorphism, and encapsulation, while providing a structured and efficient waw to handle student grades.

## Project Structure
gradr/
├── .idea/
│   ├── .gitignore
│   ├── misc.xml
│   ├── modules.xml
│   └── vcs.xml
│
├── src/
│   ├── Grade.java
│   ├── Main.java
│   ├── Student.java
│   └── Subject.java
│
├── .gitignore
├── README.md
├── StudentGradeManagement.iml
└── TODO.md

## Prerequisites

- **Java Development Kit (JDK)**
    - Download from: https://www.oracle.com/java/technologies/downloads/

- **Git**: For version control
    - Download from: https://git-scm.com/

## Key Features
- **Add Student**: Register new students in the system
- **View Students**: Display all students with their details
- **Record Grade**: Add grades for students in different subjects
- **View Grade Report**: Display grade history for a student
- **Simple Menu**: Navigate through options

## Setup Steps
### 1. Clone the Repository

```bash
git clone https://github.com/nksarps/gradr
```

### 2. Verify Prerequisites
Check that Java is installed:

```bash
java --version
```

### 3. Compile the Project

```bash
javac src/*.java
```

### 4. Run the Project
```bash
java src/Main.java
```

## Usage Examples
### Main Menu
``` bash
||=============================================||
||     STUDENT GRADE MANAGEMENT - MAIN MENU    ||
||=============================================||

1. Add Student
2. View Students
3. Record Grade
4. View Grade Report
5. Exit

Enter choice: 
```

### Adding a new student
```bash
Enter choice: 1

ADD STUDENT
_______________________________________________

Enter student name: Nana Kwaku
Enter student age: 12
Enter student email: nana.kwaku@school.edu
Enter student phone: 0123456789

Student type:
1. Regular Student (Passing grade: 50%)
2. Honors Student: (Passing grade: 60%, honors recognition)

Select type (1-2): 1

Student added successfully!
Student ID: STU001
Name: Nana Kwaku
Type: Regular
Age: 20
Email: nana.kwaku@school.edu
Passing Grade: 50%
Status: Active
```

## License
This project is for educational purposes.

## Contact
For inquiries or feedback, please get in touch with the project owner.