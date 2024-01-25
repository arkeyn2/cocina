package com.example.demo.models.entity;

import java.io.Serializable;

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
@Table(name = "stock")
public class Stock implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private int cantidad;

	private int stock_inicial;
	
	private int entrada;
	
	private int salida;
	
	@Column(nullable = false)
	private int stock_critico;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Insumo insumos;

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

	public Insumo getInsumos() {
		return insumos;
	}

	public int getStock_inicial() {
		return stock_inicial;
	}

	public void setStock_inicial(int stock_inicial) {
		this.stock_inicial = stock_inicial;
	}

	public int getEntrada() {
		return entrada;
	}

	public void setEntrada(int entrada) {
		this.entrada = entrada;
	}

	public int getSalida() {
		return salida;
	}

	public void setSalida(int salida) {
		this.salida = salida;
	}

	public void setInsumos(Insumo insumos) {
		this.insumos = insumos;
	}

	private static final long serialVersionUID = 1L;

}
