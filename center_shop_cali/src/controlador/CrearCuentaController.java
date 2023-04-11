package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Base64;

import javax.swing.JOptionPane;

import herramientas.AplicarValidacion;
import herramientas.Ayudas;
import modelo.Usuario;
import sql.Consultas;
import vista.CrearCuenta;
import vista.Index;
import vista.IniciarSesion;

public class CrearCuentaController implements KeyListener,MouseListener , ActionListener{
	CrearCuenta CC;
	Ayudas ayuda = new Ayudas();
	public CrearCuentaController (CrearCuenta CC) {
		this.CC = CC;
		this.CC.btnCrear.addActionListener(this);
		this.CC.btnTengoCuenta.addActionListener(this);
		this.CC.textNombre.addKeyListener(this);
		this.CC.textNumeroTelefono.addKeyListener(this);
		this.CC.textDia.addKeyListener(this);
		this.CC.textMes.addKeyListener(this);
		this.CC.textAño.addKeyListener(this);
		this.CC.textDia.addMouseListener(this);
		this.CC.textMes.addMouseListener(this);
		this.CC.textAño.addMouseListener(this);
		this.CC.textCorreo.addKeyListener(this);
		this.CC.textContrasena.addKeyListener(this);
		this.CC.textCContrasena.addKeyListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(CC.btnTengoCuenta)) {
			IniciarSesion iniciar = new IniciarSesion();
			new IniciarSesionController(iniciar);
			iniciar.setVisible(true);
			CC.dispose();
		}
		if(e.getSource().equals(CC.btnCrear)) {
			
			Usuario u = new Usuario();
			String nombre = CC.textNombre.getText();
			String telefono = CC.textNumeroTelefono.getText();
			String correo = CC.textCorreo.getText();
			String contrasena = String.valueOf(CC.textContrasena.getPassword());
			String ccontrasena = String.valueOf(CC.textCContrasena.getPassword());
			String dia = CC.textDia.getText();
			String mes = CC.textMes.getText();
			String año = CC.textAño.getText();
			u.setNombre(nombre);
			u.setTelefono(telefono);
			u.setCorreo(correo);
			u.setContrasena(contrasena);
			u.setDia(dia);
			u.setMes(mes);
			u.setAño(año);
			
			if(AplicarValidacion.NombreCrear(CC.textNombre.getText(), CC)|| AplicarValidacion.TelefonoCrear(CC.textNumeroTelefono.getText(), CC)
			||AplicarValidacion.FechaNacimientoCrear(CC.textDia.getText(), CC.textMes.getText(), CC.textAño.getText(), CC)||
			AplicarValidacion.FechaNacimientoCrear(CC.textDia.getText(), CC.textMes.getText(), CC.textAño.getText(), CC)||
				AplicarValidacion.FechaNacimientoCrear(CC.textDia.getText(), CC.textMes.getText(), CC.textAño.getText(), CC)||
				AplicarValidacion.CrearCorreo(CC.textCorreo.getText(), CC) ||AplicarValidacion.CrearContraseña(String.valueOf(CC.textContrasena.getPassword()), CC)||
				AplicarValidacion.CrearCContraseña(String.valueOf(CC.textCContrasena.getPassword()), CC)) {
				JOptionPane.showMessageDialog(null, "ERROR EN LOS CAMPOS");
			}else {
				
				if(contrasena.equals(ccontrasena)) {
					Consultas consulta = new Consultas();
					try {
						String cifrado = ayuda.Cifra(u.getContrasena());
						u.setContrasena(cifrado);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if(!consulta.ConsultarUsuario(u)) {
					if(consulta.InsertarUsuario(u)) {
						CC.textNombre.setText("");
						CC.textNumeroTelefono.setText("");
						CC.textCorreo.setText("");
						CC.textContrasena.setText("");
						CC.textCContrasena.setText("");
						CC.textDia.setText("");
						CC.textMes.setText("");
						CC.textAño.setText("");
						JOptionPane.showMessageDialog(null, "USUARIO CREADO CON EXITO");
					}
					else {
						JOptionPane.showMessageDialog(null, "HUBO UN PROBLEMA ");
					}}else {
						JOptionPane.showMessageDialog(null, "ESE USUARIO YA EXISTE");
					}
				}else {
					JOptionPane.showMessageDialog(null, "LAS CONTRASEÑAS NO COINCIDEN");
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
		if(e.getSource().equals(CC.textNombre)) {
			AplicarValidacion.NombreCrear(CC.textNombre.getText(), CC);
		}
		if(e.getSource().equals(CC.textNumeroTelefono)) {
			AplicarValidacion.TelefonoCrear(CC.textNumeroTelefono.getText(), CC);
		}
		if(e.getSource().equals(CC.textDia)) {
			AplicarValidacion.FechaNacimientoCrear(CC.textDia.getText(), CC.textMes.getText(), CC.textAño.getText(), CC);
		}
		if(e.getSource().equals(CC.textMes)) {
			AplicarValidacion.FechaNacimientoCrear(CC.textDia.getText(), CC.textMes.getText(), CC.textAño.getText(), CC);
		}
		if(e.getSource().equals(CC.textAño)) {
			AplicarValidacion.FechaNacimientoCrear(CC.textDia.getText(), CC.textMes.getText(), CC.textAño.getText(), CC);
		}
		if(e.getSource().equals(CC.textCorreo)) {
			AplicarValidacion.CrearCorreo(CC.textCorreo.getText(), CC);
		}
		if(e.getSource().equals(CC.textContrasena)) {
			AplicarValidacion.CrearContraseña(String.valueOf(CC.textContrasena.getPassword()), CC);
		}
		if(e.getSource().equals(CC.textCContrasena)) {
			AplicarValidacion.CrearCContraseña(String.valueOf(CC.textCContrasena.getPassword()), CC);
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getSource().equals(CC.textDia)) {
			CC.textDia.setText("");
		}
		if(e.getSource().equals(CC.textMes)) {
			CC.textMes.setText("");
		}
		if(e.getSource().equals(CC.textAño)) {
			CC.textAño.setText("");
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
}
