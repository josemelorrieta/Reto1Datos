package vista;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;

public class PanelVerEmpleados extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public  JLabel lblTituloEmple, lblBsquedaPorCdigo, lblBsquedaPorNombre, lblnombre, lblapellidos;
	public JButton btnAnteriorDept;
	public JTextField txtCodigoIntroducido, txtNombreIntroducido, txtApellidosIntroducidos;
	public JTextPane textPaneVerEmpleados;

	/**
	 * Create the panel.
	 */
	public PanelVerEmpleados() {
		setPreferredSize(new Dimension(800, 440));
		setLayout(null);
		
		lblTituloEmple = new JLabel("EMPLEADOS");
		lblTituloEmple.setBounds(299, 25, 97, 36);
		add(lblTituloEmple);
		instanciarObjetos();
		
		btnAnteriorDept = new JButton("Buscar empleado");
		btnAnteriorDept.setBounds(68, 368, 161, 23);
		add(btnAnteriorDept);
		
		textPaneVerEmpleados = new JTextPane();
		textPaneVerEmpleados.setBounds(299, 81, 438, 310);
		add(textPaneVerEmpleados);
		
		lblBsquedaPorCdigo = new JLabel("B\u00FAsqueda por c\u00F3digo de empleado:");
		lblBsquedaPorCdigo.setBounds(68, 81, 188, 14);
		add(lblBsquedaPorCdigo);
		
		lblBsquedaPorNombre = new JLabel("B\u00FAsqueda por nombre y apellidos:");
		lblBsquedaPorNombre.setBounds(68, 189, 188, 14);
		add(lblBsquedaPorNombre);
		
		txtCodigoIntroducido = new JTextField();
		txtCodigoIntroducido.setBounds(68, 106, 161, 20);
		add(txtCodigoIntroducido);
		txtCodigoIntroducido.setColumns(10);
		
		txtNombreIntroducido = new JTextField();
		txtNombreIntroducido.setColumns(10);
		txtNombreIntroducido.setBounds(68, 238, 161, 20);
		add(txtNombreIntroducido);
		
		txtApellidosIntroducidos = new JTextField();
		txtApellidosIntroducidos.setColumns(10);
		txtApellidosIntroducidos.setBounds(68, 300, 161, 20);
		add(txtApellidosIntroducidos);
		
		lblnombre = new JLabel("-Nombre:");
		lblnombre.setBounds(68, 214, 188, 14);
		add(lblnombre);
		
		lblapellidos = new JLabel("-Apellidos:");
		lblapellidos.setBounds(68, 275, 188, 14);
		add(lblapellidos);
		
		
	}
	
	private void instanciarObjetos() {
		
	}
}
