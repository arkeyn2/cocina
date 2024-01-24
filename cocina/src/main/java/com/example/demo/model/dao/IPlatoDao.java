package com.example.demo.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.entity.Plato;

public interface IPlatoDao extends CrudRepository<Plato, Long> {

}
