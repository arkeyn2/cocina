package com.example.demo.models.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "insum_bodega")
public class Insum_bodega implements Serializable{


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private int cantidad;

	private int stock_inicial;
	
	@Column(nullable = false)
	private int stock_critico;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "insumo_id")
	private Insumo insumo;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "bodega_id")
	private Bodega bodega;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getStock_inicial() {
		return stock_inicial;
	}

	public void setStock_inicial(int stock_inicial) {
		this.stock_inicial = stock_inicial;
	}

	public int getStock_critico() {
		return stock_critico;
	}

	public void setStock_critico(int stock_critico) {
		this.stock_critico = stock_critico;
	}

	public Insumo getInsumo() {
		return insumo;
	}

	public void setInsumo(Insumo insumo) {
		this.insumo = insumo;
	}

	




	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
