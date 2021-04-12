package modelo;

import java.io.Serializable;

public class Servicios implements Serializable {
	
	private static final String fich_servicios_blue = "ServiciosBlue.obj";
	private static final String fich_servicios_agency = "ServiciosAgency.obj";
	private static final String fich_servicios_1824 = "Servicio1824.obj";
	
	private static int count = 0;
	
	private int id_servicio;
	private String nombre;
	private String descripcion;
	private double precio;
	
	public Servicios () {
		this.id_servicio = ++count;
	}
	
	public Servicios (String nombre, String descripcion, double precio) {
		this.id_servicio = ++count;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
	}
	
	public int get_id () {
		return id_servicio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public static String getFichServiciosBlue() {
		return fich_servicios_blue;
	}

	public static String getFichServiciosAgency() {
		return fich_servicios_agency;
	}

	public static String getFichServicios1824() {
		return fich_servicios_1824;
	}
	
	@Override
	public String toString() {
		return "Servicios [id_servicio=" + id_servicio + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", precio=" + precio + "]";
	}
	
}
