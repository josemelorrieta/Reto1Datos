package vista;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

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
		btnAltaEmple.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAltaEmple.setBounds(265, 160, 270, 30);
		btnAltaEmple.setActionCommand("altaEmple");
		add(btnAltaEmple);
		
		btnVerEmple = new JButton("Ver empleado");
		btnVerEmple.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVerEmple.setBounds(265, 230, 269, 30);
		btnVerEmple.setActionCommand("verEmple");
		add(btnVerEmple);
		
		JLabel lblGestinDeEmpleados = new JLabel("GESTIÓN DE EMPLEADOS");
		lblGestinDeEmpleados.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestinDeEmpleados.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGestinDeEmpleados.setBounds(10, 40, 780, 40);
		add(lblGestinDeEmpleados);
	}

}
