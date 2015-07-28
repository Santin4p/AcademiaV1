package model.student;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.FileObjectReaderIMPL;
import model.FileObjectWriterIMPL;

public class StudentManagerIMPL implements StudentManager {
	List<Student> StudentsList = new ArrayList<Student>();
	private static final String FILE_STUDENT = "Alumnos.dat";
	File fileName = new File(FILE_STUDENT);
	static int lastId = 1;
	Student currentStudent;
	
	public StudentManagerIMPL() {
		try (FileObjectReaderIMPL reader = new FileObjectReaderIMPL(fileName)) {
			while (true) {
				StudentsList.add((Student) reader.nextObject());
			}
		} catch (EOFException e) {

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	@Override
	public List<Student> getAllStudents() {
		return StudentsList;
	}

	@Override
	public Student getStudent(int id) {
		for (Student student : StudentsList) {
			if (student.getId() == id) {
				return student;
			}
		}
		return null;
	}

	@Override
	public Student getStudent(String dni) {
		for (Student student : StudentsList) {
			if (student.getDni().equalsIgnoreCase(dni)) {
				return student;
			}
		}
		return null;
	}

	@Override
	public Student createStudent(String dni, String name, String surnames) {
		int mayor = lastID();
		Student instancia = new Student(name, surnames, dni, null, null,
				mayor);
		StudentsList.add(instancia);
		try (FileObjectWriterIMPL writer = new FileObjectWriterIMPL(fileName)) {
			writer.writeObject(instancia);
		} catch (Exception e) {
			return null;
		}
		return instancia;
	}

	@Override
	public void updateStudent(Student student) {
		deleteStudent(student);
		StudentsList.add(student);
		try (FileObjectWriterIMPL writer = new FileObjectWriterIMPL(fileName)) {
			writer.writeObject(student);
		} catch (Exception e) {
		}
	}

	@Override
	public void deleteStudent(Student student) {
		StudentsList.remove(student);
		fileName.delete();
		try (FileObjectWriterIMPL writer = new FileObjectWriterIMPL(fileName);) {
			for (Student student2 : StudentsList) {
				writer.writeObject(student2);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	private int lastID() {
		int mayor=1;
		for (Student student : StudentsList) {
			if (student.getId()>=mayor) {
				mayor=student.getId()+1;
			}
		}
		return mayor;
	}
}
