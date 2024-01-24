package com.example.demo.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.dao.IPlatoDao;
import com.example.demo.models.entity.Plato;

@Service
public class PlatoService implements IPlatoService {
	
	@Autowired
	private IPlatoDao platodao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Plato> findAll() {
		return (List<Plato>) platodao.findAll();
	}

	@Override
	public Plato findById(Long id) {
		return platodao.findById(id).orElse(null);
	}

	@Override
	public Plato save(Plato plato) {
		return platodao.save(plato);
	}

	@Override
	public void delete(Long id) {
		platodao.deleteById(id);
		
	}

}
