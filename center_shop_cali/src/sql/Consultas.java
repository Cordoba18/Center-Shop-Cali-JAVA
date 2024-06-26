package sql;

import java.awt.Image;
import java.awt.Panel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import modelo.Usuario;
import vista.*;
public class Consultas {

	
	PreparedStatement PS;
	public boolean logueo(Usuario Loguear) {
        Conexion conectar = new Conexion();
        String sql = "SELECT * FROM users WHERE correo ='" + Loguear.getCorreo()+ "' AND contrasena='"+Loguear.getContrasena()+"' AND estado ='activo'";
        ResultSet rs;
        boolean numero = false;
        try {
        	
            rs = conectar.consultar(sql);
            if(rs.next()){
                     numero = true;
             
                     Loguear.setNombre(rs.getString("nombre"));
                     Loguear.setCorreo(rs.getString("correo"));
                     Loguear.setContrasena(rs.getString("contrasena"));
                     Loguear.setRol(String.valueOf(rs.getInt("Roles_id")));
                     Loguear.setId(String.valueOf(rs.getInt("id")));
                     Loguear.setImagen(rs.getString("logo"));
                     Loguear.setId_empresa(String.valueOf(rs.getInt("id")));
                     
                 } 
            else {
            }
        } catch (Exception e) {
       System.out.println("Error en comparar clave(controlador users): " + e);
        }
        conectar.cerrar();
        return numero;
    }
	public boolean ConfirmarExistenciaUsuario(Usuario Loguear) {
        Conexion conectar = new Conexion();
        String sql = "SELECT * FROM users WHERE correo = '" + Loguear.getCorreo()+ "'";
        ResultSet rs;
        boolean numero = false;
        try {
        	
            rs = conectar.consultar(sql);
            if(rs.next()){
                     numero = true;
              
                 } 
            else {
            }
        } catch (Exception e) {
       System.out.println("Error en comparar clave(controlador users): " + e);
        }
        conectar.cerrar();
        return numero;
    }
	
	public boolean CargarCantidad(Producto P, String id_user, String id_producto) {
        Conexion conectar = new Conexion();
        String sql = "SELECT * FROM carrito_compras WHERE id_user="+ id_user+ " AND id_producto="+id_producto+" AND estado='activo'";
        ResultSet rs;
        boolean numero = false;
        DefaultComboBoxModel model = new DefaultComboBoxModel();
    	P.BoxCantidades.setModel(model);
    	String[] dato = new String[1];
        try {
        	
            rs = conectar.consultar(sql);
            if(rs.next()){
            	P.BoxCantidades.removeAllItems();
                dato[0] = (rs.getString(2));
                  P.BoxCantidades.addItem(dato[0]);;
                   numero = true;
                 } 
            else {
            }
        } catch (Exception e) {
        }
        conectar.cerrar();
        return numero;
    }
	public boolean ConfirmarPagoUsuario(Usuario Loguear) {
		String pass = (Loguear.getContrasena());
        Conexion conectar = new Conexion();
        String sql = "SELECT * FROM users WHERE correo = '" + Loguear.getCorreo()+ "' AND estado ='inactivo'";
        ResultSet rs;
        boolean numero = false;
        try {
        	
            rs = conectar.consultar(sql);
            if(rs.next()){
                     numero = true;
                     
                 } 
            else {
            }
        } catch (Exception e) {
       System.out.println("Error en comparar clave(controlador users): " + e);
        }
        conectar.cerrar();
        return numero;
    }
	
	public boolean ConsultarCarrito(Usuario Loguear) {
        Conexion conectar = new Conexion();
        String sql = "SELECT * FROM carrito_compras WHERE id_user ='" + Loguear.getId()+ "' AND id_producto='"+Loguear.getId_producto()+"' AND estado ='activo'";
        ResultSet rs;
        boolean numero = false;
        try {
        	
            rs = conectar.consultar(sql);
            if(rs.next()){
                     numero = true;
             
                     Loguear.setTalla(rs.getString("talla"));
     
                 } 
            else {
            }
        } catch (Exception e) {
       System.out.println("Error en comparar clave(controlador users): " + e);
        }
        conectar.cerrar();
        return numero;
    }
	
	public boolean DatosUsuario(Usuario Loguear) {
        Conexion conectar = new Conexion();
        String sql = "SELECT * FROM users WHERE id ="+Loguear.getId() +" AND estado ='activo'";
        ResultSet rs;
        boolean numero = false;
        try {
        	
            rs = conectar.consultar(sql);
            if(rs.next()){
                     numero = true;
             
                     Loguear.setNombre(rs.getString("nombre"));
                     Loguear.setCorreo(rs.getString("correo"));
                     Loguear.setContrasena(rs.getString("contrasena"));
                     Loguear.setRol(String.valueOf(rs.getInt("Roles_id")));
                     Loguear.setId(String.valueOf(rs.getInt("id")));
               
                     
                 } 
            else {
            }
        } catch (Exception e) {
       System.out.println("Error en comparar clave(controlador user): " + e);
        }
        conectar.cerrar();
        return numero;
    }
	public List<String> Id_ProductosCUsuario(Usuario Loguear) {
        Conexion conectar = new Conexion();
        String sql = "SELECT * FROM carrito_compras WHERE id_user ="+Loguear.getId() +" AND estado ='activo'";
        ResultSet rs;
        List <String> id_productos = new ArrayList<>();
        try {
        	
            rs = conectar.consultar(sql);
            while(rs.next()){
                 
             
                     id_productos.add(rs.getString("id_producto"));
               
                     
                 } 
        
        } catch (Exception e) {
       System.out.println("Error en comparar clave(controlador user): " + e);
        }
        conectar.cerrar();
        return id_productos;
    }
	public List<String> Id_ProductosLDUsuario(Usuario Loguear) {
        Conexion conectar = new Conexion();
        String sql = "SELECT * FROM lista_deseos WHERE id_user ="+Loguear.getId() +" AND estado ='activo'";
        ResultSet rs;
        List <String> id_productos = new ArrayList<>();
        try {
        	
            rs = conectar.consultar(sql);
            while(rs.next()){
                 
             
                     id_productos.add(rs.getString("id_producto"));
               
                     
                 } 
        
        } catch (Exception e) {
       System.out.println("Error en comparar clave(controlador user): " + e);
        }
        conectar.cerrar();
        return id_productos;
    }
	public boolean ConsultarUsuario(Usuario Loguear) {
		String pass = (Loguear.getContrasena());
        Conexion conectar = new Conexion();
        String sql = "SELECT * FROM users WHERE correo = '" + Loguear.getCorreo()+ "' AND estado='activo'";
        ResultSet rs;
        boolean numero = false;
        try {
        	
            rs = conectar.consultar(sql);
            if(rs.next()){
                     numero = true;  
                 } 
            else {
            }
        } catch (Exception e) {
       System.out.println("Error en comparar clave(controlador user): " + e);
        }
        conectar.cerrar();
        return numero;
    }
	
	public boolean ExistenciaListaDeDeseos(String id_user, String id_producto) {
        Conexion conectar = new Conexion();
        String sql = "SELECT * FROM lista_deseos WHERE id_user="+id_user+" AND id_producto="+id_producto+" AND estado='activo'";
        ResultSet rs;
        boolean numero = false;
        try {
        	
            rs = conectar.consultar(sql);
            if(rs.next()){
                     numero = true;
                 } 
            else {
            }
        } catch (Exception e) {
       System.out.println("Error en comparar clave(controlador lista_deseos): " + e);
        }
        conectar.cerrar();
        return numero;
    }
	public boolean ExistenciaCarritoDeCompras(String id_user, String id_producto) {
        Conexion conectar = new Conexion();
        String sql = "SELECT * FROM carrito_compras WHERE id_user="+id_user+" AND id_producto="+id_producto+" AND estado='activo'";
        ResultSet rs;
        boolean numero = false;
        try {
        	
            rs = conectar.consultar(sql);
            if(rs.next()){
                     numero = true;
                 } 
            else {
            }
        } catch (Exception e) {
       System.out.println("Error en comparar clave(controlador carrito_compras): " + e);
        }
        conectar.cerrar();
        return numero;
    }
	public boolean DescripcionProducto(Usuario u) {
        Conexion conectar = new Conexion();
        String sql = "SELECT * FROM productos WHERE id = " +u.getId_producto()+ "";
        ResultSet rs;
        boolean numero = false;
        try {
        	
            rs = conectar.consultar(sql);
            if(rs.next()){
                     numero = true;
             
                   u.setDescripcion(rs.getString("descripcion"));
                     
                 } 
            else {
            }
        } catch (Exception e) {
       System.out.println("Error en comparar clave(controlador user): " + e);
        }
        conectar.cerrar();
        return numero;
    }
	
