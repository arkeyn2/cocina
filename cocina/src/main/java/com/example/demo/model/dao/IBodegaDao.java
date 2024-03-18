package com.example.demo.model.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import com.example.demo.models.entity.Bodega;

public interface IBodegaDao extends CrudRepository<Bodega , Long> {
    Page<Bodega> findAll(Pageable pageable);
}
