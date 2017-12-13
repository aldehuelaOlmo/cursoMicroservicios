package es.curso.aplicacionenvio.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.curso.aplicacionenvio.dto.Envio;

@RestController
@RequestMapping("/envio")
public class EnvioController {

	@RequestMapping(path="/seleccionMetodoEnvio",method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public void seleccionMetodoEnvio(@RequestBody Envio envio) {

		switch(envio.getMetodoEnvio()) {
		case 0:
			System.out.println("Se ha elegido Correos.");
			break;
		case 1:
			System.out.println("Se ha elegido DHL.");
			break;
		case 2:
			System.out.println("Se ha elegido ASM.");
			break;
		default:
				System.out.println("Elección Erronea.");
				break;
			
			
		}
	}
}
