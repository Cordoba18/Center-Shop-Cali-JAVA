package vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class RecuperarContraseña extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	public JPanel PanelPrincipal;
	public RecuperarContraseña() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 923, 559);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		PanelPrincipal = new JPanel();
		PanelPrincipal.setBackground(new Color(255, 255, 255));
		PanelPrincipal.setBounds(453, 0, 454, 520);
		contentPane.add(PanelPrincipal);
		PanelPrincipal.setLayout(null);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("images\\LOGO.png"));
		lblNewLabel.setBounds(10, 11, 422, 487);
		contentPane.add(lblNewLabel);
	}
}
