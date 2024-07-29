package tp02;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP2 - Ejercicio 04 --- */

/*
Escribir un programa donde el usuario ingrese un número entre 0 y 999, y muestre un mensaje de cuántos
dígitos tiene. Además, si tiene 3 dígitos debe informar qué número es.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class E04 {
    public static void main(String[] args) {
        int num;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        try {
            // Entrada
            System.out.print("Ingrese un número entre 0 y 999: ");
            num = Integer.valueOf(entrada.readLine());

            // Procesamiento y salida
            if (num >= 100 && num < 1000) {
                System.out.println("El número " + num + " tiene tres dígitos");
            } else if (num >= 10 && num < 100) {
                System.out.println("El número tiene dos dígitos");
            } else if (num >= 0 && num < 10) {
                System.out.println("El número tiene un dígito");
            } else {
                System.out.println("Número incorrecto");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }    
}
