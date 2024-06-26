package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

public class IniciarSesion extends JFrame {

	private JPanel contentPane;
	public JTextField textCorreo;
	public JButton btnIniciar;
	public JLabel lblRestablecer;
	public JButton btnVolver;
	public JLabel lblErrorContrasena;
	public JLabel lblErrorCorreo;
	public JPasswordField textContrasena;
	private JLabel lblNewLabel;
	public JLabel lblCrearCuenta;

	public IniciarSesion() {
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
		
		JLabel titulo = new JLabel("INICIAR \r\nSESIÓN");
		titulo.setForeground(new Color(0, 0, 0));
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setFont(new Font("Arial Black", Font.BOLD, 34));
		titulo.setBounds(23, 93, 406, 131);
		panel.add(titulo);
		
		JLabel lblcorreo = new JLabel("CORREO:");
		lblcorreo.setBackground(new Color(0, 0, 0));
		lblcorreo.setForeground(new Color(0, 0, 0));
		lblcorreo.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblcorreo.setBounds(49, 235, 128, 32);
		panel.add(lblcorreo);
		
		JLabel lblContrasena = new JLabel("CONTRASEÑA:");
		lblContrasena.setForeground(new Color(0, 0, 0));
		lblContrasena.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblContrasena.setBounds(49, 290, 175, 32);
		panel.add(lblContrasena);
		
		textCorreo = new JTextField();
		textCorreo.setHorizontalAlignment(SwingConstants.RIGHT);
		textCorreo.setBackground(new Color(255, 255, 255));
		textCorreo.setBounds(248, 245, 168, 20);
		panel.add(textCorreo);
		textCorreo.setColumns(10);
		
		btnIniciar = new JButton("INICIAR");
		btnIniciar.setForeground(new Color(255, 255, 255));
		btnIniciar.setBackground(new Color(0, 0, 255));
		btnIniciar.setFont(new Font("Arial Black", Font.PLAIN, 15));
		btnIniciar.setBounds(296, 384, 120, 37);
		panel.add(btnIniciar);
		
		 lblRestablecer = new JLabel("¿OLVIDO SU CONTRASEÑA?");
		lblRestablecer.setForeground(new Color(255, 0, 0));
		lblRestablecer.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblRestablecer.setBounds(227, 344, 189, 14);
		panel.add(lblRestablecer);
		
		btnVolver = new JButton("VOLVER");
		btnVolver.setForeground(Color.WHITE);
		btnVolver.setFont(new Font("Arial Black", Font.PLAIN, 15));
		btnVolver.setBackground(Color.BLUE);
		btnVolver.setBounds(49, 384, 128, 37);
		panel.add(btnVolver);
		
		lblErrorContrasena = new JLabel("ERROR");
		lblErrorContrasena.setHorizontalAlignment(SwingConstants.RIGHT);
		lblErrorContrasena.setForeground(Color.RED);
		lblErrorContrasena.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 8));
		lblErrorContrasena.setBounds(217, 319, 199, 14);
		panel.add(lblErrorContrasena);
		
		lblErrorCorreo = new JLabel("ERROR");
		lblErrorCorreo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblErrorCorreo.setForeground(new Color(255, 0, 0));
		lblErrorCorreo.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 8));
		lblErrorCorreo.setBounds(219, 265, 199, 14);
		panel.add(lblErrorCorreo);
		
		textContrasena = new JPasswordField();
		textContrasena.setHorizontalAlignment(SwingConstants.RIGHT);
		textContrasena.setBounds(248, 300, 168, 20);
		panel.add(textContrasena);
		
		lblCrearCuenta = new JLabel("CREAR CUENTA");
		lblCrearCuenta.setForeground(Color.RED);
		lblCrearCuenta.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblCrearCuenta.setBounds(49, 344, 128, 14);
		panel.add(lblCrearCuenta);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("images\\LOGO.png"));
		lblNewLabel.setBounds(10, 11, 422, 487);
		contentPane.add(lblNewLabel);
		lblErrorContrasena.setVisible(false);
		lblErrorCorreo.setVisible(false);
	}
}
