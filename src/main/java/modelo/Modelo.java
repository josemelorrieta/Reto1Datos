package modelo;

import java.util.ArrayList;

import baseDatos.ConsultaBD;

public class Modelo {

	public static ConsultaBD bd;
	public ConexionBD conBD;
	
	public Centro[] centros;
	public Cargo[] cargos;
	public ArrayList<Departamento> dptos;
	public ArrayList<Empleado> empleados;
	
	public Modelo() {
		bd = ConsultaBD.getSingletonInstance();
		
		initModelos();
	}
	
	private void initModelos() {
		conBD = new ConexionBD();
	}

}
