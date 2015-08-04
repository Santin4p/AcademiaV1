package model.group;

import java.util.List;

import model.student.Student;
import model.student.StudentManager;
import model.teacher.Teacher;
import model.teacher.TeacherManager;

public interface GroupManager {
	public List<Group> getAllGroups();
	public Group createGroup(String groupName, Teacher teacher, List<Student> students);
	public void updateGroup(Group group);
	public void deleteGroup(Group group);
	
	public List<Student> getStudentsFromGroup(Group group);
	public Teacher getTeacherFromGroup(Group group);
	
	public List<Group> getAllGroupsByTeacher(Teacher teacher);
	public List<Group> getAllGroupsByStudent(Student student);
	
	public StudentManager getSManager();
	public TeacherManager getTManager();

}
