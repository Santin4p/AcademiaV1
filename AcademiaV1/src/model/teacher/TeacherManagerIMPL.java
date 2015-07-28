package model.teacher;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.FileObjectReaderIMPL;
import model.FileObjectWriterIMPL;

public class TeacherManagerIMPL implements TeacherManager {
	List<Teacher> TeacherList = new ArrayList<Teacher>();
	private static final String FILE_TEACHER = "Teacher.dat";
	File fileName = new File(FILE_TEACHER);
	static int lastId = 1;
	Teacher currentTeacher;

	public TeacherManagerIMPL() {
		try (FileObjectReaderIMPL reader = new FileObjectReaderIMPL(fileName)) {
			while (true) {
				TeacherList.add((Teacher) reader.nextObject());
			}
		} catch (EOFException e) {

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public List<Teacher> getAllTeachers() {
		return TeacherList;
	}

	@Override
	public Teacher getTeacher(int id) {
		for (Teacher teacher : TeacherList) {
			if (teacher.getId() == id) {
				return teacher;
			}
		}
		return null;
	}

	@Override
	public Teacher getTeacher(String dni) {
		for (Teacher teacher : TeacherList) {
			if (teacher.getDni().equalsIgnoreCase(dni)) {
				return teacher;
			}
		}
		return null;
	}

	@Override
	public Teacher createTeacher(String dni, String name, String surnames) {
		int mayor = lastID();
		Teacher instancia = new Teacher(name, surnames, null, dni, 0);
		TeacherList.add(instancia);
		try (FileObjectWriterIMPL writer = new FileObjectWriterIMPL(fileName)) {
			writer.writeObject(instancia);
		} catch (Exception e) {
			return null;
		}
		return instancia;
	}

	@Override
	public void updateTeacher(Teacher teacher) {
		deleteTeacher(teacher);
		TeacherList.add(teacher);
		try (FileObjectWriterIMPL writer = new FileObjectWriterIMPL(fileName)) {
			writer.writeObject(teacher);
		} catch (Exception e) {
		}

	}

	@Override
	public void deleteTeacher(Teacher teacher) {
		TeacherList.remove(teacher);
		fileName.delete();
		try (FileObjectWriterIMPL writer = new FileObjectWriterIMPL(fileName);) {
			for (Teacher teacher1 : TeacherList) {
				writer.writeObject(teacher1);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	private int lastID() {
		int mayor = 1;
		for (Teacher teacher : TeacherList) {
			if (teacher.getId() >= mayor) {
				mayor = teacher.getId() + 1;
			}
		}
		return mayor;
	}

}
