package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ControladorPrincipal;
import modelo.Cliente;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;

public class PanelClientes extends JDialog {
//	public ArrayList<Cliente> aClientes;
	public JTextField tfNombre;
	public JTextField tfDireccion;
	public JTextField tfTel;
	public JTextField tfCIF;
	public JTextField tfCP;
	public JTextField tfBuscar;
	public JButton btnNuevo;
	public JButton btnBuscar;
	public JButton btnSeleccionar;
	public JButton btnGuardar;
	
//	private Cliente clienteSeleccionado;
	
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		if (e.getSource() == btnNuevo) {
//			creaCliente();
//		} 
//		else if (e.getSource() == btnBuscar) {
//			buscarCliente();
//		}
//		else if (e.getSource() == btnSeleccionar) {
//			sm.setCliente(clienteSeleccionado);
//			sm.colocarCliente();
//			this.dispose();
//		}
//		else if (e.getSource() == btnGuardar) {
//			guardarCliente();
//			ModeloBlue.mensaje(this, "Se ha guardado las modificaciones correctamente", "");
//		}
//	}
	
	
	
//	public void creaCliente () {
//		if (tfRellenado(tfNombre)) {
//			String nombre = tfNombre.getText();
//			Cliente nuevoCliente = new Cliente(nombre);
//			if (masCamposRellenados()) {
//				addAtributosExtra(nuevoCliente);
//			}
//			aClientes.add(nuevoCliente);
//			ModeloBlue.guardaArrayCliente(aClientes, Cliente.getFichClientes());
//			ModeloBlue.mensaje(this, "Cliente creado correctamente", "Nota");
//			limpiarCampos();
//		}
//		else { 
//			ModeloBlue.mensajeError(this, "El campo 'nombre' no puede estar vacío", "Error al crear cliente");
//		}
//	}
	
//	public void addAtributosExtra (Cliente c) {
//		String direccion, cif;
//		int cp, tel;
//		
//		if (tfRellenado(tfCP)) {
//			cp = Integer.valueOf(tfCP.getText());
//			c.setCodigoPostal(cp);
//		}
//		if (tfRellenado(tfTel)) {
//			tel = Integer.valueOf(tfTel.getText());
//			c.setCodigoPostal(tel);
//		}
//		if (tfRellenado(tfCIF)) {
//			cif = tfCIF.getText();
//			c.setCif(cif);
//		}
//		if (tfRellenado(tfDireccion)) {
//			direccion = tfDireccion.getText();
//			c.setDireccion(direccion);
//		}
//	}
//	
	

//	public boolean masCamposRellenados () {
//		if (tfRellenado(tfCP)) {
//			return (true);
//		}
//		else if (tfRellenado(tfTel)) {
//			return (true);
//		}
//		else if (tfRellenado(tfCIF)) {
//			return (true);
//		}
//		else if (tfRellenado(tfDireccion)) {
//			return (true);
//		}
//		
//		return (false);
//	}
//	
//	public boolean tfRellenado (JTextField tf) {
//		if (tf.getText().length() == 0) {
//			return (false);
//		} else {
//			return (true);
//		}
//	}

	
//	public void limpiarCampos () {
//		tfNombre.setText("");
//		tfDireccion.setText("");
//		tfTel.setText("");
//		tfCP.setText("");
//		tfCIF.setText("");
//		tfBuscar.setText("");
//	}
	
// --- VISUAL --- //
	/**
	 * Create the dialog.
	 */
	public PanelClientes(/*ControladorPrincipal controlador*/) {
		setModal(true);
//		this.sm = controlador;
		
		setResizable(false);
		setBounds(100, 100, 756, 322);
		getContentPane().setLayout(null);
		
		creaLBL();
		creaTF();
		creaBTN();
		
//		logicaInicial();
	}

	public void creaBTN() {
		btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnGuardar.setBounds(574, 201, 130, 42);
		getContentPane().add(btnGuardar);
		
		btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.setFont(new Font("Tahoma", Font.BOLD, 23));
		btnSeleccionar.setBounds(405, 125, 303, 58);
		getContentPane().add(btnSeleccionar);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNuevo.setBounds(405, 201, 130, 42);
		getContentPane().add(btnNuevo);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBuscar.setBounds(596, 67, 108, 33);
		getContentPane().add(btnBuscar);
	}
	
	public void creaTF () {
		tfBuscar = new JTextField();
		tfBuscar.setColumns(10);
		tfBuscar.setBounds(405, 68, 179, 33);
		getContentPane().add(tfBuscar);
		
		tfCP = new JTextField();
		tfCP.setColumns(10);
		tfCP.setBounds(99, 221, 130, 22);
		getContentPane().add(tfCP);
		
		tfTel = new JTextField();
		tfTel.setColumns(10);
		tfTel.setBounds(99, 131, 160, 22);
		getContentPane().add(tfTel);
		
		tfCIF = new JTextField();
		tfCIF.setColumns(10);
		tfCIF.setBounds(99, 177, 130, 22);
		getContentPane().add(tfCIF);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(99, 39, 220, 22);
		getContentPane().add(tfNombre);
		tfNombre.setColumns(10);
		
		tfDireccion = new JTextField();
		tfDireccion.setColumns(10);
		tfDireccion.setBounds(99, 85, 220, 22);
		getContentPane().add(tfDireccion);
	}

	public void creaLBL () {
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombre.setBounds(27, 33, 91, 33);
		getContentPane().add(lblNombre);
		
		JLabel lblDireccion = new JLabel("Direcci\u00F3n");
		lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDireccion.setBounds(27, 79, 91, 33);
		getContentPane().add(lblDireccion);
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono:");
		lblTelfono.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTelfono.setBounds(27, 125, 91, 33);
		getContentPane().add(lblTelfono);
		
		JLabel lblCif = new JLabel("CIF");
		lblCif.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCif.setBounds(27, 171, 91, 33);
		getContentPane().add(lblCif);
		
		JLabel lblCif_1 = new JLabel("CP");
		lblCif_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCif_1.setBounds(27, 215, 91, 33);
		getContentPane().add(lblCif_1);
		
		JLabel lblNewLabel = new JLabel("Introduce el nombre de la empresa");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(405, 33, 286, 33);
		getContentPane().add(lblNewLabel);
	}
}
