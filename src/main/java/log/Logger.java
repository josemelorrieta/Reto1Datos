package log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import modelo.Centro;
import modelo.Departamento;

public class Logger {
	private static Logger logger;
	
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
		FileWriter fichero = null;
		BufferedWriter writer = null;
		PrintWriter printW = null;
		
		try {
			fichero = new FileWriter("C:\\Temp\\Log.txt", true);
		
			writer = new BufferedWriter(fichero);
			printW = new PrintWriter(writer);
			printW.println(mensaje);
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			try {
				if (writer != null) {
					writer.close();
				}
				if (printW != null) {
					printW.close();
				}
			} catch (Exception e2) {
				
			}
		}

	}
	
	private String leerRutaDeFichero() {
		
		String ruta = "";
		File fichero = new File("gestor.ini");
		if (fichero != null) {	
			BufferedReader bufferLectura = null;
			try {
				bufferLectura = new BufferedReader(new InputStreamReader(new FileInputStream(fichero.getPath()), "UTF-8"));
					
				// Leer una linea del archivo
				String linea = null;
				linea = bufferLectura.readLine();
					
				if (linea != null) {
					ruta = linea;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				// Cierro el buffer de lectura
				if (bufferLectura != null) {
					try {
						bufferLectura.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		return ruta;
	}
}
