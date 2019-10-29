package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.VentanaPpal;

public class ControladorGestionDepartamentos {
	private VentanaPpal vista;
	public Controlador controlador;
	
	public ControladorGestionDepartamentos(VentanaPpal vista, Controlador controlador) {
		this.vista = vista;
		this.controlador = controlador;
		
		initListeners();
	}
	
	private void initListeners() {
		vista.pCentral.pGestionDptos.btnAltaDpto.addActionListener(new ListenerMenu());
		vista.pCentral.pGestionDptos.btnVerDpto.addActionListener(new ListenerMenu());
	}
	
	private class ListenerMenu implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
			case "altaDpto":
				vista.pCentral.changePanel("3");
				controlador.cAltaDpto.initAltaDpto();
				break;
			case "verDpto":
				vista.pCentral.changePanel("4");
				controlador.cVerDpto.cambiarDpto(0);
				break;
			}
			
		}
		
	}
}
