package Modelo;

public class Centro {

	//Declaración e inicialización de atributos:
	private int codigo;
	private String nombre;
	
	//Constructor:
	public Centro() {
		
	}
	
	public Centro(int codigo, String nombre) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
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
	
}
