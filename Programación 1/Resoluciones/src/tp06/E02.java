package tp06;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP6 - Ejercicio 02 --- */

/*
Hacer un programa que dada una matriz de enteros de tamaño 5x10 que se encuentra precargada, obtenga la
cantidad de números pares que tiene y la imprima.
*/

import java.util.Random;

public class E02 {
    public static final int MAXF = 5, MAXC = 10, MIN_VALOR = 0, MAX_VALOR = 9;

    public static void main(String[] args) {
        int[][] matriz = new int[MAXF][MAXC];
        int cantPares;

        cargarMatriz(matriz);
        imprimirMatriz(matriz);
        cantPares = contarPares(matriz);
        System.out.println("Cantidad de números pares en la matriz: " + cantPares);
    }

    // Devuelve la cantidad de números pares dentro de una matriz dada
    public static int contarPares(int[][] matriz) {
        int cantPares = 0;
        
        for (int fila = 0; fila < MAXF; fila++) {
            for (int columna = 0; columna < MAXC; columna++) {
                if (matriz[fila][columna] % 2 == 0) {
                    cantPares++;
                }
            }
        }

        return cantPares;
    }

    // Carga una matriz con valores aleatorios entre MIN_VALOR y MAX_VALOR
    public static void cargarMatriz(int[][] matriz) {
        Random r = new Random();
        for (int fila = 0; fila < MAXF; fila++) {
            for (int columna = 0; columna < MAXC; columna++) {
                matriz[fila][columna] = r.nextInt(MAX_VALOR - MIN_VALOR + 1) + MIN_VALOR;
            }
        }
    }

    // Imprime por consola una matriz dada
    public static void imprimirMatriz(int[][] matriz) {
        for (int fila = 0; fila < MAXF; fila++) {
            System.out.print("| ");
            for (int columna = 0; columna < MAXC; columna++) {
                System.out.print(matriz[fila][columna] + " | ");
            }
            System.out.println();
        }
    }
}
