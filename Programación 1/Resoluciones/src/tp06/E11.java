package tp06;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP6 - Ejercicio 11 --- */

/*
Se tiene una matriz de enteros de tamaño 4x20 de secuencias de números entre 1 y 9 (por cada fila), separadas por 0.
La matriz está precargada, y además cada fila empieza y termina con uno o más separadores 0. Hacer un programa que
permita encontrar por cada fila la posición de inicio y fin de la secuencia cuya suma de valores sea mayor.
*/

import java.util.Random;

public class E11 {
    public static final int MAXF = 4, MAXC = 20, MIN_VALOR = 1, MAX_VALOR = 9, SEPARADOR = 0;
    public static final double PROBABILIDAD_ELEMENTO = 0.8;

    public static void main(String[] args) {
        int[][] matriz = new int[MAXF][MAXC];
        int inicioSumaMayor = 0, finSumaMayor = 0;

        // Se carga la matriz con secuencias numéricas y se imprime
        cargarMatrizSecuenciasInt(matriz);
        imprimirMatrizInt(matriz);

        // Se busca para cada fila el índice de inicio y fin de la secuencia con suma mayor
        for (int i = 0; i < MAXF; i++) {
            inicioSumaMayor = obtenerInicioSecuenciaSumaMayor(matriz[i]);
            finSumaMayor = obtenerFin(matriz[i], inicioSumaMayor);
            
            System.out.println("---------------------");
            System.out.println("Fila " + i + ":");
            System.out.println("Inicio: " + inicioSumaMayor);
            System.out.println("Fin: " + finSumaMayor);
            System.out.println("---------------------");
        }
    }

    // Devuelve el inicio de la secuencia de mayor suma
    public static int obtenerInicioSecuenciaSumaMayor(int[] vector) {
        int inicio = 0, fin = -1, inicioSumaMayor = 0, suma = 0, sumaMayor = 0;

        while (inicio < MAXC) {
            inicio = obtenerInicio(vector, fin + 1);
            if (inicio < MAXC) {
                fin = obtenerFin(vector, inicio);
                suma = obtenerSumaSecuencia(vector, inicio, fin);
                if (suma > sumaMayor) {
                    sumaMayor = suma;
                    inicioSumaMayor = inicio;
                }
            }
        }

        return inicioSumaMayor;
    }

    // Devuelve la suma de los elementos de una secuencia
    public static int obtenerSumaSecuencia(int[] vector, int inicio, int fin) {
        int suma = 0;
        for (int i = inicio; i <= fin; i++) {
            suma += vector[i];
        }
        return suma;
    }

    // Devuelve la posición de inicio de una secuencia
    public static int obtenerInicio(int[] vector, int pos) {
        while (pos < MAXC && vector[pos] == SEPARADOR) {
            pos++;
        }
        return pos;
    }

    // Devuelve la posición de final de una secuencia
    public static int obtenerFin(int[] vector, int pos) {
        while (pos < MAXC && vector[pos] != SEPARADOR) {
            pos++;
        }
        return pos - 1;
    }

    // Carga una matriz con valores aleatorios entre MIN_VALOR y MAX_VALOR
    public static void cargarMatrizSecuenciasInt(int[][] matriz) {
        Random r = new Random();

        for (int i = 0; i < MAXF; i++) {
            // Se coloca al comienzo y final de cada fila un separador
            matriz[i][0] = SEPARADOR;
            matriz[i][MAXC - 1] = SEPARADOR;

            for (int j = 1; j < MAXC - 1; j++) {
                if (PROBABILIDAD_ELEMENTO > r.nextDouble()) {
                    matriz[i][j] = r.nextInt(MAX_VALOR - MIN_VALOR + 1) + MIN_VALOR;
                } else {
                    matriz[i][j] = SEPARADOR;
                }
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
