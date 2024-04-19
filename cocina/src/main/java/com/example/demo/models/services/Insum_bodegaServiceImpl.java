package com.example.demo.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.dao.IInsum_bodegaDao;
import com.example.demo.models.entity.Insum_bodega;
@Service
public class Insum_bodegaServiceImpl implements IInsum_bodegaService{

	@Autowired
	private IInsum_bodegaDao insBDao;
	
	@Override
	 @Transactional(readOnly = true)
	public List<Insum_bodega> findAll() {
		return (List<Insum_bodega>) insBDao.findAll();
	}

	@Override
	public Insum_bodega findById(Long id) {
		return insBDao.findById(id).orElse(null);
	}

	@Override
	public Insum_bodega save(Insum_bodega insum_bodega) {
		return insBDao.save(insum_bodega);
	}

	@Override
	public void delete(Long id) {
		insBDao.deleteById(id);
	}

}
