package com.sena.mtsb.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Document(collection = "usuarios")
public class Usuario {
	
	@Id
	private String idUsuario;
	
	private String nombreUsuario;
	
	private String apellidoUsuario;
	
	private String tipoIdentificacionUsuario;
	
	private int numeroIdentificacionUsuario;
	
	private String numeroTell;

	private String username;
	
	private String password;
	
	private String correo;
	
	private String recoveryToken;
	
    private LocalDateTime recoveryTokenExpiration;

	private boolean activo;

	private List<String> rolesAsignados;

	// Define los roles disponibles como una lista fija en el modelo
	private List<String> rolesDisponibles = Arrays.asList("ROLE_Admin", "ROLE_Empleado");

	public Usuario() {
		super();
	}

	public Usuario(String idUsuario, String nombreUsuario, String apellidoUsuario, String tipoIdentificacionUsuario,
			int numeroIdentificacionUsuario, String numeroTell, String username, String password, String correo,
			String recoveryToken, LocalDateTime recoveryTokenExpiration, boolean activo, List<String> rolesAsignados,
			List<String> rolesDisponibles) {
		super();
		this.idUsuario = idUsuario;
		this.nombreUsuario = nombreUsuario;
		this.apellidoUsuario = apellidoUsuario;
		this.tipoIdentificacionUsuario = tipoIdentificacionUsuario;
		this.numeroIdentificacionUsuario = numeroIdentificacionUsuario;
		this.numeroTell = numeroTell;
		this.username = username;
		this.password = password;
		this.correo = correo;
		this.recoveryToken = recoveryToken;
		this.recoveryTokenExpiration = recoveryTokenExpiration;
		this.activo = activo;
		this.rolesAsignados = rolesAsignados;
		this.rolesDisponibles = rolesDisponibles;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getApellidoUsuario() {
		return apellidoUsuario;
	}

	public void setApellidoUsuario(String apellidoUsuario) {
		this.apellidoUsuario = apellidoUsuario;
	}

	public String getTipoIdentificacionUsuario() {
		return tipoIdentificacionUsuario;
	}

	public void setTipoIdentificacionUsuario(String tipoIdentificacionUsuario) {
		this.tipoIdentificacionUsuario = tipoIdentificacionUsuario;
	}

	public int getNumeroIdentificacionUsuario() {
		return numeroIdentificacionUsuario;
	}

	public void setNumeroIdentificacionUsuario(int numeroIdentificacionUsuario) {
		this.numeroIdentificacionUsuario = numeroIdentificacionUsuario;
	}

	public String getNumeroTell() {
		return numeroTell;
	}

	public void setNumeroTell(String numeroTell) {
		this.numeroTell = numeroTell;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getRecoveryToken() {
		return recoveryToken;
	}

	public void setRecoveryToken(String recoveryToken) {
		this.recoveryToken = recoveryToken;
	}

	public LocalDateTime getRecoveryTokenExpiration() {
		return recoveryTokenExpiration;
	}

	public void setRecoveryTokenExpiration(LocalDateTime recoveryTokenExpiration) {
		this.recoveryTokenExpiration = recoveryTokenExpiration;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public List<String> getRolesAsignados() {
		return rolesAsignados;
	}

	public void setRolesAsignados(List<String> rolesAsignados) {
		this.rolesAsignados = rolesAsignados;
	}

	public List<String> getRolesDisponibles() {
		return rolesDisponibles;
	}

	public void setRolesDisponibles(List<String> rolesDisponibles) {
		this.rolesDisponibles = rolesDisponibles;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombreUsuario=" + nombreUsuario + ", apellidoUsuario="
				+ apellidoUsuario + ", tipoIdentificacionUsuario=" + tipoIdentificacionUsuario
				+ ", numeroIdentificacionUsuario=" + numeroIdentificacionUsuario + ", numeroTell=" + numeroTell
				+ ", username=" + username + ", password=" + password + ", correo=" + correo + ", recoveryToken="
				+ recoveryToken + ", recoveryTokenExpiration=" + recoveryTokenExpiration + ", activo=" + activo
				+ ", rolesAsignados=" + rolesAsignados + ", rolesDisponibles=" + rolesDisponibles + "]";
	}

	
}
