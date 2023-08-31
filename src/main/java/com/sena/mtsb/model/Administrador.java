package com.sena.mtsb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "administradores")
public class Administrador {

	@Id
	private String idAdministrador;
	private String nombreAdministrador;
	
	public Administrador() {
		super();

	}

	public Administrador(String idAdministrador, String nombreAdministrador) {
		super();
		this.idAdministrador = idAdministrador;
		this.nombreAdministrador = nombreAdministrador;
	}

	public String getIdAdministrador() {
		return idAdministrador;
	}

	public void setIdAdministrador(String idAdministrador) {
		this.idAdministrador = idAdministrador;
	}

	public String getNombreAdministrador() {
		return nombreAdministrador;
	}

	public void setNombreAdministrador(String nombreAdministrador) {
		this.nombreAdministrador = nombreAdministrador;
	}

	@Override
	public String toString() {
		return "Administrador [idAdministrador=" + idAdministrador + ", nombreAdministrador=" + nombreAdministrador
				+ "]";
	}
	
	
}
