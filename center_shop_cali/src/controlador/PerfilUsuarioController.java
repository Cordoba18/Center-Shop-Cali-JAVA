package controlador;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import herramientas.AplicarValidacion;
import herramientas.Ayudas;
import modelo.Usuario;
import sql.Conexion;
import sql.Consultas;
import vista.CambiarContraseñaUsuario;
import vista.Index;
import vista.PaginaProductos;
import vista.PanelPrincipal;
import vista.PerfilUsuario;
import vista.Producto;

public class PerfilUsuarioController implements KeyListener, ActionListener{
	PerfilUsuario PU;
	Index I;
	public static int slider = 1;
	Usuario u = new Usuario();
	public static int datos = 0;
	public int productos = 0;
	public int producto = 0;
	public int total = 0;
	public int todos= 0;
	public boolean sesion;
	Ayudas a = new Ayudas();
	boolean categoria = true;
	Consultas consulta = new Consultas();
	 List <String> id  = new ArrayList<>();
      List <String> name  = new ArrayList<>();
      List <String>  precio = new ArrayList<>();
      List <String> descuento  = new ArrayList<>();
      List <String>  id_empresa = new ArrayList<>();
     List <String>  imagen = new ArrayList<>();
     List <String>  id_productos = new ArrayList<>();
	PaginaProductos PP = new PaginaProductos();
	PanelPrincipal PanelP = new PanelPrincipal();
	Producto producto1 = new Producto();
	Producto producto2 = new Producto();
	Producto producto3 = new Producto();
	List <String> Nombre  = new ArrayList<>(); 
	public PerfilUsuarioController(PerfilUsuario PU, Index I) {
		this.PU = PU;
		this.I = I;
		this.PU.btnCerrarSesion.addActionListener(this);
		this.PU.btnCarritoCompras.addActionListener(this);
		this.PU.btnListaDeDeseos.addActionListener(this);
		this.PP.btnDerecha.addActionListener(this);
		this.PP.btnIzquierda.addActionListener(this);
		this.PU.textNombre.addKeyListener(this);
		this.PU.textCedula.addKeyListener(this);
		this.PU.textDirrecion.addKeyListener(this);
		this.PU.textTelefono.addKeyListener(this);
		this.PU.btnGuardarCambios.addActionListener(this);
		this.PU.btnCambiarContrasena.addActionListener(this);
		this.PP.btnVaciarCarrito.addActionListener(this);
		PaginaProductoUnoController PPU = new PaginaProductoUnoController(producto1, I);
		PaginaProductoDosController PPD = new PaginaProductoDosController(producto2, I);
		PaginaProductoTresController PPT = new PaginaProductoTresController(producto3, I);
		CargarDatos();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(PP.btnVaciarCarrito)) {
			Usuario u = new Usuario();
			u.setId(I.id_user.getText());
			if(consulta.EliminarTodosLosProductosDelCarrito(u)>0) {
			JOptionPane.showMessageDialog(null, "PRODUCTO ELIMINADOS DEL CARRITO");
			PerfilUsuario PU = new PerfilUsuario();
			Ayudas.ActualizarPanelFacil(PU, I.IndexPanel);
			new PerfilUsuarioController(PU, I);}
		
		}
		if(e.getSource().equals(PU.btnCambiarContrasena)) {
			CambiarContraseñaUsuario CCU = new CambiarContraseñaUsuario();
			CCU.setVisible(true);
			new CambiarContraseñaUsuarioController(CCU);
			CCU.id_user.setText(I.id_user.getText());
		}
		if(e.getSource().equals(PU.btnGuardarCambios)) {
			
			String nombre = PU.textNombre.getText();
			String cedula = PU.textCedula.getText();
			String telefono = PU.textTelefono.getText();
			String direccion = PU.textDirrecion.getText();
			
			
			u.setNombre(nombre);
			u.setCedula(cedula);
			u.setTelefono(telefono);
			u.setDireccion(direccion);
			
			if(AplicarValidacion.NombreEditarUsuario(PU.textNombre.getText(), PU)||
			AplicarValidacion.CedulaEditarUsuario(PU.textCedula.getText(), PU)||
			AplicarValidacion.DireccionEditarUsuario(PU.textDirrecion.getText(), PU)||
			AplicarValidacion.TelefonoEditarUsuario(PU.textTelefono.getText(), PU)) {
				JOptionPane.showMessageDialog(null, "ERROR EN LOS CAMPOS");
			}else {
				if(consulta.EditarUsuario(u)>0) {
					CargarDatos();
					JOptionPane.showMessageDialog(null, "INFORMACIÓN GUARDADA");
				}else {
					JOptionPane.showMessageDialog(null, "NO SE INSERTO LOS DATOS");
				}
			}
		}
		
