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
	private ControladorGestionDepartamentos cGestDptos;
	private ControladorGenerarInforme cGenerarInforme;
	public ControladorVerDepartamento cVerDpto;
	public ControladorAltaDepartamento cAltaDpto;
	
	public Controlador (VentanaPpal vista, Modelo modelo) {
		this.vista = vista;
		this.modelo = modelo;
		
		initControladores();
		initListeners();
		
		initAplicacion();
		
	}
	
	private void initControladores() {
		cMenu = new ControladorMenu(vista);
		cGestDptos = new ControladorGestionDepartamentos(vista, this);
		cVerDpto = new ControladorVerDepartamento(modelo, vista);
		cAltaDpto = new ControladorAltaDepartamento(modelo, vista);
		cGenerarInforme = new ControladorGenerarInforme(vista, modelo);

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
					if (vista.pCentral.currentIndex == 2)
						vista.pCentral.changePanel("1");
					if (vista.pCentral.currentIndex == 3)
						vista.pCentral.changePanel("2");
					if (vista.pCentral.currentIndex == 4)
						vista.pCentral.changePanel("2");
					if (vista.pCentral.currentIndex == 5)
						vista.pCentral.changePanel("1");
					if (vista.pCentral.currentIndex == 6)
						vista.pCentral.changePanel("5");
					if (vista.pCentral.currentIndex == 7)
						vista.pCentral.changePanel("5");
					if (vista.pCentral.currentIndex == 8)
						vista.pCentral.changePanel("1");
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
		switch (modelo.conBD.inicializarTablas(modelo)) {
			case 0:
				System.out.println("Error al cargar tablas");
				break;
			case 1:
				System.out.println("Tablas cargadas");
				break;
			case 2:
				System.out.println("Entradas duplicadas en tablas no se cargaron");
		}
	}
	
}
