package com.example.demo.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Plato implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private String nombre;

	@NotNull
	private String detalle;

	@NotNull
	private String estado;
	
	private String foto;
	@Column(length = 1000)
	private String punto_critico;
	@Column(length = 1000)
	private String observaciones;
	
	private String calorias;
	@Column(length = 1000)
	private String preparacion;
	
	private String tipo;
	@Column(length = 1000)
	private String miseplace;
	
	public String getPunto_critico() {
		return punto_critico;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getMiseplace() {
		return miseplace;
	}


	public void setMiseplace(String miseplace) {
		this.miseplace = miseplace;
	}


	public void setPunto_critico(String punto_critico) {
		this.punto_critico = punto_critico;
	}


	public String getObservaciones() {
		return observaciones;
	}


	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}


	public String getCalorias() {
		return calorias;
	}


	public String getPreparacion() {
		return preparacion;
	}


	public void setPreparacion(String preparacion) {
		this.preparacion = preparacion;
	}


	public void setCalorias(String calorias) {
		calorias = calorias;
	}
	
	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
