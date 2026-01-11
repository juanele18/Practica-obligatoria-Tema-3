package models;

import java.time.LocalDate;

public class Venta {
    //atributos
    private double precioFinal;
    private String emailComprador;
    private double puntuacion;
    private String comentario;
    private LocalDate fecha;

    //Creamos el constructor

    public Venta(String comentario, String emailComprador, LocalDate fecha, double precioFinal, double puntuacion) {
        this.comentario = comentario;
        this.emailComprador = emailComprador;
        this.fecha = fecha;
        this.precioFinal = precioFinal;
        this.puntuacion = puntuacion;
    }

    //Creamos los getters y los setters

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getEmailComprador() {
        return emailComprador;
    }

    public void setEmailComprador(String emailComprador) {
        this.emailComprador = emailComprador;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(int precioFinal) {
        this.precioFinal = precioFinal;
    }

    public double getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(double puntuacion) {
        this.puntuacion = puntuacion;
    }

    @Override
    public String toString() {
        return  "💰 Precio final: $" + precioFinal + "\n" +
                "📧 Comprador: " + emailComprador + "\n" +
                "⭐ Puntuación: " + puntuacion + "/5\n" +
                "💬 Comentario: \"" + comentario + "\"\n" +
                "📅 Fecha de la venta: " + fecha + "\n" +
                "**********************************************";
    }



}
