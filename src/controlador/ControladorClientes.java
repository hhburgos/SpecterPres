package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;

import eventos.Ficheros;
import modelo.Cliente;
import vista.PanelClientes;

public class ControladorClientes implements ActionListener {
	
	private PanelClientes customersPanel;
	
	private ArrayList<Cliente> aClientes;
	private Cliente clienteSeleccionado;
	private ControladorPrincipal sm;
	
	public ControladorClientes (PanelClientes pc, ControladorPrincipal controlador) {
		customersPanel = pc;
		this.sm = controlador;
		
		logicaInicial();
		
		addActionListenerToButtons();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == customersPanel.btnNuevo) {
			creaCliente();
		}
		else if (e.getSource() == customersPanel.btnBuscar) {
			buscarCliente();
		}
		else if (e.getSource() == customersPanel.btnSeleccionar) {
			sm.setCliente(clienteSeleccionado);
			sm.colocarCliente();
			customersPanel.dispose();
		}
		else if (e.getSource() == customersPanel.btnGuardar) {
			
		}
	}
	
// METODOS PRINCIPALES
	public void creaCliente () {
		if (tfRellenado(customersPanel.tfNombre)) {
			String nombre = customersPanel.tfNombre.getText();
			Cliente nuevoCliente = new Cliente(nombre);
			if (masCamposRellenados()) {
				addAtributosExtra(nuevoCliente);
			}
			aClientes.add(nuevoCliente);
			Ficheros.guardaArrayCliente(aClientes, Cliente.getFichClientes());
			Ficheros.mensaje(customersPanel, "Cliente creado correctamente", "Nota");
			limpiarCampos();
		}
		else { 
			Ficheros.mensajeError(customersPanel, "El campo 'nombre' no puede estar vacío", "Error al crear cliente");
		}
	}
	
	public void guardarCliente () {
		try {
			int id = clienteSeleccionado.getId();
			int codigoPostal = Integer.valueOf(customersPanel.tfCP.getText());
			int telefono = Integer.valueOf(customersPanel.tfTel.getText());
			String nombre = customersPanel.tfNombre.getText();
			String direccion = customersPanel.tfDireccion.getText();
			String cif = customersPanel.tfCIF.getText();
			
			clienteSeleccionado.setCodigoPostal(codigoPostal);
			clienteSeleccionado.setTelefono(telefono);
			clienteSeleccionado.setNombre(nombre);
			clienteSeleccionado.setDireccion(direccion);
			clienteSeleccionado.setCif(cif);
			
			int index = buscarPorID(id);
			aClientes.set(index, clienteSeleccionado);
			Ficheros.guardaArrayCliente(aClientes, Cliente.getFichClientes());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void buscarCliente () {
		if (tfRellenado(customersPanel.tfBuscar)) {
			String nombre = customersPanel.tfBuscar.getText().toUpperCase().trim();
		
			for (int i = 0; i < aClientes.size(); i++) {
				if (nombre.equals(aClientes.get(i).getNombre().toUpperCase().trim())) {
					clienteSeleccionado = aClientes.get(i);
					
					customersPanel.tfNombre.setText(aClientes.get(i).getNombre().toString());
					customersPanel.tfCP.setText(String.valueOf(aClientes.get(i).getCodigoPostal()));
					customersPanel.tfCIF.setText(aClientes.get(i).getCif());
					customersPanel.tfDireccion.setText(aClientes.get(i).getDireccion());
					customersPanel.tfTel.setText(String.valueOf(aClientes.get(i).getTelefono()));
					return;
				}
			}
			Ficheros.mensajeError(customersPanel, "No se ha encontrado ningún cliente con ese nombre", "Error");
		}
		else { Ficheros.mensajeError(customersPanel, "Debes introducir un nombre en el campo 'Buscar'", "Error"); }
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
	
	public void logicaInicial () {
		aClientes = new ArrayList<Cliente>();
		Ficheros.leeFicheroCliente(aClientes, Cliente.getFichClientes());
		limpiarCampos();
	}	
	
// METODOS SECUNDARIOS
	public boolean tfRellenado (JTextField tf) {
		if (tf.getText().length() == 0) {
			return (false);
		} else {
			return (true);
		}
	}
	
	public boolean masCamposRellenados () {
		if (tfRellenado(customersPanel.tfCP)) {
			return (true);
		}
		else if (tfRellenado(customersPanel.tfTel)) {
			return (true);
		}
		else if (tfRellenado(customersPanel.tfCIF)) {
			return (true);
		}
		else if (tfRellenado(customersPanel.tfDireccion)) {
			return (true);
		}
		
		return (false);
	}
	
	public void addAtributosExtra (Cliente c) {
		String direccion, cif;
		int cp, tel;
		
		if (tfRellenado(customersPanel.tfCP)) {
			cp = Integer.valueOf(customersPanel.tfCP.getText());
			c.setCodigoPostal(cp);
		}
		if (tfRellenado(customersPanel.tfTel)) {
			tel = Integer.valueOf(customersPanel.tfTel.getText());
			c.setCodigoPostal(tel);
		}
		if (tfRellenado(customersPanel.tfCIF)) {
			cif = customersPanel.tfCIF.getText();
			c.setCif(cif);
		}
		if (tfRellenado(customersPanel.tfDireccion)) {
			direccion = customersPanel.tfDireccion.getText();
			c.setDireccion(direccion);
		}
	}
	
	public void limpiarCampos () {
		customersPanel.tfNombre.setText("");
		customersPanel.tfDireccion.setText("");
		customersPanel.tfTel.setText("");
		customersPanel.tfCP.setText("");
		customersPanel.tfCIF.setText("");
		customersPanel.tfBuscar.setText("");
	}
	
	public void addActionListenerToButtons () {
		customersPanel.btnNuevo.addActionListener(this);
		customersPanel.btnBuscar.addActionListener(this);
		customersPanel.btnSeleccionar.addActionListener(this);
		customersPanel.btnGuardar.addActionListener(this);
	}
	
// GETERS Y SETERS
	public ArrayList<Cliente> getaClientes() {
		return aClientes;
	}

	public void setaClientes(ArrayList<Cliente> aClientes) {
		this.aClientes = aClientes;
	}

	public ControladorPrincipal getSm() {
		return sm;
	}

	public void setSm(ControladorPrincipal sm) {
		this.sm = sm;
	}
	
	

}
