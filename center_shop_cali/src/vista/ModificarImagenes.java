package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class ModificarImagenes extends JFrame {

	private JPanel contentPane;
	public JTable TablaImagenes;
	public JButton btnEliminarImagen;
	public JButton btnAgregarImagen;
	private JLabel lblLimiteDeImagenes;
	private JLabel lblLimiteDeImagenes_1;
	public JLabel lblLimiteImagenes;
	public JButton btnVolver;
	public ModificarImagenes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 923, 559);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(65, 112, 383, 232);
		contentPane.add(scrollPane);
		
		TablaImagenes = new JTable();
		scrollPane.setViewportView(TablaImagenes);
		
		JLabel lblNewLabel = new JLabel("IMAGENES");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 34));
		lblNewLabel.setBounds(62, 29, 386, 72);
		contentPane.add(lblNewLabel);
		
		btnAgregarImagen = new JButton("AGREGAR IMAGEN");
		btnAgregarImagen.setForeground(new Color(255, 255, 255));
		btnAgregarImagen.setBackground(new Color(0, 0, 255));
		btnAgregarImagen.setFont(new Font("Arial Black", Font.PLAIN, 20));
		btnAgregarImagen.setBounds(535, 150, 323, 72);
		contentPane.add(btnAgregarImagen);
		
		btnEliminarImagen = new JButton("ELIMINAR IMAGEN");
		btnEliminarImagen.setForeground(Color.WHITE);
		btnEliminarImagen.setFont(new Font("Arial Black", Font.PLAIN, 20));
		btnEliminarImagen.setBackground(new Color(255, 0, 0));
		btnEliminarImagen.setBounds(535, 243, 323, 72);
		contentPane.add(btnEliminarImagen);
		
		lblLimiteDeImagenes = new JLabel("LIMITE DE IMAGENES:");
		lblLimiteDeImagenes.setHorizontalAlignment(SwingConstants.CENTER);
		lblLimiteDeImagenes.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblLimiteDeImagenes.setBounds(62, 355, 230, 42);
		contentPane.add(lblLimiteDeImagenes);
		
		lblLimiteDeImagenes_1 = new JLabel("/10");
		lblLimiteDeImagenes_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblLimiteDeImagenes_1.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblLimiteDeImagenes_1.setBounds(401, 355, 47, 42);
		contentPane.add(lblLimiteDeImagenes_1);
		
		lblLimiteImagenes = new JLabel("0");
		lblLimiteImagenes.setHorizontalAlignment(SwingConstants.CENTER);
		lblLimiteImagenes.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblLimiteImagenes.setBounds(370, 355, 36, 42);
		contentPane.add(lblLimiteImagenes);
		
		btnVolver = new JButton("VOLVER");
		btnVolver.setForeground(new Color(0, 0, 0));
		btnVolver.setFont(new Font("Arial Black", Font.PLAIN, 40));
		btnVolver.setBackground(new Color(0, 0, 255));
		btnVolver.setBounds(535, 341, 334, 136);
		contentPane.add(btnVolver);
		btnEliminarImagen.setVisible(false);
	}
}
