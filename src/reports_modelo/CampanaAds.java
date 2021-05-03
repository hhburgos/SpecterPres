package reports_modelo;

import eventos.Reports;

public class CampanaAds {
	
	public static String ruta = Reports.jrCampanaAds;
	
	public static String defaultTexto1 = "CAMPAÑAS PROMOCIONADAS EN FACEBOOK E INSTAGRAM (TRÁFICO, CONVERSIONES O GENERACIÓN DE LEADS";
	public static String defaultTexto2 = "LAS PRIMERAS SEMANAS SE HACEN CAMPAÑAS DE PROSPECTING Y POSTERIORMENTE SE APROVECHARÁN LAS AUDIENCIAS"
			+ " PARA CAMPAÑAS DE RETÁRGETING";
	public static String defaultTexto3 = "PLANIFICACIÓN CAMPAÑA";
	public static String defaultTexto4 = "LANZAMIENTO Y SEGUIMIENTO";
	public static String defaultTexto5 = "INFORME DE RESULTADOS";
	public static String defaultAviso = "* La inversión la cobra directamente Facebook a la tarjeta que nos facilite el cliente. "
			+ "No hay inversión mínima mensual";
	public static String defaultPrecio = "350€ + IVA";

	String texto1, texto2, texto3, texto4, texto5, aviso, precio;

	public CampanaAds(String texto1, String texto2, String texto3, String texto4, String texto5, String aviso,
			String precio) {
		super();
		this.texto1 = texto1;
		this.texto2 = texto2;
		this.texto3 = texto3;
		this.texto4 = texto4;
		this.texto5 = texto5;
		this.aviso = aviso;
		this.precio = precio;
	}
	
	public CampanaAds() {
		super();
		this.texto1 = defaultTexto1;
		this.texto2 = defaultTexto2;
		this.texto3 = defaultTexto3;
		this.texto4 = defaultTexto4;
		this.texto5 = defaultTexto5;
		this.aviso = defaultAviso;
		this.precio = defaultPrecio;
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

	public String getAviso() {
		return aviso;
	}

	public void setAviso(String aviso) {
		this.aviso = aviso;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}
	
	public static String getRuta() {
		return ruta;
	}

	public static void setRuta(String ruta) {
		CampanaAds.ruta = ruta;
	}

	public static String getDefaultTexto1() {
		return defaultTexto1;
	}

	public static void setDefaultTexto1(String defaultTexto1) {
		CampanaAds.defaultTexto1 = defaultTexto1;
	}

	public static String getDefaultTexto2() {
		return defaultTexto2;
	}

	public static void setDefaultTexto2(String defaultTexto2) {
		CampanaAds.defaultTexto2 = defaultTexto2;
	}

	public static String getDefaultTexto3() {
		return defaultTexto3;
	}

	public static void setDefaultTexto3(String defaultTexto3) {
		CampanaAds.defaultTexto3 = defaultTexto3;
	}

	public static String getDefaultTexto4() {
		return defaultTexto4;
	}

	public static void setDefaultTexto4(String defaultTexto4) {
		CampanaAds.defaultTexto4 = defaultTexto4;
	}

	public static String getDefaultTexto5() {
		return defaultTexto5;
	}

	public static void setDefaultTexto5(String defaultTexto5) {
		CampanaAds.defaultTexto5 = defaultTexto5;
	}

	public static String getDefaultAviso() {
		return defaultAviso;
	}

	public static void setDefaultAviso(String defaultAviso) {
		CampanaAds.defaultAviso = defaultAviso;
	}

	public static String getDefaultPrecio() {
		return defaultPrecio;
	}

	public static void setDefaultPrecio(String defaultPrecio) {
		CampanaAds.defaultPrecio = defaultPrecio;
	}

	@Override
	public String toString() {
		return "CampanaAds [texto1=" + texto1 + ", texto2=" + texto2 + ", texto3=" + texto3 + ", texto4=" + texto4
				+ ", texto5=" + texto5 + ", aviso=" + aviso + ", precio=" + precio + "]";
	}
}
