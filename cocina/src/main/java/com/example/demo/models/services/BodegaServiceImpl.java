package com.example.demo.models.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.dao.IBodegaDao;
import com.example.demo.models.entity.Bodega;
import com.example.demo.models.entity.Stock;


@Service
public class BodegaServiceImpl implements IBodegaService{

    @Autowired
	private IBodegaDao bodegaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Bodega> findAll() {
        return (List<Bodega>) bodegaDao.findAll();
    }

    @Override
    public Bodega findById(Long id) {
        return bodegaDao.findById(id).orElse(null);
    }

    @Override
    public Bodega save(Bodega bodega) {
        return bodegaDao.save(bodega);
    }

    @Override
    public void delete(Long id) {
       bodegaDao.deleteById(id);
    }
    

}
