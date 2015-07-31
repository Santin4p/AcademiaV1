package prueba.teacher;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.student.StudentManager;
import model.student.StudentManagerIMPL;
import model.teacher.TeacherManager;
import model.teacher.TeacherManagerIMPL;
import controller.student.ParaCreatePanel;
import controller.teacher.ParaChangeTeacher;
import controller.teacher.ParaCheckTeacher;
import controller.teacher.ParaCreateTeacher;

public class PruebaCheckTeacher extends JFrame {

	private ParaCheckTeacher contentPane;
	TeacherManager nuevo=new TeacherManagerIMPL();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PruebaCheckTeacher frame = new PruebaCheckTeacher();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PruebaCheckTeacher() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new ParaCheckTeacher(nuevo);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
	}

}
