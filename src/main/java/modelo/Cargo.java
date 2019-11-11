package modelo;

public class Cargo {
	// Declaraci�n e inicializaci�n de atributos:
	private String codigo;
	private String nombre;

	// Constructor:
	public Cargo() {

	}

	public Cargo(String codigo, String nombre) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
	}

	// getter y setters
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

}
