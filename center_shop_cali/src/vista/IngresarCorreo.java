package vista;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IngresarCorreo extends JPanel {
	public JTextField textCorreo;
	public JLabel lblErrorCorreo;
	public JButton btnVolver;
	public JButton btnSiguiente;
	public IngresarCorreo() {
		setBackground(new Color(255, 255, 255));

		setBounds(0, 0, 454, 520);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("RECUPERAR CONTRASEÑA:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 22));
		lblNewLabel.setBounds(46, 86, 365, 58);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CORREO:");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblNewLabel_1.setBounds(46, 240, 98, 40);
		add(lblNewLabel_1);
		
		textCorreo = new JTextField();
		textCorreo.setHorizontalAlignment(SwingConstants.RIGHT);
		textCorreo.setFont(new Font("Arial Black", Font.ITALIC, 20));
		textCorreo.setBounds(159, 248, 252, 28);
		add(textCorreo);
		textCorreo.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("INGRESESE SU CORREO A RECUPERAR");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(76, 165, 307, 28);
		add(lblNewLabel_2);
		
		lblErrorCorreo = new JLabel("ERROR");
		lblErrorCorreo.setForeground(new Color(255, 0, 0));
		lblErrorCorreo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblErrorCorreo.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 13));
		lblErrorCorreo.setBounds(159, 289, 252, 28);
		add(lblErrorCorreo);
		
		btnVolver = new JButton("VOLVER");
		btnVolver.setForeground(new Color(255, 255, 255));
		btnVolver.setBackground(new Color(0, 0, 255));
		btnVolver.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnVolver.setBounds(46, 345, 123, 40);
		add(btnVolver);
		
		btnSiguiente = new JButton("SIGUIENTE");
		btnSiguiente.setForeground(Color.WHITE);
		btnSiguiente.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnSiguiente.setBackground(Color.BLUE);
		btnSiguiente.setBounds(265, 345, 146, 40);
		add(btnSiguiente);
		lblErrorCorreo.setVisible(false);
	}
}
