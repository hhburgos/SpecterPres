package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Servicios;
import vista.PanelPrincipal;

public class Controlador implements ActionListener {
	
	private PanelPrincipal mainPanel;
	
	
	public Controlador (PanelPrincipal pp) {
		mainPanel = pp;
		
		pp.btnBlue.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mainPanel.btnBlue) {
			mainPanel.archivo_activo = Servicios.getFichServiciosBlue();
			cambiaSector();
		}
	}

}
