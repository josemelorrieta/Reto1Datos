package vista;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PanelAltaDepartamento extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public  JLabel lblTituloAltaDept, lblCdigoDeDepartamento, lblNombre, lblLocalizacin;
	public JTextField txtCodDepart, texNombreDepart, textLocDepart;
	public JButton btnDarDeAlta;


	/**
	 * Create the panel.
	 */
	public PanelAltaDepartamento() {
		setPreferredSize(new Dimension(800, 520));
		setLayout(null);
		
		lblTituloAltaDept = new JLabel("FORMULARIO ALTA DEPARTAMENTO");
		lblTituloAltaDept.setBounds(293, 73, 192, 36);
		add(lblTituloAltaDept);
		instanciarObjetos();
		
		lblCdigoDeDepartamento = new JLabel("C\u00F3digo de departamento:");
		lblCdigoDeDepartamento.setBounds(253, 156, 132, 26);
		add(lblCdigoDeDepartamento);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(253, 206, 46, 14);
		add(lblNombre);
		
		lblLocalizacin = new JLabel("Localizaci\u00F3n:");
		lblLocalizacin.setBounds(253, 256, 85, 14);
		add(lblLocalizacin);
		
		txtCodDepart = new JTextField();
		txtCodDepart.setBounds(393, 156, 150, 20);
		add(txtCodDepart);
		txtCodDepart.setColumns(10);
		
		texNombreDepart = new JTextField();
		texNombreDepart.setBounds(393, 206, 150, 20);
		add(texNombreDepart);
		texNombreDepart.setColumns(10);
		
		textLocDepart = new JTextField();
		textLocDepart.setBounds(393, 256, 150, 20);
		add(textLocDepart);
		textLocDepart.setColumns(10);
		
		btnDarDeAlta = new JButton("Dar de alta");
		btnDarDeAlta.setBounds(349, 381, 89, 23);
		add(btnDarDeAlta);
		
		
	}
	
	private void instanciarObjetos() {
		
	}
}
