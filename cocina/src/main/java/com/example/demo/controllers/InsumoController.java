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
import com.example.demo.models.entity.Insumo;
import com.example.demo.models.entity.Movimiento_stock;
import com.example.demo.models.services.IInsumosService;
import com.example.demo.models.services.IMovimiento_stockservice;

@CrossOrigin(origins ={"http://loalhost:4200","*"})
@RestController
@RequestMapping("/api")
public class InsumoController {

	@Autowired
	private IInsumosService insumoService;
	@Autowired
	private IMovimiento_stockservice imovstock ;
	
	@GetMapping("/insumos")
	public List<Insumo>index(){
		return insumoService.findAll();
	}
	
	@GetMapping("/insumos/{id}")
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
		Movimiento_stock socknew =null;
		Movimiento_stock movstock = null;
		Insumo insumosnew =null;
		Map<String, Object> response = new HashMap<>();
		//System.out.print("id " + insumos.getId()+" -");
		
		try {
			
			insumosnew = insumoService.save(insumos);
			System.out.print("id " + insumosnew.getId()+" -");
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El insumo ha sido creado con exito!");
		response.put("insumos", insumosnew);
		System.out.print("id " + insumosnew.getId()+" -");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@PutMapping("/insumos/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> update(@RequestBody Insumo insumo, @PathVariable Long id) {

		Insumo insumoActual = insumoService.findById(id);

		Insumo insumoUpdate = null;

		Map<String, Object> response = new HashMap<>();

		if (insumo == null) {
			response.put("mensaje", "El usuario Id:".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {

			insumoActual.setNombre(insumo.getNombre());
			insumoActual.setPrecio_unidad(insumo.getPrecio_unidad());
			insumoActual.setDescripcion(insumo.getDescripcion());
			insumoActual.setCodigo(insumo.getCodigo());
			insumoActual.setDescripcion_umv(insumo.getDescripcion_umv());
			insumoActual.setEstado(insumo.getEstado());
			insumoActual.setFecha_vencimiento(insumo.getFecha_vencimiento());
			insumoActual.setTemperatura(insumo.getTemperatura());
			
			insumoActual.setMovimiento_stock(insumo.getMovimiento_stock());
			
			insumoUpdate = insumoService.save(insumoActual);
			
			System.out.print(insumoActual.getMovimiento_stock().getFactura());
			System.out.print("--");
			System.out.print(insumoUpdate.getMovimiento_stock().getFactura());
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el actualizar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El insumo ha sido actualizado con exito!");
		response.put("usuario", insumoUpdate);
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
