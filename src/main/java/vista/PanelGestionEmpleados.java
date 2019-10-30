package vista;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelGestionEmpleados extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JButton btnAltaEmple;
	public JButton btnVerEmple;
	
	public PanelGestionEmpleados() {
		setPreferredSize(new Dimension(800, 440));
		setLayout(null);
		
		btnAltaEmple = new JButton("Alta nuevo empleado");
		btnAltaEmple.setBounds(265, 120, 270, 23);
		btnAltaEmple.setActionCommand("altaEmple");
		add(btnAltaEmple);
		
		btnVerEmple = new JButton("Ver empleado");
		btnVerEmple.setBounds(265, 173, 269, 23);
		btnVerEmple.setActionCommand("verEmple");
		add(btnVerEmple);
	}

}
