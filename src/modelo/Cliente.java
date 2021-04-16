package modelo;

public class Cliente {
	
	private static final String fich_clientes = "clientes.obj";
	private static int count = 1000;
	
	private int id, codigoPostal, telefono;
	private String nombre, direccion, cif;
	
	public Cliente(int codigoPostal, int telefono, String nombre, String direccion, String cif) {
		this.id = ++count;
		this.codigoPostal = codigoPostal;
		this.telefono = telefono;
		this.nombre = nombre;
		this.direccion = direccion;
		this.cif = cif;
	}
	
	public Cliente (String nombre) {
		this.id = ++count;
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public static String getFichClientes() {
		return fich_clientes;
	}
	
	
}
