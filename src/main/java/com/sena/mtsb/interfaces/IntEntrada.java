package com.sena.mtsb.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sena.mtsb.model.Entrada;

@Repository
public interface IntEntrada extends CrudRepository<Entrada, String> {

	
}
