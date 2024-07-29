package tp01;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP1 - Ejercicio 12 --- */

/*
Escribir un programa que permita ingresar dos números enteros, incremente el primero y decremente el segundo,
para luego mostrar por pantalla en ambos casos, el valor original y el modificado.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class E12 {
    public static void main(String[] args) {
        int a, b;

        try {
            // Entrada
            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Ingrese el primer número: ");
            a = Integer.valueOf(entrada.readLine());
            System.out.print("Ingrese el segundo número: ");
            b = Integer.valueOf(entrada.readLine());
            
            // Salida
            System.out.println("Valor original del primer número: " + a + "\t Valor incrementado: " + (++a));
            System.out.println("Valor original del segundo número: " + b + "\t Valor decrementado: " + (--b));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
