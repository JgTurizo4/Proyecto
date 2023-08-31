package com.sena.mtsb.email.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
@Data
@Document(collection = "mensajes")
public class Mensaje {

    @Id
    private String id;

    private String codigo;

    private String mailRemitente;

    private String mailDestinatario;

    private String asunto;

    private String contenido;

    public Mensaje() {
    }

    public Mensaje(String id, String codigo, String mailRemitente, String mailDestinatario, String asunto, String contenido) {
        this.id = id;
        this.codigo = codigo;
        this.mailRemitente = mailRemitente;
        this.mailDestinatario = mailDestinatario;
        this.asunto = asunto;
        this.contenido = contenido;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMailRemitente() {
        return mailRemitente;
    }

    public void setMailRemitente(String mailRemitente) {
        this.mailRemitente = mailRemitente;
    }

    public String getMailDestinatario() {
        return mailDestinatario;
    }

    public void setMailDestinatario(String mailDestinatario) {
        this.mailDestinatario = mailDestinatario;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    @Override
    public String toString() {
        return "Mensaje{" +
                "id='" + id + '\'' +
                ", codigo='" + codigo + '\'' +
                ", mailRemitente='" + mailRemitente + '\'' +
                ", mailDestinatario='" + mailDestinatario + '\'' +
                ", asunto='" + asunto + '\'' +
                ", contenido='" + contenido + '\'' +
                '}';
    }
}