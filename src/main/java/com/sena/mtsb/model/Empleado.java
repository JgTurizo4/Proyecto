package com.sena.mtsb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "empleados")
public class Empleado {

	@Id
	private String idEmpleado;
	private String areaAcargo;
	
	public Empleado() {
		super();

	}

	public Empleado(String idEmpleado, String areaAcargo) {
		super();
		this.idEmpleado = idEmpleado;
		this.areaAcargo = areaAcargo;
	}

	public String getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(String idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getAreaAcargo() {
		return areaAcargo;
	}

	public void setAreaAcargo(String areaAcargo) {
		this.areaAcargo = areaAcargo;
	}

	@Override
	public String toString() {
		return "Empleado [idEmpleado=" + idEmpleado + ", areaAcargo=" + areaAcargo + "]";
	}
	
	
	
}
