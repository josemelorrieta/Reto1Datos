package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import com.google.gson.Gson;

import baseDatos.ConsultaBD;

public class ConexionBD {
	private Gson gson = new Gson();
	
//	public ConexionBD () {
//		
//	}
//	
//	public void cargarDptosInicio() {
//		ArrayList<Departamento> dptos;
//		
//		dptos = cargarDptosDeFichero();
//	}
	
	public Centro[] cargarCentros(ConsultaBD conBD) {
		Centro[] centros;

		String json = conBD.consultarToGson("SELECT * FROM `centro`");
		centros = gson.fromJson(json, Centro[].class);
		
		return centros;
	}
	
	public Cargo[] cargarCargos(ConsultaBD conBD) {
		Cargo[] cargos;

		String json = conBD.consultarToGson("SELECT * FROM `cargo`");
		cargos = gson.fromJson(json, Cargo[].class);
		
		return cargos;
	}
	
	public ArrayList<Departamento> cargarDptos(ConsultaBD conBD, Centro[] centros) {
		DepartamentoBD[] arrayDptos;
		Centro centro = null;
		
		String json = conBD.consultarToGson("SELECT * FROM departamento");
		arrayDptos = gson.fromJson(json, DepartamentoBD[].class);
		
		ArrayList<Departamento> dptos = new ArrayList<Departamento>();
		
		for (DepartamentoBD dpto: arrayDptos) {
			for  (int i=0;i<centros.length;i++) {
				if (centros[i].getCodigo() == dpto.getLocalizacion()) {
					centro = centros[i];
				}
			}
			
			dptos.add(new Departamento(dpto.getCodigo(), dpto.getNombre(), centro));
		}
		
		return dptos;		
	}
	
	public ArrayList<Empleado> cargarEmpleados(ConsultaBD conBD, Cargo[] cargos, ArrayList<Departamento> departamentos) {
		EmpleadoBD[] arrayEmpleados;
		Cargo cargo = null;
		Departamento departamento = null;
		Empleado responsable = null;
		boolean esJefe = false;
		Date fecha = null;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		String json = conBD.consultarToGson("SELECT * FROM empleado");
		arrayEmpleados = gson.fromJson(json, EmpleadoBD[].class);
		
		ArrayList<Empleado> empleados = new ArrayList<Empleado>();
		
		for (EmpleadoBD emple: arrayEmpleados) {
			for (int i=0;i<cargos.length;i++) {
				if (cargos[i].getCodigo().equals(emple.getCargo())) {
					cargo = cargos[i];
				}
			}
			
			for (int i=0;i<departamentos.size();i++) {
				if (departamentos.get(i).getCodigo() == emple.getDepartamento()) {
					departamento = departamentos.get(i);
				}
			}
			
			if (emple.getJefe() == 1) {
				esJefe = true;
			} else {
				esJefe = false;
			}
			
			try {
				fecha = formatter.parse(emple.getFecha());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			if (!emple.getCargo().equals("C001")) {
				for (Empleado resp: empleados) {
					if (resp.getDni().equals(emple.getResponsable())) {
						responsable = resp;
					}
				}
			}
			
			empleados.add(new Empleado(emple.getDni(), emple.getNombre(), emple.getSueldo(), cargo, departamento, esJefe, responsable, fecha));
		}
		
		return empleados;		
	}
	
	public ArrayList<Departamento> cargarDptosDeFichero(Centro[] centros) {
		ArrayList<Departamento> dptos = new ArrayList<Departamento>();
		File fichero = new File("Departamentos.csv");
		if (fichero != null) {
			final String SEPARADOR = ";";
			Departamento dpto = null;
	
			BufferedReader bufferLectura = null;
			try {
				// Abrir el .csv en buffer de lectura
				try {
					bufferLectura = new BufferedReader(new InputStreamReader(new FileInputStream(fichero.getPath()), "UTF-8"));
				} catch (UnsupportedEncodingException e2) {
					e2.printStackTrace();
				}
	
				// Leer una linea del archivo
				String linea = null;
				try {
					linea = bufferLectura.readLine();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	
				while (linea != null) {
					// Sepapar la linea leida con el separador definido previamente
					String[] campos = linea.split(SEPARADOR, -1); // opción -1 para que siempre sea un array de 8 aunque los últimos campos estén vacíos
	
					if (!campos[0].equals("Departamento")) {
						dpto = new Departamento();
						dpto.setCodigo(Integer.parseInt(campos[0]));
						dpto.setNombre(campos[1]);
						Centro centro = buscarCentro(centros, Integer.parseInt(campos[2]));
						if (centro != null) {
							dpto.setLocalizacion(centro);
						}
					}
					if (dpto != null) {
						dptos.add(dpto);
					}
					// Volver a leer otra línea del fichero
					try {
						linea = bufferLectura.readLine();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			} catch (FileNotFoundException fnE) {
				System.out.println("Fichero de datos de depatamentos iniciales no encontrado en la ruta " + fichero.getAbsolutePath());
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
		return dptos;
	}
	
	public Centro buscarCentro(Centro[] centros, int codCentro) {
		Centro centro = null;
		
		for (int i=0;i<centros.length;i++) {
			if (centros[i].getCodigo() == codCentro) {
				centro = centros[i];
				break;
			}
		}
		
		return centro;
	}
	
	public Cargo buscarCargo(Cargo[] cargos, String codCargo) {
		Cargo cargo = null;
		
		for (int i=0;i<cargos.length;i++) {
			if (cargos[i].getCodigo().equals(codCargo)) {
				cargo = cargos[i];
				break;
			}
		}
		
		return cargo;
	}
	
	public Departamento buscarDpto(ArrayList<Departamento> dptos, int codDpto) {
		Departamento dpto = null;
		
		for (int i=0;i<dptos.size();i++) {
			if (dptos.get(i).getCodigo() == codDpto) {
				dpto = dptos.get(i);
				break;
			}
		}
		
		return dpto;
	}
	
	public ArrayList<Empleado> cargarEmpleadosDeFichero(ArrayList<Departamento> dptos, Cargo[] cargos) {
		ArrayList<Empleado> empleados = null;
		
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
				
		File fichero = new File("Empleados.xml");
		if (fichero != null) {
		    try {
		        SAXParser saxParser = saxParserFactory.newSAXParser();
		        XMLHandler handler = new XMLHandler(dptos, cargos, this);
		        saxParser.parse(fichero, handler);
		        
		        empleados = handler.cargarEmpleados();
		        		              
		    } catch (ParserConfigurationException | SAXException | IOException e) {
		        e.printStackTrace();
		    }
		}
		
		return empleados;
	}
	
	public int inicializarTablas(Modelo modelo) {
		//Departamento[] departamentos = modelo.dptos.toArray(new Departamento[modelo.dptos.size()]); 
		int resultadoDptos = 0;
		int resultadoEmple = 0;
		
		resultadoDptos = Modelo.bd.guardarDepartamentos(modelo.dptos);
		resultadoEmple = Modelo.bd.guardarEmpleados(modelo.empleados);
		
		if (resultadoDptos == 1 && resultadoEmple == 1) {
			return 1;
		} else if (resultadoDptos == 0 || resultadoEmple == 0) {
			return 0;
		} else {
			return 2;
		}
	}

}
