package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;

public class Empresa extends JPanel {

	public JLabel lblImagen;
	public JLabel lblNombre;
	public JLabel id_empresa;
	public Empresa() {
		setBackground(new Color(0, 128, 0));
		
		setBounds(98, 330, 172, 155);
		setLayout(null);
		
		lblImagen = new JLabel("");
		lblImagen.setBounds(21, 22, 130, 85);
		add(lblImagen);
		
		lblNombre = new JLabel("NOMBRE");
		lblNombre.setForeground(new Color(255, 255, 255));
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNombre.setBounds(10, 118, 152, 26);
		add(lblNombre);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 152, 107);
		add(panel);
		panel.setLayout(null);
		
		id_empresa = new JLabel("");
		id_empresa.setHorizontalAlignment(SwingConstants.CENTER);
		id_empresa.setBounds(54, 0, 46, 14);
		panel.add(id_empresa);
		id_empresa.setVisible(false);
	}
}
