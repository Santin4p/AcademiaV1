package model;
import java.util.List;

public interface TeacherManager {
	public List<Student> getAllTeachers();
	public Student getTeacher(int id);
	public Student getTeacher(String dni);
	public Student createTeacher(String dni, String name, String surnames);
	public void updateTeacher(Student teacher);
	public void deleteTeacher(Student teacher);
}
