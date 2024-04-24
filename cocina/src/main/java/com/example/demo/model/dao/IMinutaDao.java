package com.example.demo.model.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.entity.Minuta;
import com.example.demo.models.entity.Preparacion;

public interface IMinutaDao extends CrudRepository<Minuta, Long>{
	
	@Modifying
	@Query(value= "SELECT cast(eliminar_minuta(?1,?2)as text)",nativeQuery = true)
	public List<Object> deleteminuta(String nombre, Date fecha);
	
	@Modifying
    @Query("select mi FROM Minuta mi where bodega = ?1")
    public List<Object> minutaBodega(String bodega);
	
	@Query("select mi from Minuta mi where mi.fecha Between ?1 and ?2")
	public List<Object> minutaFecha(Date fecha1 ,Date fecha2);
	
}
