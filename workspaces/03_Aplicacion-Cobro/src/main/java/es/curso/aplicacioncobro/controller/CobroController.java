package es.curso.aplicacioncobro.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;


import es.curso.aplicacioncobro.dto.Cobro;
import es.curso.aplicacioncobro.dto.Stock;

@RestController
@RequestMapping(path="/cobro")
public class CobroController {
	
	
	private static final String URI_SERVICE_VALIDACION_STOCK = "http://localhost:8081/validacionCompra";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(path="/realizacionCompra",method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public void realizacionCobro(Cobro cobro) throws RestClientException, URISyntaxException {
		
		if(posibilidadDeComprar()) {
		//Calculo el valor de la compra
		int precio = (cobro.getCantidad()*cobro.getPrecio()); 
		
		//Muestro la compra que se ha realizado
		System.out.println("El usuario "+ cobro.getIdUser() + " ha realizado la compra"
				+ "del producto " +cobro.getIdProducto() + " con un precio de "
				+ precio);
		}else
			System.out.println("No se puede realizar la compra.");
	}
	
	/**
	 *  Este metodo estudio si existe la posibilidad de realizar la compra.
	 * @return Boolean
	 * @throws RestClientException
	 * @throws URISyntaxException
	 */
	//FALLA
	@RequestMapping(path="/posibilidadDeComprar",method=RequestMethod.POST,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public Boolean posibilidadDeComprar() throws RestClientException, URISyntaxException {

		Stock stock = buildStock();
		
		boolean validated=false;
		ResponseEntity<Boolean> responseEntity = restTemplate.postForEntity(new URI(URI_SERVICE_VALIDACION_STOCK), stock ,Boolean.class);
		if(responseEntity.getBody())
			validated=true;
		else
			validated=false;
		
		return validated;
	}

	/**
	 * 
	 * @return
	 */
	private Stock buildStock() {
		Stock stock = new Stock();
		stock.setCantidad(1);
		stock.setIdProducto(2);
		stock.setNombre("Pantalla");
		return stock;
	}

}
