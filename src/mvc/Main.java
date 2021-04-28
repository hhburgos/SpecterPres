package mvc;

import controlador.Controlador;
import vista.PanelPrincipal;

public class Main {
	
	public static void main (String [] args) {
		PanelPrincipal pp = new PanelPrincipal();
		
		Controlador ctrl = new Controlador(pp);
		
	}
}
