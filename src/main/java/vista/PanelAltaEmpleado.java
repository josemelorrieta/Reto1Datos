package vista;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JComboBox;

public class PanelAltaEmpleado extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public  JLabel lblTituloAltaEmple, lblNCodigoEmple,lblNombreEmple, lblApellidosEmple,lblSueldo, lblDepart, lblCargo, lblesJefe, lblJefeAsignado ;
	public JTextField txtCodEmple,txtNombreEmple, txtApellidosEmple, txtSueldo, txtCargo;
	public JComboBox comboBoxDepartamentos, comboBoxJefeSiNo, comboBoxJefeAsignado;
	public JButton btnNewButton;


	/**
	 * Create the panel.
	 */
	public PanelAltaEmpleado() {
		setPreferredSize(new Dimension(800, 520));
		setLayout(null);
		
		lblTituloAltaEmple = new JLabel("FORMULARIO ALTA EMPLEADOS");
		lblTituloAltaEmple.setBounds(287, 26, 167, 36);
		add(lblTituloAltaEmple);
		
		lblNCodigoEmple = new JLabel("C\u00F3digo de empleado:");
		lblNCodigoEmple.setBounds(150, 100, 118, 14);
		add(lblNCodigoEmple);
		
		lblNombreEmple = new JLabel("Nombre:");
		lblNombreEmple.setBounds(150, 150, 118, 14);
		add(lblNombreEmple);
		
		lblApellidosEmple = new JLabel("Apellidos:");
		lblApellidosEmple.setBounds(150, 200, 118, 14);
		add(lblApellidosEmple);
		
		lblSueldo = new JLabel("Sueldo:");
		lblSueldo.setHorizontalAlignment(SwingConstants.LEFT);
		lblSueldo.setBounds(150, 250, 118, 14);
		add(lblSueldo);
		
		lblDepart = new JLabel("Departamento:");
		lblDepart.setHorizontalAlignment(SwingConstants.LEFT);
		lblDepart.setBounds(150, 300, 118, 14);
		add(lblDepart);
		
		lblCargo = new JLabel("Cargo:");
		lblCargo.setHorizontalAlignment(SwingConstants.LEFT);
		lblCargo.setBounds(150, 350, 118, 14);
		add(lblCargo);
		
		lblesJefe = new JLabel("\u00BFEs jefe?");
		lblesJefe.setHorizontalAlignment(SwingConstants.LEFT);
		lblesJefe.setBounds(150, 400, 118, 14);
		add(lblesJefe);
		
		lblJefeAsignado = new JLabel("Jefe asignado:");
		lblJefeAsignado.setHorizontalAlignment(SwingConstants.LEFT);
		lblJefeAsignado.setBounds(150, 450, 118, 14);
		add(lblJefeAsignado);
		
		//ComboBoxs
		
		comboBoxDepartamentos = new JComboBox();
		comboBoxDepartamentos.setBounds(300, 300, 150, 20);
		add(comboBoxDepartamentos);
		
		comboBoxJefeSiNo = new JComboBox();
		comboBoxJefeSiNo.setBounds(300, 394, 150, 20);
		add(comboBoxJefeSiNo);
		
		comboBoxJefeAsignado = new JComboBox();
		comboBoxJefeAsignado.setBounds(300, 444, 150, 20);
		add(comboBoxJefeAsignado);
		
		//TextFields
		
		txtCodEmple = new JTextField();
		txtCodEmple.setBounds(300, 100, 150, 20);
		add(txtCodEmple);
		txtCodEmple.setColumns(10);
		
		txtNombreEmple = new JTextField();
		txtNombreEmple.setColumns(10);
		txtNombreEmple.setBounds(300, 150, 150, 20);
		add(txtNombreEmple);
		
		txtApellidosEmple = new JTextField();
		txtApellidosEmple.setColumns(10);
		txtApellidosEmple.setBounds(300, 200, 150, 20);
		add(txtApellidosEmple);
		
		txtSueldo = new JTextField();
		txtSueldo.setColumns(10);
		txtSueldo.setBounds(300, 250, 150, 20);
		add(txtSueldo);
		
		txtCargo = new JTextField();
		txtCargo.setColumns(10);
		txtCargo.setBounds(300, 350, 150, 20);
		add(txtCargo);
		
		//Buttons
		
		btnNewButton = new JButton("Dar de alta empleado");
		btnNewButton.setBounds(287, 486, 176, 23);
		add(btnNewButton);
		instanciarObjetos();
		
		
	}
	
	private void instanciarObjetos() {
		
	}
}
