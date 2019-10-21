package modelo;

public class Departamento {
	//Declaraci�n e inicializaci�n de atributos:
	private String codigo;
	private String nombre;
	private Centro localizacion;
	
	//Constructor:
	public Departamento() {
		
	}

	public Departamento(String codigo, String nombre, Centro localizacion) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.localizacion = localizacion;
	}
	
	//getter y setters
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
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
