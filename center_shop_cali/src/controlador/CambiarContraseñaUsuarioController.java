package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Base64;

import javax.swing.JOptionPane;

import herramientas.AplicarValidacion;
import herramientas.Ayudas;
import modelo.Usuario;
import sql.Consultas;
import vista.CambiarContraseñaUsuario;

public class CambiarContraseñaUsuarioController implements KeyListener, ActionListener{

	CambiarContraseñaUsuario CCU;
	Consultas consulta = new Consultas();
	Usuario u = new Usuario();
	public CambiarContraseñaUsuarioController(CambiarContraseñaUsuario CCU) {
		this.CCU = CCU;
		this.CCU.btnCerrar.addActionListener(this);
		this.CCU.btnConfirmar.addActionListener(this);
		this.CCU.textCContrasena.addKeyListener(this);
		this.CCU.textContrasenaA.addKeyListener(this);
		this.CCU.textContrasenaN.addKeyListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(CCU.btnCerrar)) {
			CCU.dispose();
		}
		if(e.getSource().equals(CCU.btnConfirmar)) {
			
			String CContrasena = String.valueOf(CCU.textCContrasena.getPassword());
			String ContrasenaA = String.valueOf(CCU.textContrasenaA.getPassword());
			String ContrasenaN = String.valueOf(CCU.textContrasenaN.getPassword());
			
			if(AplicarValidacion.UsuarioCContraseña(String.valueOf(CCU.textCContrasena.getPassword()), CCU)
			|| AplicarValidacion.UsuarioContraseñaA(String.valueOf(CCU.textContrasenaA.getPassword()), CCU)
			||AplicarValidacion.UsuarioContraseñaN(String.valueOf(CCU.textContrasenaN.getPassword()), CCU)) {
			JOptionPane.showMessageDialog(null, "ERROR EN LOS CAMPOS");	
			}else {
				if(!ContrasenaN.equals(CContrasena)) {
					JOptionPane.showMessageDialog(null, "LAS CONTRASEÑAS NO COINCIDEN");
				}else {
					u.setId(CCU.id_user.getText());
					consulta.DatosUsuario(u);
					Ayudas ayuda = new Ayudas();
					try {
						String CActual = ayuda.Cifra(ContrasenaA);
						u.setContrasena2(CActual);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if(u.getContrasena2().equals(u.getContrasena())) {
						try {
							String NActual = ayuda.Cifra(ContrasenaN);
							u.setContrasena(NActual);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				
						if(consulta.EditarContraseñaUsuario(u)> 0) {
							JOptionPane.showMessageDialog(null, "CONTRASEÑA EDITADA CON EXITO");
							CCU.dispose();
						}else {
							JOptionPane.showMessageDialog(null, "NO SE EDITO");
						}
					}else {
						JOptionPane.showMessageDialog(null, "LA CONTRASEÑA NO COINCIDE CON LA EXISTENTE");
					}
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
		
		if(e.getSource().equals(CCU.textCContrasena)) {
			AplicarValidacion.UsuarioCContraseña(String.valueOf(CCU.textCContrasena.getPassword()), CCU);
		}
		if(e.getSource().equals(CCU.textContrasenaA)) {
			AplicarValidacion.UsuarioContraseñaA(String.valueOf(CCU.textContrasenaA.getPassword()), CCU);
		}
		if(e.getSource().equals(CCU.textContrasenaN)) {
			AplicarValidacion.UsuarioContraseñaN(String.valueOf(CCU.textContrasenaN.getPassword()), CCU);
		}
		
	}
}
