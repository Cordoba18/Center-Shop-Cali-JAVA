package herramientas;

import java.awt.Image;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.DriverManager;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.sound.midi.Patch;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;



import modelo.Usuario;
import sql.Consultas;
import vista.Administrador;
import vista.CrearEmpresa;
import vista.ModificarImagenes;
import vista.PerfilEmpresa;
import vista.TallasYColores;

public class Ayudas {

	
	public static void ActualizarPanel(JPanel Panel, JPanel quitar, JPanel PanelPrincipal) {
		PanelPrincipal.remove(quitar);
		PanelPrincipal.add(Panel);
		PanelPrincipal.repaint();
		PanelPrincipal.revalidate();
	}
	
	public static void ActualizarPanelFacil(JPanel Agregar, JPanel PanelPrincipal) {
		PanelPrincipal.removeAll();
		PanelPrincipal.add(Agregar);
		PanelPrincipal.repaint();
		PanelPrincipal.revalidate();
	}
	
	private SecretKeySpec crearClave(String clave) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        byte[] claveEncriptacion = clave.getBytes("UTF-8");
        
        MessageDigest sha = MessageDigest.getInstance("SHA-1");
        
        claveEncriptacion = sha.digest(claveEncriptacion);
        claveEncriptacion = Arrays.copyOf(claveEncriptacion, 16);
        
        SecretKeySpec secretKey = new SecretKeySpec(claveEncriptacion, "AES");

        return secretKey;
    }

    /**
     * Aplica la encriptacion AES a la cadena de texto usando la clave indicada
     * @param datos Cadena a encriptar
     * @param claveSecreta Clave para encriptar
     * @return Información encriptada
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws NoSuchPaddingException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException 
     */
    public String Cifra(String datos) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        SecretKeySpec secretKey = this.crearClave(datos);
        
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");        
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        byte[] datosEncriptar = datos.getBytes("UTF-8");
        byte[] bytesEncriptados = cipher.doFinal(datosEncriptar);
        String encriptado = Base64.getEncoder().encodeToString(bytesEncriptados);

        return encriptado;
    }
    

    /**
     * Aplica la encriptacion AES a la cadena de texto usando la clave indicada
     * @param datos Cadena a encriptar
     * @param claveSecreta Clave para encriptar
     * @return Información encriptada
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws NoSuchPaddingException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException 
     */


    public static String obtenerFechaYHoraActual() {
    	String formato = "yyyy-MM-dd_HH_mm_ss";
    	DateTimeFormatter formateador = DateTimeFormatter.ofPattern(formato);
    	LocalDateTime ahora = LocalDateTime.now();
    	return formateador.format(ahora);
    }
   
    /**
     * Desencripta la cadena de texto indicada usando la clave de encriptacion
     * @param datosEncriptados Datos encriptados
     * @param claveSecreta Clave de encriptacion
     * @return Informacion desencriptada
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws NoSuchPaddingException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException 
     */
    public String descifrar(String clave, String datosEncriptados) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        SecretKeySpec secretKey = this.crearClave(clave);

        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        
        byte[] bytesEncriptados = Base64.getDecoder().decode(datosEncriptados);
        byte[] datosDesencriptados = cipher.doFinal(bytesEncriptados);
        String datos = new String(datosDesencriptados);
        
        return datos;
    }

	
