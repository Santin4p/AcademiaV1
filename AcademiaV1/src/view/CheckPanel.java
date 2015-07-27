package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class CheckPanel extends JPanel {
	protected JTextField txtNombre;
	protected JTextField txtApellidos;
	protected JLabel lblObservaciones;
	protected JLabel lblDNI;
	protected JLabel lblNombre;
	protected JLabel lblModificar;
	protected JLabel lblApellidos;
	protected JLabel lblFechaNacimiento;
	protected JTextField txtFechaNacimiento;
	protected JTextField txtDNI;
	protected JTextField txtObservaciones;
	protected JLabel lblAlumno;
	protected JComboBox comboBox;

	/**
	 * Create the panel.
	 */
	
	public CheckPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 122, 92, 0, 74, 71, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 58, 62, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		lblModificar = new JLabel("Consultar alumno");
		lblModificar.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblModificar = new GridBagConstraints();
		gbc_lblModificar.anchor = GridBagConstraints.SOUTH;
		gbc_lblModificar.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblModificar.insets = new Insets(0, 0, 5, 5);
		gbc_lblModificar.gridx = 1;
		gbc_lblModificar.gridy = 0;
		add(lblModificar, gbc_lblModificar);
		
		lblAlumno = new JLabel("Alumno:");
		GridBagConstraints gbc_lblAlumno = new GridBagConstraints();
		gbc_lblAlumno.anchor = GridBagConstraints.WEST;
		gbc_lblAlumno.insets = new Insets(0, 0, 5, 5);
		gbc_lblAlumno.gridx = 1;
		gbc_lblAlumno.gridy = 2;
		add(lblAlumno, gbc_lblAlumno);
		
		comboBox = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 4;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 2;
		add(comboBox, gbc_comboBox);
		
		lblNombre = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.WEST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 3;
		add(lblNombre, gbc_lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.gridx = 2;
		gbc_txtNombre.gridy = 3;
		add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);
		
		lblApellidos = new JLabel("Apellidos:");
		GridBagConstraints gbc_lblApellidos = new GridBagConstraints();
		gbc_lblApellidos.anchor = GridBagConstraints.WEST;
		gbc_lblApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellidos.gridx = 4;
		gbc_lblApellidos.gridy = 3;
		add(lblApellidos, gbc_lblApellidos);
		
		txtApellidos = new JTextField();
		txtApellidos.setEditable(false);
		GridBagConstraints gbc_txtApellidos = new GridBagConstraints();
		gbc_txtApellidos.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_txtApellidos.gridx = 5;
		gbc_txtApellidos.gridy = 3;
		add(txtApellidos, gbc_txtApellidos);
		txtApellidos.setColumns(10);
		
		lblFechaNacimiento = new JLabel("Fecha de nacimiento:");
		lblFechaNacimiento.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblFechaNacimiento = new GridBagConstraints();
		gbc_lblFechaNacimiento.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaNacimiento.anchor = GridBagConstraints.WEST;
		gbc_lblFechaNacimiento.gridx = 1;
		gbc_lblFechaNacimiento.gridy = 4;
		add(lblFechaNacimiento, gbc_lblFechaNacimiento);
		
		txtFechaNacimiento = new JTextField();
		txtFechaNacimiento.setEditable(false);
		GridBagConstraints gbc_txtFechaNacimiento = new GridBagConstraints();
		gbc_txtFechaNacimiento.insets = new Insets(0, 0, 5, 5);
		gbc_txtFechaNacimiento.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFechaNacimiento.gridx = 2;
		gbc_txtFechaNacimiento.gridy = 4;
		add(txtFechaNacimiento, gbc_txtFechaNacimiento);
		txtFechaNacimiento.setColumns(10);
		
		lblDNI = new JLabel("DNI:");
		GridBagConstraints gbc_lblDNI = new GridBagConstraints();
		gbc_lblDNI.insets = new Insets(0, 0, 5, 5);
		gbc_lblDNI.anchor = GridBagConstraints.WEST;
		gbc_lblDNI.gridx = 4;
		gbc_lblDNI.gridy = 4;
		add(lblDNI, gbc_lblDNI);
		
		txtDNI = new JTextField();
		txtDNI.setEditable(false);
		GridBagConstraints gbc_txtDNI = new GridBagConstraints();
		gbc_txtDNI.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDNI.insets = new Insets(0, 0, 5, 5);
		gbc_txtDNI.gridx = 5;
		gbc_txtDNI.gridy = 4;
		add(txtDNI, gbc_txtDNI);
		txtDNI.setColumns(10);
		
		lblObservaciones = new JLabel("Observaciones:");
		GridBagConstraints gbc_lblObservaciones = new GridBagConstraints();
		gbc_lblObservaciones.gridheight = 2;
		gbc_lblObservaciones.anchor = GridBagConstraints.WEST;
		gbc_lblObservaciones.insets = new Insets(0, 0, 5, 5);
		gbc_lblObservaciones.gridx = 1;
		gbc_lblObservaciones.gridy = 5;
		add(lblObservaciones, gbc_lblObservaciones);
		
		txtObservaciones = new JTextField();
		txtObservaciones.setEditable(false);
		GridBagConstraints gbc_txtObservaciones = new GridBagConstraints();
		gbc_txtObservaciones.gridheight = 2;
		gbc_txtObservaciones.gridwidth = 4;
		gbc_txtObservaciones.insets = new Insets(0, 0, 5, 5);
		gbc_txtObservaciones.fill = GridBagConstraints.BOTH;
		gbc_txtObservaciones.gridx = 2;
		gbc_txtObservaciones.gridy = 5;
		add(txtObservaciones, gbc_txtObservaciones);
		txtObservaciones.setColumns(10);
	}

}
