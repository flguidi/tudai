package tp01;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP1 - Ejercicio 04 --- */

/*
Escribir un programa que permita ingresar 5 números de a uno por vez y que los muestre por
pantalla en orden inverso.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class E04 {
    public static void main(String[] args) {
        int n1, n2, n3, n4, n5;

        try {
            // Entrada por teclado
            BufferedReader entrada = new BufferedReader (new InputStreamReader(System.in));
            System.out.print("Ingrese el primer número: ");
            n1 = Integer.valueOf(entrada.readLine());
            System.out.print("Ingrese el segundo número: ");
            n2 = Integer.valueOf(entrada.readLine());
            System.out.print("Ingrese el tercer número: ");
            n3 = Integer.valueOf(entrada.readLine());
            System.out.print("Ingrese el cuarto número: ");
            n4 = Integer.valueOf(entrada.readLine());
            System.out.print("Ingrese el quinto número: ");
            n5 = Integer.valueOf(entrada.readLine());

            // Salida por consola, en orden inverso
            System.out.print(n5 + " - ");
            System.out.print(n4 + " - ");
            System.out.print(n3 + " - ");
            System.out.print(n2 + " - ");
            System.out.print(n1);
        } catch (Exception exc) {
            System.out.println("Error");
        }
    }
}