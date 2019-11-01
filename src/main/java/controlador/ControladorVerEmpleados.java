package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import modelo.Empleado;
import modelo.Modelo;
import vista.VentanaPpal;

public class ControladorVerEmpleados {
	private Modelo modelo;
	private VentanaPpal vista;
	private NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance();
	private SimpleDateFormat formatoFecha = new SimpleDateFormat("dd / MM / yyyy");
	
	public ControladorVerEmpleados(Modelo modelo, VentanaPpal vista) {
		this.modelo = modelo;
		this.vista = vista;
		
		initListeners();
	}
	
	public void initListeners() {
		vista.pCentral.pVerEmple.btnBuscarDNI.addActionListener(new listenerBotones());
		vista.pCentral.pVerEmple.btnBuscarNombre.addActionListener(new listenerBotones());
	}
	
	private class listenerBotones implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
				case "buscarDNI": buscarEmpleado("DNI", vista.pCentral.pVerEmple.txtBusqDNI.getText());
					break;
				case "buscarNombre": buscarEmpleado("Nombre", vista.pCentral.pVerEmple.txtBusqNombre.getText());
					break;
			}			
		}
		
	}
	
	public void initPanel() {
		vista.pCentral.pVerEmple.lblDNI.setText("");
		vista.pCentral.pVerEmple.lblNombre.setText("");
		vista.pCentral.pVerEmple.lblSueldo.setText("");
		vista.pCentral.pVerEmple.lblCargo.setText("");
		vista.pCentral.pVerEmple.lblDpto.setText("");
		vista.pCentral.pVerEmple.lblResponsable.setText("");
		vista.pCentral.pVerEmple.lblFecha.setText("");
		vista.pCentral.pVerEmple.lblJefe.setText("");
	}
	
	private void buscarEmpleado(String campo, String valor) {
		Empleado emple = null;
		
		if (campo.equals("DNI")) {
			for (Empleado e: modelo.empleados) {
				if (e.getDni().contentEquals(valor))
					emple = e;
			}
		} else if (campo.equals("Nombre")) {
			for (Empleado e: modelo.empleados) {
				if (e.getNombre().equals(valor))
					emple = e;
			}
		}

		
		String esJefe;
		if (emple != null) {	
			if (emple.isJefe())
				esJefe = "SI";
			else
				esJefe = "NO";
			
			vista.pCentral.pVerEmple.lblDNI.setText(emple.getDni());
			vista.pCentral.pVerEmple.lblNombre.setText(emple.getNombre());
			vista.pCentral.pVerEmple.lblSueldo.setText(formatoMoneda.format(emple.getSueldo()));
			vista.pCentral.pVerEmple.lblCargo.setText(emple.getCargo().getNombre());
			vista.pCentral.pVerEmple.lblDpto.setText(emple.getDepartamento().getNombre());
			if (emple.getResponsable() != null)
				vista.pCentral.pVerEmple.lblResponsable.setText(emple.getResponsable().getNombre());
			vista.pCentral.pVerEmple.lblFecha.setText(formatoFecha.format(emple.getFecha()));
			vista.pCentral.pVerEmple.lblJefe.setText(esJefe);
		} else {
			JOptionPane.showMessageDialog(this.vista, "No existen coinidencias en la base de datos", "Información", JOptionPane.INFORMATION_MESSAGE);
		}

	}

}
