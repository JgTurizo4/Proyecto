package com.sena.mtsb.email.controller;

import com.sena.mtsb.email.service.EmailService;
import com.sena.mtsb.model.Usuario;
import com.sena.mtsb.security.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.UUID;

@RequestMapping
@Controller
public class PasswordRecoveryController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;
    private final EmailService emailService;

    @Autowired
    public PasswordRecoveryController(UserRepository userRepository, EmailService emailService) {
        this.userRepository = userRepository;
        this.emailService = emailService;
    }

    @GetMapping("/recuperar-contrasena")
    public String showPasswordRecoveryForm() {
        return "recuperar-contrasena";
    }

    @PostMapping("/recuperar-contrasena")
    public String processPasswordRecoveryForm(@RequestParam("correo") String correo, Model model) {
        Usuario usuario = userRepository.findByCorreo(correo);
        if (usuario != null) {
            // Generar un código único para la recuperación de contraseña
            String codigoRecuperacion = generateUniqueCode();

            // Guardar el código de recuperación en el usuario
            usuario.setRecoveryToken(codigoRecuperacion);
            usuario.setRecoveryTokenExpiration(LocalDateTime.now().plusMinutes(10)); // Token válido por 24 horas
            userRepository.save(usuario);

            // Enviar el correo de recuperación de contraseña con el enlace que contiene el código único
            emailService.sendPasswordRecoveryEmail(correo, codigoRecuperacion);

            model.addAttribute("mensaje", "Se ha enviado un correo de recuperación de contraseña a " + correo);
        } else {
            model.addAttribute("error", "El correo electrónico no está registrado en nuestro sistema");
        }

        return "login";
    }

    @GetMapping("/resetear-contrasena/{codigo}")
    public String showPasswordResetForm(@PathVariable String codigo, Model model) {
        Usuario usuario = userRepository.findByRecoveryToken(codigo);

        if (usuario != null) {
            model.addAttribute("codigoRecuperacion", codigo);
            return "resetear-contrasena";
        } else {
            model.addAttribute("error", "El enlace de recuperación de contraseña no es válido");
            return "recuperar-contrasena";
        }
    }

    @PostMapping("/resetear-contrasena/{codigoRecuperacion}")
    public String processPasswordResetForm(@PathVariable("codigoRecuperacion") String codigo,
                                           @RequestParam("nuevaContrasena") String nuevaContrasena,
                                           @RequestParam("confirmarContrasena") String confirmarContrasena,
                                           Model model) {
        Usuario usuario = userRepository.findByRecoveryToken(codigo);

        if (usuario != null && nuevaContrasena.equals(confirmarContrasena)) {
            // Verificar si el token de recuperación ha expirado
            LocalDateTime now = LocalDateTime.now();
            if (usuario.getRecoveryTokenExpiration().isBefore(now)) {
                // El token ha expirado
                model.addAttribute("error", "El enlace de recuperación de contraseña ha expirado. Por favor, solicita uno nuevo.");
                return "recuperar-contrasena";
            }

            usuario.setPassword(passwordEncoder.encode(nuevaContrasena));
            usuario.setRecoveryToken(null);
            usuario.setRecoveryTokenExpiration(null);
            userRepository.save(usuario);

            model.addAttribute("mensaje", "La contraseña se ha reseteado exitosamente");
            return "login"; // Redirigir al login después de cambiar la contraseña exitosamente
        } else {
            model.addAttribute("error", "El enlace de recuperación de contraseña no es válido o las contraseñas no coinciden");
            return "resetear-contrasena";
        }
    }

    // Método para generar un código único para recuperación de contraseña
    private String generateUniqueCode() {
        // Lógica para generar un código único para recuperación de contraseña
        // Por ejemplo, puedes utilizar alguna librería o implementar tu propio algoritmo para generar el código
        // En este caso, usaremos UUID para generar el código único
        return UUID.randomUUID().toString();
    }
}

