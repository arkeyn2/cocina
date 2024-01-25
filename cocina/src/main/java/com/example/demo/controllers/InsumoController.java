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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.entity.Insumo;
import com.example.demo.models.services.IInsumosService;

@CrossOrigin(origins ={"http://loalhost:4200","*"})
@RestController
@RequestMapping("/api")
public class InsumoController {

	@Autowired
	private IInsumosService insumoService;
	
	@GetMapping("/insumos")
	public List<Insumo>index(){
		return insumoService.findAll();
	}
	
	@GetMapping("/tragos{id}")
	public ResponseEntity<?> show(@PathVariable Long id){
		
		Insumo insumos = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			insumos = insumoService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta a la base de datos");
			response.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		if (insumos == null) {
			response.put("mensaje", "El tipo id:".concat(id.toString().concat(" no existe en la base de datos!")));
		}
		return new ResponseEntity<Insumo>(insumos, HttpStatus.OK);
	}
	
	@PostMapping("/insumos")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> create (@RequestBody Insumo insumos){
	
		Insumo insumosnew =null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			insumosnew = insumoService.save(insumos);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El insumo ha sido creado con exito!");
		response.put("insumos", insumosnew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@PostMapping("/insumos/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> update(@RequestBody Insumo insumos, @PathVariable Long id ){
	
		Insumo insumosActual =insumoService.findById(id);
		
		Insumo insumosUpdate =null;
		
		Map<String, Object> response = new HashMap<>();
		
		if (insumos == null) {
			response.put("mensaje", "El insumos Id:" .concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		
		}
		try {
			insumosUpdate.setNombre(insumos.getNombre());
			insumosUpdate.setDescripcion(insumos.getDescripcion());
			insumosUpdate.setEstado(insumos.getEstado());
			insumosUpdate.setCodigo(insumos.getCodigo());
			insumosUpdate.setDescripcion_umv(insumos.getDescripcion_umv());
			insumosUpdate.setPrecio_unidad(insumos.getPrecio_unidad());
			insumosUpdate.setTemperatura(insumos.getTemperatura());
			insumosUpdate.setFecha_vencimiento(insumos.getFecha_vencimiento());
			
			insumosUpdate = insumoService.save(insumosActual);
		}catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar actualizado en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	
		}
		response.put("mensaje", "El insumo ha sido actualizado con exito!");
		response.put("insumos", insumosUpdate);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/insumos/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();
		try {
			insumoService.delete(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El insumo eliminada con exito!");

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}
