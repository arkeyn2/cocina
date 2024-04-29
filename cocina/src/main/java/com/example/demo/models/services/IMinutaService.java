package com.example.demo.models.services;

import java.sql.Date;
import java.util.List;

import com.example.demo.models.entity.Minuta;

public interface IMinutaService {

	public List<Minuta> findAll();
	
	public Minuta findById(Long id);
	
	public Minuta save (Minuta minuta);
	
	public void delete(Long id);
	
	public List<Object> deleteminuta(String nombre,Date fecha);
	
	public List<Object> minutaBodega(String bodega);
	
	public List<Object> minutaFecha(Date fecha1 ,Date fecha2,String bodega);
}
