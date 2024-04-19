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

import com.example.demo.models.entity.Bodega;
import com.example.demo.models.entity.Insum_bodega;
import com.example.demo.models.services.IInsum_bodegaService;

@CrossOrigin(origins ={"http://loalhost:4200","*"})
@RestController
@RequestMapping("/api")
public class Insum_bodegaController {
	@Autowired
	private IInsum_bodegaService insboService; 
	
    @GetMapping("/insumbodega")
	public List<Insum_bodega>index(){
		return insboService.findAll();
	}
	
    @GetMapping("/insumbodega/{id}")
	public ResponseEntity<?> show(@PathVariable Long id){
		
    	Insum_bodega bodega = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			bodega = insboService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta a la base de datos");
			response.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		if (bodega == null) {
			response.put("mensaje", "La bodega id:".concat(id.toString().concat(" no existe en la base de datos!")));
		}
		return new ResponseEntity<Insum_bodega>(bodega, HttpStatus.OK);
	}
    
	@PostMapping("/insumbodega")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> create (@RequestBody Insum_bodega bodega){
	
		Insum_bodega bodeganew =null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			bodeganew = insboService.save(bodega);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "La bodega ha sido creada con exito!");
		response.put("bodega", bodeganew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/insumbodega/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();
		try {
			insboService.delete(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "La bodega ha sido eliminada con exito!");

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}
