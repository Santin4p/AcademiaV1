package controller.teacher;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.student.Student;
import model.student.StudentManager;
import model.student.StudentManagerIMPL;
import model.teacher.Teacher;
import model.teacher.TeacherManager;
import view.student.CheckPanel;
import view.student.CreatePanel;
import view.teacher.CheckPanelTeacher;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;

public class ParaCheckTeacher extends CheckPanelTeacher {

	TeacherManager instancia;
	Teacher currentTeacher;
	
	public ParaCheckTeacher(TeacherManager teacher) {
		this.instancia = teacher;
		RellenarComboBox();
		eventos();
	
	}

	private void eventos() {
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat prueba=new SimpleDateFormat("dd-MMM-yyyy");
				currentTeacher=(Teacher) comboBox.getSelectedItem();
				txtNombre.setText(currentTeacher.getName());
				txtApellidos.setText(currentTeacher.getSurname());
				txtDNI.setText(currentTeacher.getDni());
				txtFechaNacimiento.setText(prueba.format(currentTeacher.getBornDate()));
				spinner.setValue(currentTeacher.getSueldo());
			}
		});
	}
	private void RellenarComboBox() {
		DefaultComboBoxModel<Student> modelo=(DefaultComboBoxModel<Student>)comboBox.getModel();
		for (int i = 0; i < instancia.getAllTeachers().size(); i++) {
			currentTeacher = (Teacher) instancia.getAllTeachers().get(i);
			comboBox.addItem(currentTeacher);
		}
	}
}
