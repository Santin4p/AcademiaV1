package controller;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.Student;
import model.StudentManager;
import model.StudentManagerIMPL;
import view.ChangePanel;
import view.DeletePanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ParaDeletePanel extends DeletePanel {

	StudentManager instancia;
	Student currentStudent;

	public ParaDeletePanel(StudentManager student) {
		this.instancia = student;
		RellenarComboBox();
		eventos();
	}

	private void eventos() {
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Borrado con exito",
						"Exito", JOptionPane.INFORMATION_MESSAGE);
				instancia.deleteStudent((Student) comboBox.getSelectedItem());
			}
		});
	}

	private void RellenarComboBox() {
		for (int i = 0; i < instancia.getAllStudents().size(); i++) {
			currentStudent = (Student) instancia.getAllStudents().get(i);
			comboBox.addItem(currentStudent);
		}
	}
}
