package controlador;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import herramientas.Ayudas;
import modelo.Usuario;
import sql.Consultas;
import vista.CrearProducto;
import vista.EditarProducto;
import vista.Index;
import vista.PerfilEmpresa;
import vista.TallasYColores;

public class PerfilEmpresaController implements ActionListener, KeyListener, MouseListener{

	PerfilEmpresa Empresa;
	Usuario u = new Usuario();
	CrearProducto CP = new CrearProducto();
	EditarProducto EP = new EditarProducto();
	TallasYColores TC = new TallasYColores();
	public PerfilEmpresaController (PerfilEmpresa Empresa, Usuario u) {
		this.Empresa = Empresa;
		this.u = u;
		this.Empresa.btnCerrarSesion.addActionListener(this);
		this.Empresa.btnCrearProductos.addActionListener(this);
		this.Empresa.btnConsultarProductos.addActionListener(this);
		this.Empresa.textBuscador.addKeyListener(this);
		this.Empresa.textBuscador.addMouseListener(this);
		this.Empresa.TablaProductos.addMouseListener(this);
		this.Empresa.btnCancelar.addActionListener(this);
		this.Empresa.btnEditar.addActionListener(this);
		this.Empresa.btnEliminar.addActionListener(this);
		this.Empresa.btnTallasColores.addActionListener(this);
		Ayudas.ActualizarPerfilEmpresa(u, Empresa);
		Ayudas.LLenarTablaProductos(Empresa.TablaProductos, u);
		Ayudas.ActualizarProductos(Empresa, u);
		new CrearProductoController(CP, Empresa);
		new EditarProductoController(EP, Empresa);
		new TallasYColoresController(TC, Empresa, u);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(Empresa.btnCerrarSesion)) {
			Empresa.setVisible(false);
			Index I = new Index();
			IndexController IC = new IndexController(I);
		}
		
		if(e.getSource().equals(Empresa.btnTallasColores)) {
			
			Ayudas.ActualizarPanel( TC, Empresa.EmpresaPanel , Empresa.contentPane);
			Ayudas.ActualizarPanel( TC , EP , Empresa.contentPane);
			Ayudas.ActualizarPanel( TC , CP , Empresa.contentPane);
			Empresa.textBuscador.setVisible(false);
			Empresa.btnConsultarProductos.setVisible(true);
			u.setId_producto(Empresa.ID_Producto.getText());
			u.setId_empresa(Empresa.ID_Empresa.getText());
			Ayudas.LLenarTablaColores(TC, u);
			Ayudas.LLenarTablaTallas(TC, u);
			
		}
		
		if(e.getSource().equals(Empresa.btnCrearProductos)) {
			
			Ayudas.ActualizarPanel( CP, Empresa.EmpresaPanel , Empresa.contentPane);
			Ayudas.ActualizarPanel( CP, TC , Empresa.contentPane);
			Ayudas.ActualizarPanel( CP, EP , Empresa.contentPane);
			CP.btnSeleccionarImagen.setVisible(true);
			CP.btnSeleccionarImagen.setText("SELECCIONAR IMAGEN");
			Empresa.btnConsultarProductos.setVisible(true);
			Empresa.textBuscador.setVisible(false);
		}
		
		if(e.getSource().equals(Empresa.btnConsultarProductos)) {
			Ayudas.ActualizarPanel( Empresa.EmpresaPanel, CP , Empresa.contentPane);
			Ayudas.ActualizarPanel( Empresa.EmpresaPanel, EP , Empresa.contentPane);
			Ayudas.ActualizarPanel( Empresa.EmpresaPanel, TC , Empresa.contentPane);//EditarEmpresa
			Empresa.btnConsultarProductos.setVisible(false);
			Empresa.textBuscador.setVisible(true);
			EP.btnSeleccionarImagen.setVisible(true);
			EP.btnSeleccionarImagen.setText("CAMBIAR IMAGEN PRINCIPAL");
		}
		
