package reports_modelo;

import eventos.Reports;

public class TiendaOnline {

	public static String ruta = Reports.jrTiendaOnline;
	
	public static String defaultPrecio1 = "desde 1400€ + IVA";
	public static String defaultUrl = "www.bazarmercenario.com";
	
	String precio1, url;

	public TiendaOnline(String precio1, String url) {
		super();
		this.precio1 = precio1;
		this.url = url;
	}
	
	public TiendaOnline() {
		super();
		this.precio1 = defaultPrecio1;
		this.url = defaultUrl;
	}

	public static String getRuta() {
		return ruta;
	}

	public static void setRuta(String ruta) {
		TiendaOnline.ruta = ruta;
	}

	public static String getDefaultPrecio1() {
		return defaultPrecio1;
	}

	public static void setDefaultPrecio1(String defaultPrecio1) {
		TiendaOnline.defaultPrecio1 = defaultPrecio1;
	}

	public static String getDefaultUrl() {
		return defaultUrl;
	}

	public static void setDefaultUrl(String defaultUrl) {
		TiendaOnline.defaultUrl = defaultUrl;
	}

	public String getPrecio1() {
		return precio1;
	}

	public void setPrecio1(String precio1) {
		this.precio1 = precio1;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "TiendaOnline [precio1=" + precio1 + ", url=" + url + "]";
	}
}
