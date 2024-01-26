package com.example.demo.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.dao.IPreparacionDao;
import com.example.demo.models.entity.Preparacion;

@Service
public class PreparacionServuceImpl implements IPreparacionService{
	
	@Autowired
	private IPreparacionDao preparacionDao;

	@Override
	@Transactional(readOnly = true)
	public List<Preparacion> findAll() {
		return (List<Preparacion>) preparacionDao.findAll();
	}

	@Override
	public Preparacion findById(Long id) {
		return preparacionDao.findById(id).orElse(null);
	}

	@Override
	public Preparacion save(Preparacion preparacion) {
		return preparacionDao.save(preparacion);
	}

	@Override
	public void delete(Long id) {
		preparacionDao.deleteById(id);
	}

}