	public boolean ImagenYNombreEmpresa(Usuario u) {
        Conexion conectar = new Conexion();
        String sql = "SELECT * FROM users WHERE id =" +u.getId_empresa()+"";
        ResultSet rs;
        boolean numero = false;
        try {
        	
            rs = conectar.consultar(sql);
            if(rs.next()){
                     numero = true;
             
                   u.setNombre(rs.getString("nombre"));
                   u.setImagen(rs.getString("logo"));
                     
                 } 
            else {
            }
        } catch (Exception e) {
       System.out.println("Error en comparar clave(controlador user): " + e);
        }
        conectar.cerrar();
        return numero;
    }
	
	public boolean ImagenColor(Usuario u) {
        Conexion conectar = new Conexion();
        String sql = "SELECT * FROM colores WHERE color='" +u.getColor()+"' AND id_empresa="+u.getId_empresa()+" AND id_producto="+u.getId_producto()+ " AND estado='activo'";
        ResultSet rs;
        boolean numero = false;
        try {
        	
            rs = conectar.consultar(sql);
            if(rs.next()){
                     numero = true;
                   u.setImagen(rs.getString("imagen"));
                  
                 } 
            else {
            }
        } catch (Exception e) {
       System.out.println("Error en comparar clave(controlador colores): " + e);
        }
        conectar.cerrar();
        return numero;
    }
	
	public boolean CantidadTalla(Usuario u) {
        Conexion conectar = new Conexion();
        String sql = "SELECT * FROM tallas WHERE talla='" +u.getTalla()+"' AND id_empresa="+u.getId_empresa()+" AND id_producto="+u.getId_producto()+ " AND estado='activo'";
        ResultSet rs;
        boolean numero = false;
        try {
        	
            rs = conectar.consultar(sql);
            if(rs.next()){
                     numero = true;
                   u.setCantidad(rs.getString("cantidad"));
                  
                 } 
            else {
            }
        } catch (Exception e) {
       System.out.println("Error en comparar clave(controlador tallas): " + e);
        }
        conectar.cerrar();
        return numero;
    }
	
	public String NombreEmpresa(String id_empresa) {
        Conexion conectar = new Conexion();
        String sql = "SELECT * FROM users WHERE id= "+id_empresa+"";
        ResultSet rs;
        String nombre = "";
        try {
        	
            rs = conectar.consultar(sql);
            if(rs.next()){
                     
                    nombre = rs.getString("nombre");
                     
                 } 
            else {
            }
        } catch (Exception e) {
       System.out.println("Error en comparar clave(controlador user): " + e);
        }
        conectar.cerrar();
        return nombre;
    }
	
	public boolean CargarDatosAdmin(Usuario Loguear) {
        Conexion conectar = new Conexion();
        String sql = "SELECT * FROM users WHERE id="+Loguear.getId();
        ResultSet rs;
        boolean numero = false;
        try {
        	
            rs = conectar.consultar(sql);
            if(rs.next()){
                     numero = true;
             
                     Loguear.setNombre(rs.getString("nombre"));
                     Loguear.setCorreo(rs.getString("correo"));
                     Loguear.setF_Nacimiento(rs.getString("f_nacimiento"));
                     Loguear.setTelefono(rs.getString("telefono"));
                     Loguear.setCedula(rs.getString("cedula"));
                     Loguear.setDireccion(rs.getString("direccion"));
         
                     
                 } 
            else {
            }
        } catch (Exception e) {
       System.out.println("Error en comparar clave(controlador user): " + e);
        }
        conectar.cerrar();
        return numero;
    }
	
	
	public boolean ConsultarImagen(Usuario u) {
        Conexion conectar = new Conexion();
        String sql = "SELECT * FROM imagenes_productos WHERE id_empresa ="+ u.getId_empresa()+ " AND id_producto ="+u.getId_producto()+"  AND estado ='activo'";
        ResultSet rs;
        boolean numero = false;
        try {
        	
            rs = conectar.consultar(sql);
            if(rs.next()){
                     numero = true;
             
                     u.setId(String.valueOf(rs.getInt("id")));
                     
                 } 
            else {
            }
        } catch (Exception e) {
       System.out.println("Error en comparar clave(controlador imagenes_productos): " + e);
        }
        conectar.cerrar();
        return numero;
    }
	
	
	public boolean VerId_Producto(Usuario u) {
        Conexion conectar = new Conexion();
        String sql = "SELECT * FROM productos WHERE id_empresa = " +u.getId_empresa();
        ResultSet rs;
        boolean numero = false;
        try {
        	
            rs = conectar.consultar(sql);
            while(rs.next()){
                     numero = true;
             
                     u.setId_producto(String.valueOf(rs.getInt("id")));
                     
                 } 
      
        } catch (Exception e) {
       System.out.println("Error en comparar clave(controlador imagenes_productos): " + e);
        }
        conectar.cerrar();
        return numero;
    }
	
	
	public boolean id_categoria(Usuario u) {
        Conexion conectar = new Conexion();
        String sql = "SELECT * FROM categorias WHERE categoria = '" + u.getCategoria()+"'";
        ResultSet rs;
        boolean numero = false;
        try {
        	
            rs = conectar.consultar(sql);
            if(rs.next()){
                     numero = true;
             
                     u.setCategoria(String.valueOf( rs.getInt("id")));
                 
                     
                 } 
            else {
            }
        } catch (Exception e) {
       System.out.println("Error en comparar clave(controlador user): " + e);
        }
        conectar.cerrar();
        return numero;
    }
	
	public String TraerIdCategorias(String categoria) {
        Conexion conectar = new Conexion();
        String sql = "SELECT * FROM categorias WHERE categoria = '" + categoria+"'";
        ResultSet rs;
        boolean numero = false;
        String id_categoria = "";
        try {
        	
            rs = conectar.consultar(sql);
            if(rs.next()){
                     numero = true;
             
                     id_categoria = (String.valueOf( rs.getInt("id")));
                 
                     
                 } 
            else {
            }
        } catch (Exception e) {
       System.out.println("Error en comparar clave(controlador user): " + e);
        }
        conectar.cerrar();
        return id_categoria;
    }
	
