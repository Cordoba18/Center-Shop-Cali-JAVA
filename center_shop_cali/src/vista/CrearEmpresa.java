package vista;

import javax.swing.JPanel;
import java.awt.Rectangle;
import java.awt.Component;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CrearEmpresa extends JPanel {
	public JTextField textNombre;
	public JTextField textCorreo;
	public JPasswordField textContrasenaA;
	public JPasswordField textContrasenaN;
	public JButton btnGuardarCambios;
	public JLabel lblErrorNombre;
	public JLabel lblErrorCorreo;
	public 	JLabel lblErrorContrasenaA;
	public JLabel lblErrorContrasenaN;
	public CrearEmpresa() {
		setBounds(174, 105, 1188, 595);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NOMBRE:");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNewLabel.setBounds(240, 155, 158, 47);
		add(lblNewLabel);
		
		JLabel lblCorreo = new JLabel("CORREO:");
		lblCorreo.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblCorreo.setBounds(240, 225, 158, 47);
		add(lblCorreo);
		
		JLabel lblContraseaActual = new JLabel("INGRESE CONTRASEÑA ACTUAL:");
		lblContraseaActual.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblContraseaActual.setBounds(202, 360, 336, 47);
		add(lblContraseaActual);
		
		JLabel lblNewLabel_1_1 = new JLabel("PERFIL ADMINISTRADOR");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_1.setFont(new Font("Arial Black", Font.BOLD, 45));
		lblNewLabel_1_1.setBounds(181, 40, 885, 76);
		add(lblNewLabel_1_1);
		
		JLabel lbldeseasCambiarLa = new JLabel("¿DESEAS CAMBIAR LA CONTRASEÑA?");
		lbldeseasCambiarLa.setHorizontalAlignment(SwingConstants.CENTER);
		lbldeseasCambiarLa.setFont(new Font("Arial Black", Font.BOLD, 15));
		lbldeseasCambiarLa.setBounds(548, 302, 433, 47);
		add(lbldeseasCambiarLa);
		
		JLabel lblIngreseSuNueva = new JLabel("INGRESE SU NUEVA CONTRASEÑA:");
		lblIngreseSuNueva.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblIngreseSuNueva.setBounds(202, 434, 317, 47);
		add(lblIngreseSuNueva);
		
		textNombre = new JTextField();
		textNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		textNombre.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		textNombre.setBounds(479, 154, 502, 47);
		add(textNombre);
		textNombre.setColumns(10);
		
		textCorreo = new JTextField();
		textCorreo.setHorizontalAlignment(SwingConstants.RIGHT);
		textCorreo.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		textCorreo.setColumns(10);
		textCorreo.setBounds(479, 224, 502, 47);
		add(textCorreo);
		
		textContrasenaA = new JPasswordField();
		textContrasenaA.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		textContrasenaA.setHorizontalAlignment(SwingConstants.RIGHT);
		textContrasenaA.setBounds(548, 360, 433, 46);
		add(textContrasenaA);
		
		textContrasenaN = new JPasswordField();
		textContrasenaN.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		textContrasenaN.setHorizontalAlignment(SwingConstants.RIGHT);
		textContrasenaN.setBounds(548, 436, 433, 46);
		add(textContrasenaN);
		
		btnGuardarCambios = new JButton("GUARDAR CAMBIOS");
		btnGuardarCambios.setBackground(new Color(0, 0, 255));
		btnGuardarCambios.setForeground(new Color(255, 255, 255));
		btnGuardarCambios.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 12));
		btnGuardarCambios.setBounds(836, 527, 145, 40);
		add(btnGuardarCambios);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("icons\\editar.png"));
		lblNewLabel_1.setBounds(991, 155, 52, 47);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("");
		lblNewLabel_1_2.setIcon(new ImageIcon("icons\\editar.png"));
		lblNewLabel_1_2.setBounds(991, 225, 52, 47);
		add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("");
		lblNewLabel_1_2_1_1.setIcon(new ImageIcon("icons\\editar.png"));
		lblNewLabel_1_2_1_1.setBounds(991, 415, 52, 47);
		add(lblNewLabel_1_2_1_1);
		
		lblErrorNombre = new JLabel("ERROR");
		lblErrorNombre.setForeground(new Color(255, 0, 0));
		lblErrorNombre.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 15));
		lblErrorNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblErrorNombre.setBounds(489, 199, 492, 25);
		add(lblErrorNombre);
		
		lblErrorCorreo = new JLabel("ERROR");
		lblErrorCorreo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblErrorCorreo.setForeground(Color.RED);
		lblErrorCorreo.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 15));
		lblErrorCorreo.setBounds(479, 276, 502, 25);
		add(lblErrorCorreo);
		
		lblErrorContrasenaA = new JLabel("ERROR");
		lblErrorContrasenaA.setHorizontalAlignment(SwingConstants.RIGHT);
		lblErrorContrasenaA.setForeground(Color.RED);
		lblErrorContrasenaA.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 15));
		lblErrorContrasenaA.setBounds(548, 411, 433, 25);
		add(lblErrorContrasenaA);
		
		lblErrorContrasenaN = new JLabel("ERROR");
		lblErrorContrasenaN.setHorizontalAlignment(SwingConstants.RIGHT);
		lblErrorContrasenaN.setForeground(Color.RED);
		lblErrorContrasenaN.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 15));
		lblErrorContrasenaN.setBounds(548, 491, 433, 25);
		add(lblErrorContrasenaN);
		
		lblErrorCorreo.setVisible(false);
		lblErrorNombre.setVisible(false);
		lblErrorContrasenaA.setVisible(false);
		lblErrorContrasenaN.setVisible(false);
		
	}
}
