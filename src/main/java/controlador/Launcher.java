package controlador;

import modelo.Modelo;
import vista.VentanaPpal;

public class Launcher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Modelo modelo = new Modelo();
		VentanaPpal vista = new VentanaPpal();

		@SuppressWarnings("unused")
		Controlador controlador = new Controlador(vista, modelo);
	}

}
