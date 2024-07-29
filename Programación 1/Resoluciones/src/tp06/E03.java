package tp06;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP6 - Ejercicio 03 --- */

/*
Hacer un programa que dada una matriz de enteros de tamaño 5x10 que se encuentra precargada, solicite al
usuario una posición fila, columna y realice un corrimiento a izquierda
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class E03 {
    public static final int MAXF = 5, MAXC = 10, MIN_VALOR = 0, MAX_VALOR = 9;

    public static void main(String[] args) {
        int[][] matriz = new int[MAXF][MAXC];
        int fila, columna;

        cargarMatriz(matriz);
        imprimirMatriz(matriz);

        System.out.print("Ingrese número de fila (0 a " + (MAXF - 1) + "): ");
        fila = leerEntero();
        System.out.print("Ingrese número de columna (0 a " + (MAXC - 1) + "): ");
        columna = leerEntero();

        if ((0 <= fila && fila < MAXF) && (0 <= columna && columna < MAXC)) {
            eliminarElemento(matriz[fila], columna);
            imprimirMatriz(matriz);
        } else {
            System.out.println("Índice fuera de rango");
        }
    }

    // Elimina un elemento dado y realiza un corrimiento a izquierda
    public static void eliminarElemento(int[] fila, int columna) {
        for (;columna < MAXC - 1; columna++) {
            fila[columna] = fila[columna + 1];
        }
        fila[MAXC - 1] = 0;
    }

    // Obtiene un número entero ingresado por teclado
    public static int leerEntero() {
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
