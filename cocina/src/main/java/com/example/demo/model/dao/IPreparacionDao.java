package com.example.demo.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.example.demo.models.entity.Preparacion;

public interface IPreparacionDao extends CrudRepository<Preparacion , Long> {

	
	@Query("select pre from Preparacion pre inner join Plato pla on pre.plato.id=pla.id where pre.plato.id=?1")
	public List<Preparacion> platoporid(Long id);
	
}
