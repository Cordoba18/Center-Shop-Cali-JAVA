package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.System.Logger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.logging.Level;

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
public class CrearLocalController implements ActionListener, KeyListener {
	CrearLocal CL;
	public Path origen;
	public Path Destino;
	Usuario u = new Usuario();
	Consultas consulta = new Consultas();
	Administrador admin;
	Ayudas ayuda = new Ayudas();
	public CrearLocalController(CrearLocal CL, Administrador admin) {
		this.admin = admin;
		this.CL = CL;
		this.CL.btnCrear.addActionListener(this);
		this.CL.btnSeleccionarLogo.addActionListener(this);
		this.CL.textNombreEmpresa.addKeyListener(this);
		this.CL.textCContrasena.addKeyListener(this);
		this.CL.textCedulaPropietario.addKeyListener(this);
		this.CL.textContrasena.addKeyListener(this);
		this.CL.textCorreo.addKeyListener(this);
		this.CL.textD1.addKeyListener(this);
		this.CL.textD2.addKeyListener(this);
		this.CL.textD3.addKeyListener(this);
		this.CL.textNombrePropietario.addKeyListener(this);
		this.CL.textTelefono.addKeyListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(CL.btnSeleccionarLogo)) {
			
			JFileChooser file = new JFileChooser();
			file.showOpenDialog(CL);
			File archivo = file.getSelectedFile();
			
			if(archivo != null) {
				int formato = archivo.getName().length() - 4;
				String FinFormato = archivo.getName().toString().substring(formato);
				if (!FinFormato.equals(".png") && !FinFormato.equals(".jpg")) {
					JOptionPane.showMessageDialog(null, "FORMATO NO VALIDO \n EL FORMATO DEBE SER .png o .jpg");
				}else {
				consulta.ClaveImagenUser(u);
				u.setImagen(u.getId()+"_"+ Ayudas.obtenerFechaYHoraActual()+FinFormato);
				
				
					String Dest = System.getProperty("user.dir") + "/images/"+ u.getImagen() ;
					Path destino = Paths.get(Dest);
					String Orig = archivo.getPath();
					Path Origen = Paths.get(Orig);
					
					Destino = destino;
					origen = Origen;
					
					JOptionPane.showMessageDialog(null, "ARCHIVO GUARDADO");
					CL.btnSeleccionarLogo.setVisible(false);
					CL.btnSeleccionarLogo.setText("");
					CL.lblImagen.setVisible(true);
					CL.lblImagen.setText(archivo.getName());
					
			
			}
			}
			
		}
		
