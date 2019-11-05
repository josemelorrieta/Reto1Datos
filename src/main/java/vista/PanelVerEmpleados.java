package vista;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import modelo.Empleado;

public class PanelVerEmpleados extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9L;
	
	private  JLabel lblTituloEmple, lblBsquedaDNI, lblBsquedaNombre;
	public JButton btnBuscarDNI, btnBuscarNombre, btnVerEmple;
	public JTextField txtBusqDNI, txtBusqNombre;
	private JLabel lblTituloDNI, lblTituloNombre, lblTituloSueldo, lblTituloCargo, lblTituloDepartamento, lblTituloJefe, lblTituloResponsable, lblTituloFechaDeAlta;
	public JLabel lblDNI, lblNombre, lblSueldo, lblCargo, lblJefe, lblResponsable, lblDpto, lblFecha;
	public DefaultListModel<String> listModel = new DefaultListModel<String>();
	public JList<String> listEmpleados;

	/**
	 * Create the panel.
	 */
	public PanelVerEmpleados() {
		setPreferredSize(new Dimension(800, 440));
		setLayout(null);
		
		
		instanciarObjetos();
	}
	
	private void instanciarObjetos() {
		lblTituloEmple = new JLabel("BUSCAR EMPLEADOS");
		lblTituloEmple.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloEmple.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTituloEmple.setBounds(0, 11, 800, 36);
		add(lblTituloEmple);
		
		btnBuscarDNI = new JButton("Buscar por DNI");
		btnBuscarDNI.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscarDNI.setBounds(66, 136, 200, 30);
		btnBuscarDNI.setActionCommand("buscarDNI");
		add(btnBuscarDNI);
		
		btnBuscarNombre = new JButton("Buscar por Nombre");
		btnBuscarNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscarNombre.setBounds(66, 256, 200, 30);
		btnBuscarNombre.setActionCommand("buscarNombre");
		add(btnBuscarNombre);
		
		lblBsquedaDNI = new JLabel("Búsqueda por DNI:");
		lblBsquedaDNI.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBsquedaDNI.setBounds(66, 66, 150, 30);
		add(lblBsquedaDNI);
		
		lblBsquedaNombre = new JLabel("Búsqueda por nombre:");
		lblBsquedaNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBsquedaNombre.setBounds(66, 186, 150, 30);
		add(lblBsquedaNombre);
		
		txtBusqDNI = new JTextField();
		txtBusqDNI.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtBusqDNI.setBounds(66, 96, 200, 30);
		add(txtBusqDNI);
		txtBusqDNI.setColumns(10);
		
		txtBusqNombre = new JTextField();
		txtBusqNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtBusqNombre.setColumns(10);
		txtBusqNombre.setBounds(66, 216, 200, 30);
		add(txtBusqNombre);
		
		lblTituloDNI = new JLabel("DNI");
		lblTituloDNI.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTituloDNI.setBounds(378, 79, 94, 30);
		add(lblTituloDNI);
		
		lblTituloNombre = new JLabel("Nombre");
		lblTituloNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTituloNombre.setBounds(378, 119, 94, 30);
		add(lblTituloNombre);
		
		lblTituloSueldo = new JLabel("Sueldo");
		lblTituloSueldo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTituloSueldo.setBounds(378, 159, 94, 30);
		add(lblTituloSueldo);
		
		lblTituloCargo = new JLabel("Cargo");
		lblTituloCargo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTituloCargo.setBounds(378, 239, 94, 30);
		add(lblTituloCargo);
		
		lblTituloDepartamento = new JLabel("Departamento");
		lblTituloDepartamento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTituloDepartamento.setBounds(378, 199, 94, 30);
		add(lblTituloDepartamento);
		
		lblTituloJefe = new JLabel("Jefe");
		lblTituloJefe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTituloJefe.setBounds(378, 319, 94,30);
		add(lblTituloJefe);
		
		lblTituloResponsable = new JLabel("Responsable");
		lblTituloResponsable.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTituloResponsable.setBounds(378, 279, 94, 30);
		add(lblTituloResponsable);
		
		lblJefe = new JLabel("SI");
		lblJefe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblJefe.setBounds(516, 319, 38, 30);
		add(lblJefe);
		
		lblTituloFechaDeAlta = new JLabel("Fecha de alta");
		lblTituloFechaDeAlta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTituloFechaDeAlta.setBounds(378, 359, 94, 30);
		add(lblTituloFechaDeAlta);
		
		lblDNI = new JLabel("12345678X");
		lblDNI.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDNI.setBounds(516, 79, 200, 30);
		add(lblDNI);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(516, 119, 200, 30);
		add(lblNombre);
		
		lblSueldo = new JLabel("50000");
		lblSueldo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSueldo.setBounds(516, 159, 200, 30);
		add(lblSueldo);
		
		lblDpto = new JLabel("Departamento");
		lblDpto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDpto.setBounds(516, 199, 200, 30);
		add(lblDpto);
		
		lblCargo = new JLabel("Cargo");
		lblCargo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCargo.setBounds(516, 239, 200, 30);
		add(lblCargo);
		
		lblResponsable = new JLabel("Responsable");
		lblResponsable.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblResponsable.setBounds(516, 279, 200, 30);
		add(lblResponsable);
		
		lblFecha = new JLabel("Fecha");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFecha.setBounds(516, 359, 200, 30);
		add(lblFecha);
		
		listEmpleados = new JList();
		listEmpleados.setFont(new Font("Tahoma", Font.PLAIN, 14));
		listEmpleados.setBounds(66, 297, 270, 74);
		add(listEmpleados);
		
		btnVerEmple = new JButton("Ver");
		btnVerEmple.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVerEmple.setBounds(141, 371, 120, 30);
		btnVerEmple.setActionCommand("ver");
		add(btnVerEmple);
	}
}
