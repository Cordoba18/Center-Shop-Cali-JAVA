package vista;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.DropMode;
import javax.swing.JScrollPane;

public class CrearProducto extends JPanel {

	public JTextField textNombreProducto;
	public JTextField textPrecio;
	public JButton btnCrear;
	public JLabel lblErrorNombre;
	public JTextField textDescuento;
	public JButton btnSeleccionarImagen;
	public JLabel lblErrorPrecio;
	public JComboBox categorias;
	public JLabel lblErrorDescuento;
	public JLabel lblImagen;
	private JLabel lblDescripcin;
	public JTextArea textDescripcion;
	public JLabel lblContador;
	public JLabel lblErrorDescripcion;
	public CrearProducto() {

		setBounds(174, 105, 1188, 595);
		setLayout(null);
		JLabel lblNewLabel = new JLabel("NOMBRE PRODUCTO:");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 10));
		lblNewLabel.setBounds(240, 155, 207, 29);
		add(lblNewLabel);
		
		JLabel lblCorreo = new JLabel("PRECIO:");
		lblCorreo.setFont(new Font("Arial Black", Font.BOLD, 10));
		lblCorreo.setBounds(240, 195, 229, 29);
		add(lblCorreo);
		
		JLabel lblNewLabel_1_1 = new JLabel("CREAR PRODUCTO:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_1.setFont(new Font("Arial Black", Font.BOLD, 45));
		lblNewLabel_1_1.setBounds(181, 40, 885, 76);
		add(lblNewLabel_1_1);
		
		textNombreProducto = new JTextField();
		textNombreProducto.setHorizontalAlignment(SwingConstants.RIGHT);
		textNombreProducto.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		textNombreProducto.setBounds(479, 154, 502, 29);
		add(textNombreProducto);
		textNombreProducto.setColumns(10);
		
		textPrecio = new JTextField();
		textPrecio.setHorizontalAlignment(SwingConstants.RIGHT);
		textPrecio.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		textPrecio.setColumns(10);
		textPrecio.setBounds(676, 194, 305, 29);
		add(textPrecio);
		
		btnCrear = new JButton("CREAR");
		btnCrear.setBackground(new Color(0, 0, 255));
		btnCrear.setForeground(new Color(255, 255, 255));
		btnCrear.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		btnCrear.setBounds(836, 506, 145, 40);
		add(btnCrear);
		
		lblErrorNombre = new JLabel("ERROR");
		lblErrorNombre.setForeground(new Color(255, 0, 0));
		lblErrorNombre.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 10));
		lblErrorNombre.setBounds(991, 155, 187, 25);
		add(lblErrorNombre);
		
		JLabel lblCedula = new JLabel("DESCUENTO:");
		lblCedula.setFont(new Font("Arial Black", Font.BOLD, 10));
		lblCedula.setBounds(240, 235, 229, 29);
		add(lblCedula);
		
		textDescuento = new JTextField();
		textDescuento.setText("0");
		textDescuento.setHorizontalAlignment(SwingConstants.CENTER);
		textDescuento.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		textDescuento.setColumns(10);
		textDescuento.setBounds(836, 234, 93, 29);
		add(textDescuento);
		
		JLabel lblCorreo_1_1_1_1_1 = new JLabel("IMAGEN:");
		lblCorreo_1_1_1_1_1.setFont(new Font("Arial Black", Font.BOLD, 10));
		lblCorreo_1_1_1_1_1.setBounds(240, 466, 229, 29);
		add(lblCorreo_1_1_1_1_1);
		
		btnSeleccionarImagen = new JButton("SELECCIONAR IMAGEN");
		btnSeleccionarImagen.setForeground(new Color(0, 0, 0));
		btnSeleccionarImagen.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 12));
		btnSeleccionarImagen.setBackground(Color.BLUE);
		btnSeleccionarImagen.setBounds(693, 466, 288, 29);
		add(btnSeleccionarImagen);
		
		lblErrorPrecio = new JLabel("ERROR");
		lblErrorPrecio.setForeground(new Color(255, 0, 0));
		lblErrorPrecio.setFont(new Font("Arial Black", Font.ITALIC, 10));
		lblErrorPrecio.setBounds(991, 195, 187, 25);
		add(lblErrorPrecio);
		
		lblErrorDescuento = new JLabel("ERROR");
		lblErrorDescuento.setForeground(Color.RED);
		lblErrorDescuento.setFont(new Font("Arial Black", Font.ITALIC, 10));
		lblErrorDescuento.setBounds(991, 235, 187, 25);
		add(lblErrorDescuento);
		
		lblImagen = new JLabel("Imagen");
		lblImagen.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 15));
		lblImagen.setHorizontalAlignment(SwingConstants.RIGHT);
		lblImagen.setBounds(693, 470, 288, 25);
		add(lblImagen);
		
		JLabel lblNewLabel_1 = new JLabel("%");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 21));
		lblNewLabel_1.setBounds(935, 234, 46, 30);
		add(lblNewLabel_1);
		
		JLabel lblCategoria = new JLabel("CATEGORIA:");
		lblCategoria.setFont(new Font("Arial Black", Font.BOLD, 10));
		lblCategoria.setBounds(240, 283, 229, 29);
		add(lblCategoria);
		
		categorias = new JComboBox();
		categorias.setModel(new DefaultComboBoxModel(new String[] {"CATEGORIAS"}));
		categorias.setBackground(new Color(0, 0, 255));
		categorias.setForeground(new Color(0, 0, 0));
		categorias.setFont(new Font("Arial Black", Font.PLAIN, 18));
		categorias.setBounds(801, 283, 180, 29);
		add(categorias);
		
		lblDescripcin = new JLabel("DESCRIPCIÓN:");
		lblDescripcin.setFont(new Font("Arial Black", Font.BOLD, 10));
		lblDescripcin.setBounds(240, 341, 229, 29);
		add(lblDescripcin);
		
		lblErrorDescripcion = new JLabel("ERROR");
		lblErrorDescripcion.setForeground(new Color(255, 0, 0));
		lblErrorDescripcion.setFont(new Font("Arial Black", Font.ITALIC, 10));
		lblErrorDescripcion.setBounds(991, 348, 155, 22);
		add(lblErrorDescripcion);
		lblErrorDescripcion.setVisible(false);
		
		JLabel lblNewLabel_2 = new JLabel("/300");
		lblNewLabel_2.setFont(new Font("Arial Black", Font.PLAIN, 11));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(935, 441, 46, 14);
		add(lblNewLabel_2);
		
		lblContador = new JLabel("0");
		lblContador.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblContador.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContador.setBounds(894, 441, 46, 14);
		add(lblContador);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(420, 348, 553, 82);
		add(scrollPane);
		
		textDescripcion = new JTextArea();
		scrollPane.setViewportView(textDescripcion);
		textDescripcion.setTabSize(3);
		textDescripcion.setLineWrap(true);
		textDescripcion.setColumns(3);
		textDescripcion.setFont(new Font("Arial Black", Font.PLAIN, 15));
		textDescripcion.setWrapStyleWord(true);
		
		lblErrorNombre.setVisible(false);
		lblErrorDescuento.setVisible(false);
		lblErrorPrecio.setVisible(false);
		lblImagen.setVisible(false);
	}
}
