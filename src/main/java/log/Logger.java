package log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
	private static Logger logger;
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY - hh:mm:ss");
	public String rutaArchivo;

	private Logger() {
		this.rutaArchivo = leerRutaDeFichero();
	}

	public static Logger getSingletonInstance() {
		if (logger == null) {
			logger = new Logger();
		}

		return logger;
	}

	public void escribirLog(String mensaje) {
		File f = null;
		BufferedWriter writer = null;
		PrintWriter printW = null;

		try {
			f = new File(rutaArchivo + "\\Log.txt");

			if (!f.exists()) {
				f.createNewFile();
			}
			
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f, true), StandardCharsets.UTF_8));
			printW = new PrintWriter(writer);
			printW.println(mensaje);
		} catch (IOException e1) {

		} finally {
			try {
				if (writer != null) {
					writer.close();
				}
				if (printW != null) {
					printW.close();
				}
			} catch (Exception e2) {
				logger.escribirLog(dateFormat.format(new Date()) + " - " + getClass().getName() + " - Error al cerrar fichero.");
			}
		}

	}

	private String leerRutaDeFichero() {

		String ruta = "";
		File fichero = new File("gestor.ini");
		if (fichero != null) {
			BufferedReader bufferLectura = null;
			try {
				bufferLectura = new BufferedReader(
						new InputStreamReader(new FileInputStream(fichero.getPath()), "UTF-8"));

				// Leer una linea del archivo
				String linea = null;
				linea = bufferLectura.readLine();

				if (linea != null) {
					ruta = linea;
				}
			} catch (Exception e) {
				logger.escribirLog(dateFormat.format(new Date()) + " - " + getClass().getName() + " - Ruta incorrecta.");
			} finally {
				// Cierro el buffer de lectura
				if (bufferLectura != null) {
					try {
						bufferLectura.close();
					} catch (IOException e) {
						logger.escribirLog(dateFormat.format(new Date()) + " - " + getClass().getName() + " - Error al cerrar.");
					}
				}
			}
		}

		return ruta;
	}
}
