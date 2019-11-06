package vista;

import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

public class PanelCentral extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3L;
	
	public CardLayout card;
	public int currentIndex;
	
	public PanelMenu pMenu;
	public PanelGestionDepartamentos pGestionDptos;
	public PanelGestionEmpleados pGestionEmple;
	public PanelAltaDepartamento pAltaDepart;
	public PanelAltaEmpleado pAltaEmpleado;
	public PanelVerDepartamento pVerDepart;
	public PanelVerEmpleados pVerEmple;
	public PanelGenerarInforme pInformes;
	public PanelGestionLog pGestionLog;

	public PanelCentral() {
		card = new CardLayout();
		setLayout(card);
		setPreferredSize(new Dimension(800, 440));
		instanciarObjetos();
		currentIndex = 1;
		card.first(this);
	}
	
	private void instanciarObjetos() {
		pMenu = new PanelMenu();
		add(pMenu, "1");
		
		pGestionDptos = new PanelGestionDepartamentos();
		add(pGestionDptos, "2");
		
		pAltaDepart = new PanelAltaDepartamento();
		add(pAltaDepart, "3");
		
		pVerDepart = new PanelVerDepartamento();
		add(pVerDepart, "4");
		
		pGestionEmple = new PanelGestionEmpleados();
		add(pGestionEmple, "5");
		
		pAltaEmpleado = new PanelAltaEmpleado();
		add(pAltaEmpleado, "6");
		
		pVerEmple = new PanelVerEmpleados();
		add(pVerEmple, "7");
		
		pInformes = new PanelGenerarInforme();
		add(pInformes, "8");
		
		pGestionLog = new PanelGestionLog();
		add(pGestionLog, "9");
	}
	
	public void prevPanel() {
		card.previous(this);
		currentIndex--;
	}
	
	public void nextPanel() {
		card.next(this);
		currentIndex++;
	}
	
	public void firstPanel() {
		card.first(this);
		currentIndex = 1;
	}
	
	public void changePanel(String index) {
		this.card.show(this, index);
		this.currentIndex = Integer.parseInt(index);
	}

	public int getCurrentIndex() {
		return currentIndex;
	}

	public void setCurrentIndex(int currentIndex) {
		this.currentIndex = currentIndex;
	}


}
