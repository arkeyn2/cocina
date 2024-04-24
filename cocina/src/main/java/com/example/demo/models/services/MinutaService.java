package com.example.demo.models.services;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.dao.IMinutaDao;
import com.example.demo.models.entity.Minuta;
import com.example.demo.models.entity.Tipo;
@Service
public class MinutaService implements IMinutaService{

	
	@Autowired
	private IMinutaDao minutaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Minuta> findAll() {
		return (List<Minuta>) minutaDao.findAll();
	}
	
	@Override
	public Minuta findById(Long id) {
		return minutaDao.findById(id).orElse(null);
	}
	
	@Override
	public Minuta save(Minuta minuta) {
		return minutaDao.save(minuta);
	}

	@Override
	public void delete(Long id) {
		minutaDao.deleteById(id);
		
	}
	
	public List<Object> minutaBodega(String bodega) {
		return minutaDao.minutaBodega(bodega);
	}
	
	@Override
	public List<Object> deleteminuta(String nombre , Date fecha) {
		return minutaDao.deleteminuta(nombre, fecha );
		
	}

	@Override
	public List<Object> minutaFecha(Date fecha1, Date fecha2) {
		// TODO Auto-generated method stub
		return minutaDao.minutaFecha(fecha1, fecha2);
	}
	
}
