package modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Presupuesto {
	private static int count = 0;
	
	private int id;
	private String cliente;
	private LocalDate fecha;
	private ArrayList<Servicios> aServicios;
	
	public Presupuesto () {
		this.id = ++count;
		this.fecha = LocalDate.now();
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public ArrayList<Servicios> getaServicios() {
		return aServicios;
	}

	public void setaServicios(ArrayList<Servicios> aServicios) {
		this.aServicios = aServicios;
	}

	public int getId() {
		return id;
	}
	
	
}
