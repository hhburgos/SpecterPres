package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Cliente;
import modelo.ModeloBlue;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;

public class NuevoCliente extends JDialog implements ActionListener {
	private ArrayList<Cliente> aClientes;
	private JTextField tfNombre;
	private JTextField tfDireccion;
	private JTextField tfTel;
	private JTextField tfCIF;
	private JTextField tfCP;
	private JTextField tfBuscar;
	private JButton btnNuevo;

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNuevo) {
			creaCliente();
		}
	}
	
	public void creaCliente () {
		if (verificaTFNombre()) {
			String nombre = tfNombre.getText();
			Cliente nuevoCliente = new Cliente(nombre);
			if (masCamposRellenados()) {
				
			}
			aClientes.add(nuevoCliente);
			ModeloBlue.mensaje(this, "Cliente creado correctamente", "Nota");
		}
		else { 
			ModeloBlue.mensajeError(this, "El campo 'nombre' no puede estar vacío", "Error al crear cliente");
		}
	}
	
	public boolean masCamposRellenados () {
		//falta verificar si han escrito en mas campos e introducirlos al objeto antes de que se almacene en el arrayList
		return false;
	}
	
	public boolean verificaTFNombre () {
		if (tfNombre.getText().length() == 0) {
			return (false);
		} else {
			return (true);
		}
	}

	public void logicaInicial () {
		aClientes = new ArrayList<Cliente>();
		ModeloBlue.leeFicheroCliente(aClientes, Cliente.getFichClientes());
		
	}
	
	public void logicaFinal () {
		ModeloBlue.guardaArrayCliente(aClientes, Cliente.getFichClientes());
	}
	
	/**
	 * Create the dialog.
	 */
	public NuevoCliente() {
		setResizable(false);
		setBounds(100, 100, 756, 322);
		getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombre.setBounds(27, 33, 91, 33);
		getContentPane().add(lblNombre);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(99, 39, 220, 22);
		getContentPane().add(tfNombre);
		tfNombre.setColumns(10);
		
		tfDireccion = new JTextField();
		tfDireccion.setColumns(10);
		tfDireccion.setBounds(99, 85, 220, 22);
		getContentPane().add(tfDireccion);
		
		JLabel lblDireccion = new JLabel("Direcci\u00F3n");
		lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDireccion.setBounds(27, 79, 91, 33);
		getContentPane().add(lblDireccion);
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono:");
		lblTelfono.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTelfono.setBounds(27, 125, 91, 33);
		getContentPane().add(lblTelfono);
		
		tfTel = new JTextField();
		tfTel.setColumns(10);
		tfTel.setBounds(99, 131, 160, 22);
		getContentPane().add(tfTel);
		
		tfCIF = new JTextField();
		tfCIF.setColumns(10);
		tfCIF.setBounds(99, 177, 130, 22);
		getContentPane().add(tfCIF);
		
		JLabel lblCif = new JLabel("CIF");
		lblCif.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCif.setBounds(27, 171, 91, 33);
		getContentPane().add(lblCif);
		
		tfCP = new JTextField();
		tfCP.setColumns(10);
		tfCP.setBounds(99, 221, 130, 22);
		getContentPane().add(tfCP);
		
		JLabel lblCif_1 = new JLabel("CP");
		lblCif_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCif_1.setBounds(27, 215, 91, 33);
		getContentPane().add(lblCif_1);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNuevo.setBounds(405, 201, 130, 42);
		getContentPane().add(btnNuevo);
		btnNuevo.addActionListener(this);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBuscar.setBounds(596, 67, 108, 33);
		getContentPane().add(btnBuscar);
		
		tfBuscar = new JTextField();
		tfBuscar.setColumns(10);
		tfBuscar.setBounds(405, 68, 179, 33);
		getContentPane().add(tfBuscar);
		
		JLabel lblNewLabel = new JLabel("Introduce el nombre de la empresa");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(405, 33, 286, 33);
		getContentPane().add(lblNewLabel);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnVolver.setBounds(574, 201, 130, 42);
		getContentPane().add(btnVolver);
		
		JButton btnNewButton_1 = new JButton("Seleccionar");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 23));
		btnNewButton_1.setBounds(405, 125, 303, 58);
		getContentPane().add(btnNewButton_1);
		
		///
		
		logicaInicial();
	}
	

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			NuevoCliente dialog = new NuevoCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
