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
		setPreferredSize(new Dimension(800, 440));
		setLayout(null);
		
		lblTituloAltaEmple = new JLabel("FORMULARIO ALTA EMPLEADOS");
		lblTituloAltaEmple.setBounds(283, 0, 167, 36);
		add(lblTituloAltaEmple);
		
		lblNCodigoEmple = new JLabel("C\u00F3digo de empleado:");
		lblNCodigoEmple.setBounds(209, 42, 118, 14);
		add(lblNCodigoEmple);
		
		lblNombreEmple = new JLabel("Nombre:");
		lblNombreEmple.setBounds(209, 92, 118, 14);
		add(lblNombreEmple);
		
		lblApellidosEmple = new JLabel("Apellidos:");
		lblApellidosEmple.setBounds(209, 142, 118, 14);
		add(lblApellidosEmple);
		
		lblSueldo = new JLabel("Sueldo:");
		lblSueldo.setHorizontalAlignment(SwingConstants.LEFT);
		lblSueldo.setBounds(209, 192, 118, 14);
		add(lblSueldo);
		
		lblDepart = new JLabel("Departamento:");
		lblDepart.setHorizontalAlignment(SwingConstants.LEFT);
		lblDepart.setBounds(209, 242, 118, 14);
		add(lblDepart);
		
		lblCargo = new JLabel("Cargo:");
		lblCargo.setHorizontalAlignment(SwingConstants.LEFT);
		lblCargo.setBounds(209, 292, 118, 14);
		add(lblCargo);
		
		lblesJefe = new JLabel("\u00BFEs jefe?");
		lblesJefe.setHorizontalAlignment(SwingConstants.LEFT);
		lblesJefe.setBounds(209, 342, 118, 14);
		add(lblesJefe);
		
		lblJefeAsignado = new JLabel("Jefe asignado:");
		lblJefeAsignado.setHorizontalAlignment(SwingConstants.LEFT);
		lblJefeAsignado.setBounds(536, 342, 118, 14);
		add(lblJefeAsignado);
		
		//ComboBoxs
		
		comboBoxDepartamentos = new JComboBox();
		comboBoxDepartamentos.setBounds(359, 242, 150, 20);
		add(comboBoxDepartamentos);
		
		comboBoxJefeSiNo = new JComboBox();
		comboBoxJefeSiNo.setBounds(359, 336, 150, 20);
		add(comboBoxJefeSiNo);
		
		comboBoxJefeAsignado = new JComboBox();
		comboBoxJefeAsignado.setBounds(617, 339, 150, 20);
		add(comboBoxJefeAsignado);
		
		//TextFields
		
		txtCodEmple = new JTextField();
		txtCodEmple.setBounds(359, 42, 150, 20);
		add(txtCodEmple);
		txtCodEmple.setColumns(10);
		
		txtNombreEmple = new JTextField();
		txtNombreEmple.setColumns(10);
		txtNombreEmple.setBounds(359, 92, 150, 20);
		add(txtNombreEmple);
		
		txtApellidosEmple = new JTextField();
		txtApellidosEmple.setColumns(10);
		txtApellidosEmple.setBounds(359, 142, 150, 20);
		add(txtApellidosEmple);
		
		txtSueldo = new JTextField();
		txtSueldo.setColumns(10);
		txtSueldo.setBounds(359, 192, 150, 20);
		add(txtSueldo);
		
		txtCargo = new JTextField();
		txtCargo.setColumns(10);
		txtCargo.setBounds(359, 292, 150, 20);
		add(txtCargo);
		
		//Buttons
		
		btnNewButton = new JButton("Dar de alta empleado");
		btnNewButton.setBounds(283, 388, 176, 23);
		add(btnNewButton);
		instanciarObjetos();
		
		
	}
	
	private void instanciarObjetos() {
		
	}
}
