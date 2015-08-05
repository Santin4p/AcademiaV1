package controller.group;

import javax.swing.ComboBoxModel;
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
import view.group.DeleteGroup;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class ParaDeleteGroup extends DeleteGroup {
	GroupManager instanciaGrupo;
	Group currentGroup;
	Teacher currentTeacher;
	Student currentStudent;
	DefaultTableModel modelo;

	public ParaDeleteGroup(GroupManager groupM) {
		// Meter asignacion dentro de los constructores
		modelo = (DefaultTableModel) table.getModel();
		this.instanciaGrupo = groupM;
		RellenarComboBoxProfesor();
		eventos();
	}

	private void eventos() {
		comboProfesor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultComboBoxModel model = (DefaultComboBoxModel) comboGroup
						.getModel();
				model.removeAllElements();
				borrarTabla();
				RellenarComboBoxGrupos();
			}
		});

		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				instanciaGrupo.deleteGroup((Group) comboGroup.getSelectedItem());
				borrarTabla();
			}
		});

		comboGroup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrarTabla();
				currentGroup = (Group) comboGroup.getSelectedItem();
				if (currentGroup!=null) {
					List<Student> nueva=instanciaGrupo.getStudentsFromGroup(currentGroup);
					for (Student student : nueva ) {
						Object[] data = {student.getDni(), student.getName(),student.getSurname()};
						modelo.addRow(data);
					}
				}
			}
		});
	}

	private void RellenarComboBoxProfesor() {
		for (int i = 0; i < instanciaGrupo.getTManager().getAllTeachers()
				.size(); i++) {
			currentTeacher = (Teacher) instanciaGrupo.getTManager()
					.getAllTeachers().get(i);
			comboProfesor.addItem(currentTeacher);
		}
	}

	private void RellenarComboBoxGrupos() {
		List<Group> lista = instanciaGrupo
				.getAllGroupsByTeacher((Teacher) comboProfesor
						.getSelectedItem());
		for (int i = 0; i < lista.size(); i++) {
			currentGroup = lista.get(i);
			comboGroup.addItem(currentGroup);
		}
	}
	private void borrarTabla() {
		if (modelo.getRowCount()>0) {
			modelo.removeRow(modelo.getRowCount()-1);
		}
	}
}
