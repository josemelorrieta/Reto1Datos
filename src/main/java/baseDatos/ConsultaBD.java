package baseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

import modelo.Departamento;

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
}
