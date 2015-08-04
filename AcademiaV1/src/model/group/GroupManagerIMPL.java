package model.group;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.FileObjectReaderIMPL;
import model.FileObjectWriterIMPL;
import model.student.Student;
import model.student.StudentManager;
import model.teacher.Teacher;
import model.teacher.TeacherManager;

public class GroupManagerIMPL implements GroupManager {
	StudentManager SManager;
	TeacherManager TManager;

	List<Teacher> TeacherList = new ArrayList<Teacher>();
	List<Group> GroupList = new ArrayList<Group>();

	private static final String FILE_GROUP = "Groups.dat";
	File fileName = new File(FILE_GROUP);

	public GroupManagerIMPL(StudentManager S, TeacherManager T) {
		this.SManager = S;
		this.TManager = T;
		try (FileObjectReaderIMPL reader = new FileObjectReaderIMPL(fileName)) {
			while (true) {
				GroupList.add((Group) reader.nextObject());
			}
		} catch (EOFException e) {

		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public List<Group> getAllGroups() {
		return GroupList;
	}

	@Override
	public Group createGroup(String groupName, Teacher teacher,
			List<Student> students) {
		List<Integer> StudentsID = new ArrayList<Integer>();
		int mayor = lastID();
		for (Student student : students) {
			StudentsID.add(student.getId());
		}
		Group instancia = new Group(mayor, groupName, teacher.getId(),
				StudentsID);
		GroupList.add(instancia);
		
		try (FileObjectWriterIMPL writer = new FileObjectWriterIMPL(fileName)) {
			writer.writeObject(instancia);
		} catch (Exception e) {
			return null;
		}
		return instancia;
	}

	@Override
	public void updateGroup(Group group) {
		deleteGroup(group);
		GroupList.add(group);
		try (FileObjectWriterIMPL writer = new FileObjectWriterIMPL(fileName)) {
			writer.writeObject(group);
		} catch (Exception e) {
			
		}

	}

	@Override
	public void deleteGroup(Group group) {
		GroupList.remove(group);
		fileName.delete();
		try (FileObjectWriterIMPL writer = new FileObjectWriterIMPL(fileName)) {
			for (Group group1 : GroupList) {
				writer.writeObject(group1);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public List<Student> getStudentsFromGroup(Group group) {
		List<Student> listaInst=new ArrayList<Student>();
		
		for (Integer group1 : group.getStudentsIds()) {
			listaInst.add(SManager.getStudent(group1));
		}
		
		return listaInst;
	}

	@Override
	public Teacher getTeacherFromGroup(Group group) {
		return TManager.getTeacher(group.getIdTeacher());
	}

	@Override
	public List<Group> getAllGroupsByTeacher(Teacher teacher) {
		List<Group> listaGrup=new ArrayList<Group>();
		for (Group group : GroupList) {
			if (group.getIdTeacher()==teacher.getId()) {
				listaGrup.add(group);
			}
		}
		return listaGrup;
	}

	@Override
	public List<Group> getAllGroupsByStudent(Student student) {
		List<Group> listaGrup=new ArrayList<Group>();
		for (Group groupLista : GroupList) {
			for (Integer studentID : groupLista.getStudentsIds()) {
				if (studentID.equals(student.getId())) {
					listaGrup.add(groupLista);
				}
			}
		}
		return listaGrup;
	}

	private int lastID() {
		int mayor = 1;
		for (Group group : GroupList) {
			if (group.getId() >= mayor) {
				mayor = group.getId() + 1;
			}
		}
		return mayor;
	}

	public StudentManager getSManager() {
		return SManager;
	}


	public TeacherManager getTManager() {
		return TManager;
	}
	
}
