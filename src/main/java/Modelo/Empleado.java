package Modelo;

public class Empleado {
	//Declaración e inicialización de atributos:
	private String dni;
	private String nombre;
	private float sueldo;
	private Cargo cargo;
	private Departamento departamento;
	private boolean jefe;
	private String responsable;
	
	//Constructor:
	public Empleado() {
		
	}

	public Empleado(String dni, String nombre, float sueldo, Cargo cargo, Departamento departamento, boolean jefe,
			String responsable) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.sueldo = sueldo;
		this.cargo = cargo;
		this.departamento = departamento;
		this.jefe = jefe;
		this.responsable = responsable;
	}

	//getter y setters
	
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

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public boolean isJefe() {
		return jefe;
	}

	public void setJefe(boolean jefe) {
		this.jefe = jefe;
	}

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}
		
	
	
}
