package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

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
		BufferedWriter writer = null;
		String ruta = modelo.funGen.elegirCarpeta();
		
		if (!ruta.equals("")) {
			try {
				fichero = new FileWriter(ruta + "\\Informe departamentos.txt");
				
				writer = new BufferedWriter(fichero);
				PrintWriter printW = new PrintWriter(writer);
				printW.println("**************************************************");
				printW.println("*		INFORME DEPARTAMENTOS		 *");
				printW.println("**************************************************");
				
				for (int i=0;i<dptos.size();i++) {
					
					printW.println("Código: " + dptos.get(i).getCodigo());
					printW.println("Nombre: " + dptos.get(i).getNombre());
					
					printW.println("Localización del centro:");
					printW.println("	Código del centro: " + dptos.get(i).getLocalizacion().getCodigo());
					printW.println("	Nombre del centro: " + dptos.get(i).getLocalizacion().getNombre());
					printW.println();
					printW.println("**************************************************");
					
					printW.println();
				}
				
				writer.close();
				JOptionPane.showMessageDialog(vista, "El fichero " + ruta + "\\Informe departamentos.txt se generó correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(vista, "Hubo un error a la hora de generar el fichero.", "Información", JOptionPane.INFORMATION_MESSAGE);
				e.printStackTrace();
			} finally {
				try {
					if (writer != null)
						writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void generarInformeEmple(ArrayList<Empleado> emple) {
		FileWriter fichero = null;
		BufferedWriter writer = null;
		String ruta = modelo.funGen.elegirCarpeta();
		
		if (!ruta.equals("")) {
			try {
				fichero = new FileWriter(ruta + "\\Informe empleados.txt");
					
				writer = new BufferedWriter(fichero);
				PrintWriter printW = new PrintWriter(writer);
				printW.println("**************************************************");
				printW.println("*		INFORME EMPLEADOS		 *");
				printW.println("**************************************************");
				
				for (int i=0;i<emple.size();i++) {
					
					printW.println("DNI: " + emple.get(i).getDni());
					printW.println("Nombre: " + emple.get(i).getNombre());
					printW.println("Sueldo: " + emple.get(i).getSueldo() + " €");
					printW.println("Cargo: " + emple.get(i).getCargo().getNombre());
					printW.println("Departamento: " );
					printW.println("	Código: " + emple.get(i).getDepartamento().getCodigo());
					printW.println("	Nombre: " + emple.get(i).getDepartamento().getNombre());
					printW.println("Localización del centro:");
					printW.println("	Código del centro: " + emple.get(i).getDepartamento().getLocalizacion().getCodigo());
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
				JOptionPane.showMessageDialog(vista, "El fichero " + ruta + "\\Informe empleados.txt se generó correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(vista, "Hubo un error a la hora de generar el fichero.", "Información", JOptionPane.INFORMATION_MESSAGE);
				e.printStackTrace();
			} finally {
				try {
					if (writer != null)
						writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} 
	}

	
}
