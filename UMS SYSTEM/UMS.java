import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UMS {
    private List<StudentDetails> students;
    private List<FacultyDetails> faculties;
    private Admin admin;

    public UMS() {
        students = new ArrayList<>();
        faculties = new ArrayList<>();
        admin = new Admin("admin", "password123", "Admin"); // Example admin credentials
    }

    public void login() {
        Scanner scanner = new Scanner(System.in);
        boolean continueRunning = true;

        while (continueRunning) {
            System.out.println("Enter the login Type:");
            System.out.println("1. Admin Login");
            System.out.println("2. Student Login");
            System.out.println("3. Faculty Login");
            System.out.println("4. Exit");
            int choose = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choose) {
                case 1:
                    adminLogin();
                    break;
                case 2:
                    studentLogin();
                    break;
                case 3:
                    facultyLogin();
                    break;
                case 4:
                    continueRunning = false;
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }

    private void adminLogin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();

        try {
            if (admin.validateUser(username, password)) {
                boolean continueAdmin = true;
                while (continueAdmin) {
                    adminOperations();
                    System.out.println("Do you want to relogin or exit? (1 for Relogin, 2 for Exit)");
                    int choice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    if (choice == 1) {
                        continueAdmin = false;
                    } else if (choice == 2) {
                        continueAdmin = false;
                        System.out.println("Exiting the system. Goodbye!");
                    } else {
                        System.out.println("Invalid choice.");
                    }
                }
            } else {
                System.out.println("Invalid username or password.");
            }
        } catch (InvalidLoginException e) {
            System.out.println(e.getMessage());
        }
    }

    private void studentLogin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Student ID: ");
        String studentId = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();

        StudentDetails student = validateStudent(studentId, password);
        if (student != null) {
            boolean continueStudent = true;
            while (continueStudent) {
                studentOperations(student);
                System.out.println("Do you want to relogin or exit? (1 for Relogin, 2 for Exit)");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                if (choice == 1) {
                    continueStudent = false;
                } else if (choice == 2) {
                    continueStudent = false;
                    System.out.println("Exiting the system. Goodbye!");
                } else {
                    System.out.println("Invalid choice.");
                }
            }
        } else {
            System.out.println("Invalid Student ID or password.");
        }
    }

    private void facultyLogin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Faculty ID: ");
        String facultyId = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();

        FacultyDetails faculty = validateFaculty(facultyId, password);
        if (faculty != null) {
            boolean continueFaculty = true;
            while (continueFaculty) {
                facultyOperations(faculty);
                System.out.println("Do you want to relogin or exit? (1 for Relogin, 2 for Exit)");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                if (choice == 1) {
                    continueFaculty = false;
                } else if (choice == 2) {
                    continueFaculty = false;
                    System.out.println("Exiting the system. Goodbye!");
                } else {
                    System.out.println("Invalid choice.");
                }
            }
        } else {
            System.out.println("Invalid Faculty ID or password.");
        }
    }

    private StudentDetails validateStudent(String studentId, String password) {
        for (StudentDetails student : students) {
            if (student.getStudentId().equals(studentId) && student.validatePassword(password)) {
                return student;
            }
        }
        return null;
    }

    private FacultyDetails validateFaculty(String facultyId, String password) {
        for (FacultyDetails faculty : faculties) {
            if (faculty.getFacultyId().equals(facultyId) && faculty.validatePassword(password)) {
                return faculty;
            }
        }
        return null;
    }

    private void studentOperations(StudentDetails student) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Student Operations:");
        System.out.println("1. Give Exam");
        System.out.println("2. Take Course");
        System.out.println("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                student.giveExam();
                break;
            case 2:
                student.takeCourse();
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private void facultyOperations(FacultyDetails faculty) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Faculty Operations:");
        System.out.println("1. Assign Grade");
        System.out.println("2. Take Exam");
        System.out.println("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                faculty.assignGrade();
                break;
            case 2:
                faculty.takeExam();
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private void adminOperations() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Admin Operations:");
        System.out.println("1. Add Student");
        System.out.println("2. Add Faculty");
        System.out.println("3. Fee Collection");
        System.out.println("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); 

        switch (choice) {
            case 1:
                admin.addStudent(students);
                break;
            case 2:
                admin.addFaculty(faculties);
                break;
            case 3:
                admin.feeCollection();
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    public static void main(String[] args) {
        UMS ums = new UMS();
        // Add some students and faculties for testing
        ums.students.add(new StudentDetails("Kunal Patel", "123 Raigarh", "555-1234", "stu001", "A", "CS", "pass123"));
        ums.students.add(new StudentDetails("Gajendra Bhoii", "456 Mahasamund", "555-5678", "stu002", "B", "EE", "pass456"));

        ums.faculties.add(new FacultyDetails("Dr.Nikita Patel", "789 Jagdalpur", "555-9876", "fac001", "CS", "Algorithms", "facpass123"));
        ums.faculties.add(new FacultyDetails("Dr.Neha Patel", "321 Bareli", "555-6543", "fac002", "EE", "Circuits", "facpass456"));

        ums.login();
    }
}
