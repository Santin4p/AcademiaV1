package controller;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.Student;
import model.StudentManager;
import model.StudentManagerIMPL;
import view.CheckPanel;
import view.CreatePanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;

public class ParaCheckPanel extends CheckPanel {

	StudentManager instancia;
	Student currentStudent;
	
	public ParaCheckPanel(StudentManager student) {
		this.instancia = student;
		RellenarComboBox();
		eventos();
	
	}

	private void eventos() {
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat prueba=new SimpleDateFormat("dd-MMM-yyyy");
				currentStudent=(Student) comboBox.getSelectedItem();
				txtNombre.setText(currentStudent.getName());
				txtApellidos.setText(currentStudent.getSurname());
				txtDNI.setText(currentStudent.getDni());
				txtFechaNacimiento.setText(prueba.format(currentStudent.getBornDate()));
				txtObservaciones.setText(currentStudent.getComments());
			}
		});
	}
	private void RellenarComboBox() {
		DefaultComboBoxModel<Student> modelo=(DefaultComboBoxModel<Student>)comboBox.getModel();
		for (int i = 0; i < instancia.getAllStudents().size(); i++) {
			currentStudent = (Student) instancia.getAllStudents().get(i);
			comboBox.addItem(currentStudent);
		}
	}
}
