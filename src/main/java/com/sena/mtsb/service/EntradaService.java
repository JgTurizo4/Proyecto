package com.sena.mtsb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.mtsb.interfaces.IntEntrada;
import com.sena.mtsb.interfaces.IntEntradaService;
import com.sena.mtsb.model.Entrada;

@Service
public class EntradaService implements IntEntradaService {

	@Autowired
	private IntEntrada data;
	
	@Override
	public List<Entrada> Listar() {
		return (List<Entrada>)data.findAll();
	}

	@Override
	public Optional<Entrada> ListarId(String id) {
		return data.findById(id);
	}

	@Override
	public int save(Entrada p) {
		int res=0;
		Entrada entrada=data.save(p);
		if(entrada.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void delete(String id) {
		data.deleteById(id);
		
	}
}
