package es.curso.jmsconsumidor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MensjaesJmsListener {

	@Autowired
	private LogicaNegocio logicaNegocio;
	
	//lo que aparece en destination es el nombre del queue que hemos creado en ActiveMQ.
	@JmsListener(destination="mensajes")
	public void procesarMensajes(String mensaje) {
		logicaNegocio.metodo(mensaje);
	}
}
