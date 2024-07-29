package tp02;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP2 - Ejercicio 15 --- */

/*
Pedir por consola el ingreso de números enteros. Cuando se ingrese un 0 se debe terminar el programa
informando el promedio de los números ingresados, cuál fue el mayor número y cuál fue el menor número.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class E15 {
    public static void main(String[] args) {
        int num, mayor = 0, menor = 0, suma = 0, contador = 0;
        float promedio;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        // Entrada
        
        try {
            System.out.print("Ingrese un número entero (0 para salir): ");
            num = Integer.valueOf(entrada.readLine());
            mayor = num;
            menor = num;

            while (num != 0) {
                if (num < menor) {
                    menor = num;
                }
                if (num > mayor) {
                    mayor = num;
                }
                suma += num;
                contador++;

                System.out.print("Ingrese un número entero (0 para salir): ");
                num = Integer.valueOf(entrada.readLine());
            }
        } catch (Exception e) {
            System.out.println("Ingreso inválido");
        }

        promedio = (float) suma / contador;

        // Salida
        System.out.println("Menor: " + menor);
        System.out.println("Mayor: " + mayor);
        System.out.println("Promedio: " + promedio);
    }
}
