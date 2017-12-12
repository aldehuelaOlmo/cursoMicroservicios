package es.accenture.clientemicroserviciospring.controllers;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import es.accenture.clientemicroserviciospring.dto.Persona;

@RestController
@RequestMapping(path="/gestion")
public class GestionRestController {

	private static final String URI_SERVICE_PERSONAS = "http://localhost:8081/personas";
	//Me creo una instancia y lo inyecto.
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public void method() throws URISyntaxException {
		
		ResponseEntity<Persona> responseEntity = restTemplate.getForEntity(new URI(URI_SERVICE_PERSONAS), Persona.class);
	
		//Estas opciones nos aparecen ya que estamos utilizando el getForEntity. Si 
		//Utilizaramos el getForObject solamente nos devolveria el body. 
		HttpStatus statusCode = responseEntity.getStatusCode();
		//Nos muestra el código de estado
		System.out.print(statusCode);
		HttpHeaders headers = responseEntity.getHeaders();
		System.out.print(headers);
		Persona persona = responseEntity.getBody();
	
		//Envio mediante post el objeto que me ha devuelto la petición get que he hecho anteriormente
		restTemplate.postForEntity(new URI(URI_SERVICE_PERSONAS), persona , void.class);
	}
}
