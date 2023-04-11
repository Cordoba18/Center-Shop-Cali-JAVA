package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.PasswordAuthentication;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;

import herramientas.AplicarValidacion;
import herramientas.Ayudas;
import herramientas.Email;
import modelo.Usuario;
import sql.Consultas;
import vista.IngresarCorreo;
import vista.IniciarSesion;
import vista.RecuperarContraseña;

public class IngresarCorreoController implements KeyListener, ActionListener{

	IngresarCorreo IC;
	RecuperarContraseña RC;
	Usuario u = new Usuario();
	public IngresarCorreoController (IngresarCorreo IC, RecuperarContraseña RC) {
		this.IC = IC;
		this.RC = RC;
		this.IC.btnSiguiente.addActionListener(this);
		this.IC.btnVolver.addActionListener(this);
		this.IC.textCorreo.addKeyListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(IC.btnVolver)) {
			RC.dispose();
			IniciarSesion iniciar = new IniciarSesion();
			iniciar.setVisible(true);
			new IniciarSesionController(iniciar);
		}
		
		if(e.getSource().equals(IC.btnSiguiente)) {
			
			String correo = IC.textCorreo.getText();
			u.setCorreo(correo);
			u.setImagen("ZapatillasRikas.png");
			
			if(AplicarValidacion.IngresarCorreoRecuperar(correo, IC)) {
				JOptionPane.showMessageDialog(null, "ERROR EN EL CORREO");
			}else {
				Consultas consulta = new Consultas();
				if(!consulta.ConfirmarExistenciaUsuario(u)) {
					JOptionPane.showMessageDialog(null, "ESE USUARIO NO EXISTE");
				}else {
					
					  List <String> Codigo  = new ArrayList<>();
						for (int i = 0; i < 6; i++) {
							  Random dato = new Random();
						        int num = (dato.nextInt(9));
						        String carac = String.valueOf(num);
						       Codigo.add(carac);
						}
						
						String codigofinal = Codigo.get(0) + Codigo.get(1) + Codigo.get(2) + Codigo.get(3) + Codigo.get(4)+ Codigo.get(5);
				
					
						try {
				            Email m = new Email("config/configuracion.prop");

				            
				            String correos[] = {"jccq12@gmail.com", correo};
				            
				            m.enviarEmail("Test", codigofinal, correos);

				            System.out.println("Se ha enviado!!");
				        } catch (InvalidParameterException | IOException | MessagingException ex) {
				            System.out.println(ex.getMessage());
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
		
		if(e.getSource().equals(IC.textCorreo)) {
			AplicarValidacion.IngresarCorreoRecuperar(IC.textCorreo.getText(), IC);
			
		}
		
	}
//	private boolean MandarCorreo() {
//		try {
//			
//		Ayudas ayuda = new Ayudas();
//		 Properties props = new Properties();
//	        props.put("mail.smtp.host", "smtp.gmail.com");
//	        props.setProperty("mail.smtp.starttls.enable", "true");
//	        props.setProperty("mail.smtp.port", "587");
//	        props.setProperty("mail.smtp.user", u.getCorreo());
//	        props.setProperty("mail.smtp.autj", "true");
//	        Session s = Session.getDefaultInstance(props, null);
//	        BodyPart texto = new MimeBodyPart();
//	        List <String> Codigo  = new ArrayList<>();
//			for (int i = 0; i < 6; i++) {
//				  Random dato = new Random();
//			        int num = (dato.nextInt(9));
//			        String carac = String.valueOf(num);
//			       Codigo.add(carac);
//			}
//			
//			String codigofinal = Codigo.get(0) + Codigo.get(1) + Codigo.get(2) + Codigo.get(3) + Codigo.get(4)+ Codigo.get(5);
//	        texto.setText(codigofinal);
//	        BodyPart adjunto = new MimeBodyPart();
//	        MimeMultipart m = new MimeMultipart();
//	        m.addBodyPart(texto);
//	         MimeMessage mensaje = new MimeMessage(s);
//	         mensaje.setFrom(new InternetAddress("jccq12@gmail.com"));
//	         mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(u.getCorreo()));
//	         mensaje.setContent(m);
//	         mensaje.setSubject(adjunto.getContentType());
//	         
//	         Transport t = s.getTransport("smtp");
//	         try {
//				t.connect(u.getCorreo(),ayuda.descifrar(u.getContrasena()));
//			} catch (InvalidKeyException | UnsupportedEncodingException | NoSuchAlgorithmException
//					| NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException | MessagingException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//	         t.sendMessage(mensaje, mensaje.getAllRecipients());
//	         t.close();
//	         return true;
//	} catch (Exception e) {
//		return false;
//	}
//		
//	}


}
