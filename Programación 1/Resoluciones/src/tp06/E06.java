package tp06;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP6 - Ejercicio 06 --- */

/*
Hacer un programa que dada una matriz de enteros de tamaño 5x10 que se encuentra precargada, solicite al
usuario un número entero y elimine todas las ocurrencia de número en la matriz si existe. Mientras exista
(en cada iteración tiene que buscar la posición fila y columna) tendrá que usar dicha posición para realizar
un corrimiento a izquierda (quedarán tantas copias de la última posición de cada fila como cantidad de
ocurrencias del número). Tener en cuenta, como se hizo en arreglos, si el elemento a eliminar es el último
de alguna fila de la matriz.
*/

import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class E06 {
    public static final int MAXF = 5, MAXC = 10, MIN_VALOR = 1, MAX_VALOR = 9;

    public static void main(String[] args) {
        int[][] matriz = new int[MAXF][MAXC];
        int num;

        // Se carga e imprime la matriz original
        cargarMatrizInt(matriz);
        System.out.println("Matriz original: ");
        imprimirMatrizInt(matriz);

        // Se solicita al usuario el número que desea eliminar de la matriz
        System.out.print("Ingrese el número que desea eliminar de la matriz: ");
        num = leerInt();

        // Se eliminan las ocurrencias, fila por fila
        for (int i = 0; i < MAXF; i++) {
            eliminarOcurrenciasVectorInt(matriz[i], num);
        }

        // Se imprime la matriz modificada
        imprimirMatrizInt(matriz);
    }

    // Se eliminan las ocurrencias de un número en un vector
    public static void eliminarOcurrenciasVectorInt(int[] vector, int num) {
        int pos = 0;
        while (pos < MAXC) {
            if (vector[pos] == num) {
                eliminarElementoVectorInt(vector, pos);
            } else {
                pos++;
            }
        }
    }

    // Se elimina el elemento de un vector en una posición dada, colocando al final un 0
    public static void eliminarElementoVectorInt(int[] vector, int pos) {
        for (int i = pos; i < MAXC - 1; i++) {
            vector[i] = vector[i + 1];
        }
        vector[MAXC - 1] = 0;
    }

    // Se obtiene la entrada por teclado de un int
    public static int leerInt() {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        int num = 0;
        boolean esValido = false;

        while (!esValido) {
            try {
                num = Integer.valueOf(entrada.readLine());
                esValido = true;
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        return num;
    }

    // Carga una matriz con valores aleatorios entre MIN_VALOR y MAX_VALOR
    public static void cargarMatrizInt(int[][] matriz) {
        Random r = new Random();
        for (int i = 0; i < MAXF; i++) {
            for (int j = 0; j < MAXC; j++) {
                matriz[i][j] = r.nextInt(MAX_VALOR - MIN_VALOR + 1) + MIN_VALOR;
            }
        }
    }

    // Imprime por consola una matriz dada
    public static void imprimirMatrizInt(int[][] matriz) {
        for (int i = 0; i < MAXF; i++) {
            System.out.print("| ");
            for (int j = 0; j < MAXC; j++) {
                System.out.print(matriz[i][j] + " | ");
            }
            System.out.println();
        }
    }
}
