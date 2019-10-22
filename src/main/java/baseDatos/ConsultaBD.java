package baseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.sql.DataSource;

import modelo.Departamento;
import modelo.Empleado;

public class ConsultaBD {
	private static ConsultaBD consultaBD;
	
	private PoolConexiones pool;
	private DataSource datasource;
	private Connection con;
	
	private ConsultaBD() {
		pool = new PoolConexiones();
		datasource = pool.CrearConexiones();
		try {
			con = datasource.getConnection();
		} catch (SQLException e) {
			System.out.println(e.getCause());
			e.printStackTrace();
		}
	}

	public static ConsultaBD getSingletonInstance() {
		if (consultaBD == null) {
			consultaBD = new ConsultaBD();
		} else {
			
		}
		
		return consultaBD;
	}
	
	public String consultarToGson(String consulta) {
		String resultado = "[";
		try {
			con = datasource.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(consulta);
			int numColumnas = rs.getMetaData().getColumnCount();
			if (rs.isBeforeFirst()) {
				while (rs.next()) {
					resultado += "{\"";
					for (int i = 1; i <= numColumnas; i++) {
						if (i != 1)
							resultado += ",\"";
						if (rs.getMetaData().getColumnTypeName(i).equals("VARCHAR")) {
							resultado += rs.getMetaData().getColumnLabel(i) + "\":\"";
							resultado += rs.getString(i) + "\"";
						} else {
							resultado += rs.getMetaData().getColumnLabel(i) + "\":";
							resultado += rs.getString(i);
						}
						if (i == numColumnas)
							resultado += "},";
					}
				}

				return resultado.substring(0, resultado.length() - 1) + "]";
			} else {
				return "";
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
	}
	
	public boolean insertGenerico(Object[] objetos, String nombreTabla) {
		try {
			con = datasource.getConnection();
			Class[] clasesObj = arrayClases(objetos);
			String query = prepararQuery(objetos.length, nombreTabla);
			PreparedStatement statementGenerico = generarStatement(objetos, clasesObj, query);
			if (statementGenerico != null) {
				statementGenerico.execute();
			}
			return true;
		} catch (SQLException e1) {
			return false;
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
		
	public PreparedStatement generarStatement(Object[] objetos, Class[] clases, String query) {
		try {
			PreparedStatement statementGenerico = this.con.prepareStatement(query);
			for (int i = 0; i < objetos.length; i++) {
				if (clases[i] == String.class) {
					statementGenerico.setString(i + 1, (String) objetos[i]);
				} else if (clases[i] == Float.class) {
					statementGenerico.setFloat(i + 1, (Float) objetos[i]);
				} else if (clases[i] == Double.class) {
					statementGenerico.setDouble(i + 1, (Double) objetos[i]);
				} else if (clases[i] == Integer.class) {
					statementGenerico.setInt(i + 1, (int) objetos[i]);
				} else if (clases[i] == java.util.Date.class) {
					statementGenerico.setDate(i + 1, new java.sql.Date(((java.util.Date) objetos[i]).getTime()));
				} else {
					statementGenerico.setString(i + 1, (String) objetos[i]);
				}
			}
			return statementGenerico;
		} catch (SQLException e) {
			return null;
		}
	}
	
	public Class[] arrayClases(Object[] objetos) {
		Class[] clasesObj = new Class[objetos.length];
		for (int i = 0; i < objetos.length; i++) {
			clasesObj[i] = objetos[i].getClass();
		}
		return clasesObj;
	}
	
	public String prepararQuery(int num, String tabla) {
		String query = "insert into " + tabla + " values(";
		for (int i = 0; i < num; i++) {
			query += "?,";
		}
		query = (query.substring(0, query.length() - 1)) + ");";
		return query;
	}
	
	public int guardarDepartamentos(ArrayList<Departamento> dptos) {
		PreparedStatement statement;
		String query;
		int resultado = 1;
		try {
			con = datasource.getConnection();
			
			
			for (int i=0; i<dptos.size();i++) {
				query = "insert into departamento values(?,?,?);";
				
				try {
					statement = con.prepareStatement(query);
					statement.setInt(1, dptos.get(i).getCodigo());
					statement.setString(2, dptos.get(i).getNombre());
					statement.setInt(3, dptos.get(i).getLocalizacion().getCodigo());
					
					statement.execute();
				} catch (SQLIntegrityConstraintViolationException e) {
					//TODO
					// Escribir en el log entrada duplicada
					resultado = 2;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			resultado = 0;
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return resultado;
	}
	
	public int guardarEmpleados(ArrayList<Empleado> empleados) {
		PreparedStatement statement;
		String query;
		//SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		int resultado = 1;
		try {
			con = datasource.getConnection();
			
			
			for (int i=0; i<empleados.size();i++) {
				query = "insert into empleado values(?,?,?,?,?,?,?,?);";
				
				try {
					statement = con.prepareStatement(query);
					statement.setString(1, empleados.get(i).getDni());
					statement.setString(2, empleados.get(i).getNombre());
					statement.setFloat(3, empleados.get(i).getSueldo());
					statement.setString(4, empleados.get(i).getCargo().getCodigo());
					statement.setInt(5, empleados.get(i).getDepartamento().getCodigo());
					if (empleados.get(i).isJefe()) {
						statement.setInt(6, 1);
					} else {
						statement.setInt(6, 0);
					}
					if (empleados.get(i).getCargo().getCodigo().equals("C001")) {
						statement.setString(7, null);
					} else {
						statement.setString(7, empleados.get(i).getResponsable().getDni());
					}
					//statement.setString(8, formatter.format(empleados.get(i).getFecha()));
					statement.setDate(8, new java.sql.Date((empleados.get(i).getFecha()).getTime()));
					
					statement.execute();
				} catch (SQLIntegrityConstraintViolationException e) {
					//TODO
					// Escribir en el log entrada duplicada
					resultado = 2;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			resultado = 0;
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return resultado;
	}
}
