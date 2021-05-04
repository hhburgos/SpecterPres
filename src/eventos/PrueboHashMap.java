package eventos;

import java.util.HashMap;

import reports_modelo.CampanaAds;
import reports_modelo.ContenidoAudioVisual;

public class PrueboHashMap {
	
	public static void main (String [] args) {
		
		HashMap<Integer,Integer> servicios = new HashMap<Integer,Integer>();
		
		servicios.put(1, 1);
		servicios.put(2, 2);
		servicios.put(2, 5);
//		servicios.remove(2);
		System.out.println(servicios.toString());
		
	}
	
	public void prueba1 () {
		HashMap<String,Object> services = new HashMap<String,Object>();
		services.put("Campaña Ads", new CampanaAds());
		services.put("Contenido AudioVisual", new ContenidoAudioVisual());
		
		Object p = services.get("Campaña Ads");
		
		if (p instanceof CampanaAds)  {
			System.out.println("no mames");
		}
	}
} 
