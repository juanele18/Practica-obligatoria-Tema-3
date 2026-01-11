package models;

import java.time.LocalDate;

public class Compra {
    //Atributos
    private double precioFinal;
    private String emailVendedor;
    private double puntuacion;
    private String comentario;
    private LocalDate fecha;


    //Creamos el constructor

    public Compra(double puntuacion, int precioFinal, LocalDate fecha, String emailVendedor, String comentario) {
        this.puntuacion = puntuacion;
        this.precioFinal = precioFinal;
        this.fecha = fecha;
        this.emailVendedor = emailVendedor;
        this.comentario = comentario;
    }

    //creamos los getters y lo setters

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getEmailVendedor() {
        return emailVendedor;
    }

    public void setEmailVendedor(String emailVendedor) {
        this.emailVendedor = emailVendedor;
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

    // Dentro de models/Compra.java
    @Override
    public String toString() {
        return "🛒 --- DETALLE DE COMPRA --- 🛒\n" +
                "💰 Precio pagado: $" + precioFinal + "\n" +
                "📧 Vendedor: " + emailVendedor + "\n" +
                "⭐ Puntuación otorgada: " + puntuacion + "/5\n" +
                "💬 Comentario: \"" + comentario + "\"\n" +
                "📅 Fecha: " + fecha + "\n" +
                "**********************************************";
    }

}
