package modelo;

import java.util.ArrayList;

public class Prueba {
	
	String nombre, apellido;
	
	public Prueba (String nombre, String apellido) {
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	@Override
	public String toString() {
		return "Prueba [nombre=" + nombre + ", apellido=" + apellido + "]";
	}
	
	
}
