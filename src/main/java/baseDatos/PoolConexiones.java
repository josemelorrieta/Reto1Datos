package baseDatos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

public class PoolConexiones {
	//BasicDataSource basicDataSource = new BasicDataSource();
	DataSource dataSource;
	
	public DataSource CrearConexiones() {	
		Properties propiedades = new Properties();
		
		try {
			propiedades.load(new FileInputStream("datasource_config.properties"));
		} catch (FileNotFoundException e) {
			System.out.println(e.getCause());
			e.printStackTrace();
			// Añadir a log fichero de datos conexión a base de datos no encontrado 
			return null;
		} catch (IOException e) {
			System.out.println(e.getCause());
			e.printStackTrace();
			// Añadir a log fichero de datos conexión a base de datos no encontrado 
			return null;
		}
	
		try {
			dataSource = BasicDataSourceFactory.createDataSource(propiedades);
		} catch (Exception e) {
			System.out.println(e.getCause());
			e.printStackTrace();
			// Añadir log error en conexión a base de datos 
			return null;
		}
		
		return dataSource;

	}
}
