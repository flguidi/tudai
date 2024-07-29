package tp05;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP5 - Ejercicio 29 --- */

/*
Hacer un programa que dado un arreglo de enteros de tamaño 10 que se encuentra precargado, solicite al
usuario el ingreso de dos números enteros (posiciones del arreglo) y ordene de forma creciente el arreglo
entre dos posiciones correspondientes a los números ingresados.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class E29 {
    public static final int MAX = 10, MIN_VALOR = 0, MAX_VALOR = 99;

    public static void main(String[] args) {
        int[] arr = new int[MAX];
        int pos1, pos2;

        cargarArreglo(arr);
        imprimirArreglo(arr);

        System.out.print("Ingrese posición 1 (entre 0 y " + (MAX - 1) + "): ");
        pos1 = leerEntero();

        System.out.print("Ingrese posición 2 (entre 0 y " + (MAX - 1) + "): ");
        pos2 = leerEntero();

        if ((0 <= pos1 && pos1 < MAX) && (0 <= pos2 && pos2 < MAX)) {
            ordenarSubarreglo(arr, pos1, pos2);
            imprimirArreglo(arr);
        } else {
            System.out.println("Error.");
        }
    }

    // Lectura de número entero por teclado
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

    // Ordenamiento ascendente por burbujeo de un subarreglo dado
    public static void ordenarSubarreglo(int[] arr, int pos1, int pos2) {
        int aux;

        for (int i = pos1; i < pos2; i++) {
            for (int j = pos1; j < pos2 - i + pos1; j++) {
                if (arr[j] > arr[j + 1]) {
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
