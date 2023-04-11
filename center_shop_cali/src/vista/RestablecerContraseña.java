package vista;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

public class RestablecerContraseña extends JPanel {
	public JButton btnVolver;
	public JButton btnRestablecer;
	public JPasswordField textContrasenaN;
	public JPasswordField textCContrasena;
	public JLabel lblErrorContrasenaN;
	public JLabel lblErrorCContrasena;
	
	public RestablecerContraseña() {
		setBackground(new Color(255, 255, 255));

		setBounds(0, 0, 454, 520);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("RECUPERAR CONTRASEÑA:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 22));
		lblNewLabel.setBounds(46, 86, 365, 58);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("NUEVA CONTRASEÑA:");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNewLabel_1.setBounds(46, 179, 183, 40);
		add(lblNewLabel_1);
		
		btnVolver = new JButton("VOLVER");
		btnVolver.setForeground(new Color(255, 255, 255));
		btnVolver.setBackground(new Color(0, 0, 255));
		btnVolver.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnVolver.setBounds(46, 345, 123, 40);
		add(btnVolver);
		
		btnRestablecer = new JButton("RESTABLECER");
		btnRestablecer.setForeground(Color.WHITE);
		btnRestablecer.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnRestablecer.setBackground(Color.BLUE);
		btnRestablecer.setBounds(234, 345, 177, 40);
		add(btnRestablecer);
		
		textContrasenaN = new JPasswordField();
		textContrasenaN.setToolTipText("");
		textContrasenaN.setHorizontalAlignment(SwingConstants.RIGHT);
		textContrasenaN.setFont(new Font("Arial Black", Font.BOLD, 14));
		textContrasenaN.setBounds(234, 187, 177, 28);
		add(textContrasenaN);
		
		JLabel lblNewLabel_1_1 = new JLabel("CONFIRMAR CONTRASEÑA:");
		lblNewLabel_1_1.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(46, 249, 189, 40);
		add(lblNewLabel_1_1);
		
		textCContrasena = new JPasswordField();
		textCContrasena.setToolTipText("");
		textCContrasena.setHorizontalAlignment(SwingConstants.RIGHT);
		textCContrasena.setFont(new Font("Arial Black", Font.BOLD, 14));
		textCContrasena.setBounds(234, 255, 177, 28);
		add(textCContrasena);
		
		lblErrorContrasenaN = new JLabel("ERROR");
		lblErrorContrasenaN.setHorizontalAlignment(SwingConstants.RIGHT);
		lblErrorContrasenaN.setForeground(Color.RED);
		lblErrorContrasenaN.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 10));
		lblErrorContrasenaN.setBounds(159, 216, 252, 28);
		add(lblErrorContrasenaN);
		
		lblErrorCContrasena = new JLabel("ERROR");
		lblErrorCContrasena.setHorizontalAlignment(SwingConstants.RIGHT);
		lblErrorCContrasena.setForeground(Color.RED);
		lblErrorCContrasena.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 10));
		lblErrorCContrasena.setBounds(159, 283, 252, 28);
		add(lblErrorCContrasena);
		lblErrorContrasenaN.setVisible(false);
		lblErrorCContrasena.setVisible(false);
	}
}
