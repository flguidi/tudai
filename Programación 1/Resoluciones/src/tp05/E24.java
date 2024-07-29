package tp05;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP5 - Ejercicio 24 --- */

/*
Se tiene un arreglo de enteros de tamaño 20 de secuencias de números entre 1 y 9, separadas por 0. El
arreglo está precargado, y además empieza y termina con uno o más separadores 0. Hacer un programa que
permita obtener a través de métodos la posición de inicio y la posición de fin de la secuencia ubicada a
partir de una posición entera ingresada por el usuario. Finalmente, si existen imprima por pantalla ambas
posiciones obtenidas.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class E24 {
    public static final int MAX = 20, MIN_VALOR = 1, MAX_VALOR = 9;
    public static final double PROBABILIDAD_NUMERO = 0.6;

    public static void main(String[] args) {
        int[] arr = new int[MAX];
        int num;

        cargarArreglo(arr);
        imprimirArreglo(arr);

        System.out.print("Ingrese número de posición: ");
        num = leerEntero();

        // Se verifica si el número de posición no excede los límites del arreglo
        if (0 <= num && num < MAX) {
            if (arr[num] == 0) {
                System.out.println("En arr[" + num + "] hay un separador");
            } else {
                buscarInicioYFinSecuencia(arr, num);
            }
        } else {
            System.out.println("arr[" + num + "] excede los límites del arreglo");
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
                System.out.println("Error. Intentar nuevamente.");
            }
        }

        return num;
    }

    public static void cargarArreglo(int[] arr) {
        Random r = new Random();
        arr[0] = 0;
        arr[MAX - 1] = 0;

        for (int i = 1; i < MAX - 1; i++) {
            if (r.nextDouble() < PROBABILIDAD_NUMERO) {
                arr[i] = r.nextInt(MAX_VALOR - MIN_VALOR + 1) + MIN_VALOR;
            } else {
                arr[i] = 0;
            }
        }
    }

    public static void buscarInicioYFinSecuencia(int[] arr, int num) {
        int inicio = 0, fin = -1;

        while (inicio < MAX) {
            inicio = obtenerInicioSecuencia(arr, fin + 1);
            if (inicio < MAX) {
                fin = obtenerFinSecuencia(arr, inicio);
                if (inicio <= num && num <= fin) {
                    System.out.println("Inicio: arr[" + inicio + "]");
                    System.out.println("Fin: arr[" + fin + "]");
                }
            }
        }
    }

    public static int obtenerInicioSecuencia(int[] arr, int pos) {
        while (pos < MAX && arr[pos] == 0) {
            pos++;
        }
        return pos;
    }

    public static int obtenerFinSecuencia(int[] arr, int pos) {
        while (pos < MAX && arr[pos] != 0) {
            pos++;
        }
        return pos - 1;
    }

    public static void imprimirArreglo(int[] arr) {
        System.out.print("|");
        for (int i = 0; i < MAX; i++) {
            System.out.print(arr[i] + "|");
        }
        System.out.print("\n");
    }
}
