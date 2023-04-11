package vista;

import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTable;

public class TallasYColores extends JPanel {
	private JLabel lblNewLabel_1_2;
	public JTable TablaTallas;
	public JTable TablaColores;
	public JTextField textTalla;
	public JTextField textCantidadTalla;
	public JTextField textColor;
	public 	JButton btnAgregarColor;
	public JButton btnAgregarImagen;
	public JButton btnAgregarTalla;
	public JButton btnCancelarTalla;
	public JButton btnEliminarTalla;
	public JButton btnEliminarColor;
	public JButton btnCancelarColor;
	public JLabel lblTituloTalla;
	public 	JLabel lblTituloColores;
	public JLabel lblImagen;
	public TallasYColores() {


		setBounds(174, 105, 1188, 595);
		setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("TALLAS");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_1.setFont(new Font("Arial Black", Font.BOLD, 45));
		lblNewLabel_1_1.setBounds(92, 41, 444, 76);
		add(lblNewLabel_1_1);
		
		JLabel lblCorreo_1_1_1_1_1 = new JLabel("TALLA:");
		lblCorreo_1_1_1_1_1.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblCorreo_1_1_1_1_1.setBounds(92, 337, 229, 29);
		add(lblCorreo_1_1_1_1_1);
		
		lblNewLabel_1_2 = new JLabel("COLORES");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_2.setFont(new Font("Arial Black", Font.BOLD, 45));
		lblNewLabel_1_2.setBounds(663, 41, 444, 76);
		add(lblNewLabel_1_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(92, 128, 444, 142);
		add(scrollPane);
		
		TablaTallas = new JTable();
		scrollPane.setViewportView(TablaTallas);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(663, 128, 444, 142);
		add(scrollPane_1);
		
		TablaColores = new JTable();
		scrollPane_1.setViewportView(TablaColores);
		
		lblTituloTalla = new JLabel("AGREGAR TALLA:");
		lblTituloTalla.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloTalla.setForeground(Color.BLACK);
		lblTituloTalla.setFont(new Font("Arial Black", Font.BOLD, 25));
		lblTituloTalla.setBounds(87, 281, 449, 29);
		add(lblTituloTalla);
		
		lblTituloColores = new JLabel("AGREGAR COLOR:");
		lblTituloColores.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloColores.setForeground(Color.BLACK);
		lblTituloColores.setFont(new Font("Arial Black", Font.BOLD, 25));
		lblTituloColores.setBounds(663, 281, 449, 29);
		add(lblTituloColores);
		
		textTalla = new JTextField();
		textTalla.setFont(new Font("Arial Black", Font.PLAIN, 11));
		textTalla.setBounds(343, 341, 193, 29);
		add(textTalla);
		textTalla.setColumns(10);
		
		textCantidadTalla = new JTextField();
		textCantidadTalla.setFont(new Font("Arial Black", Font.PLAIN, 11));
		textCantidadTalla.setColumns(10);
		textCantidadTalla.setBounds(343, 394, 193, 29);
		add(textCantidadTalla);
		
		JLabel lblCorreo_1_1_1_1_1_1 = new JLabel("CANTIDAD:");
		lblCorreo_1_1_1_1_1_1.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblCorreo_1_1_1_1_1_1.setBounds(92, 391, 229, 29);
		add(lblCorreo_1_1_1_1_1_1);
		
		btnAgregarTalla = new JButton("AGREGAR");
		btnAgregarTalla.setForeground(Color.WHITE);
		btnAgregarTalla.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		btnAgregarTalla.setBackground(Color.BLUE);
		btnAgregarTalla.setBounds(391, 438, 145, 40);
		add(btnAgregarTalla);
		
		JLabel lblCorreo_1_1_1_1_1_2 = new JLabel("COLOR:");
		lblCorreo_1_1_1_1_1_2.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblCorreo_1_1_1_1_1_2.setBounds(663, 337, 229, 29);
		add(lblCorreo_1_1_1_1_1_2);
		
		textColor = new JTextField();
		textColor.setFont(new Font("Arial Black", Font.PLAIN, 11));
		textColor.setColumns(10);
		textColor.setBounds(914, 341, 193, 29);
		add(textColor);
		
		btnAgregarColor = new JButton("AGREGAR");
		btnAgregarColor.setForeground(Color.WHITE);
		btnAgregarColor.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		btnAgregarColor.setBackground(Color.BLUE);
		btnAgregarColor.setBounds(962, 438, 145, 40);
		add(btnAgregarColor);
		
		btnAgregarImagen = new JButton("SELECCIONAR IMAGEN");
		btnAgregarImagen.setForeground(Color.WHITE);
		btnAgregarImagen.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		btnAgregarImagen.setBackground(Color.BLUE);
		btnAgregarImagen.setBounds(663, 383, 444, 40);
		add(btnAgregarImagen);
		
		btnCancelarTalla = new JButton("CANCELAR");
		btnCancelarTalla.setForeground(new Color(255, 255, 255));
		btnCancelarTalla.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		btnCancelarTalla.setBackground(new Color(255, 0, 0));
		btnCancelarTalla.setBounds(92, 438, 132, 40);
		add(btnCancelarTalla);
		
		btnEliminarTalla = new JButton("ELIMINAR");
		btnEliminarTalla.setForeground(Color.BLACK);
		btnEliminarTalla.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		btnEliminarTalla.setBackground(Color.RED);
		btnEliminarTalla.setBounds(249, 438, 132, 40);
		add(btnEliminarTalla);
		
		btnEliminarColor = new JButton("ELIMINAR");
		btnEliminarColor.setForeground(Color.BLACK);
		btnEliminarColor.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		btnEliminarColor.setBackground(Color.RED);
		btnEliminarColor.setBounds(818, 438, 132, 40);
		add(btnEliminarColor);
		
		btnCancelarColor = new JButton("CANCELAR");
		btnCancelarColor.setForeground(new Color(255, 255, 255));
		btnCancelarColor.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		btnCancelarColor.setBackground(Color.RED);
		btnCancelarColor.setBounds(663, 438, 132, 40);
		add(btnCancelarColor);
		
		lblImagen = new JLabel("Imagen");
		lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagen.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		lblImagen.setBounds(663, 383, 444, 40);
		add(lblImagen);
		
		btnCancelarTalla.setVisible(false);
		btnCancelarColor.setVisible(false);
		btnEliminarColor.setVisible(false);
		btnEliminarTalla.setVisible(false);
	}
}
