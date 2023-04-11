package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import herramientas.AplicarValidacion;
import herramientas.Ayudas;
import modelo.Usuario;
import sql.Consultas;
import vista.Administrador;
import vista.CrearLocal;
import vista.EditarEmpresa;

public class EditarEmpresaController implements ActionListener, KeyListener{
	EditarEmpresa EE;
	public Path origen;
	public Path Destino;
	public Path Destino2;
	public String destin = "";
	Usuario u = new Usuario();
	Consultas consulta = new Consultas();
	Administrador admin;
	Ayudas ayuda = new Ayudas();
	public EditarEmpresaController(EditarEmpresa EE, Administrador admin, Usuario u) {
		this.admin = admin;
		this.u = u;
			this.EE = EE;
			this.EE.btnCrear.addActionListener(this);
			this.EE.btnSeleccionarLogo.addActionListener(this);
			this.EE.textNombreEmpresa.addKeyListener(this);
			this.EE.textCContrasena.addKeyListener(this);
			this.EE.textCedulaPropietario.addKeyListener(this);
			this.EE.textContrasena.addKeyListener(this);
			this.EE.textCorreo.addKeyListener(this);
			this.EE.textDireccion.addKeyListener(this);
			this.EE.textNombrePropietario.addKeyListener(this);
			this.EE.textTelefono.addKeyListener(this);
			llenarDatos();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(EE.btnSeleccionarLogo)) {
			if(destin.equals("")) {
			JFileChooser file = new JFileChooser();
			file.showOpenDialog(EE);
			File archivo = file.getSelectedFile();
			
			if(archivo != null) {
					int formato = archivo.getName().length() - 4;
					String FinFormato = archivo.getName().toString().substring(formato);
					if (!FinFormato.equals(".png") && !FinFormato.equals(".jpg")) {
						JOptionPane.showMessageDialog(null, "FORMATO NO VALIDO \n EL FORMATO DEBE SER .png o .jpg");
					}else {
						consulta.ConsultarLogoEmpresa(u);
						String Dest2 = System.getProperty("user.dir")+"/images/"+u.getImagen();
						Path destino2 = Paths.get(Dest2);
						u.setImagen(u.getId()+"_"+ Ayudas.obtenerFechaYHoraActual()+FinFormato);
						String Dest = System.getProperty("user.dir")+"/images/"+ u.getImagen();
						Path destino = Paths.get(Dest);
					
					String Orig = archivo.getPath();
					Path Origen = Paths.get(Orig);
					
					Destino = destino;
					origen = Origen;
					Destino2 = destino2;
					JOptionPane.showMessageDialog(null, "ARCHIVO GUARDADO");
					EE.btnSeleccionarLogo.setVisible(false);
					EE.btnSeleccionarLogo.setText("");
					EE.lblImagen.setVisible(true);
					EE.lblImagen.setText(archivo.getName());
					
				
				
			}
			}
			}else {
				
			}
			}
			
		
		
