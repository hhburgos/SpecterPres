package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class PanelSetServices extends JDialog {

	public JLabel lblServicesName;
	public JComboBox cbSelectAttribute;
	public JTextArea taAttributeValue;
	public JButton btnAceptar;
	
	public static void main(String[] args) {
		try {
			PanelSetServices dialog = new PanelSetServices();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PanelSetServices() {
		setModal(true);
		setBounds(100, 100, 557, 349);
		getContentPane().setLayout(null);
		
		lblServicesName = new JLabel("New label");
		lblServicesName.setBounds(28, 26, 168, 34);
		getContentPane().add(lblServicesName);
		
		cbSelectAttribute = new JComboBox();
		cbSelectAttribute.setBounds(28, 73, 253, 28);
		getContentPane().add(cbSelectAttribute);
		
		taAttributeValue = new JTextArea();
		taAttributeValue.setBounds(28, 114, 482, 154);
		getContentPane().add(taAttributeValue);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(364, 73, 146, 28);
		getContentPane().add(btnAceptar);
	}
	
}
