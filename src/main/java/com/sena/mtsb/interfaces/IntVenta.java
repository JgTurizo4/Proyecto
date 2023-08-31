package com.sena.mtsb.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sena.mtsb.model.Venta;

@Repository
public interface IntVenta extends CrudRepository<Venta, String> {

}
