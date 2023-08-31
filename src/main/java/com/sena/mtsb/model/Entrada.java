package com.sena.mtsb.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "entradas")
public class Entrada {
	
	@Id
	private String idEntrada;
	
	
	private String recibeEntrada;
	
	
	private String nombreItemEntrada;
	
	
	private int cantidadEntrada;
	
	
	private float unidadMedidaItemEntrada;
	
	
	private int cedulaProvEntrada;
	
	
	private LocalDateTime fechaEntrada;


	public Entrada() {
		super();
	}


	public Entrada(String idEntrada, String recibeEntrada, String nombreItemEntrada, int cantidadEntrada,
			float unidadMedidaItemEntrada, int cedulaProvEntrada, LocalDateTime fechaEntrada) {
		super();
		this.idEntrada = idEntrada;
		this.recibeEntrada = recibeEntrada;
		this.nombreItemEntrada = nombreItemEntrada;
		this.cantidadEntrada = cantidadEntrada;
		this.unidadMedidaItemEntrada = unidadMedidaItemEntrada;
		this.cedulaProvEntrada = cedulaProvEntrada;
		this.fechaEntrada = fechaEntrada;
	}


	public String getIdEntrada() {
		return idEntrada;
	}


	public void setIdEntrada(String idEntrada) {
		this.idEntrada = idEntrada;
	}


	public String getRecibeEntrada() {
		return recibeEntrada;
	}


	public void setRecibeEntrada(String recibeEntrada) {
		this.recibeEntrada = recibeEntrada;
	}


	public String getNombreItemEntrada() {
		return nombreItemEntrada;
	}


	public void setNombreItemEntrada(String nombreItemEntrada) {
		this.nombreItemEntrada = nombreItemEntrada;
	}


	public int getCantidadEntrada() {
		return cantidadEntrada;
	}


	public void setCantidadEntrada(int cantidadEntrada) {
		this.cantidadEntrada = cantidadEntrada;
	}


	public float getUnidadMedidaItemEntrada() {
		return unidadMedidaItemEntrada;
	}


	public void setUnidadMedidaItemEntrada(float unidadMedidaItemEntrada) {
		this.unidadMedidaItemEntrada = unidadMedidaItemEntrada;
	}


	public int getCedulaProvEntrada() {
		return cedulaProvEntrada;
	}


	public void setCedulaProvEntrada(int cedulaProvEntrada) {
		this.cedulaProvEntrada = cedulaProvEntrada;
	}


	public LocalDateTime getFechaEntrada() {
		return fechaEntrada;
	}


	public void setFechaEntrada(LocalDateTime fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}


	@Override
	public String toString() {
		return "Entrada [idEntrada=" + idEntrada + ", recibeEntrada=" + recibeEntrada + ", nombreItemEntrada="
				+ nombreItemEntrada + ", cantidadEntrada=" + cantidadEntrada + ", unidadMedidaItemEntrada="
				+ unidadMedidaItemEntrada + ", cedulaProvEntrada=" + cedulaProvEntrada + ", fechaEntrada="
				+ fechaEntrada + "]";
	}
	
	
}
