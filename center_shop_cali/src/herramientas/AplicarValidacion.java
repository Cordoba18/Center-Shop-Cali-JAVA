package herramientas;

import vista.*;

public class AplicarValidacion {

	public static boolean LoginCorreo (String texto, IniciarSesion login) {
		if((Validaciones.vacio(texto))) {
			login.lblErrorCorreo.setText("RELLENE EL CAMPO");
			login.lblErrorCorreo.setVisible(true);
			return true;
		}else if((Validaciones.validarCorreo(texto))) {
			login.lblErrorCorreo.setText("ESCRIBE UN CORREO VALIDO");
			login.lblErrorCorreo.setVisible(true);
			return true;
		}
		else if(Validaciones.CantidadCorreo(texto)){
			login.lblErrorCorreo.setText("ESCRIBE MENOS CARACTERES");
			login.lblErrorCorreo.setVisible(true);
			return true;
		}
		else {
			login.lblErrorCorreo.setVisible(false);
		return false;}
	
	}
	//if(Validaciones.vacio(texto) || Validaciones.cantidadcontraseña(texto) || Validaciones.validarContraseña(texto)) {
	
	public static boolean LoginContraseña (String texto, IniciarSesion login) {
		if(Validaciones.vacio(texto)) {
			login.lblErrorContrasena.setText("CAMPO VACIO");
			login.lblErrorContrasena.setVisible(true);;
			return true;
		}
		else if(Validaciones.cantidadcontraseña(texto)) {
			login.lblErrorContrasena.setText("LA CONTRASEÑA ES DE 8 CARACTERES");
			login.lblErrorContrasena.setVisible(true);;
			return true;
		}
		else if(Validaciones.validarContraseña(texto)) {
			login.lblErrorContrasena.setText("NO ESCRIBAS CARACTERES ESPECIALES");
			login.lblErrorContrasena.setVisible(true);;
			return true;
		}
		else {
			login.lblErrorContrasena.setVisible(false);;
		return false;}
	}
	
	//------------------------------------------------------------EDITAR ADMIN--------------------------------------------------------
	
