package prueba.group;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.group.GroupManager;
import model.group.GroupManagerIMPL;
import model.student.StudentManager;
import model.student.StudentManagerIMPL;
import model.teacher.TeacherManager;
import model.teacher.TeacherManagerIMPL;
import controller.group.ParaCreateGroup;
import controller.student.ParaCreatePanel;

public class PruebaCreatePanel extends JFrame {

	private ParaCreateGroup contentPane;
	StudentManager Snew=new StudentManagerIMPL();
	TeacherManager Tnew=new TeacherManagerIMPL();
	GroupManager nuevo=new GroupManagerIMPL(Snew, Tnew);
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PruebaCreatePanel frame = new PruebaCreatePanel();
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
	public PruebaCreatePanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new ParaCreateGroup(nuevo);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
	}

}
