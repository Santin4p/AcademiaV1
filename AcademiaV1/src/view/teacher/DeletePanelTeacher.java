package view.teacher;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class DeletePanelTeacher extends JPanel {
	protected JLabel lblNuevos;
	protected JButton btnBorrar;
	protected JLabel lblTeacher;
	protected JComboBox comboBox;

	/**
	 * Create the panel.
	 */
	public DeletePanelTeacher() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 122, 92, 0, 74, 71, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 88, 88, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		lblNuevos = new JLabel("Borrar teacher");
		lblNuevos.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblNuevos = new GridBagConstraints();
		gbc_lblNuevos.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNuevos.insets = new Insets(0, 0, 5, 5);
		gbc_lblNuevos.gridx = 1;
		gbc_lblNuevos.gridy = 1;
		add(lblNuevos, gbc_lblNuevos);
		
		lblTeacher = new JLabel("Teacher:");
		GridBagConstraints gbc_lblTeacher = new GridBagConstraints();
		gbc_lblTeacher.anchor = GridBagConstraints.WEST;
		gbc_lblTeacher.insets = new Insets(0, 0, 5, 5);
		gbc_lblTeacher.gridx = 1;
		gbc_lblTeacher.gridy = 2;
		add(lblTeacher, gbc_lblTeacher);
		
		comboBox = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 4;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 2;
		add(comboBox, gbc_comboBox);
		
		btnBorrar = new JButton("Borrar");
		GridBagConstraints gbc_btnBorrar = new GridBagConstraints();
		gbc_btnBorrar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnBorrar.insets = new Insets(0, 0, 5, 5);
		gbc_btnBorrar.gridx = 5;
		gbc_btnBorrar.gridy = 4;
		add(btnBorrar, gbc_btnBorrar);
	}

}
