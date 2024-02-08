package com.example.demo.model.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.entity.Insumo;

public interface IInsumosDao extends CrudRepository<Insumo , Long>{

	Page<Insumo> findAll(Pageable pageable);

}
