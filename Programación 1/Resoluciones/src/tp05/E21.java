package tp05;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP5 - Ejercicio 21 --- */

/*
Hacer un programa que elimine de un arreglo todas las secuencias que tienen orden descendente entre
sus elementos.
*/

import java.util.Random;

public class E21 {
    public static final int MAX = 20, MIN_VALOR = 1, MAX_VALOR = 9;
    public static final double probabilidadNumero = 0.6;

    public static void main(String[] args) {
        int[] arr = new int[MAX];

        cargarArreglo(arr); // Carga aleatoria del arreglo
        imprimirArreglo(arr); // Impresión de arreglo original
        eliminarSecuenciasDesc(arr); // Eliminación de secuencias de orden descendente
        imprimirArreglo(arr); // Impresión de arreglo modificado
    }

    // Carga del arreglo con números enteros aleatorios entre MIN_VALOR y MAX_VALOR
    public static void cargarArreglo(int[] arr) {
        Random r = new Random();
        arr[0] = 0;
        arr[MAX - 1] = 0;

        for (int i = 1; i < MAX - 1; i++) {
            if (probabilidadNumero > r.nextDouble()) {
                arr[i] = r.nextInt(MAX_VALOR - MIN_VALOR + 1) + MIN_VALOR;
            } else {
                arr[i] = 0;
            }
        }
    }

    // Eliminación de secuencia/s de orden descendente
    public static void eliminarSecuenciasDesc(int[] arr) {
        int inicio = 0, fin = -1;
        while (inicio < MAX) {
            inicio = obtenerInicioSecuencia(arr, fin + 1);
            if (inicio < MAX) {
                fin = obtenerFinSecuencia(arr, inicio);
                if (verificarSecuenciaDesc(arr, inicio, fin)) {
                    eliminarSecuencia(arr, inicio, fin);
                    inicio = fin;
                }
            }
        }
    }

    // Obtención de posición de inicio de secuencia
    public static int obtenerInicioSecuencia(int[] arr, int pos) {
        while (pos < MAX && arr[pos] == 0) {
            pos++;
        }
        return pos;
    }

    // Obtención de posición de fin de secuencia
    public static int obtenerFinSecuencia(int[] arr, int pos) {
        while (pos < MAX && arr[pos] != 0) {
            pos++;
        }
        return pos - 1;
    }

    // Verifica si una secuencia dada es de orden descendente
    public static boolean verificarSecuenciaDesc(int[] arr, int inicio, int fin) {
        int longitudSecuencia = fin - inicio + 1;
        if (longitudSecuencia < 2) {
            return false;
        }
        while (inicio < fin && arr[inicio] > arr[inicio + 1]) {
            inicio++;
        }
        return inicio == fin;
    }

    // Eliminación de todos los elementos de una secuencia dada
    public static void eliminarSecuencia(int[] arr, int inicio, int fin) {
        for (int i = inicio; i <= fin; i++) {
            eliminarElemento(arr, inicio);
        }
    }

    // Eliminación de elemento y corrimiento a izquierda
    public static void eliminarElemento(int[] arr, int pos) {
        for (int i = pos; i < MAX - 1; i++) {
            arr[i] = arr[i + 1];
        }
    }

    // Impresión por consola de un arreglo dado
    public static void imprimirArreglo(int[] arr) {
        System.out.print("|");
        for (int i = 0 ; i < MAX; i++) {
            System.out.print(arr[i] + "|");
        }
        System.out.print("\n");
    }
}
