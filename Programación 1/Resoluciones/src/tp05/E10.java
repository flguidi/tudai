package tp05;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP5 - Ejercicio 10 --- */

/* Hacer un programa que dado un arreglo de enteros de tamaño 10 que se encuentra precargado, solicite al usuario
un número entero y elimine la primera ocurrencia del número (un número igual) en el arreglo (si existe). Para ello
tendrá que buscar la posición y si está, realizar un corrimiento a izquierda (queda una copia de la última posición
del arreglo en la anteúltima posición).
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class E10 {
    public static final int MAX = 10, MIN_VALOR = 0, MAX_VALOR = 9;

    public static void main(String[] args) {
        int[] arr = new int[MAX];
        int num, pos;

        // Carga e impresión de arreglo original
        cargarArreglo(arr);
        imprimirArreglo(arr);

        // Entrada de datos
        System.out.print("Ingrese un número entero: ");
        num = leerEntero();

        // Búsqueda de posición de elemento
        pos = buscarElemento(arr, num);

        if (pos < MAX) {
            eliminarElemento(arr, pos);
            imprimirArreglo(arr);
        } else {
            System.out.println("El número " + num + " no se encuentra en arr[].");
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
                System.out.println("ERROR. Intentar nuevamente.");
            }
        }

        return num;
    }

    // Carga aleatoria del arreglo con valores entre MIN_VALOR y MAX_VALOR
    public static void cargarArreglo(int[] arr) {
        Random r = new Random();
        for (int pos = 0; pos < MAX; pos++) {
            arr[pos] = r.nextInt(MAX_VALOR - MIN_VALOR + 1) + MIN_VALOR;
        }
    }

    // Retorna la posición de la primera ocurrencia del elemento pasado como argumento
    public static int buscarElemento(int[] arr, int num) {
        int pos = 0;
        while (pos < MAX && arr[pos] != num) {
            pos++;
        }
        return pos;
    }

    // Eliminación de elemento y corrimiento a izquierda
    public static void eliminarElemento(int[] arr, int pos) {
        for (int i = pos; i < MAX - 1; i++) {
            arr[i] = arr[i + 1];
        }
    }

    // Impresión del arreglo
    public static void imprimirArreglo (int[] arr) {
        System.out.print("|  ");
        for (int pos = 0; pos < MAX; pos++) {
            System.out.print(arr[pos] + "  |  ");
        }
        System.out.println();
    }
}
