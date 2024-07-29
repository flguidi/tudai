package tp06;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP6 - Ejercicio 15 --- */

/*
Se tiene una matriz de caracteres de tamaño 4x20 de secuencias de caracteres letras minúsculas entre 'a' y 'z'
(por cada fila), separadas por ' ' (espacios). La matriz está precargada, y además cada fila empieza y termina
con uno o más separadores ' '. Hacer un programa que dada la matriz de secuencias de caracteres definida y
precargada elimine todas las secuencias que tienen orden descendente entre sus elementos.
*/

public class E15 {
    public static final int MAXF = 4, MAXC = 20;
    public static final char SEPARADOR = ' ';

    public static void main(String[] args) {
        char[][] matriz = {
            { ' ', 'a', 'b', 'c', 'd', ' ', 'c', 'b', 'a', ' ', ' ', 'a', 'c', 'e', ' ', ' ', ' ', 'b', 'a', ' ' },
            { ' ', ' ', 'a', 'b', 'c', 'd', 'd', ' ', ' ', 'c', 'a', 'a', ' ', 'z', 'y', 'x', ' ', ' ', ' ', ' ' },
            { ' ', ' ', 'n', 'f', 'a', ' ', 'e', 'e', 'f', 'g', 'h', 'i', ' ', ' ', 'a', 'b', 'c', ' ', 'a', ' ' },
            { ' ', 'a', 'a', 'b', 'c', 'd', 'e', ' ', ' ', 'p', 'b', 'a', ' ', 'h', 'b', 'c', ' ', 'a', 'f', ' ' },
        };

        // Se imprime la matriz original
        System.out.println("Matriz original:");
        imprimirMatrizChar(matriz);

        // Para cada fila de la matriz se eliminan las secuencias con orden descendente
        for (int fila = 0; fila < MAXF; fila++) {
            eliminarSecuenciasDescendentes(matriz[fila]);
        }

        // Se imprime la matriz modificada
        System.out.println("Matriz modificada:");
        imprimirMatrizChar(matriz);
    }

    // Elimina las secuencias con orden descendente entre sus elementos
    public static void eliminarSecuenciasDescendentes(char[] vector) {
        int ini = 0, fin = -1, longitudSecuencia;

        while (ini < MAXC) {
            ini = obtenerInicio(vector, fin + 1);
            if (ini < MAXC) {
                fin = obtenerFin(vector, ini);
                longitudSecuencia = fin - ini + 1;
                if (longitudSecuencia > 1 && esDescendente(vector, ini, fin)) {
                    eliminarSecuencia(vector, ini, fin);
                    fin = ini;
                }
            }
        }
    }

    // Verifica si una secuencia dada es de orden descendente
    public static boolean esDescendente(char[] vector, int ini, int fin) {
        while (ini < fin && vector[ini] > vector[ini + 1]) {
            ini++;
        }
        return ini == fin;
    }

    // Elimina una secuencia dada (corrimiento a izquierda)
    public static void eliminarSecuencia(char[] vector, int ini, int fin) {
        for (int i = ini; i <= fin; i++) {
            eliminarElemento(vector, ini);
        }
    }

    // Elimina el elemento en una posición dada (corrimiento a izquierda)
    public static void eliminarElemento(char[] vector, int pos) {
        for (int i = pos; i < MAXC - 1; i++) {
            vector[i] = vector[i + 1];
        }
    }

    // Devuelve la posición de inicio de una secuencia
    public static int obtenerInicio(char[] vector, int pos) {
        while (pos < MAXC && vector[pos] == SEPARADOR) {
            pos++;
        }
        return pos;
    }

    // Devuelve la posición de final de una secuencia
    public static int obtenerFin(char[] vector, int pos) {
        while (pos < MAXC && vector[pos] != SEPARADOR) {
            pos++;
        }
        return pos - 1;
    }

    // Imprime por consola una matriz dada
    public static void imprimirMatrizChar(char[][] matriz) {
        for (int i = 0; i < MAXF; i++) {
            imprimirVectorChar(matriz[i]);
        }
    }

    // Imprime por consola un vector dado
    public static void imprimirVectorChar(char[] vector) {
        System.out.print("| ");
        for (int i = 0; i < MAXC; i++) {
            System.out.print(vector[i] + " | ");
        }
        System.out.println();
    }
}
