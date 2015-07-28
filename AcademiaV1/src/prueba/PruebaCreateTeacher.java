package prueba;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.StudentManager;
import model.StudentManagerIMPL;
import model.TeacherManager;
import model.TeacherManagerIMPL;
import controller.ParaCreatePanel;
import controller.ParaCreateTeacher;

public class PruebaCreateTeacher extends JFrame {

	private ParaCreateTeacher contentPane;
	TeacherManager nuevo=new TeacherManagerIMPL();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PruebaCreateTeacher frame = new PruebaCreateTeacher();
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
	public PruebaCreateTeacher() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new ParaCreateTeacher(nuevo);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
	}

}
