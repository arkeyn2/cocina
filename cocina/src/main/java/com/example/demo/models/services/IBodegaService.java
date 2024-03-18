package com.example.demo.models.services;

import java.util.List;

import com.example.demo.models.entity.Bodega;


public interface IBodegaService {

    public List<Bodega> findAll();
	
	public Bodega findById(Long id);
	
	public Bodega save(Bodega bodega);
	
	public void delete(Long id);


    
}
