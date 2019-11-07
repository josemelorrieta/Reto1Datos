package modelo;

public class EmpleadoBD {
	private String dni;
	private String nombre;
	private float sueldo;
	private String cargo;
	private int departamento;
	private int jefe;
	private String responsable;
	private String fecha;
	
	public EmpleadoBD(String dni, String nombre, float sueldo, String cargo, int departamento, int jefe, String responsable, String fecha) {
		this.dni = dni;
		this.nombre = nombre;
		this.sueldo = sueldo;
		this.cargo = cargo;
		this.departamento = departamento;
		this.jefe = jefe;
		this.responsable = responsable;
		this.fecha = fecha;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getSueldo() {
		return sueldo;
	}

	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public int getDepartamento() {
		return departamento;
	}

	public void setDepartamento(int departamento) {
		this.departamento = departamento;
	}

	public int getJefe() {
		return jefe;
	}

	public void setJefe(int jefe) {
		this.jefe = jefe;
	}

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
}