		if(e.getSource().equals(PP.btnIzquierda)) {
			PP.removeAll();
			PP.repaint();
			PP.add(PP.btnIzquierda);
			PP.add(PP.btnDerecha);
			PP.btnDerecha.setVisible(true);
			PP.btnIzquierda.setVisible(true);
			producto = 1;
			
			for (productos = todos-3; productos  < todos; productos++) {
				
				System.out.println("Productos  :" + productos + "\nProducto:   " + producto + "  TOTAL: " + total + "Todos :" + todos);
	        if(producto == 1 && productos >= 0) {
	        	
	    		PP.add(producto1);
	    		PP.repaint();
	    		PP.revalidate();
	    		producto1.setBounds(66, 77, 354, 377);
	    		 PonerProducto(producto1);
	    		producto = producto + 1;}
	        else if(producto == 2 && productos >= 0) {
	        	
	    		PP.add(producto2);
	    		PP.repaint();
	    		PP.revalidate();
	    		producto2.setBounds(502, 77, 354, 377);
	    		 PonerProducto(producto2);
	    		producto = producto + 1;}
	        else  if(producto == 3 && productos >= 0) {
	        	
	    		PP.add(producto3);
	    		PP.repaint();
	    		PP.revalidate();
	    		producto3.setBounds(949, 77, 354, 377);
	    		PonerProducto(producto3);
	    		}
	        
	    		
	       
			}
			if(todos == 3) {
				PP.remove(PP.btnIzquierda);	
			}else {
				todos = todos - 3;
				
			}
			
		}
		if(e.getSource().equals(PP.btnDerecha)) {
			producto = 1;
			PP.removeAll();
			PP.repaint();
			PP.add(PP.btnIzquierda);
			PP.add(PP.btnDerecha);
			PP.btnDerecha.setVisible(true);
			PP.btnIzquierda.setVisible(true);
			
	for (productos = todos; productos  < todos+3; productos++) {
		
		
		
				
			
				
	        if(producto == 1 && productos < total) {
	        	
	    		PP.add(producto1);
	    		PP.repaint();
	    		PP.revalidate();
	    		producto1.setBounds(66, 77, 354, 377);
	    		 PonerProducto(producto1);
	    		   producto = producto + 1;
	    		}
	        else if(producto == 2 && productos < total) {
	        	
	    		PP.add(producto2);
	    		PP.repaint();
	    		PP.revalidate();
	    		producto2.setBounds(502, 77, 354, 377);
	    		 PonerProducto(producto2);
	    		   producto = producto + 1;
	    		}
	        else  if(producto == 3 && productos < total) {
	        	
	    		PP.add(producto3);
	    		PP.repaint();
	    		PP.revalidate();
	    		producto3.setBounds(949, 77, 354, 377);
	    		 PonerProducto(producto3);
	    		 
	    		}
	       
	     
	  
	     
	        
	      
	}
	
			if(productos < total) {
				todos = todos + 3;
			}else {
				productos = productos - 3;
				PP.remove(PP.btnDerecha);	
			}
			}
		if(e.getSource().equals(PU.btnCerrarSesion)) {
			Index ID = new Index();
			I.dispose();
			new IndexController(ID);
		}
		if(e.getSource().equals(PU.btnCarritoCompras)) {
			I.lblTitulo.setVisible(true);
			I.lblTitulo.setText("CARRITO DE COMPRAS");
			I.Quitar.setText("carrito");
			total = 0;
			todos = 0;
			producto = 0;
			 id.clear();
		     name.clear();
		    precio.clear();;
		     descuento.clear();
		    id_empresa.clear(); 
		     imagen.clear(); 
		     id_productos.clear();
		
	        id_productos = consulta.Id_ProductosCUsuario(u);
	        Conexion conectar = new Conexion();
	        while(total< id_productos.size()) {
	        	Consultas consulta = new Consultas();
	        	
	        String sql = "SELECT * FROM productos WHERE id ="+id_productos.get(total)+" AND estado='activo'" ;
	        ResultSet rs;
	        boolean numero = false;
	   
	         	        try {
	         	        	
	         	            rs = conectar.consultar(sql);
	         	            if(rs.next()){
	         	                     numero = true;
	         	                     
	         	                     id.add((rs.getString("id")));
	         	                     name.add(rs.getString("nombre"));
	         	                     precio.add(rs.getString("precio"));
	         	                     descuento.add((rs.getString("descuento")));
	         	                     id_empresa.add(rs.getString("id_empresa"));
	         	                     imagen.add(consulta.TraerImagen(id_empresa.get(total), id.get(total)));
	         	                    total = total + 1;
	         	                   
	         	                     producto = 1;
	         	                 
	                     
	                 } 
	                	
	        } catch (Exception ex) {
	       System.out.println("Error en comparar clave(controlador productos): " + ex);
	        }
	       } 
	        conectar.cerrar();
	        
	        if(producto == 0) {
	        	I.lblTitulo.setText("PERFIL");
				JOptionPane.showMessageDialog(null, "NO HAY PRODUCTOS EN SU CARRITO");
				
			}else {
				PP.removeAll();
				PP.add(PP.btnDerecha);
				PP.add(PP.btnIzquierda);
				PP.btnDerecha.setVisible(true);
				PP.btnIzquierda.setVisible(false);
				Ayudas.ActualizarPanelFacil(PP, I.IndexPanel);
				
			for (productos = 0; productos  < 3; productos++) {
				
			
				   if(producto == 1 && productos < total) {
			        	
		        		PP.add(producto1);
		        		PP.repaint();
		        		PP.revalidate();
		        		producto1.setBounds(66, 77, 354, 377);
		        		 PonerProducto(producto1);
		        		producto = producto + 1;}
			        else if(producto == 2 && productos < total) {
			        	
		        		PP.add(producto2);
		        		PP.repaint();
		        		PP.revalidate();
		        		producto2.setBounds(502, 77, 354, 377);
		        		 PonerProducto(producto2);
		        		producto = producto + 1;}
			        else  if(producto == 3 && productos < total) {
			        	
		        		PP.add(producto3);
		        		PP.repaint();
		        		PP.revalidate();
		        		producto3.setBounds(949, 77, 354, 377);
		        		 PonerProducto(producto3);
		        		}
			        
	        
	       
			}
			if(total > 3) {
				todos = todos + 3;
				PP.add(PP.btnIzquierda);
			}else {
				PP.btnDerecha.setVisible(false);
			}
			}
		}
		