		if(e.getSource().equals(EE.btnCrear)) {
			
			String nombre = EE.textNombreEmpresa.getText();
			String NombreP = EE.textNombrePropietario.getText();
			String telefono = EE.textTelefono.getText();
			String cedula = EE.textCedulaPropietario.getText();
			String Direccion = EE.textDireccion.getText();
			String Correo = EE.textCorreo.getText();
			String Contrasena = String.valueOf(EE.textContrasena.getPassword());
			String CContrasena = String.valueOf(EE.textCContrasena.getPassword());
	
			
			u.setNombre(nombre);
			u.setNombreP(NombreP);
			u.setTelefono(telefono);
			u.setCedula(cedula);
			u.setDireccion(Direccion);
			u.setCorreo(Correo);
			u.setContrasena(Contrasena);
			u.setContrasena2(CContrasena);
			try {
				String cifrado = ayuda.Cifra(u.getContrasena());
				u.setContrasena(cifrado);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				String cifrado = ayuda.Cifra(u.getContrasena2());
				u.setContrasena2(cifrado);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			if(Contrasena.equals("") && CContrasena.equals("") && !EE.btnSeleccionarLogo.getText().equals("")) {//editar sin logo y sin contraseña
				
				if(	AplicarValidacion.NombreLocalEditar(EE.textNombreEmpresa.getText(), EE)||AplicarValidacion.NombrePropietarioEditar(EE.textNombrePropietario.getText(), EE)
						|| AplicarValidacion.CedulaPropietarioEditar(EE.textCedulaPropietario.getText(), EE)|| AplicarValidacion.CorreoEditar(EE.textCorreo.getText(), EE)
						|| AplicarValidacion.DirrecionEditar(EE.textDireccion.getText(), EE) || AplicarValidacion.TelefonoEditar(EE.textTelefono.getText(), EE))
				{ JOptionPane.showMessageDialog(null, "ERROR EN LOS CAMPOS");
				}else {
					if(consulta.EditarEmpresaSinLogoySinContraseña(u) > 0) {
						JOptionPane.showMessageDialog(null, "EMPRESA EDITADA CON EXITO");
						Ayudas.ActualizarPanel(admin.AdminPanel, EE , admin.contentPane);
						Ayudas.ActualizarEmpresas(admin);
						Ayudas.LLenarTablaEmpresas(admin.TablaEmpresas);
						EE.textContrasena.setText("");
						EE.textCContrasena.setText("");
						admin.lblpresionar.setText("PRESIONE UNA EMPRESA PARA MODIFICARLA");
						admin.btnCancelar.setVisible(false);
						admin.btnEliminar.setVisible(false);
						admin.btnEditar.setVisible(false);
						admin.btnConsultarempresas.setVisible(false);
					}
					
				}
			
				
			}else if(!Contrasena.equals("") || !CContrasena.equals("") &&   !EE.btnSeleccionarLogo.getText().equals("")) {//editar sin logo y con contraseña
				
			if(	AplicarValidacion.NombreLocalEditar(EE.textNombreEmpresa.getText(), EE)||AplicarValidacion.NombrePropietarioEditar(EE.textNombrePropietario.getText(), EE)
					|| AplicarValidacion.CedulaPropietarioEditar(EE.textCedulaPropietario.getText(), EE)|| AplicarValidacion.CorreoEditar(EE.textCorreo.getText(), EE)
					|| AplicarValidacion.DirrecionEditar(EE.textDireccion.getText(), EE) || AplicarValidacion.ContraseñaEditar(String.valueOf( EE.textContrasena.getPassword()), EE) 
					|| AplicarValidacion.ContraseñaConfirmarEditar(String.valueOf( EE.textCContrasena.getPassword()), EE)|| AplicarValidacion.TelefonoEditar(EE.textTelefono.getText(), EE))
			{
				JOptionPane.showMessageDialog(null, "ERROR EN LOS CAMPOS");}
				
			else if(!Contrasena.equals(CContrasena)) {
				JOptionPane.showMessageDialog(null, "LA CONTRASEÑA NO CONINCIDE");
			}else{
				if(consulta.EditarEmpresaSinLogoYConContraseña(u) > 0) {
					
					JOptionPane.showMessageDialog(null, "EMPRESA EDITADA CON EXITO");
					Ayudas.ActualizarPanel(admin.AdminPanel, EE , admin.contentPane);
					Ayudas.ActualizarEmpresas(admin);
					Ayudas.LLenarTablaEmpresas(admin.TablaEmpresas);	
					EE.textContrasena.setText("");
					EE.textCContrasena.setText("");
					admin.lblpresionar.setText("PRESIONE UNA EMPRESA PARA MODIFICARLA");
					admin.btnCancelar.setVisible(false);
					admin.btnEliminar.setVisible(false);
					admin.btnEditar.setVisible(false);
					admin.btnConsultarempresas.setVisible(false);

					
//					try {
//						Files.delete(Destino2);
//						Files.copy(origen, Destino);
//					} catch (IOException ex) {
//						// TODO: handle exception
//					}
					
				}
			}
			}
				else if(!Contrasena.equals("") || !CContrasena.equals("")  &&   EE.btnSeleccionarLogo.getText().equals("")) {//editar con logo y con contraseña
					
					if(	AplicarValidacion.NombreLocalEditar(EE.textNombreEmpresa.getText(), EE)||AplicarValidacion.NombrePropietarioEditar(EE.textNombrePropietario.getText(), EE)
							|| AplicarValidacion.CedulaPropietarioEditar(EE.textCedulaPropietario.getText(), EE)|| AplicarValidacion.CorreoEditar(EE.textCorreo.getText(), EE)
							|| AplicarValidacion.DirrecionEditar(EE.textDireccion.getText(), EE) || AplicarValidacion.ContraseñaEditar(String.valueOf( EE.textContrasena.getPassword()), EE) 
							|| AplicarValidacion.ContraseñaConfirmarEditar(String.valueOf( EE.textCContrasena.getPassword()), EE)|| AplicarValidacion.TelefonoEditar(EE.textTelefono.getText(), EE)){
						
							JOptionPane.showMessageDialog(null, "ERROR EN LOS CAMPOS");}
							
						else if(!Contrasena.equals(CContrasena)) {
							JOptionPane.showMessageDialog(null, "LA CONTRASEÑA NO CONINCIDE");
						}
						else{
							if(consulta.EditarEmpresaConLogoYConcontraseña(u) > 0) {
								
								JOptionPane.showMessageDialog(null, "EMPRESA EDITADA CON EXITO");
								Ayudas.ActualizarPanel(admin.AdminPanel, EE , admin.contentPane);
								Ayudas.ActualizarEmpresas(admin);
								Ayudas.LLenarTablaEmpresas(admin.TablaEmpresas);	
								EE.textContrasena.setText("");
								EE.textCContrasena.setText("");
								admin.lblpresionar.setText("PRESIONE UNA EMPRESA PARA MODIFICARLA");
								admin.btnCancelar.setVisible(false);
								admin.btnEliminar.setVisible(false);
								admin.btnEditar.setVisible(false);
								admin.btnConsultarempresas.setVisible(false);
								
								try {
									Files.copy(origen, Destino);
									Files.delete(Destino2);
								} catch (IOException ex) {
									// TODO: handle exception
								}
								
							}
					}
					}
				
				else if (Contrasena.equals("") && CContrasena.equals("") && EE.btnSeleccionarLogo.getText().equals("")) {//editar con logo y sin contraseña
					
					if(	AplicarValidacion.NombreLocalEditar(EE.textNombreEmpresa.getText(), EE)||AplicarValidacion.NombrePropietarioEditar(EE.textNombrePropietario.getText(), EE)
							|| AplicarValidacion.CedulaPropietarioEditar(EE.textCedulaPropietario.getText(), EE)|| AplicarValidacion.CorreoEditar(EE.textCorreo.getText(), EE)
							|| AplicarValidacion.DirrecionEditar(EE.textDireccion.getText(), EE) || AplicarValidacion.TelefonoEditar(EE.textTelefono.getText(), EE)){
						
							JOptionPane.showMessageDialog(null, "ERROR EN LOS CAMPOS");}
							
						else{
							if(consulta.EditarEmpresaConLogoYsinContraseña(u) > 0) {
								
								JOptionPane.showMessageDialog(null, "EMPRESA EDITADA CON EXITO");
								Ayudas.ActualizarPanel(admin.AdminPanel, EE , admin.contentPane);
								Ayudas.ActualizarEmpresas(admin);
								Ayudas.LLenarTablaEmpresas(admin.TablaEmpresas);
								EE.textContrasena.setText("");
								EE.textCContrasena.setText("");
								admin.lblpresionar.setText("PRESIONE UNA EMPRESA PARA MODIFICARLA");
								admin.btnCancelar.setVisible(false);
								admin.btnEliminar.setVisible(false);
								admin.btnEditar.setVisible(false);
								admin.btnConsultarempresas.setVisible(false);
								try {
									Files.copy(origen, Destino);
									Files.delete(Destino2);
								} catch (IOException ex) {
									System.out.println(ex);
								}
							}
						}
				}
			}
		}
//		JOptionPane.showMessageDialog(null, "EMPRESA EDITADA CON EXITO");
//		Ayudas.ActualizarPanel(admin.AdminPanel, EE , admin.contentPane);
//		Ayudas.ActualizarEmpresas(admin);
//		Ayudas.LLenarTablaEmpresas(admin.TablaEmpresas);
//		
	
	
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
		if(e.getSource().equals(EE.textNombreEmpresa)) {
			AplicarValidacion.NombreLocalEditar(EE.textNombreEmpresa.getText(), EE);
		}
		if(e.getSource().equals(EE.textNombrePropietario)) {
			AplicarValidacion.NombrePropietarioEditar(EE.textNombrePropietario.getText(), EE);
		}
		
		
	if(e.getSource().equals(EE.textCedulaPropietario)) {
		AplicarValidacion.CedulaPropietarioEditar(EE.textCedulaPropietario.getText(), EE);
		}
	if(e.getSource().equals(EE.textCorreo)) {
		AplicarValidacion.CorreoEditar(EE.textCorreo.getText(), EE);
	}
	if(e.getSource().equals(EE.textDireccion)) {
		AplicarValidacion.DirrecionEditar(EE.textDireccion.getText(), EE);
	}
	if(e.getSource().equals(EE.textContrasena)) {
		AplicarValidacion.ContraseñaEditar(String.valueOf( EE.textContrasena.getPassword()), EE);
	}
	
	if(e.getSource().equals(EE.textCContrasena)) {
			
		AplicarValidacion.ContraseñaConfirmarEditar(String.valueOf( EE.textCContrasena.getPassword()), EE);
		}
	
	if(e.getSource().equals(EE.textTelefono)) {
		
		AplicarValidacion.TelefonoEditar(EE.textTelefono.getText(), EE);
		}
	}
	private void llenarDatos() {
		
		EE.textNombreEmpresa.setText(u.getNombre());
		EE.textNombrePropietario.setText(u.getNombreP());
		EE.textCorreo.setText(u.getCorreo());
		EE.textTelefono.setText(u.getTelefono());
		EE.textCedulaPropietario.setText(u.getCedula());
		EE.textDireccion.setText(u.getDireccion());
		
	}
}
