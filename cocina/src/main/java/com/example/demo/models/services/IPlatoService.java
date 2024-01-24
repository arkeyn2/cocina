package com.example.demo.models.services;

import java.util.List;

import com.example.demo.models.entity.Plato;

public interface IPlatoService {
	
	public List<Plato> findAll();
	
	public Plato findById(Long id);
	
	public Plato save (Plato plato);
	
	public void delete (Long id);

}
