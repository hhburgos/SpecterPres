package reports_modelo;

import eventos.Reports;

public class LandingPage {
	
	public static String ruta = Reports.jrLandingPage;
	
	public static String defaultPrecio1 = "850€ + IVA";
	
	String precio1;

	public LandingPage(String precio1) {
		super();
		this.precio1 = precio1;
	}

	public LandingPage() {
		super();
		this.precio1 = defaultPrecio1;
	}

	public static String getRuta() {
		return ruta;
	}

	public static void setRuta(String ruta) {
		LandingPage.ruta = ruta;
	}

	public static String getDefaultPrecio1() {
		return defaultPrecio1;
	}

	public static void setDefaultPrecio1(String defaultPrecio1) {
		LandingPage.defaultPrecio1 = defaultPrecio1;
	}

	public String getPrecio1() {
		return precio1;
	}

	public void setPrecio1(String precio1) {
		this.precio1 = precio1;
	}

	@Override
	public String toString() {
		return "LandingPage [precio1=" + precio1 + "]";
	}
	
}
