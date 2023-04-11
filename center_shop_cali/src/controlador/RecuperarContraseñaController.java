package controlador;

import herramientas.Ayudas;
import vista.IngresarCorreo;
import vista.RecuperarContraseña;

public class RecuperarContraseñaController {

	RecuperarContraseña RC;
	public RecuperarContraseñaController (RecuperarContraseña RC) {
		this.RC = RC;
		PanelCorreo();
	}
	
	private void PanelCorreo() {
		IngresarCorreo IC = new IngresarCorreo();
		new IngresarCorreoController(IC, RC);
		Ayudas.ActualizarPanelFacil(IC, RC.PanelPrincipal);
	}
}
