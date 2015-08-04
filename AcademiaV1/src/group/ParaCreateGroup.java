package group;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import model.group.Group;
import model.group.GroupManager;
import model.student.Student;
import model.student.StudentManager;
import model.teacher.Teacher;
import view.group.CreateGroup;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ParaCreateGroup extends CreateGroup {
	GroupManager instancia;
	Group currentGroup;
	Student currentStudent;
	Teacher currentTeacher;
	DefaultTableModel modelo=(DefaultTableModel)table.getModel();
	
	public ParaCreateGroup(GroupManager groupM) {

		this.instancia = groupM;
		RellenarComboBoxProfesor();
		RellenarComboBoxAlumnos();
		eventos();
	}

	private void eventos() {
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentStudent=(Student) comboBox_1.getSelectedItem();
				Object[] data = {currentStudent.getDni(),currentStudent.getName(),currentStudent.getSurname()};
				modelo.addRow(data);
			}
		});
	}

	private void RellenarComboBoxProfesor() {
		for (int i = 0; i < instancia.getTManager().getAllTeachers().size(); i++) {
			currentTeacher = (Teacher) instancia.getTManager().getAllTeachers()
					.get(i);
			comboBox.addItem(currentTeacher);
		}
	}

	private void RellenarComboBoxAlumnos() {
		for (int i = 0; i < instancia.getSManager().getAllStudents().size(); i++) {
			currentStudent = (Student) instancia.getSManager().getAllStudents()
					.get(i);
			comboBox_1.addItem(currentStudent);
		}
	}
}
