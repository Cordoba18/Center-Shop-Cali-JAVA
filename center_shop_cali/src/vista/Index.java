package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.JScrollBar;
import javax.swing.SwingConstants;

public class Index extends JFrame {
	public JLabel logo;

	public JPanel contentPane;
	public JTextField textBuscador;
	public JButton btnIniciarSesion;
	public JComboBox categorias;
	public JPanel footer;
	public JPanel header;
	public JPanel IndexPanel;
	public JLabel lblIconoPerfil;
	public JLabel id_user;
	public JLabel Quitar;
	public JLabel lblTitulo;
	public Index() {
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1378, 739);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel header = new JPanel();
		header.setBackground(new Color(0, 128, 0));
		header.setBounds(0, 0, 1367, 105);
		contentPane.add(header);
		header.setLayout(null);
		
		logo = new JLabel("");
		logo.setIcon(new ImageIcon("icons\\LOGO.png"));
		logo.setBounds(27, 11, 131, 83);
		header.add(logo);
		
		textBuscador = new JTextField();
		textBuscador.setText("BUSCAR PRODUCTOS");
		textBuscador.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		textBuscador.setBounds(772, 31, 379, 37);
		header.add(textBuscador);
		textBuscador.setColumns(10);
		
		btnIniciarSesion = new JButton("INICIAR SESION");
		btnIniciarSesion.setForeground(new Color(255, 255, 255));
		btnIniciarSesion.setFont(new Font("Arial Black", Font.BOLD, 13));
		btnIniciarSesion.setBackground(new Color(0, 0, 255));
		btnIniciarSesion.setBounds(1171, 32, 169, 37);
		header.add(btnIniciarSesion);
		
		categorias = new JComboBox();
		categorias.setMaximumRowCount(3);
		categorias.setFont(new Font("Arial Black", Font.PLAIN, 24));
		categorias.setModel(new DefaultComboBoxModel(new String[] {"CATEGORIAS"}));
		categorias.setForeground(new Color(255, 255, 255));
		categorias.setBackground(new Color(0, 0, 255));
		categorias.setBounds(496, 32, 237, 37);
		header.add(categorias);
		
		JLabel titulo = new JLabel("CENTER SHOP CALI");
		titulo.setForeground(new Color(255, 255, 255));
		titulo.setFont(new Font("Arial Black", Font.BOLD, 25));
		titulo.setBounds(168, 32, 312, 37);
		header.add(titulo);
		
		lblIconoPerfil = new JLabel("");
		lblIconoPerfil.setIcon(new ImageIcon("icons\\perfil.png"));
		lblIconoPerfil.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconoPerfil.setBounds(1218, 11, 122, 83);
		header.add(lblIconoPerfil);
		
		lblTitulo = new JLabel("");
		lblTitulo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTitulo.setFont(new Font("Arial Black", Font.BOLD, 30));
		lblTitulo.setBounds(493, 7, 663, 87);
		header.add(lblTitulo);
		lblIconoPerfil.setVisible(false);
		lblTitulo.setVisible(false);
		footer = new JPanel();
		footer.setLayout(null);
		footer.setBackground(new Color(0, 128, 0));
		footer.setBounds(0, 617, 1367, 98);
		contentPane.add(footer);
		
		id_user = new JLabel("");
		id_user.setHorizontalAlignment(SwingConstants.CENTER);
		id_user.setBounds(711, 42, 46, 14);
		footer.add(id_user);
		
		Quitar = new JLabel("");
		Quitar.setBounds(767, 42, 57, 14);
		footer.add(Quitar);
		id_user.setVisible(false);
		Quitar.setVisible(false);
		
		IndexPanel = new JPanel();
		IndexPanel.setBounds(0, 105, 1367, 515);
		contentPane.add(IndexPanel);
		IndexPanel.setLayout(null);
	
		
	}
}
