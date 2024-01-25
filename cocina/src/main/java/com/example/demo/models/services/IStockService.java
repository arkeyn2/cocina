package com.example.demo.models.services;

import java.util.List;

import com.example.demo.models.entity.Stock;

public interface IStockService {

	public List<Stock> findAll();
	
	public Stock findById(Long id);
	
	public Stock save(Stock stock);
	
	public void delete(Long id);
	
}
