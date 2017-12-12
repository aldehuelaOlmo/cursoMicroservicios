package es.accenture.clientemicroserviciospring.dto;

public class Persona {

	private Integer id;
	private String nombre;
	


	public Persona() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Persona(Integer id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + "]";
	}
	
}
