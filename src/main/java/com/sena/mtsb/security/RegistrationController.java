package com.sena.mtsb.security;

import com.sena.mtsb.email.service.EmailService;
import com.sena.mtsb.model.Usuario;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Controller
public class RegistrationController {

    private final UserRepository userRepository;
    private final EmailService emailService;
    private final IntUsuarioService service; // Asegúrate de tener este servicio configurado e inyectado correctamente.


    @Autowired
    public RegistrationController(UserRepository userRepository, EmailService emailService, IntUsuarioService service) {
        this.userRepository = userRepository;
        this.emailService = emailService;
        this.service = service;
    }

    @PreAuthorize("hasRole('Admin')")
    @GetMapping("/registros")
    public String consultarVentas(Model model) {
        List<Usuario> usuarios = service.Listar();
        model.addAttribute("usuarios", usuarios);
        return "registros";
    }

    @PreAuthorize("hasRole('Admin')")
    @GetMapping("/newUsuario")
    public String agregar(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "register";
    }

    @PreAuthorize("hasRole('Admin')")
    @PostMapping("/saveUsuario")
    public String save(@ModelAttribute("usuario") @Validated Usuario usuario, BindingResult result, Model model) {
        if (result.hasErrors()) {
            // Si hay errores de validación, regresa al formulario de registro con los mensajes de error
            return "register";
        }

        // Configurar el atributo "activo" como true
        usuario.setActivo(true);

        // Guardar el usuario en la base de datos
        userRepository.save(usuario);

        // Enviar correo de registro exitoso
        emailService.sendRegistrationEmail(usuario.getCorreo());

        // Redirigir a la página de inicio de sesión u otra página apropiada
        return "redirect:/login";
    }

    @PreAuthorize("hasRole('Admin')")
    @GetMapping("/editarUsuario/{id}")
    public String editar(@PathVariable String id, Model model) {
        Optional<Usuario> usuario = service.ListarId(id);
        usuario.ifPresent(v -> model.addAttribute("usuario", v));
        return "register";
    }
}
