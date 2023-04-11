package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.Base64;

import javax.swing.JOptionPane;

import org.w3c.dom.events.MouseEvent;

import herramientas.AplicarValidacion;
import herramientas.Ayudas;
import modelo.Usuario;
import sql.Consultas;
import vista.*;


public class IniciarSesionController implements ActionListener, KeyListener, MouseListener{
	IniciarSesion iniciar;
	Usuario u = new Usuario();
	Ayudas ayuda = new Ayudas();
	public IniciarSesionController(IniciarSesion iniciar) {
		this.iniciar = iniciar;
		this.iniciar.btnIniciar.addActionListener(this);
		this.iniciar.btnVolver.addActionListener(this);
		this.iniciar.lblRestablecer.addMouseListener(this);
		this.iniciar.textCorreo.addKeyListener(this);
		this.iniciar.textContrasena.addKeyListener(this);
		this.iniciar.lblCrearCuenta.addMouseListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	
		if(e.getSource().equals(iniciar.btnVolver)) {
			Index I = new Index();
			I.setVisible(true);
			new IndexController(I);	
			iniciar.dispose();
		}
		
		if(e.getSource().equals(iniciar.btnIniciar)) {
			
			String correo = iniciar.textCorreo.getText();
			String contrasena =String.valueOf( iniciar.textContrasena.getPassword());
			u.setCorreo(correo);
			u.setContrasena(contrasena);
			
			if(AplicarValidacion.LoginCorreo(correo, iniciar) || AplicarValidacion.LoginContraseña(contrasena, iniciar)) {
				JOptionPane.showMessageDialog(null, "ERROR EN LOS CAMPOS");
			}else {
				try {
					String cifrado = ayuda.Cifra(u.getContrasena());
					u.setContrasena(cifrado);
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Consultas consulta = new Consultas();
				if(!consulta.ConfirmarExistenciaUsuario(u)) {
					JOptionPane.showMessageDialog(null, "EL USUARIO NO EXISTE");
				}else if(consulta.ConfirmarPagoUsuario(u)){
					JOptionPane.showMessageDialog(null, "EL USUARIO ESTA INACTIVO POR FALTA DE PAGO \nO ELIMINADO");
				}else if(consulta.logueo(u)) {
				if(u.getRol().equals("1")) {
					iniciar.dispose();
					Index I = new Index();
					I.id_user.setText(u.getId());
					new IndexController(I);
				}else
					if(u.getRol().equals("2")) {
					PerfilEmpresa empresa = new PerfilEmpresa();
					empresa.setVisible(true);
					iniciar.dispose();
					new PerfilEmpresaController(empresa, u);
					
					}
					else
						if(u.getRol().equals("3")) {
							Administrador admin = new Administrador();
							admin.setVisible(true);
							admin.IdAdmin.setText(u.getId());
							iniciar.dispose();
							new AdministradorController(admin, u);
						}
						}else {
							JOptionPane.showMessageDialog(null, "LA CONTRASEÑA \n NO COINCIDE CON EL USUARIO");
						}
				
				}
			}
			
		}
		
	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
if(e.getSource().equals(iniciar.lblCrearCuenta)) {
			
			CrearCuenta CC = new CrearCuenta();
			CC.setVisible(true);
			iniciar.dispose();
			new CrearCuentaController(CC);
		}
	}
	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
		
		if(e.getSource().equals(iniciar.lblRestablecer)) {
			iniciar.dispose();
			RecuperarContraseña RC = new RecuperarContraseña();
			RC.setVisible(true);
			new RecuperarContraseñaController(RC);
		}
	}
	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {
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
		if(e.getSource().equals(iniciar.textCorreo)) {
			
			AplicarValidacion.LoginCorreo(iniciar.textCorreo.getText(), iniciar);
		}
		if(e.getSource().equals(iniciar.textContrasena)) {
			
			
			AplicarValidacion.LoginContraseña(String.valueOf( iniciar.textContrasena.getPassword()), iniciar);
		}
		
	}
	
}
