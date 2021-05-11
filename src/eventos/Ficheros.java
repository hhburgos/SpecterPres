package eventos;

import java.awt.Component;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.Cliente;
import modelo.Servicios;

public class Ficheros {
	
	private static ArrayList<Servicios> servicios;
	private static ArrayList<Cliente> clientes;
	
	public static void main (String [] args) {
		servicios = new ArrayList<Servicios>();
		
		leeFicheroServicios(servicios, Servicios.getFichServicios());
//		servicios.clear();
//		
//		servicios.add(new Servicios(Servicios.getSector1824(),"Contenido Audiovisual","Lorem ipsussm", 902));
//		servicios.add(new Servicios(Servicios.getSectorBlue(),"Pack Cian", "Lorem Ipsum", 2342));
//		servicios.add(new Servicios(Servicios.getSectorBlue(),"Pack Turquesa", "Lorem Ipsum", 2342));
//		servicios.add(new Servicios(Servicios.getSectorBlue(),"Pack Zafiro", "Lorem Ipsum", 2342));
//		servicios.add(new Servicios(Servicios.getSectorBlue(),"Tienda Online", "Lorem Ipsum", 2342));
		
		guardaArrayServicios(servicios, Servicios.getFichServicios());
	}
	
	/**
	 * Carga el Array Servicios si es que no lo está y comprueba cual es el id del ultimo servicio almacenado 
	 * y retorna dicho número + 1 para que sea el id del siguiente servicio a añadir
	 * @return
	 */
	public static int dameIDServicio () {
		int dev;
		try {
			if (servicios == null || servicios.size() == 0) {
				leeFicheroServicios(servicios, Servicios.getFichServicios());
			}
			int sizeArray = servicios.size();
			int id = servicios.get(sizeArray - 1).get_id();
			dev = id + 1;
		}
		catch (Exception e) {
			dev = ((int) Math.random() * 99) + 1;
		}
		return dev;
	}
	
	public static void leeFicheroCliente (ArrayList<Cliente> lista, String archivo) {
		//Creamos un objeto de tipo File a partir de la ruta absoluta o relativa al fichero
		File fich = new File(archivo);
		//Cargamos el fichero de árboles en el ArrayList
		try {
			if (fich.exists()){
				System.out.println("EL fichero YA existe");
				FileInputStream fie = new FileInputStream(fich);
				ObjectInputStream ois=new ObjectInputStream(fie);
				
				while(true){
					Cliente a = (Cliente)ois.readObject();
					lista.add(a);
					System.out.println(a.toString());
				}
			}
			else System.out.println("El fichero todavía NO existe");
			
		}catch (EOFException eof) {
			System.out.println("\n****** FIN DE FICHERO *******");
			// AQUI NO SE PUEDE PONER NINGUN MENSAJE DE ERRROR, ES UN EXCEPTION QUE VA A SALTAR SIEMPRE
//			JOptionPane.showMessageDialog( null, eof.getStackTrace(), "PDF Guardado", JOptionPane.PLAIN_MESSAGE ); 
		}catch (FileNotFoundException fnf) {
			System.err.println("Fichero no encontrado " + fnf);
			JOptionPane.showMessageDialog( null, fnf.getStackTrace(), "PDF Guardado", JOptionPane.PLAIN_MESSAGE ); 
		}catch(IOException e){
			System.err.println("Se ha producido una IOException");
			e.printStackTrace();
			JOptionPane.showMessageDialog( null, e.getStackTrace(), "PDF Guardado", JOptionPane.PLAIN_MESSAGE ); 
		}catch (Exception e) {
			System.err.println("Error de programa: " + e);
			e.printStackTrace();
			JOptionPane.showMessageDialog( null, e.getStackTrace(), "PDF Guardado", JOptionPane.PLAIN_MESSAGE ); 
		}
	}
	
	public static void leeFicheroServicios (ArrayList<Servicios> lista, String archivo) {
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
			// AQUI NO SE PUEDE PONER NINGUN MENSAJE DE ERRROR, ES UN EXCEPTION QUE VA A SALTAR SIEMPRE
//			JOptionPane.showMessageDialog( null, eof.getStackTrace(), "PDF Guardado", JOptionPane.PLAIN_MESSAGE ); 
		}catch (FileNotFoundException fnf) {
			System.err.println("Fichero no encontrado " + fnf);
			JOptionPane.showMessageDialog( null, fnf.getStackTrace(), "PDF Guardado", JOptionPane.PLAIN_MESSAGE ); 
		}catch(IOException e){
			System.err.println("Se ha producido una IOException");
			e.printStackTrace();
			JOptionPane.showMessageDialog( null, e.getStackTrace(), "PDF Guardado", JOptionPane.PLAIN_MESSAGE ); 
		}catch (Exception e) {
			System.err.println("Error de programa: " + e);
			e.printStackTrace();
			JOptionPane.showMessageDialog( null, e.getStackTrace(), "PDF Guardado", JOptionPane.PLAIN_MESSAGE ); 
		}
	}
	
	public static void guardaArrayCliente (ArrayList<Cliente> lista, String archivo) {
		try {
			FileOutputStream fos = new FileOutputStream(archivo);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			for (Cliente a : lista) oos.writeObject(a);
				oos.close();
				
		} catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog( null, e.getStackTrace(), "PDF Guardado", JOptionPane.PLAIN_MESSAGE ); 
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
			JOptionPane.showMessageDialog( null, e.getStackTrace(), "PDF Guardado", JOptionPane.PLAIN_MESSAGE ); 
		}
	}

	public static void mensajeError (Component parent, String mensaje, String titulo) {
		JOptionPane.showMessageDialog(parent, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
	}
	
	public static void mensaje (Component parent, String mensaje, String titulo) {
		JOptionPane.showMessageDialog(parent, mensaje, titulo, JOptionPane.PLAIN_MESSAGE);
	}

}
