package reports_modelo;

import eventos.Reports;

public class FiltrosInstagram {
	
	public static String ruta = Reports.jrFiltrosInstagram;
	
	public static String defaultPrecio1 = "900€ + IVA";
	public static String defaultPrecio2 = "1400€ + IVA";
	public static String defaultPrecio3 = "2000€ + IVA";
	public static String defaultPrecio4 = "200€ + IVA";
	
	String precio1, precio2, precio3, precio4;

	public FiltrosInstagram(String precio1, String precio2, String precio3, String precio4) {
		super();
		this.precio1 = precio1;
		this.precio2 = precio2;
		this.precio3 = precio3;
		this.precio4 = precio4;
	}

	public FiltrosInstagram() {
		super();
		this.precio1 = defaultPrecio1;
		this.precio2 = defaultPrecio2;
		this.precio3 = defaultPrecio3;
		this.precio4 = defaultPrecio4;
	}

	public static String getRuta() {
		return ruta;
	}

	public static void setRuta(String ruta) {
		FiltrosInstagram.ruta = ruta;
	}

	public static String getDefaultPrecio1() {
		return defaultPrecio1;
	}

	public static void setDefaultPrecio1(String defaultPrecio1) {
		FiltrosInstagram.defaultPrecio1 = defaultPrecio1;
	}

	public static String getDefaultPrecio2() {
		return defaultPrecio2;
	}

	public static void setDefaultPrecio2(String defaultPrecio2) {
		FiltrosInstagram.defaultPrecio2 = defaultPrecio2;
	}

	public static String getDefaultPrecio3() {
		return defaultPrecio3;
	}

	public static void setDefaultPrecio3(String defaultPrecio3) {
		FiltrosInstagram.defaultPrecio3 = defaultPrecio3;
	}

	public static String getDefaultPrecio4() {
		return defaultPrecio4;
	}

	public static void setDefaultPrecio4(String defaultPrecio4) {
		FiltrosInstagram.defaultPrecio4 = defaultPrecio4;
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

	public String getPrecio4() {
		return precio4;
	}

	public void setPrecio4(String precio4) {
		this.precio4 = precio4;
	}

	@Override
	public String toString() {
		return "FiltrosInstagram [precio1=" + precio1 + ", precio2=" + precio2 + ", precio3=" + precio3 + ", precio4="
				+ precio4 + "]";
	}
	
}
