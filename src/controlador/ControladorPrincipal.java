package controlador;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JList;
import javax.swing.JOptionPane;

import eventos.Ficheros;
import eventos.Reports;
import modelo.Cliente;
import modelo.Servicios;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import reports_modelo.CampanaAds;
import reports_modelo.ContenidoAudioVisual;
import reports_modelo.ContenidoAudioVisual1824;
import reports_modelo.DisenoPacking1824;
import reports_modelo.DisenoProducto1824;
import reports_modelo.LandingPage;
import reports_modelo.Logotipos1824;
import reports_modelo.Modelado3D1824;
import reports_modelo.Naming1824;
import reports_modelo.PackCeleste;
import reports_modelo.PackCian;
import reports_modelo.PackTurquesa;
import reports_modelo.PackZafiro;
import reports_modelo.TiendaOnline;
import reports_modelo.WebCorporativa;
import vista.PanelClientes;
import vista.PanelPrincipal;
import vista.PanelServicios;

public class ControladorPrincipal implements ActionListener {
	
	private PanelPrincipal mainPanel;
	
	public String fich_servicios = Servicios.getFichServicios();
	public int sector_activo;
	private static ArrayList<Servicios> aServicios;
	private ArrayList<Servicios> aTableService;
	private Cliente cliente;
	
	public static List<JasperPrint> jasperPrintList;
	private static List<WebCorporativa> listWebCorporativa;
	private static List<CampanaAds> listCampanaAds;
	private static List<ContenidoAudioVisual> listContenidoAudioVisual;
	private static List<LandingPage> listLandingPage;
	private static List<PackCeleste> listPackCeleste;
	private static List<PackCian> listPackCian;
	private static List<PackTurquesa> listPackTurquesa;
	private static List<PackZafiro> listPackZafiro;
	private static List<TiendaOnline> listTiendaOnline;
	
	private static List<ContenidoAudioVisual1824> listContenidoAudioVisual1824;
	private static List<DisenoPacking1824> listDisenoPacking;
	private static List<DisenoProducto1824> listDisenoProducto;
	private static List<Logotipos1824> listLogotipos;
	private static List<Modelado3D1824> listModelado3D;
	private static List<Naming1824> listNaming;
	
	private HashMap<Integer,Integer> tracking;
	private HashMap<Integer,JasperPrint> jpHashMap;
	private static JasperPrint jpCampanaAds;
	private static JasperPrint jpWebCorporativa;
	private static JasperPrint jpContenidoAudioVisual;
	private static JasperPrint jpLandingPage;
	private static JasperPrint jpPackCeleste;
	private static JasperPrint jpPackCian;
	private static JasperPrint jpPackTurquesa;
	private static JasperPrint jpPackZafiro;
	private static JasperPrint jpTiendaOnline;
	
	private static JasperPrint jpContenidoAudioVisual1824;
	private static JasperPrint jpDisenoPacking;
	private static JasperPrint jpDisenoProducto;
	private static JasperPrint jpLogotipos;
	private static JasperPrint jpModelado3D;
	private static JasperPrint jpNaming;
	
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
			sector_activo = Servicios.getSectorBlue();
			cargaLista();
		}
		else if (e.getSource() == mainPanel.btn1824) {
			sector_activo = Servicios.getSector1824();
			cargaLista();
		}
		else if (e.getSource() == mainPanel.btnAgency) {
			sector_activo = Servicios.getSectorAgency();
			cargaLista();
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
		else if (e.getSource() == mainPanel.btnLimpiar) {
			resetAll();
		}
	}
	
	
