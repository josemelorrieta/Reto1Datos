package vista;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JCheckBox;

public class PanelVerEmpleados extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9L;
	
	public  JLabel lblTituloEmple, lblBsquedaDNI, lblBsquedaNombre;
	public JButton btnBuscar;
	public JTextField txtBusqDNI, txtBusqNombre;
	private JLabel lblTituloNombre;
	private JLabel lblTituloSueldo;
	private JLabel lblTituloCargo;
	private JLabel lblTituloDepartamento;
	private JLabel lblTituloResponsable;

	/**
	 * Create the panel.
	 */
	public PanelVerEmpleados() {
		setPreferredSize(new Dimension(800, 440));
		setLayout(null);
		
		lblTituloEmple = new JLabel("BUSCAR EMPLEADOS");
		lblTituloEmple.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloEmple.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTituloEmple.setBounds(0, 11, 800, 36);
		add(lblTituloEmple);
		instanciarObjetos();
		
		btnBuscar = new JButton("Buscar empleado");
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscar.setBounds(65, 300, 140, 30);
		add(btnBuscar);
		
		lblBsquedaDNI = new JLabel("Búsqueda por DNI:");
		lblBsquedaDNI.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBsquedaDNI.setBounds(65, 80, 150, 30);
		add(lblBsquedaDNI);
		
		lblBsquedaNombre = new JLabel("Búsqueda por nombre:");
		lblBsquedaNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBsquedaNombre.setBounds(65, 190, 150, 30);
		add(lblBsquedaNombre);
		
		txtBusqDNI = new JTextField();
		txtBusqDNI.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtBusqDNI.setBounds(65, 110, 160, 30);
		add(txtBusqDNI);
		txtBusqDNI.setColumns(10);
		
		txtBusqNombre = new JTextField();
		txtBusqNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtBusqNombre.setColumns(10);
		txtBusqNombre.setBounds(65, 220, 200, 30);
		add(txtBusqNombre);
		
		JLabel lblTituloDNI = new JLabel("DNI");
		lblTituloDNI.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTituloDNI.setBounds(350, 80, 94, 30);
		add(lblTituloDNI);
		
		lblTituloNombre = new JLabel("Nombre");
		lblTituloNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTituloNombre.setBounds(350, 120, 94, 30);
		add(lblTituloNombre);
		
		lblTituloSueldo = new JLabel("Sueldo");
		lblTituloSueldo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTituloSueldo.setBounds(350, 160, 94, 30);
		add(lblTituloSueldo);
		
		lblTituloCargo = new JLabel("Cargo");
		lblTituloCargo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTituloCargo.setBounds(350, 240, 94, 30);
		add(lblTituloCargo);
		
		lblTituloDepartamento = new JLabel("Departamento");
		lblTituloDepartamento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTituloDepartamento.setBounds(350, 200, 94, 30);
		add(lblTituloDepartamento);
		
		lblTituloResponsable = new JLabel("Responsable");
		lblTituloResponsable.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTituloResponsable.setBounds(350, 280, 94, 30);
		add(lblTituloResponsable);
		
		JCheckBox chkJefe = new JCheckBox("Es Jefe");
		chkJefe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chkJefe.setBounds(350, 320, 250, 30);
		add(chkJefe);
		
		JLabel lblTituloFechaDeAlta = new JLabel("Fecha de alta");
		lblTituloFechaDeAlta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTituloFechaDeAlta.setBounds(350, 360, 94, 30);
		add(lblTituloFechaDeAlta);
		
		JLabel lblDNI = new JLabel("12345678X");
		lblDNI.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDNI.setBounds(488, 80, 200, 30);
		add(lblDNI);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(488, 120, 200, 30);
		add(lblNombre);
		
		JLabel lblSueldo = new JLabel("50000");
		lblSueldo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSueldo.setBounds(488, 160, 200, 30);
		add(lblSueldo);
		
		JLabel lblDpto = new JLabel("Departamento");
		lblDpto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDpto.setBounds(488, 200, 200, 30);
		add(lblDpto);
		
		JLabel lblCargo = new JLabel("Cargo");
		lblCargo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCargo.setBounds(488, 240, 200, 30);
		add(lblCargo);
		
		JLabel lblResponsable = new JLabel("Responsable");
		lblResponsable.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblResponsable.setBounds(488, 280, 200, 30);
		add(lblResponsable);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFecha.setBounds(488, 360, 200, 30);
		add(lblFecha);
		
		
	}
	
	private void instanciarObjetos() {
		
	}
}
