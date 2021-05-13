package reports_modelo;

import eventos.Reports;

public class Naming1824 {

	public static String ruta = Reports.jrNaming;
	
	public static String defaultPrecio1 = "400€ + IVA";
	public static String defaultPrecio2 = "600€ + IVA";
	public static String defaultPrecio3 = "+ 650€ + IVA";
	
	String precio1, precio2, precio3;

	public Naming1824(String precio1, String precio2, String precio3) {
		super();
		this.precio1 = precio1;
		this.precio2 = precio2;
		this.precio3 = precio3;
	}
	
	public Naming1824() {
		super();
		this.precio1 = defaultPrecio1;
		this.precio2 = defaultPrecio2;
		this.precio3 = defaultPrecio3;
	}

	public static String getRuta() {
		return ruta;
	}

	public static void setRuta(String ruta) {
		Naming1824.ruta = ruta;
	}

	public static String getDefaultPrecio1() {
		return defaultPrecio1;
	}

	public static void setDefaultPrecio1(String defaultPrecio1) {
		Naming1824.defaultPrecio1 = defaultPrecio1;
	}

	public static String getDefaultPrecio2() {
		return defaultPrecio2;
	}

	public static void setDefaultPrecio2(String defaultPrecio2) {
		Naming1824.defaultPrecio2 = defaultPrecio2;
	}

	public static String getDefaultPrecio3() {
		return defaultPrecio3;
	}

	public static void setDefaultPrecio3(String defaultPrecio3) {
		Naming1824.defaultPrecio3 = defaultPrecio3;
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
		return "Naming1824 [precio1=" + precio1 + ", precio2=" + precio2 + ", precio3=" + precio3 + "]";
	}
}