	public static boolean NombreEditar (String texto, CrearEmpresa EE) {
		if(Validaciones.vacio(texto)) {
			EE.lblErrorNombre.setText("RELLENE EL CAMPO");
			EE.lblErrorNombre.setVisible(true);;
			return true;
		}
		else if(Validaciones.SoloLetras(texto)) {
			EE.lblErrorNombre.setText("NO SE PERMITEN NUMEROS");
			EE.lblErrorNombre.setVisible(true);;
			return true;
		}
		else {
			EE.lblErrorNombre.setVisible(false);;
		return false;}
	}
	public static boolean CorreoEditar (String texto, CrearEmpresa EE) {
		if((Validaciones.vacio(texto))) {
			EE.lblErrorCorreo.setText("RELLENE EL CAMPO");
			EE.lblErrorCorreo.setVisible(true);
			return true;
		}else if((Validaciones.validarCorreo(texto))) {
			EE.lblErrorCorreo.setText("ESCRIBE UN CORREO VALIDO");
			EE.lblErrorCorreo.setVisible(true);
			return true;
		}
		else if(Validaciones.CantidadCorreo(texto)){
			EE.lblErrorCorreo.setText("ESCRIBE MENOS CARACTERES");
			EE.lblErrorCorreo.setVisible(true);
			return true;
		}
		else {
			EE.lblErrorCorreo.setVisible(false);
		return false;}
	
	}
	public static boolean ContraseñaAcEditar (String texto,  CrearEmpresa EE) {
		if(Validaciones.vacio(texto)) {
			EE.lblErrorContrasenaA.setText("RELLENE EL CAMPO");
			EE.lblErrorContrasenaA.setVisible(true);;
			return true;
		}
		else if(Validaciones.cantidadcontraseña(texto)) {
			EE.lblErrorContrasenaA.setText("LA CONTRASEÑA ES DE 8 CARACTERES");
			EE.lblErrorContrasenaA.setVisible(true);;
			return true;
		}
		else if(Validaciones.validarContraseña(texto)) {
			EE.lblErrorContrasenaA.setText("NO ESCRIBAS CARACTERES ESPECIALES");
			EE.lblErrorContrasenaA.setVisible(true);;
			return true;
		}
		else {
			EE.lblErrorContrasenaA.setVisible(false);;
		return false;}
	}
	public static boolean ContraseñaNueEditar (String texto,  CrearEmpresa EE) {
		if(Validaciones.vacio(texto)) {
			EE.lblErrorContrasenaN.setText("RELLENE EL CAMPO");
			EE.lblErrorContrasenaN.setVisible(true);;
			return true;
		}
		else if(Validaciones.cantidadcontraseña(texto)) {
			EE.lblErrorContrasenaN.setText("LA CONTRASEÑA ES DE 8 CARACTERES");
			EE.lblErrorContrasenaN.setVisible(true);;
			return true;
		}
		else if(Validaciones.validarContraseña(texto)) {
			EE.lblErrorContrasenaN.setText("NO ESCRIBAS CARACTERES ESPECIALES");
			EE.lblErrorContrasenaN.setVisible(true);;
			return true;
		}
		else {
			EE.lblErrorContrasenaN.setVisible(false);;
		return false;}
	}
	//-------------------------------------------------------------------CREAR EMPRESA---------------------------------------------------------
	public static boolean NombreLocal (String texto, CrearLocal CL) {
		if(Validaciones.vacio(texto)) {
			CL.lblErrorNombre.setText("RELLENE EL CAMPO");
			CL.lblErrorNombre.setVisible(true);;
			return true;
		}
		else if(Validaciones.SoloLetras(texto)) {
			CL.lblErrorNombre.setText("NO SE PERMITEN NUMEROS");
			CL.lblErrorNombre.setVisible(true);;
			return true;
		}
		else {
			CL.lblErrorNombre.setVisible(false);;
		return false;}
	}
	public static boolean CorreoCrear (String texto, CrearLocal CL) {
		if((Validaciones.vacio(texto))) {
			CL.lblErrorCorreo.setText("RELLENE EL CAMPO");
			CL.lblErrorCorreo.setVisible(true);
			return true;
		}else if((Validaciones.validarCorreo(texto))) {
			CL.lblErrorCorreo.setText("ESCRIBE UN CORREO VALIDO");
			CL.lblErrorCorreo.setVisible(true);
			return true;
		}
		else if(Validaciones.CantidadCorreo(texto)){
			CL.lblErrorCorreo.setText("ESCRIBE MENOS CARACTERES");
			CL.lblErrorCorreo.setVisible(true);
			return true;
		}
		else {
			CL.lblErrorCorreo.setVisible(false);
		return false;}
	
	}
	public static boolean ContraseñaCrear (String texto, CrearLocal CL) {
		if(Validaciones.vacio(texto)) {
			CL.lblErrorContrasena.setText("RELLENE EL CAMPO");
			CL.lblErrorContrasena.setVisible(true);;
			return true;
		}
		else if(Validaciones.cantidadcontraseña(texto)) {
			CL.lblErrorContrasena.setText("LA CONTRASEÑA ES DE 8 CARACTERES");
			CL.lblErrorContrasena.setVisible(true);;
			return true;
		}
		else if(Validaciones.validarContraseña(texto)) {
			CL.lblErrorContrasena.setText("NO ESCRIBAS CARACTERES ESPECIALES");
			CL.lblErrorContrasena.setVisible(true);;
			return true;
		}
		else {
			CL.lblErrorContrasena.setVisible(false);;
		return false;}
	}
	public static boolean ContraseñaConfirmar (String texto,  CrearLocal CL) {
		if(Validaciones.vacio(texto)) {
			CL.lblErrorCContrasena.setText("RELLENE EL CAMPO");
			CL.lblErrorCContrasena.setVisible(true);;
			return true;
		}
		else if(Validaciones.cantidadcontraseña(texto)) {
			CL.lblErrorCContrasena.setText("LA CONTRASEÑA ES DE 8 CARACTERES");
			CL.lblErrorCContrasena.setVisible(true);;
			return true;
		}
		else if(Validaciones.validarContraseña(texto)) {
			CL.lblErrorCContrasena.setText("NO ESCRIBAS CARACTERES ESPECIALES");
			CL.lblErrorCContrasena.setVisible(true);;
			return true;
		}
		else {
			CL.lblErrorCContrasena.setVisible(false);;
		return false;}
	}

	public static boolean NombrePropietario (String texto, CrearLocal CL) {
		if(Validaciones.vacio(texto)) {
			CL.lblErrorNP.setText("RELLENE EL CAMPO");
			CL.lblErrorNP.setVisible(true);;
			return true;
		}
		else if(Validaciones.SoloLetras(texto)) {
			CL.lblErrorNP.setText("NO SE PERMITEN NUMEROS");
			CL.lblErrorNP.setVisible(true);;
			return true;
		}
		else {
			CL.lblErrorNP.setVisible(false);;
		return false;}
	}
	
