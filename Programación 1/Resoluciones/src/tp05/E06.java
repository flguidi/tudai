package tp05;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP5 - Ejercicio 06 --- */

/* Hacer un programa que dado un arreglo de enteros de tamaño 10 que se encuentra cargado, obtenga la cantidad de
números pares que tiene y la imprima. */

import java.util.Random;

public class E06 {
    public static final int MAX = 10, MIN_VALOR = 0, MAX_VALOR = 9;

    public static void main(String[] args) {
        int[] arr = new int[MAX];
        int cantPares;

        // Carga e impresión del arreglo
        cargarArreglo(arr);
        imprimirArreglo(arr);

        // Cuenta de pares
        cantPares = contarPares(arr);
        
        // Impresión de resultado
        System.out.println("La cantidad de pares en arr[] es " + cantPares);
    }

    public static void cargarArreglo(int[] arr) {
        Random r = new Random();
        for (int pos = 0; pos < MAX; pos++) {
            arr[pos] = r.nextInt(MAX_VALOR - MIN_VALOR + 1) + MIN_VALOR;
        }
    }

    public static int contarPares(int[] arr) {
        int cantPares = 0;
        for (int pos = 0; pos < MAX; pos++) {
            if (arr[pos] % 2 == 0) {
                cantPares++;
            }
        }
        return cantPares;
    }

    public static void imprimirArreglo(int[] arr) {
        System.out.print("|  ");
        for (int pos = 0; pos < MAX; pos++) {
            System.out.print(arr[pos] + "  |  ");
        }
        System.out.println();
    }
}
