package com.sena.mtsb.interfaces;

import java.util.List;
import java.util.Optional;

import com.sena.mtsb.model.Venta;

public interface IntVentaService {
	public List<Venta>Listar();
	public Optional<Venta> ListarId(String id);
    public int save(Venta p);
    public void delete(String id);
}
