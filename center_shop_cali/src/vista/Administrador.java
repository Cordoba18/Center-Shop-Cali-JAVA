package vista;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;

public class Administrador extends JFrame {

	public JPanel contentPane;
	public JLabel logo;

	public JTextField textBuscador;
	public JLabel perfil;
	private JPanel panel;
	public JButton btnCrearEmpresa;
	public JLabel lblNombreAdmin;
	private JLabel lblNewLabel;
	public JTextField textE_totales;
	public JButton btnModificarSlider;
	public JButton btnCerrarSesion;
	public JPanel AdminPanel;
	public JButton btnConsultarempresas;
	public JTable TablaEmpresas;
	public JButton btnEditar;
	public JButton btnEliminar;
	public JButton btnCancelar;
	public JLabel lblpresionar;
	public JLabel IdAdmin;
	public JLabel IdEmpresa;
	
	public Administrador() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1378, 739);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel header = new JPanel();
		header.setBounds(0, 0, 1367, 105);
		header.setBackground(new Color(0, 128, 0));
		contentPane.add(header);
		header.setLayout(null);
		
		logo = new JLabel("");
		logo.setIcon(new ImageIcon("icons\\LOGO.png"));
		logo.setBounds(27, 11, 131, 83);
		header.add(logo);
		
		textBuscador = new JTextField();
		textBuscador.setText("BUSCAR EMPRESAS");
		textBuscador.setFont(new Font("Arial Black", Font.PLAIN, 15));
		textBuscador.setBounds(887, 37, 389, 37);
		header.add(textBuscador);
		textBuscador.setColumns(10);
		
		JLabel titulo = new JLabel("CENTER SHOP CALI");
		titulo.setForeground(new Color(255, 255, 255));
		titulo.setFont(new Font("Arial Black", Font.BOLD, 25));
		titulo.setBounds(168, 32, 312, 37);
		header.add(titulo);
		
		 perfil = new JLabel("");
		perfil.setIcon(new ImageIcon("icons\\perfil.png"));
		perfil.setBounds(1286, 32, 50, 50);
		header.add(perfil);
		
		IdEmpresa = new JLabel("ID");
		IdEmpresa.setForeground(Color.WHITE);
		IdEmpresa.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 16));
		IdEmpresa.setBounds(490, 37, 155, 23);
		header.add(IdEmpresa);
		panel = new JPanel();
		panel.setBackground(new Color(0, 128, 0));
		panel.setBounds(0, 104, 175, 596);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnCrearEmpresa = new JButton("CREAR EMPRESA");
		btnCrearEmpresa.setForeground(new Color(255, 255, 255));
		btnCrearEmpresa.setBackground(new Color(0, 0, 255));
		btnCrearEmpresa.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 17));
		btnCrearEmpresa.setBounds(10, 180, 155, 43);
		panel.add(btnCrearEmpresa);
		
		lblNombreAdmin = new JLabel("NOMBRE ADMIN");
		lblNombreAdmin.setForeground(new Color(0, 0, 0));
		lblNombreAdmin.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 16));
		lblNombreAdmin.setBounds(10, 53, 155, 43);
		panel.add(lblNombreAdmin);
		
		lblNewLabel = new JLabel("BIENVENIDO");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 11, 155, 50);
		panel.add(lblNewLabel);
		
		btnModificarSlider = new JButton("MODIFICAR SLIDER");
		btnModificarSlider.setForeground(new Color(255, 255, 255));
		btnModificarSlider.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 17));
		btnModificarSlider.setBackground(Color.BLUE);
		btnModificarSlider.setBounds(10, 234, 155, 43);
		panel.add(btnModificarSlider);
		
		JLabel lblEmpresasTotales = new JLabel("EMPRESAS TOTALES");
		lblEmpresasTotales.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmpresasTotales.setForeground(Color.WHITE);
		lblEmpresasTotales.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblEmpresasTotales.setBounds(10, 411, 155, 50);
		panel.add(lblEmpresasTotales);
		
		textE_totales = new JTextField();
		textE_totales.setEditable(false);
		textE_totales.setFont(new Font("Arial Black", Font.BOLD, 11));
		textE_totales.setHorizontalAlignment(SwingConstants.CENTER);
		textE_totales.setBounds(10, 472, 155, 29);
		panel.add(textE_totales);
		textE_totales.setColumns(10);
		
		btnCerrarSesion = new JButton("CERRAR SESION");
		btnCerrarSesion.setForeground(new Color(0, 0, 0));
		btnCerrarSesion.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 17));
		btnCerrarSesion.setBackground(new Color(255, 255, 255));
		btnCerrarSesion.setBounds(10, 288, 155, 43);
		panel.add(btnCerrarSesion);
		
		btnConsultarempresas = new JButton("CONSULTAR EMPRESAS");
		btnConsultarempresas.setForeground(Color.WHITE);
		btnConsultarempresas.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 14));
		btnConsultarempresas.setBackground(Color.BLUE);
		btnConsultarempresas.setBounds(10, 129, 155, 43);
		panel.add(btnConsultarempresas);
		
		IdAdmin = new JLabel("ID");
		IdAdmin.setForeground(new Color(255, 255, 255));
		IdAdmin.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 16));
		IdAdmin.setBounds(10, 95, 155, 23);
		panel.add(IdAdmin);
		
		AdminPanel = new JPanel();
		AdminPanel.setBounds(174, 104, 1188, 596);
		contentPane.add(AdminPanel);
		AdminPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(101, 77, 992, 270);
		AdminPanel.add(scrollPane);
		
		TablaEmpresas = new JTable();
		TablaEmpresas.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		TablaEmpresas.setBorder(new LineBorder(new Color(0, 128, 0)));
		TablaEmpresas.setFont(new Font("Arial Black", Font.PLAIN, 14));
		scrollPane.setViewportView(TablaEmpresas);
		
		lblpresionar = new JLabel("PRESIONE UNA EMPRESA PARA MODIFICARLA");
		lblpresionar.setHorizontalAlignment(SwingConstants.CENTER);
		lblpresionar.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 19));
		lblpresionar.setBounds(105, 379, 988, 56);
		AdminPanel.add(lblpresionar);
		
		btnEditar = new JButton("EDITAR");
		btnEditar.setForeground(Color.WHITE);
		btnEditar.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 17));
		btnEditar.setBackground(Color.BLUE);
		btnEditar.setBounds(372, 446, 155, 43);
		AdminPanel.add(btnEditar);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 17));
		btnEliminar.setBackground(Color.BLUE);
		btnEliminar.setBounds(537, 446, 155, 43);
		AdminPanel.add(btnEliminar);
		
		btnCancelar = new JButton("CANCELAR");
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 17));
		btnCancelar.setBackground(new Color(255, 0, 0));
		btnCancelar.setBounds(702, 446, 155, 43);
		AdminPanel.add(btnCancelar);
		btnConsultarempresas.setVisible(false);
		btnEliminar.setVisible(false);
		btnEditar.setVisible(false);
		btnCancelar.setVisible(false);
		IdAdmin.setVisible(false);
		IdEmpresa.setVisible(false);
	}
}
