package es.curso.aplicacioncobro.dto;

public class Cobro {

	public int idCobro;
	public int idUser;
	public int idProducto;
	public int cantidad;
	public int precio;
	public int getIdCobro() {
		return idCobro;
	}
	public void setIdCobro(int idCobro) {
		this.idCobro = idCobro;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public Cobro(int idCobro, int idUser, int idProducto, int cantidad, int precio) {
		super();
		this.idCobro = idCobro;
		this.idUser = idUser;
		this.idProducto = idProducto;
		this.cantidad = cantidad;
		this.precio = precio;
	}
	public Cobro() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
