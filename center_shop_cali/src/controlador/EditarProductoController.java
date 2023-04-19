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

import herramientas.AplicarValidacion;
import herramientas.Ayudas;
import modelo.Usuario;
import sql.Consultas;
import vista.*;
public class EditarProductoController implements KeyListener, MouseListener, ActionListener{

	EditarProducto EP; 
	PerfilEmpresa PE;
	public Path origen;
	public Path Destino;
	public Path Destino2;
	Usuario u = new Usuario();
	Consultas consulta = new Consultas();
	public EditarProductoController(EditarProducto EP, PerfilEmpresa PE) {
		
		this.EP = EP;
		this.PE = PE;
		this.EP.textPrecio.addKeyListener(this);
		this.EP.textDescripcion.addKeyListener(this);
		this.EP.textDescuento.addKeyListener(this);
		this.EP.textNombreProducto.addKeyListener(this);
		this.EP.btnCrear.addActionListener(this);
		this.EP.btnSeleccionarImagen.addActionListener(this);
		this.EP.categorias.addMouseListener(this);
		this.EP.btnModificarImagenes.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(EP.btnModificarImagenes)) {
			ModificarImagenes MI = new ModificarImagenes();
			MI.setVisible(true);
			u.setId_empresa(PE.ID_Empresa.getText());
			u.setId_producto(PE.ID_Producto.getText());
			new ModificarImagenesController(MI, u);
		}
		
		if(e.getSource().equals(EP.btnSeleccionarImagen)) {
		JFileChooser file = new JFileChooser();
		file.showOpenDialog(EP);
		File archivo = file.getSelectedFile();
		
		if(archivo != null) {
			int formato = archivo.getName().length() - 4;
			String FinFormato = archivo.getName().toString().substring(formato);
			if (!FinFormato.equals(".png") && !FinFormato.equals(".jpg")) {
				JOptionPane.showMessageDialog(null, "FORMATO NO VALIDO \n EL FORMATO DEBE SER .png o .jpg");
			}else {
				consulta.ConsultarLogoProducto(u);
				String Dest2 = System.getProperty("user.dir")+"/images/"+u.getImagen();
				Path destino2 = Paths.get(Dest2);
			u.setId(PE.ID_Producto.getText());
			u.setImagen(u.getId()+"_"+ Ayudas.obtenerFechaYHoraActual()+FinFormato);
			
				String Dest = System.getProperty("user.dir")+"/images/"+u.getImagen();
				Path destino = Paths.get(Dest);
				Usuario u = new Usuario();
				u.setId_producto(PE.ID_Producto.getText());
				
				
				String Orig = archivo.getPath();
				Path Origen = Paths.get(Orig);
				
				Destino = destino;
				origen = Origen;
				Destino2 = destino2;
				JOptionPane.showMessageDialog(null, "ARCHIVO GUARDADO");
				EP.btnSeleccionarImagen.setVisible(false);
				EP.btnSeleccionarImagen.setText("");
				EP.lblImagen.setVisible(true);
				EP.lblImagen.setText(archivo.getName());
			
			
		}
			}
		}
		
		if(e.getSource().equals(EP.btnCrear)) {
			
			String nombre = EP.textNombreProducto.getText();
			String precio = EP.textPrecio.getText();
			String descuento = EP.textDescuento.getText();
			String descripcion = EP.textDescripcion.getText();
			u.setId_producto(PE.ID_Producto.getText());
			u.setNombre(nombre);
			u.setPrecio(precio);
			u.setDescuento(descuento);
			u.setDescripcion(descripcion);
			u.setCategoria( String.valueOf( EP.categorias.getSelectedItem()));
			u.setId_empresa(PE.ID_Empresa.getText());
			Consultas consulta = new Consultas();
			consulta.id_categoria(u);
			
			if(	AplicarValidacion.NombreEditarProducto(EP.textNombreProducto.getText(), EP) ||AplicarValidacion.PrecioEditarProducto(EP.textPrecio.getText(), EP)
			 || AplicarValidacion.DescuentoEditarProducto(EP.textDescuento.getText(), EP)  || AplicarValidacion.DescripcionEditarProducto(EP.textDescripcion.getText(), EP)) {
				JOptionPane.showMessageDialog(null, "ERROR EN LOS CAMPOS");
			}else if(!EP.btnSeleccionarImagen.getText().equals("")){
				consulta.EditarProductoSinImagen(u);
				EP.textNombreProducto.setText("");
				EP.textPrecio.setText("");
				EP.textDescuento.setText("0");
				EP.textDescripcion.setText("");
				Ayudas.ActualizarPanel( PE.EmpresaPanel, EP , PE.contentPane);
				PE.btnConsultarProductos.setVisible(false);
				PE.textBuscador.setVisible(true);
				Ayudas.LLenarTablaProductos(PE.TablaProductos, u);
				Ayudas.ActualizarProductos(PE, u);
				PE.lblpresionar.setText("PRESIONE UN PRODUCTO PARA MODIFICARLO");
				PE.btnCancelar.setVisible(false);
				PE.btnEliminar.setVisible(false);
				PE.btnEditar.setVisible(false);
				PE.btnTallasColores.setVisible(false);
				JOptionPane.showMessageDialog(null, "PRODUCTO EDITADO");
				
			}else {
				consulta.ConsultarImagen(u);
				if(consulta.EditarProductoSinImagen(u) > 0 ) {
					EP.textNombreProducto.setText("");
					EP.textPrecio.setText("");
					EP.textDescuento.setText("0");
					EP.textDescripcion.setText("");
					Ayudas.ActualizarPanel( PE.EmpresaPanel, EP , PE.contentPane);
					PE.btnConsultarProductos.setVisible(false);
					PE.textBuscador.setVisible(true);
					Ayudas.LLenarTablaProductos(PE.TablaProductos, u);
					Ayudas.ActualizarProductos(PE, u);
					PE.lblpresionar.setText("PRESIONE UN PRODUCTO PARA MODIFICARLO");
					PE.btnCancelar.setVisible(false);
					PE.btnEliminar.setVisible(false);
					PE.btnEditar.setVisible(false);
					PE.btnTallasColores.setVisible(false);
					try {
						Files.copy(origen, Destino);
						consulta.EditarImagenProducto(u);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "PRODUCTO EDITADO");
					
					
				}else {
					JOptionPane.showMessageDialog(null, "PRODUCTO NO INSERTADO");
				}
			}
				
			}
		
	
			
		}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource().equals(EP.categorias)) {
			consulta.CategoriasEditar(EP);
			
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
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
	if(e.getSource().equals(EP.textNombreProducto)) {
			
			AplicarValidacion.NombreEditarProducto(EP.textNombreProducto.getText(), EP);
			
		}
		
		if(e.getSource().equals(EP.textPrecio)) {
			
			AplicarValidacion.PrecioEditarProducto(EP.textPrecio.getText(), EP);
			
		}
		
		if(e.getSource().equals(EP.textDescuento)) {
			
			AplicarValidacion.DescuentoEditarProducto(EP.textDescuento.getText(), EP);
			
		}
		
		if(e.getSource().equals(EP.textDescripcion)) {
			
			AplicarValidacion.ContarEditar(EP.textDescripcion.getText(), EP);
			AplicarValidacion.DescripcionEditarProducto(EP.textDescripcion.getText(), EP);
		}
	
		
	}
}
