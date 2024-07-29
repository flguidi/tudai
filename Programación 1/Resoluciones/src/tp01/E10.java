package tp01;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP1 - Ejercicio 10 --- */

/*
Escribir un programa que permita el ingreso de dos números enteros por teclado e imprima:
    a. si el primero es mayor al segundo.
    b. si ambos son múltiplos de 2.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class E10 {
    public static void main(String[] args) {
        int a, b;
        boolean esMayor, sonPares;

        System.out.println("DEBUGGING PARA PRÁCTICA 04, EJERCICIO 02:");

        try {
            // Entrada
            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Ingrese un número entero: ");
            a = Integer.valueOf(entrada.readLine());
            System.out.println("'a': " + a);

            System.out.print("Ingrese otro número entero: ");
            b = Integer.valueOf(entrada.readLine());
            System.out.println("'b': " + b);

            // Procesamiento
            esMayor = a > b;
            System.out.println("'esMayor': " + esMayor);
            sonPares = (a % 2 == 0) && (b % 2 == 0);
            System.out.println("'sonPares': " + sonPares);
            
            // Salida
            System.out.println("¿" + a + " es mayor que " + b + "? " + esMayor);
            System.out.println("¿" + a + " y " + b + " son múltiplos de 2? " + sonPares);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
