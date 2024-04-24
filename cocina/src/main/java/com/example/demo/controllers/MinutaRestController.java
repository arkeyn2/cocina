package com.example.demo.controllers;

import java.sql.Date;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
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

import com.example.demo.models.entity.Minuta;
import com.example.demo.models.entity.Tipo;
import com.example.demo.models.services.IMinutaService;

@CrossOrigin(origins ={"http://loalhost:4200","*"})
@RestController
@RequestMapping("/api")
public class MinutaRestController {

	@Autowired
	private IMinutaService minutaService;
	
	@GetMapping("/minutas")
	public List<Minuta>index(){
		return minutaService.findAll();
	}
	
	@GetMapping("/minutas/{id}")
	public ResponseEntity<?> show(@PathVariable Long id){
		
		Minuta minutas = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			minutas = minutaService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta a la base de datos");
			response.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		if (minutas == null) {
			response.put("mensaje", "La minuta id:".concat(id.toString().concat(" no existe en la base de datos!")));
		
		}
		return new ResponseEntity<Minuta>(minutas, HttpStatus.OK);
	}
	
	@PostMapping("/minutas")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> create (@RequestBody Minuta minutas){
	
		
		Minuta minutasnew =null;
		System.out.println(minutas.getFecha());
		Map<String, Object> response = new HashMap<>();
		
		try {
			minutasnew = minutaService.save(minutas);
			System.out.println(minutasnew.getFecha());
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "La minuta ha sido creado con exito!");
		response.put("minutas", minutasnew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@PutMapping("/minutas/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> update(@RequestBody Minuta minutas, @PathVariable Long id ){
	
		Minuta minutasActual =minutaService.findById(id);
		
		Minuta minutasUpdate =null;
		
		Map<String, Object> response = new HashMap<>();
		
		if (minutas == null) {
			response.put("mensaje", "La minuta Id:" .concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		
		}
		try {
			minutasActual.setNombre(minutas.getNombre());
			minutasActual.setHorario(minutas.getHorario());
			minutasActual.setDetalle(minutas.getDetalle());
			minutasActual.setFecha(minutas.getFecha());
			minutasUpdate = minutaService.save(minutasActual);
		}catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar actualizado en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	
		}
		response.put("mensaje", "La minuta ha sido actualizado con exito!");
		response.put("minuta", minutasUpdate);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/minutas/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();
		try {
			minutaService.delete(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "La minuta fue eliminada con exito!");

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	
	@GetMapping("/minutas/delete/{nombre}/{fecha}")
	public ResponseEntity<?> eliminar_fechastomadas(@PathVariable String nombre,@PathVariable Date fecha) {
		System.out.println(nombre);
		Map<String, Object> response = new HashMap<>();
		
		List<Object> reservahora = null;

		try {
			reservahora = minutaService.deleteminuta(nombre,fecha);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al ejecutar procedimiento almacenado en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity <List<Object>>(reservahora, HttpStatus.OK);
	}
	
	@GetMapping("/minutas/bodega/{bodega}")
	public ResponseEntity<?> minutaBodega(@PathVariable String bodega)throws ParseException {

		List<Object> accion = null;
		Map<String, Object> response = new HashMap<>();

		try {
			accion = minutaService.minutaBodega(bodega);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		if (accion == null) {
			response.put("mensaje", "La accion Id:".toString().concat(" no existe en la base de datos!"));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Object>>(accion, HttpStatus.OK);
	}
	
	
	@GetMapping("/minutas/fecha/{fecha1}/{fecha2}")
	public ResponseEntity<?> minutaFecha(@PathVariable Date fecha1,@PathVariable Date fecha2)throws ParseException {
		
		System.out.print(fecha1);
		List<Object> accion = null;
		Map<String, Object> response = new HashMap<>();
		try {
			accion = minutaService.minutaFecha(fecha1,fecha2);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		if (accion == null) {
			response.put("mensaje", "La accion Id:".concat(fecha1.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Object>>(accion, HttpStatus.OK);
	}
}
