package controlador;

import vista.PanelPrincipal;

public class Main {
	
	public static void main (String [] args) {
		PanelPrincipal pp = new PanelPrincipal();
		ControladorPrincipal ctrl = new ControladorPrincipal(pp);
		
		pp.setVisible(true);
	}
	
}
