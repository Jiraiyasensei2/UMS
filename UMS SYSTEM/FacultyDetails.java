public class FacultyDetails extends UserDetails implements FacultyOperations {
    private String facultyId;
    private String department;
    private String subjectTaught;
    private String password;

    public FacultyDetails(String name, String address, String mobileNo, String facultyId, String department, String subjectTaught, String password) {
        super(name, address, mobileNo);
        this.facultyId = facultyId;
        this.department = department;
        this.subjectTaught = subjectTaught;
        this.password = password;
    }

    public String getFacultyId() {
        return facultyId;
    }

    public String getDepartment() {
        return department;
    }

    public String getSubjectTaught() {
        return subjectTaught;
    }

    public boolean validatePassword(String password) {
        return this.password.equals(password);
    }

    @Override
    public void assignGrade() {
        System.out.println("Faculty " + getName() + " is assigning a grade.");
        // Implement the assign grade logic here
    }

    @Override
    public void takeExam() {
        System.out.println("Faculty " + getName() + " is taking an exam.");
        // Implement the exam logic here
    }

    @Override
    public String toString() {
        return "FacultyDetails{" +
                "facultyId='" + facultyId + '\'' +
                ", department='" + department + '\'' +
                ", subjectTaught='" + subjectTaught + '\'' +
                "} " + super.toString();
    }
}
