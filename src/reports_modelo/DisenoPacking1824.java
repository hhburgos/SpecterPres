package reports_modelo;

import eventos.Reports;

public class DisenoPacking1824 {

	public static String ruta = Reports.jrDisenoPacking;
	
	public static String defaultPrecio = "600€ + IVA"; 
	
	String precio1;

	public DisenoPacking1824(String precio1) {
		super();
		this.precio1 = precio1;
	}
	
	public DisenoPacking1824() {
		super();
		this.precio1 = defaultPrecio;
	}

	public static String getRuta() {
		return ruta;
	}

	public static void setRuta(String ruta) {
		DisenoPacking1824.ruta = ruta;
	}

	public static String getDefaultPrecio() {
		return defaultPrecio;
	}

	public static void setDefaultPrecio(String defaultPrecio) {
		DisenoPacking1824.defaultPrecio = defaultPrecio;
	}

	public String getPrecio1() {
		return precio1;
	}

	public void setPrecio1(String precio1) {
		this.precio1 = precio1;
	}

	@Override
	public String toString() {
		return "DisenoPacking1824 [precio1=" + precio1 + "]";
	}
	
}
