package controller;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.Student;
import model.StudentManager;
import model.StudentManagerIMPL;
import view.ChangePanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ParaChangePanel extends ChangePanel {

	StudentManager instancia;
	Student currentStudent;

	public ParaChangePanel(StudentManager student) {
		this.instancia = student;
		eventos();
	}

	private void eventos() {
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					currentStudent.setName(txtNombre.getText());
					currentStudent.setSurname(txtApellidos.getText());
					currentStudent.setDni(txtDNI.getText());
					instancia.updateStudent(currentStudent);
					JOptionPane.showMessageDialog(null, "Alumno modificado",
							"Exito", JOptionPane.INFORMATION_MESSAGE);
					vaciarCampos();
			}
		});

		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat prueba = new SimpleDateFormat("dd-MMM-yyyy");
				currentStudent = instancia.getStudent(Integer
						.parseInt(txtBuscarAlumno.getText()));
				if (currentStudent != null) {
					txtNombre.setText(currentStudent.getName());
					txtApellidos.setText(currentStudent.getSurname());
					txtDNI.setText(currentStudent.getDni());
					txtFechaNacimiento.setText(prueba.format(currentStudent
							.getBornDate()));
					txtObservaciones.setText(currentStudent.getComments());
					lblID.setText(String.valueOf(currentStudent.getId()));
				} else {
					JOptionPane.showMessageDialog(null,
							"ERROR, alumno no encontrado", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}



	private void vaciarCampos() {
		txtNombre.setText("");
		txtApellidos.setText("");
		txtDNI.setText("");
		txtObservaciones.setText("");
		txtFechaNacimiento.setText("");
		lblID.setText("");
		txtBuscarAlumno.setText("");
	}
}
