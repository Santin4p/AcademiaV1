package view;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

import com.toedter.calendar.JDateChooser;

public class CreatePanel extends JPanel {
	protected JTextField txtNombre;
	protected JTextField txtApellidos;
	protected JLabel lblObservaciones;
	protected JLabel lblDNI;
	protected JLabel lblNombre;
	protected JLabel lblNuevos;
	protected JLabel lblApellidos;
	protected JLabel lblFechaNacimiento;
	protected JTextField txtDNI;
	protected JTextField txtObservaciones;
	protected JButton btnCrearAlumno;
	protected JDateChooser dateChooser;

	/**
	 * Create the panel.
	 */
	public CreatePanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 123, 92, 0, 74, 71, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 88, 88, 0, 0, 41, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		lblNuevos = new JLabel("Crear nuevo alumno");
		lblNuevos.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblNuevos = new GridBagConstraints();
		gbc_lblNuevos.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNuevos.insets = new Insets(0, 0, 5, 5);
		gbc_lblNuevos.gridx = 1;
		gbc_lblNuevos.gridy = 1;
		add(lblNuevos, gbc_lblNuevos);
		
		lblNombre = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 2;
		add(lblNombre, gbc_lblNombre);
		
		txtNombre = new JTextField();
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.anchor = GridBagConstraints.SOUTH;
		gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.gridx = 2;
		gbc_txtNombre.gridy = 2;
		add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);
		
		lblApellidos = new JLabel("Apellidos:");
		GridBagConstraints gbc_lblApellidos = new GridBagConstraints();
		gbc_lblApellidos.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellidos.gridx = 4;
		gbc_lblApellidos.gridy = 2;
		add(lblApellidos, gbc_lblApellidos);
		
		txtApellidos = new JTextField();
		GridBagConstraints gbc_txtApellidos = new GridBagConstraints();
		gbc_txtApellidos.anchor = GridBagConstraints.SOUTH;
		gbc_txtApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_txtApellidos.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtApellidos.gridx = 5;
		gbc_txtApellidos.gridy = 2;
		add(txtApellidos, gbc_txtApellidos);
		txtApellidos.setColumns(10);
		
		lblFechaNacimiento = new JLabel("Fecha de nacimiento:");
		lblFechaNacimiento.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblFechaNacimiento = new GridBagConstraints();
		gbc_lblFechaNacimiento.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaNacimiento.anchor = GridBagConstraints.WEST;
		gbc_lblFechaNacimiento.gridx = 1;
		gbc_lblFechaNacimiento.gridy = 3;
		add(lblFechaNacimiento, gbc_lblFechaNacimiento);
		
		dateChooser = new JDateChooser();
		GridBagConstraints gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooser.fill = GridBagConstraints.HORIZONTAL;
		gbc_dateChooser.gridx = 2;
		gbc_dateChooser.gridy = 3;
		add(dateChooser, gbc_dateChooser);
		
		lblDNI = new JLabel("DNI:");
		GridBagConstraints gbc_lblDNI = new GridBagConstraints();
		gbc_lblDNI.insets = new Insets(0, 0, 5, 5);
		gbc_lblDNI.anchor = GridBagConstraints.WEST;
		gbc_lblDNI.gridx = 4;
		gbc_lblDNI.gridy = 3;
		add(lblDNI, gbc_lblDNI);
		
		txtDNI = new JTextField();
		GridBagConstraints gbc_txtDNI = new GridBagConstraints();
		gbc_txtDNI.insets = new Insets(0, 0, 5, 5);
		gbc_txtDNI.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDNI.gridx = 5;
		gbc_txtDNI.gridy = 3;
		add(txtDNI, gbc_txtDNI);
		txtDNI.setColumns(10);
		
		lblObservaciones = new JLabel("Observaciones:");
		GridBagConstraints gbc_lblObservaciones = new GridBagConstraints();
		gbc_lblObservaciones.gridheight = 2;
		gbc_lblObservaciones.anchor = GridBagConstraints.WEST;
		gbc_lblObservaciones.insets = new Insets(0, 0, 5, 5);
		gbc_lblObservaciones.gridx = 1;
		gbc_lblObservaciones.gridy = 4;
		add(lblObservaciones, gbc_lblObservaciones);
		
		txtObservaciones = new JTextField();
		GridBagConstraints gbc_txtObservaciones = new GridBagConstraints();
		gbc_txtObservaciones.gridheight = 2;
		gbc_txtObservaciones.gridwidth = 4;
		gbc_txtObservaciones.insets = new Insets(0, 0, 5, 5);
		gbc_txtObservaciones.fill = GridBagConstraints.BOTH;
		gbc_txtObservaciones.gridx = 2;
		gbc_txtObservaciones.gridy = 4;
		add(txtObservaciones, gbc_txtObservaciones);
		txtObservaciones.setColumns(10);
		
		btnCrearAlumno = new JButton("Crear Alumno");
		GridBagConstraints gbc_btnCrearAlumno = new GridBagConstraints();
		gbc_btnCrearAlumno.anchor = GridBagConstraints.SOUTHEAST;
		gbc_btnCrearAlumno.insets = new Insets(0, 0, 5, 5);
		gbc_btnCrearAlumno.gridx = 5;
		gbc_btnCrearAlumno.gridy = 6;
		add(btnCrearAlumno, gbc_btnCrearAlumno);
	}

}
