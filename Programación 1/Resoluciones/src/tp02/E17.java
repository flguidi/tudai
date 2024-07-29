package tp02;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP2 - Ejercicio 17 --- */

/*
Escribir un programa que dado un valor ingresado por el usuario menor que 10 y mayor a 1, muestre por pantalla
una cuenta regresiva de números desde dicho valor hasta el 0 inclusive.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class E17 {
    public static void main(String[] args) {
        int num;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.print("Ingrese un número entero entre 1 y 10: ");
            num = Integer.valueOf(entrada.readLine());

            if (1 <= num && num <= 10) {
                while (num >= 0) {
                    System.out.println(num);
                    num--;
                }
            } else {
                System.out.println("Valor incorrecto. Programa terminado.");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
