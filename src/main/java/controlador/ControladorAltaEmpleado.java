package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Modelo;
import vista.VentanaPpal;

public class ControladorAltaEmpleado {
	private Modelo modelo;
	private VentanaPpal vista;
	
	public ControladorAltaEmpleado(Modelo modelo, VentanaPpal vista) {
		this.modelo = modelo;
		this.vista = vista;
		
		initListeners();
	}
	
	private void initListeners() {
		vista.pCentral.pAltaEmpleado.btnAlta.addActionListener(new listenerBotones());
	}
	
	private class listenerBotones implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
				case "alta":
					nuevoEmple();
					break;
			}
		}
		
	}
	
	public void initAltaEmple() {
		
	}
	
	private void nuevoEmple() {
		
	}

}
