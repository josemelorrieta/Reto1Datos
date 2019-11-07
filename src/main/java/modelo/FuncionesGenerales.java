package modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;

public class FuncionesGenerales {
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
			e.printStackTrace();
			return false;
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
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
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
}
