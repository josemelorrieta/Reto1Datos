package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

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
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY - hh:mm:ss");
	
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
				ruta = modelo.funGen.elegirCarpeta();
				if (!ruta.equals("")) {
					if (modelo.funGen.guardarRutaLog(ruta)) {
						logger.rutaArchivo = ruta;
						JOptionPane.showMessageDialog(vista,  "Ruta del archivo de log cambiada a " + ruta, "Información", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(vista,  "Error al guardar la nueva ruta del fichero de log", "Error", JOptionPane.ERROR_MESSAGE);
						logger.escribirLog(dateFormat.format(new Date()) + " " + getClass().getName() + " - Error al guardar la ruta en el archivo gestor.ini");
					}
				}
				break;
			case "borrar":
				
				break;
			}
			
		}
		
	}
}
