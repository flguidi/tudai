package tp05;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP5 - Bonus Track 02e --- */

/* Escribir un programa que elimine todas las secuencias de tamaño par. */

import java.util.Random;

public class BT02e {
    public static final int MAX = 20, MIN_VALOR = 0, MAX_VALOR = 9;
    public static final double PROBABILIDAD_NUMERO = 0.6;

    public static void main(String[] args) {
        int[] A = new int[MAX];

        cargar_arreglo(A);
        mostrarArreglo(A);
        eliminarSecuencias(A);
        mostrarArreglo(A);
    }

    public static void cargar_arreglo(int[] arr) {
        Random r = new Random();
        arr[0] = 0;
        arr[MAX - 1] = 0;

        for (int pos = 1; pos < MAX - 1; pos++) {
            if (r.nextDouble() < PROBABILIDAD_NUMERO) {
                arr[pos] = pos * 2;
            } else {
                arr[pos] = 0;
            }
        }
    }

    public static void eliminarSecuencias(int[] arr) {
        int inicio = 0, fin = -1;

        while (inicio < MAX) {
            inicio = obtenerInicio(arr, fin + 1);

            if (inicio < MAX) {
                fin = obtenerFin(arr, inicio);

                int tam = fin - inicio + 1;
                if (tam % 2 == 0) {
                    for (; tam > 0; tam--) {
                        correrIzquierda(arr, inicio);
                    }
                    fin = inicio;
                }
            }
        }
    }

    public static void correrIzquierda(int[] arr, int pos) {
        for (int i = pos; i < MAX - 1; i++) {
            arr[i] = arr[i + 1];
        }
    }

    public static int obtenerInicio(int[] arr, int pos) {
        while (pos < MAX && arr[pos] == 0) {
            pos++;
        }
        return pos;
    }

    public static int obtenerFin(int[] arr, int pos) {
        while (pos < MAX && arr[pos] != 0) {
            pos++;
        }
        return pos - 1;
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
