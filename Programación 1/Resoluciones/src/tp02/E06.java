package tp02;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP2 - Ejercicio 06 --- */

/*
Escribir un programa que mientras el usuario ingrese un número entero menor que 100 y mayor a 1, muestre
por pantalla si el número es múltiplo de 2 y múltiplo de 3 simultáneamente.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class E06 {
    public static void main(String[] args) {
        final int MIN = 1, MAX = 100;
        int num;
        boolean esValido = true;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        while (esValido) {
            try {
                // Entrada
                System.out.print("Ingrese un número entero entre 1 y 100: ");
                num = Integer.valueOf(entrada.readLine());
                
                // Procesamiento y salida
                if (MIN <= num && num <= MAX) {
                    if (num % 2 == 0 && num % 3 == 0) {
                        System.out.println(num + " es múltiplo de 2 y de 3");
                    } 
                } else {
                    esValido = false;
                }
            } catch (Exception e) { // Cuando no se ingresa un número entero
                System.out.println("¡No es un número entero!");
            }    
        }
    }
}
