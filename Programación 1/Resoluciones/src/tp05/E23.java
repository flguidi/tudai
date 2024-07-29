package tp05;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP5 - Ejercicio 23 --- */

/* Hacer un programa que invierta el orden de la última secuencia en un arreglo. */

import java.util.Random;

public class E23 {
    public static final int MAX = 20, MIN_VALOR = 1, MAX_VALOR = 9;
    public static double probabilidadNumero = 0.9;

    public static void main(String[] args) {
        int[] arr = new int[MAX];
        int inicio, fin;

        cargarArreglo(arr);
        imprimirArreglo(arr);

        // Encontrar inicio y fin de la última secuencia
        fin = obtenerFinSecuenciaInv(arr, MAX-1);
        inicio = obtenerInicioSecuenciaInv(arr, fin);

        invertirSecuencia(arr, inicio, fin);
        imprimirArreglo(arr);
    }

    // Carga de arreglo con valores aleatorios entre MIN_VALOR y MAX_VALOR
    public static void cargarArreglo(int[] arr) {
        Random r = new Random();
        arr[0] = 0;
        arr[MAX - 1] = 0;

        for (int i = 1; i < MAX - 1; i++) {
            if (r.nextDouble() < probabilidadNumero) {
                arr[i] = r.nextInt(MAX_VALOR - MIN_VALOR + 1) + MIN_VALOR;
            } else {
                arr[i] = 0;
            }
        }
    }

    // Obtención del fin de la última secuencia del arreglo (se recorre descendentemente)
    public static int obtenerFinSecuenciaInv(int[] arr, int pos) {
        while (pos > 0 && arr[pos] == 0) {
            pos--;
        }
        return pos;
    }

    // Obtención del comienzo de la última secuencia del arreglo (se recorre descendentemente)
    public static int obtenerInicioSecuenciaInv(int[] arr, int pos) {
        while (pos > 0 && arr[pos] != 0) {
            pos--;
        }
        return pos + 1;
    }

    // Se invierte una secuencia, dadas sus posiciones de inicio y fin
    public static void invertirSecuencia (int[] arr, int inicio, int fin) {
        for (int i = inicio; i <= (fin + inicio) / 2; i++) {
            int aux = arr[i];
            arr[i] = arr[fin + inicio - i];
            arr[fin + inicio - i] = aux;
        }
    }

    // Impresión por consola del arreglo
    public static void imprimirArreglo(int[] arr) {
        System.out.print("|");
        for (int i = 0; i < MAX; i++) {
            System.out.print(arr[i] + "|");
        }
        System.out.print("\n");
    }
}
