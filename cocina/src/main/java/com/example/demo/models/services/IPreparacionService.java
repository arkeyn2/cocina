package com.example.demo.models.services;

import java.util.List;

import com.example.demo.models.entity.Preparacion;

public interface IPreparacionService {

	public List<Preparacion> findAll();
	
	public Preparacion findById(Long id);
	
	public Preparacion save(Preparacion preparacion);
	
	public void delete(Long id);
	
}
