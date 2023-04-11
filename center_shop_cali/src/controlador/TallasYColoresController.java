package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
import vista.PerfilEmpresa;
import vista.TallasYColores;

public class TallasYColoresController implements ActionListener , MouseListener, KeyListener{

	TallasYColores TC;
	PerfilEmpresa PE;
	public Path origen;
	public Path Destino;
	public Path Destino2;
	Usuario u = new Usuario();
	Consultas consulta = new Consultas();
	public TallasYColoresController(TallasYColores TC, PerfilEmpresa PE, Usuario u) {
		
		this.TC = TC;
		this.PE = PE;
		this.u = u;
		
		this.TC.btnAgregarColor.addActionListener(this);
		this.TC.btnAgregarImagen.addActionListener(this);
		this.TC.btnAgregarTalla.addActionListener(this);
		this.TC.btnCancelarColor.addActionListener(this);
		this.TC.btnCancelarTalla.addActionListener(this);
		this.TC.btnEliminarColor.addActionListener(this);
		this.TC.btnEliminarTalla.addActionListener(this);
		this.TC.TablaColores.addMouseListener(this);
		this.TC.TablaTallas.addMouseListener(this);
		this.TC.textCantidadTalla.addKeyListener(this);
		this.TC.textColor.addKeyListener(this);
		this.TC.textTalla.addKeyListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(TC.btnAgregarImagen)) {
			JFileChooser file = new JFileChooser();
			file.showOpenDialog(TC);
			File archivo = file.getSelectedFile();
			
			if(archivo != null) {
				
				int formato = archivo.getName().length() - 4;
				String FinFormato = archivo.getName().toString().substring(formato);
				if (!FinFormato.equals(".png") && !FinFormato.equals(".jpg")) {
					JOptionPane.showMessageDialog(null, "FORMATO NO VALIDO \n EL FORMATO DEBE SER .png o .jpg");
				}else {
				Consultas consulta = new Consultas();
				consulta.ClaveImagenColores(u);
				
				u.setImagen(u.getId()+"_"+Ayudas.obtenerFechaYHoraActual()+FinFormato);
				
					String Dest = System.getProperty("user.dir") + "/images/"+ u.getImagen() ;
					Path destino = Paths.get(Dest);
					String Orig = archivo.getPath();
					Path Origen = Paths.get(Orig);
					
					Destino = destino;
					origen = Origen;
					TC.btnCancelarColor.setVisible(true);
					JOptionPane.showMessageDialog(null, "ARCHIVO GUARDADO");
					TC.btnAgregarImagen.setVisible(false);
					TC.btnAgregarImagen.setText("");
					TC.lblImagen.setVisible(true);
					TC.lblImagen.setText(archivo.getName());
					
				
			}	
				}
		}
		if(e.getSource().equals(TC.btnEliminarTalla)) {
		
			if(consulta.ElimiarTalla(u) >0) {
				TC.btnEliminarTalla.setVisible(false);
				TC.btnCancelarTalla.setVisible(false);
				TC.lblTituloTalla.setText("AGREGAR TALLA");
				TC.btnAgregarTalla.setText("AGREGAR");
				TC.textCantidadTalla.setText("");
				TC.textTalla.setText("");
				Ayudas.LLenarTablaTallas(TC, u);
				JOptionPane.showMessageDialog(null, "TALLA ELIMINADA");
			}
		}
		if(e.getSource().equals(TC.btnEliminarColor)) {
			if(consulta.ElimiarColor(u) > 0){
			TC.btnEliminarColor.setVisible(false);
			TC.btnCancelarColor.setVisible(false);
			TC.lblTituloColores.setText("SELECCIONAR IMAGEN");
			TC.btnAgregarColor.setVisible(true);
			TC.btnAgregarImagen.setVisible(true);
			JOptionPane.showMessageDialog(null, "COLOR ELIMINADO");
			try {
				Files.delete(Destino2);
			} catch (IOException ex) {
			}
			Ayudas.LLenarTablaColores(TC, u);
			}else{
				JOptionPane.showMessageDialog(null, "NO SE ELIMINO EL COLOR");
				TC.btnAgregarImagen.setText("SELECCIONAR IMAGEN");
			}
		}
		
