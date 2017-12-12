package es.accenture.microserviciospring;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.accenture.microserviciosping.dto.Persona;

@RestController
@RequestMapping(path="/personas")
public class PersonaRestController {

	//Permite definir un filtro que se tiene que cumplir para ejecutar este método. 
	//Si no se cumple cualquiera de las diferentes opciones no se ejecutará dicho método.
		@RequestMapping(method=RequestMethod.GET , 
				produces=MediaType.APPLICATION_JSON_VALUE)
	public Persona get() {
		
			return new Persona(1,"Andrés");
	}
	
	@RequestMapping(method=RequestMethod.POST , 
			consumes= MediaType.APPLICATION_JSON_VALUE)
	public void post(@RequestBody Persona persona) {
		System.out.println("Persona: "+ persona);
	}
	
}
