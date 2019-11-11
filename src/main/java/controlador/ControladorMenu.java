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
		vista.pCentral.pMenu.btnLog.addActionListener(new ListenerMenu());
	}

	private class ListenerMenu implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			opcion = e.getActionCommand();
			botonesNoMenu();

			switch (opcion) {
			case "gestDepart":
				vista.pCentral.changePanel("2");
				break;
			case "gestEmple":
				vista.pCentral.changePanel("5");
				break;
			case "informes":
				vista.pCentral.changePanel("8");
				break;
			case "log":
				vista.pCentral.changePanel("9");
				break;
			}

		}

	}

	private void botonesNoMenu() {
		vista.pBotones.btnAtras.setVisible(true);
		vista.pBotones.btnSalir.setVisible(false);
	}
}
