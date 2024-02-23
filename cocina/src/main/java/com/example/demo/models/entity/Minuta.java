package com.example.demo.models.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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



	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	private static final long serialVersionUID = 1L;

}
