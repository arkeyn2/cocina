package com.example.demo.models.services;

import java.util.List;

import com.example.demo.models.entity.Movimiento_stock;

public interface IMovimiento_stockservice {
	
	public List<Movimiento_stock>findAll();
	
	public Movimiento_stock findById(Long id);
	
	public Movimiento_stock save (Movimiento_stock mov_stock);
	
	public void delete (Long id);

}
