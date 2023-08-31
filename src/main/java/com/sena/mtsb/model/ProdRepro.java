package com.sena.mtsb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "prodRepros")
public class ProdRepro {
	
	@Id
	private String idProdRepro;
	
	
	private String nombreProdRepro;
	
	
	private String descripcionProdRepro;
	
	
	private String estadoProdRepro;


	public ProdRepro() {
		super();

	}


	public ProdRepro(String idProdRepro, String nombreProdRepro, String descripcionProdRepro, String estadoProdRepro) {
		super();
		this.idProdRepro = idProdRepro;
		this.nombreProdRepro = nombreProdRepro;
		this.descripcionProdRepro = descripcionProdRepro;
		this.estadoProdRepro = estadoProdRepro;
	}


	public String getIdProdRepro() {
		return idProdRepro;
	}


	public void setIdProdRepro(String idProdRepro) {
		this.idProdRepro = idProdRepro;
	}


	public String getNombreProdRepro() {
		return nombreProdRepro;
	}


	public void setNombreProdRepro(String nombreProdRepro) {
		this.nombreProdRepro = nombreProdRepro;
	}


	public String getDescripcionProdRepro() {
		return descripcionProdRepro;
	}


	public void setDescripcionProdRepro(String descripcionProdRepro) {
		this.descripcionProdRepro = descripcionProdRepro;
	}


	public String getEstadoProdRepro() {
		return estadoProdRepro;
	}


	public void setEstadoProdRepro(String estadoProdRepro) {
		this.estadoProdRepro = estadoProdRepro;
	}


	@Override
	public String toString() {
		return "ProdRepro [idProdRepro=" + idProdRepro + ", nombreProdRepro=" + nombreProdRepro
				+ ", descripcionProdRepro=" + descripcionProdRepro + ", estadoProdRepro=" + estadoProdRepro + "]";
	}
	
	
}
