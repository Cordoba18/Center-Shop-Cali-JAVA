package controlador;
import vista.*;

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

import controlador.*;
import herramientas.Ayudas;
import modelo.Usuario;
import sql.*;
public class ModificarSliderController implements MouseListener, KeyListener, ActionListener{
	ModificarSlider MSlider;
	public Path origen;
	public Path Destino;
	public Path Destino2;
	Usuario u = new Usuario();
	Consultas consulta = new Consultas();
	public ModificarSliderController(ModificarSlider MSlider) {
		
		this.MSlider = MSlider;
		this.MSlider.TablaSlider.addMouseListener(this);
		this.MSlider.btnEditar.addActionListener(this);
		this.MSlider.btnCambiarImagen.addActionListener(this);
		this.MSlider.textNombre.addKeyListener(this);
		this.MSlider.textInfo.addKeyListener(this);
		this.MSlider.btnEstado.addActionListener(this);
		LlenarTablaSlider();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(MSlider.btnCambiarImagen)) {
			
			JFileChooser file = new JFileChooser();
			file.showOpenDialog(MSlider);
			File archivo = file.getSelectedFile();
			
			if(archivo != null) {
				int formato = archivo.getName().length() - 4;
				String FinFormato = archivo.getName().toString().substring(formato);
				if (!FinFormato.equals(".png") && !FinFormato.equals(".jpg")) {
					JOptionPane.showMessageDialog(null, "FORMATO NO VALIDO \n EL FORMATO DEBE SER .png o .jpg");
				}else {
					String Dest2 = System.getProperty("user.dir") + "/images/"+u.getImagen()+"" ;
					Path destino2 = Paths.get(Dest2);
				u.setImagen(u.getId()+"_"+Ayudas.obtenerFechaYHoraActual()+FinFormato);
				
					String Dest = System.getProperty("user.dir") + "/images/"+ u.getImagen();
					Path destino = Paths.get(Dest);
					
					
					
					
					String Orig = archivo.getPath();
					Path Origen = Paths.get(Orig);
					
					Destino = destino;
					origen = Origen;
					Destino2 = destino2;
					JOptionPane.showMessageDialog(null, "ARCHIVO GUARDADO");
					MSlider.btnCambiarImagen.setVisible(false);
					MSlider.btnCambiarImagen.setText("");
					MSlider.lblImagen.setVisible(true);
					MSlider.lblImagen.setText(archivo.getName());
					}
			}
		}
		
		if(e.getSource().equals(MSlider.btnEditar)) {
			
			String nombre = MSlider.textNombre.getText();
			String info = MSlider.textInfo.getText();
			
			u.setNombre(nombre);
			u.setInfo(info);
			
			
			if(MSlider.btnCambiarImagen.getText().equals("")) {
				
				consulta.EditarSliderConImagen(u);
				try {
					Files.copy(origen, Destino);
					Files.delete(Destino2);
					
				} catch (IOException ex) {
					System.out.println(ex);
				}
				
				LlenarTablaSlider();
				MSlider.btnCambiarImagen.setVisible(true);
				MSlider.btnCambiarImagen.setText("CAMBIAR IMGAEN");
				MSlider.lblImagen.setVisible(false);
				JOptionPane.showMessageDialog(null, "Slider Editado");
			}else {
				
				consulta.EditarSliderSinImagen(u);
				LlenarTablaSlider();
				JOptionPane.showMessageDialog(null, "Slider Editado");
			}
			
		}
		
		if(e.getSource().equals(MSlider.btnEstado)) {
		
			if(MSlider.btnEstado.getText().equals("Desactivar")){
				
				consulta.DesactivarSlider(u);
				MSlider.btnEstado.setText("Activar");
				LlenarTablaSlider();
				
			}else{
				
				consulta.ActivarSlider(u);
				MSlider.btnEstado.setText("Desactivar");
				LlenarTablaSlider();
				
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
		if(e.getSource().equals(MSlider.TablaSlider)) {
		MSlider.btnCambiarImagen.setVisible(true);
		MSlider.btnEditar.setVisible(true);
		MSlider.btnEstado.setVisible(true);
			int row = MSlider.TablaSlider.getSelectedRow();
			String id = (String)   MSlider.TablaSlider.getValueAt(row, 0).toString();
			String nombre = (String)  MSlider.TablaSlider.getValueAt(row, 1).toString();
			String info = (String)  MSlider.TablaSlider.getValueAt(row, 2).toString();
			String imagen = (String)   MSlider.TablaSlider.getValueAt(row, 3).toString();
			String estado = (String)  MSlider.TablaSlider.getValueAt(row, 4).toString();
			
			u.setId(id);
			u.setNombre(nombre);
			u.setImagen(imagen);
			u.setInfo(info);
			u.setEstado(estado);
			
			if(estado.equals("activo")) {
				MSlider.btnEstado.setText("Desactivar");
				
				
			}else {
				
				MSlider.btnEstado.setText("Activar");
			}
			MSlider.textNombre.setText(nombre);
			MSlider.textInfo.setText(info);
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
	private void LlenarTablaSlider() {
		
		Consultas consulta = new Consultas();
		consulta.Sliders(MSlider.TablaSlider);
	}
}
