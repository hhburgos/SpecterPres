package modelo;

import java.util.ArrayList;

public class Prueba {
	
	String nombre, apellido;
	Double precio;
	
	public Prueba(String nombre, String apellido, Double precio) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.precio = precio;
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

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	
}