//METODOS PRINCIPALES
	/**
	 * Realiza las instancias iniciales correspondiente del programa para que nada pete
	 * Tambi?n llama a los m?todos principales que pondr?n todo en su sitio
	 */
	public void inicio () {
		aServicios = new ArrayList<Servicios>();
		sector_activo = Servicios.getSectorBlue();
		tracking = new HashMap<Integer,Integer>();
		
		//JASPER REPORTS RESOURCE
		jasperPrintList = new ArrayList<JasperPrint>();
		
		listCampanaAds =  new ArrayList<CampanaAds>();
		listWebCorporativa = new ArrayList<WebCorporativa>();
		listContenidoAudioVisual = new ArrayList<ContenidoAudioVisual>();
		listLandingPage = new ArrayList<LandingPage>();
		listPackCeleste = new ArrayList<PackCeleste>();
		listPackCian = new ArrayList<PackCian>();
		listPackTurquesa = new ArrayList<PackTurquesa>();
		listPackZafiro = new ArrayList<PackZafiro>();
		listTiendaOnline = new ArrayList<TiendaOnline>();
		
		listContenidoAudioVisual1824 = new ArrayList<ContenidoAudioVisual1824>();
		listDisenoPacking = new ArrayList<DisenoPacking1824>();
		listDisenoProducto = new ArrayList<DisenoProducto1824>();
		listLogotipos = new ArrayList<Logotipos1824>();
		listModelado3D = new ArrayList<Modelado3D1824>();
		listNaming = new ArrayList<Naming1824>();
		
		jpCampanaAds = null;
		jpWebCorporativa = null;
		jpContenidoAudioVisual = null;
		jpLandingPage = null;
		jpPackCeleste = null;
		jpPackCian = null;
		jpPackTurquesa = null;
		jpPackZafiro = null;
		jpTiendaOnline = null;
		
		jpContenidoAudioVisual1824 = null;
		jpDisenoPacking = null;
		jpDisenoProducto = null;
		jpLogotipos = null;
		jpModelado3D = null;
		jpNaming = null;
		// --------- //
		
		initHashMap();
		aTableService = new ArrayList<Servicios>();
		cargaLista();
	}
	
	public void mueveServicio () {
		int servicio_seleccionado = damePosEnArray(); //mainPanel.listServicios.getSelectedIndex();
		
		Object [] fila = new Object[tableColumn];
		fila[0] = ControladorPrincipal.getaServicios().get(servicio_seleccionado).get_id();
		fila[1] = ControladorPrincipal.getaServicios().get(servicio_seleccionado).getNombre();
		fila[2] = ControladorPrincipal.getaServicios().get(servicio_seleccionado).getDescripcion();
		fila[3] = ControladorPrincipal.getaServicios().get(servicio_seleccionado).getPrecio();
		mainPanel.modeloTabla.addRow (fila); // A?ade una fila al final
		
		aTableService.add(ControladorPrincipal.getaServicios().get(servicio_seleccionado));
	}
	//dfdf
	public int damePosEnArray () {
		int dev = 0;
		String nombre = mainPanel.listServicios.getSelectedValue().toString();
		for (int i = 0; i < aServicios.size(); i++) {
			if (aServicios.get(i).getNombre().equals(nombre) && aServicios.get(i).getSector() == sector_activo) {
				dev = i;
				i = aServicios.size();
				System.out.println("damePosArray: " + dev);
			}
		}
		return dev;
	}
	
	/**
	 * Genera informes en los que se involucran varios .jasper
	 */
	public static void generaInforme () {
		JRPdfExporter exp = new JRPdfExporter(); 
		exp.setExporterInput(SimpleExporterInput.getInstance(jasperPrintList)); 
		exp.setExporterOutput(new SimpleOutputStreamExporterOutput(nombre_pdf)); 
		try { 
			exp.exportReport(); 
			JOptionPane.showMessageDialog( null, "Informe generado y almacenado", "PDF Guardado", JOptionPane.PLAIN_MESSAGE ); 
		} catch (JRException e1) { // TODO Auto-generated catch block
			e1.printStackTrace(); 
		}
	}
	

	public void cargaLista () { //aqui
		aServicios.clear();
		mainPanel.modeloServicios.clear();
		
		Ficheros.leeFicheroServicios(aServicios,fich_servicios);
		int indexServ = 0;
		for (int i = 0; i < aServicios.size(); i++) {
			if (aServicios.get(i).getSector() == sector_activo) {
				mainPanel.modeloServicios.add(indexServ, aServicios.get(i).getNombre());
				indexServ ++;
			}
		}
		mainPanel.scrollPane_1.setViewportView(mainPanel.listServicios);
		mainPanel.listServicios.setFont(new Font("Tahoma", Font.PLAIN, 24));
		mainPanel.listServicios.setModel(mainPanel.modeloServicios);
	}
	
	
