package reports_modelo;

import eventos.Reports;

public class BlueRedes {
	
	public static String ruta = Reports.jrBlueRedes;
	
	public static String defaultCorreo = "hello@specterblue.com";
	public static String defaultWhatsapp = "+34 722 44 95 68"; //estos datos se podrian leer de un fichero obj donde se pueda modificar el default
	
	String correo, whatsapp;

	public BlueRedes(String correo, String whatsapp) {
		super();
		this.correo = correo;
		this.whatsapp = whatsapp;
	}

	public static String getRuta() {
		return ruta;
	}

	public static void setRuta(String ruta) {
		BlueRedes.ruta = ruta;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getWhatsapp() {
		return whatsapp;
	}

	public void setWhatsapp(String whatsapp) {
		this.whatsapp = whatsapp;
	}
	
	public static String getDefaultCorreo() {
		return defaultCorreo;
	}

	public static void setDefaultCorreo(String defaultCorreo) {
		BlueRedes.defaultCorreo = defaultCorreo;
	}

	public static String getDefaultWhatsapp() {
		return defaultWhatsapp;
	}

	public static void setDefaultWhatsapp(String defaultWhatsapp) {
		BlueRedes.defaultWhatsapp = defaultWhatsapp;
	}

	@Override
	public String toString() {
		return "BlueRedes [correo=" + correo + ", whatsapp=" + whatsapp + "]";
	}
	
}
