package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import java.awt.Font;
import javax.swing.JTextField;

public class SpecterBlue extends JDialog {
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SpecterBlue dialog = new SpecterBlue();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SpecterBlue() {
		getContentPane().setBackground(Color.WHITE);
		setBounds(100, 100, 1426, 795);
		getContentPane().setLayout(null);
		
		JLabel lblLogo = new JLabel("LOGO");
		lblLogo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLogo.setBackground(Color.RED);
		lblLogo.setBounds(12, 13, 235, 80);
		getContentPane().add(lblLogo);
		
		JList listServicios = new JList();
		listServicios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listServicios.setBackground(Color.GRAY);
		listServicios.setBounds(925, 290, 446, 419);
		getContentPane().add(listServicios);
		
		JList listSeleccion = new JList();
		listSeleccion.setBackground(Color.DARK_GRAY);
		listSeleccion.setBounds(37, 290, 838, 419);
		getContentPane().add(listSeleccion);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(55, 176, 173, 44);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(258, 175, 173, 45);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnGenera = new JButton("Genera PDF");
		btnGenera.setBounds(1274, 126, 97, 114);
		getContentPane().add(btnGenera);
	}
}
