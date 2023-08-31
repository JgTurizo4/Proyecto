package com.sena.mtsb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.mtsb.interfaces.IntProduccion;
import com.sena.mtsb.interfaces.IntProduccionService;
import com.sena.mtsb.model.Produccion;

@Service
public class ProduccionService implements IntProduccionService {

	@Autowired
	private IntProduccion data;
	
	@Override
	public List<Produccion> Listar() {
		return (List<Produccion>)data.findAll();
	}

	@Override
	public Optional<Produccion> ListarId(String id) {
		return data.findById(id);
	}

	@Override
	public int save(Produccion p) {
		int res=0;
		Produccion produccion=data.save(p);
		if(produccion.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void delete(String id) {
		data.deleteById(id);
	}

}
