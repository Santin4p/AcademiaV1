package view.group;

import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DeleteGroup extends JPanel {
	protected JTable table;
	protected JLabel lblNewLabel;
	protected JComboBox comboProfesor;
	protected JLabel lblGrupo;
	protected JComboBox comboGroup;
	protected JScrollPane scrollPane;
	protected JButton btnBorrar;

	/**
	 * Create the panel.
	 */
	public DeleteGroup() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 72, 342, 77, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 57, 180, 39, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		lblNewLabel = new JLabel("Profesor:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);
		
		comboProfesor = new JComboBox();
		GridBagConstraints gbc_comboProfesor = new GridBagConstraints();
		gbc_comboProfesor.gridwidth = 2;
		gbc_comboProfesor.insets = new Insets(0, 0, 5, 5);
		gbc_comboProfesor.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboProfesor.gridx = 2;
		gbc_comboProfesor.gridy = 1;
		add(comboProfesor, gbc_comboProfesor);
		
		lblGrupo = new JLabel("Grupo:");
		GridBagConstraints gbc_lblGrupo = new GridBagConstraints();
		gbc_lblGrupo.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblGrupo.insets = new Insets(0, 0, 5, 5);
		gbc_lblGrupo.gridx = 1;
		gbc_lblGrupo.gridy = 2;
		add(lblGrupo, gbc_lblGrupo);
		
		comboGroup = new JComboBox();
		GridBagConstraints gbc_comboGroup = new GridBagConstraints();
		gbc_comboGroup.gridwidth = 2;
		gbc_comboGroup.anchor = GridBagConstraints.SOUTH;
		gbc_comboGroup.insets = new Insets(0, 0, 5, 5);
		gbc_comboGroup.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboGroup.gridx = 2;
		gbc_comboGroup.gridy = 2;
		add(comboGroup, gbc_comboGroup);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 3;
		add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		String[] columnas = {"DNI","Nombre","Apellidos"};
		table.setModel(new DefaultTableModel(columnas, 0));
		
		btnBorrar = new JButton("Borrar");
		GridBagConstraints gbc_btnBorrar = new GridBagConstraints();
		gbc_btnBorrar.anchor = GridBagConstraints.EAST;
		gbc_btnBorrar.insets = new Insets(0, 0, 0, 5);
		gbc_btnBorrar.gridx = 3;
		gbc_btnBorrar.gridy = 4;
		add(btnBorrar, gbc_btnBorrar);
	}

}
