package reports_modelo;

import eventos.Reports;

public class PackTurquesa {
	
	public static String ruta = Reports.jrPackTurquesa;
	
	public static String defaultTexto1 = "ESTRATEGIA DE CONTENIDOS MENSUAL INSTAGRAM Y FACEBOOK Y ASESORAMIENTO PERSONALIZADO"; 
	public static String defaultTexto2 = "COMMUNITY MANAGEMENT";
	public static String defaultTexto3 = "SERVICIO AL CLIENTE";
	public static String defaultTexto4 = "3 POST SEMANALES y STORIES DIARIOS SEGÚN NECESIDADES";
	public static String defaultTexto5 = "1 CAMPAÑA MENSUAL FACEBOOK ADS O GOOGLE ADS (ALCANCE Y TRÁFICO)";
	public static String defaultTexto6 = "INFORMES DE KPI´S Y PLANES DE CONTENIDO";
	public static String defaultTexto7 = "COPYS ADAPTADOS PARA RRSS";
	public static String defaultTexto8 = "INSTALACIÓN Y USO DE INSTAGRAM SHOPPING";
	public static String defaultTexto9 = "MARKETING DE INFLUENCIA SIN INVERSIÓN";
	public static String defaultPrecio1 = "650€ / MES + IVA";
	public static String defaultPrecio2 = "599€ / MES + IVA";
	
	String texto1,texto2,texto3,texto4,texto5,texto6,texto7,texto8,texto9,precio1,precio2;

	public PackTurquesa(String texto1, String texto2, String texto3, String texto4, String texto5, String texto6,
			String texto7, String texto8, String texto9, String precio1, String precio2) {
		super();
		this.texto1 = texto1;
		this.texto2 = texto2;
		this.texto3 = texto3;
		this.texto4 = texto4;
		this.texto5 = texto5;
		this.texto6 = texto6;
		this.texto7 = texto7;
		this.texto8 = texto8;
		this.texto9 = texto9;
		this.precio1 = precio1;
		this.precio2 = precio2;
	}
	
	public PackTurquesa() {
		super();
		this.texto1 = defaultTexto1;
		this.texto2 = defaultTexto2;
		this.texto3 = defaultTexto3;
		this.texto4 = defaultTexto4;
		this.texto5 = defaultTexto5;
		this.texto6 = defaultTexto6;
		this.texto7 = defaultTexto7;
		this.texto8 = defaultTexto8;
		this.texto9 = defaultTexto9;
		this.precio1 = defaultPrecio1;
		this.precio2 = defaultPrecio2;
	}
	
	public static String getRuta() {
		return ruta;
	}

	public static void setRuta(String ruta) {
		PackTurquesa.ruta = ruta;
	}

	public static String getDefaultTexto1() {
		return defaultTexto1;
	}

	public static void setDefaultTexto1(String defaultTexto1) {
		PackTurquesa.defaultTexto1 = defaultTexto1;
	}

	public static String getDefaultTexto2() {
		return defaultTexto2;
	}

	public static void setDefaultTexto2(String defaultTexto2) {
		PackTurquesa.defaultTexto2 = defaultTexto2;
	}

	public static String getDefaultTexto3() {
		return defaultTexto3;
	}

	public static void setDefaultTexto3(String defaultTexto3) {
		PackTurquesa.defaultTexto3 = defaultTexto3;
	}

	public static String getDefaultTexto4() {
		return defaultTexto4;
	}

	public static void setDefaultTexto4(String defaultTexto4) {
		PackTurquesa.defaultTexto4 = defaultTexto4;
	}

	public static String getDefaultTexto5() {
		return defaultTexto5;
	}

	public static void setDefaultTexto5(String defaultTexto5) {
		PackTurquesa.defaultTexto5 = defaultTexto5;
	}

	public static String getDefaultTexto6() {
		return defaultTexto6;
	}

	public static void setDefaultTexto6(String defaultTexto6) {
		PackTurquesa.defaultTexto6 = defaultTexto6;
	}

	public static String getDefaultTexto7() {
		return defaultTexto7;
	}

	public static void setDefaultTexto7(String defaultTexto7) {
		PackTurquesa.defaultTexto7 = defaultTexto7;
	}

	public static String getDefaultTexto8() {
		return defaultTexto8;
	}

	public static void setDefaultTexto8(String defaultTexto8) {
		PackTurquesa.defaultTexto8 = defaultTexto8;
	}

	public static String getDefaultTexto9() {
		return defaultTexto9;
	}

	public static void setDefaultTexto9(String defaultTexto9) {
		PackTurquesa.defaultTexto9 = defaultTexto9;
	}

	public static String getDefaultPrecio1() {
		return defaultPrecio1;
	}

	public static void setDefaultPrecio1(String defaultPrecio1) {
		PackTurquesa.defaultPrecio1 = defaultPrecio1;
	}

	public static String getDefaultPrecio2() {
		return defaultPrecio2;
	}

	public static void setDefaultPrecio2(String defaultPrecio2) {
		PackTurquesa.defaultPrecio2 = defaultPrecio2;
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

	public String getTexto7() {
		return texto7;
	}

	public void setTexto7(String texto7) {
		this.texto7 = texto7;
	}

	public String getTexto8() {
		return texto8;
	}

	public void setTexto8(String texto8) {
		this.texto8 = texto8;
	}

	public String getTexto9() {
		return texto9;
	}

	public void setTexto9(String texto9) {
		this.texto9 = texto9;
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
		return "PackTurquesa [texto1=" + texto1 + ", texto2=" + texto2 + ", texto3=" + texto3 + ", texto4=" + texto4
				+ ", texto5=" + texto5 + ", texto6=" + texto6 + ", texto7=" + texto7 + ", texto8=" + texto8
				+ ", texto9=" + texto9 + ", precio1=" + precio1 + ", precio2=" + precio2 + "]";
	}
}
