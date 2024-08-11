public class StudentDetails extends UserDetails implements StudentOperations {
    private String studentId;
    private String grade;
    private String department;
    private String password;

    public StudentDetails(String name, String address, String mobileNo, String studentId, String grade, String department, String password) {
        super(name, address, mobileNo);
        this.studentId = studentId;
        this.grade = grade;
        this.department = department;
        this.password = password;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getGrade() {
        return grade;
    }

    public String getDepartment() {
        return department;
    }

    public boolean validatePassword(String password) {
        return this.password.equals(password);
    }

    @Override
    public void giveExam() {
        System.out.println("Student " + getName() + " is giving an exam.");
        
    }

    @Override
    public void takeCourse() {
        System.out.println("Student " + getName() + " is taking a course in " + department + ".");
        
    }

    @Override
    public String toString() {
        return "StudentDetails{" +
                "studentId='" + studentId + '\'' +
                ", grade='" + grade + '\'' +
                ", department='" + department + '\'' +
                "} " + super.toString();
    }
}
