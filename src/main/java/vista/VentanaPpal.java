package vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class VentanaPpal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public PanelTitulo pTitulo;

	/**
	 * Create the frame.
	 */
	public VentanaPpal() {
		setParametros();
		instanciarObjetos();
	}
	
	private void setParametros() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 100, 800, 600);
		//contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//setContentPane(contentPane);
		getContentPane().setLayout(new BorderLayout(0,0));
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Gestión de Empleados Elorrieta / Errekamari");
		setVisible(true);		
	}
	
	private void instanciarObjetos() {
		pTitulo  = new PanelTitulo();
		getContentPane().add(pTitulo, BorderLayout.NORTH);
	}

}
