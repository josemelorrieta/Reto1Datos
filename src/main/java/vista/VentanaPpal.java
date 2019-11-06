package vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class VentanaPpal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Instancias de los paneles en la VentanaPpal:
	public BorderLayout border;
	public PanelTitulo pTitulo;
	public PanelCentral pCentral;
	public PanelBotones pBotones;
		
	
	/**
	 * Create the frame.
	 */
	public VentanaPpal() {
		setParametros();
		instanciarObjetos();
	}
	
	private void setParametros() {
		border = new BorderLayout();
		getContentPane().setLayout(border);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Gestión de Empleados Elorrieta / Errekamari");
		setVisible(true);
	}
	
	private void instanciarObjetos() {
		pTitulo  = new PanelTitulo();
		getContentPane().add(pTitulo, BorderLayout.NORTH);
		
		pCentral = new PanelCentral();
		getContentPane().add(pCentral, BorderLayout.CENTER);
		
		pBotones = new PanelBotones();
		getContentPane().add(pBotones, BorderLayout.SOUTH);
		
	}

}