	public static boolean CedulaPropietario (String texto, CrearLocal CL) {
		if(Validaciones.vacio(texto)) {
			CL.lblErrorCP.setText("RELLENE EL CAMPO");
			CL.lblErrorCP.setVisible(true);;
			return true;
		}
		else if(Validaciones.SoloNum(texto)) {
			CL.lblErrorCP.setText("NO SE PERMITEN LETRAS");
			CL.lblErrorCP.setVisible(true);;
			return true;
		}else if(Validaciones.CantidadCedula(texto)) {
			CL.lblErrorCP.setText("LA CANTIDAD DE LA CEDULA NO ES VALIDA");
			CL.lblErrorCP.setVisible(true);;
			return true;
		}
		else {
			CL.lblErrorCP.setVisible(false);;
		return false;}
	}
	public static boolean TelefonoCrear (String texto, CrearLocal CL) {
		if(Validaciones.vacio(texto)) {
			CL.lblErrorTelefono.setText("RELLENE EL CAMPO");
			CL.lblErrorTelefono.setVisible(true);;
			return true;
		}
		else if(Validaciones.SoloNum(texto)) {
			CL.lblErrorTelefono.setText("NO SE PERMITEN LETRAS");
			CL.lblErrorTelefono.setVisible(true);;
			return true;
		}else if(Validaciones.CantidadTelefono(texto)) {
			CL.lblErrorTelefono.setText("ESCRIBE UN # DE TELEFONO VALIDO");
			CL.lblErrorTelefono.setVisible(true);;
			return true;
		}
		else {
			CL.lblErrorTelefono.setVisible(false);;
		return false;}
	}
	
	
	public static boolean Dirrecion (String texto,String texto2 , String texto3, CrearLocal CL) {
		if(Validaciones.vacio(texto) || Validaciones.vacio(texto2) || Validaciones.vacio(texto3)) {
			CL.lblErrorDirrecion.setText("ESCRIBA UNA DIRECCIÓN VALIDA");
			CL.lblErrorDirrecion.setVisible(true);;
			return true;
		}
		else if(Validaciones.Dirrecion(texto)|| Validaciones.Dirrecion(texto2) || Validaciones.Dirrecion(texto3)) {
			CL.lblErrorDirrecion.setText("NO SE PERMITEN CARACTERES ESPECIALES");
			CL.lblErrorDirrecion.setVisible(true);;
			return true;
		}else if(Validaciones.CantidadDireccion(texto) || Validaciones.CantidadDireccion(texto2) || Validaciones.CantidadDireccion(texto3)) {
			CL.lblErrorDirrecion.setText("LA CANTIDAD DE CARACTERES NO ES VALIDA");
			CL.lblErrorDirrecion.setVisible(true);;
			return true;
		}
		else {
			CL.lblErrorDirrecion.setVisible(false);;
		return false;}
	}
	
	//--------------------------------------------EditarEmpresa--------------------------------------------------------------------
	public static boolean NombreLocalEditar (String texto, EditarEmpresa CL) {
		if(Validaciones.vacio(texto)) {
			CL.lblErrorNombre.setText("RELLENE EL CAMPO");
			CL.lblErrorNombre.setVisible(true);;
			return true;
		}
		else if(Validaciones.SoloLetras(texto)) {
			CL.lblErrorNombre.setText("NO SE PERMITEN NUMEROS");
			CL.lblErrorNombre.setVisible(true);;
			return true;
		}
		else {
			CL.lblErrorNombre.setVisible(false);;
		return false;}
	}
	public static boolean CorreoEditar (String texto, EditarEmpresa CL) {
		if((Validaciones.vacio(texto))) {
			CL.lblErrorCorreo.setText("RELLENE EL CAMPO");
			CL.lblErrorCorreo.setVisible(true);
			return true;
		}else if((Validaciones.validarCorreo(texto))) {
			CL.lblErrorCorreo.setText("ESCRIBE UN CORREO VALIDO");
			CL.lblErrorCorreo.setVisible(true);
			return true;
		}
		else if(Validaciones.CantidadCorreo(texto)){
			CL.lblErrorCorreo.setText("ESCRIBE MENOS CARACTERES");
			CL.lblErrorCorreo.setVisible(true);
			return true;
		}
		else {
			CL.lblErrorCorreo.setVisible(false);
		return false;}
	
	}
	public static boolean ContraseñaEditar (String texto, EditarEmpresa CL) {
		if(Validaciones.vacio(texto)) {
			CL.lblErrorContrasena.setText("RELLENE EL CAMPO");
			CL.lblErrorContrasena.setVisible(true);;
			return true;
		}
		else if(Validaciones.cantidadcontraseña(texto)) {
			CL.lblErrorContrasena.setText("LA CONTRASEÑA ES DE 8 CARACTERES");
			CL.lblErrorContrasena.setVisible(true);;
			return true;
		}
		else if(Validaciones.validarContraseña(texto)) {
			CL.lblErrorContrasena.setText("NO ESCRIBAS CARACTERES ESPECIALES");
			CL.lblErrorContrasena.setVisible(true);;
			return true;
		}
		else {
			CL.lblErrorContrasena.setVisible(false);;
		return false;}
	}
	public static boolean ContraseñaConfirmarEditar (String texto,  EditarEmpresa CL) {
		if(Validaciones.vacio(texto)) {
			CL.lblErrorCContrasena.setText("RELLENE EL CAMPO");
			CL.lblErrorCContrasena.setVisible(true);;
			return true;
		}
		else if(Validaciones.cantidadcontraseña(texto)) {
			CL.lblErrorCContrasena.setText("LA CONTRASEÑA ES DE 8 CARACTERES");
			CL.lblErrorCContrasena.setVisible(true);;
			return true;
		}
		else if(Validaciones.validarContraseña(texto)) {
			CL.lblErrorCContrasena.setText("NO ESCRIBAS CARACTERES ESPECIALES");
			CL.lblErrorCContrasena.setVisible(true);;
			return true;
		}
		else {
			CL.lblErrorCContrasena.setVisible(false);;
		return false;}
	}

