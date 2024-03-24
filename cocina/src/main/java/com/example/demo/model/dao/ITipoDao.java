package com.example.demo.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.entity.Preparacion;
import com.example.demo.models.entity.Tipo;

public interface ITipoDao extends CrudRepository<Tipo, Long>{

}
