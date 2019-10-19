package controlador;

import modelo.Modelo;
import vista.VentanaPpal;

public class Controlador {
	private Modelo modelo;
	private VentanaPpal vista;
	
	
	public Controlador (VentanaPpal vista, Modelo modelo) {
		this.vista = vista;
		this.modelo = modelo;
	}

}