	public boolean Slider(Usuario u) {
        Conexion conectar = new Conexion();
        String sql = "SELECT * FROM slider WHERE estado = 'activo'";
        ResultSet rs;
        boolean numero = false;
        List <String> Nombre = new ArrayList<>();
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
       System.out.println("Error en comparar clave(controlador slider): " + e);
        }
        conectar.cerrar();
        return numero;
    }
	
	
	public boolean ConsultarEmpresa(Usuario Loguear) {
		String pass = (Loguear.getContrasena());
        Conexion conectar = new Conexion();
        String sql = "SELECT * FROM users WHERE correo = '" + Loguear.getCorreo() + "'";
        ResultSet rs;
        boolean numero = false;
        try {
        	
            rs = conectar.consultar(sql);
            if(rs.next()){
                     numero = true;
             
                 } 
            else {
            }
        } catch (Exception e) {
       System.out.println("Error en comparar clave(controlador user): " + e);
        }
        conectar.cerrar();
        return numero;
    }
	public boolean ConsultarLogoEmpresa(Usuario Loguear) {
		String pass = (Loguear.getContrasena());
        Conexion conectar = new Conexion();
        String sql = "SELECT * FROM users WHERE id =" +Loguear.getId();
        ResultSet rs;
        boolean numero = false;
        try {
            rs = conectar.consultar(sql);
            if(rs.next()){
                     numero = true;
                     Loguear.setImagen(rs.getString("logo"));
           
                     
                 } 
            else {
            }
        } catch (Exception e) {
       System.out.println("Error en comparar clave(controlador user): " + e);
        }
        conectar.cerrar();
        return numero;
    }
	
	public boolean ConsultarLogoProducto(Usuario u) {
        Conexion conectar = new Conexion();
        String sql = "SELECT * FROM imagenes_productos WHERE id_producto ="+u.getId_producto()+" AND estado ='activo'";
        ResultSet rs;
        boolean numero = false;
        try {
            rs = conectar.consultar(sql);
            if(rs.next()){
                     numero = true;
                     u.setImagen(rs.getString("imagen"));
                 } 
            else {
            }
        } catch (Exception e) {
       System.out.println("Error en comparar clave(controlador productos): " + e);
        }
        conectar.cerrar();
        return numero;
    }
	
	
	public boolean ValidarContraseña(Usuario Loguear) {
		String pass = (Loguear.getContrasena());
        Conexion conectar = new Conexion();
        String sql = "SELECT * FROM users WHERE contrasena = '" + pass + "' AND id = "+Loguear.getId()+"";
        ResultSet rs;
        boolean numero = false;
        try {
        	
            rs = conectar.consultar(sql);
            if(rs.next()){
                     numero = true;
             
                     Loguear.setNombre(rs.getString("nombre"));
                     Loguear.setCorreo(rs.getString("correo"));
                     Loguear.setContrasena(rs.getString("contrasena"));
                     Loguear.setRol(String.valueOf(rs.getInt("Roles_id")));
                     Loguear.setId(String.valueOf(rs.getInt("id")));
                     
                 } 
            else {
            }
        } catch (Exception e) {
       System.out.println("Error en comparar clave(controlador user): " + e);
        }
        conectar.cerrar();
        return numero;
    }
	
	public String TraerImagen (String id_empresa, String id_producto) {
		
		Consultas consulta = new Consultas();
        Conexion conectar = new Conexion();
        String sql = "SELECT * FROM imagenes_productos WHERE id_empresa ="+id_empresa+" AND id_producto="+id_producto+"" ;
        ResultSet rs;
        boolean numero = false;
   
        String imagen = "";
         	        try {
         	        	
         	            rs = conectar.consultar(sql);
         	            if(rs.next()){
         	                     numero = true;
         	                     imagen = ((rs.getString("imagen")));
         	                   
         	                 
                     
                 } 
        } catch (Exception ex) {
       System.out.println("Error en comparar clave(controlador slider): " + ex);
        }
        conectar.cerrar();
		return imagen;
	}
	
	public boolean Empresa(Usuario u, PanelPrincipal PanelP, PaginaProductos PP) {
        Conexion conectar = new Conexion();
        Random dato = new Random();
        int num = (dato.nextInt(1000000000));
        String sql = "SELECT * FROM users WHERE Roles_id = 2 AND estado='activo' ORDER BY RAND() LIMIT "+num+"";
        ResultSet rs;
        boolean numero = false;
        int total = 1;
        try {
        	
            rs = conectar.consultar(sql);
            while(rs.next()){
            	if(total == 1) {
            		Empresa em = new Empresa();
            		PanelP.PanelPrincipal.add(em);
            		PanelP.PanelPrincipal.repaint();
            		PanelP.PanelPrincipal.revalidate();
            		em.setBounds(87, 330, 172, 155);
            		em.lblNombre.setText(rs.getString("nombre"));
            		em.id_empresa.setText(rs.getString("id"));
            		AplicarImagen(em.lblImagen,"images//"+rs.getString("logo")+"", em);
            		
            
            		
            	}else if(total == 2) {
            		Empresa em = new Empresa();
            		PanelP.PanelPrincipal.add(em);
            		PanelP.PanelPrincipal.repaint();
            		PanelP.PanelPrincipal.revalidate();
            		em.setBounds(284, 330, 172, 155);
            		em.lblNombre.setText(rs.getString("nombre"));
            		em.id_empresa.setText(rs.getString("id"));
            		AplicarImagen(em.lblImagen,"images//"+rs.getString("logo")+"", em);
            		
            		
            	}else if(total == 3) {
            		Empresa em = new Empresa();
            		PanelP.PanelPrincipal.add(em);
            		PanelP.PanelPrincipal.repaint();
            		PanelP.PanelPrincipal.revalidate();
            		em.setBounds(484, 330, 172, 155);
            		em.lblNombre.setText(rs.getString("nombre"));
            		em.id_empresa.setText(rs.getString("id"));
            		AplicarImagen(em.lblImagen,"images//"+rs.getString("logo")+"", em);
            		
            	
            		
            	}else if(total == 4) {
            		Empresa em = new Empresa();
            		PanelP.PanelPrincipal.add(em);
            		PanelP.PanelPrincipal.repaint();
            		PanelP.PanelPrincipal.revalidate();
            		em.setBounds(681, 333, 172, 155);
            		em.lblNombre.setText(rs.getString("nombre"));
            		em.id_empresa.setText(rs.getString("id"));
            		AplicarImagen(em.lblImagen,"images//"+rs.getString("logo")+"", em);
            		
            		
            		
            	}else if(total == 5) {
            		Empresa em = new Empresa();
            		PanelP.PanelPrincipal.add(em);
            		PanelP.PanelPrincipal.repaint();
            		PanelP.PanelPrincipal.revalidate();
            		em.setBounds(884, 333, 172, 155);
            		em.lblNombre.setText(rs.getString("nombre"));
            		em.id_empresa.setText(rs.getString("id"));
            		AplicarImagen(em.lblImagen,"images//"+rs.getString("logo")+"", em);
            	
            		
            		
            	}else if(total == 6) {
            		Empresa em = new Empresa();
            		PanelP.PanelPrincipal.add(em);
            		PanelP.PanelPrincipal.repaint();
            		PanelP.PanelPrincipal.revalidate();
            		em.setBounds(1094, 330, 172, 155);
            		em.lblNombre.setText(rs.getString("nombre"));
            		em.id_empresa.setText(rs.getString("id"));
            		AplicarImagen(em.lblImagen,"images//"+rs.getString("logo")+"", em);
            		
            		
            		
            	}
            	total = total + 1;
            	numero = true;
            	
            	} 
            
        } catch (Exception e) {
       System.out.println("Error en comparar clave(controlador user): " + e);
        }
        conectar.cerrar();
        return numero;
    }
	private void AplicarImagen(JLabel NombreLabel, String root, Empresa em) {
	ImageIcon image = new ImageIcon(root);
	Icon icon = new ImageIcon(image.getImage().getScaledInstance(NombreLabel.getWidth(), NombreLabel.getHeight(), Image.SCALE_DEFAULT));
	NombreLabel.setIcon(icon);
	em.lblImagen.repaint();
	}
	
	public boolean EmpresasTotales(Usuario Loguear) {
        Conexion conectar = new Conexion();
        String sql = "SELECT * FROM users WHERE Roles_id = 2 AND estado = 'activo'";
        ResultSet rs;
        boolean numero = false;
        int total = 0;
        try {
            rs = conectar.consultar(sql);
            while(rs.next()){
            	total = total + 1;
            	numero = true;
            	Loguear.setE_empresa(total);
            	} 
        } catch (Exception e) {
       System.out.println("Error en comparar clave(controlador user): " + e);
        }
        conectar.cerrar();
        return numero;
    }
	
	public boolean ClaveImagenUser(Usuario Loguear) {
        Conexion conectar = new Conexion();
        String sql = "SELECT * FROM users";
        ResultSet rs;
        boolean numero = false;
        try {
            rs = conectar.consultar(sql);
            while(rs.next()){
            	numero = true;
            	Loguear.setId(rs.getString("id"));
            	} 
        } catch (Exception e) {
       System.out.println("Error en comparar clave(controlador users): " + e);
        }
        conectar.cerrar();
        return numero;
    }
	public boolean ClaveImagenImagenes_Productos(Usuario Loguear) {
        Conexion conectar = new Conexion();
        String sql = "SELECT * FROM imagenes_productos";
        ResultSet rs;
        boolean numero = false;
        try {
            rs = conectar.consultar(sql);
            while(rs.next()){
            	numero = true;
            	Loguear.setId(rs.getString("id"));
            	} 
        } catch (Exception e) {
       System.out.println("Error en comparar clave(controlador imagenes_productos): " + e);
        }
        conectar.cerrar();
        return numero;
    }
	
	public boolean ClaveImagenColores(Usuario Loguear) {
        Conexion conectar = new Conexion();
        String sql = "SELECT * FROM colores";
        ResultSet rs;
        boolean numero = false;
        try {
            rs = conectar.consultar(sql);
            while(rs.next()){
            	numero = true;
            	Loguear.setId(rs.getString("id"));
            	} 
        } catch (Exception e) {
       System.out.println("Error en comparar clave(controlador colores): " + e);
        }
        conectar.cerrar();
        return numero;
    }
	
	public boolean ClaveImagenProducto(Usuario Loguear) {
        Conexion conectar = new Conexion();
        String sql = "SELECT * FROM productos";
        ResultSet rs;
        boolean numero = false;
        try {
            rs = conectar.consultar(sql);
            while(rs.next()){
            	numero = true;
            	Loguear.setId(rs.getString("id"));
            	} 
        } catch (Exception e) {
       System.out.println("Error en comparar clave(controlador productos): " + e);
        }
        conectar.cerrar();
        return numero;
    }
	
	public boolean ProductosTotales(Usuario u) {
        Conexion conectar = new Conexion();
        String sql = "SELECT * FROM productos where id_empresa = "+u.getId_empresa() +" AND estado='activo'";
        ResultSet rs;
        boolean numero = false;
        int total = 0;
        try {
            rs = conectar.consultar(sql);
            while(rs.next()){
            	total = total + 1;
            	numero = true;
            	u.setProductos(total);
            	} 
        } catch (Exception e) {
       System.out.println("Error en comparar clave(controlador user): " + e);
        }
        conectar.cerrar();
        return numero;
    }
	
	
	
//	
//	
	public boolean InsertarEmpresa(Usuario U) {
		
        Conexion conectar = new Conexion();
        String sql = "INSERT INTO `users`(`nombre`, `correo`, `contrasena`, `telefono`, `n_propietario`, `cedula`, `direccion`, `logo`, `Roles_id`, `estado`) "
        		+ "VALUES "
        		+ "('"+U.getNombre()+"',"
        		+ "'"+U.getCorreo()+"',"
        		+ "'"+U.getContrasena2()+"',"
        		+ "'"+U.getTelefono()+"',"
        		+ "'"+U.getNombreP()+"',"
        		+ "'"+U.getCedula()+"',"
        		+ "'"+U.getD1()+" # "+U.getD2()+" / "+U.getD3()+"',"
        		+ "'"+U.getImagen()+"',"
        		+ "'2',"
        		+ "'activo')";
        boolean numero = false;
        try {
            
            if(conectar.ejecutar(sql)){
                numero = true;
            }
        } catch (Exception e) {
            System.out.println("Error al insertar(controlador reservabebida): " + e);
            numero = true;
        }
        conectar.cerrar();
        return numero;
		
	}
	
