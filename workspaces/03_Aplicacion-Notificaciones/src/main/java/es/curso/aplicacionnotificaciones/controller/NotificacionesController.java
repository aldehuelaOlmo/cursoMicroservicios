package es.curso.aplicacionnotificaciones.controller;

import javax.jms.Destination;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.curso.aplicacionnotificaciones.dto.NotificacionDto;

@RestController
public class NotificacionesController {

	@Autowired
	private JmsTemplate jmsTemplate;
	
	@RequestMapping(path="/", method=RequestMethod.POST)
	public void lanceNotificaciones(@RequestParam int idUser,@RequestParam int tipoMensaje) {
	
		NotificacionDto message = new NotificacionDto (idUser, getPlantilla(tipoMensaje));
		jmsTemplate.convertAndSend(new ActiveMQQueue("mensajes"), message );
	}

	/**
	 * 
	 * @param tipoMensaje
	 * @return
	 */
	private String getPlantilla(int tipoMensaje) {
		
		switch(tipoMensaje) {
		case 0:
			return "Compra";
		case 1:
			return "Alta";
		default:
		
		return null;
		}
	}
}
