package vista;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JComboBox;

public class PanelGenerarInforme extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 10L;
	
	public JLabel lblGeneracinDeInformes;
	public JButton btnGenerarInformeDepart,btnGenerarInformeEmple;


	/**
	 * Create the panel.
	 */
	public PanelGenerarInforme() {
		setPreferredSize(new Dimension(800, 440));
		setLayout(null);
		
		lblGeneracinDeInformes = new JLabel("GENERACI\u00D3N DE INFORMES");
		lblGeneracinDeInformes.setBounds(301, 44, 148, 36);
		add(lblGeneracinDeInformes);
		instanciarObjetos();
		
		btnGenerarInformeDepart = new JButton("Generar informe departamentos");
		btnGenerarInformeDepart.setBounds(256, 134, 237, 23);
		add(btnGenerarInformeDepart);
		
		btnGenerarInformeEmple = new JButton("Generar informe empleados");
		btnGenerarInformeEmple.setBounds(256, 220, 237, 23);
		add(btnGenerarInformeEmple);
		
		
		
		
	}
	
	private void instanciarObjetos() {
		
	}
}
