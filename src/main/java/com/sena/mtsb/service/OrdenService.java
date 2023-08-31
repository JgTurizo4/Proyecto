package com.sena.mtsb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.mtsb.interfaces.IntOrden;
import com.sena.mtsb.interfaces.IntOrdenService;
import com.sena.mtsb.model.Orden;

@Service
public class OrdenService implements IntOrdenService {

	@Autowired
	private IntOrden data;
	
	@Override
	public List<Orden> Listar() {
		return (List<Orden>)data.findAll();
	}

	@Override
	public Optional<Orden> ListarId(String id) {
		return data.findById(id);
	}

	@Override
	public int save(Orden p) {
		int res=0;
		Orden orden=data.save(p);
		if(orden.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}
}