		if(e.getSource().equals(Empresa.btnCancelar)) {
			
			Empresa.lblpresionar.setText("PRESIONE UN PRODUCTO PARA MODIFICARLO");
			Empresa.btnCancelar.setVisible(false);
			Empresa.btnEliminar.setVisible(false);
			Empresa.btnEditar.setVisible(false);
			Empresa.btnTallasColores.setVisible(false);
		}
		
		if(e.getSource().equals(Empresa.btnEliminar)) {
			Consultas consulta = new Consultas();
			consulta.EliminarProducto(u);
			consulta.EliminarImagenesProductos(u);
			consulta.EliminarProductoDelosCarritos(u);
			consulta.EliminarProductoDelasLD(u);
				JOptionPane.showMessageDialog(null, "PRODUCTO ELIMINADO");
				Empresa.lblpresionar.setText("PRESIONE UN PRODUCTO PARA MODIFICARLO");
				Empresa.btnCancelar.setVisible(false);
				Empresa.btnEliminar.setVisible(false);
				Empresa.btnEditar.setVisible(false);
				Empresa.btnTallasColores.setVisible(false);
				Ayudas.LLenarTablaProductos(Empresa.TablaProductos, u);
				Ayudas.ActualizarProductos(Empresa, u);
			
		}
		if(e.getSource().equals(Empresa.btnEditar)) {
			Empresa.btnConsultarProductos.setVisible(true);
			Ayudas.ActualizarPanel( EP, Empresa.EmpresaPanel , Empresa.contentPane);
			Empresa.textBuscador.setVisible(false);
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {

		if(e.getSource().equals(Empresa.TablaProductos)) {
			
			int row = Empresa.TablaProductos.getSelectedRow();
			String id = (String)  Empresa.TablaProductos.getValueAt(row, 0).toString();
			String nombre = (String) Empresa.TablaProductos.getValueAt(row, 1).toString();
			String precio = (String) Empresa.TablaProductos.getValueAt(row, 2).toString();
			String descuento = (String)  Empresa.TablaProductos.getValueAt(row, 3).toString();
			String descripcion = (String)  Empresa.TablaProductos.getValueAt(row, 4).toString();
			String categoria = (String)  Empresa.TablaProductos.getValueAt(row, 7).toString();
			Empresa.ID_Producto.setText(id);
			u.setId(id);
			u.setNombre(nombre);
			u.setPrecio(precio);
			u.setDescuento(descuento);
			u.setDescripcion(descripcion);
			u.setCategoria(categoria);
			Empresa.lblpresionar.setText("MODIFICAR PRODUCTO :  '"+nombre +"'");
			Empresa.btnCancelar.setVisible(true);
			Empresa.btnEliminar.setVisible(true);
			Empresa.btnEditar.setVisible(true);
			Empresa.btnTallasColores.setVisible(true);
			
			EP.textNombreProducto.setText(nombre);
			EP.textPrecio.setText(precio);
			EP.textDescuento.setText(descuento);
			EP.textDescripcion.setText(descripcion);
			EP.categorias.removeAll();
			DefaultComboBoxModel model = new DefaultComboBoxModel();
			EP.categorias.setModel(model);
			Consultas consulta = new Consultas();
			consulta.Categoria(u);
			EP.categorias.addItem(u.getCategoria());
			
			
		}
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		
		if(e.getSource().equals(Empresa.textBuscador)) {
			
			Empresa.textBuscador.setText("");
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
		
		Consultas consulta = new Consultas();
		u.setNombre(Empresa.textBuscador.getText());
		u.setId_producto(Empresa.textBuscador.getText());
		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
			
			if(consulta.ProductosPorNombre(Empresa.TablaProductos, u) || consulta.ProductosPorId(Empresa.TablaProductos, u)) {
				
			}
			else {
		
		JOptionPane.showMessageDialog(null, "PRODUCTO NO ENCONTRADO");
	}
}
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		
		if(e.getSource().equals(Empresa.textBuscador)) {
			
			if(Empresa.textBuscador.getText().isEmpty()) {
				
				Ayudas.LLenarTablaProductos(Empresa.TablaProductos, u);
				
			}
		}
	}
	
	
}
