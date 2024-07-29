package tp02;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP2 - Ejercicio 08 --- */

/*
Escribir un programa que mientras que el usuario ingrese un número entero distinto de 0, pida ingresar
otro número entero y lo imprima.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class E08 {
    public static void main(String[] args) {
        int nroCorte = 1, nroSalida;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        while (nroCorte != 0) {
            try {
                System.out.print("Ingrese un número (0 para salir): ");
                nroCorte = Integer.valueOf(entrada.readLine());

                if (nroCorte != 0) {
                    System.out.print("Ingrese número entero para imprimir: ");
                    nroSalida = Integer.valueOf(entrada.readLine());
                    System.out.println("Número ingresado: " + nroSalida);
                }
            } catch (Exception e) {
                System.out.println("¡No es un número entero!");
            }
        }
    }
}
