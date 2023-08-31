package com.sena.mtsb.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {

    @GetMapping("/acceso-denegado")
    public String accesoDenegado() {
        return "acceso-denegado"; // Nombre de la vista de error personalizada (puede ser una página JSP, Thymeleaf, etc.)
    }
}