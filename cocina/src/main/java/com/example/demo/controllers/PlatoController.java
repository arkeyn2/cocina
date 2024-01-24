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
import com.example.demo.models.services.IPlatoService;

@CrossOrigin(origins = { "http://localhost:4200","*" })
@RestController
@RequestMapping("/api")
public class PlatoController {

	@Autowired
	private IPlatoService platoser;
	
	@GetMapping("/platos")
	public List<Plato>findAll() {
		return (List<Plato>) platoser.findAll();
	}

	@GetMapping("/platos{id}")
	public ResponseEntity<?> show(@PathVariable Long id){
		
		Plato plato = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			plato = platoser.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta a la base de datos");
			response.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		if (plato == null) {
			response.put("mensaje", "El plato id:".concat(id.toString().concat(" no existe en la base de datos!")));
		}
		return new ResponseEntity<Plato>(plato, HttpStatus.OK);
	}
	
	@PostMapping("/platos")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> create (@RequestBody Plato plato){
	
		Plato platonew =null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			platonew = platoser.save(plato);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El plato ha sido creado con exito!");
		response.put("trago", platonew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@PostMapping("/platos/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> update(@RequestBody Plato plato, @PathVariable Long id ){
	
		Plato platoActual =platoser.findById(id);
		
		Plato platoUpdate =null;
		
		Map<String, Object> response = new HashMap<>();
		
		if (plato == null) {
			response.put("mensaje", "El plato Id:" .concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		
		}
		try {
			platoActual.setNombre(plato.getNombre());
			platoActual.setDetalle(plato.getDetalle());
			platoActual.setEstado(plato.getEstado());

			
			platoUpdate = platoser.save(platoActual);
		}catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar actualizado en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	
		}
		response.put("mensaje", "El plato ha sido actualizado con exito!");
		response.put("trago", platoUpdate);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/plato/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();
		try {
			platoser.delete(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El plato fue eliminada con exito!");

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}

