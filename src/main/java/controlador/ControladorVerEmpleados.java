package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

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
		vista.pCentral.pVerEmple.btnVerEmple.addActionListener(new listenerBotones());
	}

	private class listenerBotones implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
			case "buscarDNI":
				vista.pCentral.pVerEmple.txtBusqNombre.setText("");
				buscarEmpleado("DNI", vista.pCentral.pVerEmple.txtBusqDNI.getText());
				break;
			case "buscarNombre":
				vista.pCentral.pVerEmple.txtBusqDNI.setText("");
				buscarEmpleado("Nombre", vista.pCentral.pVerEmple.txtBusqNombre.getText());
				break;
			case "ver":
				int index = vista.pCentral.pVerEmple.listEmpleados.getSelectedIndex();
				if (index != -1) {
					for (Empleado emple : modelo.empleados) {
						if (emple.getDni()
								.equals(vista.pCentral.pVerEmple.listModel.getElementAt(index).substring(0, 9))) {
							verDatosEmple(emple);
							break;
						}
					}
				}
			}
		}

	}

	public void initPanel() {
		vista.pCentral.pVerEmple.txtBusqDNI.setText("");
		vista.pCentral.pVerEmple.txtBusqNombre.setText("");

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
		ArrayList<Empleado> emples = new ArrayList<Empleado>();

		vista.pCentral.pVerEmple.listModel.removeAllElements();
		vista.pCentral.pVerEmple.listEmpleados.setModel(vista.pCentral.pVerEmple.listModel);

		if (campo.equals("DNI")) {
			for (Empleado e : modelo.empleados) {
				if (e.getDni().contentEquals(valor))
					emples.add(e);
			}

			if (emples.size() > 0) {
				verDatosEmple(emples.get(0));
			} else {
				JOptionPane.showMessageDialog(vista, "No existe ningún empleado con ese DNI", "Información",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} else if (campo.equals("Nombre")) {
			for (Empleado e : modelo.empleados) {
				if (e.getNombre().equals(valor)) {
					emples.add(e);
					vista.pCentral.pVerEmple.listModel.addElement(e.getDni() + " " + e.getNombre());
				}
			}
			vista.pCentral.pVerEmple.listEmpleados.setModel(vista.pCentral.pVerEmple.listModel);
		}

	}

	private void verDatosEmple(Empleado emple) {
		String esJefe;

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
	}

}
