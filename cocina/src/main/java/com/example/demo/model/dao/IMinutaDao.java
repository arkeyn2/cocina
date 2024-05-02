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
	
	@Query("select mi from Minuta mi where mi.fecha Between ?1 and ?2 and mi.bodega=?3")
	public List<Object> minutaFecha(Date fecha1 ,Date fecha2,String bodega);
	
	@Query("select i.id,m.cantidad_plato as cantidad,m.bodega,p.nombre,i.descripcion,pr.stock_necesario,st.cantidad from Minuta m inner join Plato p ON m.nombre =p.nombre inner join Preparacion pr on pr.plato.id = p.id inner join Insumo i on i.id =pr.insumo.id inner join Movimiento_stock ms on i.movimiento_stock.id=ms.id inner join Stock st on ms.stock.id=st.id where m.fecha Between ?1 and ?2 and m.bodega=?3")
	public List<Object> minutaFechaIJ(Date fecha1 ,Date fecha2,String bodega);
	
	
}
//select * from minuta m inner join plato p ON m.nombre =p.nombre  
//inner join preparacion p2 on p2.plato_id = p.id 
//inner join insumo i on i.id =p2.insumo_id where  m.bodega='bodega4'