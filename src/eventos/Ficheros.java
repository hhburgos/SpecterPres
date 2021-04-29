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
	
	private static ArrayList<Servicios> serviciosBlue;
	private static ArrayList<Servicios> servicios1824;
	private static ArrayList<Cliente> clientes;
	
	public static void main (String [] args) {
		servicios1824 = new ArrayList<Servicios>();
		
		leeFicheroServicios(servicios1824, Servicios.getFichServicios1824());
		
//		servicios1824.add(new Servicios("Redes Sociales", "Lorem Ipsum", 2342));
//		servicios1824.add(new Servicios("SEO", "Lorem Ipsum", 142));
//		servicios1824.add(new Servicios("Marketing", "Lorem Ipsum", 2222));
//		System.out.println(servicios1824.get(1).toString());
		
		guardaArrayServicios(servicios1824, Servicios.getFichServicios1824());
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
