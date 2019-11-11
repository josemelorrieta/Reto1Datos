package vista;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelBotones extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4L;

	public JButton btnAtras;
	public JButton btnSalir;

	public PanelBotones() {
		setPreferredSize(new Dimension(800, 80));
		setLayout(null);
		instanciarObjetos();
	}

	private void instanciarObjetos() {
		btnAtras = new JButton("ANTERIOR");
		btnAtras.setBounds(50, 25, 100, 25);
		btnAtras.setActionCommand("ATRAS");
		btnAtras.setVisible(false);
		add(btnAtras);

		btnSalir = new JButton("SALIR");
		btnSalir.setBounds(650, 25, 100, 25);
		btnSalir.setActionCommand("SALIR");
		add(btnSalir);
	}

}
