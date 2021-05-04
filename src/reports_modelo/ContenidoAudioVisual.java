package reports_modelo;

import eventos.Reports;

public class ContenidoAudioVisual {
	
	public static String ruta = Reports.jrCampanaAds;
	
	public static String defaultPrecio1 = "+ 650€ / mes + IVA";
	public static String defaultPrecio2 = "350€ + IVA";
	public static String defaultPrecio3 = "*desde 800€ + IVA";
	                           
	String precio1, precio2, precio3;

	public ContenidoAudioVisual(String precio1, String precio2, String precio3) {
		super();
		this.precio1 = precio1;
		this.precio2 = precio2;
		this.precio3 = precio3;
	}

	public ContenidoAudioVisual() {
		super();
		this.precio1 = defaultPrecio1;
		this.precio2 = defaultPrecio2;
		this.precio3 = defaultPrecio3;
	}

	public static String getRuta() {
		return ruta;
	}

	public static void setRuta(String ruta) {
		ContenidoAudioVisual.ruta = ruta;
	}

	public static String getDefaultPrecio1() {
		return defaultPrecio1;
	}

	public static void setDefaultPrecio1(String defaultPrecio1) {
		ContenidoAudioVisual.defaultPrecio1 = defaultPrecio1;
	}

	public static String getDefaultPrecio2() {
		return defaultPrecio2;
	}

	public static void setDefaultPrecio2(String defaultPrecio2) {
		ContenidoAudioVisual.defaultPrecio2 = defaultPrecio2;
	}

	public static String getDefaultPrecio3() {
		return defaultPrecio3;
	}

	public static void setDefaultPrecio3(String defaultPrecio3) {
		ContenidoAudioVisual.defaultPrecio3 = defaultPrecio3;
	}

	public String getPrecio1() {
		return precio1;
	}

	public void setPrecio1(String precio1) {
		this.precio1 = precio1;
	}

	public String getPrecio2() {
		return precio2;
	}

	public void setPrecio2(String precio2) {
		this.precio2 = precio2;
	}

	public String getPrecio3() {
		return precio3;
	}

	public void setPrecio3(String precio3) {
		this.precio3 = precio3;
	}

	@Override
	public String toString() {
		return "ContenidoAudioVisual [precio1=" + precio1 + ", precio2=" + precio2 + ", precio3=" + precio3 + "]";
	}
	
}
