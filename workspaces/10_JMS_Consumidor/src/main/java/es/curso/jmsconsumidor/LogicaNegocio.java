package es.curso.jmsconsumidor;

import org.springframework.stereotype.Component;

@Component
public class LogicaNegocio {

	//Me creo está clase para que albergar la logica de negocio. Aquí haremos las operaciones
	//En las otras clases solo invocamos a este método.
	public void metodo(String mensaje) {
		System.out.println("Procesando el mensaje....: "+ mensaje);
	}
}
