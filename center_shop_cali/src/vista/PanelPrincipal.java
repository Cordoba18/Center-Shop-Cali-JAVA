package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

public class PanelPrincipal extends JPanel {

	public JPanel PanelPrincipal;
	
	public JLabel lblNombre ;
	
	public JLabel lblInfo; 
	
	public JLabel lblImagen;
	public JPanel panel; 
	public PanelPrincipal() {
		setBackground(new Color(0, 0, 255));

		setBounds(0, 0, 1367, 515);
		setLayout(null);
		
		PanelPrincipal = new JPanel();
		PanelPrincipal.setLayout(null);
		PanelPrincipal.setBounds(0, 0, 1367, 515);
		add(PanelPrincipal);
		
		lblNombre = new JLabel("");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setForeground(new Color(255, 255, 255));
		lblNombre.setFont(new Font("Arial Black", Font.BOLD, 30));
		lblNombre.setBounds(235, 56, 931, 84);
		PanelPrincipal.add(lblNombre);
		
		lblInfo = new JLabel("");
		lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfo.setForeground(Color.BLACK);
		lblInfo.setFont(new Font("Arial Black", Font.ITALIC, 35));
		lblInfo.setBackground(Color.GREEN);
		lblInfo.setBounds(214, 111, 952, 102);
		PanelPrincipal.add(lblInfo);
		
		lblImagen = new JLabel("");
		lblImagen.setBounds(214, 24, 965, 232);
		PanelPrincipal.add(lblImagen);
		
		panel = new JPanel();
		panel.setBackground(new Color(0, 128, 0));
		panel.setBounds(187, 11, 1005, 259);
		PanelPrincipal.add(panel);
		
		JLabel lblNewLabel = new JLabel("ALGUNAS EMPRESAS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 40));
		lblNewLabel.setBounds(224, 278, 1005, 44);
		PanelPrincipal.add(lblNewLabel);
	}
}
