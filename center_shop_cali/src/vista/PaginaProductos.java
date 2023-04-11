package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class PaginaProductos extends JPanel {
	public JButton btnIzquierda;
	public JButton btnDerecha;
	public JButton btnVaciarCarrito;
	public JButton btnComprar;
	public PaginaProductos() {
		
		setBounds(0, 0, 1367, 515);
		setLayout(null);
		
		btnIzquierda = new JButton("<");
		btnIzquierda.setForeground(Color.WHITE);
		btnIzquierda.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		btnIzquierda.setBackground(Color.BLUE);
		btnIzquierda.setBounds(0, 194, 49, 114);
		add(btnIzquierda);
		
		btnDerecha = new JButton(">");
		btnDerecha.setForeground(Color.WHITE);
		btnDerecha.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		btnDerecha.setBackground(Color.BLUE);
		btnDerecha.setBounds(1318, 194, 49, 114);
		add(btnDerecha);
		
		btnVaciarCarrito = new JButton("VACIAR CARRITO");
		btnVaciarCarrito.setFont(new Font("Arial Black", Font.BOLD, 23));
		btnVaciarCarrito.setBackground(new Color(255, 0, 0));
		btnVaciarCarrito.setForeground(new Color(255, 255, 255));
		btnVaciarCarrito.setBounds(265, 465, 290, 50);
		add(btnVaciarCarrito);
		
		btnComprar = new JButton("COMPRAR");
		btnComprar.setBackground(new Color(0, 0, 255));
		btnComprar.setForeground(new Color(255, 255, 255));
		btnComprar.setFont(new Font("Arial Black", Font.BOLD, 25));
		btnComprar.setBounds(965, 465, 244, 50);
		add(btnComprar);
		btnVaciarCarrito.setVisible(false);
		btnComprar.setVisible(false);
	}
}
