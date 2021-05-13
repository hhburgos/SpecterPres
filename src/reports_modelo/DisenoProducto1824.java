package reports_modelo;

import eventos.Reports;

public class DisenoProducto1824 {
	
	public static String ruta = Reports.jrDisenoProducto2;
	
	public static String defaultPrecio1 = "1200€ - 6000€ + IVA";
	
	String precio;

	public DisenoProducto1824(String precio) {
		super();
		this.precio = precio;
	}
	
	public DisenoProducto1824() {
		super();
		this.precio = defaultPrecio1;
	}

	public static String getRuta() {
		return ruta;
	}

	public static void setRuta(String ruta) {
		DisenoProducto1824.ruta = ruta;
	}

	public static String getDefaultPrecio1() {
		return defaultPrecio1;
	}

	public static void setDefaultPrecio1(String defaultPrecio1) {
		DisenoProducto1824.defaultPrecio1 = defaultPrecio1;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "DisenoProducto1824 [precio=" + precio + "]";
	}
}
