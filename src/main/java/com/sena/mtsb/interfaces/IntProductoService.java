package com.sena.mtsb.interfaces;

import java.util.List;
import java.util.Optional;

import com.sena.mtsb.model.Producto;

public interface IntProductoService {
	public List<Producto>Listar();
	public Optional<Producto>ListarId(String id);
	public int save (Producto p);
	public void delete(String id);
}
