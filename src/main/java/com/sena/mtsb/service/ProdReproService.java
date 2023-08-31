package com.sena.mtsb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.mtsb.interfaces.IntProdReproService;
import com.sena.mtsb.interfaces.IntProdRepro;
import com.sena.mtsb.model.ProdRepro;

@Service
public class ProdReproService implements IntProdReproService {

	@Autowired
	private IntProdRepro data;
	
	@Override
	public List<ProdRepro> Listar() {
		return (List<ProdRepro>)data.findAll();
	}

	@Override
	public Optional<ProdRepro> ListarId(String id) {
		return data.findById(id);
	}

	@Override
	public int save(ProdRepro p) {
		int res=0;
		ProdRepro prodRepro=data.save(p);
		if(prodRepro.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void delete(String id) {
		data.deleteById(id);
	}

}
