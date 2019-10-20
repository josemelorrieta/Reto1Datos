package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.VentanaPpal;

public class ControladorMenu {

	private VentanaPpal vista;
	private String opcion; 
	
	public ControladorMenu(VentanaPpal vista) {
		this.vista = vista;
		
		initListeners();
	}
	
	private void initListeners() {
		vista.pCentral.pMenu.btnGestionDepart.addActionListener(new ListenerMenu());
		vista.pCentral.pMenu.btnGestionEmple.addActionListener(new ListenerMenu());
		vista.pCentral.pMenu.btnGestionInfor.addActionListener(new ListenerMenu());
	}
	
	private class ListenerMenu implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			opcion = e.getActionCommand();
			
			switch (opcion) {
				case "altaDepart":
					vista.pCentral.card.show(vista.pCentral, "2");
					break;
				case "altaEmple": 
					vista.pCentral.changePanel("3");
					break;
				case "verDepart":
					break;
				case "verEmple":
					break;
				case "informes":
					vista.pCentral.changePanel("6");
					break;
				
			}
			
		}
		
	}
}
