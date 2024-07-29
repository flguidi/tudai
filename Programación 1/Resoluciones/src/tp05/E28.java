package tp05;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP5 - Ejercicio 28 --- */

/*
Hacer un programa que dado un arreglo ordenado creciente de enteros de tamaño 10 que se encuentra precargado,
solicite al usuario un número entero y elimine la primera ocurrencia de número (un número igual) en el arreglo
(si existe). Informar si no existe en el arreglo.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class E28 {
    public static final int MAX = 10;

    public static void main(String[] args) {
        int[] arr = { 0, 1, 2, 3, 3, 6, 7, 8, 8, 9 };
        int num, pos;

        imprimirArreglo(arr);

        System.out.print("Ingrese el número del arreglo que desea eliminar: ");
        num = leerEntero();

        pos = buscarElementoEnArreglo(arr, num);
        if (0 <= pos && pos < MAX) {
            eliminarElementoEnArreglo(arr, num);
        } else {
            System.out.println("El número " + num + " no se encuentra en el arreglo.");
        }

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

    public static int buscarElementoEnArreglo(int[] arr, int num) {
        int pos = 0;
        while (pos < MAX && arr[pos] != num) {
            pos++;
        }
        return pos;
    }

    public static void eliminarElementoEnArreglo(int[] arr, int pos) {
        for (; pos < MAX - 1; pos++) {
            arr[pos] = arr[pos + 1];
        }
        arr[MAX - 1] = 0; // Se vacía la última posición
    }

    public static void imprimirArreglo(int[] arr) {
        System.out.print("|  ");
        for (int i = 0; i < MAX; i++) {
            System.out.print(arr[i] + "  |  ");
        }
        System.out.println();
    }
}
