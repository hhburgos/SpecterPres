package vista;

import java.awt.BorderLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import eventos.Ficheros;
import modelo.Servicios;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JToggleButton;

public class PanelServicios extends JDialog {
	
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private String archivo_activo = Servicios.getFichServiciosBlue();
	private DefaultListModel<String> modeloServicios = new DefaultListModel<String>();
	
	public JTextField tfID;
	public JTextField tfNombre;
	public JTextField tfPrecio;
	public JTextArea taDescripcion;
	public JList<String> listServicios;
	public JComboBox<String> cbSector;
	public JButton btnBlue;
	public JButton btn1824;
	public JButton btnBorrar;
	public JButton btnGuardar;
	public JCheckBox chbNuevo; //min 21 - https://www.youtube.com/watch?v=6eyMT-Dn1fM
		
	private ArrayList<Servicios> aServicios;
	private JScrollPane scrollPane_1;
	private boolean modoNuevo; //si está en false es que va a modificar los campos de un servicio existente
	private int sector = 0; //0:Blue  1:1824  2:Agency
	private int index = -1; //index del servicio activo en cada momento
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			PanelServicios dialog = new PanelServicios();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	public void clickBorrar () {
		if (index != -1) {
			aServicios.remove(index);
			actualizaFichero();
			cargarLista();
			Ficheros.mensaje(this, "Servicio borrado corractamente", "");
		}
	}
	
	public void clickGuardar () {
		if (modoNuevo) {
			creaNuevoServicio();
		} else {
			actualizarServicio();
		}
	}
	
	public void modificaOCrea() {
		if (modoNuevo) {
			System.out.println("modificar");
			modoNuevo = false;
		} else {
			System.out.println("Crear");
			modoNuevo = true;
		}
	}
	
	public void actualizarServicio() {
		if (tfRellenado(tfNombre) || tfRellenado(tfPrecio) || taRellenado(taDescripcion)) {
			String nombre = tfNombre.getText();
			String descripcion = taDescripcion.getText();
			double precio = Double.valueOf(tfPrecio.getText()); //captar exception

			aServicios.get(index).setNombre(nombre);
			aServicios.get(index).setDescripcion(descripcion);
			aServicios.get(index).setPrecio(precio);
			
			actualizaFichero();
			limpiaCampos();
			cargarLista();
		}
		else { Ficheros.mensajeError(this, "Debes rellenar todos los campos", "ERROR"); }
	}
	
	public void creaNuevoServicio() {
		//camposLlenos()
		//suponiendo que todos los campos estan llenos
		if (tfRellenado(tfNombre) || tfRellenado(tfPrecio) || taRellenado(taDescripcion)) {
			String nombre = tfNombre.getText();
			String descripcion = taDescripcion.getText();
			double precio = Double.valueOf(tfPrecio.getText());
			
			Servicios nuevo_servicio = new Servicios(nombre, descripcion, precio);
			actualizaArrayServicios();
			aServicios.add(nuevo_servicio);
			
			actualizaFichero();
			limpiaCampos();
			cargarLista();
		}
		else { Ficheros.mensajeError(this, "Debes rellenar todos los campos", "ERROR"); }
	}
		
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
	
	public void actualizaArrayServicios() {
		switch (sector) {
		case 0: Servicios.getFichServiciosBlue(); break;
		case 1: Servicios.getFichServicios1824(); break;
		case 2: Servicios.getFichServiciosAgency(); break;
		default: //mensaje de error;
		}
	}
	
	public void cargarLista () {
		aServicios.clear();
		modeloServicios.clear();
		
		Ficheros.leeFicheroServicios(aServicios,archivo_activo);
		for (int i = 0; i < aServicios.size(); i++) {
			modeloServicios.add(i, aServicios.get(i).getNombre());
//			System.out.println("buc:"  + i);
		}
		scrollPane_1.setViewportView(listServicios);
		listServicios.setFont(new Font("Tahoma", Font.PLAIN, 24));
		listServicios.setModel(modeloServicios);
	}
	
