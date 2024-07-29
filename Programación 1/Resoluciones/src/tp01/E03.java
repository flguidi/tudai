package tp01;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP1 - Ejercicio 03 --- */

/*
Escribir un programa que declare una constante de tipo int y pida el ingreso de un valor por teclado.
Luego debe mostrar el valor ingresado.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class E03 {
    public static void main(String[] args) {
        final int num;

        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Ingrese un número entero: ");
            num = Integer.valueOf(entrada.readLine());
            System.out.println("Número ingresado: " + num);
        } catch (Exception exc) {
            System.out.println(exc);
            System.out.println("Error al ingresar el dato");
        }
    }
}
