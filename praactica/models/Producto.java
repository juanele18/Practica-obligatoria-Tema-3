package models;

public class Producto {
    //Atributos
    private String nombre;
    private String descripcion;
    private boolean enVenta;
    private double precio;
    private String emailVendedor;

    public Producto(String descripcion, String emailVendedor, boolean enVenta, String nombre, double precio) {
        this.descripcion = descripcion;
        this.emailVendedor = emailVendedor;
        this.enVenta = enVenta;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Producto(){

    }


    //getters and setters

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEmailVendedor() {
        return emailVendedor;
    }

    public void setEmailVendedor(String emailVendedor) {
        this.emailVendedor = emailVendedor;
    }

    public boolean isEnVenta() {
        return enVenta;
    }

    public void setEnVenta(boolean enVenta) {
        this.enVenta = enVenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    //hacemos el to String
    public void quitarLaVenta(){
        enVenta = false;

    }

    public String toString() {
        return (enVenta) ? "🛍️ Producto en exhibición 🛍️\n" +
                "📛 Nombre: " + nombre + "\n" +
                "📝 Descripción: " + descripcion + "\n" +
                "💰 Precio: $" + precio + "\n" +
                "📧 Vendedor: " + emailVendedor + "\n" +
                "✨ ¡Gracias por mirar este producto! ✨" : " ";
        }


}
