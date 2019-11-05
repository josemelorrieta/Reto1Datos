package log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {
	private static Logger logger;
	
	private String rutaArchivo;
	
	private Logger() {
		this.rutaArchivo = "C:\\Temp\\Log.txt";
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

}
