package vista;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PanelVerEmpleados extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9L;
	
	private  JLabel lblTituloEmple, lblBsquedaDNI, lblBsquedaNombre;
	public JButton btnBuscarDNI, btnBuscarNombre;
	public JTextField txtBusqDNI, txtBusqNombre;
	private JLabel lblTituloDNI, lblTituloNombre, lblTituloSueldo, lblTituloCargo, lblTituloDepartamento, lblTituloJefe, lblTituloResponsable, lblTituloFechaDeAlta;
	public JLabel lblDNI, lblNombre, lblSueldo, lblCargo, lblJefe, lblResponsable, lblDpto, lblFecha;

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
		btnBuscarDNI.setBounds(65, 150, 200, 30);
		btnBuscarDNI.setActionCommand("buscarDNI");
		add(btnBuscarDNI);
		
		btnBuscarNombre = new JButton("Buscar por Nombre");
		btnBuscarNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscarNombre.setBounds(65, 300, 200, 30);
		btnBuscarNombre.setActionCommand("buscarNombre");
		add(btnBuscarNombre);
		
		lblBsquedaDNI = new JLabel("Búsqueda por DNI:");
		lblBsquedaDNI.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBsquedaDNI.setBounds(65, 80, 150, 30);
		add(lblBsquedaDNI);
		
		lblBsquedaNombre = new JLabel("Búsqueda por nombre:");
		lblBsquedaNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBsquedaNombre.setBounds(65, 230, 150, 30);
		add(lblBsquedaNombre);
		
		txtBusqDNI = new JTextField();
		txtBusqDNI.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtBusqDNI.setBounds(65, 110, 200, 30);
		add(txtBusqDNI);
		txtBusqDNI.setColumns(10);
		
		txtBusqNombre = new JTextField();
		txtBusqNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtBusqNombre.setColumns(10);
		txtBusqNombre.setBounds(65, 260, 200, 30);
		add(txtBusqNombre);
		
		lblTituloDNI = new JLabel("DNI");
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
		
		lblTituloJefe = new JLabel("Jefe");
		lblTituloJefe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTituloJefe.setBounds(350, 320, 94,30);
		add(lblTituloJefe);
		
		lblTituloResponsable = new JLabel("Responsable");
		lblTituloResponsable.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTituloResponsable.setBounds(350, 280, 94, 30);
		add(lblTituloResponsable);
		
		lblJefe = new JLabel("SI");
		lblJefe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblJefe.setBounds(488, 320, 250, 30);
		add(lblJefe);
		
		lblTituloFechaDeAlta = new JLabel("Fecha de alta");
		lblTituloFechaDeAlta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTituloFechaDeAlta.setBounds(350, 360, 94, 30);
		add(lblTituloFechaDeAlta);
		
		lblDNI = new JLabel("12345678X");
		lblDNI.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDNI.setBounds(488, 80, 200, 30);
		add(lblDNI);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(488, 120, 200, 30);
		add(lblNombre);
		
		lblSueldo = new JLabel("50000");
		lblSueldo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSueldo.setBounds(488, 160, 200, 30);
		add(lblSueldo);
		
		lblDpto = new JLabel("Departamento");
		lblDpto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDpto.setBounds(488, 200, 200, 30);
		add(lblDpto);
		
		lblCargo = new JLabel("Cargo");
		lblCargo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCargo.setBounds(488, 240, 200, 30);
		add(lblCargo);
		
		lblResponsable = new JLabel("Responsable");
		lblResponsable.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblResponsable.setBounds(488, 280, 200, 30);
		add(lblResponsable);
		
		lblFecha = new JLabel("Fecha");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFecha.setBounds(488, 360, 200, 30);
		add(lblFecha);
	}
}
