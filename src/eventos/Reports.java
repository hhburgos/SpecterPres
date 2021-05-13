package eventos;

import java.util.ArrayList;
import java.util.List;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import reports_modelo.Glosario;
import reports_modelo.WebCorporativa;

public class Reports {
	
	public static String jrWebCorporativa = "reports-blue/WebCorporativa.jasper";
	public static String jrGlosario = "reports-blue/Glosario.jasper";
	public static String jrPackCian = "reports-blue/PackCian.jasper";
	public static String jrPackCeleste = "reports-blue/PackCeleste.jasper";
	public static String jrPackTurquesa = "reports-blue/PackTurquesa.jasper";
	public static String jrPackZafiro = "reports-blue/PackZafiro.jasper";
	public static String jrCampanaAds = "reports-blue/CampanaAds.jasper";
	public static String jrBlueRedes = "reports-blue/BlueRedes.jasper";
	public static String jrContenidoAudioVisual = "reports-blue/ContenidoAudioVisual.jasper";
	public static String jrFiltrosInstagram = "reports-blue/FiltrosInstagram.jasper";
	public static String jrLandingPage = "reports-blue/LandingPage.jasper";
	public static String jrTiendaOnline = "reports-blue/TiendaOnline.jasper";
	
	public static String jrContenidoAudioVisual1824 = "reports-1824/ContenidoAudioVisual1824.jasper";
	public static String jrBranding = "reports-1824/Branding.jasper";
	public static String jrDisenoPacking = "reports-1824/DisenoPacking.jasper";
	public static String jrDisenoProducto = "reports-1824/DisenoProducto1.jasper"; 
	public static String jrDisenoProducto2 = "reports-1824/DisenoProducto2.jasper";
	public static String jrLogotipos = "reports-1824/Logotipos.jasper";
	public static String jrModelado3D = "reports-1824/Modelado3D.jasper";
	public static String jrModelado3D2 = "reports-1824/Modelado3D2.jasper";
	public static String jrNaming = "reports-1824/Naming.jasper";
	
	public static String nombre_pdf = "multipleReport.pdf";
	
	public static void generaPrueba () {
		List<WebCorporativa> lista1 = new ArrayList<WebCorporativa>();
		List<Glosario> lista2 = new ArrayList<Glosario>();
		List<JasperPrint> jasperPrintList = new ArrayList<>();
		
		lista1.add(new WebCorporativa("*desde 1252€ + IVA","CannaMedicalBroker.com"));
		lista2.add(new Glosario(Glosario.text1Default, Glosario.text2Default, Glosario.text3Default));
		
		JasperPrint jasperPrint = null;
		JasperPrint jasperPrint2 = null;
		
		try { 
			jasperPrint = JasperFillManager.fillReport(jrWebCorporativa, null,new JRBeanCollectionDataSource(lista1));
			jasperPrint2 = JasperFillManager.fillReport(jrGlosario, null,new JRBeanCollectionDataSource(lista2));
			jasperPrintList.add(jasperPrint);
			jasperPrintList.add(jasperPrint2);
		} catch (Exception e1) { 
			// TODO Auto-generated catch block
			e1.printStackTrace(); 
//			JOptionPane.showMessageDialog( null, e1.getStackTrace(), "PDF Guardado", JOptionPane.PLAIN_MESSAGE ); 
		} 
		JRPdfExporter exp = new JRPdfExporter(); 
		exp.setExporterInput(SimpleExporterInput.getInstance(jasperPrintList)); 
		exp.setExporterOutput(new SimpleOutputStreamExporterOutput(nombre_pdf)); 
//		JOptionPane.showMessageDialog( null, "Informe generado y almacenado", "PDF Guardado", JOptionPane.PLAIN_MESSAGE ); 
		try { 
			exp.exportReport(); 
		} catch (JRException e1) { // TODO Auto-generated catch block
			e1.printStackTrace(); 
//			JOptionPane.showMessageDialog( null, e1.getStackTrace(), "PDF Guardado", JOptionPane.PLAIN_MESSAGE ); 
		}
	}
}
