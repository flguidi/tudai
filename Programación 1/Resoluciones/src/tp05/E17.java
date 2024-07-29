package tp05;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP5 - Ejercicio 17 --- */

/*
Hacer un programa que devuelva la posición de inicio y fin de la anteúltima secuencia de números
distintos de ceros.
*/

import java.util.Random;

public class E17 {
    public static final int MAX = 20, MIN_VALOR = 1, MAX_VALOR = 9;
    public static final double probabilidadNumero = 0.7;

    public static void main(String[] args) {
        int[] vector = new int[MAX];
        int cantSecuencias;

        cargarVectorSecuenciasInt(vector);
        imprimirVector(vector);
        
        cantSecuencias = obtenerCantSecuencias(vector);

        if (cantSecuencias >= 2) {
            // Impresión de índice de inicio y fin de anteúltima secuencia
            imprimirInicioFinSecuencia(vector, cantSecuencias - 1);
        } else {
            System.out.println("Cantidad insuficiente de secuencias.");
        }
    }

    // Carga aleatoria del vector con valores entre MIN_VALOR y MAX_VALOR
    public static void cargarVectorSecuenciasInt(int[] vector) {
        Random r = new Random();
        vector[0] = 0; // Separador al comienzo
        vector[MAX - 1] = 0; // Separador al final

        for (int i = 1; i < MAX - 1; i++) {
            if (probabilidadNumero > r.nextDouble()) {
                vector[i] = r.nextInt(MAX_VALOR - MIN_VALOR + 1) + MIN_VALOR;
            } else {
                vector[i] = 0;
            }
        }
    }

    // Obtención de la cantidad de secuencias del vector
    public static int obtenerCantSecuencias(int[] vector) {
        int inicio = 0, fin = -1, cantSecuencias = 0;
        
        while (inicio < MAX) {
            inicio = obtenerInicioSecuencia(vector, fin + 1);
            if (inicio < MAX) {
                fin = obtenerFinSecuencia(vector, inicio);
                cantSecuencias++;
            }
        }

        System.out.println("Cantidad de secuencias: " + cantSecuencias);
        return cantSecuencias;
    }

    // Obtención del índice del inicio de secuencia
    public static int obtenerInicioSecuencia(int[] vector, int pos) {
        while (pos < MAX && vector[pos] == 0) {
            pos++;
        }
        return pos;
    }

    // Obtención del índice del fin de secuencia
    public static int obtenerFinSecuencia(int[] vector, int pos) {
        while (pos < MAX && vector[pos] != 0) {
            pos++;
        }
        return pos - 1;
    }

    // Impresión del inicio y del fin de una secuencia dada
    public static void imprimirInicioFinSecuencia(int[] vector, int numSecuencia) {
        int inicio = 0, fin = -1;

        for (int i = 0; i < numSecuencia; i++) {
            inicio = obtenerInicioSecuencia(vector, fin + 1);
            fin = obtenerFinSecuencia(vector, inicio);
        }

        System.out.println("Inicio y fin de la secuencia " + numSecuencia + ":");
        System.out.println("Inicio: " + inicio + "\nFin: " + fin);
    }

    // Impresión del vector
    public static void imprimirVector(int[] vector) {
        System.out.print("|");
        for (int i = 0; i < MAX; i++) {
            System.out.print(vector[i] + "|");
        }
        System.out.print("\n");
    }
}
