package com.sena.mtsb.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ordenes")
public class Orden {

	@Id
	private String idOrden;
	
	
	private String solicitudOrden;
	
	
	private LocalDateTime fechaOrden;
	
	
	private String productoOrden;
	
	
	private int cantidadOrden;
	
	
	private String proveedorOrden;


	public Orden() {
		super();
	}


	public Orden(String idOrden, String solicitudOrden, LocalDateTime fechaOrden, String productoOrden,
			int cantidadOrden, String proveedorOrden) {
		super();
		this.idOrden = idOrden;
		this.solicitudOrden = solicitudOrden;
		this.fechaOrden = fechaOrden;
		this.productoOrden = productoOrden;
		this.cantidadOrden = cantidadOrden;
		this.proveedorOrden = proveedorOrden;
	}


	public String getIdOrden() {
		return idOrden;
	}


	public void setIdOrden(String idOrden) {
		this.idOrden = idOrden;
	}


	public String getSolicitudOrden() {
		return solicitudOrden;
	}


	public void setSolicitudOrden(String solicitudOrden) {
		this.solicitudOrden = solicitudOrden;
	}


	public LocalDateTime getFechaOrden() {
		return fechaOrden;
	}


	public void setFechaOrden(LocalDateTime fechaOrden) {
		this.fechaOrden = fechaOrden;
	}


	public String getProductoOrden() {
		return productoOrden;
	}


	public void setProductoOrden(String productoOrden) {
		this.productoOrden = productoOrden;
	}


	public int getCantidadOrden() {
		return cantidadOrden;
	}


	public void setCantidadOrden(int cantidadOrden) {
		this.cantidadOrden = cantidadOrden;
	}


	public String getProveedorOrden() {
		return proveedorOrden;
	}


	public void setProveedorOrden(String proveedorOrden) {
		this.proveedorOrden = proveedorOrden;
	}


	@Override
	public String toString() {
		return "Orden [idOrden=" + idOrden + ", solicitudOrden=" + solicitudOrden + ", fechaOrden=" + fechaOrden
				+ ", productoOrden=" + productoOrden + ", cantidadOrden=" + cantidadOrden + ", proveedorOrden="
				+ proveedorOrden + "]";
	}
	
	
}