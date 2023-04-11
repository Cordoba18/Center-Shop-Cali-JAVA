package vista;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class IngresarCodigo extends JPanel {
	public JButton btnVolver;
	public JButton btnSiguiente;
	public JTextField textCodigo;
	public IngresarCodigo() {

		setBounds(0, 0, 454, 520);
		setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("RECUPERAR CONTRASEÑA:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 22));
		lblNewLabel.setBounds(46, 86, 365, 58);
		add(lblNewLabel);
		
		
		JLabel lblNewLabel_2 = new JLabel("Hemos enviado un codigo a ");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(41, 161, 190, 28);
		add(lblNewLabel_2);
		
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
		
		JLabel lblCorreo = new JLabel("");
		lblCorreo.setHorizontalAlignment(SwingConstants.LEFT);
		lblCorreo.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 15));
		lblCorreo.setBounds(229, 161, 182, 28);
		add(lblCorreo);
		
		JLabel lblNewLabel_2_1 = new JLabel("ingrese el codigo enviado al correo");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(10, 200, 434, 28);
		add(lblNewLabel_2_1);
		
		textCodigo = new JTextField();
		textCodigo.setText("INGRESE EL CODIGO AQUÍ");
		textCodigo.setFont(new Font("Arial Black", Font.BOLD, 17));
		textCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		textCodigo.setBounds(83, 246, 289, 51);
		add(textCodigo);
		textCodigo.setColumns(10);
	}

}
