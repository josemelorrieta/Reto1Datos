package baseDatos;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

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
			System.out.println(con.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
}
