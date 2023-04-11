package controlador;
import vista.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Base64;

import javax.print.attribute.standard.JobPrioritySupported;
import javax.swing.Action;
import javax.swing.JOptionPane;

import herramientas.AplicarValidacion;
import herramientas.Ayudas;
import modelo.*;
import sql.Consultas;
public class EditarAdminController implements ActionListener, KeyListener{

	CrearEmpresa EE;
	Usuario u = new Usuario();
	Administrador admin;
	Consultas consulta = new Consultas();
	Ayudas ayuda = new Ayudas();
	public EditarAdminController(CrearEmpresa EE, Usuario u, Administrador admin) {
		this.EE = EE;
		this.admin= admin;
		this.EE.textNombre.addKeyListener(this);
		this.EE.textCorreo.addKeyListener(this);
		this.EE.textContrasenaA.addKeyListener(this);
		this.EE.textContrasenaN.addKeyListener(this);
		this.u = u;
		this.EE.btnGuardarCambios.addActionListener(this);
		Ayudas.CagarDatosAdmin(EE, u);
	}
	
	




	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(EE.btnGuardarCambios)) {
			
			String nombre = EE.textNombre.getText();
			String correo = EE.textCorreo.getText();
			String ContrasenaA = String.valueOf(EE.textContrasenaA.getPassword());
			String ContrasenaN = String.valueOf(EE.textContrasenaN.getPassword());
			
			u.setNombre(nombre);
			u.setCorreo(correo);
			u.setContrasena(ContrasenaA);
			u.setContrasena2(ContrasenaN);
			try {
				String cifrado =ayuda.Cifra(u.getContrasena());
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
			if(ContrasenaA.equals("") && ContrasenaN.equals("")) {
				

				if(AplicarValidacion.NombreEditar(nombre, EE) || AplicarValidacion.CorreoEditar(correo, EE)) {
					JOptionPane.showMessageDialog(null, "ERROR EN LOS CAMPOS");
				}else {
					if (consulta.editarAdminSinContraseña(u) > 0) {
					JOptionPane.showMessageDialog(null, "USUARIO EDITADO CORRECTAMENTE");
					u.setNombre(nombre);
					u.setCorreo(correo);
					Ayudas.ActualizarNombre(u, admin);
					Ayudas.LLenarTablaEmpresas(admin.TablaEmpresas);
					Ayudas.CagarDatosAdmin(EE, u);}
				
				}
				
		}
			else {
				
			if(AplicarValidacion.NombreEditar(nombre, EE) || AplicarValidacion.CorreoEditar(correo, EE) || AplicarValidacion.ContraseñaAcEditar(ContrasenaA, EE) || AplicarValidacion.ContraseñaNueEditar(ContrasenaN, EE)) {
				JOptionPane.showMessageDialog(null, "ERROR EN LOS CAMPOS");
			}
			
			else if(!consulta.ValidarContraseña(u)){
				JOptionPane.showMessageDialog(null, "LA CONTRASEÑA ACTUAL NO CONINCIDE CON EL USUARIO");
			}
			
			else{
				if (consulta.editarAdminConContraseña(u) > 0) {
				JOptionPane.showMessageDialog(null, "USUARIO EDITADO CORRECTAMENTE");
				u.setNombre(nombre);
				u.setCorreo(correo);
				Ayudas.ActualizarNombre(u, admin);
				EE.textContrasenaA.setText("");
				EE.textContrasenaN.setText("");
				 Ayudas.LLenarTablaEmpresas(admin.TablaEmpresas);
					Ayudas.CagarDatosAdmin(EE, u); }
			else {
				
				JOptionPane.showMessageDialog(null, "Usuario no editado");
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
		
		if(e.getSource().equals(EE.textNombre)) {
			
			AplicarValidacion.NombreEditar(EE.textNombre.getText(), EE);
		}
		
		if(e.getSource().equals(EE.textCorreo)) {
			
			AplicarValidacion.CorreoEditar(EE.textCorreo.getText(), EE);
		}
		
		if(e.getSource().equals(EE.textContrasenaA)) {
			
			AplicarValidacion.ContraseñaAcEditar(String.valueOf( EE.textContrasenaA.getPassword()), EE);
		}
		
		if(e.getSource().equals(EE.textContrasenaN)) {
			
			AplicarValidacion.ContraseñaNueEditar(String.valueOf( EE.textContrasenaN.getPassword()), EE);
		}
		
	}
	

}
