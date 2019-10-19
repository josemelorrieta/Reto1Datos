package vista;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;

public class PanelVerDepartamento extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public  JLabel lblTituloDept;
	public JButton btnVerUltimo, btnIrAlPrimer, btnSiguienteDept, btnAnteriorDept;



	/**
	 * Create the panel.
	 */
	public PanelVerDepartamento() {
		setPreferredSize(new Dimension(800, 520));
		setLayout(null);
		
		lblTituloDept = new JLabel(" DEPARTAMENTOS");
		lblTituloDept.setBounds(299, 25, 97, 36);
		add(lblTituloDept);
		instanciarObjetos();
		
		btnVerUltimo = new JButton("Ir al \u00FAltimo departamento");
		btnVerUltimo.setBounds(57, 81, 161, 23);
		add(btnVerUltimo);
		
		btnIrAlPrimer = new JButton("Ir al primer departamento");
		btnIrAlPrimer.setBounds(57, 108, 161, 23);
		add(btnIrAlPrimer);
		
		btnSiguienteDept = new JButton("Siguiente departamento");
		btnSiguienteDept.setBounds(57, 131, 161, 23);
		add(btnSiguienteDept);
		
		btnAnteriorDept = new JButton("Anterior departamento");
		btnAnteriorDept.setBounds(57, 155, 161, 23);
		add(btnAnteriorDept);
		
		JTextPane textPaneVerDepart = new JTextPane();
		textPaneVerDepart.setBounds(299, 81, 438, 419);
		add(textPaneVerDepart);
		
		
	}
	
	private void instanciarObjetos() {
		
	}
}
