package com.sena.mtsb.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sena.mtsb.model.Produccion;
@Repository
public interface IntProduccion extends CrudRepository<Produccion, String> {

}