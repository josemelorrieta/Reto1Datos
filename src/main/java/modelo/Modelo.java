package modelo;

import java.util.ArrayList;

import javax.swing.JFileChooser;

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
	
	public String elegirCarpeta() {
		
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		
		fileChooser.showDialog(null, "Seleccionar");
		
		if (fileChooser.getSelectedFile() != null)
			return fileChooser.getSelectedFile().getAbsolutePath();
		else
			return "";

	}

}
