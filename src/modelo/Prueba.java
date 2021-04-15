package modelo;

import java.util.ArrayList;

public class Prueba {
	
	String nombre, descripcion;
	Double precio;
	
	public Prueba(String nombre, String descripcion, Double precio) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return descripcion;
	}

	public void setApellido(String apellido) {
		this.descripcion = apellido;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	

	
}
