package com.example.demo.models.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity
public class Movimiento_stock implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = true)
	private int cantidad_platos;
	
	@NotNull
	private Date fecha;

	private int entrada;

	private int salida;
	
	private int Factura;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "stock_id")
	private Stock stock;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
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

	public int getFactura() {
		return Factura;
	}

	public void setFactura(int factura) {
		Factura = factura;
	}



	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}



	public int getCantidad_platos() {
		return cantidad_platos;
	}

	public void setCantidad_platos(int cantidad_platos) {
		this.cantidad_platos = cantidad_platos;
	}



	private static final long serialVersionUID = 1L;

}
