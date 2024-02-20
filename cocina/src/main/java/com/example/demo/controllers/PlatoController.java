package com.example.demo.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.File;
import java.nio.file.Files;
import java.io.IOException;
import org.springframework.core.io.UrlResource;
import java.net.MalformedURLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import com.example.demo.models.entity.Plato;
import com.example.demo.models.services.IPlatoService;

@CrossOrigin(origins = { "http://localhost:4200","*" })
@RestController
@RequestMapping("/api")
public class PlatoController {

	@Autowired
	private IPlatoService platoser;
	private final Logger log = LoggerFactory.getLogger(UsuarioRestController.class);
	
	@GetMapping("/platos")
	public List<Plato>findAll() {
		return (List<Plato>) platoser.findAll();
	}

	@GetMapping("/platos/{id}")
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
	
	@PutMapping("/platos/{id}")
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
			platoActual.setPunto_critico(plato.getPunto_critico());
			platoActual.setObservaciones(plato.getObservaciones());
			platoActual.setCalorias(plato.getCalorias());
			
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
	
	@DeleteMapping("/platos/{id}")
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
	
	@PostMapping("/platos/upload")
	public ResponseEntity<?>upload(@RequestParam("archivo")MultipartFile archivo, @RequestParam("id") long id){
		Map<String, Object> response = new HashMap<>();
		
		Plato plato =platoser.findById(id);
		
		if(!archivo.isEmpty()) {
			String nombreArchivo=UUID.randomUUID().toString() + "_" +archivo.getOriginalFilename().replace(" ","");
			Path rutaArchivo = Paths.get("uploads").resolve(nombreArchivo).toAbsolutePath();
			
			try {
				Files.copy(archivo.getInputStream(), rutaArchivo);
			} catch (IOException e) {
				response.put("mensaje", "Error al subir la imagen");
				response.put("error", e.getMessage().concat(": ").concat(e.getCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			String nombreFotoAnterior =plato.getFoto();
			
			if(nombreFotoAnterior !=null && nombreFotoAnterior.length() >0) {
				Path rutaFotoAnterior =Paths.get("uploads").resolve(nombreFotoAnterior).toAbsolutePath();
				File archivoFotoAnterior = rutaFotoAnterior.toFile();
				if(archivoFotoAnterior.exists() && archivoFotoAnterior.canRead()) {
					archivoFotoAnterior.delete();
				}
			}
			
			plato.setFoto(nombreArchivo);
			platoser.save(plato);
			response.put("mascota", plato);
			response.put("mensahe", "Has subido correctamente la imagen:" );
		}
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@GetMapping("/uploads/img/{nombreFoto:.+}")
	public ResponseEntity<Resource> verFoto(@PathVariable String nombreFoto){
		
		Path rutaArchivo = Paths.get("uploads").resolve(nombreFoto).toAbsolutePath();
		log.info(rutaArchivo.toString());
		
		Resource recurso = null;
		
		try {
			recurso = new UrlResource(rutaArchivo.toUri());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		if(!recurso.exists() && !recurso.isReadable()) {
			throw new RuntimeException("Error no se pudo cargar la imagen: " + nombreFoto);
		}
		HttpHeaders cabecera = new HttpHeaders();
		cabecera.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + recurso.getFilename() + "\"");
		
		return new ResponseEntity<Resource>(recurso, cabecera, HttpStatus.OK);
	}
	
}

