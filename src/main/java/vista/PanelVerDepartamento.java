package vista;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PanelVerDepartamento extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8L;
	
	public  JLabel lblTituloDept;
	public JLabel lblCodigo, lblNombre, lblLocalizacion;
	public JTextField txtCodigo, txtNombre, txtLocalizacion;
	public JButton btnPrimero;
	public JButton btnAnterior;
	public JButton btnSiguiente;
	public JButton btnUltimo;


	/**
	 * Create the panel.
	 */
	public PanelVerDepartamento() {
		setPreferredSize(new Dimension(800, 440));
		setLayout(null);
		
		lblTituloDept = new JLabel(" Departamentos");
		lblTituloDept.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloDept.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTituloDept.setBounds(0, 11, 800, 36);
		add(lblTituloDept);
		
		lblCodigo = new JLabel("Código");
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCodigo.setBounds(270, 148, 100, 30);
		add(lblCodigo);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(270, 188, 100, 30);
		add(lblNombre);
		
		lblLocalizacion = new JLabel("Localización");
		lblLocalizacion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLocalizacion.setBounds(270, 228, 100, 30);
		add(lblLocalizacion);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(370, 148, 86, 30);
		add(txtCodigo);
		txtCodigo.setColumns(10);
		instanciarObjetos();
		
		txtNombre = new JTextField();
		txtNombre.setBounds(370, 188, 230, 30);
		add(txtNombre);
		txtNombre.setColumns(10);
		instanciarObjetos();
		
		txtLocalizacion = new JTextField();
		txtLocalizacion.setBounds(370, 228, 230, 30);
		add(txtLocalizacion);
		txtLocalizacion.setColumns(10);
		
		btnPrimero = new JButton("Primero");
		btnPrimero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPrimero.setBounds(110, 80, 130, 30);
		btnPrimero.setActionCommand("primero");
		add(btnPrimero);
		
		btnAnterior = new JButton("Anterior");
		btnAnterior.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAnterior.setBounds(260, 82, 130, 30);
		btnAnterior.setActionCommand("anterior");
		add(btnAnterior);
		
		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSiguiente.setBounds(410, 82, 130, 30);
		btnSiguiente.setActionCommand("siguiente");
		add(btnSiguiente);
		
		btnUltimo = new JButton("Último");
		btnUltimo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnUltimo.setBounds(560, 82, 130, 30);
		btnUltimo.setActionCommand("ultimo");
		add(btnUltimo);
		instanciarObjetos();

	}
	
	private void instanciarObjetos() {
		
	}
}
