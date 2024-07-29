package tp05;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP5 - Ejercicio 27 --- */

/*
Hacer un programa que dado un arreglo ordenado creciente de enteros de tamaño 10 que se encuentra precargado,
solicite al usuario un número entero y lo inserte en el arreglo manteniendo su orden. Para ello tendrá que realizar
un corrimiento a derecha (se pierde el último valor del arreglo) y colocar el número en el arreglo en la posición
indicada.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class E27 {
    public static final int MAX = 10;

    public static void main(String[] args) {
        int[] arr = { 0, 1, 2, 3, 3, 6, 7, 8, 8, 9 };
        int num;

        imprimirArreglo(arr);

        System.out.print("Ingrese un número entero (entre 0 y 9) para colocar en el arreglo: ");
        num = leerEntero();

        if (0 <= num && num <= 9) {
            insertarElementoArregloOrdAsc(arr, num);
            imprimirArreglo(arr);
        }
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

    public static void insertarElementoArregloOrdAsc(int[] arr, int num) {
        int pos = 0;

        // Se obtiene el índice para colocar el elemento
        while (pos < MAX && arr[pos] < num) {
            pos++;
        }

        // Si el índice se encuentra dentro de los límites del arreglo
        if (pos < MAX) {
            corrimientoADerecha(arr, pos); // Corrimiento a derecha
            arr[pos] = num; // Inserción de elemento
        }
    }

    public static void corrimientoADerecha(int[] arr, int pos) {
        for (int i = MAX - 1; i > pos; i--) {
            arr[i] = arr[i - 1];
        }
    }

    public static void imprimirArreglo(int[] arr) {
        System.out.print("|  ");
        for (int i = 0; i < MAX; i++) {
            System.out.print(arr[i] + "  |  ");
        }
        System.out.println();
    }
}
