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
import com.example.demo.models.entity.Bodega;
import com.example.demo.models.services.IBodegaService;


@CrossOrigin(origins ={"http://loalhost:4200","*"})
@RestController
@RequestMapping("/api")
public class BodegaController {
    @Autowired
	private IBodegaService bodegaService;

    @GetMapping("/bodega")
	public List<Bodega>index(){
		return bodegaService.findAll();
	}

    @GetMapping("/bodega/{id}")
	public ResponseEntity<?> show(@PathVariable Long id){
		
		Bodega bodega = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			bodega = bodegaService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta a la base de datos");
			response.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		if (bodega == null) {
			response.put("mensaje", "La bodega id:".concat(id.toString().concat(" no existe en la base de datos!")));
		}
		return new ResponseEntity<Bodega>(bodega, HttpStatus.OK);
	}
	
	@PostMapping("/bodega")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> create (@RequestBody Bodega bodega){
	
		Bodega bodeganew =null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			bodeganew = bodegaService.save(bodega);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "La bodega ha sido creada con exito!");
		response.put("bodega", bodeganew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@PutMapping("/bodega/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> update(@RequestBody Bodega bodega, @PathVariable Long id) {

		Bodega bodegaActual = bodegaService.findById(id);

		Bodega bodegaUpdate = null;

		Map<String, Object> response = new HashMap<>();

		if (bodega == null) {
			response.put("mensaje", "La bodega Id:".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {

            bodegaActual.setNombre(bodega.getNombre());
			
			bodegaUpdate = bodegaService.save(bodegaActual);
			
			System.out.print(bodegaActual.getNombre());
			System.out.print("--");
			
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el actualizar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "La bodega ha sido actualizada con exito!");
		response.put("usuario", bodegaUpdate);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/bodega/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();
		try {
			bodegaService.delete(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "La bodega ha sido eliminada con exito!");

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

}
