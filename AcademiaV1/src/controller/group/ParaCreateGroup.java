package controller.group;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
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
import java.util.ArrayList;
import java.util.List;

public class ParaCreateGroup extends CreateGroup {
	GroupManager instancia;
	Group currentGroup;
	Student currentStudent;
	Teacher currentTeacher;
	DefaultTableModel modelo;

	public ParaCreateGroup(GroupManager groupM) {
		// Meter asignacion dentro de los constructores
		modelo = (DefaultTableModel) table.getModel();
		this.instancia = groupM;
		RellenarComboBoxProfesor();
		RellenarComboBoxAlumnos();
		eventos();
	}

	private void eventos() {
		// Boton añadir
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comprobarAlumnos()) {
					currentStudent = (Student) comboBox_1.getSelectedItem();
					Object[] data = { currentStudent.getDni(),
							currentStudent.getName(),
							currentStudent.getSurname() };
					modelo.addRow(data);
				} else {
					JOptionPane.showMessageDialog(null, "Error, alumno repetido en la tabla",
							"Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		// Boton remover
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Para quitar desde el combobox
				// currentStudent=(Student) comboBox_1.getSelectedItem();
				// for (int i = 0; i < table.getRowCount(); i++) {
				// if (table.getValueAt(i, 0).equals(currentStudent.getDni())) {
				// modelo.removeRow(i);
				// }
				// }
				modelo.removeRow(table.getSelectedRow());
			}
		});

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Student> listS = new ArrayList<Student>();
				for (int i = 0; i < table.getRowCount(); i++) {
					currentStudent = instancia.getSManager().getStudent(
							(String) table.getValueAt(i, 0));
					listS.add(currentStudent);
				}
				if (instancia.createGroup(textField.getText(),
						(Teacher) comboBox.getSelectedItem(), listS) != null) {
					JOptionPane.showMessageDialog(null, "Creado con exito",
							"Exito", JOptionPane.INFORMATION_MESSAGE);
				}
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

	private boolean comprobarAlumnos() {
		currentStudent = (Student) comboBox_1.getSelectedItem();
		for (int i = 0; i < table.getRowCount(); i++) {
			if (table.getValueAt(i, 0).equals(currentStudent.getDni())) {
				return false;
			}
		}
		return true;
	}
}
