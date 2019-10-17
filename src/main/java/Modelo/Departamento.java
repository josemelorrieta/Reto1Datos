package Modelo;

public class Departamento {
	//Declaración e inicialización de atributos:
	private int codigo;
	private int nombre;
	private String localizacion = "Elorrieta-Errekamari.";
	
	//Constructor:
	public Departamento() {
		
	}

	public Departamento(int codigo, int nombre, String localizacion) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.localizacion = localizacion;
	}
	
	//getter y setters
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getNombre() {
		return nombre;
	}

	public void setNombre(int nombre) {
		this.nombre = nombre;
	}

	public String getLocalizacion() {
		return localizacion;
	}

	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}
	
}
