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

import com.example.demo.models.entity.Movimiento_stock;
import com.example.demo.models.entity.Plato;
import com.example.demo.models.entity.Stock;
import com.example.demo.models.services.IMovimiento_stockservice;

@CrossOrigin(origins = { "http://localhost:4200","*" })
@RestController
@RequestMapping("/api")
public class Movimiento_stockController {
	
	@Autowired
	private IMovimiento_stockservice movser;

	@GetMapping("/movstocks")
	public List<Movimiento_stock>findAll() {
		return (List<Movimiento_stock>) movser.findAll();
	}
	
	@GetMapping("/movstocks/{id}")
	public ResponseEntity<?> show(@PathVariable Long id){
		
		Movimiento_stock mov = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			mov = movser.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta a la base de datos");
			response.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		if (mov == null) {
			response.put("mensaje", "El movimiento id:".concat(id.toString().concat(" no existe en la base de datos!")));
		}
		return new ResponseEntity<Movimiento_stock>(mov, HttpStatus.OK);
	}
	
	@PostMapping("/movstocks")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> create (@RequestBody Movimiento_stock movstock){
	
		Movimiento_stock socknew =null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			socknew = movser.save(movstock);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El movimiento ha sido creado con exito!");
		response.put("trago", socknew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@PutMapping("/movstocks/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> update(@RequestBody Movimiento_stock stock, @PathVariable Long id ){
	
		Movimiento_stock stockActual =movser.findById(id);
		
		Movimiento_stock stockUpdate =null;
		
		Map<String, Object> response = new HashMap<>();
		
		if (stock == null) {
			response.put("mensaje", "El movimiento Id:" .concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		
		}
		try {
			stockActual.setEntrada(stock.getEntrada());
			stockActual.setSalida(stock.getSalida());
			stockActual.setFecha(stock.getFecha());
			stockActual.setFactura(stock.getFactura());
			stockActual.setStock(stock.getStock());
			
			stockUpdate = movser.save(stockActual);
		}catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar actualizado en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	
		}
		response.put("mensaje", "El movimiento ha sido actualizado con exito!");
		response.put("stock", stockUpdate);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/movstocks/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();
		try {
			movser.delete(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El movimiento eliminada con exito!");

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

}
