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
	public JButton btnLog;
	public JLabel lblTituloMenu;

	public PanelMenu() {
		setPreferredSize(new Dimension(800, 440));
		setLayout(null);
		
		lblTituloMenu = new JLabel("MENÚ PRINCIPAL");
		lblTituloMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloMenu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTituloMenu.setBounds(10, 40, 780,40);
		add(lblTituloMenu);
		
		btnGestionDepart = new JButton("Gestión de departamentos");
		btnGestionDepart.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGestionDepart.setBounds(275, 120, 250, 30);
		btnGestionDepart.setActionCommand("gestDepart");
		add(btnGestionDepart);
		
		btnGestionEmple = new JButton("Gestión de empleados");
		btnGestionEmple.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGestionEmple.setBounds(275, 180, 250, 30);
		btnGestionEmple.setActionCommand("gestEmple");
		add(btnGestionEmple);
		
		btnGestionInfor = new JButton("Generar informes");
		btnGestionInfor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGestionInfor.setBounds(275, 240, 250, 30);
		btnGestionInfor.setActionCommand("informes");
		add(btnGestionInfor);
		
		btnLog = new JButton("Gestión Fichero Log");
		btnLog.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLog.setBounds(275, 300, 250, 30);
		btnLog.setActionCommand("log");
		add(btnLog);

	}
}
