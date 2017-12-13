package es.curso.aplicacionstock.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.curso.aplicacionstock.dto.Stock;

@RestController
@RequestMapping(path="/stock")
public class StockController {
	
	private static Integer STOCK_DISPONIBLE = 10;
	
	@RequestMapping(path="/validacionCompra",method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public Boolean validacionCompra(@RequestBody Stock stock) {
		
		//Flag para saber si puedo comprar o no
		Boolean validated;
		//Estudio la condición de compra
		if(stock.getCantidad() < STOCK_DISPONIBLE) {
			//La compra se puede hacer y retorno un true
			validated = true;
			System.out.println("La compra ha sido validada.");
		}else {
			//La compra no se puede hacer y retonor un false.
			validated = false;
			System.out.println("No se puede realizar la compra.");
		}
		//Devuelvo valor de flag.
		return validated; 
	}
	
	@RequestMapping(path="/actualizarStock",method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public void actualizarStock(@RequestBody Stock stock) {
		
		//Actualizo el valor de la cantidad.
		STOCK_DISPONIBLE = ((STOCK_DISPONIBLE-stock.getCantidad()));
		System.out.println("El valor del stock es: " + STOCK_DISPONIBLE);
	}
	
	@RequestMapping(path="/consultaStockDisponible",method=RequestMethod.GET , 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public Integer consultaStockDisponible() {
		
		return STOCK_DISPONIBLE;
		
	}

}
