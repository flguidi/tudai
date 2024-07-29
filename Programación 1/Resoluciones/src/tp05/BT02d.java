package tp05;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP5 - Bonus Track 02d --- */

/*
Hacer un programa que dado un arreglo de enteros de tamaño 10 que se encuentra precargado, imprima por pantalla
el promedio de la suma de sus valores.
*/

import java.util.Random;

public class BT02d {
    public static final int MAX = 10, MIN_VALOR = 0, MAX_VALOR = 1000;

    public static void main(String[] args) {
        int[] arr = new int[MAX];
        int promedio;

        cargarArregloInt(arr);
        imprimirArregloInt(arr);
        
        promedio = promedioArreglo(arr);
        System.out.println("El promedio del arreglo es: " + promedio);
    }

    public static int promedioArreglo(int[] arr) {
        int suma = 0;
        for (int pos = 0; pos < MAX; pos++) {
            suma += arr[pos];
        }
        return (suma / MAX);
    }

    // Carga aleatoria del arreglo entre los valores MIN_VALOR y MAX_VALOR
    public static void cargarArregloInt(int[] arr) {
        Random r = new Random();
        for (int pos = 0; pos < MAX; pos++) {
            arr[pos] = r.nextInt(MAX_VALOR - MIN_VALOR + 1) + MIN_VALOR;
        }
    }

    // Impresión del arreglo
    public static void imprimirArregloInt(int[] arr) {
        System.out.print("|  ");
        for (int pos = 0; pos < MAX; pos++) {
            System.out.print(arr[pos] + "  |  ");
        }
        System.out.println();
    }
}
