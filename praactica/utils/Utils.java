package utils;

import java.util.Scanner;

public class Utils {
    public static void limpiaPatallas(){
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }

    public static void pulsaParaContinuar(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Pulsa una tecla para continuar: ");
        sc.nextLine();
    }

    public static void menuCambiaDatos(){
        System.out.println("""
                            Qué datos personales quieres cambiar?
                            1.Nombre
                            2.Apellidos
                            3.Calle
                            4.Email
                            5.Clave""");

    }
}
