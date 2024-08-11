import java.util.List;

public interface AdminOperations {
    void addStudent(List<StudentDetails> students);
    void addFaculty(List<FacultyDetails> faculties);
    void feeCollection();
    boolean validateUser(String username, String password) throws InvalidLoginException;
}