package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import modelo.Cargo;
import modelo.Departamento;
import modelo.Empleado;
import modelo.Modelo;
import vista.PanelAltaEmpleado;
import vista.VentanaPpal;

public class ControladorAltaEmpleado {
	private Modelo modelo;
	private VentanaPpal vista;
	
	public ControladorAltaEmpleado(Modelo modelo, VentanaPpal vista) {
		this.modelo = modelo;
		this.vista = vista;
		
		initListeners();
	}
	
	private void initListeners() {
		vista.pCentral.pAltaEmpleado.btnAlta.addActionListener(new listenerBotones());
	}
	
	private class listenerBotones implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
				case "alta":
					nuevoEmple();
					break;
			}
		}
		
	}
	
	public void initAltaEmple() {
		vista.pCentral.pAltaEmpleado.cmbCargos.removeAllItems();
		vista.pCentral.pAltaEmpleado.cmbDptos.removeAllItems();
		vista.pCentral.pAltaEmpleado.cmbResponsable.removeAllItems();
		
		for (Cargo cargo: modelo.cargos) {
			if (!cargo.getCodigo().equals("C001"))
				vista.pCentral.pAltaEmpleado.cmbCargos.addItem(cargo.getNombre());
		}
		
		for (Departamento dpto: modelo.dptos) {
			vista.pCentral.pAltaEmpleado.cmbDptos.addItem(dpto.getNombre());
		}
		
		for (Empleado resp: modelo.empleados) {
			if (resp.isJefe())
				vista.pCentral.pAltaEmpleado.cmbResponsable.addItem(resp.getNombre());
		}
		
		vista.pCentral.pAltaEmpleado.txtCodEmple.setText("");
		vista.pCentral.pAltaEmpleado.txtNombreEmple.setText("");
		vista.pCentral.pAltaEmpleado.txtSueldo.setText("");
	
	}
	
	private void nuevoEmple() {
		PanelAltaEmpleado panel = vista.pCentral.pAltaEmpleado;
		
		if (validacionDatos(panel.txtCodEmple.getText(), panel.txtNombreEmple.getText(), panel.txtSueldo.getText())) {
			ArrayList<Empleado> empleados = new ArrayList<Empleado>();
			
			Cargo cargo = buscarCargo(panel.cmbCargos.getSelectedItem().toString());
			Departamento dpto = buscarDpto(panel.cmbDptos.getSelectedItem().toString());
			Empleado responsable = buscarResponsable(panel.cmbResponsable.getSelectedItem().toString());
			
			Boolean esJefe;
			
			if (panel.cmbJefe.getSelectedItem().equals("SI")) {
				esJefe = true;
			} else {
				esJefe = false;
			}
			
			Date fecha = new Date();
	
			empleados.add(new Empleado(panel.txtCodEmple.getText(), panel.txtNombreEmple.getText(), Float.parseFloat(panel.txtSueldo.getText()), cargo, dpto, esJefe, responsable, fecha));
			if (Modelo.bd.guardarEmpleados(empleados) == 1) {
				this.modelo.empleados.add(empleados.get(0));
				JOptionPane.showMessageDialog(this.vista, "El empleado se ha guardado en la base de datos", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
				initAltaEmple();
			} else {
				JOptionPane.showMessageDialog(this.vista, "ERROR al guardar el empleado en la base de datos.", "¡ATENCIÓN!", JOptionPane.ERROR_MESSAGE);
			}
			
		}
	}

	private boolean validacionDatos(String dni, String nombre, String sueldo) {
		boolean validacion = false;
		String dniRegexp = "^[0-9]{7,8}['T|R|W|A|G|M|Y|F|P|D|X|B|N|J|Z|S|Q|V|H|L|C|K|E]$";
		String sueldoRegexp = "^[0-9]+([.][0-9]+)?$";
		
		if (!dni.equals("") && !nombre.equals("") && !sueldo.contentEquals("")) {
			if(dni.matches(dniRegexp)) {
				if (validarLetraDNI(dni)) {
					if (sueldo.matches(sueldoRegexp)) {
						validacion = true;
					} else {
						JOptionPane.showMessageDialog(this.vista,  "Debe introducir un sueldo válido (separador decimal . )", "Aviso", JOptionPane.WARNING_MESSAGE);
						validacion = false;
					}
				} else {
					JOptionPane.showMessageDialog(this.vista,  "La letra del DNI no es correcta", "Aviso", JOptionPane.WARNING_MESSAGE);
					validacion = false;
				}
			} else {
				JOptionPane.showMessageDialog(this.vista,  "Debe introducir un DNI válido", "Aviso", JOptionPane.WARNING_MESSAGE);
				validacion = false;
			}
				
		} else {
			JOptionPane.showMessageDialog(this.vista,  "Debe rellenar todos los campos", "Aviso", JOptionPane.WARNING_MESSAGE);
			validacion = false;
		}
		
		return validacion;
	}
	
	private Cargo buscarCargo(String nombreCargo) {
		Cargo cargo = null;
		
		for (Cargo c: modelo.cargos) {
			if (nombreCargo.equals(c.getNombre())) {
				cargo = c;
			}
		}
		
		return cargo;
	}
	
	private Departamento buscarDpto(String nombreDpto) {
		Departamento dpto = null;
		
		for (Departamento d: modelo.dptos) {
			if (nombreDpto.contentEquals(d.getNombre())) {
				dpto = d;
			}
		}
		
		return dpto;
	}
	
	private Empleado buscarResponsable(String nombre) {
		Empleado resp = null;
		
		for (Empleado e: modelo.empleados) {
			if (nombre.contentEquals(e.getNombre())) {
				resp = e;
			}
		}
		
		return resp;
	}
	
	private boolean validarLetraDNI(String dni) {
		String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
		
		
		if (letras.substring(Integer.parseInt(dni.substring(0, 8))%23, Integer.parseInt(dni.substring(0, 8))%23 + 1).equals(dni.substring(8, 9)))
			return true;
		else
			return false;
	}
}
