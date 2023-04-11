package vista;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CrearLocal extends JPanel {

	public JTextField textNombreEmpresa;
	public JTextField textNombrePropietario;
	public JPasswordField textContrasena;
	public JPasswordField textCContrasena;
	public JButton btnCrear;
	public JLabel lblErrorNombre;
	public JTextField textCedulaPropietario;
	public JTextField textD1;
	public JTextField textD2;
	public JTextField textD3;
	public JTextField textCorreo;
	public JButton btnSeleccionarLogo;
	public JLabel lblErrorNP;
	
	public JLabel lblErrorCP;
	
	public JLabel lblErrorDirrecion;
	
	public JLabel lblErrorCorreo;
	
	public JLabel lblErrorContrasena;
	
	public JLabel lblErrorCContrasena ;
	public JLabel lblImagen;
	private JLabel lblTelefono;
	public JTextField textTelefono;
	public JLabel lblErrorTelefono;
	public CrearLocal() {

		setBounds(174, 105, 1188, 595);
		setLayout(null);
		JLabel lblNewLabel = new JLabel("NOMBRE EMPRESA:");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 10));
		lblNewLabel.setBounds(240, 155, 207, 29);
		add(lblNewLabel);
		
		JLabel lblCorreo = new JLabel("NOMBRE DEL PROPIETARIO:");
		lblCorreo.setFont(new Font("Arial Black", Font.BOLD, 10));
		lblCorreo.setBounds(240, 195, 229, 29);
		add(lblCorreo);
		
		JLabel lblNewLabel_1_1 = new JLabel("CREAR EMPRESA:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_1.setFont(new Font("Arial Black", Font.BOLD, 45));
		lblNewLabel_1_1.setBounds(181, 40, 885, 76);
		add(lblNewLabel_1_1);
		
		textNombreEmpresa = new JTextField();
		textNombreEmpresa.setHorizontalAlignment(SwingConstants.RIGHT);
		textNombreEmpresa.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		textNombreEmpresa.setBounds(479, 154, 502, 29);
		add(textNombreEmpresa);
		textNombreEmpresa.setColumns(10);
		
		textNombrePropietario = new JTextField();
		textNombrePropietario.setHorizontalAlignment(SwingConstants.RIGHT);
		textNombrePropietario.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		textNombrePropietario.setColumns(10);
		textNombrePropietario.setBounds(479, 194, 502, 29);
		add(textNombrePropietario);
		
		textContrasena = new JPasswordField();
		textContrasena.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		textContrasena.setHorizontalAlignment(SwingConstants.RIGHT);
		textContrasena.setBounds(548, 349, 433, 29);
		add(textContrasena);
		
		textCContrasena = new JPasswordField();
		textCContrasena.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		textCContrasena.setHorizontalAlignment(SwingConstants.RIGHT);
		textCContrasena.setBounds(548, 389, 433, 29);
		add(textCContrasena);
		
		btnCrear = new JButton("CREAR");
		btnCrear.setBackground(new Color(0, 0, 255));
		btnCrear.setForeground(new Color(255, 255, 255));
		btnCrear.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		btnCrear.setBounds(836, 527, 145, 40);
		add(btnCrear);
		
		lblErrorNombre = new JLabel("ERROR");
		lblErrorNombre.setForeground(new Color(255, 0, 0));
		lblErrorNombre.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 10));
		lblErrorNombre.setBounds(991, 155, 187, 25);
		add(lblErrorNombre);
		
		JLabel lblCedula = new JLabel("CEDULA DEL PROPIETARIO:");
		lblCedula.setFont(new Font("Arial Black", Font.BOLD, 10));
		lblCedula.setBounds(240, 235, 229, 29);
		add(lblCedula);
		
		textCedulaPropietario = new JTextField();
		textCedulaPropietario.setHorizontalAlignment(SwingConstants.RIGHT);
		textCedulaPropietario.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		textCedulaPropietario.setColumns(10);
		textCedulaPropietario.setBounds(479, 234, 502, 29);
		add(textCedulaPropietario);
		
		JLabel lblDireccin = new JLabel("DIRECCIÓN:");
		lblDireccin.setFont(new Font("Arial Black", Font.BOLD, 10));
		lblDireccin.setBounds(240, 275, 229, 29);
		add(lblDireccin);
		
		textD1 = new JTextField();
		textD1.setHorizontalAlignment(SwingConstants.RIGHT);
		textD1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		textD1.setColumns(10);
		textD1.setBounds(645, 274, 82, 30);
		add(textD1);
		
		textD2 = new JTextField();
		textD2.setHorizontalAlignment(SwingConstants.RIGHT);
		textD2.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		textD2.setColumns(10);
		textD2.setBounds(775, 274, 82, 30);
		add(textD2);
		
		textD3 = new JTextField();
		textD3.setHorizontalAlignment(SwingConstants.RIGHT);
		textD3.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		textD3.setColumns(10);
		textD3.setBounds(899, 274, 82, 30);
		add(textD3);
		
		JLabel lblNewLabel_2 = new JLabel("#");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNewLabel_2.setBounds(726, 273, 52, 29);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("/");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNewLabel_2_1.setBounds(857, 274, 41, 29);
		add(lblNewLabel_2_1);
		
		JLabel lblCorreo_1 = new JLabel("Correo:");
		lblCorreo_1.setFont(new Font("Arial Black", Font.BOLD, 10));
		lblCorreo_1.setBounds(240, 310, 229, 29);
		add(lblCorreo_1);
		
		textCorreo = new JTextField();
		textCorreo.setHorizontalAlignment(SwingConstants.RIGHT);
		textCorreo.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		textCorreo.setColumns(10);
		textCorreo.setBounds(479, 315, 502, 29);
		add(textCorreo);
		
		JLabel lblCorreo_1_1_1 = new JLabel("CONTRASEÑA:");
		lblCorreo_1_1_1.setFont(new Font("Arial Black", Font.BOLD, 10));
		lblCorreo_1_1_1.setBounds(240, 350, 229, 29);
		add(lblCorreo_1_1_1);
		
		JLabel lblCorreo_1_1_1_1 = new JLabel("CONFIRMAR CONTRASEÑA:");
		lblCorreo_1_1_1_1.setFont(new Font("Arial Black", Font.BOLD, 10));
		lblCorreo_1_1_1_1.setBounds(240, 390, 229, 29);
		add(lblCorreo_1_1_1_1);
		
		JLabel lblCorreo_1_1_1_1_1 = new JLabel("LOGO:");
		lblCorreo_1_1_1_1_1.setFont(new Font("Arial Black", Font.BOLD, 10));
		lblCorreo_1_1_1_1_1.setBounds(240, 487, 229, 29);
		add(lblCorreo_1_1_1_1_1);
		
		btnSeleccionarLogo = new JButton("SELECCIONAR LOGO");
		btnSeleccionarLogo.setForeground(new Color(0, 0, 0));
		btnSeleccionarLogo.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 12));
		btnSeleccionarLogo.setBackground(Color.BLUE);
		btnSeleccionarLogo.setBounds(693, 487, 288, 29);
		add(btnSeleccionarLogo);
		
		lblErrorNP = new JLabel("ERROR");
		lblErrorNP.setForeground(new Color(255, 0, 0));
		lblErrorNP.setFont(new Font("Arial Black", Font.ITALIC, 10));
		lblErrorNP.setBounds(991, 195, 187, 25);
		add(lblErrorNP);
		
		lblErrorCP = new JLabel("ERROR");
		lblErrorCP.setForeground(Color.RED);
		lblErrorCP.setFont(new Font("Arial Black", Font.ITALIC, 10));
		lblErrorCP.setBounds(991, 235, 187, 25);
		add(lblErrorCP);
		
		lblErrorDirrecion = new JLabel("ERROR");
		lblErrorDirrecion.setForeground(Color.RED);
		lblErrorDirrecion.setFont(new Font("Arial Black", Font.ITALIC, 10));
		lblErrorDirrecion.setBounds(991, 275, 187, 25);
		add(lblErrorDirrecion);
		
		lblErrorCorreo = new JLabel("ERROR");
		lblErrorCorreo.setForeground(Color.RED);
		lblErrorCorreo.setFont(new Font("Arial Black", Font.ITALIC, 10));
		lblErrorCorreo.setBounds(991, 317, 187, 25);
		add(lblErrorCorreo);
		
		lblErrorContrasena = new JLabel("ERROR");
		lblErrorContrasena.setForeground(Color.RED);
		lblErrorContrasena.setFont(new Font("Arial Black", Font.ITALIC, 10));
		lblErrorContrasena.setBounds(991, 352, 187, 25);
		add(lblErrorContrasena);
		
		lblErrorCContrasena = new JLabel("ERROR");
		lblErrorCContrasena.setForeground(Color.RED);
		lblErrorCContrasena.setFont(new Font("Arial Black", Font.ITALIC, 10));
		lblErrorCContrasena.setBounds(991, 392, 187, 25);
		add(lblErrorCContrasena);
		
		lblImagen = new JLabel("Imagen");
		lblImagen.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 15));
		lblImagen.setHorizontalAlignment(SwingConstants.RIGHT);
		lblImagen.setBounds(693, 489, 288, 25);
		add(lblImagen);
		
		lblTelefono = new JLabel("TELEFONO DE CONTACTO:");
		lblTelefono.setFont(new Font("Arial Black", Font.BOLD, 10));
		lblTelefono.setBounds(240, 431, 229, 29);
		add(lblTelefono);
		
		textTelefono = new JTextField();
		textTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		textTelefono.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		textTelefono.setColumns(10);
		textTelefono.setBounds(479, 429, 502, 29);
		add(textTelefono);
		
		lblErrorTelefono = new JLabel("ERROR");
		lblErrorTelefono.setForeground(new Color(255, 0, 0));
		lblErrorTelefono.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 11));
		lblErrorTelefono.setBounds(991, 431, 187, 29);
		add(lblErrorTelefono);
		lblErrorNombre.setVisible(false);
		lblErrorCorreo.setVisible(false);
		lblErrorCContrasena.setVisible(false);
		lblErrorContrasena.setVisible(false);
		lblErrorCP.setVisible(false);
		lblErrorDirrecion.setVisible(false);
		lblErrorNP.setVisible(false);
		lblImagen.setVisible(false);
		lblErrorTelefono.setVisible(false);
	}
}
