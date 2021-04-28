package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.PanelServicios;

public class ControladorServicios implements ActionListener {
	
	private PanelServicios servicesPanel;
	
	public ControladorServicios (PanelServicios ps) {
		servicesPanel = ps;
		
		addActionListenerToButtons();
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}
	
	public void addActionListenerToButtons () {
		servicesPanel.btn1824.addActionListener(this);
		servicesPanel.btnBlue.addActionListener(this);
		servicesPanel.btnBorrar.addActionListener(this);
		servicesPanel.btnGuardar.addActionListener(this);
		servicesPanel.cbSector.addActionListener(this);
		servicesPanel.chbNuevo.addActionListener(this);
	}
	
}
