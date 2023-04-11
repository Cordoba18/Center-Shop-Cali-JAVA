package vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class PerfilEmpresa extends JFrame {

	public JPanel contentPane;
	public JButton btnTallasColores;
	public JLabel logo;
	public JLabel lblImagenEmpresa;
	public JTextField textBuscador;
	private JPanel panel;
	public JButton btnCrearProductos;
	public JLabel lblNombrerEmpresa;
	private JLabel lblNewLabel;
	public JTextField textE_totales;
	public JButton btnCerrarSesion;
	public JPanel EmpresaPanel;
	public JButton btnConsultarProductos;
	public JTable TablaProductos;
	public JButton btnEditar;
	public JButton btnEliminar;
	public JButton btnCancelar;
	public JLabel lblpresionar;
	public JLabel ID_Empresa;
	public JLabel ID_Producto; 
	public PerfilEmpresa() {
		
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
		textBuscador.setHorizontalAlignment(SwingConstants.RIGHT);
		textBuscador.setText("BUSCAR PRODUCTOS");
		textBuscador.setFont(new Font("Arial Black", Font.PLAIN, 15));
		textBuscador.setBounds(887, 37, 389, 37);
		header.add(textBuscador);
		textBuscador.setColumns(10);
		
		JLabel titulo = new JLabel("CENTER SHOP CALI");
		titulo.setForeground(new Color(255, 255, 255));
		titulo.setFont(new Font("Arial Black", Font.BOLD, 25));
		titulo.setBounds(168, 32, 312, 37);
		header.add(titulo);
		
		ID_Producto = new JLabel("ID");
		ID_Producto.setHorizontalAlignment(SwingConstants.CENTER);
		ID_Producto.setForeground(Color.WHITE);
		ID_Producto.setFont(new Font("Arial Black", Font.BOLD, 20));
		ID_Producto.setBounds(635, 24, 155, 50);
		header.add(ID_Producto);
		
		panel = new JPanel();
		panel.setBackground(new Color(0, 128, 0));
		panel.setBounds(0, 104, 175, 596);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnCrearProductos = new JButton("CREAR PRODUCTO");
		btnCrearProductos.setForeground(new Color(255, 255, 255));
		btnCrearProductos.setBackground(new Color(0, 0, 255));
		btnCrearProductos.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 17));
		btnCrearProductos.setBounds(10, 353, 155, 43);
		panel.add(btnCrearProductos);
		
		lblNombrerEmpresa = new JLabel("NOMBRE EMPRESA");
		lblNombrerEmpresa.setForeground(new Color(0, 0, 0));
		lblNombrerEmpresa.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 16));
		lblNombrerEmpresa.setBounds(10, 53, 155, 43);
		panel.add(lblNombrerEmpresa);
		
		lblNewLabel = new JLabel("BIENVENIDO");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 11, 155, 50);
		panel.add(lblNewLabel);
		
		JLabel lblEmpresasTotales = new JLabel("PRODUCTOS TOTALES:");
		lblEmpresasTotales.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmpresasTotales.setForeground(Color.WHITE);
		lblEmpresasTotales.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblEmpresasTotales.setBounds(10, 475, 155, 50);
		panel.add(lblEmpresasTotales);
		
		textE_totales = new JTextField();
		textE_totales.setEditable(false);
		textE_totales.setFont(new Font("Arial Black", Font.BOLD, 11));
		textE_totales.setHorizontalAlignment(SwingConstants.CENTER);
		textE_totales.setBounds(10, 536, 155, 29);
		panel.add(textE_totales);
		textE_totales.setColumns(10);
		
		btnCerrarSesion = new JButton("CERRAR SESION");
		btnCerrarSesion.setForeground(new Color(0, 0, 0));
		btnCerrarSesion.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 17));
		btnCerrarSesion.setBackground(new Color(255, 255, 255));
		btnCerrarSesion.setBounds(10, 421, 155, 43);
		panel.add(btnCerrarSesion);
		
		btnConsultarProductos = new JButton("CONSULTAR PRODUCTOS");
		btnConsultarProductos.setForeground(Color.WHITE);
		btnConsultarProductos.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 11));
		btnConsultarProductos.setBackground(Color.BLUE);
		btnConsultarProductos.setBounds(10, 299, 155, 43);
		panel.add(btnConsultarProductos);
		
		lblImagenEmpresa = new JLabel("");
		lblImagenEmpresa.setForeground(Color.BLACK);
		lblImagenEmpresa.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 16));
		lblImagenEmpresa.setBounds(10, 111, 155, 125);
		panel.add(lblImagenEmpresa);
		
		ID_Empresa = new JLabel("ID");
		ID_Empresa.setHorizontalAlignment(SwingConstants.CENTER);
		ID_Empresa.setForeground(Color.WHITE);
		ID_Empresa.setFont(new Font("Arial Black", Font.BOLD, 20));
		ID_Empresa.setBounds(10, 236, 155, 50);
		panel.add(ID_Empresa);
		
		EmpresaPanel = new JPanel();
		EmpresaPanel.setBounds(174, 104, 1188, 596);
		contentPane.add(EmpresaPanel);
		EmpresaPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(101, 77, 992, 270);
		EmpresaPanel.add(scrollPane);
		
		TablaProductos = new JTable();
		TablaProductos.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		TablaProductos.setBorder(new LineBorder(new Color(0, 128, 0)));
		TablaProductos.setFont(new Font("Arial Black", Font.PLAIN, 14));
		scrollPane.setViewportView(TablaProductos);
		
		lblpresionar = new JLabel("PRESIONE UNA EMPRESA PARA MODIFICARLA");
		lblpresionar.setHorizontalAlignment(SwingConstants.CENTER);
		lblpresionar.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 19));
		lblpresionar.setBounds(105, 379, 988, 56);
		EmpresaPanel.add(lblpresionar);
		
		btnEditar = new JButton("EDITAR");
		btnEditar.setForeground(Color.WHITE);
		btnEditar.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 17));
		btnEditar.setBackground(Color.BLUE);
		btnEditar.setBounds(372, 446, 155, 43);
		EmpresaPanel.add(btnEditar);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 17));
		btnEliminar.setBackground(Color.BLUE);
		btnEliminar.setBounds(537, 446, 155, 43);
		EmpresaPanel.add(btnEliminar);
		
		btnCancelar = new JButton("CANCELAR");
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 25));
		btnCancelar.setBackground(new Color(255, 0, 0));
		btnCancelar.setBounds(702, 446, 202, 97);
		EmpresaPanel.add(btnCancelar);
		
		btnTallasColores = new JButton("TALLAS Y COLORES");
		btnTallasColores.setForeground(new Color(255, 255, 255));
		btnTallasColores.setBackground(new Color(0, 0, 255));
		btnTallasColores.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 19));
		btnTallasColores.setBounds(372, 500, 318, 43);
		EmpresaPanel.add(btnTallasColores);
		btnConsultarProductos.setVisible(false);
		btnEliminar.setVisible(false);
		btnEditar.setVisible(false);
		btnCancelar.setVisible(false);
		btnTallasColores.setVisible(false);
		ID_Producto.setVisible(false);
		ID_Empresa.setVisible(false);
	}
}
