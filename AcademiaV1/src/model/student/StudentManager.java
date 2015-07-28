package model.student;
import java.util.Date;
import java.util.List;
public interface StudentManager {
	public List<Student> getAllStudents();
	public Student getStudent(int id);
	public Student getStudent(String dni);
	public Student createStudent(String dni, String name, String surnames);
	public void updateStudent(Student student);
	public void deleteStudent(Student student);
}
