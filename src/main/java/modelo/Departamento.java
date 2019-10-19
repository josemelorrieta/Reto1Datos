package modelo;

public class Departamento {
	//Declaraci�n e inicializaci�n de atributos:
	private int codigo;
	private int nombre;
	private Centro localizacion;
	
	//Constructor:
	public Departamento() {
		
	}

	public Departamento(int codigo, int nombre, Centro localizacion) {
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

	public Centro getLocalizacion() {
		return localizacion;
	}

	public void setLocalizacion(Centro localizacion) {
		this.localizacion = localizacion;
	}
	
}
