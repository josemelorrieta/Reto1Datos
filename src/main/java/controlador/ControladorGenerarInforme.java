package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JFileChooser;

import modelo.Departamento;
import modelo.Empleado;
import modelo.Modelo;
import vista.VentanaPpal;

public class ControladorGenerarInforme {
	private Modelo modelo;
	private VentanaPpal vista;
	
	public ControladorGenerarInforme(VentanaPpal vista, Modelo modelo) {
		this.modelo = modelo;
		this.vista = vista;
		initListeners();
	}
	
	private void initListeners() {
		vista.pCentral.pInformes.btnGenerarInformeDepart.addActionListener(new ListenerMenu());
		vista.pCentral.pInformes.btnGenerarInformeEmple.addActionListener(new ListenerMenu());
	}
	
	private class ListenerMenu implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
			case "informeDepart":
				generarInformeDepart(modelo.dptos);
				break;
			case "informeEmple":
				generarInformeEmple(modelo.empleados);
				break;
			}
			
		}
		
	}
	
	public void generarInformeDepart(ArrayList<Departamento> dptos) {
		FileWriter fichero = null;
		String ruta = elegirCarpeta();
		
		try {
			fichero = new FileWriter(ruta + "\\Informe departamentos.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (fichero != null) {
			BufferedWriter writer = new BufferedWriter(fichero);
			PrintWriter printW = new PrintWriter(writer);
			printW.println("**************************************************");
			printW.println("*		INFORME DEPARTAMENTOS		 *");
			printW.println("**************************************************");
			try {
				for (int i=0;i<dptos.size();i++) {
					
					printW.println("C�digo: " + dptos.get(i).getCodigo());
					printW.println("Nombre: " + dptos.get(i).getNombre());
					
					printW.println("Localizaci�n del centro:");
					printW.println("	C�digo del centro: " + dptos.get(i).getLocalizacion().getCodigo());
					printW.println("	Nombre del centro: " + dptos.get(i).getLocalizacion().getNombre());
					printW.println();
					printW.println("**************************************************");
					
					printW.println();
				}
				writer.close();
			System.out.println("El Informe departamentos.txt se gener� correctamente");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("Hubo un error a la hora de generar el fichero.");
		}
	}
	
	public void generarInformeEmple(ArrayList<Empleado> emple) {
		FileWriter fichero = null;
		String ruta = elegirCarpeta();
		
		try {
			fichero = new FileWriter(ruta + "\\Informe empleados.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (fichero != null) {
			BufferedWriter writer = new BufferedWriter(fichero);
			PrintWriter printW = new PrintWriter(writer);
			printW.println("**************************************************");
			printW.println("*		INFORME EMPLEADOS		 *");
			printW.println("**************************************************");
			try {
				for (int i=0;i<emple.size();i++) {
					
					printW.println("DNI: " + emple.get(i).getDni());
					printW.println("Nombre: " + emple.get(i).getNombre());
					printW.println("Sueldo: " + emple.get(i).getSueldo() + " �");
					printW.println("Cargo: " + emple.get(i).getCargo().getNombre());
					printW.println("Departamento: " );
					printW.println("	C�digo: " + emple.get(i).getDepartamento().getCodigo());
					printW.println("	Nombre: " + emple.get(i).getDepartamento().getNombre());
					printW.println("Localizaci�n del centro:");
					printW.println("	C�digo del centro: " + emple.get(i).getDepartamento().getLocalizacion().getCodigo());
					printW.println("	Nombre del centro: " + emple.get(i).getDepartamento().getLocalizacion().getNombre());
					printW.println("Jefe: " + emple.get(i).respuestaJefe());
					printW.println("Responsable: " );
					
					if(emple.get(i).getResponsable() != null) {
						printW.println("	DNI responsable: " + emple.get(i).getResponsable().getDni());
						printW.println("	Nombre responsable: " + emple.get(i).getResponsable().getNombre());
						printW.println("	Cargo responsable: " + emple.get(i).getResponsable().getCargo().getNombre());
						
					}
					else
					printW.println("	Este empleado no tiene responsable asociado. " );
					
				
					printW.println("Fecha de alta: " + emple.get(i).getFecha());
					
					printW.println();
					printW.println("**************************************************");
					
					printW.println();
				}
				writer.close();
				System.out.println("El Informe empleados.txt se gener� correctamente");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("Hubo un error a la hora de generar el fichero.");
		}
	}
	
	public String elegirCarpeta() {
		
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		
		fileChooser.showDialog(null, "Seleccionar");
		
		System.out.println(fileChooser.getSelectedFile().getAbsolutePath());
		
		return fileChooser.getSelectedFile().getAbsolutePath();
	}
	
}