	public static boolean NombrePropietarioEditar (String texto, EditarEmpresa CL) {
		if(Validaciones.vacio(texto)) {
			CL.lblErrorNP.setText("RELLENE EL CAMPO");
			CL.lblErrorNP.setVisible(true);;
			return true;
		}
		else if(Validaciones.SoloLetras(texto)) {
			CL.lblErrorNP.setText("NO SE PERMITEN NUMEROS");
			CL.lblErrorNP.setVisible(true);;
			return true;
		}
		else {
			CL.lblErrorNP.setVisible(false);;
		return false;}
	}
	
	public static boolean CedulaPropietarioEditar (String texto, EditarEmpresa CL) {
		if(Validaciones.vacio(texto)) {
			CL.lblErrorCP.setText("RELLENE EL CAMPO");
			CL.lblErrorCP.setVisible(true);;
			return true;
		}
		else if(Validaciones.SoloNum(texto)) {
			CL.lblErrorCP.setText("NO SE PERMITEN LETRAS");
			CL.lblErrorCP.setVisible(true);;
			return true;
		}else if(Validaciones.CantidadCedula(texto)) {
			CL.lblErrorCP.setText("LA CANTIDAD DE LA CEDULA NO ES VALIDA");
			CL.lblErrorCP.setVisible(true);;
			return true;
		}
		else {
			CL.lblErrorCP.setVisible(false);;
		return false;}
	}
	public static boolean TelefonoEditar (String texto,EditarEmpresa CL) {
		if(Validaciones.vacio(texto)) {
			CL.lblErrorTelefono.setText("RELLENE EL CAMPO");
			CL.lblErrorTelefono.setVisible(true);;
			return true;
		}
		else if(Validaciones.SoloNum(texto)) {
			CL.lblErrorTelefono.setText("NO SE PERMITEN LETRAS");
			CL.lblErrorTelefono.setVisible(true);;
			return true;
		}else if(Validaciones.CantidadTelefono(texto)) {
			CL.lblErrorTelefono.setText("ESCRIBE UN # DE TELEFONO VALIDO");
			CL.lblErrorTelefono.setVisible(true);;
			return true;
		}
		else {
			CL.lblErrorTelefono.setVisible(false);;
		return false;}
	}
	
	
	public static boolean DirrecionEditar (String texto, EditarEmpresa CL) {
		if(Validaciones.vacio(texto)) {
			CL.lblErrorDirrecion.setText("ESCRIBA UNA DIRECCIÓN VALIDA");
			CL.lblErrorDirrecion.setVisible(true);;
			return true;
		}
		else {
			CL.lblErrorDirrecion.setVisible(false);;
		return false;}
	}
	//-----------------------------------------------------------------------------CREAR PRODUCTO----------------------------------------------------------
	
