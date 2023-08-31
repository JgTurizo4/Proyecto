package com.sena.mtsb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "proveedores")
public class Proveedor {

	@Id
	private String idProveedor;
	
	
	private String nombreProveedor;
	
	
	private int cedulaProveedor;


	public Proveedor() {
		super();

	}


	public Proveedor(String idProveedor, String nombreProveedor, int cedulaProveedor) {
		super();
		this.idProveedor = idProveedor;
		this.nombreProveedor = nombreProveedor;
		this.cedulaProveedor = cedulaProveedor;
	}


	public String getIdProveedor() {
		return idProveedor;
	}


	public void setIdProveedor(String idProveedor) {
		this.idProveedor = idProveedor;
	}


	public String getNombreProveedor() {
		return nombreProveedor;
	}


	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}


	public int getCedulaProveedor() {
		return cedulaProveedor;
	}


	public void setCedulaProveedor(int cedulaProveedor) {
		this.cedulaProveedor = cedulaProveedor;
	}


	@Override
	public String toString() {
		return "Proveedor [idProveedor=" + idProveedor + ", nombreProveedor=" + nombreProveedor + ", cedulaProveedor="
				+ cedulaProveedor + "]";
	}


	
}
