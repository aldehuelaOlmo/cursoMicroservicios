package es.curso.aplicacionnotificaciones.dto;


public class NotificacionDto {

	private int idUser;
	private String tipoMensaje;
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getTipoMensaje() {
		return tipoMensaje;
	}
	public void setTipoMensaje(String tipoMensaje) {
		this.tipoMensaje = tipoMensaje;
	}
	public NotificacionDto(int idUser, String tipoMensaje) {
		super();
		this.idUser = idUser;
		this.tipoMensaje = tipoMensaje;
	}
	public NotificacionDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
