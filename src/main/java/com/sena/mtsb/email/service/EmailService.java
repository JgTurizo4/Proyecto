package com.sena.mtsb.email.service;

import com.sena.mtsb.email.repository.MensajeRepository;
import com.sena.mtsb.security.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EmailService {

    private final JavaMailSender javaMailSender;
    private final MensajeRepository mensajeRepository;
    private final UserRepository userRepository;

    @Autowired
    public EmailService(JavaMailSender javaMailSender, MensajeRepository mensajeRepository, UserRepository userRepository) {
        this.javaMailSender = javaMailSender;
        this.mensajeRepository = mensajeRepository;
        this.userRepository = userRepository;
    }

    @Value("${spring.mail.username}")
    private String fromEmail;

    public void sendRegistrationEmail(String toAddress) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toAddress);
        message.setSubject("Registro Exitoso");
        message.setText("¡Hola! Tu registro ha sido exitoso.");

        javaMailSender.send(message);
    }

    public void sendPasswordRecoveryEmail(String toEmail, String token) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromEmail);
        message.setTo(toEmail);
        message.setSubject("Recuperación de Contraseña");
        message.setText("Hola,\n\nPara recuperar tu contraseña, haz clic en el siguiente enlace: " +
                "http://localhost:8080/resetear-contrasena/" + token);

        javaMailSender.send(message);
    }


    private String generatePasswordResetToken(String userEmail) {
        // Lógica para generar un token único para el restablecimiento de contraseña
        // Aquí puedes usar alguna librería o implementar tu propio algoritmo para generar el token
        // Por ejemplo, utilizando UUID:
        return UUID.randomUUID().toString();
    }

    // Método para enviar el correo electrónico utilizando javaMailSender.send()
    private void sendEmail(String toAddress, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toAddress);
        message.setSubject(subject);
        message.setText(text);

        javaMailSender.send(message);
    }
}
