package com.sena.mtsb.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "producciones")
public class Produccion {

	@Id
	private String idProduccion;
	
	
	private String tipoProduccion;
	
	
	private int cantidadProduccion;
	
	
	private LocalDateTime fechaProduccion;
	
	
	private String estadoProduccion;


	public Produccion() {
		super();

	}


	public Produccion(String idProduccion, String tipoProduccion, int cantidadProduccion,
			LocalDateTime fechaProduccion, String estadoProduccion) {
		super();
		this.idProduccion = idProduccion;
		this.tipoProduccion = tipoProduccion;
		this.cantidadProduccion = cantidadProduccion;
		this.fechaProduccion = fechaProduccion;
		this.estadoProduccion = estadoProduccion;
	}


	public String getIdProduccion() {
		return idProduccion;
	}


	public void setIdProduccion(String idProduccion) {
		this.idProduccion = idProduccion;
	}


	public String getTipoProduccion() {
		return tipoProduccion;
	}


	public void setTipoProduccion(String tipoProduccion) {
		this.tipoProduccion = tipoProduccion;
	}


	public int getCantidadProduccion() {
		return cantidadProduccion;
	}


	public void setCantidadProduccion(int cantidadProduccion) {
		this.cantidadProduccion = cantidadProduccion;
	}


	public LocalDateTime getFechaProduccion() {
		return fechaProduccion;
	}


	public void setFechaProduccion(LocalDateTime fechaProduccion) {
		this.fechaProduccion = fechaProduccion;
	}


	public String getEstadoProduccion() {
		return estadoProduccion;
	}


	public void setEstadoProduccion(String estadoProduccion) {
		this.estadoProduccion = estadoProduccion;
	}


	@Override
	public String toString() {
		return "Produccion [idProduccion=" + idProduccion + ", tipoProduccion=" + tipoProduccion
				+ ", cantidadProduccion=" + cantidadProduccion + ", fechaProduccion=" + fechaProduccion
				+ ", estadoProduccion=" + estadoProduccion + "]";
	}


	
}
