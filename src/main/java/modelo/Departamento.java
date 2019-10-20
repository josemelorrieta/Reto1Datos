package modelo;

public class Departamento {
	//Declaraci�n e inicializaci�n de atributos:
	private int codigo;
	private String nombre;
	private Centro localizacion;
	
	//Constructor:
	public Departamento() {
		
	}

	public Departamento(int codigo, String nombre, Centro localizacion) {
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Centro getLocalizacion() {
		return localizacion;
	}

	public void setLocalizacion(Centro localizacion) {
		this.localizacion = localizacion;
	}
	
}
