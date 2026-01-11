package models;

import java.util.random.RandomGenerator;

public class Usuario {

    //Atributos
    private String email;
    private String clave;
    private String nombre;
    private String apellidos;
    private String calle;
    private int ventas;
    private int compras;
    private Producto productoEnVenta1;
    private Producto productoEnVenta2;
    private Venta historicoVenta;
    private Compra historicoCompra;

    //Constructor


    public Usuario(String nombre, String apellidos, String calle, String email,String clave) {
        this.apellidos = apellidos;
        this.calle = calle;
        this.email = email;
        this.nombre = nombre;
        ventas = 0;
        compras = 0;
        this.clave = clave;
    }

    //getters and setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    //Creamos los métodos
    public boolean login(String correo, String clve){
        return (correo.equals(email) && clve.equals(clave));
    }

    //Metodo para poner los prductos en venta
    public boolean ponerProductoEnVenta(Producto p){
       if (productoEnVenta1 == null ){
           productoEnVenta1 = p;
           return true;
       }
       if (productoEnVenta2 == null){
           productoEnVenta2 = p;
           return true;
       }
       return false;
    }

    public String verProductoEnVenta(){
        String resultado= " ";
        if (productoEnVenta1 != null) resultado += productoEnVenta1.toString() + "\n";
        resultado += "====================================================";
        if (productoEnVenta2 != null) System.out.println(productoEnVenta2.toString() + "\n");
        return resultado;
    }

//    //Metodo para realizar la venta de un producto

    public boolean realizarVenta(String nombre, String emailComprador, double puntuacion, String comentario) {

        // 1. COMPROBACIÓN DE LÍMITE:
        if (this.ventas >= 1) {
            return false;
        }

        Producto productoVendido = null;

        // 2. BUSCAMOS EL PRODUCTO (Guardamos la referencia ANTES de borrarla)
        if (productoEnVenta1 != null && productoEnVenta1.getNombre().equalsIgnoreCase(nombre)) {
            productoVendido = productoEnVenta1;
            productoEnVenta1 = null;
        }
        else if (productoEnVenta2 != null && productoEnVenta2.getNombre().equalsIgnoreCase(nombre)) {
            productoVendido = productoEnVenta2;
            productoEnVenta2 = null;
        }

        // 3. SI ENCONTRAMOS EL PRODUCTO, CREAMOS EL HISTÓRICO
        if (productoVendido != null) {
            this.ventas++;

            // Creamos el objeto histórico con los datos del producto que acabamos de "sacar"
            this.historicoVenta = new Venta(
                    comentario,
                    emailComprador,
                    java.time.LocalDate.now(),
                    (int) productoVendido.getPrecio(),
                    puntuacion
            );

            return true; // Éxito: Se encontró, se borró y se registró
        }

        // 4. SI LLEGAMOS AQUÍ, ES QUE EL PRODUCTO NO SE ENCONTRÓ
        return false;
    }

    //hacemos el metodo para quitar un producto de la venta
    public boolean quitarProducto(String nombre) {

        // 1. BUSCAMOS EL PRODUCTO EN EL HUECO 1
        if (productoEnVenta1 != null && productoEnVenta1.getNombre().equalsIgnoreCase(nombre)) {
            productoEnVenta1 = null; // Lo sacamos de la venta
            return true;
        }

        // 2. SI NO ESTABA EN EL 1, BUSCAMOS EN EL HUECO 2
        if (productoEnVenta2 != null && productoEnVenta2.getNombre().equalsIgnoreCase(nombre)) {
            productoEnVenta2 = null; // Lo sacamos de la venta
            return true;
        }

        // 3. SI LLEGAMOS AQUÍ, ES QUE EL PRODUCTO NO SE ENCONTRÓ
        return false;
    }

    // Dentro de models/Usuario.java

    public void registrarCompra(double precio, String emailVendedor, double puntuacion, String comentario) {
        // Verificamos si ya tiene una compra (límite de 1)
        if (this.compras < 1) {
            this.historicoCompra = new Compra(
                    puntuacion,
                    (int) precio,
                    java.time.LocalDate.now(),
                    emailVendedor,
                    comentario
            );
            this.compras++; // Incrementamos el contador
        } else {
            System.out.println("Error: No se puede registrar más de 1 compra en el histórico."); //
        }
    }

    // Método para obtener el texto del histórico de ventas
    public String verHistoricoVentas() {
        if (historicoVenta == null) {
            return "Aún no has realizado ninguna venta.";
        }
        return "📜 HISTÓRICO DE VENTAS:\n" + historicoVenta.toString();
    }

    // Método para obtener el texto del histórico de compras
    public String verHistoricoCompras() {
        if (historicoCompra == null) {
            return "Aún no has realizado ninguna compra.";
        }
        return "🛍️ HISTÓRICO DE COMPRAS:\n" + historicoCompra.toString();
    }


    @Override
    public String toString() {
        return "👤 Usuario {" +
                "\n  🏷️ Nombre: " + nombre +
                "\n  🧾 Apellidos: " + apellidos +
                "\n  🏠 Calle: " + calle +
                "\n  📧 Email: " + email +
                "\n  🔒 Clave: " + clave +
                "\n  💰 Ventas realizadas: " + ventas +
                "\n  🛒 Compras realizadas: " + compras +
                "\n}";
    }

}
