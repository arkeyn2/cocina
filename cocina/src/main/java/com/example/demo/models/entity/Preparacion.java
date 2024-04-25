package com.example.demo.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "preparacion")
public class Preparacion implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	private Date fecha;
	

	private int stock_necesario;
	

	private int tiempo_preparacion;
	
	private String estado;
	

	@ManyToOne(cascade = CascadeType.MERGE)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Usuario usuario;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Insumo insumo;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Plato plato;
	
	
	
	public long getId() {
		return id;
	}





	public void setId(long id) {
		this.id = id;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}



	public int getStock_necesario() {
		return stock_necesario;
	}


	public void setStock_necesario(int stock_necesario) {
		this.stock_necesario = stock_necesario;
	}


	public Insumo getInsumo() {
		return insumo;
	}


	public void setInsumo(Insumo insumo) {
		this.insumo = insumo;
	}


	public int getTiempo_preparacion() {
		return tiempo_preparacion;
	}


	public void setTiempo_preparacion(int tiempo_preparacion) {
		this.tiempo_preparacion = tiempo_preparacion;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public Plato getPlato() {
		return plato;
	}


	public void setPlato(Plato plato) {
		this.plato = plato;
	}


	
	
	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	private static final long serialVersionUID = 1L;
}
