package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import eventos.Reports;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import reports_modelo.CampanaAds;
import reports_modelo.ContenidoAudioVisual;
import reports_modelo.LandingPage;
import reports_modelo.PackCeleste;
import reports_modelo.PackCian;
import reports_modelo.PackTurquesa;
import reports_modelo.PackZafiro;
import reports_modelo.TiendaOnline;
import reports_modelo.WebCorporativa;
import vista.PanelPrincipal;
import vista.PanelSetServices;

public class ControladorSetServices implements ActionListener {
	
	private PanelSetServices setServices;
	
	private int idObjectServices;
	private String className;
//	private ArrayList<ArrayList<Object>> a;
	private ArrayList<String> attributesNames;
	private ArrayList<String> attributesValues;
	private int attributeIndex = 0;
	
//	private List<JasperPrint> jasperPrintList;
	private List<WebCorporativa> listWebCorporativa;
	private List<CampanaAds> listCampanaAds;
	private List<ContenidoAudioVisual> listContenidoAudioVisual;
	private List<LandingPage> listLandingPage;
	private List<PackCeleste> listPackCeleste;
	private List<PackCian> listPackCian;
	private List<PackTurquesa> listPackTurquesa;
	private List<PackZafiro> listPackZafiro;
	private List<TiendaOnline> listTiendaOnline;
	
	private JasperPrint jp;
	
	public ControladorSetServices (PanelSetServices pss, int idObjectServices) {
		setServices = pss;
		this.idObjectServices = idObjectServices; 
		
		attributesNames = new ArrayList<String>();
		attributesValues = new ArrayList<String>();
		jp = null;
		
		identificaClase();
		putData();
		getAtttributesNames(); 
		fillCombo();
		
		setServices.lblServicesName.setText(className);
		setServices.taAttributeValue.setText( attributesValues.get(attributeIndex));
		
		setServices.btnAceptar.addActionListener(this);
		setServices.cbSelectAttribute.addActionListener(this);
		
	}

