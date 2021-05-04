package modelo;

import java.io.Serializable;

import eventos.Ficheros;

public class Servicios implements Serializable {
	
	/**
	 * Como pete algo la serialVersionUID será la responsable, pero es para la serializacion
	 */
	private static final long serialVersionUID = -2703872979850240336L;
	private static final String fich_servicios = "Servicios.obj";
	private static final int sector_blue = 1;
	private static final int sector_1824 = 2;
	private static final int sector_agency = 3;

	private static int count = 0;
	
	private int id_servicio;
	private int sector;
	private String nombre;
	private String descripcion;
	private double precio;
	
	public Servicios () {
		this.id_servicio = Ficheros.dameIDServicio();
	}
	
	public Servicios (int sector, String nombre, String descripcion, double precio) {
		this.id_servicio = Ficheros.dameIDServicio();
		this.sector = sector;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
	}
	
	public int get_id () {
		return id_servicio;
	}
	
	public int getSector() {
		return sector;
	}

	public void setSector(int sector) {
		this.sector = sector;
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
	
	public static String getFichServicios() {
		return fich_servicios;
	}
	
	public static int getSectorBlue() {
		return sector_blue;
	}

	public static int getSector1824() {
		return sector_1824;
	}

	public static int getSectorAgency() {
		return sector_agency;
	}

	@Override
	public String toString() {
		return "Servicios [id_servicio=" + id_servicio + ", sector=" + sector + ", nombre=" + nombre + ", descripcion="
				+ descripcion + ", precio=" + precio + "]";
	}

}