public boolean InsertarColor(Usuario U) {
		
        Conexion conectar = new Conexion();
        String sql = "INSERT INTO `colores`(`color`, `id_producto`, `id_empresa`, `imagen`, `estado`) "
        		+ "VALUES "
        		+ "('"+U.getColor()+"',"
        		+ ""+U.getId_producto()+","
        		+ ""+U.getId_empresa()+","
        		+ "'"+U.getImagen()+"',"
        		+ "'activo')";
        boolean numero = false;
        try {
            
            if(conectar.ejecutar(sql)){
                numero = true;
            }
        } catch (Exception e) {
            System.out.println("Error al insertar(controlador colores): " + e);
            numero = true;
        }
        conectar.cerrar();
        return numero;
		
	}

public boolean InsertarTalla(Usuario U) {
	
    Conexion conectar = new Conexion();
    String sql = "INSERT INTO `tallas`(`cantidad`, `talla` , `id_producto`, `id_empresa`, `estado`) "
    		+ "VALUES "
    		+ "('"+U.getCantidad()+"',"
    		+ "'"+U.getTalla()+"',"
    		+ ""+U.getId_producto()+","
    		+ ""+U.getId_empresa()+","
    		+ "'activo')";
    boolean numero = false;
    try {
        
        if(conectar.ejecutar(sql)){
            numero = true;
        }
    } catch (Exception e) {
        System.out.println("Error al insertar(controlador colores): " + e);
        numero = true;
    }
    conectar.cerrar();
    return numero;
	
}

public int EditarTalla(Usuario u) {
	
    Conexion conectar = new Conexion();
    String sql = "UPDATE `tallas` SET `talla`='"+u.getTalla()+"', `cantidad`='"+u.getCantidad()+"'  WHERE id= "+u.getId_talla()+"";
    int rs = 0;
    try {
        PS = conectar.getConnection().prepareStatement(sql);
        rs = PS.executeUpdate();
        
    } catch (Exception e) {
   System.out.println("Error en comparar clave(controlador productos): " + e);
    }finally {
    	PS = null;
    	conectar.cerrar();
	}
    
    return rs;
}
	
	
	
	public boolean InsertarProducto(Usuario U) {
		
        Conexion conectar = new Conexion();
        String sql = "INSERT INTO `productos`(`nombre`, `precio`, `descuento`, `descripcion`, `categoria`, `id_empresa`,`estado`) "
        		+ "VALUES "
        		+ "('"+U.getNombre()+"',"
        		+ "'"+U.getPrecio()+"',"
        		+ "'"+U.getDescuento()+"',"
        		+ "'"+U.getDescripcion()+"',"
        		+ "'"+U.getCategoria()+"',"
        		+ "'"+U.getId_empresa()+"',"
        		+ "'activo')";
        
        boolean numero = false;
        try {
            
            if(conectar.ejecutar(sql)){
                numero = true;
            }
        } catch (Exception e) {
            System.out.println("Error al insertar(controlador productos): " + e);
            numero = true;
        }
        conectar.cerrar();
        return numero;
		
	}
	
public boolean AñadirAListaDeDeseos(Usuario U) {
		
        Conexion conectar = new Conexion();
        String sql = "INSERT INTO `lista_deseos`(`id_user`,`id_producto`,`estado`) "
        		+ "VALUES "
        		+ "("+U.getId()+","
        		+ ""+U.getId_producto()+","
        		+ "'activo')";
        
        boolean numero = false;
        try {
            
            if(conectar.ejecutar(sql)){
                numero = true;
            }
        } catch (Exception e) {
            System.out.println("Error al insertar(controlador productos): " + e);
            numero = true;
        }
        conectar.cerrar();
        return numero;
		
	}

public boolean AñadirCarritoCompras(Usuario U) {
	
    Conexion conectar = new Conexion();
    String sql = "INSERT INTO `carrito_compras`(`cantidad_producto`,`total`,`id_user`,`id_producto`,`color`,`talla`,`estado`) "
    		+ "VALUES "
    		+ "(1,"
    		+ ""+U.getPrecio()+","
    		+ ""+U.getId()+","
    		+ ""+U.getId_producto()+","
    		+ "'"+U.getColor()+"',"
    		+ "'"+U.getTalla()+"',"
    		+ "'activo')";
    
    boolean numero = false;
    try {
        
        if(conectar.ejecutar(sql)){
            numero = true;
        }
    } catch (Exception e) {
        System.out.println("Error al insertar(controlador productos): " + e);
        numero = true;
    }
    conectar.cerrar();
    return numero;
	
}

public boolean InsertarUsuario(Usuario U) {
		
        Conexion conectar = new Conexion();
        String sql = "INSERT INTO `users`(`nombre`, `correo`, `contrasena`,`telefono`, `f_nacimiento`,`estado`,`Roles_id`) "
        		+ "VALUES "
        		+ "('"+U.getNombre()+"',"
        		+ "'"+U.getCorreo()+"',"
        		+ "'"+U.getContrasena()+"',"
        		+ "'"+U.getTelefono()+"',"
        		+ "'"+U.getDia()+"/"+U.getMes()+"/"+U.getAño()+"',"
        		+ "'activo',"
        		+ "1)";
        
        boolean numero = false;
        try {
            
            if(conectar.ejecutar(sql)){
                numero = true;
            }
        } catch (Exception e) {
            System.out.println("Error al insertar(controlador productos): " + e);
            numero = true;
        }
        conectar.cerrar();
        return numero;
		
	}
	
public boolean InsertarImagenProducto(Usuario U) {
		
        Conexion conectar = new Conexion();
        String sql = "INSERT INTO `imagenes_productos`(`imagen`, `id_empresa`, `id_producto`,  `estado`) "
        		+ "VALUES "
        		+ "('"+U.getImagen()+"',"
        		+ ""+U.getId_empresa()+","
        		+ ""+U.getId_producto()+","
        		+"'activo')";
        
        boolean numero = false;
        try {
            
            if(conectar.ejecutar(sql)){
                numero = true;
            }
        } catch (Exception e) {
            System.out.println("Error al insertar(controlador productos): " + e);
            numero = true;
        }
        conectar.cerrar();
        return numero;
		
	}
	
	
	public boolean Empresas(JTable tabla) {
		
        Conexion conectar = new Conexion();
    	String sql = "SELECT * FROM users WHERE Roles_id = ' 2' AND estado = 'activo'" ;
    	 ResultSet rs;
		DefaultTableModel model = new DefaultTableModel();
	
		model.addColumn("ID");
		model.addColumn("NOMBRE");
		model.addColumn("CORREO");
		model.addColumn("TELEFONO");
		model.addColumn("NOMBRE PROPIETARIO");
		model.addColumn("CEDULA");
		model.addColumn("DIRECCIÓN");
		model.addColumn("LOGO");
		
		tabla.setModel(model);
		
		String[] dato = new String[9];
		
       
        boolean numero = false;
        try {
            rs = conectar.consultar(sql);
            while (rs.next()){
               
            	dato[0] = rs.getString(1);
            	dato[1] = rs.getString(2);
            	dato[2] = rs.getString(3);
            	dato[3] = rs.getString(6);
            	dato[4] = rs.getString(7);
            	dato[5] = rs.getString(8);
            	dato[6] = rs.getString(9);
            	dato[7] = rs.getString(10);
            	dato[8] = rs.getString(11);
            	model.addRow(dato);
                numero = true;
            }
        } catch (Exception e) {
       System.out.println("Error en comparar clave(controlador users): " + e);
        }
        conectar.cerrar();
        return numero;
    }
	
public boolean CargarImagenes(ModificarImagenes MI, Usuario u) {
		
        Conexion conectar = new Conexion();
    	String sql = "SELECT * FROM imagenes_productos WHERE id_empresa = '"+u.getId_empresa()+"' AND id_producto= '"+u.getId_producto()+"' AND estado = 'activo'" ;
    	 ResultSet rs;
		DefaultTableModel model = new DefaultTableModel();
	
		model.addColumn("ID");
		model.addColumn("IMAGEN");
		model.addColumn("ID_EMPRESA");
		model.addColumn("ID_PRODUCTO");
		
		MI.TablaImagenes.setModel(model);
		
		String[] dato = new String[4];
		
       
        boolean numero = false;
        int total = 0;
        try {
            rs = conectar.consultar(sql);
            while (rs.next()){
               if(total == 0) {
            	   total = 1;
            	   MI.lblLimiteImagenes.setText(String.valueOf(total));
               }else {
            	dato[0] = rs.getString(1);
            	dato[1] = rs.getString(2);
            	dato[2] = rs.getString(3);
            	dato[3] = rs.getString(4);
            	model.addRow(dato);
                numero = true;
                total = total + 1;
                MI.lblLimiteImagenes.setText(String.valueOf(total));
               }
            }
        } catch (Exception e) {
       System.out.println("Error en comparar clave(controlador users): " + e);
        }
        conectar.cerrar();
        return numero;
    }


