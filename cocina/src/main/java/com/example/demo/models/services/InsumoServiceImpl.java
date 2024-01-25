package com.example.demo.models.services;

import java.util.List;


import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.dao.IInsumosDao;
import com.example.demo.models.entity.Insumo;

@Service
public class InsumoServiceImpl implements IInsumosService{
	
	@Autowired
	private IInsumosDao insumoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Insumo> findAll(){
		return (List<Insumo>) insumoDao.findAll();
		
	}
	
	@Override
	public Insumo findById(Long id) {
		return insumoDao.findById(id).orElse(null);
	}

	@Override
	public Insumo save(Insumo insumo) {
		return insumoDao.save(insumo);
	}

	@Override
	public void delete(Long id) {
		insumoDao.deleteById(id);
	}


}
