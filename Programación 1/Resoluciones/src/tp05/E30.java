package tp05;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP5 - Ejercicio 30 --- */

/*
Hacer un programa que cargue un arreglo (sin orden) de tamaño 10 con números enteros aleatorios entre 0 y 100.
Finalmente imprima por pantalla el arreglo ordenado. Hacerlo para orden creciente y decreciente
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class E30 {
    public static final int MAX = 10, MIN_VALOR = 0, MAX_VALOR = 100;

    public static void main(String[] args) {
        int[] arr = new int[MAX];

        cargarArreglo(arr);
        System.out.println("Arreglo original:");
        imprimirArreglo(arr);

        // Ordenamiento por selección
        ordenamientoSeleccionAsc(arr);
        System.out.println("Ordenamiento por selección ascendente:");
        imprimirArreglo(arr);

        ordenamientoSeleccionDesc(arr);
        System.out.println("Ordenamiento por selección descendente:");
        imprimirArreglo(arr);

        // Ordenamiento por inserción
        ordenamientoInsercionAsc(arr);
        System.out.println("Ordenamiento por inserción ascendente:");
        imprimirArreglo(arr);

        ordenamientoInsercionDesc(arr);
        System.out.println("Ordenamiento por inserción descendente:");
        imprimirArreglo(arr);

        // Ordenamiento por burbujeo
        ordenamientoBurbujeoAsc(arr);
        System.out.println("Ordenamiento por burbujeo ascendente:");
        imprimirArreglo(arr);

        ordenamientoBurbujeoDesc(arr);
        System.out.println("Ordenamiento por burbujeo descendente:");
        imprimirArreglo(arr);
    }

    public static int leerEntero() {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        int num = 0;
        boolean esValido = false;

        while (!esValido) {
            try {
                num = Integer.valueOf(entrada.readLine());
                esValido = true;
            } catch (Exception e) {
                System.out.println("Error. Inténtelo nuevamente.");
            }
        }

        return num;
    }

    // Carga del arreglo con números enteros aleatorios entre MIN_VALOR y MAX_VALOR
    public static void cargarArreglo(int[] arr) {
        Random r = new Random();
        for (int i = 0; i < MAX; i++) {
            arr[i] = r.nextInt(MAX_VALOR - MIN_VALOR + 1) + MIN_VALOR;
        }
    }

    // Ordenamiento ascendente por selección
    public static void ordenamientoSeleccionAsc(int[] arr) {
        int menor, aux, pos;

        for (int i = 0; i < MAX; i++) {
            menor = arr[i];
            pos = i;
            for (int j = i + 1; j < MAX; j++) {
                if (arr[j] < menor) {
                    menor = arr[j];
                    pos = j;
                }
            }
            if (pos != i) {
                aux = arr[i];
                arr[i] = arr[pos];
                arr[pos] = aux;
            }
        }
    }

    // Ordenamiento descendente por selección
    public static void ordenamientoSeleccionDesc(int[] arr) {
        int mayor, aux, pos;

        for (int i = 0; i < MAX; i++) {
            mayor = arr[i];
            pos = i;
            for (int j = i + 1; j < MAX; j++) {
                if (arr[j] > mayor) {
                    mayor = arr[j];
                    pos = j;
                }
            }
            if (pos != i) {
                aux = arr[i];
                arr[i] = arr[pos];
                arr[pos] = aux;
            }
        }
    }

    // Ordenamiento ascendente por inserción
    public static void ordenamientoInsercionAsc(int[] arr) {
        for (int i = 1; i < MAX; i++) {
            int aux = arr[i];
            int j = i - 1;
            while ((j >= 0) && (arr[j] > aux)) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = aux;
        }
    }

    // Ordenamiento descendente por inserción
    public static void ordenamientoInsercionDesc(int[] arr) {
        for (int i = 1; i < MAX; i++) {
            int aux = arr[i];
            int j = i - 1;
            while ((j >= 0) && (arr[j] < aux)) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = aux;
        }
    }

    // Ordenamiento ascendente por burbujeo
    public static void ordenamientoBurbujeoAsc(int[] arr) {
        int aux;
        for (int i = 0; i < MAX; i++) {
            for (int j = 0; j < MAX - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    aux = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = aux;
                }
            }
        }
    }

    // Ordenamiento descendente por burbujeo
    public static void ordenamientoBurbujeoDesc(int[] arr) {
        int aux;
        for (int i = 0; i < MAX; i++) {
            for (int j = 0; j < MAX - 1 - i; j++) {
                if (arr[j] < arr[j + 1]) {
                    aux = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = aux;
                }
            }
        }
    }

    // Impresión del arreglo
    public static void imprimirArreglo(int[] arr) {
        System.out.print("| ");
        for (int i = 0; i < MAX; i++) {
            System.out.print(arr[i] + " | ");
        }
        System.out.print("\n");
    }
}
