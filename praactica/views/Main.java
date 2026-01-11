package views;

import models.Producto;
import models.Usuario;
import utils.Utils;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int op = 0;
        boolean usu1 = false, usu2= false, login = false, salir = false;
        Usuario usuario1, usuario2;
        String nombre, apellidos, calle, clavee, emaill, descripcion, emailVendedor, nombreVenta, emailComprador, comentario;
        Producto producto = new Producto();
        double precio, puntuacion;

        usuario1 = new Usuario("Ángel", "Miranda", "Calle padre alejandro recio", "usuario1@gmail.com", "1234");
        usuario2 = new Usuario("Carlos", "Barroso", "Calle padre alejandro recio", "usuario2@gmail.com", "12345");

        do {
            System.out.println("""
                        Bienvenido al programa de fernanPop
                        Compra y vende tus articulos en nuestro Centro
                        Quieres registrarte (1) o salir (2):
                        =====================================================""");
            op = Integer.parseInt(sc.nextLine());
            switch (op){
                case 1:
                    do {
                        System.out.print("Introduzca su email: ");
                        String email = sc.nextLine();
                        System.out.print("Introduzca su clave: ");
                        String clave = sc.nextLine();
                        if (usuario1.login(email, clave)) {
                            usu1 = true;
                            login = true;
                            System.out.println("Bienvenido " + usuario1.getNombre());
                            break;
                        }
                        if (usuario2.login(email, clave)) {
                            usu2 = true;
                            login = true;
                            System.out.println("Bienvenido " + usuario2.getNombre());
                            break;
                        }

                        System.out.println("Lo siento el correo o la clave introducidas no son correctos\nPor favor vuelve a intentarlo...");
                        Utils.pulsaParaContinuar();
                        Utils.limpiaPatallas();


                    } while (!login);
                    break;
                case 2:
                    salir = true;
                    break;
                default:
                    System.out.println("Lo siento el numero introducido es incorrecto...");
            }
            if (salir) break;

            Utils.pulsaParaContinuar();
            Utils.limpiaPatallas();

            do {
                System.out.println("""
                        ****************************************************************
                                                Menú de usuario
                        1.Mostrar mi perfil de usuario
                        2.Cambiar mis datos personales
                        3.Ver mis productos en venta
                        4.Cerrar la venta de un producto o quitarlo de la venta
                        5.Poner a la venta un nuevo producto
                        6.Ver todos los productos en venta de la aplicación
                        7.Ver mi histórico de ventas
                        8.Ver mi histórico de compras
                        9.Salir de usuario
                        Introduzca la opción deseada:\s""");
                op = Integer.parseInt(sc.nextLine());
                Utils.limpiaPatallas();
                switch (op) {
                    case 1:
                        if (usu1) System.out.println(usuario1.toString());
                        if (usu2) System.out.println(usuario2.toString());
                        Utils.pulsaParaContinuar();
                        Utils.limpiaPatallas();
                        break;
                    case 2:
                        if (usu1) {
                            Utils.menuCambiaDatos();
                            op = Integer.parseInt(sc.nextLine());
                            switch (op) {
                                case 1:
                                    System.out.println("Dime el nombre nuevo: ");
                                    nombre = sc.nextLine();
                                    usuario1.setNombre(nombre);
                                    break;
                                case 2:
                                    System.out.println("Dime el apellido nuevo: ");
                                    apellidos = sc.nextLine();
                                    usuario1.setApellidos(apellidos);
                                    break;
                                case 3:
                                    System.out.println("Dime la calle nueva: ");
                                    calle = sc.nextLine();
                                    usuario1.setCalle(calle);
                                    break;
                                case 4:
                                    System.out.println("Dime el email nuevo: ");
                                    emaill = sc.nextLine();
                                    usuario1.setEmail(emaill);
                                    break;
                                case 5:
                                    System.out.println("Dimela clave nueva: ");
                                    clavee = sc.nextLine();
                                    usuario1.setClave(clavee);
                                    break;

                            }
                        }
                        if (usu2) {
                            Utils.menuCambiaDatos();
                            op = Integer.parseInt(sc.nextLine());
                            switch (op) {
                                case 1:
                                    System.out.println("Dime el nombre nuevo: ");
                                    nombre = sc.nextLine();
                                    usuario2.setNombre(nombre);
                                    break;
                                case 2:
                                    System.out.println("Dime el apellido nuevo: ");
                                    apellidos = sc.nextLine();
                                    usuario2.setApellidos(apellidos);
                                    break;
                                case 3:
                                    System.out.println("Dime la calle nueva: ");
                                    calle = sc.nextLine();
                                    usuario2.setCalle(calle);
                                    break;
                                case 4:
                                    System.out.println("Dime el email nuevo: ");
                                    emaill = sc.nextLine();
                                    usuario2.setEmail(emaill);
                                    break;
                                case 5:
                                    System.out.println("Dimela clave nueva: ");
                                    clavee = sc.nextLine();
                                    usuario2.setClave(clavee);
                                    break;

                            }
                        }

                        break;
                    case 3:
                        if (usu1) System.out.println(usuario1.verProductoEnVenta());
                        if (usu2) System.out.println(usuario2.verProductoEnVenta());
                        Utils.pulsaParaContinuar();
                        Utils.limpiaPatallas();
                        break;
                    case 4:
                        if (usu1) {
                            System.out.println("Quieres quitar un producto de la venta (1) o venderlo (2): ");
                            op = Integer.parseInt(sc.nextLine());
                            switch (op) {
                                case 1:
                                    System.out.printf("Que producto quieres eliminar: \n %s", usuario1.verProductoEnVenta() + "\n");
                                    nombre = sc.nextLine();
                                    System.out.println(usuario1.quitarProducto(nombre) ? "Has eliminado el producto corrrectamente" : "EL producto no se ha podido eliminar");
                                    break;
                                case 2:
                                    System.out.printf("Que producto quieres vender: \n %s", usuario1.verProductoEnVenta() + "\n");
                                    nombre = sc.nextLine();
                                    System.out.print("Dime la descripcion del producto en venta: ");
                                    descripcion = sc.nextLine();
                                    System.out.print("Dime el email del comprador: ");
                                    emailComprador = sc.nextLine();
                                    System.out.print("Dime el precio al que lo vas a poner: ");
                                    precio = Double.parseDouble(sc.nextLine());
                                    System.out.print("Dime la puntuacion del producto: ");
                                    puntuacion = Double.parseDouble(sc.nextLine());
                                    System.out.print("Dime el comentario: ");
                                    comentario = sc.nextLine();
                                    usuario2.registrarCompra(precio, usuario1.getEmail(), puntuacion, comentario);


                                    System.out.println(usuario1.realizarVenta(nombre, emailComprador, puntuacion, comentario) ? "EL producto se ha vendido correctamente" : "No se ha podido vender el producto");
                                    break;
                            }
                        }
                        if (usu2) {
                            System.out.println("Quieres quitar un producto de la venta (1) o venderlo (2): ");
                            op = Integer.parseInt(sc.nextLine());
                            switch (op) {
                                case 1:
                                    System.out.printf("Que producto quieres eliminar: \n %s", usuario1.verProductoEnVenta() + "\n");
                                    nombre = sc.nextLine();
                                    System.out.println(usuario2.quitarProducto(nombre) ? "Has eliminado el producto corrrectamente" : "EL producto no se ha podido eliminar");
                                    break;
                                case 2:
                                    System.out.printf("Que producto quieres eliminar: \n %s", usuario1.verProductoEnVenta() + "\n");
                                    nombre = sc.nextLine();
                                    System.out.print("Dime la descripcion del producto en venta: ");
                                    descripcion = sc.nextLine();
                                    System.out.print("Dime el email del comprador: ");
                                    emailComprador = sc.nextLine();
                                    System.out.print("Dime el precio al que lo vas a poner: ");
                                    precio = Double.parseDouble(sc.nextLine());
                                    System.out.print("Dime la puntuacion del producto: ");
                                    puntuacion = Double.parseDouble(sc.nextLine());
                                    System.out.print("Dime el comentario: ");
                                    comentario = sc.nextLine();
                                    usuario1.registrarCompra(precio, usuario2.getEmail(), puntuacion, comentario);

                                    System.out.println(usuario2.realizarVenta(nombre, emailComprador, puntuacion, comentario) ? "EL producto se ha vendido correctamente" : "No se ha podido vender el producto");
                                    break;
                            }
                        }
                        break;
                    case 5:
                        if (usu1) {
                            System.out.print("Dime el producto en venta que quieres poner: ");
                            nombreVenta = sc.nextLine();
                            System.out.print("Dime la descripcion del producto en venta: ");
                            descripcion = sc.nextLine();
                            System.out.print("Dime el email del vendedor: ");
                            emailVendedor = sc.nextLine();
                            System.out.print("Dime el precio al que lo vas a poner: ");
                            precio = Double.parseDouble(sc.nextLine());

                            producto = new Producto(descripcion, emailVendedor, true, nombreVenta, precio);

                            System.out.println(usuario1.ponerProductoEnVenta(producto) ? "El producto se ha puesto a la venta correctamente." : "El producto no se ha podido poner a la venta");
                        }
                        if (usu2) {
                            System.out.print("Dime el producto en venta que quieres poner: ");
                            nombreVenta = sc.nextLine();
                            System.out.print("Dime la descripcion del producto en venta: ");
                            descripcion = sc.nextLine();
                            System.out.print("Dime el email del vendedor: ");
                            emailVendedor = sc.nextLine();
                            System.out.print("Dime el precio al que lo vas a poner: ");
                            precio = Double.parseDouble(sc.nextLine());

                            producto = new Producto(descripcion, emailVendedor, true, nombreVenta, precio);

                            System.out.println(usuario2.ponerProductoEnVenta(producto) ? "El producto se ha puesto a la venta correctamente." : "El producto no se ha podido poner a la venta");
                        }
                        Utils.pulsaParaContinuar();
                        Utils.limpiaPatallas();
                        break;
                    case 6:
                        System.out.println(usuario1.verProductoEnVenta());
                        System.out.println(usuario2.verProductoEnVenta());
                        Utils.pulsaParaContinuar();
                        Utils.limpiaPatallas();
                        break;
                    case 7:
                        if (usu1) System.out.println(usuario1.verHistoricoVentas());
                        if (usu2) System.out.println(usuario2.verHistoricoVentas());
                        Utils.pulsaParaContinuar();
                        Utils.limpiaPatallas();
                        break;

                    case 8:
                        if (usu1) System.out.println(usuario1.verHistoricoCompras());
                        if (usu2) System.out.println(usuario2.verHistoricoCompras());
                        Utils.pulsaParaContinuar();
                        Utils.limpiaPatallas();
                        break;
                    case 9:
                        System.out.println("Saliendo de la cuenta...");
                        usu1 = false;
                        usu2 = false;
                        break;
                }
            } while (op != 9);
        }while (!salir);
        System.out.println("Saliendo de la aplicación...");
    }
}