package vista;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PanelGenerarInforme extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 10L;
	public JButton btnGenerarInformeDepart, btnGenerarInformeEmple;
	private JLabel lblGenerar;

	/**
	 * Create the panel.
	 */
	public PanelGenerarInforme() {
		setPreferredSize(new Dimension(800, 440));
		setLayout(null);
		instanciarObjetos();

		btnGenerarInformeDepart = new JButton("Generar informe departamentos");
		btnGenerarInformeDepart.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGenerarInformeDepart.setBounds(275, 160, 250, 30);
		btnGenerarInformeDepart.setActionCommand("informeDepart");
		add(btnGenerarInformeDepart);

		btnGenerarInformeEmple = new JButton("Generar informe empleados");
		btnGenerarInformeEmple.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGenerarInformeEmple.setBounds(275, 230, 250, 30);
		btnGenerarInformeEmple.setActionCommand("informeEmple");
		add(btnGenerarInformeEmple);

		lblGenerar = new JLabel("GENERAR INFORMES");
		lblGenerar.setHorizontalAlignment(SwingConstants.CENTER);
		lblGenerar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGenerar.setBounds(10, 40, 780, 40);
		add(lblGenerar);

	}

	private void instanciarObjetos() {

	}
}
