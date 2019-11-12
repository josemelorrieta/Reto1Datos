package baseDatos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.Date;
import log.Logger;

import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

public class PoolConexiones {
	// BasicDataSource basicDataSource = new BasicDataSource();
	DataSource dataSource;
	private Logger logger;
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY - hh:mm:ss");
	
	public PoolConexiones() {
		this.logger = Logger.getSingletonInstance();
	}
	
	public DataSource CrearConexiones() {
		Properties propiedades = new Properties();

		try {
			propiedades.load(new FileInputStream("datasource_config.properties"));
		} catch (FileNotFoundException e) {
			System.out.println(e.getCause());
			logger.escribirLog(dateFormat.format(new Date()) + " - " + getClass().getName() + " - Fichero de datos no encontrado.");
			// Añadir a log fichero de datos conexión a base de datos no encontrado
			return null;
		} catch (IOException e) {
			System.out.println(e.getCause());
			logger.escribirLog(dateFormat.format(new Date()) + " - " + getClass().getName() + " - Base de datos no encontrada.");
			// Añadir a log fichero de datos conexión a base de datos no encontrado
			return null;
		}

		try {
			dataSource = BasicDataSourceFactory.createDataSource(propiedades);
		} catch (Exception e) {
			System.out.println(e.getCause());
			logger.escribirLog(dateFormat.format(new Date()) + " - " + getClass().getName() + " - Error en la conexión a la base de datos.");
			// Añadir log error en conexión a base de datos
			return null;
		}

		return dataSource;

	}
}
