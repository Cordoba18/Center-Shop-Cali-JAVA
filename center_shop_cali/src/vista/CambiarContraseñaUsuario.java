package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class CambiarContraseñaUsuario extends JFrame {

	private JPanel contentPane;
	public JPasswordField textContrasenaA;
	public JPasswordField textContrasenaN;
	public JPasswordField textCContrasena;
	public JButton btnCerrar;
	
	public JButton btnConfirmar;
	
	public JLabel lblErrorContrasenaA ;
	
	public JLabel lblErrorContrasenaN ;
	
	public JLabel lblErrorCContrasena;
	public JLabel id_user;
	
	public CambiarContraseñaUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 562, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CAMBIAR CONTRASEÑA");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 24));
		lblNewLabel.setBounds(70, 11, 429, 88);
		contentPane.add(lblNewLabel);
		
		JLabel lblContraseaActual = new JLabel("CONTRASEÑA ACTUAL:");
		lblContraseaActual.setHorizontalAlignment(SwingConstants.CENTER);
		lblContraseaActual.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblContraseaActual.setBounds(70, 96, 201, 66);
		contentPane.add(lblContraseaActual);
		
		JLabel lblNuevaContrasea = new JLabel("NUEVA CONTRASEÑA:");
		lblNuevaContrasea.setHorizontalAlignment(SwingConstants.LEFT);
		lblNuevaContrasea.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNuevaContrasea.setBounds(70, 173, 201, 66);
		contentPane.add(lblNuevaContrasea);
		
		JLabel lblConfirmarContrasea = new JLabel("CONFIRMAR CONTRASEÑA:");
		lblConfirmarContrasea.setHorizontalAlignment(SwingConstants.LEFT);
		lblConfirmarContrasea.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblConfirmarContrasea.setBounds(70, 236, 240, 66);
		contentPane.add(lblConfirmarContrasea);
		
		btnCerrar = new JButton("CERRAR");
		btnCerrar.setBackground(new Color(0, 0, 255));
		btnCerrar.setForeground(new Color(255, 255, 255));
		btnCerrar.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnCerrar.setBounds(70, 327, 125, 39);
		contentPane.add(btnCerrar);
		
		btnConfirmar = new JButton("CONFIRMAR");
		btnConfirmar.setForeground(new Color(255, 255, 255));
		btnConfirmar.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnConfirmar.setBackground(Color.BLUE);
		btnConfirmar.setBounds(352, 327, 153, 39);
		contentPane.add(btnConfirmar);
		
		lblErrorContrasenaA = new JLabel("ERROR");
		lblErrorContrasenaA.setHorizontalAlignment(SwingConstants.RIGHT);
		lblErrorContrasenaA.setForeground(new Color(255, 0, 0));
		lblErrorContrasenaA.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.ITALIC, 10));
		lblErrorContrasenaA.setBounds(281, 148, 224, 27);
		contentPane.add(lblErrorContrasenaA);
		
		lblErrorContrasenaN = new JLabel("ERROR");
		lblErrorContrasenaN.setHorizontalAlignment(SwingConstants.RIGHT);
		lblErrorContrasenaN.setForeground(Color.RED);
		lblErrorContrasenaN.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.ITALIC, 10));
		lblErrorContrasenaN.setBounds(281, 223, 224, 27);
		contentPane.add(lblErrorContrasenaN);
		
		lblErrorCContrasena = new JLabel("ERROR");
		lblErrorCContrasena.setHorizontalAlignment(SwingConstants.RIGHT);
		lblErrorCContrasena.setForeground(Color.RED);
		lblErrorCContrasena.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.ITALIC, 10));
		lblErrorCContrasena.setBounds(281, 289, 224, 27);
		contentPane.add(lblErrorCContrasena);
		
		textContrasenaA = new JPasswordField();
		textContrasenaA.setBounds(281, 110, 224, 39);
		contentPane.add(textContrasenaA);
		
		textContrasenaN = new JPasswordField();
		textContrasenaN.setBounds(281, 186, 224, 39);
		contentPane.add(textContrasenaN);
		
		textCContrasena = new JPasswordField();
		textCContrasena.setBounds(311, 252, 194, 39);
		contentPane.add(textCContrasena);
		
		id_user = new JLabel("");
		id_user.setBounds(10, 11, 63, 39);
		contentPane.add(id_user);
		lblErrorCContrasena.setVisible(false);
		lblErrorContrasenaA.setVisible(false);
		lblErrorContrasenaN.setVisible(false);
		id_user.setVisible(false);
	}
}
