package com.sena.mtsb.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "productos")
public class Producto {

	@Id
	private String idProducto;

	private LocalDateTime fechaCaducidad;

	private int cantidadProducto;

	private String nombreProducto;

	private float valorUnitarioProducto;

	public Producto() {
		super();

	}


	public Producto(String idProducto, LocalDateTime fechaCaducidad, int cantidadProducto, String nombreProducto,
			float valorUnitarioProducto) {
		super();
		this.idProducto = idProducto;
		this.fechaCaducidad = fechaCaducidad;
		this.cantidadProducto = cantidadProducto;
		this.nombreProducto = nombreProducto;
		this.valorUnitarioProducto = valorUnitarioProducto;
	}


	public String getIdProducto() {
		return idProducto;
	}


	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}


	public LocalDateTime getFechaCaducidad() {
		return fechaCaducidad;
	}


	public void setFechaCaducidad(LocalDateTime fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}


	public int getCantidadProducto() {
		return cantidadProducto;
	}


	public void setCantidadProducto(int cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}


	public String getNombreProducto() {
		return nombreProducto;
	}


	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}


	public float getValorUnitarioProducto() {
		return valorUnitarioProducto;
	}


	public void setValorUnitarioProducto(float valorUnitarioProducto) {
		this.valorUnitarioProducto = valorUnitarioProducto;
	}


	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", fechaCaducidad=" + fechaCaducidad + ", cantidadProducto="
				+ cantidadProducto + ", nombreProducto=" + nombreProducto + ", valorUnitarioProducto="
				+ valorUnitarioProducto + "]";
	}


	
}
