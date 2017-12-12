package es.curso.aplicacionstock.dto;

public class Stock {

	private Integer idProducto;
	private String nombre;
	private Integer cantidad;
	
	
	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Stock(Integer idProducto, String nombre, Integer cantidad) {
		super();
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.cantidad = cantidad;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Integer getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	
}
