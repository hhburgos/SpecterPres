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
	
	public static String jrWebCorporativa = "reports/WebCorporativa.jasper";
	public static String jrGlosario = "reports/Glosario.jasper";
	public static String jrPackCian = "reports/PackCian.jasper";
	public static String jrPackCeleste = "reports/PackCeleste.jasper";
	public static String jrCampanaAds = "reports/CampanaAds.jasper";
	public static String jrBlueRedes = "reports/BlueRedes.jasper";
	public static String jrContenidoAudioVisual = "reports/ContenidoAudioVisual.jasper";
	public static String jrFiltrosInstagram = "reports/FiltrosInstagram.jasper";
	public static String jrLandingPage = "reports/LandingPage.jasper";
	
	public static String nombre_pdf = "multipleReport.pdf";
	
	public static void main (String [] args) {
		
	}
	
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
