package tp02;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP2 - Ejercicio 10 --- */

/*
Escribir un programa que mientras que el usuario ingrese un número entero entre 1 y 10 inclusive,
lleve la suma de los números ingresados. Finalmente, cuando sale del ciclo muestre por pantalla el
resultado de la suma.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class E10 {
    public static void main(String[] args) {
        int num = 1, suma = 0;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        while (num >= 1 && num <= 10) {
            try {
                System.out.print("Ingrese un número entero entre 1 y 10: ");
                num = Integer.valueOf(entrada.readLine());

                if (num >= 1 && num <= 10) {
                    suma += num;
                }
            } catch (Exception e) {
                System.out.println("¡No es un número entero!");
            }
        }

        System.out.println("La suma es: " + suma);
    }
}
