package modelo;

public class Servicios {
	
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
	
}
