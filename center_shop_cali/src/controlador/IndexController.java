package controlador;
import java.awt.Event;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.UnsupportedEncodingException;
import java.nio.channels.IllegalBlockingModeException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.sound.midi.SysexMessage;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import herramientas.Ayudas;
import modelo.Usuario;
import sql.Consultas;
import vista.*;
import sql.*;
public class IndexController implements ActionListener, MouseListener, KeyListener{
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
	PaginaProductos PP = new PaginaProductos();
	PanelPrincipal PanelP = new PanelPrincipal();
	Producto producto1 = new Producto();
	Producto producto2 = new Producto();
	Producto producto3 = new Producto(); 
	public IndexController (Index I) {
		this.I = I;
		this.I.btnIniciarSesion.addActionListener(this);
		this.I.textBuscador.addMouseListener(this);
		this.I.textBuscador.addKeyListener(this);
		this.I.categorias.addMouseListener(this);
		this.I.logo.addMouseListener(this);
		this.I.categorias.addActionListener(this);
		this.PP.btnDerecha.addActionListener(this);
		this.PP.btnIzquierda.addActionListener(this);
		this.I.lblIconoPerfil.addMouseListener(this);
		PaginaProductoUnoController PPU = new PaginaProductoUnoController(producto1, I);
		PaginaProductoDosController PPD = new PaginaProductoDosController(producto2, I);
		PaginaProductoTresController PPT = new PaginaProductoTresController(producto3, I);
		Ayudas.ActualizarPanelFacil(PanelP, I.IndexPanel);
		Iniciar();
		Empresas();
		Sesion();
		Slider();
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
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
		
		
		
	if(e.getSource().equals(I.btnIniciarSesion)) {
		
		slider = 2;
		IniciarSesion iniciar = new IniciarSesion();
		I.dispose();
		iniciar.setVisible(true);
		new IniciarSesionController(iniciar);
	}
	if(e.getSource().equals(I.categorias)) {
		total = 0;
		todos = 0;
		producto = 0;
		 id.clear();
	     name.clear();
	    precio.clear();;
	     descuento.clear();
	    id_empresa.clear(); 
	     imagen.clear(); 
		Consultas consulta = new Consultas();
        Conexion conectar = new Conexion();
        Random dato = new Random();
        int num = (dato.nextInt(1000000000));
        String categoria = String.valueOf(I.categorias.getSelectedItem());
        categoria = consulta.TraerIdCategorias(categoria);
        String sql = "SELECT * FROM productos WHERE categoria = "+categoria+" AND estado='activo' ORDER BY RAND() LIMIT "+num+" " ;
        ResultSet rs;
        boolean numero = false;
   
         	        try {
         	        	
         	            rs = conectar.consultar(sql);
         	            while(rs.next()){
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
        conectar.cerrar();
        
        if(producto == 0) {
			JOptionPane.showMessageDialog(null, "NO HAY PRODUCTOS CON ESE NOMBRE");
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
	public void mouseClicked(MouseEvent e) {
	
		if(e.getSource().equals(I.logo)) {
			
			Ayudas.ActualizarPanelFacil(PanelP, I.IndexPanel);
			I.textBuscador.setVisible(true);
			I.categorias.setVisible(true);
			I.lblTitulo.setVisible(false);
			I.textBuscador.setText("BUSCAR PRODUCTOS");
			
		}
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		
		if(e.getSource().equals(I.lblIconoPerfil)) {
			I.textBuscador.setVisible(false);
			I.categorias.setVisible(false);
			I.lblTitulo.setVisible(true);
			I.lblTitulo.setText("PERFIL");
			PerfilUsuario PU = new PerfilUsuario();
			Ayudas.ActualizarPanelFacil(PU, I.IndexPanel);
			new PerfilUsuarioController(PU, I);
		}
		if(e.getSource().equals(I.textBuscador)) {
			
			I.textBuscador.setText("");
		}
		
		
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		
		if(e.getSource().equals(I.categorias)) {
			if(categoria == true) {
				categorias();
				categoria = false;
				}
			else {
			}
			
		}
			
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
	}
	private void Iniciar() {
		
		I.setVisible(true);
		
	}
	private void Sesion() {
		
		if(!I.id_user.getText().equals("")) {
			I.btnIniciarSesion.setVisible(false);
			I.lblIconoPerfil.setVisible(true);
			
		}else {
			I.btnIniciarSesion.setVisible(true);
			I.lblIconoPerfil.setVisible(false);
			
		}
	}
	private void Slider() {
		Consultas consulta = new Consultas();
	        Conexion conectar = new Conexion();
	        Random dato = new Random();
	        int num = (dato.nextInt(4));
	        String sql = "SELECT * FROM slider WHERE estado = 'activo' ORDER BY RAND()";
	        ResultSet rs;
	        boolean numero = false;
	        List <String> Nombre  = new ArrayList<>();
	        List <String> Info  = new ArrayList<>();
	        List <String> Imagen = new ArrayList<>();
	        try {
	        	
	            rs = conectar.consultar(sql);
	            while(rs.next()){
	                     numero = true;
	             
	                     Nombre.add((rs.getString("nombre")));
	                     Info.add(rs.getString("info"));
	                     Imagen.add(rs.getString("imagen"));
	                   
	                 
	                   
	                     
	                 } 
	        } catch (Exception e) {
	       System.out.println("Error en comparar clave(controlador productos): " + e);
	        }
	        conectar.cerrar();
	     
		while(Nombre.size() > datos && slider == 1) {
				AplicarImagen(PanelP.lblImagen,"images//"+Imagen.get(datos)+"" );
				PanelP.lblNombre.setText(Nombre.get(datos));
				PanelP.lblInfo.setText(Info.get(datos));
				datos = datos + 1;
				delaySegundo();
				if(Nombre.size() == datos) {
					datos = 0;
				}
				}	
		AplicarImagen(PanelP.lblImagen,"images//"+Imagen.get(0)+"" );
		PanelP.lblNombre.setText(Nombre.get(0));
		PanelP.lblInfo.setText(Info.get(0));
		
	
				
			
		
	
	}
	private static void delaySegundo() {
		try {
			
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	private void AplicarImagen(JLabel NombreLabel, String root) {
	ImageIcon image = new ImageIcon(root);
	Icon icon = new ImageIcon(image.getImage().getScaledInstance(NombreLabel.getWidth(), NombreLabel.getHeight(), Image.SCALE_DEFAULT));
	NombreLabel.setIcon(icon);
	this.PanelP.lblImagen.repaint();
	}
	private void Empresas() {
		
		Consultas consulta = new Consultas();
		consulta.Empresa(u, PanelP, PP);
		
	}
	
	private void categorias() {
		Consultas consulta = new Consultas();
		consulta.categorias(I);
		
	}
	private void Organizar()
	{
		slider = 1;
		datos = 0;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
			Ayudas ayuda = new Ayudas();
			
			try {
				System.out.println(ayuda.Cifra(I.textBuscador.getText()));
			} catch (HeadlessException | InvalidKeyException | UnsupportedEncodingException | NoSuchAlgorithmException
					| NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(I.textBuscador.getText().isEmpty() || I.textBuscador.getText().equals(" ")) {
				JOptionPane.showMessageDialog(null, "ESCRIBE UN PRODUCTO A BUSCAR");
			}else{
			total = 0;
			todos = 0;
			producto = 0;
			 id.clear();
		     name.clear();
		    precio.clear();;
		     descuento.clear();
		    id_empresa.clear(); 
		     imagen.clear(); 
			PP.removeAll();
			Consultas consulta = new Consultas();
	        Conexion conectar = new Conexion();
	        Random dato = new Random();
	        int num = (dato.nextInt(1000000000));
	        String texto = I.textBuscador.getText();
	        String sql = "SELECT * FROM productos WHERE nombre= '"+texto+"'OR nombre REGEXP '"+ texto.toUpperCase()+"' AND estado='activo' ORDER BY RAND() LIMIT "+num+" " ;
	        ResultSet rs;
	     
	        boolean numero = false;
	   
	                    
	         	        try {
	         	        	
	         	            rs = conectar.consultar(sql);
	         	            while(rs.next()){
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
	        conectar.cerrar();
	        
	        if(producto == 0) {
				JOptionPane.showMessageDialog(null, "NO HAY PRODUCTOS CON ESE NOMBRE");
				
			}else {
				PP.add(PP.btnDerecha);
				PP.add(PP.btnIzquierda);
				PP.btnIzquierda.setVisible(false);
				PP.btnDerecha.setVisible(true);
				Ayudas.ActualizarPanelFacil(PP, I.IndexPanel);
			for (productos = 0; productos < 3; productos++) {
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
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}	

	private void PonerProducto(Producto P) {
		P.lblAntes.setVisible(false);
		P.lblPesoAntes.setVisible(false);
		P.lblPrecioAntes.setVisible(false);
		P.Descuento.setVisible(false);
		P.Descuento.setText("0");
		P.lblPrecioAntes.setText("0");
		 P.lblNombre.setText(name.get(productos));
			ImageIcon image = new ImageIcon("images//"+imagen.get(productos)+"");
			Icon icon = new ImageIcon(image.getImage().getScaledInstance(P.lblImagen.getWidth(), P.lblImagen.getHeight(), Image.SCALE_DEFAULT));
			P.lblImagen.setIcon(icon);
			P.Id_Producto.setText(id.get(productos));
			P.Id_empresa.setText(id_empresa.get(productos));
			P.lblLocal.setText(consulta.NombreEmpresa(id_empresa.get(productos)));
			if(!I.id_user.getText().equals("")) {
			if(consulta.ExistenciaListaDeDeseos(I.id_user.getText(), P.Id_Producto.getText())) {
				P.lblAñadirALD.setVisible(false);
			}else {
				P.lblAñadirALD.setVisible(true);
			}
			}
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
