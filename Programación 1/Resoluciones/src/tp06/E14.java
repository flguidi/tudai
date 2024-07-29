package tp06;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP6 - Ejercicio 14 --- */

/*
Se tiene una matriz de caracteres de tamaño 4x20 de secuencias de caracteres letras minúsculas entre 'a' y 'z'
(por cada fila), separadas por ' ' (espacios). La matriz está precargada, y además cada fila empieza y termina con
uno o más separadores ' '. Hacer un programa que elimine de cada fila todas las ocurrencias de una secuencia patrón
dada por un arreglo de caracteres de tamaño igual al tamaño de columnas de la matriz (sólo tiene esa secuencia con
separadores al inicio y al final). Al eliminar en cada fila se pierden los valores haciendo los corrimientos.
*/

public class E14 {
    public static final int MAXF = 4, MAXC = 20;
    public static final char SEPARADOR = ' ';

    public static void main(String[] args) {
        char[][] matriz = {
            { ' ', 'a', 'b', 'c', 'd', ' ', 'a', 'b', 'c', ' ', ' ', 'a', 'c', 'd', ' ', ' ', ' ', 'a', 'b', ' ' },
            { ' ', ' ', 'a', 'b', 'c', 'd', 'e', ' ', ' ', 'a', 'b', 'c', ' ', 'a', 'b', 'c', ' ', ' ', ' ', ' ' },
            { ' ', ' ', 'a', 'b', 'c', ' ', 'e', 'f', 'a', 'a', 'b', 'c', ' ', ' ', 'a', 'b', 'c', ' ', 'a', ' ' },
            { ' ', 'a', 'a', 'b', 'c', 'd', 'e', ' ', ' ', 'a', 'b', 'c', ' ', 'a', 'b', 'c', ' ', 'a', 'f', ' ' },
        };

        char[] vectorPatron = { ' ', ' ', 'a', 'b', 'c', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',
                ' ', ' ', ' ' };

        int iniP = 0, finP = 0;

        // Se imprimen la matriz y el vector patrón
        System.out.println("Matriz original: ");
        imprimirMatrizChar(matriz);
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("Vector patrón: ");
        imprimirVectorChar(vectorPatron);
        System.out.println("---------------------------------------------------------------------------------");

        // Se obtienen los índices de inicio y fin del patrón
        iniP = obtenerInicio(vectorPatron, iniP);
        finP = obtenerFin(vectorPatron, iniP);

        // Para cada fila se busca el patrón y, de encontrarlo, se elimina
        for (int fila = 0; fila < MAXF; fila++) {
            eliminarPatronEnVector(matriz[fila], vectorPatron, iniP, finP);
        }

        // Se imprime la matriz modificada
        System.out.println("Matriz modificada:");
        imprimirMatrizChar(matriz);
    }

    // Elimina cada aparición de un patrón dado en un vector
    public static void eliminarPatronEnVector(char[] vectorFila, char[] vectorPatron, int iniP, int finP) {
        int iniS = 0, finS = -1, largoSecuencia;
        int largoPatron = finP - iniP + 1;
        while (iniS < MAXC) {
            iniS = obtenerInicio(vectorFila, finS + 1);
            if (iniS < MAXC) {
                finS = obtenerFin(vectorFila, iniS);
                largoSecuencia = finS - iniS + 1;
                if (largoSecuencia == largoPatron && esPatron(vectorFila, iniS, finS, vectorPatron, iniP)) {
                    eliminarSecuencia(vectorFila, iniS, finS);
                    finS = iniS;
                }
            }
        }
    }

    // Elimina una secuencia dada, generando un corrimiento a izquierda
    public static void eliminarSecuencia(char[] vector, int ini, int fin) {
        for (int i = ini; i <= fin; i++) {
            eliminarElemento(vector, ini);
        }
    }

    // Elimina el elemento en una posición dada, generando un corrimiento a izquierda
    public static void eliminarElemento(char[] vector, int pos) {
        for (int i = pos; i < MAXC - 1; i++) {
            vector[i] = vector[i + 1];
        }
    }

    // Verifica si un subvector dado es igual a un patrón
    public static boolean esPatron(char[] vector, int iniS, int finS, char[] patron, int iniP) {
        while (iniS <= finS && vector[iniS] == patron[iniP]) { 
            iniS++;
            iniP++;
        }
        return iniS > finS;
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
