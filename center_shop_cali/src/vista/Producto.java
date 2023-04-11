package vista;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Producto extends JPanel {


	public JPanel panel; 
	
	public JLabel lblImagen;
	public  JLabel lblNombre ;
	
	public  JLabel lblLocal ;
	
	public  JLabel lblDe ;
	
	public  JLabel Precio;
	public  JLabel lblPrecioAhora ;
	
	public  JLabel lblAntes;
	
	public  JLabel lblPesoAhora; 
	
	public  JLabel lblPesoAntes ;
	
	public  JLabel lblPrecioAntes; 
	public  JLabel lblAñadirALD ;
	public JLabel Id_Producto;
	public JLabel Id_empresa;
	public JLabel Descuento;
	public JLabel lblQuitar;
	public JComboBox BoxCantidades;
	public Producto() {
		setBackground(new Color(0, 128, 0));
		setBounds(66, 72, 354, 377);
		setLayout(null);
		
		BoxCantidades = new JComboBox();
		BoxCantidades.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		BoxCantidades.setMaximumRowCount(2);
		BoxCantidades.setFont(new Font("Arial Black", Font.PLAIN, 20));
		BoxCantidades.setBounds(273, 314, 71, 52);
		add(BoxCantidades);
		BoxCantidades.setVisible(false);
		lblQuitar = new JLabel("");
		lblQuitar.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuitar.setIcon(new ImageIcon("icons\\Quitar.png"));
		lblQuitar.setBounds(296, 0, 58, 58);
		add(lblQuitar);
		lblQuitar.setVisible(false);
		panel = new JPanel();
		panel.setBounds(10, 11, 334, 178);
		add(panel);
		panel.setLayout(null);
		
		Descuento = new JLabel("");
		Descuento.setBounds(0, 0, 99, 60);
		panel.add(Descuento);
		Descuento.setForeground(new Color(255, 0, 0));
		Descuento.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD | Font.ITALIC, 30));
		Descuento.setHorizontalAlignment(SwingConstants.CENTER);
		Descuento.setVisible(false);
		
		lblImagen = new JLabel("");
		lblImagen.setBounds(0, 0, 334, 178);
		panel.add(lblImagen);
		
		Id_Producto = new JLabel("");
		Id_Producto.setBounds(288, 0, 46, 14);
		panel.add(Id_Producto);
		Id_Producto.setVisible(false);
		lblNombre = new JLabel("NOMBRE PRODUCTO");
		lblNombre.setForeground(new Color(255, 255, 255));
		lblNombre.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 22));
		lblNombre.setBounds(10, 200, 334, 43);
		add(lblNombre);
		
		lblLocal = new JLabel("NOMBRE LOCAL");
		lblLocal.setForeground(new Color(0, 0, 0));
		lblLocal.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 25));
		lblLocal.setBounds(76, 241, 268, 43);
		add(lblLocal);
		
		lblDe = new JLabel("DE:");
		lblDe.setForeground(Color.WHITE);
		lblDe.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblDe.setBounds(10, 241, 56, 43);
		add(lblDe);
		
		Precio = new JLabel("PRECIO:");
		Precio.setForeground(Color.WHITE);
		Precio.setFont(new Font("Arial Black", Font.BOLD, 15));
		Precio.setBounds(10, 281, 90, 43);
		add(Precio);
		
		lblPrecioAhora = new JLabel("PRECIO");
		lblPrecioAhora.setForeground(new Color(0, 0, 0));
		lblPrecioAhora.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		lblPrecioAhora.setBounds(126, 282, 119, 43);
		add(lblPrecioAhora);
		
		lblAntes = new JLabel("ANTES:");
		lblAntes.setForeground(Color.WHITE);
		lblAntes.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblAntes.setBounds(10, 323, 90, 43);
		add(lblAntes);
		
		lblPesoAhora = new JLabel("$");
		lblPesoAhora.setHorizontalAlignment(SwingConstants.CENTER);
		lblPesoAhora.setForeground(Color.WHITE);
		lblPesoAhora.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblPesoAhora.setBounds(86, 281, 58, 43);
		add(lblPesoAhora);
		
		lblPesoAntes = new JLabel("$");
		lblPesoAntes.setHorizontalAlignment(SwingConstants.CENTER);
		lblPesoAntes.setForeground(Color.WHITE);
		lblPesoAntes.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblPesoAntes.setBounds(87, 327, 58, 43);
		add(lblPesoAntes);
		
		lblPrecioAntes = new JLabel("PRECIO");
		lblPrecioAntes.setForeground(new Color(255, 0, 0));
		lblPrecioAntes.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 20));
		lblPrecioAntes.setBounds(126, 324, 137, 43);
		add(lblPrecioAntes);
		
		lblAñadirALD = new JLabel("");
		lblAñadirALD.setHorizontalAlignment(SwingConstants.CENTER);
		lblAñadirALD.setIcon(new ImageIcon("icons\\ListaDeDeseos.png"));
		
		lblAñadirALD.setBounds(279, 296, 69, 76);
		add(lblAñadirALD);
		
		Id_empresa = new JLabel("");
		Id_empresa.setBounds(10, 11, 46, 14);
		add(Id_empresa);
	
		Id_empresa.setVisible(false);
		lblAntes.setVisible(false);
		lblPrecioAntes.setVisible(false);
		lblPesoAntes.setVisible(false);
	}
}
