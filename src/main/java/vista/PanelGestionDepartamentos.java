package vista;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

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
		btnAltaDpto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAltaDpto.setBounds(265, 160, 270, 30);
		btnAltaDpto.setActionCommand("altaDpto");
		add(btnAltaDpto);

		btnVerDpto = new JButton("Ver departamento");
		btnVerDpto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVerDpto.setBounds(265, 230, 269, 30);
		btnVerDpto.setActionCommand("verDpto");
		add(btnVerDpto);

		JLabel lblGestinDeDepartamentos = new JLabel("GESTIÓN DE DEPARTAMENTOS");
		lblGestinDeDepartamentos.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestinDeDepartamentos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGestinDeDepartamentos.setBounds(10, 40, 780, 40);
		add(lblGestinDeDepartamentos);
	}
}
