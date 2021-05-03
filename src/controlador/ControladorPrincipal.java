package controlador;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JList;
import javax.swing.JOptionPane;

import eventos.Ficheros;
import eventos.Reports;
import modelo.Cliente;
import modelo.Prueba;
import modelo.Servicios;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import reports_modelo.CampanaAds;
import reports_modelo.Glosario;
import reports_modelo.WebCorporativa;
import vista.PanelClientes;
import vista.PanelPrincipal;
import vista.PanelServicios;

public class ControladorPrincipal implements ActionListener {
	
	private PanelPrincipal mainPanel;
	
	public String archivo_activo = Servicios.getFichServiciosBlue();
	private static ArrayList<Servicios> aServicios;
	private ArrayList<Servicios> aTableService;
	private Cliente cliente;
	
	private static List<JasperPrint> jasperPrintList;
	private List<WebCorporativa> listWebCorporativa;
	private List<CampanaAds> listCampanaAds;
	
	private JasperPrint jpCampanaAds;
	private JasperPrint jpWebCorporativa;
	
	private int tableColumn = 4;
	private static int modo = 1; // 1: borrar   5: edita
	private static String nombre_pdf = "InformePresupuesto.pdf";
	private String ruta_jasperreport = "src/vista/presupuestos.jasper";
	
	public ControladorPrincipal (PanelPrincipal pp) {
		mainPanel = pp;
		
		inicio();
		mouseListener();
		addActionListenerToButtons();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mainPanel.btnBlue) {
			archivo_activo = Servicios.getFichServiciosBlue();
			cargaLista();
		}
		else if (e.getSource() == mainPanel.btn1824) {
			archivo_activo = Servicios.getFichServicios1824();
			cargaLista();
		}
		else if (e.getSource() == mainPanel.btnAgency) {
//			archivo_activo = Servicios.getFichServiciosAgency();
//			cargaLista();
		}
		else if (e.getSource() == mainPanel.btnGenera) {
			generaInforme();
		}
		else if (e.getSource() == mainPanel.btnVer) {
//			generaInforme();
			System.out.println("funciona");
		}
		else if (e.getSource() == mainPanel.btnCliente) {
			PanelClientes ventana = new PanelClientes();
			ControladorClientes cc = new ControladorClientes(ventana, this);
			
			ventana.setVisible(true);
		}
		else if (e.getSource() == mainPanel.rbBorrar) {
			System.out.println("rbBorrar presionado");
			setModo(1);
		}
		else if (e.getSource() == mainPanel.rbEditar) {
			System.out.println("rbEditar presionado");
			setModo(5);
		}
		else if (e.getSource() == mainPanel.btnAdminServicios) {
			PanelServicios ps = new PanelServicios();
			ControladorServicios cs = new ControladorServicios(ps);
			
			ps.setVisible(true);
		}
	}
	
	// diciembre pedir cita 

	
//METODOS PRINCIPALES
	public void inicio () {
		aServicios = new ArrayList<Servicios>();
		
		//JASPER REPORTS RESOURCE
		jasperPrintList = new ArrayList<JasperPrint>();
		listCampanaAds =  new ArrayList<CampanaAds>();
		listWebCorporativa = new ArrayList<WebCorporativa>();
		
		jpCampanaAds = null;
		jpWebCorporativa = null;
		
		aTableService = new ArrayList<Servicios>();
		cargaLista();
	}
	
	public void mueveServicio () {
		int servicio_seleccionado = mainPanel.listServicios.getSelectedIndex();
		
		Object [] fila = new Object[tableColumn];
		fila[0] = ControladorPrincipal.getaServicios().get(servicio_seleccionado).get_id();
		fila[1] = ControladorPrincipal.getaServicios().get(servicio_seleccionado).getNombre();
		fila[2] = ControladorPrincipal.getaServicios().get(servicio_seleccionado).getDescripcion();
		fila[3] = ControladorPrincipal.getaServicios().get(servicio_seleccionado).getPrecio();
		mainPanel.modeloTabla.addRow (fila); // Añade una fila al final
		
		aTableService.add(ControladorPrincipal.getaServicios().get(servicio_seleccionado));
	}
	
	/**
	 * Genera informes en los que se involucran varios .jasper
	 */
	public static void generaInforme () {
		JRPdfExporter exp = new JRPdfExporter(); 
		exp.setExporterInput(SimpleExporterInput.getInstance(jasperPrintList)); 
		exp.setExporterOutput(new SimpleOutputStreamExporterOutput(nombre_pdf)); 
		JOptionPane.showMessageDialog( null, "Informe generado y almacenado", "PDF Guardado", JOptionPane.PLAIN_MESSAGE ); 
		try { 
			exp.exportReport(); 
		} catch (JRException e1) { // TODO Auto-generated catch block
			e1.printStackTrace(); 
//			JOptionPane.showMessageDialog( null, e1.getStackTrace(), "PDF Guardado", JOptionPane.PLAIN_MESSAGE ); 
		}
	}
	
	public void cargaLista () {
		aServicios.clear();
		mainPanel.modeloServicios.clear();
		
		Ficheros.leeFicheroServicios(aServicios,archivo_activo);
		for (int i = 0; i < aServicios.size(); i++) {
			mainPanel.modeloServicios.add(i, aServicios.get(i).getNombre());
		}
		mainPanel.scrollPane_1.setViewportView(mainPanel.listServicios);
		mainPanel.listServicios.setFont(new Font("Tahoma", Font.PLAIN, 24));
		mainPanel.listServicios.setModel(mainPanel.modeloServicios);
	}
	
	
