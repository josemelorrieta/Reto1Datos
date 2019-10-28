package vista;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class PanelMenu extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5L;
	
	public JButton btnGestionDepart;
	public JButton btnGestionEmple;
	public JButton btnGestionInfor;
	public JLabel lblTituloMenu;

	public PanelMenu() {
		setPreferredSize(new Dimension(800, 440));
		setLayout(null);
		
		lblTituloMenu = new JLabel("MENÚ PRINCIPAL");
		lblTituloMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloMenu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTituloMenu.setBounds(275, 40, 250,40);
		add(lblTituloMenu);
		
		btnGestionDepart = new JButton("Gestión de departamentos");
		btnGestionDepart.setBounds(275, 120, 250, 25);
		btnGestionDepart.setActionCommand("gestDepart");
		add(btnGestionDepart);
		
		btnGestionEmple = new JButton("Gestión de empleados");
		btnGestionEmple.setBounds(275, 180, 250, 25);
		btnGestionEmple.setActionCommand("gestEmple");
		add(btnGestionEmple);
		
		btnGestionInfor = new JButton("Gestión de informes");
		btnGestionInfor.setBounds(275, 240, 250, 25);
		btnGestionInfor.setActionCommand("informes");
		add(btnGestionInfor);

	}
}
