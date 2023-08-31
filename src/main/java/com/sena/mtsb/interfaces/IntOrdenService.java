package com.sena.mtsb.interfaces;

import java.util.List;
import java.util.Optional;

import com.sena.mtsb.model.Orden;

public interface IntOrdenService {

	public List<Orden>Listar();
	public Optional<Orden>ListarId(String id);
	public int save (Orden p);
	public void delete(String id);
}
