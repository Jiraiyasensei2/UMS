import java.util.List;
import java.util.Scanner;

public class Admin implements AdminOperations {
    private String username;
    private String password;
    private String role;

    public Admin(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    @Override
    public boolean validateUser(String username, String password) throws InvalidLoginException {
        if (!this.username.equals(username) || !this.password.equals(password)) {
            throw new InvalidLoginException("Invalid username or password.");
        }
        return true;
    }

    @Override
    public void addStudent(List<StudentDetails> students) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Student Name: ");
        String name = scanner.nextLine();
        System.out.println("Enter Address: ");
        String address = scanner.nextLine();
        System.out.println("Enter Mobile Number: ");
        String mobileNo = scanner.nextLine();
        System.out.println("Enter Student ID: ");
        String studentId = scanner.nextLine();
        System.out.println("Enter Grade: ");
        String grade = scanner.nextLine();
        System.out.println("Enter Department: ");
        String department = scanner.nextLine();
        System.out.println("Enter Password: ");
        String password = scanner.nextLine();

        StudentDetails newStudent = new StudentDetails(name, address, mobileNo, studentId, grade, department, password);
        students.add(newStudent);
        System.out.println("Student added successfully.");
    }

    @Override
    public void addFaculty(List<FacultyDetails> faculties) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Faculty Name: ");
        String name = scanner.nextLine();
        System.out.println("Enter Address: ");
        String address = scanner.nextLine();
        System.out.println("Enter Mobile Number: ");
        String mobileNo = scanner.nextLine();
        System.out.println("Enter Faculty ID: ");
        String facultyId = scanner.nextLine();
        System.out.println("Enter Department: ");
        String department = scanner.nextLine();
        System.out.println("Enter Subject Taught: ");
        String subjectTaught = scanner.nextLine();
        System.out.println("Enter Password: ");
        String password = scanner.nextLine();

        FacultyDetails newFaculty = new FacultyDetails(name, address, mobileNo, facultyId, department, subjectTaught, password);
        faculties.add(newFaculty);
        System.out.println("Faculty added successfully.");
    }

    @Override
    public void feeCollection() {
        // Implementation for fee collection
        System.out.println("Fee Collection not yet implemented.");
    }
}
