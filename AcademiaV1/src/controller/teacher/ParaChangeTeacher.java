package controller.teacher;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.student.Student;
import model.student.StudentManager;
import model.student.StudentManagerIMPL;
import model.teacher.Teacher;
import model.teacher.TeacherManager;
import view.student.ChangePanel;
import view.teacher.ChangePanelTeacher;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ParaChangeTeacher extends ChangePanelTeacher {

	TeacherManager instancia;
	Teacher currentTeacher;

	public ParaChangeTeacher(TeacherManager teacher) {
		this.instancia = teacher;
		eventos();
	}

	private void eventos() {
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					currentTeacher.setName(txtNombre.getText());
					currentTeacher.setSurname(txtApellidos.getText());
					currentTeacher.setDni(txtDNI.getText());
					instancia.updateTeacher(currentTeacher);
					JOptionPane.showMessageDialog(null, "Profesor modificado",
							"Exito", JOptionPane.INFORMATION_MESSAGE);
					vaciarCampos();
			}
		});

		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat prueba = new SimpleDateFormat("dd-MMM-yyyy");
				currentTeacher = instancia.getTeacher(Integer
						.parseInt(txtBuscarAlumno.getText()));
				if (currentTeacher != null) {
					txtNombre.setText(currentTeacher.getName());
					txtApellidos.setText(currentTeacher.getSurname());
					txtDNI.setText(currentTeacher.getDni());
					txtFechaNacimiento.setText(prueba.format(currentTeacher
							.getBornDate()));
					spinner.setValue(currentTeacher.getSueldo());
					lblID.setText(String.valueOf(currentTeacher.getId()));
				} else {
					JOptionPane.showMessageDialog(null,
							"ERROR, profesor no encontrado", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}



	private void vaciarCampos() {
		txtNombre.setText("");
		txtApellidos.setText("");
		txtDNI.setText("");
		txtFechaNacimiento.setText("");
		lblID.setText("");
		txtBuscarAlumno.setText("");
	}
}
