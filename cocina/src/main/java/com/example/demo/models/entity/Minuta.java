package com.example.demo.models.entity;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name= "minuta")
public class Minuta implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String nombre;
	
	private Date fecha;
	
	private String horario;
	
	private String detalle;
	
	private String bodega;
	
	@Column(nullable = true)
	private int cantidad_plato;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "plato_id")
	private Plato plato;
	
	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public Plato getPlato() {
		return plato;
	}



	public void setPlato(Plato plato) {
		this.plato = plato;
	}



	public Date getFecha() {
		return fecha;
	}



	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}



	public String getHorario() {
		return horario;
	}



	public void setHorario(String horario) {
		this.horario = horario;
	}



	public String getDetalle() {
		return detalle;
	}



	public String getBodega() {
		return bodega;
	}



	public int getCantidad_plato() {
		return cantidad_plato;
	}



	public void setCantidad_plato(int cantidad_plato) {
		this.cantidad_plato = cantidad_plato;
	}



	public void setBodega(String bodega) {
		this.bodega = bodega;
	}



	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	private static final long serialVersionUID = 1L;

}
