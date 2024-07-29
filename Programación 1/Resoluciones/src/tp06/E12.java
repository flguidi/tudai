package tp06;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP6 - Ejercicio 12 --- */

/*
Se tiene una matriz de caracteres de tamaño 4x20 de secuencias de caracteres letras minúsculas entre 'a' y 'z'
(por cada fila), separadas por ' ' (espacios). La matriz está precargada, y además cada fila empieza y termina
con uno o más separadores ' '. Hacer un programa que permita encontrar por cada fila la posición de inicio y fin
de la anteúltima secuencia (considerar comenzar a buscarla a partir de la última posición de la fila).
*/

import java.util.Random;

public class E12 {
    public static final int MAXF = 4, MAXC = 20;
    public static final char SEPARADOR = ' ';
    public static final double PROBABILIDAD_ELEMENTO = 0.9;

    public static void main(String[] args) {
        char[][] matriz = new char[MAXF][MAXC];
        int inicioAnteultimaSec, finAnteultimaSec;

        cargarMatrizSecuenciasChar(matriz);
        imprimirMatrizChar(matriz);

        // Se obtiene para cada fila el inicio y fin de la anteúltima secuencia
        for (int i = 0; i < MAXF; i++) {
            finAnteultimaSec = obtenerFinAnteultimaSec(matriz[i]);
            inicioAnteultimaSec = obtenerInicioInv(matriz[i], finAnteultimaSec);

            System.out.println("----------------------------------------------");
            if (finAnteultimaSec > 0) {
                System.out.println("Anteúltima secuencia de la fila " + i + ":");
                System.out.println("Inicio: " + inicioAnteultimaSec);
                System.out.println("Fin: " + finAnteultimaSec);
            } else {
                System.out.println("La fila " + i + " no tiene como mínimo dos secuencias.");
            }
            System.out.println("----------------------------------------------");
        }
    }

    // Devuelve el índice de fin de la anteúltima secuencia de un vector
    public static int obtenerFinAnteultimaSec(char[] vector) {
        int fin = MAXC - 1, inicio = MAXC;
        for(int i = 0; i < 2; i++) {
            fin = obtenerFinInv(vector, inicio - 1);
            inicio = obtenerInicioInv(vector, fin);
        }
        return fin;
    }

    // Devuelve la posición de inicio de una secuencia
    public static int obtenerFinInv(char[] vector, int pos) {
        while (pos >= 0 && vector[pos] == SEPARADOR) {
            pos--;
        }
        return pos;
    }

    // Devuelve la posición de final de una secuencia
    public static int obtenerInicioInv(char[] vector, int pos) {
        while (pos >= 0 && vector[pos] != SEPARADOR) {
            pos--;
        }
        return pos + 1;
    }

    // Carga una matriz con valores aleatorios entre MIN_VALOR y MAX_VALOR
    public static void cargarMatrizSecuenciasChar(char[][] matriz) {
        Random r = new Random();

        for (int i = 0; i < MAXF; i++) {
            // Se coloca al comienzo y final de cada fila un separador
            matriz[i][0] = SEPARADOR;
            matriz[i][MAXC - 1] = SEPARADOR;

            for (int j = 1; j < MAXC - 1; j++) {
                if (PROBABILIDAD_ELEMENTO > r.nextDouble()) {
                    matriz[i][j] = (char) (r.nextInt(26) + 'a');
                } else {
                    matriz[i][j] = SEPARADOR;
                }
            }
        }
    }

    // Imprime por consola una matriz dada
    public static void imprimirMatrizChar(char[][] matriz) {
        for (int i = 0; i < MAXF; i++) {
            System.out.print("| ");
            for (int j = 0; j < MAXC; j++) {
                System.out.print(matriz[i][j] + " | ");
            }
            System.out.println();
        }
    }
}
