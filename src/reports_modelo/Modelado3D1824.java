package reports_modelo;

import eventos.Reports;

public class Modelado3D1824 {
	
	public static String ruta = Reports.jrModelado3D2;
	
	public static String defaultPrecio = "1200€ - 6000€ + IVA";
	
	String precio1;

	public Modelado3D1824(String precio1) {
		super();
		this.precio1 = precio1;
	}
	
	public Modelado3D1824() {
		super();
		this.precio1 = defaultPrecio;
	}

	public static String getRuta() {
		return ruta;
	}

	public static void setRuta(String ruta) {
		Modelado3D1824.ruta = ruta;
	}

	public static String getDefaultPrecio() {
		return defaultPrecio;
	}

	public static void setDefaultPrecio(String defaultPrecio) {
		Modelado3D1824.defaultPrecio = defaultPrecio;
	}

	public String getPrecio1() {
		return precio1;
	}

	public void setPrecio1(String precio1) {
		this.precio1 = precio1;
	}

	@Override
	public String toString() {
		return "Modelado3D1824 [precio1=" + precio1 + "]";
	}
	
}