public boolean CargarTallas(TallasYColores TC, Usuario u) {
	
    Conexion conectar = new Conexion();
	String sql = "SELECT * FROM tallas WHERE id_empresa = '"+u.getId_empresa()+"' AND id_producto= '"+u.getId_producto()+"' AND estado = 'activo'" ;
	 ResultSet rs;
	DefaultTableModel model = new DefaultTableModel();

	model.addColumn("ID");
	model.addColumn("CANTIDAD");
	model.addColumn("TALLA");
	model.addColumn("ID_PRODUCTO");
	model.addColumn("ID_EMPRESA");
	
	TC.TablaTallas.setModel(model);
	
	String[] dato = new String[5];
	
   
    boolean numero = false;
    int total = 0;
    try {
        rs = conectar.consultar(sql);
        while (rs.next()){
          
        	dato[0] = rs.getString(1);
        	dato[1] = rs.getString(2);
        	dato[2] = rs.getString(3);
        	dato[3] = rs.getString(4);
        	dato[4] = rs.getString(5);
        	model.addRow(dato);
            numero = true;
            total = total + 1;
        }
    } catch (Exception e) {
   System.out.println("Error en comparar clave(controlador users): " + e);
    }
    conectar.cerrar();
    return numero;
}

public boolean CargarColores(TallasYColores TC, Usuario u) {
	
    Conexion conectar = new Conexion();
	String sql = "SELECT * FROM colores WHERE id_empresa = '"+u.getId_empresa()+"' AND id_producto= '"+u.getId_producto()+"' AND estado = 'activo'" ;
	 ResultSet rs;
	DefaultTableModel model = new DefaultTableModel();

	model.addColumn("ID");
	model.addColumn("COLOR");
	model.addColumn("ID_PRODUCTO");
	model.addColumn("ID_EMPRESA");
	model.addColumn("IMAGEN");
	
	TC.TablaColores.setModel(model);
	
	String[] dato = new String[5];
	
   
    boolean numero = false;
    int total = 0;
    try {
        rs = conectar.consultar(sql);
        while (rs.next()){
          
        	dato[0] = rs.getString(1);
        	dato[1] = rs.getString(2);
        	dato[2] = rs.getString(3);
        	dato[3] = rs.getString(4);
        	dato[4] = rs.getString(5);
        	model.addRow(dato);
            numero = true;
            total = total + 1;
        }
    } catch (Exception e) {
   System.out.println("Error en comparar clave(controlador users): " + e);
    }
    conectar.cerrar();
    return numero;
}



	
public boolean categorias(Index I) {
		
        Conexion conectar = new Conexion();
    	String sql = "SELECT * FROM categorias" ;
    	 ResultSet rs;
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		I.categorias.setModel(model);
    	String[] dato = new String[1];
        boolean numero = false;
        try {
            rs = conectar.consultar(sql);
            I.categorias.removeAllItems();
            
            //categorias.setModel(new DefaultComboBoxModel(new String[] {"CATEGORIAS"}));
            while (rs.next()){
       
              dato[0] = (rs.getString(2));
              I.categorias.addItem(dato[0]);;
                numero = true;
            }
        } catch (Exception e) {
       System.out.println("Error en comparar clave(controlador categorias): " + e);
        }
        conectar.cerrar();
        return numero;
    }

public boolean ColoresProducto(PaginaDelProducto PDP, String id_producto, String id_empresa) {
	
    Conexion conectar = new Conexion();
	String sql = "SELECT * FROM colores WHERE id_producto="+ id_producto+ " AND id_empresa= "+id_empresa+" AND estado='activo'";
	 ResultSet rs;
	DefaultComboBoxModel model = new DefaultComboBoxModel();
	PDP.BoxColores.setModel(model);
	String[] dato = new String[1];
    boolean numero = false;
    try {
        rs = conectar.consultar(sql);
        PDP.BoxColores.removeAllItems();
        
        //categorias.setModel(new DefaultComboBoxModel(new String[] {"CATEGORIAS"}));
        while (rs.next()){
   
          dato[0] = (rs.getString(2));
          PDP.BoxColores.addItem(dato[0]);;
            numero = true;
        }
    } catch (Exception e) {
   System.out.println("Error en comparar clave(controlador categorias): " + e);
    }
    conectar.cerrar();
    return numero;
}

public boolean CantidadesDisponibles(Producto P, String id_producto, String talla) {
    Conexion conectar = new Conexion();
	String sql = "SELECT * FROM tallas WHERE id_producto="+ id_producto+ " AND talla='"+talla+"' AND estado='activo'";
	 ResultSet rs;
	DefaultComboBoxModel model = new DefaultComboBoxModel();
	P.BoxCantidades.setModel(model);
	String[] dato = new String[1];
    boolean numero = false;
    try {
        rs = conectar.consultar(sql);
        P.BoxCantidades.removeAllItems();
        
        //categorias.setModel(new DefaultComboBoxModel(new String[] {"CATEGORIAS"}));
        if (rs.next()){
   
          dato[0] = (rs.getString(2));
          int cantidad = Integer.parseInt(dato[0]);
          for (int i = 1; i < cantidad+1; i++) {
        	  P.BoxCantidades.addItem(String.valueOf(i));
          } 
         
            numero = true;
        }
    } catch (Exception e) {
   System.out.println("Error en comparar clave(controlador categorias): " + e);
    }
    conectar.cerrar();
    return numero;
}

public boolean TallasProducto(PaginaDelProducto PDP, String id_producto, String id_empresa) {
	
    Conexion conectar = new Conexion();
	String sql = "SELECT * FROM tallas WHERE id_producto="+ id_producto+ " AND id_empresa="+id_empresa+" AND estado='activo'";
	 ResultSet rs;
	DefaultComboBoxModel model = new DefaultComboBoxModel();
	PDP.BoxTallas.setModel(model);
	String[] dato = new String[1];
    boolean numero = false;
    try {
        rs = conectar.consultar(sql);
        PDP.BoxTallas.removeAllItems();
        
        //categorias.setModel(new DefaultComboBoxModel(new String[] {"CATEGORIAS"}));
        while (rs.next()){
   
          dato[0] = (rs.getString(3));
          PDP.BoxTallas.addItem(dato[0]);;
            numero = true;
        }
    } catch (Exception e) {
   System.out.println("Error en comparar clave(controlador categorias): " + e);
    }
    conectar.cerrar();
    return numero;
}


public boolean categorias_2(CrearProducto I) {
	
    Conexion conectar = new Conexion();
	String sql = "SELECT * FROM categorias" ;
	 ResultSet rs;
	DefaultComboBoxModel model = new DefaultComboBoxModel();
	I.categorias.setModel(model);
	String[] dato = new String[1];
    boolean numero = false;
    try {
        rs = conectar.consultar(sql);
        I.categorias.removeAllItems();
        
        //categorias.setModel(new DefaultComboBoxModel(new String[] {"CATEGORIAS"}));
        while (rs.next()){
   
          dato[0] = (rs.getString(2));
         
          I.categorias.addItem(dato[0]);;
            numero = true;
        }
    } catch (Exception e) {
   System.out.println("Error en comparar clave(controlador users): " + e);
    }
    conectar.cerrar();
    return numero;
}

public boolean CategoriasEditar(EditarProducto I) {
	
    Conexion conectar = new Conexion();
	String sql = "SELECT * FROM categorias" ;
	 ResultSet rs;
	String[] dato = new String[1];
    boolean numero = false;
    try {
        rs = conectar.consultar(sql);
        I.categorias.removeAllItems();
        
        //categorias.setModel(new DefaultComboBoxModel(new String[] {"CATEGORIAS"}));
        while (rs.next()){
   
          dato[0] = (rs.getString(2));
         
          I.categorias.addItem(dato[0]);;
            numero = true;
        }
    } catch (Exception e) {
   System.out.println("Error en comparar clave(controlador users): " + e);
    }
    conectar.cerrar();
    return numero;
}