	public static boolean NombreCrearProducto(String texto, CrearProducto CP) {
		if(Validaciones.vacio(texto)) {
			CP.lblErrorNombre.setText("RELLENE EL CAMPO");
			CP.lblErrorNombre.setVisible(true);;
			return true;
		}
		else if(Validaciones.SoloLetras(texto)) {
			CP.lblErrorNombre.setText("NO SE PERMITEN NUMEROS");
			CP.lblErrorNombre.setVisible(true);;
			return true;
		}
		else {
			CP.lblErrorNombre.setVisible(false);;
		return false;}
	}
	public static boolean PrecioCrearProducto (String texto, CrearProducto CP) {
		if((Validaciones.vacio(texto))) {
			CP.lblErrorPrecio.setText("RELLENE EL CAMPO");
			CP.lblErrorPrecio.setVisible(true);
			return true;
		}else if((Validaciones.SoloNum(texto))) {
			CP.lblErrorPrecio.setText("NO SE PERMITEN LETRAS");
			CP.lblErrorPrecio.setVisible(true);
			return true;
		}
		else {
			CP.lblErrorPrecio.setVisible(false);
		return false;}
	
	}
	public static boolean DescuentoCrearProducto (String texto,  CrearProducto CP) {
		if(Validaciones.vacio(texto)) {
			CP.lblErrorDescuento.setText("RELLENE EL CAMPO");
			CP.lblErrorDescuento.setVisible(true);;
			return true;
		}
		else if(Validaciones.SoloNum(texto)) {
			CP.lblErrorDescuento.setText("NO SE PERMITEN LETRAS");
			CP.lblErrorDescuento.setVisible(true);;
			return true;
		}
		else if(Validaciones.CantidadDescuento(texto)) {
			CP.lblErrorDescuento.setText("LA CANTIDAD DE DESCUENTO NO ES VALIDA");
			CP.lblErrorDescuento.setVisible(true);;
			return true;
		}
		else {
			CP.lblErrorDescuento.setVisible(false);;
		return false;}
	}
	
	
	public static boolean Contar (String texto,  CrearProducto CP) {
		
		int largo = texto.length();
		CP.lblContador.setText(String.valueOf(largo));
		
		return true;
	}
	public static boolean DescripcionCrearProducto(String texto,  CrearProducto CP) {
		int largo = texto.length();
		CP.lblContador.setText(String.valueOf(largo));
		
		if(Validaciones.vacio(texto)) {
			CP.lblErrorDescripcion.setText("RELLENE EL CAMPO");
			CP.lblErrorDescripcion.setVisible(true);
			return true;
		}
		else if(largo > 300) {
			CP.lblErrorDescripcion.setText("LA DESCRIPCIÓN SOBRE PASA EL LIMITE DE CARACTERES");
			CP.lblErrorDescripcion.setVisible(true);
			return true;
		}
		CP.lblErrorDescripcion.setVisible(false);
		return false;
	}
	// ------------------------------------------------------------------------------------EDITAR PRODUCTO -----------------------------------------------------------------
	
	public static boolean NombreEditarProducto(String texto, EditarProducto EP) {
		if(Validaciones.vacio(texto)) {
			EP.lblErrorNombre.setText("RELLENE EL CAMPO");
			EP.lblErrorNombre.setVisible(true);;
			return true;
		}
		else if(Validaciones.SoloLetras(texto)) {
			EP.lblErrorNombre.setText("NO SE PERMITEN NUMEROS");
			EP.lblErrorNombre.setVisible(true);;
			return true;
		}
		else {
			EP.lblErrorNombre.setVisible(false);;
		return false;}
	}
	public static boolean PrecioEditarProducto (String texto, EditarProducto EP) {
		if((Validaciones.vacio(texto))) {
			EP.lblErrorPrecio.setText("RELLENE EL CAMPO");
			EP.lblErrorPrecio.setVisible(true);
			return true;
		}else if((Validaciones.SoloNum(texto))) {
			EP.lblErrorPrecio.setText("NO SE PERMITEN LETRAS");
			EP.lblErrorPrecio.setVisible(true);
			return true;
		}
		else {
			EP.lblErrorPrecio.setVisible(false);
		return false;}
	
	}
	public static boolean DescuentoEditarProducto (String texto, EditarProducto EP) {
		if(Validaciones.vacio(texto)) {
			EP.lblErrorDescuento.setText("RELLENE EL CAMPO");
			EP.lblErrorDescuento.setVisible(true);;
			return true;
		}
		else if(Validaciones.SoloNum(texto)) {
			EP.lblErrorDescuento.setText("NO SE PERMITEN LETRAS");
			EP.lblErrorDescuento.setVisible(true);;
			return true;
		}
		else if(Validaciones.CantidadDescuento(texto)) {
			EP.lblErrorDescuento.setText("LA CANTIDAD DE DESCUENTO NO ES VALIDA");
			EP.lblErrorDescuento.setVisible(true);;
			return true;
		}
		else {
			EP.lblErrorDescuento.setVisible(false);;
		return false;}
	}
	
	
	public static boolean ContarEditar (String texto,  EditarProducto EP) {
		
		int largo = texto.length();
		EP.lblContador.setText(String.valueOf(largo));
		
		return true;
	}
	public static boolean DescripcionEditarProducto(String texto, EditarProducto EP) {
		int largo = texto.length();
		EP.lblContador.setText(String.valueOf(largo));
		
		if(Validaciones.vacio(texto)) {
			EP.lblErrorDescripcion.setText("RELLENE EL CAMPO");
			EP.lblErrorDescripcion.setVisible(true);
			return true;
		}
		else if(largo > 300) {
			EP.lblErrorDescripcion.setText("LA DESCRIPCIÓN SOBRE PASA EL LIMITE DE CARACTERES");
			EP.lblErrorDescripcion.setVisible(true);
			return true;
		}
		EP.lblErrorDescripcion.setVisible(false);
		return false;
	}
	//----------------------------------------------CREAR CUENTA-----------------------------------------------------
	
