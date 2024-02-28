package com.example.demo.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.entity.Stock;
import com.example.demo.models.services.IStockService;

@CrossOrigin(origins ={"http://loalhost:4200","*"})
@RestController
@RequestMapping("/api")
public class StockResController {
	
	@Autowired
	private IStockService stockser;
	
	@GetMapping("/stocks")
	public List<Stock>index(){
		return stockser.findAll();
	}

	@GetMapping("/stocks/{id}")
	public ResponseEntity<?> show(@PathVariable Long id){
		
		Stock stock = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			stock = stockser.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta a la base de datos");
			response.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		if (stock == null) {
			response.put("mensaje", "El stock id:".concat(id.toString().concat(" no existe en la base de datos!")));
		}
		return new ResponseEntity<Stock>(stock, HttpStatus.OK);
	}
	
	@PostMapping("/stocks")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> create (@RequestBody Stock stock){
	
		Stock stocknew =null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			stocknew = stockser.save(stock);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El stock ha sido creado con exito!");
		response.put("stock", stocknew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@PutMapping("/stocks/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> update(@RequestBody Stock stock, @PathVariable Long id ){
	
		Stock stockActual =stockser.findById(id);
		
		Stock stockUpdate =null;
		
		Map<String, Object> response = new HashMap<>();
		
		if (stock == null) {
			response.put("mensaje", "El stock Id:" .concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		
		}
		try {
			stockActual.setCantidad(stock.getCantidad());
			stockActual.setStock_critico(stock.getStock_critico());
			stockActual.setInsumos(stock.getInsumos());
			stockActual.setStock_inicial(stock.getStock_inicial());
			
			stockUpdate = stockser.save(stockActual);
		}catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar actualizado en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	
		}
		response.put("mensaje", "El stock ha sido actualizado con exito!");
		response.put("stock", stockUpdate);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/stocks/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();
		try {
			stockser.delete(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El stock eliminada con exito!");

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}
