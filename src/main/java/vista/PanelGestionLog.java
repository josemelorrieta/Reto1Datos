package vista;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PanelGestionLog extends JPanel {

	private static final long serialVersionUID = 1L;

	public JButton btnRuta;
	public JButton btnBorrar;
	
	public PanelGestionLog() {
		setPreferredSize(new Dimension(800, 440));
		setLayout(null);
		
		btnRuta = new JButton("Elegir ruta del Log");
		btnRuta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRuta.setBounds(265, 160, 270, 30);
		btnRuta.setActionCommand("ruta");
		add(btnRuta);
		
		btnBorrar = new JButton("Borrar Log");
		btnBorrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBorrar.setBounds(265, 230, 269, 30);
		btnBorrar.setActionCommand("borrar");
		add(btnBorrar);
		
		JLabel lblGestinDeEmpleados = new JLabel("GESTIÓN DE ARCHIVO LOG");
		lblGestinDeEmpleados.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestinDeEmpleados.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGestinDeEmpleados.setBounds(10, 40, 780, 40);
		add(lblGestinDeEmpleados);
	}

}