	public static boolean NombreCrear (String texto, CrearCuenta CC) {
		if(Validaciones.vacio(texto)) {
			CC.lblErrorNombre.setText("RELLENE EL CAMPO");
			CC.lblErrorNombre.setVisible(true);;
			return true;
		}
		else if(Validaciones.SoloLetras(texto)) {
			CC.lblErrorNombre.setText("NO SE PERMITEN NUMEROS");
			CC.lblErrorNombre.setVisible(true);;
			return true;
		}
		else {
			CC.lblErrorNombre.setVisible(false);;
		return false;}
	}
	
	public static boolean CrearCorreo (String texto, CrearCuenta CC) {
		if((Validaciones.vacio(texto))) {
			CC.lblErrorCorreo.setText("RELLENE EL CAMPO");
			CC.lblErrorCorreo.setVisible(true);
			return true;
		}else if((Validaciones.validarCorreo(texto))) {
			CC.lblErrorCorreo.setText("ESCRIBE UN CORREO VALIDO");
			CC.lblErrorCorreo.setVisible(true);
			return true;
		}
		else if(Validaciones.CantidadCorreo(texto)){
			CC.lblErrorCorreo.setText("ESCRIBE MENOS CARACTERES");
			CC.lblErrorCorreo.setVisible(true);
			return true;
		}
		else {
			CC.lblErrorCorreo.setVisible(false);
		return false;}
	
	}
	
	
	public static boolean CrearContraseña (String texto, CrearCuenta CC) {
		if(Validaciones.vacio(texto)) {
			CC.lblErrorContrasena.setText("CAMPO VACIO");
			CC.lblErrorContrasena.setVisible(true);;
			return true;
		}
		else if(Validaciones.cantidadcontraseña(texto)) {
			CC.lblErrorContrasena.setText("LA CONTRASEÑA DEBE SER DE 8 CARACTERES");
			CC.lblErrorContrasena.setVisible(true);;
			return true;
		}
		else if(Validaciones.validarContraseña(texto)) {
			CC.lblErrorContrasena.setText("NO ESCRIBAS CARACTERES ESPECIALES");
			CC.lblErrorContrasena.setVisible(true);;
			return true;
		}
		else {
			CC.lblErrorContrasena.setVisible(false);;
		return false;}
	}
	public static boolean CrearCContraseña (String texto, CrearCuenta CC) {
		if(Validaciones.vacio(texto)) {
			CC.lblErrorCContrasena.setText("CAMPO VACIO");
			CC.lblErrorCContrasena.setVisible(true);;
			return true;
		}
		else if(Validaciones.cantidadcontraseña(texto)) {
			CC.lblErrorCContrasena.setText("LA CONTRASEÑA DEBE SER DE 8 CARACTERES");
			CC.lblErrorCContrasena.setVisible(true);;
			return true;
		}
		else if(Validaciones.validarContraseña(texto)) {
			CC.lblErrorCContrasena.setText("NO ESCRIBAS CARACTERES ESPECIALES");
			CC.lblErrorCContrasena.setVisible(true);;
			return true;
		}
		else {
			CC.lblErrorCContrasena.setVisible(false);;
		return false;}
	}
	
