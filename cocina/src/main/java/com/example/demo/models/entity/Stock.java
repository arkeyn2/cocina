package com.example.demo.models.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "stock")
public class Stock implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private int cantidad;

	private int stock_inicial;
	
	@Column(nullable = false)
	private int stock_critico;

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

	public int getStock_critico() {
		return stock_critico;
	}

	public void setStock_critico(int stock_critico) {
		this.stock_critico = stock_critico;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public int getStock_inicial() {
		return stock_inicial;
	}

	public void setStock_inicial(int stock_inicial) {
		this.stock_inicial = stock_inicial;
	}

	private static final long serialVersionUID = 1L;

	public Bodega getBodega() {
		return bodega;
	}

	public void setBodega(Bodega bodega) {
		this.bodega = bodega;
	}

	
}
