package es.curso.jmsproductor;

import javax.jms.Destination;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MensajesController {

	@Autowired
	private JmsTemplate jmsTemplate;
	
	//Este método espera una petición del tipo: http://localhost:8080/?mensaje=loquesea
	@RequestMapping("/")
	public void procesarMensaje(@RequestParam String mensaje) {
		
		//"Mensajes" pertenece al queue del ActiveMQ.
		Destination destination = new ActiveMQQueue("mensajes");
		jmsTemplate.convertAndSend(destination, "Este es el mensaje que estoy enviando.");
	}
}
