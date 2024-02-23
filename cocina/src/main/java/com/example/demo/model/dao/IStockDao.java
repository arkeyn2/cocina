package com.example.demo.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.entity.Preparacion;
import com.example.demo.models.entity.Stock;

public interface IStockDao extends CrudRepository<Stock , Long>{
	
	//@Query("select st from st where stock_critico >= cantidad")
	//public List<Stock> platoporid(Stock stock);

}