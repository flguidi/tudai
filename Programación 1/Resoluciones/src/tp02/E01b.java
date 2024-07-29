package tp02;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP2 - Ejercicio 01b --- */

/* 
Escribir un programa completo (declaración de constantes y variables, carga de datos, procesamiento e impresión de
resultados) para cada caso o ítem que:
    a. solicite un número e indique si es positivo o negativo.
    b. solicite un número e imprima “grande” si es mayor a 100 y “chico “ si es menor.
    c. solicite un número del 1 al 7 e imprima el día de la semana.
    d. solicite una letra e imprima si es vocal o consonante.
    e. solicite 3 números e imprima “creciente” si los tres números están en orden creciente, “decreciente” si están
       en orden decreciente o “error” si no cumplen ningún orden.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class E01b {
    public static void main(String[] args) {
        int num;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        try {
            // Entrada
            System.out.print("Ingrese un número entero: ");
            num = Integer.valueOf(entrada.readLine());

            // Procesamiento y salida
            if (num > 100) {
                System.out.println("Grande");
            } else {
                System.out.println("Chico");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