//METODOS SECUNDARIOS
	/**
	 * Implemente el m?todo addActionListener() a todos los botones que sean necesarios
	 */
	public void addActionListenerToButtons () {
		mainPanel.btnBlue.addActionListener(this);
		mainPanel.btn1824.addActionListener(this);
		mainPanel.btnAgency.addActionListener(this);
		
		mainPanel.btnVer.addActionListener(this);
		mainPanel.btnGenera.addActionListener(this);
		mainPanel.btnCliente.addActionListener(this);
		mainPanel.btnAdminServicios.addActionListener(this);
		mainPanel.btnLimpiar.addActionListener(this);
		
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
					//int index = list.locationToIndex(evt.getPoint());
					if (administraReports(/*index*/)) {
						mueveServicio();
					}
				}
			}
		});
	}
	
	//suponiendo que ahora solo trabajemos con blue, esto s epodria gestionar con ids
	//tambien se debe comprobar de que no se incluyen dos veces el mismo servicio a la tabla
	public boolean administraReports(/*int index*/) {
		int index = damePosEnArray();
		String nombre = aServicios.get(index).getNombre();
		int sector = aServicios.get(index).getSector();
		System.out.println("index:" + index + "  nombre:" + nombre + "  sector;"+ sector);
		boolean dev = false;
		if (nombre.equals("Campa?a Ads")) {
			listCampanaAds.add(new CampanaAds());
			if (jpCampanaAds == null) {
				try { 
					jpCampanaAds = JasperFillManager.fillReport(Reports.jrCampanaAds, null,new JRBeanCollectionDataSource(listCampanaAds));
					jasperPrintList.add(jpCampanaAds);
					dev = true;
				} catch (Exception e1) { 
					e1.printStackTrace();
				}
			} else { Ficheros.mensajeError(mainPanel, "El servicio ya est? seleccionado", "Cuidado!"); }
		}
		else if (nombre.equals("Web Corporativa")) {
			listWebCorporativa.add(new WebCorporativa());
			if (jpWebCorporativa == null) {
				try { 
					jpWebCorporativa = JasperFillManager.fillReport(Reports.jrWebCorporativa, null,new JRBeanCollectionDataSource(listWebCorporativa));
					jasperPrintList.add(jpWebCorporativa);
					dev = true;
				} catch (Exception e1) { 
					e1.printStackTrace(); 
				}
			} else {Ficheros.mensajeError(mainPanel, "El servicio ya est? seleccionado", "Cuidado!");}
		}
		else if (nombre.equals("Contenido AudioVisual") && sector == Servicios.getSectorBlue()) {
			listContenidoAudioVisual.add(new ContenidoAudioVisual());
			if (jpContenidoAudioVisual == null) {
				try { 
					jpContenidoAudioVisual = JasperFillManager.fillReport(Reports.jrContenidoAudioVisual, null,new JRBeanCollectionDataSource(listContenidoAudioVisual));
					jasperPrintList.add(jpContenidoAudioVisual);
					dev = true;
				} catch (Exception e1) { 
					e1.printStackTrace(); 
				}
			} else {Ficheros.mensajeError(mainPanel, "El servicio ya est? seleccionado", "Cuidado!");}
		}
		else if (nombre.equals("Landing Page")) {
			listLandingPage.add(new LandingPage());
			if (jpLandingPage == null) {
				try { 
					jpLandingPage = JasperFillManager.fillReport(Reports.jrLandingPage, null,new JRBeanCollectionDataSource(listLandingPage));
					jasperPrintList.add(jpLandingPage);
					dev = true;
				} catch (Exception e1) { 
					e1.printStackTrace(); 
				}
			} else {Ficheros.mensajeError(mainPanel, "El servicio ya est? seleccionado", "Cuidado!");}
		}
		else if (nombre.equals("Pack Celeste")) {
			listPackCeleste.add(new PackCeleste());
			if (jpPackCeleste == null) {
				try { 
					jpPackCeleste = JasperFillManager.fillReport(Reports.jrPackCeleste, null,new JRBeanCollectionDataSource(listPackCeleste));
					jasperPrintList.add(jpPackCeleste);
					dev = true;
				} catch (Exception e1) { 
					e1.printStackTrace(); 
				}
			} else {Ficheros.mensajeError(mainPanel, "El servicio ya est? seleccionado", "Cuidado!");}
		}
		else if (nombre.equals("Pack Cian")) {
			listPackCian.add(new PackCian());
			if (jpPackCian == null) {
				try { 
					jpPackCian = JasperFillManager.fillReport(Reports.jrPackCian, null,new JRBeanCollectionDataSource(listPackCian));
					jasperPrintList.add(jpPackCian);
					dev = true;
				} catch (Exception e1) { 
					e1.printStackTrace(); 
				}
			} else {Ficheros.mensajeError(mainPanel, "El servicio ya est? seleccionado", "Cuidado!");}
		}
		else if (nombre.equals("Pack Turquesa")) {
			listPackTurquesa.add(new PackTurquesa());
			if (jpPackTurquesa == null) {
				try { 
					jpPackTurquesa = JasperFillManager.fillReport(Reports.jrPackTurquesa, null,new JRBeanCollectionDataSource(listPackTurquesa));
					jasperPrintList.add(jpPackTurquesa);
					dev = true;
				} catch (Exception e1) { 
					e1.printStackTrace(); 
				}
			} else {Ficheros.mensajeError(mainPanel, "El servicio ya est? seleccionado", "Cuidado!");}
		}
		else if (nombre.equals("Pack Zafiro")) {
			listPackZafiro.add(new PackZafiro());
			if (jpPackZafiro == null) {
				try { 
					jpPackZafiro = JasperFillManager.fillReport(Reports.jrPackZafiro, null,new JRBeanCollectionDataSource(listPackZafiro));
					jasperPrintList.add(jpPackZafiro);
					dev = true;
				} catch (Exception e1) { 
					e1.printStackTrace(); 
				}
			} else {Ficheros.mensajeError(mainPanel, "El servicio ya est? seleccionado", "Cuidado!");}
		}
		else if (nombre.equals("Tienda Online")) {
			listTiendaOnline.add(new TiendaOnline());
			if (jpTiendaOnline == null) {
				try { 
					jpTiendaOnline = JasperFillManager.fillReport(Reports.jrTiendaOnline, null,new JRBeanCollectionDataSource(listTiendaOnline));
					jasperPrintList.add(jpTiendaOnline);
					dev = true;
				} catch (Exception e1) { 
					e1.printStackTrace(); 
				}
			} else {Ficheros.mensajeError(mainPanel, "El servicio ya est? seleccionado", "Cuidado!");}
		}
		else if (nombre.equals("Contenido Audiovisual") && sector == Servicios.getSector1824()) {
			listContenidoAudioVisual1824.add(new ContenidoAudioVisual1824());
			if (jpContenidoAudioVisual1824 == null) {
				try { 
					jpContenidoAudioVisual1824 = JasperFillManager.fillReport(Reports.jrContenidoAudioVisual1824, null,new JRBeanCollectionDataSource(listContenidoAudioVisual1824));
					jasperPrintList.add(jpContenidoAudioVisual1824);
					dev = true;
				} catch (Exception e1) { 
					e1.printStackTrace(); 
				}
			} else {Ficheros.mensajeError(mainPanel, "El servicio ya est? seleccionado", "Cuidado!");}
		}
		else if (nombre.equals("Dise?o Packing") && sector == Servicios.getSector1824()) {
			listDisenoPacking.add(new DisenoPacking1824());
			if (jpDisenoPacking == null) {
				try { 
					jpDisenoPacking = JasperFillManager.fillReport(Reports.jrDisenoPacking, null,new JRBeanCollectionDataSource(listDisenoPacking));
					jasperPrintList.add(jpDisenoPacking);
					dev = true;
				} catch (Exception e1) { 
					e1.printStackTrace(); 
				}
			} else {Ficheros.mensajeError(mainPanel, "El servicio ya est? seleccionado", "Cuidado!");}
		}
		else if (nombre.equals("Dise?o Producto") && sector == Servicios.getSector1824()) {
			listDisenoProducto.add(new DisenoProducto1824());
			if (jpDisenoProducto == null) {
				try { 
					jpDisenoProducto = JasperFillManager.fillReport(Reports.jrDisenoProducto2, null,new JRBeanCollectionDataSource(listDisenoProducto));
					jasperPrintList.add(jpDisenoProducto);
					dev = true;
				} catch (Exception e1) { 
					e1.printStackTrace(); 
				}
			} else {Ficheros.mensajeError(mainPanel, "El servicio ya est? seleccionado", "Cuidado!");}
		}
		else if (nombre.equals("Logotipos") && sector == Servicios.getSector1824()) {
			listLogotipos.add(new Logotipos1824());
			if (jpLogotipos == null) {
				try { 
					jpLogotipos = JasperFillManager.fillReport(Reports.jrLogotipos, null,new JRBeanCollectionDataSource(listLogotipos));
					jasperPrintList.add(jpLogotipos);
					dev = true;
				} catch (Exception e1) { 
					e1.printStackTrace(); 
				}
			} else {Ficheros.mensajeError(mainPanel, "El servicio ya est? seleccionado", "Cuidado!");}
		}
		else if (nombre.equals("Modelado 3D") && sector == Servicios.getSector1824()) {
			listModelado3D.add(new Modelado3D1824());
			if (jpModelado3D == null) {
				try { 
					jpModelado3D = JasperFillManager.fillReport(Reports.jrModelado3D2, null,new JRBeanCollectionDataSource(listModelado3D));
					jasperPrintList.add(jpModelado3D);
					dev = true;
				} catch (Exception e1) { 
					e1.printStackTrace(); 
				}
			} else {Ficheros.mensajeError(mainPanel, "El servicio ya est? seleccionado", "Cuidado!");}
		}
		else if (nombre.equals("Naming") && sector == Servicios.getSector1824()) {
			listNaming.add(new Naming1824());
			if (jpNaming == null) {
				try { 
					jpNaming = JasperFillManager.fillReport(Reports.jrNaming, null,new JRBeanCollectionDataSource(listNaming));
					jasperPrintList.add(jpNaming);
					dev = true;
				} catch (Exception e1) { 
					e1.printStackTrace(); 
				}
			} else {Ficheros.mensajeError(mainPanel, "El servicio ya est? seleccionado", "Cuidado!");}
		}
		else {
			System.out.println("No se reoconoce el servicio");
		}
			
		return dev;
	}
	
	/**
	 * Recibe el id del servicio seleccionado y debe pasar el jp y el arrayList correspondiente a la ventana PanelSetServices para que esta guarde los cambios 
	 * de alguna manera.
	 * @param id
	 */
	public static void modificaServicioActual (int id) {
		//
	}
	
	public static void deletePagePDF (int index, int id) {
		jasperPrintList.remove(index);
		putNullJPrint(id);
	}
	
	/**
	 * Le pasas un id, mira a que objeto de reports_model pertence y busca su respectivo jprint para colocarlo en null
	 * @param id
	 */
	public static void putNullJPrint (int id) {
		if (id == 1) { 
			jpLandingPage = null;
			listLandingPage.clear();
		}
		else if (id == 2) {
			jpWebCorporativa = null;
			listWebCorporativa.clear();
		}
		else if (id == 3) {
			jpContenidoAudioVisual = null;
			listContenidoAudioVisual.clear();
		}
		else if (id == 4) {
			jpCampanaAds = null;
			listCampanaAds.clear();
		}
		else if (id == 5) {
			jpPackCeleste = null;
			listPackCeleste.clear();
		}
		else if (id == 6) {
			jpPackCian = null;
			listPackCian.clear();
		}
		else if (id == 7) {
			jpPackTurquesa = null;
			listPackTurquesa.clear();
		}
		else if (id == 8) {
			jpPackZafiro = null;
			listPackZafiro.clear();
		}
		else if (id == 9) {
			jpTiendaOnline = null;
			listTiendaOnline.clear();
		}
		else if (id == 10) {
			jpContenidoAudioVisual1824 = null;
			listContenidoAudioVisual1824.clear();
		}
		else if (id == 11) {
			jpDisenoPacking = null;
			listDisenoPacking.clear();
		}
		else if (id == 12) {
			jpDisenoProducto = null;
			listDisenoProducto.clear();
		}
		else if (id == 13) {
			jpLogotipos = null;
			listLogotipos.clear();
		}
		else if (id == 14) {
			jpModelado3D = null;
			listModelado3D.clear();
		}
		else if (id == 15) {
			jpNaming = null;
			listNaming.clear();
		}
	}
	
	/**
	 * Coloca los jasperPrints a null y los ArrayList son limpiados
	 */
	public void resetAll () {
		jpLandingPage = null;
		jpWebCorporativa = null;
		jpContenidoAudioVisual = null;
		jpCampanaAds = null;
		jpPackCeleste = null;
		jpPackCian = null;
		jpPackTurquesa = null;
		jpPackZafiro = null;
		jpTiendaOnline = null;
		
		jpContenidoAudioVisual1824 = null;
		jpDisenoPacking = null;
		jpDisenoProducto = null;
		jpLogotipos = null;
		jpModelado3D = null;
		jpNaming = null;
		
		listLandingPage.clear();
		listWebCorporativa.clear();
		listContenidoAudioVisual.clear();
		listCampanaAds.clear();
		listPackCeleste.clear();
		listPackCian.clear();
		listPackTurquesa.clear();
		listPackZafiro.clear();
		listTiendaOnline.clear();
		
		listContenidoAudioVisual1824.clear();
		listDisenoPacking.clear();
		listDisenoProducto.clear();
		listLogotipos.clear();
		listModelado3D.clear();
		listNaming.clear();
		
		mainPanel.limpiaTabla();
		
		jasperPrintList.clear();
	}
	
	// HASHMAP
	public void initJasperMap () {
		System.out.print("");
	}
	
	/**
	 * HASH MAP: Se usar? para el tracking de los servicios, la clave ser? su id y el valor el estado
	 * Activo (introducido en el pdf) : 1
	 * @param index
	 */
	public void initHashMap () {
		for (int i = 0; i < aServicios.size(); i++) {
			tracking.put(aServicios.get(i).get_id(), 0);
		}
	}
	
	
