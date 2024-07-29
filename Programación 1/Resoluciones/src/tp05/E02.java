package tp05;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP5 - Ejercicio 02 --- */

/*
Hacer un programa que dado un arreglo ya cargado con 10 enteros, calcule el promedio y lo muestre por
la consola.
*/

import java.util.Random;

public class E02 {
    public static final int MAX = 10, MIN_VALOR = 1, MAX_VALOR = 10;
    
    public static void main(String[] args) {
        int[] arr = new int[MAX];
        double promedio;

        cargarArreglo(arr);
        imprimirArreglo(arr);
        promedio = calcularPromedioArreglo(arr);
        System.out.println("El promedio es: " + promedio);
    }

    public static void cargarArreglo(int[] arr) {
        Random r = new Random();
        for (int pos = 0; pos < MAX; pos++) {
            arr[pos] = r.nextInt(MAX_VALOR - MIN_VALOR + 1) + MIN_VALOR;
        }
    }

    public static double calcularPromedioArreglo(int[] arr) {
        int suma = 0;
        for (int pos = 0; pos < MAX; pos++) {
            suma += arr[pos];
        }
        return (double) suma / MAX;
    }

    public static void imprimirArreglo(int[] arr) {
        for (int pos = 0; pos < MAX; pos++) {
            System.out.print(arr[pos] + " ");
        }
        System.out.println();
    }
}
