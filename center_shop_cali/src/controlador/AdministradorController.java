package controlador;
import java.awt.event.ActionEvent;
import herramientas.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.w3c.dom.events.EventTarget;

import vista.*;
import controlador.*;
import modelo.*;
import sql.Consultas;
public class AdministradorController implements ActionListener, MouseListener, KeyListener{
	Administrador admin;
	
	Usuario u = new Usuario();
	EditarEmpresa EE = new EditarEmpresa();
	Consultas consulta = new Consultas();
	CrearEmpresa perfil = new CrearEmpresa();
	ModificarSlider MSlider = new ModificarSlider();
	CrearLocal CL = new CrearLocal();
	public AdministradorController(Administrador admin, Usuario u) {
	this.admin = admin;
	this.u = u;
	this.admin.btnCerrarSesion.addActionListener(this);
	this.admin.btnCrearEmpresa.addActionListener(this);
	this.admin.btnConsultarempresas.addActionListener(this);
	this.admin.btnCancelar.addActionListener(this);
	this.admin.btnEditar.addActionListener(this);
	this.admin.btnEliminar.addActionListener(this);
	this.admin.textBuscador.addKeyListener(this);
	this.admin.textBuscador.addMouseListener(this);
	this.admin.perfil.addMouseListener(this);
	this.admin.TablaEmpresas.addMouseListener(this);
	this.admin.btnModificarSlider.addActionListener(this);
	Ayudas.ActualizarNombre(u, admin);
	Ayudas.ActualizarEmpresas(admin);
	CrearLocalController CLC = new CrearLocalController(CL, admin);
	 EditarAdminController EAC =	new EditarAdminController(perfil, u, admin);
	 ModificarSliderController MSC = new ModificarSliderController(MSlider);
	 new EditarEmpresaController(EE, admin, u);
	 Ayudas.LLenarTablaEmpresas(admin.TablaEmpresas);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(admin.btnCerrarSesion)) {
			admin.setVisible(false);
			Index I = new Index();
			IndexController IC = new IndexController(I);
		
		}
		
		if(e.getSource().equals(admin.btnConsultarempresas)) {
			Ayudas.ActualizarPanel(admin.AdminPanel, perfil , admin.contentPane);//perfil
			Ayudas.ActualizarPanel(admin.AdminPanel, CL , admin.contentPane);//CrearEmpresa
			Ayudas.ActualizarPanel(admin.AdminPanel, EE , admin.contentPane);//EditarEmpresa
			Ayudas.ActualizarPanel(admin.AdminPanel, MSlider , admin.contentPane);
			admin.btnConsultarempresas.setVisible(false);
			admin.textBuscador.setVisible(true);
		}
		
		if(e.getSource().equals(admin.btnCrearEmpresa)) {
			admin.btnConsultarempresas.setVisible(true);
			Ayudas.ActualizarPanel(admin.AdminPanel, EE, admin.contentPane);
			Ayudas.ActualizarPanel(admin.AdminPanel, perfil, admin.contentPane);
			Ayudas.ActualizarPanel(admin.AdminPanel, MSlider , admin.contentPane);
			Ayudas.ActualizarPanel(CL, admin.AdminPanel , admin.contentPane);
			admin.textBuscador.setVisible(false);
			
		}
		
