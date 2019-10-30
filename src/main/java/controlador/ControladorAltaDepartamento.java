package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.Centro;
import modelo.Departamento;
import modelo.Modelo;
import vista.VentanaPpal;

public class ControladorAltaDepartamento {
	Modelo modelo;
	VentanaPpal vista;
	ArrayList<String> nombresCentros = new ArrayList<String>();
	
	public ControladorAltaDepartamento(Modelo modelo, VentanaPpal vista) {
		this.modelo = modelo;
		this.vista = vista;
		
		initListeners();
	}
	
	public void initListeners() {
		vista.pCentral.pAltaDepart.btnDarDeAlta.addActionListener(new listenerBotones());
	}
	
	private class listenerBotones implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
				case "alta":
					nuevoDpto();
			}
		}
	}
	
	public void initAltaDpto() {
		vista.pCentral.pAltaDepart.txtCodDpto.setText(Integer.toString(this.modelo.dptos.size() + 1));
		vista.pCentral.pAltaDepart.txtNombreDpto.setText("");
		vista.pCentral.pAltaDepart.cmbLocalizacion.removeAll();
		
		nombresCentros.clear();
		vista.pCentral.pAltaDepart.cmbLocalizacion.removeAllItems();
		
		for (Centro centro: this.modelo.centros) {
			if (!nombresCentros.contains(centro.getNombre()))
				nombresCentros.add(centro.getNombre());
		}
		
		for (String nombre: nombresCentros ) {
			vista.pCentral.pAltaDepart.cmbLocalizacion.addItem(nombre);
		}
	}
	
	private void nuevoDpto() {
		Centro centro = null;
		
		for (Centro c: this.modelo.centros) {
			if(c.getNombre().equals(this.vista.pCentral.pAltaDepart.cmbLocalizacion.getSelectedItem().toString())) {
				centro = c;
			}
		}
		
		if (centro != null) {
			ArrayList<Departamento> dptos = new ArrayList<Departamento>();
			dptos.add(new Departamento(Integer.parseInt(vista.pCentral.pAltaDepart.txtCodDpto.getText()), vista.pCentral.pAltaDepart.txtNombreDpto.getText(), centro));
			if (Modelo.bd.guardarDepartamentos(dptos) == 1) {
				this.modelo.dptos.add(dptos.get(0));
				JOptionPane.showMessageDialog(this.vista, "El departamento se ha guardado en la base de datos", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this.vista, "El Departamento no se ha guardado en la base de datos.", "¡ATENCIÓN!", JOptionPane.WARNING_MESSAGE);
			}
		}
	}
		
		
	
}
