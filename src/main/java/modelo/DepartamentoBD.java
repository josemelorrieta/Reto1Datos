package modelo;

public class DepartamentoBD {
	private int codigo;
	private String nombre;
	private int localizacion;

	public DepartamentoBD(int codigo, String nombre, int localizacion) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.localizacion = localizacion;
	}

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

	public int getLocalizacion() {
		return localizacion;
	}

	public void setLocalizacion(int localizacion) {
		this.localizacion = localizacion;
	}

}
