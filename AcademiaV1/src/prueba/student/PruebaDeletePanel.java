package prueba.student;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.student.StudentManager;
import model.student.StudentManagerIMPL;
import controller.student.ParaCreatePanel;
import controller.student.ParaDeletePanel;

public class PruebaDeletePanel extends JFrame {

	private ParaDeletePanel contentPane;
	StudentManager nuevo=new StudentManagerIMPL();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PruebaDeletePanel frame = new PruebaDeletePanel();
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
	public PruebaDeletePanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new ParaDeletePanel(nuevo);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
	}

}
