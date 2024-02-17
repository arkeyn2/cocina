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

import com.example.demo.models.entity.Plato;
import com.example.demo.models.entity.Preparacion;
import com.example.demo.models.services.IPreparacionService;

@CrossOrigin(origins ={"http://loalhost:4200","*"})
@RestController
@RequestMapping("/api")
public class PreparacionRestControler {
	
	@Autowired
	private IPreparacionService preservis;

	@GetMapping("/preparaciones")
	public List<Preparacion>index(){
		return preservis.findAll();
	}
	
	@GetMapping("/preparaciones/{id}")
	public ResponseEntity<?> show(@PathVariable Long id){
		
		Preparacion prepa = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			prepa = preservis.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta a la base de datos");
			response.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		if (prepa == null) {
			response.put("mensaje", "La preparacion id:".concat(id.toString().concat(" no existe en la base de datos!")));
		}
		return new ResponseEntity<Preparacion>(prepa, HttpStatus.OK);
	}
	
	@PostMapping("/preparaciones")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> create (@RequestBody Preparacion preparacion){
	
		Preparacion preparacionnew =null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			preparacionnew = preservis.save(preparacion);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "La preparacion ha sido creado con exito!");
		response.put("trago", preparacionnew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@PostMapping("/preparaciones/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> update(@RequestBody Preparacion preparacion, @PathVariable Long id ){
	
		Preparacion preparacionActual =preservis.findById(id);
		
		Preparacion preparacionUpdate =null;
		
		Map<String, Object> response = new HashMap<>();
		
		if (preparacion == null) {
			response.put("mensaje", "La preparacion Id:" .concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		
		}
		try {
			preparacionActual.setFecha(preparacion.getFecha());
			preparacionActual.setPlato(preparacion.getPlato());
			preparacionActual.setInsumo(preparacion.getInsumo());
			preparacionActual.setStock_necesario(preparacion.getStock_necesario());
			preparacionActual.setTiempo_preparacion(preparacion.getTiempo_preparacion());
			preparacionActual.setUsuario(preparacion.getUsuario());
			
			preparacionUpdate = preservis.save(preparacionActual);
		}catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar actualizado en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	
		}
		response.put("mensaje", "La preparacion ha sido actualizado con exito!");
		response.put("preparacion", preparacionUpdate);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/preparaciones/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();
		try {
			preservis.delete(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "La preparacion fue eliminada con exito!");

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}