//GETERS Y SETERS
	public static ArrayList<Servicios> getaServicios() {
		return aServicios;
	}
	public void setaServicios(ArrayList<Servicios> aServicios) {
		this.aServicios = aServicios;
	}

	public String getArchivo_activo() {
		return fich_servicios;
	}
	public void setArchivo_activo(String archivo_activo) {
		this.fich_servicios = archivo_activo;
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

	public PanelPrincipal getMainPanel() {
		return mainPanel;
	}

	public void setMainPanel(PanelPrincipal mainPanel) {
		this.mainPanel = mainPanel;
	}

	public String getFich_servicios() {
		return fich_servicios;
	}

	public void setFich_servicios(String fich_servicios) {
		this.fich_servicios = fich_servicios;
	}

	public int getSector_activo() {
		return sector_activo;
	}

	public void setSector_activo(int sector_activo) {
		this.sector_activo = sector_activo;
	}

	public ArrayList<Servicios> getaTableService() {
		return aTableService;
	}

	public void setaTableService(ArrayList<Servicios> aTableService) {
		this.aTableService = aTableService;
	}

	public static List<JasperPrint> getJasperPrintList() {
		return jasperPrintList;
	}

	public static void setJasperPrintList(List<JasperPrint> jasperPrintList) {
		ControladorPrincipal.jasperPrintList = jasperPrintList;
	}

	public static List<WebCorporativa> getListWebCorporativa() {
		return listWebCorporativa;
	}

	public static void setListWebCorporativa(List<WebCorporativa> listWebCorporativa) {
		ControladorPrincipal.listWebCorporativa = listWebCorporativa;
	}

	public static List<CampanaAds> getListCampanaAds() {
		return listCampanaAds;
	}

	public static void setListCampanaAds(List<CampanaAds> listCampanaAds) {
		ControladorPrincipal.listCampanaAds = listCampanaAds;
	}

	public static List<ContenidoAudioVisual> getListContenidoAudioVisual() {
		return listContenidoAudioVisual;
	}

	public static void setListContenidoAudioVisual(List<ContenidoAudioVisual> listContenidoAudioVisual) {
		ControladorPrincipal.listContenidoAudioVisual = listContenidoAudioVisual;
	}

	public static List<LandingPage> getListLandingPage() {
		return listLandingPage;
	}

	public static void setListLandingPage(List<LandingPage> listLandingPage) {
		ControladorPrincipal.listLandingPage = listLandingPage;
	}

	public static List<PackCeleste> getListPackCeleste() {
		return listPackCeleste;
	}

	public static void setListPackCeleste(List<PackCeleste> listPackCeleste) {
		ControladorPrincipal.listPackCeleste = listPackCeleste;
	}

	public static List<PackCian> getListPackCian() {
		return listPackCian;
	}

	public static void setListPackCian(List<PackCian> listPackCian) {
		ControladorPrincipal.listPackCian = listPackCian;
	}

	public static List<PackTurquesa> getListPackTurquesa() {
		return listPackTurquesa;
	}

	public static void setListPackTurquesa(List<PackTurquesa> listPackTurquesa) {
		ControladorPrincipal.listPackTurquesa = listPackTurquesa;
	}

	public static List<PackZafiro> getListPackZafiro() {
		return listPackZafiro;
	}

	public static void setListPackZafiro(List<PackZafiro> listPackZafiro) {
		ControladorPrincipal.listPackZafiro = listPackZafiro;
	}

	public static List<TiendaOnline> getListTiendaOnline() {
		return listTiendaOnline;
	}

	public static void setListTiendaOnline(List<TiendaOnline> listTiendaOnline) {
		ControladorPrincipal.listTiendaOnline = listTiendaOnline;
	}

	public HashMap<Integer, Integer> getTracking() {
		return tracking;
	}

	public void setTracking(HashMap<Integer, Integer> tracking) {
		this.tracking = tracking;
	}

	public HashMap<Integer, JasperPrint> getJpHashMap() {
		return jpHashMap;
	}

	public void setJpHashMap(HashMap<Integer, JasperPrint> jpHashMap) {
		this.jpHashMap = jpHashMap;
	}

	public static JasperPrint getJpCampanaAds() {
		return jpCampanaAds;
	}

	public static void setJpCampanaAds(JasperPrint jpCampanaAds) {
		ControladorPrincipal.jpCampanaAds = jpCampanaAds;
	}

	public static JasperPrint getJpWebCorporativa() {
		return jpWebCorporativa;
	}

	public static void setJpWebCorporativa(JasperPrint jpWebCorporativa) {
		ControladorPrincipal.jpWebCorporativa = jpWebCorporativa;
	}

	public static JasperPrint getJpContenidoAudioVisual() {
		return jpContenidoAudioVisual;
	}

	public static void setJpContenidoAudioVisual(JasperPrint jpContenidoAudioVisual) {
		ControladorPrincipal.jpContenidoAudioVisual = jpContenidoAudioVisual;
	}

	public static JasperPrint getJpLandingPage() {
		return jpLandingPage;
	}

	public static void setJpLandingPage(JasperPrint jpLandingPage) {
		ControladorPrincipal.jpLandingPage = jpLandingPage;
	}

	public static JasperPrint getJpPackCeleste() {
		return jpPackCeleste;
	}

	public static void setJpPackCeleste(JasperPrint jpPackCeleste) {
		ControladorPrincipal.jpPackCeleste = jpPackCeleste;
	}

	public static JasperPrint getJpPackCian() {
		return jpPackCian;
	}

	public static void setJpPackCian(JasperPrint jpPackCian) {
		ControladorPrincipal.jpPackCian = jpPackCian;
	}

	public static JasperPrint getJpPackTurquesa() {
		return jpPackTurquesa;
	}

	public static void setJpPackTurquesa(JasperPrint jpPackTurquesa) {
		ControladorPrincipal.jpPackTurquesa = jpPackTurquesa;
	}

	public static JasperPrint getJpPackZafiro() {
		return jpPackZafiro;
	}

	public static void setJpPackZafiro(JasperPrint jpPackZafiro) {
		ControladorPrincipal.jpPackZafiro = jpPackZafiro;
	}

	public static JasperPrint getJpTiendaOnline() {
		return jpTiendaOnline;
	}

	public static void setJpTiendaOnline(JasperPrint jpTiendaOnline) {
		ControladorPrincipal.jpTiendaOnline = jpTiendaOnline;
	}

	public int getTableColumn() {
		return tableColumn;
	}

	public void setTableColumn(int tableColumn) {
		this.tableColumn = tableColumn;
	}
	
}
