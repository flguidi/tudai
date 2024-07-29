package tp05;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP5 - Ejercicio 16 --- */

/*
Hacer un programa que devuelva la posición de inicio y fin de la secuencia de números distintos de cero
cuya suma del contenido sea mayor.
*/

import java.util.Random;

public class E16 {
    public static final int MAX = 20, MIN_VALOR = 1, MAX_VALOR = 9;
    public static final double probabilidadNumero = 0.7;

    public static void main(String[] args) {
        int[] vector = new int[MAX];
        int inicio = 0, fin = -1, suma, sumaMayor = 0, inicioSumaMayor = 0, finSumaMayor = -1;

        cargarVectorSecuenciasInt(vector);
        
        while (inicio < MAX) {
            inicio = obtenerInicioSecuencia(vector, fin + 1);
            
            if (inicio < MAX) {
                fin = obtenerFinSecuencia(vector, inicio);
                suma = obtenerSumaSecuencia(vector, inicio, fin);
                if (suma > sumaMayor) {
                    sumaMayor = suma;
                    inicioSumaMayor = inicio;
                    finSumaMayor = fin;
                }
            }
        }        
        
        imprimirVector(vector);
        System.out.println("Suma mayor: " + sumaMayor);
        System.out.println("Inicio de secuencia cuya suma es " + sumaMayor + ": vector[" + inicioSumaMayor + "]");
        System.out.println("Fin de secuencia cuya suma es " + sumaMayor + ": vector[" + finSumaMayor + "]");
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

    public static int obtenerInicioSecuencia(int[] vector, int pos) {
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

    public static int obtenerSumaSecuencia(int[] vector, int inicio, int fin) {
        int suma = 0;
        for (int i = inicio; i <= fin; i++) {
            suma += vector[i];
        }
        return suma;
    }

    public static void imprimirVector(int[] vector) {
        System.out.print("|");
        for (int i = 0; i < MAX; i++) {
            System.out.print(vector[i] + "|");
        }
        System.out.print("\n");
    }
}
