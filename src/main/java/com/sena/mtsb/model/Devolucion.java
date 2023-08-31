package com.sena.mtsb.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "devoluciones")
public class Devolucion {

	@Id
	private String idDevolucion;
	
	
	private String itemsDevolucion;
	
	
	private String descripcionDevolucion;
	
	
	private LocalDateTime fechaDevolucion;
	
	
	private int cantidadDevolucion;


	public Devolucion() {
		super();
	}


	public Devolucion(String idDevolucion, String itemsDevolucion, String descripcionDevolucion,
			LocalDateTime fechaDevolucion, int cantidadDevolucion) {
		super();
		this.idDevolucion = idDevolucion;
		this.itemsDevolucion = itemsDevolucion;
		this.descripcionDevolucion = descripcionDevolucion;
		this.fechaDevolucion = fechaDevolucion;
		this.cantidadDevolucion = cantidadDevolucion;
	}


	public String getIdDevolucion() {
		return idDevolucion;
	}


	public void setIdDevolucion(String idDevolucion) {
		this.idDevolucion = idDevolucion;
	}


	public String getItemsDevolucion() {
		return itemsDevolucion;
	}


	public void setItemsDevolucion(String itemsDevolucion) {
		this.itemsDevolucion = itemsDevolucion;
	}


	public String getDescripcionDevolucion() {
		return descripcionDevolucion;
	}


	public void setDescripcionDevolucion(String descripcionDevolucion) {
		this.descripcionDevolucion = descripcionDevolucion;
	}


	public LocalDateTime getFechaDevolucion() {
		return fechaDevolucion;
	}


	public void setFechaDevolucion(LocalDateTime fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}


	public int getCantidadDevolucion() {
		return cantidadDevolucion;
	}


	public void setCantidadDevolucion(int cantidadDevolucion) {
		this.cantidadDevolucion = cantidadDevolucion;
	}


	@Override
	public String toString() {
		return "Devolucion [idDevolucion=" + idDevolucion + ", itemsDevolucion=" + itemsDevolucion
				+ ", descripcionDevolucion=" + descripcionDevolucion + ", fechaDevolucion=" + fechaDevolucion
				+ ", cantidadDevolucion=" + cantidadDevolucion + "]";
	}
	
	
}