	public static boolean TelefonoCrear(String texto, CrearCuenta CC) {
		if(Validaciones.vacio(texto)) {
			CC.lblErrorTelefono.setText("RELLENE EL CAMPO");
			CC.lblErrorTelefono.setVisible(true);;
			return true;
		}
		else if(Validaciones.SoloNum(texto)) {
			CC.lblErrorTelefono.setText("NO SE PERMITEN LETRAS");
			CC.lblErrorTelefono.setVisible(true);;
			return true;
		}else if(Validaciones.CantidadTelefono(texto)) {
			CC.lblErrorTelefono.setText("ESCRIBE UN # DE TELEFONO VALIDO");
			CC.lblErrorTelefono.setVisible(true);;
			return true;
		}
		else {
			CC.lblErrorTelefono.setVisible(false);;
		return false;}
	}
	
	public static boolean FechaNacimientoCrear(String texto,String texto2 , String texto3, CrearCuenta CC) {
		if(Validaciones.vacio(texto) || Validaciones.vacio(texto2) || Validaciones.vacio(texto3)) {
			CC.lblErrorFNacimiento.setText("ESCRIBA UN FC VALIDA");
			CC.lblErrorFNacimiento.setVisible(true);;
			return true;
		}
		else if(Validaciones.FechaNacimiento(texto)|| Validaciones.FechaNacimiento(texto2) || Validaciones.FechaNacimiento(texto3)) {
			CC.lblErrorFNacimiento.setText("NO SE PERMITEN CARACTERES ESPECIALES");
			CC.lblErrorFNacimiento.setVisible(true);;
			return true;
		}else if(Validaciones.CantidadDia(texto) ) {
			CC.lblErrorFNacimiento.setText("LA CANTIDAD DEL DIA NO ES VALIDA");
			CC.lblErrorFNacimiento.setVisible(true);
			return true;
		}else if(Validaciones.CantidadMes(texto2) ) {
			CC.lblErrorFNacimiento.setText("LA CANTIDAD DEL MES NO ES VALIDA");
			CC.lblErrorFNacimiento.setVisible(true);
			return true;
		}
		else if(Validaciones.CantidadAño(texto3) ) {
			CC.lblErrorFNacimiento.setText("LA CANTIDAD DEL AÑO NO ES VALIDA");
			CC.lblErrorFNacimiento.setVisible(true);
			return true;
		}else if(Validaciones.ValidarMayorDeEdad(texto3) ) {
			CC.lblErrorFNacimiento.setText("EL USUARIO DEBE SER MAYOR DE EDAD");
			CC.lblErrorFNacimiento.setVisible(true);
			return true;
		}
		else {
			CC.lblErrorFNacimiento.setVisible(false);;
		return false;}
	}
	//--------------------------------------------EditarUsuario---------------------------------------------------------
	public static boolean NombreEditarUsuario(String texto, PerfilUsuario PU) {
		if(Validaciones.vacio(texto)) {
			PU.lblErrorNombre.setText("RELLENE EL CAMPO");
			PU.lblErrorNombre.setVisible(true);;
			return true;
		}
		else if(Validaciones.SoloLetras(texto)) {
			PU.lblErrorNombre.setText("NO SE PERMITEN NUMEROS");
			PU.lblErrorNombre.setVisible(true);;
			return true;
		}
		else {
			PU.lblErrorNombre.setVisible(false);;
		return false;}
	}
	public static boolean TelefonoEditarUsuario(String texto,PerfilUsuario PU) {
		if(Validaciones.vacio(texto)) {
			PU.lblErrorTelefono.setText("RELLENE EL CAMPO");
			PU.lblErrorTelefono.setVisible(true);;
			return true;
		}
		else if(Validaciones.SoloNum(texto)) {
			PU.lblErrorTelefono.setText("NO SE PERMITEN LETRAS");
			PU.lblErrorTelefono.setVisible(true);;
			return true;
		}else if(Validaciones.CantidadTelefono(texto)) {
			PU.lblErrorTelefono.setText("ESCRIBE UN # DE TELEFONO VALIDO");
			PU.lblErrorTelefono.setVisible(true);;
			return true;
		}
		else {
			PU.lblErrorTelefono.setVisible(false);;
		return false;}
	}
	public static boolean CedulaEditarUsuario(String texto, PerfilUsuario PU) {
		if(Validaciones.vacio(texto)) {
			PU.lblErrorCedula.setText("RELLENE EL CAMPO");
			PU.lblErrorCedula.setVisible(true);;
			return true;
		}
		else if(Validaciones.SoloNum(texto)) {
			PU.lblErrorCedula.setText("NO SE PERMITEN LETRAS");
			PU.lblErrorCedula.setVisible(true);;
			return true;
		}else if(Validaciones.CantidadCedula(texto)) {
			PU.lblErrorCedula.setText("LA CANTIDAD DE LA CEDULA NO ES VALIDA");
			PU.lblErrorCedula.setVisible(true);;
			return true;
		}
		else {
			PU.lblErrorCedula.setVisible(false);;
		return false;}
	}
	
