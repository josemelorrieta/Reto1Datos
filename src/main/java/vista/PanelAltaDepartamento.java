package vista;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PanelAltaDepartamento extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6L;
	
	public  JLabel lblTituloAltaDept, lblCodDpto, lblNombre, lblLocalizacion;
	public JTextField txtCodDpto, txtNombreDpto;
	public JButton btnDarDeAlta;
	public JComboBox<String> cmbLocalizacion;


	/**
	 * Create the panel.
	 */
	public PanelAltaDepartamento() {
		setPreferredSize(new Dimension(800, 440));
		setLayout(null);
		
		instanciarObjetos();
	}
	
	private void instanciarObjetos() {
		lblTituloAltaDept = new JLabel("FORMULARIO ALTA DEPARTAMENTO");
		lblTituloAltaDept.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloAltaDept.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTituloAltaDept.setBounds(0, 81, 800, 36);
		add(lblTituloAltaDept);
		
		lblCodDpto = new JLabel("Código");
		lblCodDpto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCodDpto.setBounds(250, 150, 130, 30);
		add(lblCodDpto);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(250, 200, 130, 30);
		add(lblNombre);
		
		lblLocalizacion = new JLabel("Localización");
		lblLocalizacion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLocalizacion.setBounds(250, 250, 130, 30);
		add(lblLocalizacion);
		
		txtCodDpto = new JTextField();
		txtCodDpto.setBounds(400, 150, 70, 30);
		add(txtCodDpto);
		txtCodDpto.setColumns(10);
		
		txtNombreDpto = new JTextField();
		txtNombreDpto.setBounds(400, 200, 250, 30);
		add(txtNombreDpto);
		txtNombreDpto.setColumns(10);
		
		btnDarDeAlta = new JButton("Dar de alta");
		btnDarDeAlta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDarDeAlta.setBounds(334, 336, 150, 36);
		btnDarDeAlta.setActionCommand("alta");
		add(btnDarDeAlta);
		
		cmbLocalizacion = new JComboBox<String>();
		cmbLocalizacion.setBounds(400, 249, 250, 30);
		add(cmbLocalizacion);
	}
}
