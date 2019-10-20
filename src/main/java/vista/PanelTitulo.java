package vista;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class PanelTitulo extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;

	/**
	 * Create the panel.
	 */
	public PanelTitulo() {
		setPreferredSize(new Dimension(800, 80));
		setLayout(null);
		
		JLabel lblGestinDeEmpleados = new JLabel("Gestión de Empleados (Elorrieta Errekamari)");
		lblGestinDeEmpleados.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestinDeEmpleados.setBounds(10, 32, 780, 25);
		lblGestinDeEmpleados.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lblGestinDeEmpleados);
		instanciarObjetos();
	}
	
	private void instanciarObjetos() {
		
	}

}
