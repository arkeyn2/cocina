package com.example.demo.models.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "insumo")
public class Insumo implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;


	private String codigo;
	
	private String nombre;

	private String descripcion;
	
	private String descripcion_umv;
	
	private String precio_unidad;
	
	private String temperatura;

	private String estado;

	private Date fecha_vencimiento;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "movimiento_stock_id")
	private Movimiento_stock movimiento_stock;

	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Tipo tipo;

	@ManyToMany
    @JoinTable(name = "insumo_bodega", joinColumns = @JoinColumn(name = "insumo_id"), inverseJoinColumns = @JoinColumn(name = "bodiga_id"))
	private Set<Bodega> bodega;

	
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFecha_vencimiento() {
		return fecha_vencimiento;
	}

	public void setFecha_vencimiento(Date fecha_vencimiento) {
		this.fecha_vencimiento = fecha_vencimiento;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion_umv() {
		return descripcion_umv;
	}

	public void setDescripcion_umv(String descripcion_umv) {
		this.descripcion_umv = descripcion_umv;
	}

	public String getPrecio_unidad() {
		return precio_unidad;
	}

	public void setPrecio_unidad(String precio_unidad) {
		this.precio_unidad = precio_unidad;
	}

	public String getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(String temperatura) {
		this.temperatura = temperatura;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Movimiento_stock getMovimiento_stock() {
		return movimiento_stock;
	}

	public void setMovimiento_stock(Movimiento_stock movimiento_stock) {
		this.movimiento_stock = movimiento_stock;
	}

	private static final long serialVersionUID = 1L;


	public Set<Bodega> getBodega() {
		return bodega;
	}

	public void setBodega(Set<Bodega> bodega) {
		this.bodega = bodega;
	}




	

}
