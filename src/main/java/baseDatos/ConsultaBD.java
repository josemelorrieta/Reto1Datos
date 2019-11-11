package baseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.sql.DataSource;

import log.Logger;
import modelo.Departamento;
import modelo.Empleado;

public class ConsultaBD {
	private static ConsultaBD consultaBD;

	private PoolConexiones pool;
	private DataSource datasource;
	private Connection con;
	private Logger logger;
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY - hh:mm:ss");

	private ConsultaBD() {
		this.pool = new PoolConexiones();
		this.datasource = pool.CrearConexiones();
		this.logger = Logger.getSingletonInstance();

		try {
			con = datasource.getConnection();
		} catch (SQLException e) {
			logger.escribirLog(dateFormat.format(new Date()) + " - " + getClass().getName() + " - "
					+ e.getStackTrace()[0].getMethodName() + " - Error en la conexión a la base de datos.");

		}
	}

	public static ConsultaBD getSingletonInstance() {
		if (consultaBD == null) {
			consultaBD = new ConsultaBD();
		}

		return consultaBD;
	}

	public Connection getCon() {
		return con;
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
			logger.escribirLog(dateFormat.format(new Date()) + " - " + getClass().getName()
					+ " - Error en la consulta a la base de datos.");
			return null;
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				logger.escribirLog(dateFormat.format(new Date()) + " - " + getClass().getName() + " - "
						+ e.getStackTrace()[0].getMethodName() + " - Error al cerrar la conexión");

				return null;
			}
		}
	}

	public int guardarDepartamentos(ArrayList<Departamento> dptos) {
		PreparedStatement statement = null;
		String query;
		int resultado = 1;
		try {
			con = datasource.getConnection();

			for (int i = 0; i < dptos.size(); i++) {
				query = "insert into departamento values(?,?,?);";

				try {
					statement = con.prepareStatement(query);
					statement.setInt(1, dptos.get(i).getCodigo());
					statement.setString(2, dptos.get(i).getNombre());
					statement.setInt(3, dptos.get(i).getLocalizacion().getCodigo());

					statement.execute();
				} catch (SQLIntegrityConstraintViolationException e) {
					logger.escribirLog(dateFormat.format(new Date()) + " - " + getClass().getName() + " - "
							+ e.getStackTrace()[0].getMethodName() + " - error en la query.");

					resultado = 2;
				}
			}
		} catch (Exception e) {
			logger.escribirLog(dateFormat.format(new Date()) + " - " + getClass().getName() + " - "
					+ e.getStackTrace()[0].getMethodName() + " - Error al insertar departamento.");

			resultado = 0;
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				logger.escribirLog(dateFormat.format(new Date()) + " - " + getClass().getName() + " - "
						+ e.getStackTrace()[0].getMethodName() + " - Error al cerrar conexión.");

			}
		}

		return resultado;
	}

	public int guardarEmpleados(ArrayList<Empleado> empleados) {
		PreparedStatement statement;
		String query;
		// SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		int resultado = 1;
		try {
			con = datasource.getConnection();

			for (int i = 0; i < empleados.size(); i++) {
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
					statement.setDate(8, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));

					statement.execute();
				} catch (SQLIntegrityConstraintViolationException e) {
					logger.escribirLog(dateFormat.format(new Date()) + " - " + getClass().getName() + " - "
							+ e.getStackTrace()[0].getMethodName() + " - Error en la query.");

					resultado = 2;
				}
			}
		} catch (Exception e) {
			logger.escribirLog(dateFormat.format(new Date()) + " - " + getClass().getName() + " - "
					+ e.getStackTrace()[0].getMethodName() + " - Error al insertar empleado.");

			resultado = 0;
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				logger.escribirLog(dateFormat.format(new Date()) + " - " + getClass().getName() + " - "
						+ e.getStackTrace()[0].getMethodName() + " - Error al cerrar la conexión.");

			}
		}

		return resultado;
	}
}
