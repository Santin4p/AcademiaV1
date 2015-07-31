package controller.teacher;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.student.Student;
import model.student.StudentManager;
import model.student.StudentManagerIMPL;
import model.teacher.Teacher;
import model.teacher.TeacherManager;
import view.student.ChangePanel;
import view.student.DeletePanel;
import view.teacher.DeletePanelTeacher;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ParaDeleteTeacher extends DeletePanelTeacher {

	TeacherManager instancia;
	Teacher currentTeacher;

	public ParaDeleteTeacher(TeacherManager teacher) {
		this.instancia = teacher;
		RellenarComboBox();
		eventos();
	}

	private void eventos() {
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Borrado con exito",
						"Exito", JOptionPane.INFORMATION_MESSAGE);
				instancia.deleteTeacher((Teacher) comboBox.getSelectedItem());
			}
		});
	}

	private void RellenarComboBox() {
		for (int i = 0; i < instancia.getAllTeachers().size(); i++) {
			currentTeacher = (Teacher) instancia.getAllTeachers().get(i);
			comboBox.addItem(currentTeacher);
		}
	}
}
