package com.sena.mtsb.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sena.mtsb.model.Orden;

@Repository
public interface IntOrden extends CrudRepository<Orden, String> {

 
}