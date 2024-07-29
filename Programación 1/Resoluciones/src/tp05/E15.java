package tp05;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP5 - Ejercicio 15 --- */

/* Hacer un programa que devuelva la posición de inicio y fin de la primera secuencia de números distinta de ceros. */

import java.util.Random;

public class E15 {
    public static final int MAX = 20, MIN_VALOR = 1, MAX_VALOR = 9;
    public static final double probabilidadNumero = 0.8;

    public static void main(String[] args) {
        int[] vector = new int[MAX];
        int inicio, fin;

        cargarVectorSecuenciasInt(vector);
        inicio = obtenerInicioSecuencia(vector);
        
        if (inicio < MAX) {
            fin = obtenerFinSecuencia(vector, inicio);    
            imprimirVectorInt(vector);
            System.out.println("Inicio: " + inicio + "\nFin: " + fin);
        } else {
            System.out.println("No hay secuencias en el vector.");
        }
    }

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

    public static int obtenerInicioSecuencia(int[] vector) {
        int pos = 0;
        while (pos < MAX && vector[pos] == 0) {
            pos++;
        }
        return pos;
    }

    public static int obtenerFinSecuencia(int[] vector, int pos) {
        while (pos < MAX && vector[pos] != 0) {
            pos++;
        }
        return pos - 1;
    }

    public static void imprimirVectorInt(int[] vector) {
        System.out.print("Vector de secuencias int:\n|");
        for (int i = 0; i < MAX; i++) {
            System.out.print(vector[i] + "|");
        }
        System.out.print("\n");
    }
}
