package tp05;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP5 - Ejercicio 04 --- */

/*
Buscar un elemento en un arreglo de caracteres ya cargado de tamaño 10 y mostrar la/s posición/es del elemento,
en caso de no estar indicarlo también.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class E04 {
    public static final int MAX = 10;

    public static void main(String[] args) {
        char[] arr = new char[MAX];
        char caracter;

        cargarArreglo(arr);
        imprimirArreglo(arr);

        System.out.print("Ingrese un carácter: ");
        caracter = leerCaracter();

        buscarCaracterEnArreglo(arr, caracter);
    }

    public static char leerCaracter() {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        char caracter = ' ';
        boolean esValido = false;

        while (!esValido) {
            try {
                caracter = entrada.readLine().charAt(0);
                esValido = true;
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        return caracter;
    }

    public static void cargarArreglo(char[] arr) {
        Random r = new Random();
        for (int pos = 0; pos < MAX; pos++) {
            arr[pos] = (char) (r.nextInt(26) + 'a');
        }
    }

    public static void imprimirArreglo(char[] arr) {
        System.out.print("|  ");
        for (int pos = 0; pos < MAX; pos++) {
            System.out.print(arr[pos] + "  |  ");
        }
        System.out.println();
    }

    public static void buscarCaracterEnArreglo(char[] arr, char caracter) {
        int contador = 0;
        for (int pos = 0; pos < MAX; pos++) {
            if (arr[pos] == caracter) {
                System.out.println("'" + caracter + "' se encuentra en arr[" + pos + "]");
                contador++;
            }
        }

        if (contador == 0) {
            System.out.println("'" + caracter + "' no se encuentra en arr[]");
        }
    }
}
