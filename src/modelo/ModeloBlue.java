package modelo;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ModeloBlue {
	
	private static ArrayList<Servicios> serviciosBlue;
	
//	public static void main (String [] args) {
//		serviciosBlue = new ArrayList<Servicios>();
//		
//		leeFichero(serviciosBlue);
//		
//		guardaArrayServicios(serviciosBlue);
//	}
	
	public static void leeFichero (ArrayList<Servicios> lista, String archivo) {
		//Creamos un objeto de tipo File a partir de la ruta absoluta o relativa al fichero
		File fich = new File(archivo);
		//Cargamos el fichero de árboles en el ArrayList
		try {
			if (fich.exists()){
				System.out.println("EL fichero YA existe");
				FileInputStream fie = new FileInputStream(fich);
				ObjectInputStream ois=new ObjectInputStream(fie);
				
				while(true){
					Servicios a = (Servicios)ois.readObject();
					lista.add(a);
					System.out.println(a.toString());
				}
			}
			else System.out.println("El fichero todavía NO existe");
			
		}catch (EOFException eof) {
			System.out.println("\n****** FIN DE FICHERO *******");
		}catch (FileNotFoundException fnf) {
			System.err.println("Fichero no encontrado " + fnf);
		}catch(IOException e){
			System.err.println("Se ha producido una IOException");
			e.printStackTrace();
		}catch (Exception e) {
			System.err.println("Error de programa: " + e);
			e.printStackTrace();
		}
	}
	
	public static void guardaArrayServicios (ArrayList<Servicios> lista, String archivo) {
		try {
			FileOutputStream fos = new FileOutputStream(archivo);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			for (Servicios a : lista) oos.writeObject(a);
				oos.close();
				
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
