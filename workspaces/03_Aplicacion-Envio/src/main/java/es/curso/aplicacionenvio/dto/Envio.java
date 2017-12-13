package es.curso.aplicacionenvio.dto;

public class Envio {

	private int idUser;
	private int metodoEnvio;
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public int getMetodoEnvio() {
		return metodoEnvio;
	}
	public void setMetodoEnvio(int metodoEnvio) {
		this.metodoEnvio = metodoEnvio;
	}
	public Envio(int idUser, int metodoEnvio) {
		super();
		this.idUser = idUser;
		this.metodoEnvio = metodoEnvio;
	}
	public Envio() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
