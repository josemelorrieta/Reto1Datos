package modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class XMLHandler extends DefaultHandler {

	private String valor = null;    
	private Empleado empleado;
	private Cargo cargo;
	private Cargo[] cargos;
	private ConexionBD conBD;
	private Departamento dpto;
	private ArrayList<Departamento> dptos;
	private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
	
   private ArrayList<Empleado> empleados = new ArrayList<Empleado>(); 
   
   public XMLHandler(ArrayList<Departamento> dptos, Cargo[] cargos, ConexionBD conBD) {
		  this.cargos = cargos;
		  this.conBD = conBD;
		  this.dptos = dptos;
   }
	   
   public ArrayList<Empleado> cargarEmpleados() {  

      return empleados;
   }  
	  
   @Override
   public void startElement(String uri, String localName, String name, Attributes attributes) throws SAXException {  
	
	 valor = null;  
         
	  if(name.equalsIgnoreCase("empleado")){  
	     empleado = new Empleado();
	  }
   }
     
   @Override  
   public void characters(char[] ch, int start, int length) throws SAXException {
      
      valor = new String(ch,start,length);
   }
  
   @Override  
   public void endElement(String uri, String localName, String name) throws SAXException {  
      
	   switch (name.toLowerCase()) {
	   	  case "dni": empleado.setDni(valor);break;
	   	  case "nombre": empleado.setNombre(valor); break;
	   	  case "sueldo": empleado.setSueldo(Float.parseFloat(valor));break;
	   	  case "cargo":
	   		  cargo = conBD.buscarCargo(cargos, valor);
	   		  if (cargo != null) {
	   			  empleado.setCargo(cargo);
	   		  }
	   		  break;
	   	  case "departamento":
			  dpto = conBD.buscarDpto(dptos, Integer.parseInt(valor));
			  if (dpto != null) {
				  empleado.setDepartamento(dpto);
			  }
			  break;
	   	  case "jefe":
	   		  if (valor.contentEquals("1")) {
	   			  empleado.setJefe(true);
	   		  } else {
	   			empleado.setJefe(false);
	   		  }
	   		  break;
	   	  case "responsable":
	   		  if (empleados.size() != 0) {
	   			  for (Empleado emple: empleados) {
	   				  if (emple.getDni().equals(valor)) {
	   					  empleado.setResponsable(emple);
	   				  }
	   			  }	   			  
	   		  }
	   		break;
	   	  /*case "fecha": try {
	   		  empleado.setFecha(formatter.parse(valor));
	   	  	} catch (ParseException e) {
				e.printStackTrace();
			}
	   	  	break;*/
	   	  case "empleado":
	   		  empleados.add(empleado);
	   }
   }

}
