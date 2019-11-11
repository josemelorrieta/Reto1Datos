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

	public FuncionesGenerales funGen;

	public Modelo() {
		bd = ConsultaBD.getSingletonInstance();
		this.funGen = new FuncionesGenerales();

		initModelos();
	}

	private void initModelos() {
		conBD = new ConexionBD();
	}

}