		if(e.getSource().equals(CL.btnCrear)) {
			
			String nombre = CL.textNombreEmpresa.getText();
			String NombreP = CL.textNombrePropietario.getText();
			String telefono = CL.textTelefono.getText();
			String cedula = CL.textCedulaPropietario.getText();
			String D1 = CL.textD1.getText();
			String D2 = CL.textD2.getText();
			String D3 = CL.textD3.getText();
			String Correo = CL.textCorreo.getText();
			String Contrasena = String.valueOf( CL.textContrasena.getPassword());
			String CContrasena = String.valueOf( CL.textCContrasena.getPassword());
	
			
			u.setNombre(nombre);
			u.setNombreP(NombreP);
			u.setTelefono(telefono);
			u.setCedula(cedula);
			u.setD1(D1);
			u.setD2(D2);
			u.setD3(D3);
			u.setCorreo(Correo);
			u.setContrasena(Contrasena);
			u.setContrasena2(CContrasena);
			
			if(AplicarValidacion.NombreLocal(CL.textNombreEmpresa.getText(), CL) || AplicarValidacion.NombrePropietario(CL.textNombrePropietario.getText(), CL)
					|| AplicarValidacion.CedulaPropietario(CL.textCedulaPropietario.getText(), CL) || AplicarValidacion.CorreoCrear(CL.textCorreo.getText(), CL)
					||AplicarValidacion.Dirrecion(CL.textD1.getText(), CL.textD2.getText(), CL.textD3.getText(), CL)||AplicarValidacion.Dirrecion(CL.textD1.getText(), CL.textD2.getText(), CL.textD3.getText(), CL)
					||AplicarValidacion.Dirrecion(CL.textD1.getText(), CL.textD2.getText(), CL.textD3.getText(), CL)|| AplicarValidacion.ContraseñaCrear(String.valueOf( CL.textContrasena.getPassword()), CL)
					||AplicarValidacion.ContraseñaConfirmar(String.valueOf( CL.textCContrasena.getPassword()), CL)|| AplicarValidacion.TelefonoCrear(CL.textTelefono.getText(), CL)){
				JOptionPane.showMessageDialog(null, "ERROR EN LOS CAMPOS");
			}else if(!CL.btnSeleccionarLogo.getText().equals("")){
				JOptionPane.showMessageDialog(null, "PORFAVOR ELIJA UNA IMAGEN");
			}
			
			else if(consulta.ConsultarEmpresa(u)) {
				JOptionPane.showMessageDialog(null, "ESA EMPRESA YA EXISTE");
			}
			
			else if(Contrasena.equals(CContrasena)){
				
				try {
					String cifrado =ayuda.Cifra(u.getContrasena2());
					u.setContrasena2(cifrado);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(consulta.InsertarEmpresa(u)) {
					try {
						Files.copy(origen, Destino);
					} catch (IOException ex) {
						// TODO: handle exception
					}
					CL.textNombreEmpresa.setText("");
					CL.textNombrePropietario.setText("");
					CL.textTelefono.setText("");
					CL.textCedulaPropietario.setText("");
					CL.textD1.setText("");
					CL.textD2.setText("");
					CL.textD3.setText("");
					CL.textCorreo.setText("");
					CL.textContrasena.setText("");
					CL.textCContrasena.setText("");
					CL.btnSeleccionarLogo.setVisible(true);
					CL.lblImagen.setVisible(false);
					CL.btnSeleccionarLogo.setText("Seleccionar Logo");
					JOptionPane.showMessageDialog(null, "EMPRESA CREADA CON EXITO");
					Ayudas.ActualizarEmpresas(admin);
					Ayudas.LLenarTablaEmpresas(admin.TablaEmpresas);
					
				}else {
					
					JOptionPane.showMessageDialog(null, "EMPRESA NO INSERTADA");
				}
				
			}else {
				JOptionPane.showMessageDialog(null, "LAS CONTRASEÑAS NO COINCIDEN");
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
		if(e.getSource().equals(CL.textNombreEmpresa)) {
			AplicarValidacion.NombreLocal(CL.textNombreEmpresa.getText(), CL);
		}
		if(e.getSource().equals(CL.textNombrePropietario)) {
			AplicarValidacion.NombrePropietario(CL.textNombrePropietario.getText(), CL);
		}
		
		
	if(e.getSource().equals(CL.textCedulaPropietario)) {
		AplicarValidacion.CedulaPropietario(CL.textCedulaPropietario.getText(), CL);
		}
	if(e.getSource().equals(CL.textCorreo)) {
		AplicarValidacion.CorreoCrear(CL.textCorreo.getText(), CL);
	}
	if(e.getSource().equals(CL.textD1)) {
		AplicarValidacion.Dirrecion(CL.textD1.getText(), CL.textD2.getText(), CL.textD3.getText(), CL);
	}
	if(e.getSource().equals(CL.textD2)) {
		AplicarValidacion.Dirrecion(CL.textD1.getText(), CL.textD2.getText(), CL.textD3.getText(), CL);
	}
	if(e.getSource().equals(CL.textD3)) {
		AplicarValidacion.Dirrecion(CL.textD1.getText(), CL.textD2.getText(), CL.textD3.getText(), CL);
	}
	if(e.getSource().equals(CL.textContrasena)) {
		AplicarValidacion.ContraseñaCrear(String.valueOf( CL.textContrasena.getPassword()), CL);
	}
	
	if(e.getSource().equals(CL.textCContrasena)) {
			
		AplicarValidacion.ContraseñaConfirmar(String.valueOf( CL.textCContrasena.getPassword()), CL);
		}
	
	if(e.getSource().equals(CL.textTelefono)) {
		
		AplicarValidacion.TelefonoCrear(CL.textTelefono.getText(), CL);
		}
	}
	
}
