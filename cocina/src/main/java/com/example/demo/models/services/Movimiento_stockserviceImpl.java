package com.example.demo.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.dao.IMovimiento_stockDao;
import com.example.demo.models.entity.Movimiento_stock;
import com.example.demo.models.entity.Plato;

@Service
public class Movimiento_stockserviceImpl implements IMovimiento_stockservice{
	
	@Autowired
	private IMovimiento_stockDao movdao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Movimiento_stock> findAll() {
		return (List<Movimiento_stock>) movdao.findAll();
	}

	@Override
	public Movimiento_stock findById(Long id) {
		return movdao.findById(id).orElse(null);
	}

	@Override
	public Movimiento_stock save(Movimiento_stock mov_stok) {
		return movdao.save(mov_stok);
	}
	
	@Override
	public void delete(Long id) {
		movdao.deleteById(id);
		
	}

}
