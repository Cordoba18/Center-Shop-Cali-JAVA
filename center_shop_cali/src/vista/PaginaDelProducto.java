package vista;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.TextArea;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;

public class PaginaDelProducto extends JPanel {

	public JButton btnAgregarAlCarrito;
	public JButton btnIzquierda;
	
	public JButton btnDerecha;
	
	public JLabel Imagen;
	public JTextArea textDescripcion;
	
	
	public JButton btnComprar;
	
	public JLabel lblTitulo;
	
	public JLabel lblDescripcion ;
	
	public JLabel lblPrecio ;
	
	public JComboBox BoxColores;
	
	public JComboBox BoxTallas;
	
	public JLabel lblColores;
	
	public JLabel lblTallas ;
	
	public JLabel ImagenColor;
	public JLabel lblEmpresa;
	public JLabel ImagenEmpresa;
	public JLabel lblAñadirLD;
	public JLabel lblCantidadTallas;
	
	public PaginaDelProducto() {

		setBounds(0, 0, 1367, 515);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 0));
		panel.setBounds(95, 28, 560, 301);
		add(panel);
		panel.setLayout(null);
		
		lblAñadirLD = new JLabel("");
		lblAñadirLD.setHorizontalAlignment(SwingConstants.CENTER);
		lblAñadirLD.setIcon(new ImageIcon("icons\\ListaDeDeseos.png"));
		lblAñadirLD.setBounds(461, 11, 89, 68);
		panel.add(lblAñadirLD);
		
		btnIzquierda = new JButton("<");
		btnIzquierda.setForeground(Color.WHITE);
		btnIzquierda.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 22));
		btnIzquierda.setBackground(Color.BLUE);
		btnIzquierda.setBounds(10, 120, 56, 61);
		panel.add(btnIzquierda);
		
		btnDerecha = new JButton(">");
		btnDerecha.setForeground(Color.WHITE);
		btnDerecha.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 22));
		btnDerecha.setBackground(Color.BLUE);
		btnDerecha.setBounds(494, 120, 56, 61);
		panel.add(btnDerecha);
		
		Imagen = new JLabel("");
		Imagen.setHorizontalAlignment(SwingConstants.CENTER);
		Imagen.setBounds(10, 11, 540, 279);
		panel.add(Imagen);
		
		btnAgregarAlCarrito = new JButton("AGREGAR AL CARRITO");
		btnAgregarAlCarrito.setBackground(new Color(0, 0, 255));
		btnAgregarAlCarrito.setForeground(new Color(255, 255, 255));
		btnAgregarAlCarrito.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 22));
		btnAgregarAlCarrito.setBounds(91, 340, 244, 58);
		add(btnAgregarAlCarrito);
		
		btnComprar = new JButton("COMPRAR");
		btnComprar.setForeground(Color.WHITE);
		btnComprar.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 30));
		btnComprar.setBackground(Color.BLUE);
		btnComprar.setBounds(345, 340, 310, 58);
		add(btnComprar);
		
		lblTitulo = new JLabel("Titulo");
		lblTitulo.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 40));
		lblTitulo.setBounds(665, 28, 430, 94);
		add(lblTitulo);
		
		lblDescripcion = new JLabel("DESCRIPCION:");
		lblDescripcion.setFont(new Font("Arial Black", Font.BOLD, 30));
		lblDescripcion.setBounds(665, 111, 264, 67);
		add(lblDescripcion);
		
		lblPrecio = new JLabel("PRECIO");
		lblPrecio.setForeground(new Color(255, 0, 0));
		lblPrecio.setFont(new Font("Arial Black", Font.BOLD, 30));
		lblPrecio.setBounds(1141, 28, 216, 94);
		add(lblPrecio);
		
		JLabel lblPrecio_1 = new JLabel("$");
		lblPrecio_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecio_1.setFont(new Font("Arial Black", Font.BOLD, 30));
		lblPrecio_1.setBounds(1079, 28, 52, 94);
		add(lblPrecio_1);
		
		BoxColores = new JComboBox();
		BoxColores.setModel(new DefaultComboBoxModel(new String[] {"COLOR"}));
		BoxColores.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 21));
		BoxColores.setBounds(843, 349, 178, 34);
		add(BoxColores);
		
		BoxTallas = new JComboBox();
		BoxTallas.setMaximumRowCount(3);
		BoxTallas.setModel(new DefaultComboBoxModel(new String[] {"TALLA"}));
		BoxTallas.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 25));
		BoxTallas.setBounds(1183, 348, 178, 34);
		add(BoxTallas);
		
		lblColores = new JLabel("COLORES:");
		lblColores.setFont(new Font("Arial Black", Font.BOLD, 25));
		lblColores.setBounds(665, 349, 171, 31);
		add(lblColores);
		
		lblTallas = new JLabel("TALLAS:");
		lblTallas.setFont(new Font("Arial Black", Font.BOLD, 25));
		lblTallas.setBounds(1029, 350, 147, 31);
		add(lblTallas);
		
		ImagenColor = new JLabel("");
		ImagenColor.setBounds(843, 407, 178, 97);
		add(ImagenColor);
		
		lblEmpresa = new JLabel("Empresa");
		lblEmpresa.setFont(new Font("Arial Black", Font.BOLD, 35));
		lblEmpresa.setBounds(203, 416, 452, 67);
		add(lblEmpresa);
		
		ImagenEmpresa = new JLabel("");
		ImagenEmpresa.setFont(new Font("Arial Black", Font.BOLD, 25));
		ImagenEmpresa.setBounds(90, 416, 90, 67);
		add(ImagenEmpresa);
		
		textDescripcion = new JTextArea();
		textDescripcion.setEditable(false);
		textDescripcion.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.ITALIC, 25));
		textDescripcion.setWrapStyleWord(true);
		textDescripcion.setLineWrap(true);
		textDescripcion.setBounds(665, 171, 692, 158);
		add(textDescripcion);
		
		lblCantidadTallas = new JLabel("Cantidad");
		lblCantidadTallas.setForeground(new Color(255, 0, 0));
		lblCantidadTallas.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantidadTallas.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblCantidadTallas.setBounds(1038, 416, 319, 31);
		add(lblCantidadTallas);
	}
}
