package com.sena.mtsb.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sena.mtsb.model.ProdRepro;

@Repository
public interface IntProdRepro extends CrudRepository<ProdRepro, String> {

}