	// Hay que quitar el jasper del jasperlist de controlador principal y sustituirlo por el modificado creado en esta clase
	// se puede usar el index de la posicion de la tabla que coincidirá con el de jasperlist
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == setServices.btnAceptar) {
			try {
				guardarDatos();
			} catch (JRException e1) {
				e1.printStackTrace();
			}
			setServices.dispose();
		}
		else if (e.getSource() == setServices.cbSelectAttribute) {
			attributesValues.set(attributeIndex, setServices.taAttributeValue.getText());
			
			attributeIndex = setServices.cbSelectAttribute.getSelectedIndex();
			setServices.taAttributeValue.setText( attributesValues.get(attributeIndex));
		}
	}
	
	/**
	 * Guarda todos los datos cargador al array previamente por si alguno de los argumentos han sufrido algún cambio
	 * Genera un jasperPrint con dicha clase de atributos actualizados, el cual se sustituye por el jasper print correspondiente
	 * 	de l clase ControladorPrincipal
	 * @throws JRException
	 */
	public void guardarDatos () throws JRException {
		switch (idObjectServices) {
		case 1: attributesValues.set(attributeIndex, setServices.taAttributeValue.getText());
				listLandingPage.get(0).setPrecio1( attributesValues.get(0));
				jp = JasperFillManager.fillReport(Reports.jrLandingPage, null, new JRBeanCollectionDataSource(listLandingPage));
				break;
		case 2: attributesValues.set(attributeIndex, setServices.taAttributeValue.getText());
				listWebCorporativa.get(0).setPrecio( attributesValues.get(0));
				listWebCorporativa.get(0).setWeburl( attributesValues.get(1));
				jp = JasperFillManager.fillReport(Reports.jrWebCorporativa, null, new JRBeanCollectionDataSource(listWebCorporativa));
		 		break;
		case 3: attributesValues.set(attributeIndex, setServices.taAttributeValue.getText());
				listContenidoAudioVisual.get(0).setPrecio1( attributesValues.get(0));
				listContenidoAudioVisual.get(0).setPrecio2( attributesValues.get(1));
				listContenidoAudioVisual.get(0).setPrecio3( attributesValues.get(2));
				jp = JasperFillManager.fillReport(Reports.jrContenidoAudioVisual, null, new JRBeanCollectionDataSource(listContenidoAudioVisual));
				break;
		case 4: attributesValues.set(attributeIndex, setServices.taAttributeValue.getText());
				listCampanaAds.get(0).setTexto1( attributesValues.get(0));
				listCampanaAds.get(0).setTexto2( attributesValues.get(1));
				listCampanaAds.get(0).setTexto3( attributesValues.get(2));
				listCampanaAds.get(0).setTexto4( attributesValues.get(3));
				listCampanaAds.get(0).setTexto5( attributesValues.get(4));
				listCampanaAds.get(0).setAviso( attributesValues.get(5));
				listCampanaAds.get(0).setPrecio( attributesValues.get(6));
				jp = JasperFillManager.fillReport(Reports.jrCampanaAds, null, new JRBeanCollectionDataSource(listCampanaAds));
				break;
		case 5: attributesValues.set(attributeIndex, setServices.taAttributeValue.getText());
				listPackCeleste.get(0).setTexto1( attributesValues.get(0));
				listPackCeleste.get(0).setTexto2( attributesValues.get(1));
				listPackCeleste.get(0).setTexto3( attributesValues.get(2));
				listPackCeleste.get(0).setTexto4( attributesValues.get(3));
				listPackCeleste.get(0).setTexto5( attributesValues.get(4));
				listPackCeleste.get(0).setTexto6( attributesValues.get(5));
				listPackCeleste.get(0).setPrecio1( attributesValues.get(6));
				listPackCeleste.get(0).setPrecio2( attributesValues.get(7));
				jp = JasperFillManager.fillReport(Reports.jrPackCeleste, null, new JRBeanCollectionDataSource(listPackCeleste));
				break;
		case 6: attributesValues.set(attributeIndex, setServices.taAttributeValue.getText());
				listPackCian.get(0).setTexto1( attributesValues.get(0));
				listPackCian.get(0).setTexto2( attributesValues.get(1));
				listPackCian.get(0).setTexto3( attributesValues.get(2));
				listPackCian.get(0).setTexto4( attributesValues.get(3));
				listPackCian.get(0).setTexto5( attributesValues.get(4));
				listPackCian.get(0).setTexto6( attributesValues.get(5));
				listPackCian.get(0).setTexto7( attributesValues.get(6));
				listPackCian.get(0).setTexto8( attributesValues.get(7));
				listPackCian.get(0).setTexto9( attributesValues.get(8));
				listPackCian.get(0).setPrecio1( attributesValues.get(9));
				listPackCian.get(0).setPrecio2( attributesValues.get(10));
				jp = JasperFillManager.fillReport(Reports.jrPackCian, null, new JRBeanCollectionDataSource(listPackCian));
				break;
		case 7: attributesValues.set(attributeIndex, setServices.taAttributeValue.getText());
				listPackTurquesa.get(0).setTexto1( attributesValues.get(0));
				listPackTurquesa.get(0).setTexto2( attributesValues.get(1));
				listPackTurquesa.get(0).setTexto3( attributesValues.get(2));
				listPackTurquesa.get(0).setTexto4( attributesValues.get(3));
				listPackTurquesa.get(0).setTexto5( attributesValues.get(3));
				listPackTurquesa.get(0).setTexto6( attributesValues.get(5));
				listPackTurquesa.get(0).setTexto7( attributesValues.get(6));
				listPackTurquesa.get(0).setTexto8( attributesValues.get(7));
				listPackTurquesa.get(0).setTexto9( attributesValues.get(8));
				listPackTurquesa.get(0).setPrecio1( attributesValues.get(9));
				listPackTurquesa.get(0).setPrecio2( attributesValues.get(10));
				jp = JasperFillManager.fillReport(Reports.jrPackTurquesa, null, new JRBeanCollectionDataSource(listPackTurquesa));
				break;
		case 8: attributesValues.set(attributeIndex, setServices.taAttributeValue.getText());
				listPackZafiro.get(0).setTexto1( attributesValues.get(0));
				listPackZafiro.get(0).setTexto2( attributesValues.get(1));
				listPackZafiro.get(0).setTexto3( attributesValues.get(2));
				listPackZafiro.get(0).setTexto4( attributesValues.get(3));
				listPackZafiro.get(0).setTexto5( attributesValues.get(3));
				listPackZafiro.get(0).setTexto6( attributesValues.get(5));
				listPackZafiro.get(0).setTexto7( attributesValues.get(6));
				listPackZafiro.get(0).setTexto8( attributesValues.get(7));
				listPackZafiro.get(0).setTexto9( attributesValues.get(8));
				listPackZafiro.get(0).setTexto10( attributesValues.get(9));
				listPackZafiro.get(0).setPrecio1( attributesValues.get(10));
				listPackZafiro.get(0).setPrecio2( attributesValues.get(11));
				jp = JasperFillManager.fillReport(Reports.jrPackZafiro, null, new JRBeanCollectionDataSource(listPackZafiro));
				break;
		case 9: attributesValues.set(attributeIndex, setServices.taAttributeValue.getText());
				listTiendaOnline.get(0).setPrecio1( attributesValues.get(0));
				listTiendaOnline.get(0).setUrl( attributesValues.get(1));
				jp = JasperFillManager.fillReport(Reports.jrTiendaOnline, null, new JRBeanCollectionDataSource(listTiendaOnline));
				break;
		default: System.out.println("fallo en identificaClase()"); break;
		}
		
		ControladorPrincipal.jasperPrintList.set(PanelPrincipal.tableRowClick, jp);
	}
	
	/**
	 * Según el id recibido por PanelPrincipal coloca el nombre y carga el List de la clase
	 */
	public void identificaClase () {
		switch (idObjectServices) {
		case 1: listLandingPage = ControladorPrincipal.getListLandingPage(); 
				className = "Landing Page"; 
				break;
		case 2: listWebCorporativa = ControladorPrincipal.getListWebCorporativa(); 
		 		className = "Web Corporativa"; 
		 		break;
		case 3: listContenidoAudioVisual = ControladorPrincipal.getListContenidoAudioVisual(); 
				className = "Contenido Audio Visual"; 
				break;
		case 4: listCampanaAds = ControladorPrincipal.getListCampanaAds();
				className = "Campaña Ads"; 
				break;
		case 5: listPackCeleste = ControladorPrincipal.getListPackCeleste();
				className = "Pack Celeste"; 
				break;
		case 6: listPackCian = ControladorPrincipal.getListPackCian(); 
				className = "Pack Cian"; 
				break;
		case 7: listPackTurquesa = ControladorPrincipal.getListPackTurquesa(); 
				className = "Pack Turquesa"; 
				break;
		case 8: listPackZafiro = ControladorPrincipal.getListPackZafiro(); 
				className = "Pack Zafiro";
				break;
		case 9: listTiendaOnline = ControladorPrincipal.getListTiendaOnline(); 
				className = "Tienda Online"; 
				break;
		default: System.out.println("fallo en identificaClase()"); break;
		}
	}
	
	/**
	 * Según el id recibido por el PanelPrincipal carga el array de valores de los atributos que tenemos en esta clase
	 * para posteriormente llevarlos al ComboBox() en el método fillCombo()
	 */
	public void putData () {
		switch (idObjectServices) {
		case 1: attributesValues.add(listLandingPage.get(0).getPrecio1()); 
				break;
		case 2: attributesValues.add(listWebCorporativa.get(0).getPrecio());
				attributesValues.add(listWebCorporativa.get(0).getWeburl()); 
				break;
		case 3: attributesValues.add(listContenidoAudioVisual.get(0).getPrecio1());
				attributesValues.add(listContenidoAudioVisual.get(0).getPrecio2());
				attributesValues.add(listContenidoAudioVisual.get(0).getPrecio3());
				break;
		case 4: attributesValues.add(listCampanaAds.get(0).getTexto1());
				attributesValues.add(listCampanaAds.get(0).getTexto2());
				attributesValues.add(listCampanaAds.get(0).getTexto3());
				attributesValues.add(listCampanaAds.get(0).getTexto4());
				attributesValues.add(listCampanaAds.get(0).getTexto5());
				attributesValues.add(listCampanaAds.get(0).getAviso());
				attributesValues.add(listCampanaAds.get(0).getPrecio());
				break;
		case 5: attributesValues.add(listPackCeleste.get(0).getTexto1());
				attributesValues.add(listPackCeleste.get(0).getTexto2());
				attributesValues.add(listPackCeleste.get(0).getTexto3());
				attributesValues.add(listPackCeleste.get(0).getTexto4());
				attributesValues.add(listPackCeleste.get(0).getTexto5());
				attributesValues.add(listPackCeleste.get(0).getTexto6());
				attributesValues.add(listPackCeleste.get(0).getPrecio1());
				attributesValues.add(listPackCeleste.get(0).getPrecio2());
				break;
		case 6: attributesValues.add(listPackCian.get(0).getTexto1());
				attributesValues.add(listPackCian.get(0).getTexto2());
				attributesValues.add(listPackCian.get(0).getTexto3());
				attributesValues.add(listPackCian.get(0).getTexto4());
				attributesValues.add(listPackCian.get(0).getTexto5());
				attributesValues.add(listPackCian.get(0).getTexto6());
				attributesValues.add(listPackCian.get(0).getTexto7());
				attributesValues.add(listPackCian.get(0).getTexto8());
				attributesValues.add(listPackCian.get(0).getTexto9());
				attributesValues.add(listPackCian.get(0).getPrecio1());
				attributesValues.add(listPackCian.get(0).getPrecio2());
				break;
		case 7: attributesValues.add(listPackTurquesa.get(0).getTexto1());
				attributesValues.add(listPackTurquesa.get(0).getTexto2());
				attributesValues.add(listPackTurquesa.get(0).getTexto3());
				attributesValues.add(listPackTurquesa.get(0).getTexto4());
				attributesValues.add(listPackTurquesa.get(0).getTexto5());
				attributesValues.add(listPackTurquesa.get(0).getTexto6());
				attributesValues.add(listPackTurquesa.get(0).getTexto7());
				attributesValues.add(listPackTurquesa.get(0).getTexto8());
				attributesValues.add(listPackTurquesa.get(0).getTexto9());
				attributesValues.add(listPackTurquesa.get(0).getPrecio1());
				attributesValues.add(listPackTurquesa.get(0).getPrecio2());
				break;
		case 8: attributesValues.add(listPackZafiro.get(0).getTexto1());
				attributesValues.add(listPackZafiro.get(0).getTexto2());
				attributesValues.add(listPackZafiro.get(0).getTexto3());
				attributesValues.add(listPackZafiro.get(0).getTexto4());
				attributesValues.add(listPackZafiro.get(0).getTexto5());
				attributesValues.add(listPackZafiro.get(0).getTexto6());
				attributesValues.add(listPackZafiro.get(0).getTexto7());
				attributesValues.add(listPackZafiro.get(0).getTexto8());
				attributesValues.add(listPackZafiro.get(0).getTexto9());
				attributesValues.add(listPackZafiro.get(0).getTexto10());
				attributesValues.add(listPackZafiro.get(0).getPrecio1());
				attributesValues.add(listPackZafiro.get(0).getPrecio2());
				break;
		case 9: attributesValues.add(listTiendaOnline.get(0).getPrecio1());
				attributesValues.add(listTiendaOnline.get(0).getUrl());
				break;
		default: //
		}
	}
	
