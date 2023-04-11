package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import herramientas.Ayudas;
import modelo.Usuario;
import sql.Consultas;
import vista.*;
public class ModificarImagenesController implements ActionListener, MouseListener{

	ModificarImagenes MI;
	Usuario u = new Usuario();
	public ModificarImagenesController(ModificarImagenes MI, Usuario u) {
		this.MI = MI;
		this.u = u;
		this.MI.btnVolver.addActionListener(this);
		this.MI.TablaImagenes.addMouseListener(this);
		this.MI.btnAgregarImagen.addActionListener(this);
		this.MI.btnEliminarImagen.addActionListener(this);
		Ayudas.LLenarTablaImagenes(MI, u);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(MI.btnAgregarImagen)) {
		
			if(MI.lblLimiteImagenes.getText().equals("10")) {
				
				JOptionPane.showMessageDialog(null, "NO SE PERMITEN MAS IMAGENES");
			}else {
			JFileChooser file = new JFileChooser();
			file.showOpenDialog(MI);
			File archivo = file.getSelectedFile();
			
			if(archivo != null) {
				int formato = archivo.getName().length() - 4;
				String FinFormato = archivo.getName().toString().substring(formato);
				if (!FinFormato.equals(".png") && !FinFormato.equals(".jpg")) {
					JOptionPane.showMessageDialog(null, "FORMATO NO VALIDO \n EL FORMATO DEBE SER .png o .jpg");
				}else {
				
				Consultas consulta = new Consultas();
				consulta.ClaveImagenImagenes_Productos(u);
				
				u.setImagen(u.getId()+"_"+Ayudas.obtenerFechaYHoraActual()+FinFormato);
					String Dest = System.getProperty("user.dir") + "/images/"+ u.getImagen();
					Path destino = Paths.get(Dest);
					String Orig = archivo.getPath();
					Path Origen = Paths.get(Orig);
					
					
					try {
						Files.copy(Origen, destino);
						consulta.InsertarImagenProducto(u);
					} catch (IOException ex) {
						// TODO: handle exception
					}
					Ayudas.LLenarTablaImagenes(MI, u);
					JOptionPane.showMessageDialog(null, "IMAGEN INSERTADA");
				
			}	
				}
			}
		}
		
		if(e.getSource().equals(MI.btnVolver)) {
			MI.dispose();
		}
		if(e.getSource().equals(MI.btnEliminarImagen)) {
		
			Consultas consulta = new Consultas();
			consulta.EliminarImagenProducto(u);
			String Dest = System.getProperty("user.dir") + "/images/"+u.getImagen()+"" ;
			Path destino = Paths.get(Dest);
			try {
				Files.delete(destino);
			} catch (IOException ex) {
				
			}
			MI.btnEliminarImagen.setVisible(false);
			JOptionPane.showMessageDialog(null, "IMAGEN ELIMINADA");
			Ayudas.LLenarTablaImagenes(MI, u);
			
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getSource().equals(MI.TablaImagenes)) {
			
			int row = MI.TablaImagenes.getSelectedRow();
			String id = (String)  MI.TablaImagenes.getValueAt(row, 0).toString();
			String imagen = (String) MI.TablaImagenes.getValueAt(row, 1).toString();
			
			u.setId(id);
			u.setImagen(imagen);
			MI.btnEliminarImagen.setVisible(true);
		}
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
