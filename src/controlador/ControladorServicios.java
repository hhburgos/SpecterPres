package controlador;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import eventos.Ficheros;
import modelo.Servicios;
import vista.PanelServicios;

public class ControladorServicios implements ActionListener {
	
	private PanelServicios servicesPanel;
	
	private ArrayList<Servicios> aServicios;
	private String archivo_activo = Servicios.getFichServicios();
	private int sector = Servicios.getSectorBlue(); //0:Blue  1:1824  2:Agency
	private boolean modoNuevo; //si está en false es que va a modificar los campos de un servicio existente
	private int index = -1; //index del servicio activo en cada momento
	
	public ControladorServicios (PanelServicios ps) {
		servicesPanel = ps;
		
		inicio();
		addActionListenerToButtons();
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == servicesPanel.btnGuardar) {
			clickGuardar();
		}
		else if (e.getSource() == servicesPanel.btnBorrar) {
			
		}
		else if (e.getSource() == servicesPanel.btnBlue) {
			sector = Servicios.getSectorBlue();
			cargarLista();
		}
		else if (e.getSource() == servicesPanel.btn1824) {
			sector = Servicios.getSector1824();
			cargarLista();
		}
	}
	
// METODOS PRINCIPALES
	public void inicio () {
		modoNuevo = true;
		aServicios = new ArrayList<Servicios>();
		servicesPanel.chbNuevo.setSelected(true);

		cargarLista();
	}
	
	public void clickGuardar () {
		if (modoNuevo) {
			creaNuevoServicio();
		} else {
			actualizarServicio();
		}
	}
	
	public void creaNuevoServicio() {
		//camposLlenos()
		//suponiendo que todos los campos estan llenos
		if (tfRellenado(servicesPanel.tfNombre) || tfRellenado(servicesPanel.tfPrecio) || taRellenado(servicesPanel.taDescripcion)) {
			String nombre = servicesPanel.tfNombre.getText();
			String descripcion = servicesPanel.taDescripcion.getText();
			double precio = Double.valueOf(servicesPanel.tfPrecio.getText());
			
			Servicios nuevo_servicio = new Servicios(sector, nombre, descripcion, precio); //revisar sector
//			actualizaArrayServicios();
			aServicios.add(nuevo_servicio);
			
			actualizaFichero();
			limpiaCampos();
			cargarLista();
		}
		else { Ficheros.mensajeError(servicesPanel, "Debes rellenar todos los campos", "ERROR"); }
	}
	
	public void actualizarServicio() {
		if (tfRellenado(servicesPanel.tfNombre) || tfRellenado(servicesPanel.tfPrecio) || taRellenado(servicesPanel.taDescripcion)) {
			String nombre = servicesPanel.tfNombre.getText();
			String descripcion = servicesPanel.taDescripcion.getText();
			double precio = Double.valueOf(servicesPanel.tfPrecio.getText()); //captar exception

			aServicios.get(index).setNombre(nombre);
			aServicios.get(index).setDescripcion(descripcion);
			aServicios.get(index).setPrecio(precio);
			
			actualizaFichero();
			limpiaCampos();
			cargarLista();
		}
		else { Ficheros.mensajeError(servicesPanel, "Debes rellenar todos los campos", "ERROR"); }
	}
	
	public void cargarLista () {
		aServicios.clear();
		servicesPanel.modeloServicios.clear();
		
		Ficheros.leeFicheroServicios(aServicios,archivo_activo);
		for (int i = 0; i < aServicios.size(); i++) {
			servicesPanel.modeloServicios.add(i, aServicios.get(i).getNombre());
			System.out.println("buc:"  + i);
		}
		servicesPanel.scrollPane_1.setViewportView(servicesPanel.listServicios);
		servicesPanel.listServicios.setFont(new Font("Tahoma", Font.PLAIN, 24));
		servicesPanel.listServicios.setModel(servicesPanel.modeloServicios);
	}
	
	public void mueveServicio () {
		int id = aServicios.get(index).get_id();
		String nombre = aServicios.get(index).getNombre();
		String descripcion = aServicios.get(index).getDescripcion();
		Double precio = aServicios.get(index).getPrecio();
		
		limpiaCampos();
		
		servicesPanel.tfID.setText(String.valueOf(id));
		servicesPanel.tfNombre.setText(nombre);
		servicesPanel.taDescripcion.setText(descripcion);
		servicesPanel.tfPrecio.setText(String.valueOf(precio));
	}
	
// METODOS SECUNDARIOS
	public void addActionListenerToButtons () {
		servicesPanel.btn1824.addActionListener(this);
		servicesPanel.btnBlue.addActionListener(this);
		servicesPanel.btnBorrar.addActionListener(this);
		servicesPanel.btnGuardar.addActionListener(this);
		servicesPanel.cbSector.addActionListener(this);
		servicesPanel.chbNuevo.addActionListener(this);
	}
	
	/**
	 * Detecta el numero de click que hace el raton sobre la lista
	 */
	public void mouseListener () {
		servicesPanel.listServicios.addMouseListener(new MouseAdapter() { 
			public void mouseClicked(MouseEvent evt) { 
				JList list = (JList)evt.getSource(); 
				if (evt.getClickCount() == 1) { 
					index = list.locationToIndex(evt.getPoint());
					mueveServicio();
				}
			}
		});
	}
	
	/**
	 * Comprubea que el TextArea que se le pasa por parametro contiene algo de texto, de ser asi devuelve true
	 * @param ta
	 * @return
	 */
	public boolean taRellenado (JTextArea ta) {
		if (ta.getText().length() == 0) {
			return (false);
		} else {
			return (true);
		}
	}
	
	public boolean tfRellenado (JTextField tf) {
		if (tf.getText().length() == 0) {
			return (false);
		} else {
			return (true);
		}
	}
	
	public void actualizaFichero() {
		Ficheros.guardaArrayServicios(aServicios, archivo_activo);
	}
	
//	public void actualizaArrayServicios() {
//		switch (sector) {
//		case 0: Servicios.getFichServiciosBlue(); break;
//		case 1: Servicios.getFichServicios1824(); break;
//		case 2: Servicios.getFichServiciosAgency(); break;
//		default: //mensaje de error;
//		}
//	}
	
	public void modificaOCrea() {
		if (modoNuevo) {
			System.out.println("modificar");
			modoNuevo = false;
		} else {
			System.out.println("Crear");
			modoNuevo = true;
		}
	}
	
	public void clickBorrar () {
		if (index != -1) {
			aServicios.remove(index);
			actualizaFichero();
			cargarLista();
			Ficheros.mensaje(servicesPanel, "Servicio borrado corractamente", "");
		}
	}
	
	public void limpiaCampos() {
		servicesPanel.tfID.setText("");
		servicesPanel.tfNombre.setText("");
		servicesPanel.taDescripcion.setText("");
		servicesPanel.tfPrecio.setText("");
	}
	
}