	public static boolean DireccionEditarUsuario(String texto, PerfilUsuario PU) {
		if(Validaciones.vacio(texto)) {
			PU.lblErrorDireccion.setText("RELLENE EL CAMPO");
			PU.lblErrorDireccion.setVisible(true);;
			return true;
		}
		else {
			PU.lblErrorDireccion.setVisible(false);;
		return false;}
	}
	//----------------------------------------CAMBIARCONTRASEÑAUSUARIO----------------------------------------------------------
	
	public static boolean UsuarioCContraseña (String texto, CambiarContraseñaUsuario CCU) {
		if(Validaciones.vacio(texto)) {
			CCU.lblErrorCContrasena.setText("CAMPO VACIO");
			CCU.lblErrorCContrasena.setVisible(true);;
			return true;
		}
		else if(Validaciones.cantidadcontraseña(texto)) {
			CCU.lblErrorCContrasena.setText("LA CONTRASEÑA DEBE SER DE 8 CARACTERES");
			CCU.lblErrorCContrasena.setVisible(true);;
			return true;
		}
		else if(Validaciones.validarContraseña(texto)) {
			CCU.lblErrorCContrasena.setText("NO ESCRIBAS CARACTERES ESPECIALES");
			CCU.lblErrorCContrasena.setVisible(true);;
			return true;
		}
		else {
			CCU.lblErrorCContrasena.setVisible(false);;
		return false;}
	}
	
	public static boolean UsuarioContraseñaN (String texto, CambiarContraseñaUsuario CCU) {
		if(Validaciones.vacio(texto)) {
			CCU.lblErrorContrasenaN.setText("CAMPO VACIO");
			CCU.lblErrorContrasenaN.setVisible(true);;
			return true;
		}
		else if(Validaciones.cantidadcontraseña(texto)) {
			CCU.lblErrorContrasenaN.setText("LA CONTRASEÑA DEBE SER DE 8 CARACTERES");
			CCU.lblErrorContrasenaN.setVisible(true);;
			return true;
		}
		else if(Validaciones.validarContraseña(texto)) {
			CCU.lblErrorContrasenaN.setText("NO ESCRIBAS CARACTERES ESPECIALES");
			CCU.lblErrorContrasenaN.setVisible(true);;
			return true;
		}
		else {
			CCU.lblErrorContrasenaN.setVisible(false);;
		return false;}
	}
	
	public static boolean UsuarioContraseñaA (String texto, CambiarContraseñaUsuario CCU) {
		if(Validaciones.vacio(texto)) {
			CCU.lblErrorContrasenaA.setText("CAMPO VACIO");
			CCU.lblErrorContrasenaA.setVisible(true);;
			return true;
		}
		else if(Validaciones.cantidadcontraseña(texto)) {
			CCU.lblErrorContrasenaA.setText("LA CONTRASEÑA DEBE SER DE 8 CARACTERES");
			CCU.lblErrorContrasenaA.setVisible(true);;
			return true;
		}
		else if(Validaciones.validarContraseña(texto)) {
			CCU.lblErrorContrasenaA.setText("NO ESCRIBAS CARACTERES ESPECIALES");
			CCU.lblErrorContrasenaA.setVisible(true);;
			return true;
		}
		else {
			CCU.lblErrorContrasenaA.setVisible(false);;
		return false;}
	}
	
	//-------------------------------------------INGRESAR CORREO-----------------------------------
	public static boolean IngresarCorreoRecuperar (String texto, IngresarCorreo IC) {
		if((Validaciones.vacio(texto))) {
			IC.lblErrorCorreo.setText("RELLENE EL CAMPO");
			IC.lblErrorCorreo.setVisible(true);
			return true;
		}else if((Validaciones.validarCorreo(texto))) {
			IC.lblErrorCorreo.setText("ESCRIBE UN CORREO VALIDO");
			IC.lblErrorCorreo.setVisible(true);
			return true;
		}
		else if(Validaciones.CantidadCorreo(texto)){
			IC.lblErrorCorreo.setText("ESCRIBE MENOS CARACTERES");
			IC.lblErrorCorreo.setVisible(true);
			return true;
		}
		else {
			IC.lblErrorCorreo.setVisible(false);
		return false;}
	
	}
}