//METODOS SECUNDARIOS
	/**
	 * Implemente el método addActionListener() a todos los botones que sean necesarios
	 */
	public void addActionListenerToButtons () {
		mainPanel.btnBlue.addActionListener(this);
		mainPanel.btn1824.addActionListener(this);
		mainPanel.btnAgency.addActionListener(this);
		mainPanel.btnGenera.addActionListener(this);
		
		mainPanel.btnVer.addActionListener(this);
		mainPanel.btnGenera.addActionListener(this);
		mainPanel.btnCliente.addActionListener(this);
		mainPanel.btnAdminServicios.addActionListener(this);
		
		mainPanel.rbEditar.addActionListener(this);
		mainPanel.rbBorrar.addActionListener(this);
	}
	
	public void colocarCliente () {
		// queda verificar que hay cliente. seguridad
		String nameCli = cliente.getNombre();
		mainPanel.tfCliente.setText(nameCli);
	}
	
	public void mouseListener () {
		mainPanel.listServicios.addMouseListener(new MouseAdapter() { 
			public void mouseClicked(MouseEvent evt) { 
				JList list = (JList)evt.getSource(); 
				if (evt.getClickCount() == 1) { 
					int index = list.locationToIndex(evt.getPoint());
					if (administraReports(index)) {
						mueveServicio();
					}
				}
			}
		});
	}
	
	//suponiendo que ahora solo trabajemos con blue, esto s epodria gestionar con ids
	//tambien se debe comprobar de que no se incluyen dos veces el mismo servicio a la tabla
	public boolean administraReports(int index) {
		String nombre = aServicios.get(index).getNombre();
		boolean dev = false;
		if (nombre.equals("Campaña Ads")) {
			listCampanaAds.add(new CampanaAds());
			if (jpCampanaAds == null) {
				try { 
					jpCampanaAds = JasperFillManager.fillReport(Reports.jrCampanaAds, null,new JRBeanCollectionDataSource(listCampanaAds));
					jasperPrintList.add(jpCampanaAds);
					dev = true;
				} catch (Exception e1) { 
					e1.printStackTrace();
				}
			} else { Ficheros.mensajeError(mainPanel, "El servicio ya está seleccionado", "Cuidado!"); }
		}
		else if (nombre.equals("Web Corporativa")) {
			listWebCorporativa.add(new WebCorporativa("*desde 1252€ + IVA","CannaMedicalBroker.com"));
			if (jpWebCorporativa == null) {
				try { 
					jpWebCorporativa = JasperFillManager.fillReport(Reports.jrWebCorporativa, null,new JRBeanCollectionDataSource(listWebCorporativa));
					jasperPrintList.add(jpWebCorporativa);
					dev = true;
				} catch (Exception e1) { 
					e1.printStackTrace(); 
				}
			} else {Ficheros.mensajeError(mainPanel, "El servicio ya está seleccionado", "Cuidado!");}
		}
		else {
			System.out.println("No se reoconoce el servicio");
		}
		
		return dev;
	}
	
	
//GETERS Y SETERS
	public static ArrayList<Servicios> getaServicios() {
		return aServicios;
	}
	public void setaServicios(ArrayList<Servicios> aServicios) {
		this.aServicios = aServicios;
	}

	public String getArchivo_activo() {
		return archivo_activo;
	}
	public void setArchivo_activo(String archivo_activo) {
		this.archivo_activo = archivo_activo;
	}

	public String getRuta_jasperreport() {
		return ruta_jasperreport;
	}
	public void setRuta_jasperreport(String ruta_jasperreport) {
		this.ruta_jasperreport = ruta_jasperreport;
	}

	public String getNombre_pdf() {
		return nombre_pdf;
	}
	public void setNombre_pdf(String nombre_pdf) {
		this.nombre_pdf = nombre_pdf;
	}

	public static int getModo() {
		return modo;
	}
	public static void setModo(int modo) {
		ControladorPrincipal.modo = modo;
	}

	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
