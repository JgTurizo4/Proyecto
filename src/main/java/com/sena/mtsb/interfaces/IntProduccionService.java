package com.sena.mtsb.interfaces;

import java.util.List;
import java.util.Optional;

import com.sena.mtsb.model.Produccion;

public interface IntProduccionService {
	public List<Produccion>Listar();
	public Optional<Produccion>ListarId(String id);
	public int save (Produccion p);
	public void delete(String id);
}
