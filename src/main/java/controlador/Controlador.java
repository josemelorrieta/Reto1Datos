package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Modelo;
import vista.VentanaPpal;

public class Controlador {
	private Modelo modelo;
	private VentanaPpal vista;	
	
	private String origen;
	
	private ControladorMenu cMenu;
	
	public Controlador (VentanaPpal vista, Modelo modelo) {
		this.vista = vista;
		this.modelo = modelo;
		
		initControladores();
		initListeners();
		
		initAplicacion();
		
	}
	
	private void initControladores() {
		cMenu = new ControladorMenu(vista);
	}

	private void initListeners() {
		vista.pBotones.btnAtras.addActionListener(new ListenerBotonesMenu());
		vista.pBotones.btnSiguiente.addActionListener(new ListenerBotonesMenu());
	}

	private class ListenerBotonesMenu implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			origen = e.getActionCommand();
			
			switch (origen) {
				case "ATRAS":
					vista.pCentral.card.first(vista.pCentral);
					break;
				case "SIGUIENTE":
					break;
			}
		}
	}
	
	public void initAplicacion() {
		modelo.centros = modelo.conBD.cargarCentros(Modelo.bd);
		modelo.cargos = modelo.conBD.cargarCargos(Modelo.bd);
		modelo.dptos = modelo.conBD.cargarDptosDeFichero(modelo.centros);
		modelo.empleados = modelo.conBD.cargarEmpleadosDeFichero(modelo.dptos, modelo.cargos);
		if (modelo.conBD.inicializarTablas(modelo)) {
			System.out.println("Tablas cargadas");
		} else {
			System.out.println("Error al cargar tablas");
		}
	}
	
}
