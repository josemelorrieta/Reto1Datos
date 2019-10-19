package baseDatos;

import java.sql.Connection;

import javax.sql.DataSource;

public class ConsultaBD {
	private static ConsultaBD consultaBD;
	
	private PoolConexiones pool;
	private DataSource datasource;
	private Connection con;
	
	private ConsultaBD() {
		pool = new PoolConexiones();
		datasource = pool.CrearConexiones();
		con = null;
	}

	public static ConsultaBD getSingletonInstance() {
		if (consultaBD == null) {
			consultaBD = new ConsultaBD();
		} else {
			
		}
		
		return consultaBD;
	}
}
