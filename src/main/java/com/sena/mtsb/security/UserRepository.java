package com.sena.mtsb.security;

import com.sena.mtsb.model.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Usuario, String> {

    Usuario findByUsername(String username);

    Usuario findByCorreo(String correo);

    Usuario findByRecoveryToken(String recoveryToken);
}
