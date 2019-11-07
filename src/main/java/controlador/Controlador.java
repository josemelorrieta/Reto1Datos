package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import log.Logger;
import modelo.Modelo;
import vista.VentanaCargando;
import vista.VentanaPpal;

public class Controlador {
	private Modelo modelo;
	private VentanaPpal vista;
	private VentanaCargando vCargando;
	private Logger logger;
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY - hh:mm:ss");
	private String origen;
	
	public ControladorVerDepartamento cVerDpto;
	public ControladorAltaDepartamento cAltaDpto;
	public ControladorVerEmpleados cVerEmple;
	public ControladorAltaEmpleado cAltaEmple;
	public ControladorGestionLog cGestionLog;
	
	public Controlador (VentanaPpal vista, Modelo modelo) {
		this.vista = vista;
		this.modelo = modelo;
		this.logger = Logger.getSingletonInstance();
		
		initControladores();
		initListeners();
		
		initAplicacion();
		
	}
	
	private void initControladores() {
		new ControladorMenu(vista);
		new ControladorGestionDepartamentos(vista, this);
		new ControladorGestionEmpleados(vista, this);
		cVerDpto = new ControladorVerDepartamento(modelo, vista);
		cAltaDpto = new ControladorAltaDepartamento(modelo, vista);
		cAltaEmple = new ControladorAltaEmpleado(modelo, vista);
		cVerEmple = new ControladorVerEmpleados(modelo, vista);
		new ControladorGenerarInforme(vista, modelo);
		cGestionLog = new ControladorGestionLog(vista, this, modelo);
	}

	private void initListeners() {
		vista.pBotones.btnAtras.addActionListener(new ListenerBotonesMenu());
		vista.pBotones.btnSalir.addActionListener(new ListenerBotonesMenu());
	}

	private class ListenerBotonesMenu implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			origen = e.getActionCommand();
			
			switch (origen) {
				case "ATRAS":
					if (vista.pCentral.currentIndex == 2) {
						vista.pCentral.changePanel("1");
						botonesMenuPpal();
					}
					
					if (vista.pCentral.currentIndex == 3) {
						vista.pCentral.changePanel("2");
					}
					
					if (vista.pCentral.currentIndex == 4) {
						vista.pCentral.changePanel("2");
					}
					
					if (vista.pCentral.currentIndex == 5) {
						vista.pCentral.changePanel("1");
						botonesMenuPpal();
					}
					
					if (vista.pCentral.currentIndex == 6) {
						vista.pCentral.changePanel("5");
					}
					
					if (vista.pCentral.currentIndex == 7) {
						vista.pCentral.changePanel("5");
					}
					
					if (vista.pCentral.currentIndex == 8) {
						vista.pCentral.changePanel("1");
						botonesMenuPpal();
					}
					
					if (vista.pCentral.currentIndex == 9) {
						vista.pCentral.changePanel("1");
						botonesMenuPpal();
					}
					break;
				case "SALIR":
					System.exit(0);
					break;
			}
		}
	}
	
	public void initAplicacion() {
		// Mostrar ventana cargando...
		vCargando = new VentanaCargando();
		vCargando.setVisible(true);
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			
		}
		
		if (Modelo.bd.getCon() == null) {
			JOptionPane.showMessageDialog(vista, "No se pudo establecer conexión con la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		
		// Cargar datos iniciales de fichero
		modelo.centros = modelo.conBD.cargarCentros(Modelo.bd);
		modelo.cargos = modelo.conBD.cargarCargos(Modelo.bd);
		modelo.dptos = modelo.conBD.cargarDptosDeFichero(modelo.centros);
		modelo.empleados = modelo.conBD.cargarEmpleadosDeFichero(modelo.dptos, modelo.cargos);
		switch (modelo.conBD.inicializarTablas(modelo)) {
			case 0:
				logger.escribirLog(dateFormat.format(new Date()) + " - " + getClass().getName() + " - Error al cargar tablas");
				break;
			case 1:
				logger.escribirLog(dateFormat.format(new Date()) + " - " + getClass().getName() + " - Tablas cargadas correctamente");
				break;
			case 2:
				logger.escribirLog(dateFormat.format(new Date()) + " - " + getClass().getName() + " - Tablas cargadas. Entradas duplicadas en tablas no se añadieron");
				break;
		}
		
		// Cargar datos de BD en modelo
		modelo.dptos.clear();
		modelo.empleados.clear();
		
		modelo.dptos = modelo.conBD.cargarDptos(Modelo.bd, modelo.centros);
		modelo.empleados = modelo.conBD.cargarEmpleados(Modelo.bd, modelo.cargos, modelo.dptos);
		
		vCargando.setVisible(false);
	}
	
	private void botonesMenuPpal() {
		vista.pBotones.btnAtras.setVisible(false);
		vista.pBotones.btnSalir.setVisible(true);
	}
	
}
