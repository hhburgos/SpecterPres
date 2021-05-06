package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.PanelSetServices;

public class ControladorSetServices implements ActionListener {
	
	private PanelSetServices setServices;
	
	public ControladorSetServices (PanelSetServices pss) {
		setServices = pss;
		
		setServices.btnAceptar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == setServices.btnAceptar) {
			setServices.dispose();
		}
	}

}
