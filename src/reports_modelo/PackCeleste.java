package reports_modelo;

import eventos.Reports;

public class PackCeleste {
	
	public static String ruta = Reports.jrPackCeleste;
	
	public static String defaultPrecio1 = "499€ / MES + IVA";
	public static String defaultPrecio2 = "460€ / MES + IVA";
	public static String defaultTexto1 = "ESTRATEGIA DE CONTENIDOS MENSUAL INSTAGRAM Y FACEBOOK Y ASESORAMIENTO PERSONALIZADO";
	public static String defaultTexto2 = "COMMUNITY MANAGEMENT";
	public static String defaultTexto3 = "SERVICIO AL CLIENTE";
	public static String defaultTexto4 = "3 POST SEMANALES Y STORIES DIARIOS SEGÚN NECESIDADES";
	public static String defaultTexto5 = "INFORMES DE KPI´S Y PLANES DE CONTENIDO";
	public static String defaultTexto6 = "COPYS ADAPTADOS PARA RRSS";
	
	String texto1, texto2, texto3, texto4, texto5, texto6, precio1, precio2;

	public PackCeleste(String texto1, String texto2, String texto3, String texto4, String texto5, String texto6,
			String precio1, String precio2) {
		super();
		this.texto1 = texto1;
		this.texto2 = texto2;
		this.texto3 = texto3;
		this.texto4 = texto4;
		this.texto5 = texto5;
		this.texto6 = texto6;
		this.precio1 = precio1;
		this.precio2 = precio2;
	}
	
	public PackCeleste() {
		super();
		this.texto1 = defaultTexto1;
		this.texto2 = defaultTexto2;
		this.texto3 = defaultTexto3;
		this.texto4 = defaultTexto4;
		this.texto5 = defaultTexto5;
		this.texto6 = defaultTexto6;
		this.precio1 = defaultPrecio1;
		this.precio2 = defaultPrecio2;
	}

	public static String getRuta() {
		return ruta;
	}

	public static void setRuta(String ruta) {
		PackCeleste.ruta = ruta;
	}

	public static String getDefaultPrecio1() {
		return defaultPrecio1;
	}

	public static void setDefaultPrecio1(String defaultPrecio1) {
		PackCeleste.defaultPrecio1 = defaultPrecio1;
	}

	public static String getDefaultPrecio2() {
		return defaultPrecio2;
	}

	public static void setDefaultPrecio2(String defaultPrecio2) {
		PackCeleste.defaultPrecio2 = defaultPrecio2;
	}

	public static String getDefaultTexto1() {
		return defaultTexto1;
	}

	public static void setDefaultTexto1(String defaultTexto1) {
		PackCeleste.defaultTexto1 = defaultTexto1;
	}

	public static String getDefaultTexto2() {
		return defaultTexto2;
	}

	public static void setDefaultTexto2(String defaultTexto2) {
		PackCeleste.defaultTexto2 = defaultTexto2;
	}

	public static String getDefaultTexto3() {
		return defaultTexto3;
	}

	public static void setDefaultTexto3(String defaultTexto3) {
		PackCeleste.defaultTexto3 = defaultTexto3;
	}

	public static String getDefaultTexto4() {
		return defaultTexto4;
	}

	public static void setDefaultTexto4(String defaultTexto4) {
		PackCeleste.defaultTexto4 = defaultTexto4;
	}

	public static String getDefaultTexto5() {
		return defaultTexto5;
	}

	public static void setDefaultTexto5(String defaultTexto5) {
		PackCeleste.defaultTexto5 = defaultTexto5;
	}

	public static String getDefaultTexto6() {
		return defaultTexto6;
	}

	public static void setDefaultTexto6(String defaultTexto6) {
		PackCeleste.defaultTexto6 = defaultTexto6;
	}

	public String getTexto1() {
		return texto1;
	}

	public void setTexto1(String texto1) {
		this.texto1 = texto1;
	}

	public String getTexto2() {
		return texto2;
	}

	public void setTexto2(String texto2) {
		this.texto2 = texto2;
	}

	public String getTexto3() {
		return texto3;
	}

	public void setTexto3(String texto3) {
		this.texto3 = texto3;
	}

	public String getTexto4() {
		return texto4;
	}

	public void setTexto4(String texto4) {
		this.texto4 = texto4;
	}

	public String getTexto5() {
		return texto5;
	}

	public void setTexto5(String texto5) {
		this.texto5 = texto5;
	}

	public String getTexto6() {
		return texto6;
	}

	public void setTexto6(String texto6) {
		this.texto6 = texto6;
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

	@Override
	public String toString() {
		return "PackCeleste [texto1=" + texto1 + ", texto2=" + texto2 + ", texto3=" + texto3 + ", texto4=" + texto4
				+ ", texto5=" + texto5 + ", texto6=" + texto6 + ", precio1=" + precio1 + ", precio2=" + precio2 + "]";
	}
	
}
