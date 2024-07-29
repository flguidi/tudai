package tp01;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP1 - Ejercicio 09 --- */

/*
Escribir un programa que permita el ingreso de un número entero por teclado e imprima el cociente de la división
de dicho número por 2, 3, y 4. En base a los resultados obtenidos analice cada caso si es correcto o no.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class E09 {
    public static void main(String[] args) {
        int dividendo, cociente1, cociente2, cociente3;

        try {
            // Entrada
            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Ingrese un número entero: ");
            dividendo = Integer.valueOf(entrada.readLine());

            // Procesamiento
            cociente1 = dividendo / 2;
            cociente2 = dividendo / 3;
            cociente3 = dividendo / 4;

            // Salida
            System.out.println(dividendo + " / 2 = " + cociente1);
            System.out.println(dividendo + " / 3 = " + cociente2);
            System.out.println(dividendo + " / 4 = " + cociente3);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