		if(e.getSource().equals(PU.btnListaDeDeseos)) {
			I.lblTitulo.setVisible(true);
			I.lblTitulo.setText("LISTA DE DESEOS");
			I.Quitar.setText("lista");
			total = 0;
			todos = 0;
			producto = 0;
			 id.clear();
		     name.clear();
		    precio.clear();;
		     descuento.clear();
		    id_empresa.clear(); 
		     imagen.clear(); 
		     id_productos.clear();
	        id_productos = consulta.Id_ProductosLDUsuario(u);
	        Conexion conectar = new Conexion();
	        while(total< id_productos.size()) {
	        	Consultas consulta = new Consultas();
	        	
	        String sql = "SELECT * FROM productos WHERE id ="+id_productos.get(total)+" AND estado='activo'" ;
	        ResultSet rs;
	        boolean numero = false;
	   
	         	        try {
	         	        	
	         	            rs = conectar.consultar(sql);
	         	            if(rs.next()){
	         	                     numero = true;
	         	                     
	         	                     id.add((rs.getString("id")));
	         	                     name.add(rs.getString("nombre"));
	         	                     precio.add(rs.getString("precio"));
	         	                     descuento.add((rs.getString("descuento")));
	         	                     id_empresa.add(rs.getString("id_empresa"));
	         	                     imagen.add(consulta.TraerImagen(id_empresa.get(total), id.get(total)));
	         	                    total = total + 1;
	         	                    
	         	                     producto = 1;
	         	                 
	                     
	                 } 
	        } catch (Exception ex) {
	       System.out.println("Error en comparar clave(controlador productos): " + ex);
	        }
	         	       
	    }
	        conectar.cerrar();
	        
	        
	        if(producto == 0) {
	        	I.lblTitulo.setText("PERFIL");
				JOptionPane.showMessageDialog(null, "NO HAY PRODUCTOS EN SU LISTA");
			}else {
				PP.removeAll();
				PP.add(PP.btnDerecha);
				PP.add(PP.btnIzquierda);
				PP.btnDerecha.setVisible(true);
				PP.btnIzquierda.setVisible(false);
				Ayudas.ActualizarPanelFacil(PP, I.IndexPanel);
				
			for (productos = 0; productos  < 3; productos++) {
				
			
				   if(producto == 1 && productos < total) {
			        	
		        		PP.add(producto1);
		        		PP.repaint();
		        		PP.revalidate();
		        		producto1.setBounds(66, 77, 354, 377);
		        		 PonerProducto(producto1);
		        		producto = producto + 1;}
			        else if(producto == 2 && productos < total) {
			        	
		        		PP.add(producto2);
		        		PP.repaint();
		        		PP.revalidate();
		        		producto2.setBounds(502, 77, 354, 377);
		        		 PonerProducto(producto2);
		        		producto = producto + 1;}
			        else  if(producto == 3 && productos < total) {
			        	
		        		PP.add(producto3);
		        		PP.repaint();
		        		PP.revalidate();
		        		producto3.setBounds(949, 77, 354, 377);
		        		 PonerProducto(producto3);
		        		}
			        
	        
	       
			}
			if(total > 3) {
				todos = todos + 3;
				PP.add(PP.btnIzquierda);
			}else {
				PP.btnDerecha.setVisible(false);
			}
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
		if(e.getSource().equals(PU.textNombre)) {
			AplicarValidacion.NombreEditarUsuario(PU.textNombre.getText(), PU);
		}
		if(e.getSource().equals(PU.textCedula)) {
			AplicarValidacion.CedulaEditarUsuario(PU.textCedula.getText(), PU);
		}
		if(e.getSource().equals(PU.textDirrecion)) {
			AplicarValidacion.DireccionEditarUsuario(PU.textDirrecion.getText(), PU);
		}
		if(e.getSource().equals(PU.textTelefono)) {
			AplicarValidacion.TelefonoEditarUsuario(PU.textTelefono.getText(), PU);
		}
		
	}
	private void CargarDatos() {
		u.setId(I.id_user.getText());
		Consultas consulta = new Consultas();
		consulta.CargarDatosAdmin(u);
		PU.lblUser.setText(u.getNombre());
		PU.textNombre.setText(u.getNombre());
		PU.textCorreo.setText(u.getCorreo());
		PU.textF_Nacimiento.setText(u.getF_Nacimiento());
		PU.textTelefono.setText(u.getTelefono());
		PU.textCedula.setText(u.getCedula());
		PU.textDirrecion.setText(u.getDireccion());
	}
	private void PonerProducto(Producto P) {
		P.lblAntes.setVisible(false);
		P.lblPesoAntes.setVisible(false);
		P.lblPrecioAntes.setVisible(false);
		P.Descuento.setVisible(false);
		P.Descuento.setText("0");
		P.lblPrecioAntes.setText("0");
		P.lblQuitar.setVisible(true);
		PP.add(PP.btnVaciarCarrito);
		PP.btnVaciarCarrito.setVisible(false); 
		PP.add(PP.btnComprar);
		PP.btnComprar.setVisible(false); 
		 P.lblNombre.setText(name.get(productos));
			ImageIcon image = new ImageIcon("images//"+imagen.get(productos)+"");
			Icon icon = new ImageIcon(image.getImage().getScaledInstance(P.lblImagen.getWidth(), P.lblImagen.getHeight(), Image.SCALE_DEFAULT));
			P.lblImagen.setIcon(icon);
			P.Id_Producto.setText(id.get(productos));
			P.Id_empresa.setText(id_empresa.get(productos));
			P.lblLocal.setText(consulta.NombreEmpresa(id_empresa.get(productos)));
			P.lblAñadirALD.setVisible(false);
			if(I.Quitar.getText().equals("carrito")) {
			Consultas consulta = new Consultas();
			consulta.CargarCantidad(P, I.id_user.getText(), P.Id_Producto.getText());
			PP.btnVaciarCarrito.setVisible(true); 
			PP.btnComprar.setVisible(true); 
			P.BoxCantidades.setVisible(true);}
			if(descuento.get(productos).equals("0") || descuento.get(productos).equals("00")) {
				P.lblPrecioAhora.setText(precio.get(productos));
			}else {
				P.Precio.setText("AHORA:");
				P.Descuento.setText(descuento.get(productos)+"%");
				P.lblPrecioAntes.setText(precio.get(productos));
				int descuentico = ( Integer.parseInt(descuento.get(productos)) * Integer.parseInt(precio.get(productos)));
				int preciodescuento = descuentico/100;
				int preciototal = Integer.parseInt(precio.get(productos)) - preciodescuento;
				P.lblPrecioAhora.setText(String.valueOf(preciototal));
				P.lblAntes.setVisible(true);
				P.lblPesoAntes.setVisible(true);
				P.lblPrecioAntes.setVisible(true);
				P.Descuento.setVisible(true);
				
			}
			
			
			
		
	}
}
