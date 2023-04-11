package vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class CrearCuenta extends JFrame {

	private JPanel contentPane;
	public JTextField textCorreo;
	public JButton btnCrear;
	public JButton btnTengoCuenta;
	public JLabel lblErrorContrasena;
	public JLabel lblErrorCorreo;
	public JPasswordField textContrasena;
	private JLabel lblNewLabel;
	private JLabel lblConfirmar;
	public JPasswordField textCContrasena;
	public JTextField textNombre;
	public JTextField textDia;
	public JTextField textNumeroTelefono;
	public JLabel lblErrorCContrasena;
	public JLabel lblErrorTelefono;
	public JLabel lblErrorFNacimiento;
	public JLabel lblErrorNombre;
	public JTextField textMes;
	public JTextField textAño;
	public CrearCuenta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 923, 559);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(453, 0, 454, 520);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel titulo = new JLabel("CREAR CUENTA");
		titulo.setForeground(new Color(0, 0, 0));
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setFont(new Font("Arial Black", Font.BOLD, 34));
		titulo.setBounds(25, 22, 406, 131);
		panel.add(titulo);
		
		JLabel lblcorreo = new JLabel("CORREO:");
		lblcorreo.setBackground(new Color(0, 0, 0));
		lblcorreo.setForeground(new Color(0, 0, 0));
		lblcorreo.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblcorreo.setBounds(25, 301, 128, 32);
		panel.add(lblcorreo);
		
		JLabel lblContrasena = new JLabel("CONTRASEÑA:");
		lblContrasena.setForeground(new Color(0, 0, 0));
		lblContrasena.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblContrasena.setBounds(25, 344, 175, 32);
		panel.add(lblContrasena);
		
		textCorreo = new JTextField();
		textCorreo.setHorizontalAlignment(SwingConstants.RIGHT);
		textCorreo.setBackground(new Color(255, 255, 255));
		textCorreo.setBounds(248, 309, 168, 20);
		panel.add(textCorreo);
		textCorreo.setColumns(10);
		
		btnCrear = new JButton("CREAR");
		btnCrear.setForeground(new Color(255, 255, 255));
		btnCrear.setBackground(new Color(0, 0, 255));
		btnCrear.setFont(new Font("Arial Black", Font.PLAIN, 15));
		btnCrear.setBounds(296, 461, 120, 37);
		panel.add(btnCrear);
		
		btnTengoCuenta = new JButton("YA TENGO CUENTA");
		btnTengoCuenta.setForeground(Color.WHITE);
		btnTengoCuenta.setFont(new Font("Arial Black", Font.PLAIN, 15));
		btnTengoCuenta.setBackground(Color.BLUE);
		btnTengoCuenta.setBounds(25, 461, 239, 37);
		panel.add(btnTengoCuenta);
		
		lblErrorContrasena = new JLabel("ERROR");
		lblErrorContrasena.setHorizontalAlignment(SwingConstants.RIGHT);
		lblErrorContrasena.setForeground(Color.RED);
		lblErrorContrasena.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 8));
		lblErrorContrasena.setBounds(217, 370, 199, 14);
		panel.add(lblErrorContrasena);
		
		lblErrorCorreo = new JLabel("ERROR");
		lblErrorCorreo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblErrorCorreo.setForeground(new Color(255, 0, 0));
		lblErrorCorreo.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 8));
		lblErrorCorreo.setBounds(217, 327, 199, 14);
		panel.add(lblErrorCorreo);
		
		textContrasena = new JPasswordField();
		textContrasena.setHorizontalAlignment(SwingConstants.RIGHT);
		textContrasena.setBounds(274, 352, 142, 20);
		panel.add(textContrasena);
		
		lblConfirmar = new JLabel("CONFIRMAR CONTRASEÑA:");
		lblConfirmar.setForeground(Color.BLACK);
		lblConfirmar.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblConfirmar.setBounds(25, 387, 239, 32);
		panel.add(lblConfirmar);
		
		textCContrasena = new JPasswordField();
		textCContrasena.setHorizontalAlignment(SwingConstants.RIGHT);
		textCContrasena.setBounds(274, 395, 142, 20);
		panel.add(textCContrasena);
		
		JLabel lblNombreCompleto = new JLabel("NOMBRE COMPLETO:");
		lblNombreCompleto.setForeground(Color.BLACK);
		lblNombreCompleto.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNombreCompleto.setBackground(Color.BLACK);
		lblNombreCompleto.setBounds(25, 156, 199, 32);
		panel.add(lblNombreCompleto);
		
		JLabel lblFechaDeNacimiento = new JLabel("FECHA DE NACIMIENTO:");
		lblFechaDeNacimiento.setForeground(Color.BLACK);
		lblFechaDeNacimiento.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblFechaDeNacimiento.setBackground(Color.BLACK);
		lblFechaDeNacimiento.setBounds(25, 204, 222, 32);
		panel.add(lblFechaDeNacimiento);
		
		JLabel lblNumeroDeTelefono = new JLabel("NUMERO DE TELEFONO:");
		lblNumeroDeTelefono.setForeground(Color.BLACK);
		lblNumeroDeTelefono.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNumeroDeTelefono.setBackground(Color.BLACK);
		lblNumeroDeTelefono.setBounds(25, 247, 222, 37);
		panel.add(lblNumeroDeTelefono);
		
		textNombre = new JTextField();
		textNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		textNombre.setColumns(10);
		textNombre.setBackground(Color.WHITE);
		textNombre.setBounds(248, 164, 168, 20);
		panel.add(textNombre);
		
		textDia = new JTextField();
		textDia.setText("DIA");
		textDia.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		textDia.setHorizontalAlignment(SwingConstants.CENTER);
		textDia.setColumns(10);
		textDia.setBackground(Color.WHITE);
		textDia.setBounds(248, 212, 48, 20);
		panel.add(textDia);
		
		textNumeroTelefono = new JTextField();
		textNumeroTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		textNumeroTelefono.setColumns(10);
		textNumeroTelefono.setBackground(Color.WHITE);
		textNumeroTelefono.setBounds(248, 257, 168, 20);
		panel.add(textNumeroTelefono);
		
		lblErrorCContrasena = new JLabel("ERROR");
		lblErrorCContrasena.setForeground(new Color(255, 0, 0));
		lblErrorCContrasena.setHorizontalAlignment(SwingConstants.RIGHT);
		lblErrorCContrasena.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 8));
		lblErrorCContrasena.setBounds(217, 417, 199, 20);
		panel.add(lblErrorCContrasena);
		
		lblErrorTelefono = new JLabel("ERROR");
		lblErrorTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		lblErrorTelefono.setForeground(Color.RED);
		lblErrorTelefono.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 8));
		lblErrorTelefono.setBounds(217, 278, 199, 20);
		panel.add(lblErrorTelefono);
		
		lblErrorFNacimiento = new JLabel("ERROR");
		lblErrorFNacimiento.setHorizontalAlignment(SwingConstants.RIGHT);
		lblErrorFNacimiento.setForeground(Color.RED);
		lblErrorFNacimiento.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 8));
		lblErrorFNacimiento.setBounds(217, 235, 199, 20);
		panel.add(lblErrorFNacimiento);
		
		lblErrorNombre = new JLabel("ERROR");
		lblErrorNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblErrorNombre.setForeground(Color.RED);
		lblErrorNombre.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 8));
		lblErrorNombre.setBounds(217, 184, 199, 20);
		panel.add(lblErrorNombre);
		
		textMes = new JTextField();
		textMes.setText("MES");
		textMes.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		textMes.setHorizontalAlignment(SwingConstants.CENTER);
		textMes.setColumns(10);
		textMes.setBackground(Color.WHITE);
		textMes.setBounds(310, 212, 48, 20);
		panel.add(textMes);
		
		textAño = new JTextField();
		textAño.setText("AÑO");
		textAño.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		textAño.setHorizontalAlignment(SwingConstants.CENTER);
		textAño.setColumns(10);
		textAño.setBackground(Color.WHITE);
		textAño.setBounds(368, 212, 48, 20);
		panel.add(textAño);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("images\\LOGO.png"));
		lblNewLabel.setBounds(10, 11, 422, 487);
		contentPane.add(lblNewLabel);
		lblErrorContrasena.setVisible(false);
		lblErrorCorreo.setVisible(false);
	
		lblErrorCContrasena.setVisible(false);
		lblErrorTelefono.setVisible(false);
		lblErrorFNacimiento.setVisible(false);
		lblErrorNombre.setVisible(false);
	}
}
