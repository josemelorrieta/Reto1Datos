package modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import java.text.SimpleDateFormat;
import java.util.Date;

import log.Logger;

import javax.swing.JFileChooser;

public class FuncionesGenerales {
	private Logger logger;
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY - hh:mm:ss");

	public FuncionesGenerales() {
		this.logger = Logger.getSingletonInstance();

	}
	public String elegirCarpeta() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

		fileChooser.showDialog(null, "Seleccionar");

		if (fileChooser.getSelectedFile() != null)
			return fileChooser.getSelectedFile().getAbsolutePath();
		else
			return "";
	}

	public boolean guardarRutaLog(String ruta) {
		FileWriter fichero = null;
		BufferedWriter writer = null;

		try {
			File f = new File(ruta + "\\Log.txt");

			if (!f.exists()) {
				f.createNewFile();
			}

			fichero = new FileWriter("gestor.ini");

			writer = new BufferedWriter(fichero);
			PrintWriter printW = new PrintWriter(writer);
			printW.println(ruta);
		} catch (Exception e) {
			logger.escribirLog(dateFormat.format(new Date()) + " - " + getClass().getName() + " - "
					+ e.getStackTrace()[0].getMethodName() + " - error al cargar/crear fichero.");

			return false;
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					logger.escribirLog(dateFormat.format(new Date()) + " - " + getClass().getName() + " - "
							+ e.getStackTrace()[0].getMethodName() + " - Error al cerrar fichero.");

				}
			}
		}

		return true;
	}

	public boolean borrarFichero(String ruta) {
		File f = null;

		try {
			f = new File(ruta);

			if (f.exists()) {
				f.delete();
				f.createNewFile();
			} else {
				return false;
			}

		} catch (Exception e) {
			logger.escribirLog(dateFormat.format(new Date()) + " - " + getClass().getName() + " - "
					+ e.getStackTrace()[0].getMethodName() + " - Error al borrar ficher.");

			return false;
		}

		return true;
	}
}
