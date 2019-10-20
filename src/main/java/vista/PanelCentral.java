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
	public PanelAltaDepartamento pAltaDepart;
	public PanelAltaEmpleado pAltaEmpleado;
	public PanelVerDepartamento pVerDepart;
	public PanelVerEmpleados pVerEmple;
	public PanelGenerarInforme pInformes;

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
		
		pAltaDepart = new PanelAltaDepartamento();
		add(pAltaDepart, "2");
		
		pAltaEmpleado = new PanelAltaEmpleado();
		add(pAltaEmpleado, "3");
		
		pVerDepart = new PanelVerDepartamento();
		add(pVerDepart, "4");
		
		pVerEmple = new PanelVerEmpleados();
		add(pVerEmple, "5");
		
		pInformes = new PanelGenerarInforme();
		add(pInformes, "6");
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
		card.show(this, index);
		currentIndex = Integer.parseInt(index);
	}

}
