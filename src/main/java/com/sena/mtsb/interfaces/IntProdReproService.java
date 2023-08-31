package com.sena.mtsb.interfaces;

import java.util.List;
import java.util.Optional;

import com.sena.mtsb.model.ProdRepro;

public interface IntProdReproService {
	public List<ProdRepro>Listar();
	public Optional<ProdRepro>ListarId(String id);
	public int save (ProdRepro p);
	public void delete(String id);
}