//	public void getAttributesValues() {
//		switch (idObjectServices) {
//		case 9: ControladorPrincipal.getListTiendaOnline();
//		}
//	}
	
	/**
	 * Según el id recibido por el PanelPrincipal 
	 */
	public void getAtttributesNames() {
		switch (idObjectServices) {
		case 1: attributesNames.add("Precio"); 
				break;
		case 2: attributesNames.add("Precio"); attributesNames.add("URL"); 
				break;
		case 3: attributesNames.add("Precio1"); attributesNames.add("Precio2"); attributesNames.add("Precio3"); 
				break;
		case 4: attributesNames.add("Texto1"); attributesNames.add("Texto2"); attributesNames.add("Texto3"); attributesNames.add("Texto4");
				attributesNames.add("Texto5"); attributesNames.add("Aviso"); attributesNames.add("Precio"); 
				break;
		case 5: attributesNames.add("Texto1"); attributesNames.add("Texto2"); attributesNames.add("Texto3"); attributesNames.add("Texto4");
				attributesNames.add("Texto5"); attributesNames.add("Texto6"); attributesNames.add("Precio1"); attributesNames.add("Precio2"); 
				break;
		case 6: attributesNames.add("Texto1"); attributesNames.add("Texto2"); attributesNames.add("Texto3"); attributesNames.add("Texto4");
				attributesNames.add("Texto5"); attributesNames.add("Texto6"); attributesNames.add("Texto7"); attributesNames.add("Texto8");
				attributesNames.add("Texto9"); attributesNames.add("Precio1"); attributesNames.add("Precio2"); 
				break;
		case 7: attributesNames.add("Texto1"); attributesNames.add("Texto2"); attributesNames.add("Texto3"); attributesNames.add("Texto4");
				attributesNames.add("Texto5"); attributesNames.add("Texto6"); attributesNames.add("Texto7"); attributesNames.add("Texto8");
				attributesNames.add("Texto9"); attributesNames.add("Precio1"); attributesNames.add("Precio2"); 
				break;
		case 8: attributesNames.add("Texto1"); attributesNames.add("Texto2"); attributesNames.add("Texto3"); attributesNames.add("Texto4");
				attributesNames.add("Texto5"); attributesNames.add("Texto6"); attributesNames.add("Texto7"); attributesNames.add("Texto8");
				attributesNames.add("Texto9"); attributesNames.add("Texto10"); attributesNames.add("Precio1"); attributesNames.add("Precio2"); 
				break;
		case 9: attributesNames.add("Precio"); attributesNames.add("URL"); 
				break;
		default: /*..*/ break;
		}
	}
	
	/**
	 * Traspasa los string del array local hasta el comboBox
	 */
	public void fillCombo () {
		System.out.println("puntoFillCombo");
		if (attributesNames != null) {
			for (int i = 0; i < attributesNames.size(); i++) {
				setServices.getCbSelectAttribute().addItem(attributesNames.get(i));
			}
		}
		else {
			System.out.println("esta vacio");
		}
	}

}
