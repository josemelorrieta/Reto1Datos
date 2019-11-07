package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Modelo;
import vista.VentanaPpal;

public class ControladorVerDepartamento {
	Modelo modelo;
	VentanaPpal vista;
	int indexDpto = 0;
	
	public ControladorVerDepartamento(Modelo modelo, VentanaPpal vista) {
		this.modelo = modelo;
		this.vista = vista;
		
		initListeners();
	}
	
	private void initListeners() {
		vista.pCentral.pVerDepart.btnPrimero.addActionListener(new listenerBotones());
		vista.pCentral.pVerDepart.btnAnterior.addActionListener(new listenerBotones());
		vista.pCentral.pVerDepart.btnSiguiente.addActionListener(new listenerBotones());
		vista.pCentral.pVerDepart.btnUltimo.addActionListener(new listenerBotones());
	}
	
	private class listenerBotones implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			switch (e.getActionCommand()) {
				case "primero":
					cambiarDpto(0);
					break;
				case "anterior":
					anteriorDpto();
					break;
				case "siguiente":
					siguienteDpto();
					break;
				case "ultimo":
					cambiarDpto(modelo.dptos.size() - 1);
					break;
			}
			
		}
		
	}
	
	private void anteriorDpto() {
		cambiarDpto(this.indexDpto - 1);
	}
	
	private void siguienteDpto() {
		cambiarDpto(this.indexDpto + 1);
	}
	
	public void cambiarDpto(int index) {
		if (index < 0)
			index = 0;
		if (index == modelo.dptos.size())
			index = modelo.dptos.size() - 1;
		
		vista.pCentral.pVerDepart.txtCodigo.setText(Integer.toString(modelo.dptos.get(index).getCodigo()));
		vista.pCentral.pVerDepart.txtNombre.setText(modelo.dptos.get(index).getNombre());
		vista.pCentral.pVerDepart.txtLocalizacion.setText(modelo.dptos.get(index).getLocalizacion().getNombre());
		
		this.indexDpto = index;
	}

}