		if(e.getSource().equals(TC.btnCancelarColor)) {
			
			TC.btnEliminarColor.setVisible(false);
			TC.btnCancelarColor.setVisible(false);
			TC.lblTituloColores.setText("AGREGAR COLOR");
			TC.btnAgregarColor.setVisible(true);
			TC.btnAgregarImagen.setVisible(true);
			TC.btnAgregarImagen.setText("SELECCIONAR IMAGEN");
			TC.textColor.setText("");
		}
		if(e.getSource().equals(TC.btnCancelarTalla)) {
			
			TC.btnEliminarTalla.setVisible(false);
			TC.btnCancelarTalla.setVisible(false);
			TC.lblTituloTalla.setText("AGREGAR TALLA");
			TC.btnAgregarTalla.setText("AGREGAR");
			TC.textCantidadTalla.setText("");
			TC.textTalla.setText("");
		}
		if(e.getSource().equals(TC.btnAgregarColor)) {
			
			String color = TC.textColor.getText();
			u.setColor(color);
			if(!TC.btnAgregarImagen.getText().equals("")){
				JOptionPane.showMessageDialog(null, "PORFAVOR ELIJA UNA IMAGEN");
			}else 
				if(consulta.InsertarColor(u)) {
			
				TC.btnEliminarColor.setVisible(false);
				TC.btnCancelarColor.setVisible(false);
				TC.lblTituloColores.setText("AGREGAR COLOR");
				TC.btnAgregarColor.setVisible(true);
				TC.btnAgregarImagen.setVisible(true);
				TC.textColor.setText("");
				Ayudas.LLenarTablaColores(TC, u);
				try {
					Files.copy(origen, Destino);
				} catch (IOException ex) {
					// TODO: handle exception
				}
				TC.btnAgregarImagen.setText("SELECCIONAR IMAGEN");
				JOptionPane.showMessageDialog( null, "COLOR AGREGADO");
			}
			
		}
		
		if(e.getSource().equals(TC.btnAgregarTalla)) {
			
			String talla = TC.textTalla.getText();
			String cantidad = TC.textCantidadTalla.getText();
			
			u.setTalla(talla);
			u.setCantidad(cantidad);
			if(TC.btnAgregarTalla.getText().equals("AGREGAR")) {
			if(consulta.InsertarTalla(u)) {
				TC.btnEliminarTalla.setVisible(false);
				TC.btnCancelarTalla.setVisible(false);
				TC.lblTituloTalla.setText("AGREGAR TALLA");
				TC.btnAgregarTalla.setText("AGREGAR");
				TC.textTalla.setText("");
				TC.textCantidadTalla.setText("");
				Ayudas.LLenarTablaTallas(TC, u);
				JOptionPane.showMessageDialog(null, "TALLA AGREGADA");
			}
			}else {
				if(consulta.EditarTalla(u) > 0) {
				TC.btnEliminarTalla.setVisible(false);
				TC.btnCancelarTalla.setVisible(false);
				TC.lblTituloTalla.setText("AGREGAR TALLA");
				TC.btnAgregarTalla.setText("AGREGAR");
				TC.textTalla.setText("");
				TC.textCantidadTalla.setText("");
				Ayudas.LLenarTablaTallas(TC, u);
				JOptionPane.showMessageDialog(null, "TALLA EDITADA");}
			}
		
			
		}
		
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getSource().equals(TC.TablaColores)) {
			
			int row = TC.TablaColores.getSelectedRow();
			String id = (String)  TC.TablaColores.getValueAt(row, 0).toString();
			String imagen = (String) TC.TablaColores.getValueAt(row, 4).toString();
			
			String Dest = System.getProperty("user.dir") + "/images/"+imagen+"" ;
			Destino2 = Paths.get(Dest);
			u.setId(id);
			
		TC.btnEliminarColor.setVisible(true);
		TC.btnCancelarColor.setVisible(true);
		TC.lblTituloColores.setText("ELIMINAR COLOR");
		TC.btnAgregarColor.setVisible(false);
		}
		
		if(e.getSource().equals(TC.TablaTallas)) {
			
			int row = TC.TablaTallas.getSelectedRow();
			String id = (String)  TC.TablaTallas.getValueAt(row, 0).toString();
			String Cantidad = (String) TC.TablaTallas.getValueAt(row, 1).toString();
			String talla = (String) TC.TablaTallas.getValueAt(row, 2).toString();
			u.setId_talla(id);
			
			TC.textTalla.setText(talla);
			TC.textCantidadTalla.setText(Cantidad);
			
			
			TC.btnEliminarTalla.setVisible(true);
			TC.btnCancelarTalla.setVisible(true);
			TC.lblTituloTalla.setText("EDITAR TALLA");
			TC.btnAgregarTalla.setText("EDITAR");
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
