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
	private JButton btnBuscar;
	private JButton btnSeleccionar;
	private JButton btnGuardar;
	
	private SpecterMain sm;
	private Cliente clienteSeleccionado;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNuevo) {
			creaCliente();
		} 
		else if (e.getSource() == btnBuscar) {
			buscarCliente();
		}
		else if (e.getSource() == btnSeleccionar) {
			sm.setCliente(clienteSeleccionado);
			sm.colocarCliente();
			this.dispose();
		}
		else if (e.getSource() == btnGuardar) {
			guardarCliente();
			ModeloBlue.mensaje(this, "Se ha guardado las modificaciones correctamente", "");
		}
	}
	
	public void guardarCliente () {
		try {
			int id = clienteSeleccionado.getId();
			int codigoPostal = Integer.valueOf(tfCP.getText());
			int telefono = Integer.valueOf(tfTel.getText());
			String nombre = tfNombre.getText();
			String direccion = tfDireccion.getText();
			String cif = tfCIF.getText();
			
			clienteSeleccionado.setCodigoPostal(codigoPostal);
			clienteSeleccionado.setTelefono(telefono);
			clienteSeleccionado.setNombre(nombre);
			clienteSeleccionado.setDireccion(direccion);
			clienteSeleccionado.setCif(cif);
			
			int index = buscarPorID(id);
			aClientes.set(index, clienteSeleccionado);
			ModeloBlue.guardaArrayCliente(aClientes, Cliente.getFichClientes());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Deuvelve la posicion del objeto con id pasa por parametro en el arrayClientes
	 * Si devuelve -1 es que no se encontró el objeto, esto no deberia pasar
	 */
	public int buscarPorID (int id) {
		int dev = -1;
		for (int i = 0; i < aClientes.size(); i++) {
			if (aClientes.get(i).getId() == id) {
				dev = i;
				return dev;
			}
		}
		return dev;
	}
	
	public void creaCliente () {
		if (tfRellenado(tfNombre)) {
			String nombre = tfNombre.getText();
			Cliente nuevoCliente = new Cliente(nombre);
			if (masCamposRellenados()) {
				addAtributosExtra(nuevoCliente);
			}
			aClientes.add(nuevoCliente);
			ModeloBlue.guardaArrayCliente(aClientes, Cliente.getFichClientes());
			ModeloBlue.mensaje(this, "Cliente creado correctamente", "Nota");
			limpiarCampos();
		}
		else { 
			ModeloBlue.mensajeError(this, "El campo 'nombre' no puede estar vacío", "Error al crear cliente");
		}
	}
	
	public void addAtributosExtra (Cliente c) {
		String direccion, cif;
		int cp, tel;
		
		if (tfRellenado(tfCP)) {
			cp = Integer.valueOf(tfCP.getText());
			c.setCodigoPostal(cp);
		}
		if (tfRellenado(tfTel)) {
			tel = Integer.valueOf(tfTel.getText());
			c.setCodigoPostal(tel);
		}
		if (tfRellenado(tfCIF)) {
			cif = tfCIF.getText();
			c.setCif(cif);
		}
		if (tfRellenado(tfDireccion)) {
			direccion = tfDireccion.getText();
			c.setDireccion(direccion);
		}
	}
	
	public void buscarCliente () {
		if (tfRellenado(tfBuscar)) {
			String nombre = tfBuscar.getText().toUpperCase().trim();
		
			for (int i = 0; i < aClientes.size(); i++) {
				if (nombre.equals(aClientes.get(i).getNombre().toUpperCase().trim())) {
					clienteSeleccionado = aClientes.get(i);
					
					tfNombre.setText(aClientes.get(i).getNombre().toString());
					tfCP.setText(String.valueOf(aClientes.get(i).getCodigoPostal()));
					tfCIF.setText(aClientes.get(i).getCif());
					tfDireccion.setText(aClientes.get(i).getDireccion());
					tfTel.setText(String.valueOf(aClientes.get(i).getTelefono()));
					return;
				}
			}
			ModeloBlue.mensajeError(this, "No se ha encontrado ningún cliente con ese nombre", "Error");
		}
		else { ModeloBlue.mensajeError(this, "Debes introducir un nombre en el campo 'Buscar'", "Error"); }
	}

	public boolean masCamposRellenados () {
		if (tfRellenado(tfCP)) {
			return (true);
		}
		else if (tfRellenado(tfTel)) {
			return (true);
		}
		else if (tfRellenado(tfCIF)) {
			return (true);
		}
		else if (tfRellenado(tfDireccion)) {
			return (true);
		}
		
		return (false);
	}
	
	public boolean tfRellenado (JTextField tf) {
		if (tf.getText().length() == 0) {
			return (false);
		} else {
			return (true);
		}
	}

	public void logicaInicial () {
		aClientes = new ArrayList<Cliente>();
		ModeloBlue.leeFicheroCliente(aClientes, Cliente.getFichClientes());
		limpiarCampos();
	}	
	
	public void limpiarCampos () {
		tfNombre.setText("");
		tfDireccion.setText("");
		tfTel.setText("");
		tfCP.setText("");
		tfCIF.setText("");
		tfBuscar.setText("");
	}
	
// --- VISUAL --- //
	/**
	 * Create the dialog.
	 */
	public NuevoCliente(SpecterMain sm) {
		setModal(true);
		this.sm = sm;
		
		setResizable(false);
		setBounds(100, 100, 756, 322);
		getContentPane().setLayout(null);
		
		creaLBL();
		creaTF();
		creaBTN();
		
		logicaInicial();
	}

	public void creaBTN() {
		btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnGuardar.setBounds(574, 201, 130, 42);
		getContentPane().add(btnGuardar);
		btnGuardar.addActionListener(this);
		
		btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.setFont(new Font("Tahoma", Font.BOLD, 23));
		btnSeleccionar.setBounds(405, 125, 303, 58);
		getContentPane().add(btnSeleccionar);
		btnSeleccionar.addActionListener(this);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNuevo.setBounds(405, 201, 130, 42);
		getContentPane().add(btnNuevo);
		btnNuevo.addActionListener(this);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBuscar.setBounds(596, 67, 108, 33);
		getContentPane().add(btnBuscar);
		btnBuscar.addActionListener(this);
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
