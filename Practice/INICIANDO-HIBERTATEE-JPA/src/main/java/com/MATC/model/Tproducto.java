package com.MATC.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tproductos database table.
 * 
 */
@Entity
@Table(name="tproductos")
@NamedQuery(name="Tproducto.findAll", query="SELECT t FROM Tproducto t")
public class Tproducto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="cantidad_producto")
	private int cantidadProducto;

	@Column(name="nombre_producto")
	private String nombreProducto;

	@Column(name="precio_producto")
	private double precioProducto;

	@Column(name="total_producto")
	private double totalProducto;

	public Tproducto() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCantidadProducto() {
		return this.cantidadProducto;
	}

	public void setCantidadProducto(int cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}

	public String getNombreProducto() {
		return this.nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public double getPrecioProducto() {
		return this.precioProducto;
	}

	public void setPrecioProducto(double precioProducto) {
		this.precioProducto = precioProducto;
	}

	public double getTotalProducto() {
		return this.totalProducto;
	}

	public void setTotalProducto(double totalProducto) {
		this.totalProducto = totalProducto;
	}

}