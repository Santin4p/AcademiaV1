package controller.teacher;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.teacher.Teacher;
import model.teacher.TeacherManager;
import view.teacher.CreatePanelTeacher;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.SpinnerNumberModel;

public class ParaCreateTeacher extends CreatePanelTeacher {

	TeacherManager instancia;
	Teacher currentTeacher;

	/**
	 * Create the panel.
	 */

	public ParaCreateTeacher(TeacherManager instancia) {
		this.instancia=instancia;
		eventos();
	}

	private void eventos() {
		btnCrearAlumno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!comprobarCampos()) {
					currentTeacher = instancia.createTeacher(txtDNI.getText(), txtNombre.getText(), txtApellidos.getText());
					currentTeacher.setBornDate(dateChooser.getDate());
					currentTeacher.setSueldo((Float)spinner.getValue());
					instancia.updateTeacher(currentTeacher);
					if (currentTeacher != null) {
						JOptionPane.showMessageDialog(null,
								"El profesor ha sido introducido correctamente",
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
				&& dateChooser.getDate().toString().isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	private void vaciarCampos() {
		txtNombre.setText("");
		txtApellidos.setText("");
		txtDNI.setText("");
		dateChooser.setDate(null);
		spinner.setValue(550f);
	}
}
