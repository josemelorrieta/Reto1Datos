package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.VentanaPpal;

public class ControladorGestionEmpleados {
	private VentanaPpal vista;
	public Controlador controlador;
	
	public ControladorGestionEmpleados(VentanaPpal vista, Controlador controlador) {
		this.vista = vista;
		this.controlador = controlador;
		
		initListeners();
	}
	
	private void initListeners() {
		vista.pCentral.pGestionEmple.btnAltaEmple.addActionListener(new ListenerMenu());
		vista.pCentral.pGestionEmple.btnVerEmple.addActionListener(new ListenerMenu());
	}
	
	private class ListenerMenu implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
			case "altaEmple":
				vista.pCentral.changePanel("6");
				controlador.cAltaEmple.initAltaEmple();
				break;
			case "verEmple":
				vista.pCentral.changePanel("7");
				controlador.cVerEmple.initPanel();
				break;
			}
			
		}
		
	}
}
