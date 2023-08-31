package com.sena.mtsb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.mtsb.interfaces.IntProducto;
import com.sena.mtsb.interfaces.IntProductoService;
import com.sena.mtsb.model.Producto;

@Service
public class ProductoService implements IntProductoService {

	@Autowired
	private IntProducto data;
	
	@Override
	public List<Producto> Listar() {
		return (List<Producto>)data.findAll();
	}

	@Override
	public Optional<Producto> ListarId(String id) {
		return data.findById(id);
	}

	@Override
	public int save(Producto p) {
		int res=0;
		Producto producto=data.save(p);
		if(producto.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void delete(String id) {
		data.deleteById(id);
	}

}