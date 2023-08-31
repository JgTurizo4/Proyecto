package com.sena.mtsb.security;

import com.sena.mtsb.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface IntUsuarioService {

    public List<Usuario> Listar();
    public Optional<Usuario> ListarId(String id);
    public int save (Usuario p);
    public void delete(Usuario id);
}
