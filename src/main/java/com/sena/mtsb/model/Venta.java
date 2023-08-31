package com.sena.mtsb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Document(collection = "ventas")
public class Venta {

	@Id
	private String idVenta;
	
	private String empleadoResponsableDeLaVenta; /* Llave foranea */
	
	
	private LocalDateTime fechaVenta;
	

	private int cantidadVenta;
	

	private float precioTotalVenta;
	

	private int idenClienteVenta;
	

	private String itemVenta;


	public Venta() {
		super();
	}


	public Venta(String idVenta, String empleadoResponsableDeLaVenta, LocalDateTime fechaVenta, int cantidadVenta,
			float precioTotalVenta, int idenClienteVenta, String itemVenta) {
		super();
		this.idVenta = idVenta;
		this.empleadoResponsableDeLaVenta = empleadoResponsableDeLaVenta;
		this.fechaVenta = fechaVenta;
		this.cantidadVenta = cantidadVenta;
		this.precioTotalVenta = precioTotalVenta;
		this.idenClienteVenta = idenClienteVenta;
		this.itemVenta = itemVenta;
	}


	public String getIdVenta() {
		return idVenta;
	}


	public void setIdVenta(String idVenta) {
		this.idVenta = idVenta;
	}


	public String getEmpleadoResponsableDeLaVenta() {
		return empleadoResponsableDeLaVenta;
	}


	public void setEmpleadoResponsableDeLaVenta(String empleadoResponsableDeLaVenta) {
		this.empleadoResponsableDeLaVenta = empleadoResponsableDeLaVenta;
	}


	public LocalDateTime getFechaVenta() {
		return fechaVenta;
	}


	public void setFechaVenta(LocalDateTime fechaVenta) {
		this.fechaVenta = fechaVenta;
	}


	public int getCantidadVenta() {
		return cantidadVenta;
	}


	public void setCantidadVenta(int cantidadVenta) {
		this.cantidadVenta = cantidadVenta;
	}


	public float getPrecioTotalVenta() {
		return precioTotalVenta;
	}


	public void setPrecioTotalVenta(float precioTotalVenta) {
		this.precioTotalVenta = precioTotalVenta;
	}


	public int getIdenClienteVenta() {
		return idenClienteVenta;
	}


	public void setIdenClienteVenta(int idenClienteVenta) {
		this.idenClienteVenta = idenClienteVenta;
	}


	public String getItemVenta() {
		return itemVenta;
	}


	public void setItemVenta(String itemVenta) {
		this.itemVenta = itemVenta;
	}


	@Override
	public String toString() {
		return "Venta [idVenta=" + idVenta + ", empleadoResponsableDeLaVenta=" + empleadoResponsableDeLaVenta
				+ ", fechaVenta=" + fechaVenta + ", cantidadVenta=" + cantidadVenta + ", precioTotalVenta="
				+ precioTotalVenta + ", idenClienteVenta=" + idenClienteVenta + ", itemVenta=" + itemVenta + "]";
	}


	
}