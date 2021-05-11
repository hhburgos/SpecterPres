package reports_modelo;

import eventos.Reports;

public class ContenidoAudioVisual1824 {

	public static String ruta = Reports.jrContenidoAudioVisual1824;
	
	public static String defaultTexto1 = "RESTAURACIÓN";
	public static String defaultTexto2 = "AUTOMOCIÓN";
	public static String defaultTexto3 = "PRODUCTO";
	
	String texto1, texto2, texto3;

	public ContenidoAudioVisual1824(String texto1, String texto2, String texto3) {
		super();
		this.texto1 = texto1;
		this.texto2 = texto2;
		this.texto3 = texto3;
	}
	
	public ContenidoAudioVisual1824() {
		super();
		this.texto1 = defaultTexto1;
		this.texto2 = defaultTexto2;
		this.texto3 = defaultTexto3;
	}

	public static String getRuta() {
		return ruta;
	}

	public static void setRuta(String ruta) {
		ContenidoAudioVisual1824.ruta = ruta;
	}

	public static String getDefaultTexto1() {
		return defaultTexto1;
	}

	public static void setDefaultTexto1(String defaultTexto1) {
		ContenidoAudioVisual1824.defaultTexto1 = defaultTexto1;
	}

	public static String getDefaultTexto2() {
		return defaultTexto2;
	}

	public static void setDefaultTexto2(String defaultTexto2) {
		ContenidoAudioVisual1824.defaultTexto2 = defaultTexto2;
	}

	public static String getDefaultTexto3() {
		return defaultTexto3;
	}

	public static void setDefaultTexto3(String defaultTexto3) {
		ContenidoAudioVisual1824.defaultTexto3 = defaultTexto3;
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

	@Override
	public String toString() {
		return "ContenidoAudioVisual1824 [texto1=" + texto1 + ", texto2=" + texto2 + ", texto3=" + texto3 + "]";
	}
	
}
