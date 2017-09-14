package com.example.ites.gmail_clone;

/**
 * Created by ites on 4/9/2017.
 */

public class Mensaje {

    private int id;
    private String remitente;
    private String email;
    private String asunto;
    private String mensaje;
    private String color;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRemitente() {
        return remitente;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Mensaje(int id, String remitente, String email, String asunto, String mensaje, String color) {
        this.id=id;
        this.remitente = remitente;
        this.email = email;
        this.asunto = asunto;
        this.mensaje = mensaje;
        this.color = color;
    }
}