public boolean Categoria(Usuario u) {
    Conexion conectar = new Conexion();
    String sql = "SELECT * FROM categorias WHERE id = " + u.getCategoria();
    ResultSet rs;
    boolean numero = false;
    try {
    	
        rs = conectar.consultar(sql);
        if(rs.next()){
                 numero = true;
         
                u.setCategoria(rs.getString("categoria"));
                
             } 
        else {
        }
    } catch (Exception e) {
   System.out.println("Error en comparar clave(controlador user): " + e);
    }
    conectar.cerrar();
    return numero;
}
	
	
public boolean Productos(JTable tabla, Usuario u) {
		
        Conexion conectar = new Conexion();
    	String sql = "SELECT * FROM productos WHERE id_empresa= "+ u.getId_empresa() + " AND estado='activo'";
    	 ResultSet rs;
		DefaultTableModel model = new DefaultTableModel();
	
		model.addColumn("ID");
		model.addColumn("NOMBRE");
		model.addColumn("PRECIO");
		model.addColumn("DESCUENTO");
		model.addColumn("DESCRIPCIÓN");
		model.addColumn("CALIFICACION");
		model.addColumn("N_P_CALIFICARON");
		model.addColumn("CATEGORIA");
		
		tabla.setModel(model);
		
		String[] dato = new String[8];
		
        boolean numero = false;
        try {
            rs = conectar.consultar(sql);
            while (rs.next()){
               
            	dato[0] = rs.getString(1);
            	dato[1] = rs.getString(2);
            	dato[2] = rs.getString(3);
            	dato[3] = rs.getString(4);
            	dato[4] = rs.getString(5);
            	dato[5] = rs.getString(6);
            	dato[6] = rs.getString(7);
            	dato[7] = rs.getString(8);
            	model.addRow(dato);
                numero = true;
            }
        } catch (Exception e) {
       System.out.println("Error en comparar clave(controlador productos): " + e);
        }
        conectar.cerrar();
        return numero;
    }
	

public boolean ProductosPorNombre(JTable tabla, Usuario u) {
	
    Conexion conectar = new Conexion();
	String sql = "SELECT * FROM productos WHERE nombre= '"+u.getNombre()+"' AND id_empresa ="+u.getId_empresa()+" AND estado='activo'" ;
	 ResultSet rs;
	DefaultTableModel model = new DefaultTableModel();

	model.addColumn("ID");
	model.addColumn("NOMBRE");
	model.addColumn("PRECIO");
	model.addColumn("DESCUENTO");
	model.addColumn("DESCRIPCIÓN");
	model.addColumn("CALIFICACION");
	model.addColumn("N_P_CALIFICARON");
	model.addColumn("CATEGORIA");
	
	tabla.setModel(model);
	
	String[] dato = new String[8];
	
    boolean numero = false;
    try {
        rs = conectar.consultar(sql);
        while (rs.next()){
           
        	dato[0] = rs.getString(1);
        	dato[1] = rs.getString(2);
        	dato[2] = rs.getString(3);
        	dato[3] = rs.getString(4);
        	dato[4] = rs.getString(5);
        	dato[5] = rs.getString(6);
        	dato[6] = rs.getString(7);
        	dato[7] = rs.getString(8);
        	model.addRow(dato);
            numero = true;
        }
    } catch (Exception e) {
    }
    conectar.cerrar();
    return numero;
}

public boolean ProductosPorId(JTable tabla, Usuario u) {
	
    Conexion conectar = new Conexion();
	String sql = "SELECT * FROM productos where id="+ u.getId_producto()+" AND id_empresa= "+u.getId_empresa()+" AND estado='activo'" ;
	 ResultSet rs;
	DefaultTableModel model = new DefaultTableModel();

	model.addColumn("ID");
	model.addColumn("NOMBRE");
	model.addColumn("PRECIO");
	model.addColumn("DESCUENTO");
	model.addColumn("DESCRIPCIÓN");
	model.addColumn("CALIFICACION");
	model.addColumn("N_P_CALIFICARON");
	model.addColumn("CATEGORIA");
	
	tabla.setModel(model);
	
	String[] dato = new String[8];
	
    boolean numero = false;
    try {
        rs = conectar.consultar(sql);
        while (rs.next()){
           
        	dato[0] = rs.getString(1);
        	dato[1] = rs.getString(2);
        	dato[2] = rs.getString(3);
        	dato[3] = rs.getString(4);
        	dato[4] = rs.getString(5);
        	dato[5] = rs.getString(6);
        	dato[6] = rs.getString(7);
        	dato[7] = rs.getString(8);
        	model.addRow(dato);
            numero = true;
        }
    } catch (Exception e) {
    }
    conectar.cerrar();
    return numero;
}


	public boolean Sliders(JTable tabla) {
		
        Conexion conectar = new Conexion();
    	String sql = "SELECT * FROM slider";
    	 ResultSet rs;
		DefaultTableModel model = new DefaultTableModel();
	
		model.addColumn("ID");
		model.addColumn("NOMBRE");
		model.addColumn("INFO");
		model.addColumn("IMAGEN");
		model.addColumn("SLIDER");
		
		tabla.setModel(model);
		
		String[] dato = new String[5];
		
       
        boolean numero = false;
        try {
            rs = conectar.consultar(sql);
            while (rs.next()){
               
            	dato[0] = rs.getString(1);
            	dato[1] = rs.getString(2);
            	dato[2] = rs.getString(3);
            	dato[3] = rs.getString(4);
            	dato[4] = rs.getString(5);
    
            	model.addRow(dato);
                numero = true;
            }
        } catch (Exception e) {
       System.out.println("Error en comparar clave(controlador users): " + e);
        }
        conectar.cerrar();
        return numero;
    }
	
public boolean EmpresaPorID(JTable tabla, String texto) {
		
        Conexion conectar = new Conexion();
    	String sql = "SELECT * FROM users WHERE Roles_id = ' 2' AND estado = 'activo' AND id = "+texto+"" ;
    	 ResultSet rs;
		DefaultTableModel model = new DefaultTableModel();
	
		model.addColumn("ID");
		model.addColumn("NOMBRE");
		model.addColumn("CORREO");
		model.addColumn("TELEFONO");
		model.addColumn("NOMBRE PROPIETARIO");
		model.addColumn("CEDULA");
		model.addColumn("DIRECCIÓN");
		model.addColumn("LOGO");
		
		tabla.setModel(model);
		
		String[] dato = new String[9];
		
       
        boolean numero = false;
        try {
            rs = conectar.consultar(sql);
            while (rs.next()){
               
            	dato[0] = rs.getString(1);
            	dato[1] = rs.getString(2);
            	dato[2] = rs.getString(3);
            	dato[3] = rs.getString(6);
            	dato[4] = rs.getString(7);
            	dato[5] = rs.getString(8);
            	dato[6] = rs.getString(9);
            	dato[7] = rs.getString(10);
            	dato[8] = rs.getString(11);
            	model.addRow(dato);
                numero = true;
            }
        } catch (Exception e) {
       System.out.println("Error en comparar clave(controlador users): " + e);
        }
        conectar.cerrar();
        return numero;
    }
	
public boolean EmpresaPorNombre(JTable tabla, String texto) {
	
    Conexion conectar = new Conexion();
	String sql = "SELECT * FROM users WHERE Roles_id = ' 2' AND estado = 'activo' AND nombre = '"+texto+"'" ;
	 ResultSet rs;
	DefaultTableModel model = new DefaultTableModel();

	model.addColumn("ID");
	model.addColumn("NOMBRE");
	model.addColumn("CORREO");
	model.addColumn("TELEFONO");
	model.addColumn("NOMBRE PROPIETARIO");
	model.addColumn("CEDULA");
	model.addColumn("DIRECCIÓN");
	model.addColumn("LOGO");
	
	tabla.setModel(model);
	
	String[] dato = new String[9];
	
   
    boolean numero = false;
    try {
        rs = conectar.consultar(sql);
        while (rs.next()){
           
        	dato[0] = rs.getString(1);
        	dato[1] = rs.getString(2);
        	dato[2] = rs.getString(3);
        	dato[3] = rs.getString(6);
        	dato[4] = rs.getString(7);
        	dato[5] = rs.getString(8);
        	dato[6] = rs.getString(9);
        	dato[7] = rs.getString(10);
        	dato[8] = rs.getString(11);
        	model.addRow(dato);
            numero = true;
        }
    } catch (Exception e) {
   System.out.println("Error en comparar clave(controlador users): " + e);
    }
    conectar.cerrar();
    return numero;
}


public int EliminarProducto(Usuario u) {
		
        Conexion conectar = new Conexion();
        String sql = "UPDATE `productos` SET `estado`='inactivo' WHERE id = " + Integer.parseInt(u.getId());
        int rs = 0;
        try {
            PS = conectar.getConnection().prepareStatement(sql);
            rs = PS.executeUpdate();
            
        } catch (Exception e) {
       System.out.println("Error en comparar clave(controlador productos): " + e);
        }finally {
        	PS = null;
        	conectar.cerrar();
		}
        
        return rs;
    }

public int EliminarImagenProducto(Usuario u) {
	
    Conexion conectar = new Conexion();
    String sql = "UPDATE `imagenes_productos` SET `estado`='inactivo' WHERE id_empresa = " + u.getId_empresa() +" AND id_producto ="+u.getId_producto() +" AND id="+u.getId();
    int rs = 0;
    try {
        PS = conectar.getConnection().prepareStatement(sql);
        rs = PS.executeUpdate();
        
    } catch (Exception e) {
   System.out.println("Error en comparar clave(controlador productos): " + e);
    }finally {
    	PS = null;
    	conectar.cerrar();
	}
    
    return rs;
}
public int EliminarImagenesProductos(Usuario u) {
	
    Conexion conectar = new Conexion();
    String sql = "UPDATE `imagenes_productos` SET `estado`='inactivo' WHERE id_empresa = " + u.getId_empresa() +" AND id_producto ="+u.getId_producto();
    int rs = 0;
    try {
        PS = conectar.getConnection().prepareStatement(sql);
        rs = PS.executeUpdate();
        
    } catch (Exception e) {
   System.out.println("Error en comparar clave(controlador productos): " + e);
    }finally {
    	PS = null;
    	conectar.cerrar();
	}
    
    return rs;
}





