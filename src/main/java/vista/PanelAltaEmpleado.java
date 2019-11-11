package vista;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PanelAltaEmpleado extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7L;

	public JLabel lblTituloAltaEmple, lblNCodigoEmple, lblNombreEmple, lblSueldo, lblDepart, lblCargo, lblesJefe,
			lblJefeAsignado;
	public JTextField txtCodEmple, txtNombreEmple, txtSueldo;
	public JComboBox<String> cmbCargos, cmbDptos, cmbJefe, cmbResponsable;
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
		lblNCodigoEmple.setBounds(150, 50, 150, 30);
		add(lblNCodigoEmple);

		lblNombreEmple = new JLabel("Nombre:");
		lblNombreEmple.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombreEmple.setBounds(150, 100, 150, 30);
		add(lblNombreEmple);

		lblSueldo = new JLabel("Sueldo:");
		lblSueldo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSueldo.setHorizontalAlignment(SwingConstants.LEFT);
		lblSueldo.setBounds(150, 150, 150, 30);
		add(lblSueldo);

		lblDepart = new JLabel("Departamento:");
		lblDepart.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDepart.setHorizontalAlignment(SwingConstants.LEFT);
		lblDepart.setBounds(150, 200, 150, 30);
		add(lblDepart);

		lblCargo = new JLabel("Cargo:");
		lblCargo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCargo.setHorizontalAlignment(SwingConstants.LEFT);
		lblCargo.setBounds(150, 250, 150, 30);
		add(lblCargo);

		lblesJefe = new JLabel("\u00BFEs jefe?");
		lblesJefe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblesJefe.setHorizontalAlignment(SwingConstants.LEFT);
		lblesJefe.setBounds(120, 300, 90, 30);
		add(lblesJefe);

		lblJefeAsignado = new JLabel("Jefe asignado:");
		lblJefeAsignado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblJefeAsignado.setHorizontalAlignment(SwingConstants.LEFT);
		lblJefeAsignado.setBounds(330, 300, 120, 30);
		add(lblJefeAsignado);

		// ComboBoxs

		cmbDptos = new JComboBox<String>();
		cmbDptos.setBounds(330, 200, 150, 30);
		add(cmbDptos);

		cmbJefe = new JComboBox<String>();
		cmbJefe.setBounds(218, 300, 50, 30);
		cmbJefe.addItem("SI");
		cmbJefe.addItem("NO");
		add(cmbJefe);

		cmbResponsable = new JComboBox<String>();
		cmbResponsable.setBounds(460, 300, 250, 30);
		add(cmbResponsable);

		cmbCargos = new JComboBox<String>();
		cmbCargos.setBounds(330, 250, 150, 30);
		add(cmbCargos);

		// TextFields

		txtCodEmple = new JTextField();
		txtCodEmple.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCodEmple.setBounds(330, 50, 150, 30);
		add(txtCodEmple);
		txtCodEmple.setColumns(10);

		txtNombreEmple = new JTextField();
		txtNombreEmple.setColumns(10);
		txtNombreEmple.setBounds(330, 100, 250, 30);
		add(txtNombreEmple);

		txtSueldo = new JTextField();
		txtSueldo.setColumns(10);
		txtSueldo.setBounds(330, 150, 150, 30);
		add(txtSueldo);

		// Buttons

		btnAlta = new JButton("Dar de alta empleado");
		btnAlta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAlta.setBounds(300, 360, 200, 30);
		btnAlta.setActionCommand("alta");
		add(btnAlta);
		instanciarObjetos();

	}

	private void instanciarObjetos() {

	}
}
