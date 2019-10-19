package modelo;

import baseDatos.ConsultaBD;

public class Modelo {

	public static ConsultaBD bd;
	
	public Modelo() {
		bd = ConsultaBD.getSingletonInstance();
	}

}