public int EditarEmpresaSinLogoySinContraseña(Usuario u) {
	
    Conexion conectar = new Conexion();
    String sql = "UPDATE `users` SET `nombre`='"+u.getNombre()+"',`correo`='"+u.getCorreo()+"',"
    		+ "`telefono`='"+u.getTelefono()+"',`n_propietario`='"+u.getNombreP()+"',`cedula`='"+u.getCedula()+"',"
    		+ "`direccion`='"+u.getDireccion()+"' WHERE id ="+Integer.parseInt( u.getId())+"";
    int rs = 0;
    try {
        PS = conectar.getConnection().prepareStatement(sql);
        rs = PS.executeUpdate();
        
    } catch (Exception e) {
   System.out.println("Error en comparar clave(controlador user): " + e);
    }finally {
    	PS = null;
    	
	}
    conectar.cerrar();
    
    return rs;
}

public int EditarEmpresaConLogoYConcontraseña(Usuario u) {
	
    Conexion conectar = new Conexion();
    String sql = "UPDATE `users` SET `nombre`='"+u.getNombre()+"',`correo`='"+u.getCorreo()+"',`contrasena`='"+u.getContrasena2()+"',"
    		+ "`telefono`='"+u.getTelefono()+"',`n_propietario`='"+u.getNombreP()+"',`cedula`='"+u.getCedula()+"',"
    		+ "`direccion`='"+u.getDireccion()+"',`logo`='"+u.getImagen()+"' WHERE id="+u.getId()+"";
    int rs = 0;
    try {
        PS = conectar.getConnection().prepareStatement(sql);
        rs = PS.executeUpdate();
        
    } catch (Exception e) {
   System.out.println("Error en comparar clave(controlador user): " + e);
    }finally {
    	PS = null;
    	
	}
    conectar.cerrar();
    
    return rs;
}

public int EditarEmpresaConLogoYsinContraseña(Usuario u) {
	
    Conexion conectar = new Conexion();
    String sql = "UPDATE `users` SET `nombre`='"+u.getNombre()+"',`correo`='"+u.getCorreo()+"',"
    		+ "`telefono`='"+u.getTelefono()+"',`n_propietario`='"+u.getNombreP()+"',`cedula`='"+u.getCedula()+"',"
    		+ "`direccion`='"+u.getDireccion()+"',`logo`='"+u.getImagen()+"' WHERE id="+u.getId()+"";
    int rs = 0;
    try {
        PS = conectar.getConnection().prepareStatement(sql);
        rs = PS.executeUpdate();
        
    } catch (Exception e) {
   System.out.println("Error en comparar clave(controlador user): " + e);
    }finally {
    	PS = null;
    	
	}
    conectar.cerrar();
    
    return rs;
}

public int EditarEmpresaSinLogoYConContraseña(Usuario u) {
	
    Conexion conectar = new Conexion();
    String sql = "UPDATE `users` SET `nombre`='"+u.getNombre()+"',`correo`='"+u.getCorreo()+"',`contrasena`='"+u.getContrasena2()+"',"
    		+ "`telefono`='"+u.getTelefono()+"',`n_propietario`='"+u.getNombreP()+"',`cedula`='"+u.getCedula()+"',"
    		+ "`direccion`='"+u.getDireccion()+"' WHERE id="+u.getId()+"";
    int rs = 0;
    try {
        PS = conectar.getConnection().prepareStatement(sql);
        rs = PS.executeUpdate();
        
    } catch (Exception e) {
   System.out.println("Error en comparar clave(controlador user): " + e);
    }finally {
    	PS = null;
    	
	}
    conectar.cerrar();
    
    return rs;
}

public int editarAdminConContraseña(Usuario u) {
		
        Conexion conectar = new Conexion();
        String sql = "UPDATE `users` SET `nombre`='"+ u.getNombre()+"',`correo`='"+ u.getCorreo() +"', `contrasena`='"+ u.getContrasena2()+
        		"' WHERE id ="+ Integer.parseInt(u.getId())+"";
        int rs = 0;
        try {
            PS = conectar.getConnection().prepareStatement(sql);
            rs = PS.executeUpdate();
            
        } catch (Exception e) {
       System.out.println("Error en comparar clave(controlador user): " + e);
        }finally {
        	PS = null;
        	
		}
        conectar.cerrar();
        
        return rs;
    }

public int ElimiarColor(Usuario Loguear) {
    Conexion conectar = new Conexion();
    String sql = "UPDATE `colores` SET `estado`='inactivo' WHERE id="+Integer.parseInt(Loguear.getId())+"";
    int rs = 0;
    try {
        PS = conectar.getConnection().prepareStatement(sql);
        rs = PS.executeUpdate();
        
    } catch (Exception e) {
   System.out.println("Error en comparar clave(controlador users): " + e);
    }finally {
    	PS = null;
    
	}
    conectar.cerrar();
    return rs;
}
public int ElimiarTalla(Usuario Loguear) {
    Conexion conectar = new Conexion();
    String sql = "UPDATE `tallas` SET `estado`='inactivo' WHERE id="+Integer.parseInt(Loguear.getId_talla())+"";
    int rs = 0;
    try {
        PS = conectar.getConnection().prepareStatement(sql);
        rs = PS.executeUpdate();
        
    } catch (Exception e) {
   System.out.println("Error en comparar clave(controlador users): " + e);
    }finally {
    	PS = null;
    
	}
    conectar.cerrar();
    return rs;
}

public int ElimiarUser(Usuario Loguear) {
    Conexion conectar = new Conexion();
    String sql = "UPDATE `users` SET `estado`='inactivo' WHERE id ="+Integer.parseInt(Loguear.getId())+"";
    int rs = 0;
    try {
        PS = conectar.getConnection().prepareStatement(sql);
        rs = PS.executeUpdate();
        
    } catch (Exception e) {
   System.out.println("Error en comparar clave(controlador users): " + e);
    }finally {
    	PS = null;
    
	}
    conectar.cerrar();
    return rs;
}
public int EliminarTodosLosProductos(Usuario Loguear) {
    Conexion conectar = new Conexion();
    String sql = "UPDATE `productos` SET `estado`='inactivo' WHERE id_empresa="+Integer.parseInt(Loguear.getId())+"";
    int rs = 0;
    try {
        PS = conectar.getConnection().prepareStatement(sql);
        rs = PS.executeUpdate();
        
    } catch (Exception e) {
   System.out.println("Error en comparar clave(controlador productos): " + e);
    }finally {
    	PS = null;
    
	}
    conectar.cerrar();
    return rs;
}

public int EliminarTodoCarritoUsuarios(Usuario Loguear) {
    Conexion conectar = new Conexion();
    String sql = "UPDATE `carrito_compras` SET `estado`='inactivo' WHERE id_user="+Integer.parseInt(Loguear.getId())+"";
    int rs = 0;
    try {
        PS = conectar.getConnection().prepareStatement(sql);
        rs = PS.executeUpdate();
        
    } catch (Exception e) {
   System.out.println("Error en comparar clave(controlador productos): " + e);
    }finally {
    	PS = null;
    
	}
    conectar.cerrar();
    return rs;
}

public int EliminarTodoLDUsuarios(Usuario Loguear) {
    Conexion conectar = new Conexion();
    String sql = "UPDATE `lista_deseos` SET `estado`='inactivo' WHERE id_user="+Integer.parseInt(Loguear.getId())+"";
    int rs = 0;
    try {
        PS = conectar.getConnection().prepareStatement(sql);
        rs = PS.executeUpdate();
        
    } catch (Exception e) {
   System.out.println("Error en comparar clave(controlador productos): " + e);
    }finally {
    	PS = null;
    
	}
    conectar.cerrar();
    return rs;
}



public int editarAdminSinContraseña(Usuario Loguear) {
	
    Conexion conectar = new Conexion();
    String sql = "UPDATE `users` SET `nombre`='"+Loguear.getNombre()+"',`correo`='"+Loguear.getCorreo()+"' WHERE id ="+Integer.parseInt(Loguear.getId())+"";
    int rs = 0;
    try {
        PS = conectar.getConnection().prepareStatement(sql);
        rs = PS.executeUpdate();
        
    } catch (Exception e) {
   System.out.println("Error en comparar clave(controlador users): " + e);
    }finally {
    	PS = null;
    
	}
    conectar.cerrar();
    return rs;
}

