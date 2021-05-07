package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import net.sf.jasperreports.engine.JasperPrint;
import reports_modelo.CampanaAds;
import reports_modelo.ContenidoAudioVisual;
import reports_modelo.LandingPage;
import reports_modelo.PackCeleste;
import reports_modelo.PackCian;
import reports_modelo.PackTurquesa;
import reports_modelo.PackZafiro;
import reports_modelo.TiendaOnline;
import reports_modelo.WebCorporativa;
import vista.PanelSetServices;

public class ControladorSetServices implements ActionListener {
	
	private PanelSetServices setServices;
	
	private int idObjectServices;
	private String className;
//	private ArrayList<ArrayList<Object>> a;
	private ArrayList<String> attributesNames;
	private ArrayList<String> attributesValues;
	private int attributeIndex = 0;
	
	private List<JasperPrint> jasperPrintList;
	private List<WebCorporativa> listWebCorporativa;
	private List<CampanaAds> listCampanaAds;
	private List<ContenidoAudioVisual> listContenidoAudioVisual;
	private List<LandingPage> listLandingPage;
	private List<PackCeleste> listPackCeleste;
	private List<PackCian> listPackCian;
	private List<PackTurquesa> listPackTurquesa;
	private List<PackZafiro> listPackZafiro;
	private List<TiendaOnline> listTiendaOnline;
	
	public ControladorSetServices (PanelSetServices pss, int idObjectServices) {
		setServices = pss;
		this.idObjectServices = idObjectServices; 
		
		setServices.lblServicesName.setText(className);
		
		attributesNames = new ArrayList<String>();
		attributesValues = new ArrayList<String>();
		
		identificaClase();
		putData();
		getAtttributesNames(); 
		fillCombo();
		
		setServices.taAttributeValue.setText( attributesValues.get(attributeIndex));
		
		setServices.btnAceptar.addActionListener(this);
		setServices.cbSelectAttribute.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == setServices.btnAceptar) {
			setServices.dispose();
		}
		else if (e.getSource() == setServices.cbSelectAttribute) {
			attributeIndex = setServices.cbSelectAttribute.getSelectedIndex();
			setServices.taAttributeValue.setText( attributesValues.get(attributeIndex));
		}
	}
	
	public void identificaClase () {
		switch (idObjectServices) {
		case 1: listLandingPage = ControladorPrincipal.getListLandingPage(); 
				className = "Landing Page"; break;
		case 2: listWebCorporativa = ControladorPrincipal.getListWebCorporativa(); 
		 		className = "Web Corporativa"; break;
		case 3: listContenidoAudioVisual = ControladorPrincipal.getListContenidoAudioVisual(); 
				className = "Contenido Audio Visual"; break;
		case 4: listCampanaAds = ControladorPrincipal.getListCampanaAds();
				className = "Campaña Ads"; break;
		case 5: listPackCeleste = ControladorPrincipal.getListPackCeleste();
				className = "Pack Celeste"; break;
		case 6: listPackCian = ControladorPrincipal.getListPackCian(); 
				className = "Pack Cian"; break;
		case 7: listPackTurquesa = ControladorPrincipal.getListPackTurquesa(); 
				className = "Pack Turquesa"; break;
		case 8: listPackZafiro = ControladorPrincipal.getListPackZafiro(); 
				className = "Pack Zafiro";break;
		case 9: listTiendaOnline = ControladorPrincipal.getListTiendaOnline(); 
				className = "Tienda Online"; break;
	
		default: System.out.println("fallo en identificaClase()"); break;
		}
	}
	
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
	
	public void getAtttributesNames() {
		switch (idObjectServices) {
		case 1: attributesNames.add("Precio"); break;
		case 2: attributesNames.add("Precio"); attributesNames.add("URL"); break;
		case 3: attributesNames.add("Precio1"); attributesNames.add("Precio2"); attributesNames.add("Precio3"); break;
		case 4: attributesNames.add("Texto1"); attributesNames.add("Texto2"); attributesNames.add("Texto3"); attributesNames.add("Texto4");
				attributesNames.add("Texto5"); attributesNames.add("Aviso"); attributesNames.add("Precio"); break;
		case 5: attributesNames.add("Texto1"); attributesNames.add("Texto2"); attributesNames.add("Texto3"); attributesNames.add("Texto4");
				attributesNames.add("Texto5"); attributesNames.add("Texto6"); attributesNames.add("Precio1"); attributesNames.add("Precio2"); break;
		case 6: attributesNames.add("Texto1"); attributesNames.add("Texto2"); attributesNames.add("Texto3"); attributesNames.add("Texto4");
				attributesNames.add("Texto5"); attributesNames.add("Texto6"); attributesNames.add("Texto7"); attributesNames.add("Texto8");
				attributesNames.add("Texto9"); attributesNames.add("Precio1"); attributesNames.add("Precio2"); break;
		case 7: attributesNames.add("Texto1"); attributesNames.add("Texto2"); attributesNames.add("Texto3"); attributesNames.add("Texto4");
				attributesNames.add("Texto5"); attributesNames.add("Texto6"); attributesNames.add("Texto7"); attributesNames.add("Texto8");
				attributesNames.add("Texto9"); attributesNames.add("Precio1"); attributesNames.add("Precio2"); break;
		case 8: attributesNames.add("Texto1"); attributesNames.add("Texto2"); attributesNames.add("Texto3"); attributesNames.add("Texto4");
				attributesNames.add("Texto5"); attributesNames.add("Texto6"); attributesNames.add("Texto7"); attributesNames.add("Texto8");
				attributesNames.add("Texto9"); attributesNames.add("Texto10"); attributesNames.add("Precio1"); attributesNames.add("Precio2"); break;
		case 9: attributesNames.add("Precio"); attributesNames.add("URL"); break;
		
		default: /*..*/ break;
		}
	}
	
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