	public void mueveServicio () {
		int id = aServicios.get(index).get_id();
		String nombre = aServicios.get(index).getNombre();
		String descripcion = aServicios.get(index).getDescripcion();
		Double precio = aServicios.get(index).getPrecio();
		
		limpiaCampos();
		
		tfID.setText(String.valueOf(id));
		tfNombre.setText(nombre);
		taDescripcion.setText(descripcion);
		tfPrecio.setText(String.valueOf(precio));
	}
	
	public void limpiaCampos() {
		tfID.setText("");
		tfNombre.setText("");
		taDescripcion.setText("");
		tfPrecio.setText("");
	}

// ------------ VISUAL ------------- //
	/**
	 * Create the dialog.
	 */
	public PanelServicios() {
		setModal(true);
		setBounds(100, 100, 808, 468);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		creaLabels();
		creaCByList();
		creaTFyTA();
		creaBotones();
		
		//logica
		modoNuevo = true;
		aServicios = new ArrayList<Servicios>();
		chbNuevo.setSelected(true);

		cargarLista();
	}
	
	public void creaBotones() {
		btnBlue = new JButton("SPECTER BLUE");
		btnBlue.setBackground(new Color(135, 206, 250));
		btnBlue.setBounds(401, 36, 139, 32);
		contentPanel.add(btnBlue);
		
		btn1824 = new JButton("SPECTER 1824");
		btn1824.setBackground(new Color(218, 165, 32));
		btn1824.setBounds(553, 36, 139, 32);
		contentPanel.add(btn1824);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnBorrar.setBounds(402, 339, 156, 42);
		contentPanel.add(btnBorrar);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnGuardar.setBounds(603, 339, 156, 42);
		contentPanel.add(btnGuardar);

		chbNuevo = new JCheckBox("NUEVO");
		chbNuevo.setFont(new Font("Tahoma", Font.BOLD, 18));
		chbNuevo.setBounds(29, 366, 145, 25);
		contentPanel.add(chbNuevo);
	}
	
	public void creaLabels() {
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(29, 36, 56, 22);
		contentPanel.add(lblNewLabel);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPrecio.setBounds(29, 287, 101, 22);
		contentPanel.add(lblPrecio);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n:");
		lblDescripcin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDescripcin.setBounds(29, 129, 128, 22);
		contentPanel.add(lblDescripcin);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNombre.setBounds(29, 81, 101, 22);
		contentPanel.add(lblNombre);
	}

	public void creaTFyTA() {
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 165, 302, 96);
		contentPanel.add(scrollPane);
		
		tfPrecio = new JTextField();
		tfPrecio.setColumns(10);
		tfPrecio.setBounds(125, 287, 116, 22);
		contentPanel.add(tfPrecio);
		
		tfID = new JTextField();
		tfID.setEditable(false);
		tfID.setBounds(70, 39, 86, 22);
		contentPanel.add(tfID);
		tfID.setColumns(10);
		
		tfNombre = new JTextField();
		tfNombre.setColumns(10);
		tfNombre.setBounds(125, 81, 200, 22);
		contentPanel.add(tfNombre);
		
		taDescripcion = new JTextArea();
		scrollPane.setViewportView(taDescripcion);
	}

	public void creaCByList() {
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(402, 81, 356, 228);
		contentPanel.add(scrollPane_1);
		
		listServicios = new JList();
		scrollPane_1.setViewportView(listServicios);
		listServicios.addMouseListener(new MouseAdapter() { 
			public void mouseClicked(MouseEvent evt) { 
				JList list = (JList)evt.getSource(); 
				if (evt.getClickCount() == 1) { 
					index = list.locationToIndex(evt.getPoint());
					mueveServicio();
				}
			}
		});
		
		cbSector = new JComboBox();
		cbSector.setBounds(169, 36, 156, 25);
		contentPanel.add(cbSector);
		cbSector.addItem("BLUE");
		cbSector.addItem("1824");
		cbSector.addItem("AGENCY");
	}
}
