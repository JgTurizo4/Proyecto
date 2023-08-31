package com.sena.mtsb.interfaces;

import java.util.List;
import java.util.Optional;

import com.sena.mtsb.model.Entrada;

public interface IntEntradaService {
	public List<Entrada>Listar();
	public Optional<Entrada>ListarId(String id);
	public int save (Entrada p);
	public void delete(String id);
}
