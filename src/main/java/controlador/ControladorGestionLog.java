package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import log.Logger;
import modelo.Modelo;
import vista.VentanaPpal;

public class ControladorGestionLog {
	private VentanaPpal vista;
	private Modelo modelo;
	public Controlador controlador;
	private static Logger logger;
	private String ruta;
	
	public ControladorGestionLog(VentanaPpal vista, Controlador controlador, Modelo modelo) {
		this.vista = vista;
		this.controlador = controlador;
		this.modelo = modelo;
		this.logger = Logger.getSingletonInstance();
		initListeners();
	}
	
	private void initListeners() {
		vista.pCentral.pGestionLog.btnRuta.addActionListener(new ListenerMenu());
		vista.pCentral.pGestionLog.btnBorrar.addActionListener(new ListenerMenu());
	}
	
	private class ListenerMenu implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
			case "ruta":
				ruta = modelo.elegirCarpeta();
				if (!ruta.equals("")) {
					logger.rutaArchivo = ruta;
					JOptionPane.showMessageDialog(vista,  "Ruta del archivo de log cambiada a " + ruta, "Información", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(vista,  "Ruta del archivo de log cambiada a " + ruta, "Aviso", JOptionPane.WARNING_MESSAGE);
				}
				break;
			case "borrar":
				
				break;
			}
			
		}
		
	}
}
