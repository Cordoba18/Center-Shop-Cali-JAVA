package vista;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class PerfilUsuario extends JPanel {

	public JButton btnCarritoCompras;
	public JButton btnListaDeDeseos;
	
	public JButton btnMetodosDePago;
	
	public JButton btnCerrarSesion;
	
	public JLabel lblUser;
	public JButton btnGuardarCambios;
	public JButton btnCambiarContrasena;
	public JTextField textNombre;
	public JTextField textCorreo;
	public JTextField textF_Nacimiento;
	public JTextField textCedula;
	public JTextField textDirrecion;
	public JTextField textTelefono;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	public JLabel lblErrorNombre;
	public JLabel lblErrorCedula;
	public JLabel lblErrorDireccion;
	public JLabel lblErrorTelefono;
	public PerfilUsuario() {

		setBounds(0, 0, 1367, 515);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 0));
		panel.setBounds(0, 0, 208, 515);
		add(panel);
		panel.setLayout(null);
		
		btnCarritoCompras = new JButton("CARRITO DE COMPRAS");
		btnCarritoCompras.setForeground(new Color(255, 255, 255));
		btnCarritoCompras.setBackground(new Color(0, 0, 255));
		btnCarritoCompras.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		btnCarritoCompras.setBounds(10, 184, 188, 47);
		panel.add(btnCarritoCompras);
		
		btnListaDeDeseos = new JButton("LISTA DE DESEOS");
		btnListaDeDeseos.setForeground(Color.WHITE);
		btnListaDeDeseos.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		btnListaDeDeseos.setBackground(Color.BLUE);
		btnListaDeDeseos.setBounds(10, 243, 188, 47);
		panel.add(btnListaDeDeseos);
		
		btnMetodosDePago = new JButton("METODOS DE PAGO");
		btnMetodosDePago.setForeground(Color.WHITE);
		btnMetodosDePago.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		btnMetodosDePago.setBackground(Color.BLUE);
		btnMetodosDePago.setBounds(10, 301, 188, 47);
		panel.add(btnMetodosDePago);
		
		btnCerrarSesion = new JButton("CERRAR SESIÒN");
		btnCerrarSesion.setForeground(new Color(0, 0, 0));
		btnCerrarSesion.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		btnCerrarSesion.setBackground(new Color(255, 255, 255));
		btnCerrarSesion.setBounds(10, 419, 188, 47);
		panel.add(btnCerrarSesion);
		
		JLabel lblBienvenido = new JLabel("BIENVENIDO");
		lblBienvenido.setForeground(new Color(0, 0, 0));
		lblBienvenido.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblBienvenido.setBounds(10, 28, 188, 57);
		panel.add(lblBienvenido);
		
		lblUser = new JLabel("USER");
		lblUser.setForeground(new Color(255, 255, 255));
		lblUser.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblUser.setBounds(10, 79, 188, 57);
		panel.add(lblUser);
		
		btnCambiarContrasena = new JButton("CAMBIAR CONTRASEÑA");
		btnCambiarContrasena.setForeground(Color.WHITE);
		btnCambiarContrasena.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		btnCambiarContrasena.setBackground(Color.BLUE);
		btnCambiarContrasena.setBounds(10, 359, 188, 47);
		panel.add(btnCambiarContrasena);
		
		JLabel lblNombre = new JLabel("NOMBRE:");
		lblNombre.setForeground(Color.BLACK);
		lblNombre.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblNombre.setBounds(446, 11, 188, 57);
		add(lblNombre);
		
		JLabel lblCorreo = new JLabel("CORREO:");
		lblCorreo.setForeground(Color.BLACK);
		lblCorreo.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblCorreo.setBounds(446, 82, 188, 57);
		add(lblCorreo);
		
		JLabel lblFechaNacimiento = new JLabel("FECHA NACIMIENTO:");
		lblFechaNacimiento.setForeground(Color.BLACK);
		lblFechaNacimiento.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblFechaNacimiento.setBounds(446, 150, 261, 57);
		add(lblFechaNacimiento);
		
		JLabel lblCedula = new JLabel("CEDULA:");
		lblCedula.setForeground(Color.BLACK);
		lblCedula.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblCedula.setBounds(446, 229, 261, 57);
		add(lblCedula);
		
		JLabel lblDireccin = new JLabel("DIRECCIÓN:");
		lblDireccin.setForeground(Color.BLACK);
		lblDireccin.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblDireccin.setBounds(446, 302, 261, 57);
		add(lblDireccin);
		
		textNombre = new JTextField();
		textNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		textNombre.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD | Font.ITALIC, 25));
		textNombre.setBounds(757, 25, 350, 32);
		add(textNombre);
		textNombre.setColumns(10);
		
		textCorreo = new JTextField();
		textCorreo.setEditable(false);
		textCorreo.setHorizontalAlignment(SwingConstants.RIGHT);
		textCorreo.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD | Font.ITALIC, 25));
		textCorreo.setColumns(10);
		textCorreo.setBounds(757, 94, 350, 32);
		add(textCorreo);
		
		textF_Nacimiento = new JTextField();
		textF_Nacimiento.setHorizontalAlignment(SwingConstants.RIGHT);
		textF_Nacimiento.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD | Font.ITALIC, 25));
		textF_Nacimiento.setEditable(false);
		textF_Nacimiento.setColumns(10);
		textF_Nacimiento.setBounds(757, 161, 350, 32);
		add(textF_Nacimiento);
		
		textCedula = new JTextField();
		textCedula.setHorizontalAlignment(SwingConstants.RIGHT);
		textCedula.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD | Font.ITALIC, 25));
		textCedula.setColumns(10);
		textCedula.setBounds(757, 241, 350, 32);
		add(textCedula);
		
		textDirrecion = new JTextField();
		textDirrecion.setHorizontalAlignment(SwingConstants.RIGHT);
		textDirrecion.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD | Font.ITALIC, 25));
		textDirrecion.setColumns(10);
		textDirrecion.setBounds(757, 312, 350, 32);
		add(textDirrecion);
		
		JLabel lblTelefono = new JLabel("TELEFONO:");
		lblTelefono.setForeground(Color.BLACK);
		lblTelefono.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblTelefono.setBounds(446, 370, 261, 57);
		add(lblTelefono);
		
		textTelefono = new JTextField();
		textTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		textTelefono.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD | Font.ITALIC, 25));
		textTelefono.setColumns(10);
		textTelefono.setBounds(757, 382, 350, 32);
		add(textTelefono);
		
		btnGuardarCambios = new JButton("GUARDAR CAMBIOS");
		btnGuardarCambios.setForeground(Color.WHITE);
		btnGuardarCambios.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		btnGuardarCambios.setBackground(Color.BLUE);
		btnGuardarCambios.setBounds(800, 453, 307, 51);
		add(btnGuardarCambios);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("icons\\editar.png"));
		lblNewLabel.setBounds(1118, 11, 75, 57);
		add(lblNewLabel);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("icons\\editar.png"));
		lblNewLabel_3.setBounds(1117, 229, 75, 57);
		add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("icons\\editar.png"));
		lblNewLabel_4.setBounds(1117, 299, 75, 60);
		add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("icons\\editar.png"));
		lblNewLabel_5.setBounds(1118, 370, 75, 57);
		add(lblNewLabel_5);
		
		lblErrorNombre = new JLabel("ERROR");
		lblErrorNombre.setForeground(new Color(255, 0, 0));
		lblErrorNombre.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD | Font.ITALIC, 20));
		lblErrorNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblErrorNombre.setBounds(757, 57, 350, 32);
		add(lblErrorNombre);
		
		lblErrorCedula = new JLabel("ERROR");
		lblErrorCedula.setHorizontalAlignment(SwingConstants.RIGHT);
		lblErrorCedula.setForeground(Color.RED);
		lblErrorCedula.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD | Font.ITALIC, 20));
		lblErrorCedula.setBounds(757, 273, 350, 32);
		add(lblErrorCedula);
		
		lblErrorDireccion = new JLabel("ERROR");
		lblErrorDireccion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblErrorDireccion.setForeground(Color.RED);
		lblErrorDireccion.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD | Font.ITALIC, 20));
		lblErrorDireccion.setBounds(757, 344, 350, 32);
		add(lblErrorDireccion);
		
		lblErrorTelefono = new JLabel("ERROR");
		lblErrorTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		lblErrorTelefono.setForeground(Color.RED);
		lblErrorTelefono.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD | Font.ITALIC, 20));
		lblErrorTelefono.setBounds(757, 413, 350, 32);
		add(lblErrorTelefono);
		
		lblErrorNombre.setVisible(false);
		lblErrorCedula.setVisible(false);
		lblErrorDireccion.setVisible(false);
		lblErrorTelefono.setVisible(false);
	}
}
