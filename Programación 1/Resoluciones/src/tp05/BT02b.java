package tp05;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP5 - Bonus Track 02b --- */

/* Corrección de errores */

import java.util.Random;

public class BT02b {
    public static final int MAX = 10, MIN_VALOR = 0, MAX_VALOR = 1000;

    public static void main(String[] args) {
        int[] arreglo = new int[MAX];
        int pos = 6;
        cargarArreglo(arreglo);
        mostrarArreglo(arreglo);
        correrIzquierda(arreglo, pos);
        mostrarArreglo(arreglo);
    }

    // Corrimiento a izquierda (se modificó la condición del ciclo for para funcione correctamente)
    public static void correrIzquierda(int[] arr, int pos) {
        for (int i = pos; i < MAX - 1; i++) {
            arr[i] = arr[i + 1];
        }
    }

    // Carga aleatoria del arreglo entre los valores MIN_VALOR y MAX_VALOR
    public static void cargarArreglo(int[] arr) {
        Random r = new Random();
        for (int pos = 0; pos < MAX; pos++) {
            arr[pos] = r.nextInt(MAX_VALOR - MIN_VALOR + 1) + MIN_VALOR;
        }
    }

    // Impresión del arreglo
    public static void mostrarArreglo(int[] arr) {
        System.out.print("|  ");
        for (int pos = 0; pos < MAX; pos++) {
            System.out.print(arr[pos] + "  |  ");
        }
        System.out.println();
    }
}
