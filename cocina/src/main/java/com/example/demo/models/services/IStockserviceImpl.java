package com.example.demo.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.dao.IStockDao;
import com.example.demo.models.entity.Stock;

@Service
public class IStockserviceImpl implements IStockService{

	
	@Autowired
	private IStockDao stockDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Stock> findAll() {
		return (List<Stock>) stockDao.findAll();
	}

	@Override
	public Stock findById(Long id) {
		return stockDao.findById(id).orElse(null);
	}

	@Override
	public Stock save(Stock stock) {
		return stockDao.save(stock);
	}

	@Override
	public void delete(Long id) {
		stockDao.deleteById(id);
	}

}
