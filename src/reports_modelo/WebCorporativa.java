package reports_modelo;

import eventos.Reports;

public class WebCorporativa {
	
	public static String ruta = Reports.jrWebCorporativa;
	
	public static String defaultPrecio = "*desde 1459 + IVA";
	public static String defaultWebUrl = "www.kenshostudio.com";
	
	String precio, weburl;
	
	public WebCorporativa (String precio, String weburl) {
		this.precio = precio;
		this.weburl = weburl;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getWeburl() {
		return weburl;
	}

	public void setWeburl(String weburl) {
		this.weburl = weburl;
	}

	public static String getRuta() {
		return ruta;
	}

	public static void setRuta(String ruta) {
		WebCorporativa.ruta = ruta;
	}

	public static String getDefaultPrecio() {
		return defaultPrecio;
	}

	public static void setDefaultPrecio(String defaultPrecio) {
		WebCorporativa.defaultPrecio = defaultPrecio;
	}

	public static String getDefaultWebUrl() {
		return defaultWebUrl;
	}

	public static void setDefaultWebUrl(String defaultWebUrl) {
		WebCorporativa.defaultWebUrl = defaultWebUrl;
	}

	@Override
	public String toString() {
		return "WebCorporativa [precio=" + precio + ", weburl=" + weburl + "]";
	}
	
}