		if(e.getSource().equals(admin.btnModificarSlider)) {
			admin.btnConsultarempresas.setVisible(true);
			Ayudas.ActualizarPanel(admin.AdminPanel, CL , admin.contentPane);
			Ayudas.ActualizarPanel(admin.AdminPanel, EE, admin.contentPane);
			Ayudas.ActualizarPanel(admin.AdminPanel, perfil , admin.contentPane);
			Ayudas.ActualizarPanel(MSlider, admin.AdminPanel, admin.contentPane);
			admin.textBuscador.setVisible(false);
			
		}
		if(e.getSource().equals(admin.btnEditar)) {
			
			
			EE.btnSeleccionarLogo.setVisible(true);
			EE.btnSeleccionarLogo.setText("CAMBIAR LOGO");
			EE.lblImagen.setVisible(false);
			admin.btnConsultarempresas.setVisible(true);
			Ayudas.ActualizarPanel(admin.AdminPanel, perfil , admin.contentPane);//perfil
			Ayudas.ActualizarPanel(admin.AdminPanel, CL , admin.contentPane);
			Ayudas.ActualizarPanel(admin.AdminPanel, MSlider , admin.contentPane);
			Ayudas.ActualizarPanel(EE, admin.AdminPanel, admin.contentPane);
			JOptionPane.showMessageDialog(null, "Recuerda que NO es obligación \n cambiar la contraseña o el logo "
					+ "para editar una empresa");
			
		}
		if(e.getSource().equals(admin.btnCancelar)) {
			
			admin.lblpresionar.setText("PRESIONE UNA EMPRESA PARA MODIFICARLA");
			admin.btnCancelar.setVisible(false);
			admin.btnEliminar.setVisible(false);
			admin.btnEditar.setVisible(false);
		}
		if(e.getSource().equals(admin.btnEliminar)) {
			
			if(consulta.ElimiarUser(u) > 0) {
				consulta.EliminarTodosLosProductos(u);
				consulta.EliminarTodoCarritoUsuarios(u);
				consulta.EliminarTodoLDUsuarios(u);
				admin.lblpresionar.setText("PRESIONE UNA EMPRESA PARA MODIFICARLA");
				admin.btnCancelar.setVisible(false);
				admin.btnEliminar.setVisible(false);
				admin.btnEditar.setVisible(false);
				Ayudas.LLenarTablaEmpresas(admin.TablaEmpresas);
				Ayudas.ActualizarEmpresas(admin);
				JOptionPane.showMessageDialog(null, "EMPRESA ELIMINADA");
			}else {
				JOptionPane.showMessageDialog(null, "EMPRESA NO ELIMINADA");
			}
		}
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getSource().equals(admin.perfil)) {
			u.setId(admin.IdAdmin.getText());
			Ayudas.CagarDatosAdmin(perfil, u);
			admin.btnConsultarempresas.setVisible(true);
			Ayudas.ActualizarPanel(admin.AdminPanel, CL , admin.contentPane);
			Ayudas.ActualizarPanel(admin.AdminPanel, EE, admin.contentPane);
			Ayudas.ActualizarPanel(admin.AdminPanel, MSlider , admin.contentPane);
			Ayudas.ActualizarPanel(perfil, admin.AdminPanel, admin.contentPane);
			admin.textBuscador.setVisible(false);
		}
		if(e.getSource().equals(admin.textBuscador)) {
			
			admin.textBuscador.setText("");
		}
		
		if(e.getSource().equals(admin.TablaEmpresas)) {
		
		int row = admin.TablaEmpresas.getSelectedRow();
		String id = (String)  admin.TablaEmpresas.getValueAt(row, 0).toString();
		String nombre = (String) admin.TablaEmpresas.getValueAt(row, 1).toString();
		String correo = (String) admin.TablaEmpresas.getValueAt(row, 2).toString();
		String telefono = (String)  admin.TablaEmpresas.getValueAt(row, 3).toString();
		String nombrep = (String)  admin.TablaEmpresas.getValueAt(row, 4).toString();
		String cedula = (String)  admin.TablaEmpresas.getValueAt(row, 5).toString();
		String direccion = (String)  admin.TablaEmpresas.getValueAt(row, 6).toString();
		String logo = (String)  admin.TablaEmpresas.getValueAt(row, 7).toString();
		u.setId(id);
		u.setNombre(nombre);
		u.setNombreP(nombrep);
		u.setCorreo(correo);
		u.setTelefono(telefono);
		u.setCedula(cedula);
		u.setDireccion(direccion);
		u.setImagen(logo);
		
		EE.textNombreEmpresa.setText(nombre);
		EE.textNombrePropietario.setText(nombrep);;
		EE.textTelefono.setText(telefono);;
		EE.textCedulaPropietario.setText(cedula);;
		EE.textDireccion.setText(direccion);
		EE.textCorreo.setText(correo);
		
		
		admin.lblpresionar.setText("MODIFICAR EMPRESA: "+nombre +"");
		admin.btnCancelar.setVisible(true);
		admin.btnEliminar.setVisible(true);
		admin.btnEditar.setVisible(true);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
		
		if(e.getSource().equals(admin.textBuscador)) {
			
			if(admin.textBuscador.getText().equals("")) {
				
				Ayudas.LLenarTablaEmpresas(admin.TablaEmpresas);
			}
		}
		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
			
			if(consulta.EmpresaPorNombre(admin.TablaEmpresas, admin.textBuscador.getText()) || consulta.EmpresaPorID(admin.TablaEmpresas,admin.textBuscador.getText())) {
				
			}
			else {
		
		JOptionPane.showMessageDialog(null, "EMPRESA NO ENCONTRADA");
	}
		}
	}
	

	
}
