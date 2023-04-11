package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import java.awt.Color;

public class ModificarSlider extends JPanel {
	public JTable TablaSlider;
	public JTextField textNombre;
	public JTextField textInfo;
	public JButton btnCambiarImagen;
	public JButton btnEditar;
	public JLabel lblImagen;
	public JButton btnEstado;

	public ModificarSlider() {
		setBounds(174, 105, 1188, 595);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MODIFICAR SLIDER");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 29));
		lblNewLabel.setBounds(59, 53, 458, 82);
		add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(59, 176, 458, 298);
		add(scrollPane);
		
		TablaSlider = new JTable();
		scrollPane.setViewportView(TablaSlider);
		
		JLabel lblNombre = new JLabel("NOMBRE:");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNombre.setBounds(766, 176, 303, 31);
		add(lblNombre);
		
		JLabel lblInfo = new JLabel("INFO:");
		lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfo.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblInfo.setBounds(766, 273, 303, 31);
		add(lblInfo);
		
		textNombre = new JTextField();
		textNombre.setBounds(766, 217, 303, 31);
		add(textNombre);
		textNombre.setColumns(10);
		
		textInfo = new JTextField();
		textInfo.setColumns(10);
		textInfo.setBounds(766, 315, 303, 82);
		add(textInfo);
		
		btnCambiarImagen = new JButton("CAMBIAR IMAGEN");
		btnCambiarImagen.setForeground(new Color(0, 0, 255));
		btnCambiarImagen.setBackground(new Color(255, 255, 255));
		btnCambiarImagen.setFont(new Font("Arial Black", Font.PLAIN, 11));
		btnCambiarImagen.setBounds(766, 418, 179, 56);
		add(btnCambiarImagen);
		
		btnEditar = new JButton("EDITAR");
		btnEditar.setForeground(new Color(255, 255, 255));
		btnEditar.setFont(new Font("Arial Black", Font.PLAIN, 11));
		btnEditar.setBackground(Color.BLUE);
		btnEditar.setBounds(955, 418, 114, 56);
		add(btnEditar);
		
		lblImagen = new JLabel("NOMBRE:");
		lblImagen.setHorizontalAlignment(SwingConstants.RIGHT);
		lblImagen.setFont(new Font("Arial Black", Font.BOLD, 8));
		lblImagen.setBounds(766, 430, 179, 31);
		add(lblImagen);
		
		btnEstado = new JButton("estado\r\n");
		btnEstado.setForeground(Color.WHITE);
		btnEstado.setFont(new Font("Arial Black", Font.PLAIN, 11));
		btnEstado.setBackground(Color.BLUE);
		btnEstado.setBounds(642, 418, 114, 56);
		add(btnEstado);
		
		btnCambiarImagen.setVisible(false);
		btnEditar.setVisible(false);
		btnEstado.setVisible(false);
	}
}
