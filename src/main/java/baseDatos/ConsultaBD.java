package baseDatos;

import java.sql.Connection;
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
}