//	public byte[] cifra(String sinCifrar) throws Exception {
//		final byte[] bytes = sinCifrar.getBytes("UTF-8");
//		final Cipher aes = obtieneCipher(true);
//		final byte[] cifrado = aes.doFinal(bytes);
//		return cifrado;
//	}
//
//	public String descifra(byte[] cifrado) throws Exception {
//		final Cipher aes = obtieneCipher(false);
//		final byte[] bytes = aes.doFinal(cifrado);
//		final String sinCifrar = new String(bytes, "UTF-8");
//		return sinCifrar;
//	}
////	try {
////		String cifrado = Base64.getEncoder().encodeToString(a.cifra(I.textBuscador.getText()));
////		System.out.println(cifrado);;
////	} catch (Exception e1) {
////		// TODO Auto-generated catch block
////		e1.printStackTrace();
////	}
////	try {
////		String descifrado = a.descifra(a.cifra(I.textBuscador.getText()));
////		System.out.println(descifrado);
////	} catch (Exception e1) {
////		// TODO Auto-generated catch block
////		e1.printStackTrace();
////	}
//
//	private Cipher obtieneCipher(boolean paraCifrar) throws Exception {
//		final String frase = "FraseLargaConDiferentesLetrasNumerosYCaracteresEspeciales_áÁéÉíÍóÓúÚüÜñÑ1234567890!#%$&()=%_NO_USAR_ESTA_FRASE!_";
//		final MessageDigest digest = MessageDigest.getInstance("SHA");
//		digest.update(frase.getBytes("UTF-8"));
//		final SecretKeySpec key = new SecretKeySpec(digest.digest(), 0, 16, "AES");
//
//		final Cipher aes = Cipher.getInstance("AES/ECB/PKCS5Padding");
//		if (paraCifrar) {
//			aes.init(Cipher.ENCRYPT_MODE, key);
//		} else {
//			aes.init(Cipher.DECRYPT_MODE, key);
//		}
//
//		return aes;
//	}
	public static  void ActualizarNombre(Usuario u, Administrador admin) {
		admin.lblNombreAdmin.setText(u.getNombre());
	}
	
	public static  void ActualizarPerfilEmpresa(Usuario u, PerfilEmpresa Empresa) {
		Empresa.lblNombrerEmpresa.setText(u.getNombre());
		Empresa.ID_Empresa.setText(u.getId_empresa());
		ImageIcon image = new ImageIcon("images//" + u.getImagen());
		Icon icon = new ImageIcon(image.getImage().getScaledInstance(Empresa.lblImagenEmpresa.getWidth(), Empresa.lblImagenEmpresa.getHeight(), Image.SCALE_DEFAULT));
		Empresa.lblImagenEmpresa.setIcon(icon);
		Empresa.lblImagenEmpresa.repaint();
		
	}
	public static void ActualizarProductos(PerfilEmpresa PE, Usuario u) {
		Consultas consulta = new Consultas();
		consulta.ProductosTotales(u);
		PE.textE_totales.setText(String.valueOf(u.getProductos()));
		
	}
	public static void ActualizarEmpresas(Administrador admin) {
		Usuario u = new Usuario();
		Consultas consulta = new Consultas();
		consulta.EmpresasTotales(u);
		admin.textE_totales.setText(String.valueOf(u.getE_empresa()));
		
	}
	
	public static void LLenarTablaEmpresas(JTable tabla) {
		Consultas consulta = new Consultas();
		consulta.Empresas(tabla);
	}
	
	public static void LLenarTablaImagenes(ModificarImagenes MI, Usuario u) {
		Consultas consulta = new Consultas();
		consulta.CargarImagenes(MI, u);
	}
	

	
	public static void LLenarTablaProductos(JTable tabla, Usuario u) {
		Consultas consulta = new Consultas();
		consulta.Productos(tabla, u);
	}
	
	public static void LLenarTablaTallas(TallasYColores TC, Usuario u) {
		Consultas consulta = new Consultas();
		consulta.CargarTallas(TC, u);
	}
	
	public static void LLenarTablaColores(TallasYColores TC, Usuario u) {
		Consultas consulta = new Consultas();
		consulta.CargarColores(TC, u);
	}
	public static void CagarDatosAdmin(CrearEmpresa EE, Usuario u) {
		Consultas consulta = new Consultas();
		consulta.CargarDatosAdmin(u);
		EE.textNombre.setText(u.getNombre());
		EE.textCorreo.setText(u.getCorreo());
	}
	

}
