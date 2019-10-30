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
	private static final long serialVersionUID = 7L;
	
	public  JLabel lblTituloAltaEmple, lblNCodigoEmple,lblNombreEmple,lblSueldo, lblDepart, lblCargo, lblesJefe, lblJefeAsignado ;
	public JTextField txtCodEmple,txtNombreEmple, txtSueldo, txtCargo;
	public JComboBox comboBoxDepartamentos, comboBoxJefeSiNo, comboBoxJefeAsignado;
	public JButton btnAlta;


	/**
	 * Create the panel.
	 */
	public PanelAltaEmpleado() {
		setPreferredSize(new Dimension(800, 440));
		setLayout(null);
		
		lblTituloAltaEmple = new JLabel("FORMULARIO ALTA EMPLEADOS");
		lblTituloAltaEmple.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloAltaEmple.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTituloAltaEmple.setBounds(0, 0, 800, 36);
		add(lblTituloAltaEmple);
		
		lblNCodigoEmple = new JLabel("DNI");
		lblNCodigoEmple.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNCodigoEmple.setBounds(150, 80, 150, 30);
		add(lblNCodigoEmple);
		
		lblNombreEmple = new JLabel("Nombre:");
		lblNombreEmple.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombreEmple.setBounds(150, 90, 150, 30);
		add(lblNombreEmple);
		
		lblSueldo = new JLabel("Sueldo:");
		lblSueldo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSueldo.setHorizontalAlignment(SwingConstants.LEFT);
		lblSueldo.setBounds(150, 190, 150, 30);
		add(lblSueldo);
		
		lblDepart = new JLabel("Departamento:");
		lblDepart.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDepart.setHorizontalAlignment(SwingConstants.LEFT);
		lblDepart.setBounds(150, 240, 150, 30);
		add(lblDepart);
		
		lblCargo = new JLabel("Cargo:");
		lblCargo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCargo.setHorizontalAlignment(SwingConstants.LEFT);
		lblCargo.setBounds(150, 290, 150, 30);
		add(lblCargo);
		
		lblesJefe = new JLabel("\u00BFEs jefe?");
		lblesJefe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblesJefe.setHorizontalAlignment(SwingConstants.LEFT);
		lblesJefe.setBounds(209, 342, 118, 14);
		add(lblesJefe);
		
		lblJefeAsignado = new JLabel("Jefe asignado:");
		lblJefeAsignado.setFont(new Font("Tahoma", Font.PLAIN, 14));
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
		txtCodEmple.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCodEmple.setBounds(330, 40, 150, 30);
		add(txtCodEmple);
		txtCodEmple.setColumns(10);
		
		txtNombreEmple = new JTextField();
		txtNombreEmple.setColumns(10);
		txtNombreEmple.setBounds(330, 90, 250, 30);
		add(txtNombreEmple);
		
		txtSueldo = new JTextField();
		txtSueldo.setColumns(10);
		txtSueldo.setBounds(359, 192, 150, 20);
		add(txtSueldo);
		
		txtCargo = new JTextField();
		txtCargo.setColumns(10);
		txtCargo.setBounds(359, 292, 150, 20);
		add(txtCargo);
		
		//Buttons
		
		btnAlta = new JButton("Dar de alta empleado");
		btnAlta.setBounds(283, 388, 176, 23);
		btnAlta.setActionCommand("alta");
		add(btnAlta);
		instanciarObjetos();
		
		
	}
	
	private void instanciarObjetos() {
		
	}
}
