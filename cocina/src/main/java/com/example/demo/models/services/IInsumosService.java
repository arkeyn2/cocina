package com.example.demo.models.services;

import java.util.List;

import com.example.demo.models.entity.Insumo;

public interface IInsumosService {
	
	public List<Insumo> findAll();
	
	public Insumo findById(Long id);
	
	public Insumo save(Insumo insumo);
	
	public void delete(Long id);

}