public int DesactivarSlider(Usuario Loguear) {
	
    Conexion conectar = new Conexion();
    String sql = "UPDATE `slider` SET `estado`='inactivo' WHERE id ="+Integer.parseInt(Loguear.getId())+"";
    int rs = 0;
    try {
        PS = conectar.getConnection().prepareStatement(sql);
        rs = PS.executeUpdate();
        
    } catch (Exception e) {
   System.out.println("Error en comparar clave(controlador users): " + e);
    }finally {
    	PS = null;
    
	}
    conectar.cerrar();
    return rs;
}

public int EditarSliderSinImagen(Usuario u) {
	
    Conexion conectar = new Conexion();
    String sql = "UPDATE `slider` SET `nombre`='"+u.getNombre()+"',`info`='"+u.getInfo()+"' WHERE id = "+Integer.parseInt(u.getId())+"";
    int rs = 0;
    try {
        PS = conectar.getConnection().prepareStatement(sql);
        rs = PS.executeUpdate();
        
    } catch (Exception e) {
   System.out.println("Error en comparar clave(controlador users): " + e);
    }finally {
    	PS = null;
    
	}
    conectar.cerrar();
    return rs;
}
public int EditarUsuario(Usuario u) {
	
    Conexion conectar = new Conexion();
    String sql = "UPDATE `users` SET `nombre`='"+u.getNombre()+"',`telefono`='"+u.getTelefono()+"',"
    		+ "`cedula`='"+u.getCedula()+"',`direccion`='"+u.getDireccion()+"' WHERE id = "+Integer.parseInt(u.getId())+"";
    int rs = 0;
    try {
        PS = conectar.getConnection().prepareStatement(sql);
        rs = PS.executeUpdate();
        
    } catch (Exception e) {
   System.out.println("Error en comparar clave(controlador users): " + e);
    }finally {
    	PS = null;
    
	}
    conectar.cerrar();
    return rs;
}
public int EditarContraseñaUsuario(Usuario u) {
    Conexion conectar = new Conexion();
    String sql = "UPDATE `users` SET `contrasena`='"+u.getContrasena()+"' WHERE id = "+Integer.parseInt(u.getId())+"";
    int rs = 0;
    try {
        PS = conectar.getConnection().prepareStatement(sql);
        rs = PS.executeUpdate();
        
    } catch (Exception e) {
   System.out.println("Error en comparar clave(controlador users): " + e);
    }finally {
    	PS = null;
    
	}
    conectar.cerrar();
    return rs;
}

public int EliminarProductoListaD(Usuario u) {
	
    Conexion conectar = new Conexion();
    String sql = "UPDATE `lista_deseos` SET `estado`='inactivo' WHERE id_user="+Integer.parseInt(u.getId())+" AND id_producto="+u.getId_producto();
    int rs = 0;
    try {
        PS = conectar.getConnection().prepareStatement(sql);
        rs = PS.executeUpdate();
        
    } catch (Exception e) {
   System.out.println("Error en comparar clave(controlador lista_deseos): " + e);
    }finally {
    	PS = null;
    
	}
    conectar.cerrar();
    return rs;
}

public int EliminarProductoCarritoC(Usuario u) {
	
    Conexion conectar = new Conexion();
    String sql = "UPDATE `carrito_compras` SET `estado`='inactivo' WHERE id_user="+Integer.parseInt(u.getId())+" AND id_producto="+u.getId_producto();
    int rs = 0;
    try {
        PS = conectar.getConnection().prepareStatement(sql);
        rs = PS.executeUpdate();
        
    } catch (Exception e) {
   System.out.println("Error en comparar clave(controlador carrito_compras): " + e);
    }finally {
    	PS = null;
    
	}
    conectar.cerrar();
    return rs;
}
public int EliminarTodosLosProductosDelCarrito(Usuario u) {
	
    Conexion conectar = new Conexion();
    String sql = "UPDATE `carrito_compras` SET `estado`='inactivo' WHERE id_user="+Integer.parseInt(u.getId());
    int rs = 0;
    try {
        PS = conectar.getConnection().prepareStatement(sql);
        rs = PS.executeUpdate();
        
    } catch (Exception e) {
   System.out.println("Error en comparar clave(controlador carrito_compras): " + e);
    }finally {
    	PS = null;
    
	}
    conectar.cerrar();
    return rs;
}

public int EliminarProductoDelosCarritos(Usuario u) {
	
    Conexion conectar = new Conexion();
    String sql = "UPDATE `carrito_compras` SET `estado`='inactivo' WHERE id_producto="+Integer.parseInt(u.getId());
    int rs = 0;
    try {
        PS = conectar.getConnection().prepareStatement(sql);
        rs = PS.executeUpdate();
        
    } catch (Exception e) {
   System.out.println("Error en comparar clave(controlador carrito_compras): " + e);
    }finally {
    	PS = null;
    
	}
    conectar.cerrar();
    return rs;
}

public int EliminarProductoDelasLD(Usuario u) {
	
    Conexion conectar = new Conexion();
    String sql = "UPDATE `lista_deseos` SET `estado`='inactivo' WHERE id_producto="+Integer.parseInt(u.getId());
    int rs = 0;
    try {
        PS = conectar.getConnection().prepareStatement(sql);
        rs = PS.executeUpdate();
        
    } catch (Exception e) {
   System.out.println("Error en comparar clave(controlador carrito_compras): " + e);
    }finally {
    	PS = null;
    
	}
    conectar.cerrar();
    return rs;
}

public int EditarSliderConImagen(Usuario u) {
	
    Conexion conectar = new Conexion();
    String sql = "UPDATE `slider` SET `nombre`='"+u.getNombre()+"',`info`='"+u.getInfo()+"',`imagen`='"+u.getImagen()+"' WHERE id = "+ Integer.parseInt(u.getId());
    int rs = 0;
    try {
        PS = conectar.getConnection().prepareStatement(sql);
        rs = PS.executeUpdate();
        
    } catch (Exception e) {
   System.out.println("Error en comparar clave(controlador users): " + e);
    }finally {
    	PS = null;
    
	}
    conectar.cerrar();
    return rs;
}

public int ActivarSlider(Usuario Loguear) {
	
    Conexion conectar = new Conexion();
    String sql = "UPDATE `slider` SET `estado`='activo' WHERE id ="+Integer.parseInt(Loguear.getId())+"";
    int rs = 0;
    try {
        PS = conectar.getConnection().prepareStatement(sql);
        rs = PS.executeUpdate();
        
    } catch (Exception e) {
   System.out.println("Error en comparar clave(controlador users): " + e);
    }finally {
    	PS = null;
    
	}
    conectar.cerrar();
    return rs;
}

public int EditarImagenProducto(Usuario u) {
	JOptionPane.showMessageDialog(null, u.getImagen() + u.getId());
    Conexion conectar = new Conexion();
    String sql = "UPDATE `imagenes_productos` SET `imagen`='"+u.getImagen()+"' WHERE id="+u.getId();
    int rs = 0;
    try {
        PS = conectar.getConnection().prepareStatement(sql);
        rs = PS.executeUpdate();
        
    } catch (Exception e) {
   System.out.println("Error en comparar clave(controlador productos): " + e);
    }finally {
    	PS = null;
    
	}
    conectar.cerrar();
    return rs;
}



public int EditarProductoSinImagen(Usuario u) {
	
    Conexion conectar = new Conexion();
    String sql = "UPDATE `productos` SET `nombre`='"+u.getNombre()+"',`precio`='"+u.getPrecio()+"',`descuento`='"+u.getDescuento()+"'"
    		+ ",`descripcion`='"+u.getDescripcion()+"',`categoria`='"+u.getCategoria()+"',`id_empresa`='"+u.getId_empresa()+
    		"' WHERE id= "+u.getId_producto();
    int rs = 0;
    try {
        PS = conectar.getConnection().prepareStatement(sql);
        rs = PS.executeUpdate();
        
    } catch (Exception e) {
   System.out.println("Error en comparar clave(controlador users): " + e);
    }finally {
    	PS = null;
    
	}
    conectar.cerrar();
    return rs;
}

public int InsertarCantidad(Usuario u) {
    Conexion conectar = new Conexion();
    String sql = "UPDATE `carrito_compras` SET `cantidad_producto`='"+u.getCantidad()+"' WHERE id_user= "+u.getId()+ " AND id_producto="+u.getId_producto()+ " AND estado='activo'";
    int rs = 0;
    try {
        PS = conectar.getConnection().prepareStatement(sql);
        rs = PS.executeUpdate();
        
    } catch (Exception e) {
   System.out.println("Error en comparar clave(controlador carrito_compras): " + e);
    }finally {
    	PS = null;
    
	}
    conectar.cerrar();
    return rs;
}
public int InsertarTotalAlCarrito(Usuario u) {
    Conexion conectar = new Conexion();
    String sql = "UPDATE `carrito_compras` SET `total`="+Integer.parseInt(u.getPrecio())+" WHERE id_user="+u.getId()+ " AND id_producto="+u.getId_producto()+ " AND estado='activo'";
    int rs = 0;
    try {
        PS = conectar.getConnection().prepareStatement(sql);
        rs = PS.executeUpdate();
        
    } catch (Exception e) {
    }finally {
    	PS = null;
    
	}
    conectar.cerrar();
    return rs;
}
}
