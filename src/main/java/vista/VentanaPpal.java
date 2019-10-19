package vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class VentanaPpal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Instancias de los paneles en la VentanaPpal:
	public PanelTitulo pTitulo;
	public PanelAltaDepartamento pAltaDepart;
	public PanelAltaEmpleado pAltaEmpleado;
	public PanelVerDepartamento pVerDepart;
	public PanelVerEmpleados pVerEmple;
	public PanelGenerarInforme pInformes;
	
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
		
		pAltaDepart = new PanelAltaDepartamento();
		getContentPane().add(pAltaDepart, BorderLayout.CENTER);
		
		pAltaEmpleado = new PanelAltaEmpleado();
		getContentPane().add(pAltaEmpleado, BorderLayout.CENTER);
		
		pVerDepart = new PanelVerDepartamento();
		getContentPane().add(pVerDepart, BorderLayout.CENTER);
		
		pVerEmple = new PanelVerEmpleados();
		getContentPane().add(pVerEmple, BorderLayout.CENTER);
		
		pInformes = new PanelGenerarInforme();
		getContentPane().add(pInformes, BorderLayout.CENTER);
		
		
	}

}
