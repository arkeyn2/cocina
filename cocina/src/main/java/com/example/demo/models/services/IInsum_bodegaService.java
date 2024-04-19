package com.example.demo.models.services;

import java.util.List;

import com.example.demo.models.entity.Bodega;
import com.example.demo.models.entity.Insum_bodega;

public interface IInsum_bodegaService {

	
    public List<Insum_bodega> findAll();
	
	public Insum_bodega findById(Long id);
	
	public Insum_bodega save(Insum_bodega insum_bodega);
	
	public void delete(Long id);
}
