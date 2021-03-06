package reports_modelo;

import eventos.Reports;

public class Glosario {
	
	public static String ruta = Reports.jrGlosario;
	
	public static String text1Default = "*Todos nuestros packs tienen 1 mes de prueba cuanto a la permanencia.";
	public static String text2Default = "*IVA no incluido en los precios.";
	public static String text3Default = "*La penalizaci?n por no cumplimiento de la totaldad del contrato ser? un 10% sobre el importe que falte por pagar.";
	
	String texto1, texto2, texto3;

	public Glosario(String texto1, String texto2, String texto3) {
		this.texto1 = texto1;
		this.texto2 = texto2;
		this.texto3 = texto3;
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

	public static String getRuta() {
		return ruta;
	}

	public static void setRuta(String ruta) {
		Glosario.ruta = ruta;
	}

	public static String getText1Default() {
		return text1Default;
	}

	public static void setText1Default(String text1Default) {
		Glosario.text1Default = text1Default;
	}

	public static String getText2Default() {
		return text2Default;
	}

	public static void setText2Default(String text2Default) {
		Glosario.text2Default = text2Default;
	}

	public static String getText3Default() {
		return text3Default;
	}

	public static void setText3Default(String text3Default) {
		Glosario.text3Default = text3Default;
	}

	@Override
	public String toString() {
		return "Glosario [texto1=" + texto1 + ", texto2=" + texto2 + ", texto3=" + texto3 + "]";
	}
	
	
}
