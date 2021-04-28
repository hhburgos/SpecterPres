package controlador;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;

import eventos.Ficheros;
import modelo.Prueba;
import modelo.Servicios;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import vista.PanelClientes;
import vista.PanelPrincipal;
import vista.PanelServicios;

public class ControladorPrincipal implements ActionListener {
	
	private PanelPrincipal mainPanel;
	
	public String archivo_activo = Servicios.getFichServiciosBlue();
	private static ArrayList<Servicios> aServicios;
	
	private static int modo = 1; // 1: borrar   5: edita
	private String nombre_pdf = "InformePresupuesto.pdf";
	private String ruta_jasperreport = "src/vista/presupuestos.jasper";
	
	public ControladorPrincipal (PanelPrincipal pp) {
		mainPanel = pp;
		
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
			generaInforme2();
		}
		else if (e.getSource() == mainPanel.btnVer) {
//			generaInforme();
			System.out.println("funciona");
		}
		else if (e.getSource() == mainPanel.btnCliente) {
			PanelClientes ventana = new PanelClientes(this);
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
	
	
//METODOS PRINCIPALES
	public void inicio () {
		aServicios = new ArrayList<Servicios>();
		
		cargaLista();
	}
	
	/**
	 * Imprime el informe directamente en el directorio raiz del proyecto, por lo que hay que
	 * hacer algo con el nombre del doc que se generar� si es el mismo siempre se cargar� el anterior siempre
	 */
	public void generaInforme2 () {
		String nombre, descripcion;
		Double precio;
		List<Prueba> lista = new ArrayList<Prueba>();		

		for (int i = 0; i < mainPanel.modeloTabla.getRowCount(); i++) {
			nombre = ((Vector) mainPanel.modeloTabla.getDataVector().elementAt(i)).get(1).toString();
			descripcion = ((Vector) mainPanel.modeloTabla.getDataVector().elementAt(i)).get(2).toString();
			precio = (Double)((Vector) mainPanel.modeloTabla.getDataVector().elementAt(i)).get(3);
			
			lista.add(new Prueba(nombre,descripcion,precio));
		}
		
		JasperPrint jasperPrint = null; 
		try { 
			jasperPrint = JasperFillManager.fillReport(ruta_jasperreport, null,new JRBeanCollectionDataSource(lista)); 
		} catch (JRException e1) { 
			// TODO Auto-generated catch block
			e1.printStackTrace(); 
			JOptionPane.showMessageDialog( null, e1.getStackTrace(), "PDF Guardado", JOptionPane.PLAIN_MESSAGE ); 
		} 
		JRPdfExporter exp = new JRPdfExporter(); 
		exp.setExporterInput(new SimpleExporterInput(jasperPrint)); 
		exp.setExporterOutput(new SimpleOutputStreamExporterOutput(nombre_pdf)); 
		JOptionPane.showMessageDialog( null, "Informe generado y almacenado", "PDF Guardado", JOptionPane.PLAIN_MESSAGE ); 
		try { 
			exp.exportReport(); 
		} catch (JRException e1) { // TODO Auto-generated catch block
			e1.printStackTrace(); 
			JOptionPane.showMessageDialog( null, e1.getStackTrace(), "PDF Guardado", JOptionPane.PLAIN_MESSAGE ); 
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
	 * Implemente el m�todo addActionListener() a todos los botones que sean necesarios
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

}
