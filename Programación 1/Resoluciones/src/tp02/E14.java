package tp02;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP2 - Ejercicio 14 --- */

/*
Pedir por consola el ingreso de 10 números enteros positivos. Contar cuántas veces se ingresaron números
pares y mostrarlo por pantalla.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class E14 {
    public static void main(String[] args) {
        final int MAX = 10;
        int num, contador = 0;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 1; i <= MAX; i++) {
            try {
                // Entrada
                System.out.print("(" + i + ") Ingrese un número entero positivo: ");
                num = Integer.valueOf(entrada.readLine());

                // Procesamiento
                if (num > 0 && num % 2 == 0) {
                    contador++;
                }
            } catch (Exception e) {
                System.out.println("ERROR: no se ingresó un número entero");
            }
        }

        // Salida
        System.out.println("Cantidad de números pares ingresados: " + contador);
    }
}
