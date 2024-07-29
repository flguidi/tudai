package tp03;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP3 - Ejercicio 03 --- */

/* 
Escribir un diseño de programa que mientras que el usuario ingrese un número natural, pida ingresar otro
número cualquiera y lo imprima:

DISEÑO
Declarar variable de tipo entero
Obtener número entero por teclado
Mientras número sea natural:
    Obtener número por teclado
    Imprimir número
    Obtener número por teclado
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class E03 {
    public static void main(String[] args) {
        int num;
        System.out.print("Ingresar número natural: ");
        num = ingresarNumero();
        
        while (num > 0) {
            System.out.print("Ingresar otro número: ");
            num = ingresarNumero();
            System.out.println("Número ingresado: " + num);
            System.out.print("Ingresar número natural: ");
            num = ingresarNumero();
        }
    }

    public static int ingresarNumero() {
        int num = 0;
        boolean esEntero = false;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        while (!esEntero) {
            try {
                num = Integer.valueOf(entrada.readLine());
                esEntero = true;
            } catch (Exception e) {
                System.out.println("Error: no se ingresó un número entero.");
            }
        }
        
        return num;
    }
}
