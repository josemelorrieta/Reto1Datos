package vista;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JButton;

public class PanelGestionDepartamentos extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JButton btnAltaDpto;
	public JButton btnVerDpto;
	
	public PanelGestionDepartamentos() {
		setPreferredSize(new Dimension(800, 440));
		setLayout(null);
		
		btnAltaDpto = new JButton("Alta nuevo departamento");
		btnAltaDpto.setBounds(265, 120, 270, 23);
		btnAltaDpto.setActionCommand("altaDpto");
		add(btnAltaDpto);
		
		btnVerDpto = new JButton("Ver departamento");
		btnVerDpto.setBounds(265, 173, 269, 23);
		btnVerDpto.setActionCommand("verDpto");
		add(btnVerDpto);
	}
}
