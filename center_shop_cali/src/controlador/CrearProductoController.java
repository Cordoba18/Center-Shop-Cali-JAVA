package controlador;
import vista.*;
import sql.Consultas;

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

import herramientas.AplicarValidacion;
import herramientas.Ayudas;
import modelo.*;
public class CrearProductoController implements ActionListener, KeyListener, MouseListener{
	CrearProducto CP;
	public Path origen;
	public Path Destino;
	 PerfilEmpresa PE;
	Usuario u = new Usuario();
	public int contador;
	public CrearProductoController(CrearProducto CP, PerfilEmpresa PE) {
		
		this.CP = CP;
		this.PE = PE;
		this.CP.btnCrear.addActionListener(this);
		this.CP.btnSeleccionarImagen.addActionListener(this);
		this.CP.categorias.addMouseListener(this);
		this.CP.textNombreProducto.addKeyListener(this);
		this.CP.textPrecio.addKeyListener(this);
		this.CP.textDescuento.addKeyListener(this);
		this.CP.textDescuento.addMouseListener(this);
		this.CP.textDescripcion.addKeyListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	if(e.getSource().equals(CP.btnSeleccionarImagen)) {
			
			JFileChooser file = new JFileChooser();
			file.showOpenDialog(CP);
			File archivo = file.getSelectedFile();
			
			if(archivo != null) {
				
				int formato = archivo.getName().length() - 4;
				String FinFormato = archivo.getName().toString().substring(formato);
				if (!FinFormato.equals(".png") && !FinFormato.equals(".jpg")) {
					JOptionPane.showMessageDialog(null, "FORMATO NO VALIDO \n EL FORMATO DEBE SER .png o .jpg");
				}else {
				
				Consultas consulta = new Consultas();
				consulta.ClaveImagenProducto(u);
				u.setImagen(u.getId()+"_"+ Ayudas.obtenerFechaYHoraActual()+FinFormato);
				
				
					String Dest = System.getProperty("user.dir") + "/images/"+ u.getImagen() ;
					Path destino = Paths.get(Dest);
					String Orig = archivo.getPath();
					Path Origen = Paths.get(Orig);
					
					Destino = destino;
					origen = Origen;
					
					JOptionPane.showMessageDialog(null, "ARCHIVO GUARDADO");
					CP.btnSeleccionarImagen.setVisible(false);
					CP.btnSeleccionarImagen.setText("");
					CP.lblImagen.setVisible(true);
					CP.lblImagen.setText(archivo.getName());
					
				
			}
			}
			}
	
	if(e.getSource().equals(CP.btnCrear)) {
		
		String nombre = CP.textNombreProducto.getText();
		String precio = CP.textPrecio.getText();
		String descuento = CP.textDescuento.getText();
		String descripcion = CP.textDescripcion.getText();
		
		u.setNombre(nombre);
		u.setPrecio(precio);
		u.setDescuento(descuento);
		u.setDescripcion(descripcion);
		u.setCategoria(String.valueOf( CP.categorias.getSelectedItem()));
		u.setId_empresa(PE.ID_Empresa.getText());
		
		if(	AplicarValidacion.NombreCrearProducto(CP.textNombreProducto.getText(), CP) || AplicarValidacion.PrecioCrearProducto(CP.textPrecio.getText(), CP) 
				|| AplicarValidacion.DescuentoCrearProducto(CP.textDescuento.getText(), CP) || AplicarValidacion.DescripcionCrearProducto(CP.textDescripcion.getText(), CP)) {
			JOptionPane.showMessageDialog(null, "ERROR EN LOS CAMPOS");
		}else if(!CP.btnSeleccionarImagen.getText().equals("")){
			JOptionPane.showMessageDialog(null, "PORFAVOR ELIJA UNA IMAGEN");
		}else {
			
			Consultas consulta = new Consultas();
			consulta.id_categoria(u);
			if(consulta.InsertarProducto(u)) {
				consulta.VerId_Producto(u);
				consulta.InsertarImagenProducto(u);
				try {
					Files.copy(origen, Destino);
				} catch (IOException ex) {
					// TODO: handle exception
				}
				CP.textNombreProducto.setText("");
				CP.textPrecio.setText("");
				CP.textDescuento.setText("0");
				CP.textDescripcion.setText("");
				Ayudas.ActualizarPanel( PE.EmpresaPanel, CP , PE.contentPane);
				PE.btnConsultarProductos.setVisible(false);
				PE.textBuscador.setVisible(true);
				Ayudas.LLenarTablaProductos(PE.TablaProductos, u);
				Ayudas.ActualizarProductos(PE, u);
				JOptionPane.showMessageDialog(null, "PRODUCTO INSERTADO");
				
				
				
			}else {
				JOptionPane.showMessageDialog(CP, "PRODUCTO NO INSERTADO");
			}
		}
			
		}
		
	}
		
		
	
	

	@Override
	public void mouseClicked(MouseEvent e) {
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
	if(e.getSource().equals(CP.textDescuento)) {
		
		CP.textDescuento.setText("");
		
	}
	
	
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		if(e.getSource().equals(CP.categorias)) {
			
			Consultas consulta = new Consultas();
			consulta.categorias_2(CP);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		if(e.getSource().equals(CP.textNombreProducto)) {
			
			AplicarValidacion.NombreCrearProducto(CP.textNombreProducto.getText(), CP);
			
		}
		
		if(e.getSource().equals(CP.textPrecio)) {
			
			AplicarValidacion.PrecioCrearProducto(CP.textPrecio.getText(), CP);
			
		}
		
		if(e.getSource().equals(CP.textDescuento)) {
			
			AplicarValidacion.DescuentoCrearProducto(CP.textDescuento.getText(), CP);
			
		}
		
		if(e.getSource().equals(CP.textDescripcion)) {
			
			AplicarValidacion.Contar(CP.textDescripcion.getText(), CP);
			AplicarValidacion.DescripcionCrearProducto(CP.textDescripcion.getText(), CP);
		}
	
	}

	
}
