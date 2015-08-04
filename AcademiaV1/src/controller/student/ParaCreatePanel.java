package controller.student;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.student.Student;
import model.student.StudentManager;
import model.student.StudentManagerIMPL;
import view.student.CreatePanel;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ParaCreatePanel extends CreatePanel {

	StudentManager instancia;
	Student currentStudent;
	public ParaCreatePanel(StudentManager student) {
		this.instancia = student;
		eventos();
	}

	private void eventos() {
		btnCrearAlumno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comprobarCampos()) {
					currentStudent = instancia.createStudent(txtDNI.getText(),
							txtNombre.getText(), txtApellidos.getText());
					currentStudent.setBornDate(dateChooser.getDate());
					currentStudent.setComments(txtObservaciones.getText());
					instancia.updateStudent(currentStudent);
					if (currentStudent != null) {
						JOptionPane.showMessageDialog(null,
								"El alumno ha sido introducido correctamente",
								"Exito", JOptionPane.INFORMATION_MESSAGE);
						vaciarCampos();
					} else {
						JOptionPane.showMessageDialog(null, "ERROR", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null,
							"No puedes dejar un campo en blanco", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}

		});
	}

	private boolean comprobarCampos() {
		if (txtNombre.getText().isEmpty() && txtApellidos.getText().isEmpty()
				&& txtDNI.getText().isEmpty()
				&& txtObservaciones.getText().isEmpty()
				&& dateChooser.getDate() != null
				&& dateChooser.getDate().toString().isEmpty()) {
			return false;
		} else {
			return true;
		}
	}
	private void vaciarCampos() {
		txtNombre.setText("");
		txtApellidos.setText("");
		txtDNI.setText("");
		txtObservaciones.setText("");
		dateChooser.setDate(null);
	}
}
