package tp05;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP5 - Ejercicio 18 --- */

/* Hacer un programa que devuelva la posición de inicio y de fin de la secuencia de mayor tamaño. */

import java.util.Random;

public class E18 {
    public static final int MAX = 20, MIN_VALOR = 1, MAX_VALOR = 9;
    public static final double probabilidadNumero = 0.7;

    public static void main(String[] args) {
        int[] vector = new int[MAX];
        int inicio = 0, fin = -1, cantElementos, cantMayorElementos = 0, inicioSecuenciaMayor = 0, finSecuenciaMayor = 0;

        cargarVectorSecuenciasInt(vector);
        imprimirVector(vector);
        
        while (inicio < MAX) {
            inicio = obtenerInicioSecuencia(vector, fin + 1);
            if (inicio < MAX) {
                fin = obtenerFinSecuencia(vector, inicio);
                cantElementos = fin - inicio + 1;
                if (cantElementos > cantMayorElementos) {
                    cantMayorElementos = cantElementos;
                    inicioSecuenciaMayor = inicio;
                    finSecuenciaMayor = fin;
                }
            }
        }

        System.out.println("Cantidad de elementos de secuencia mayor: " + cantMayorElementos);
        System.out.println("Posición de inicio de secuencia mayor: " + inicioSecuenciaMayor);
        System.out.println("Posición de fin de secuencia mayor: " + finSecuenciaMayor);
    }

    // Carga aleatoria de vector con valores entre MIN_VALOR y MAX_VALOR
    public static void cargarVectorSecuenciasInt(int[] vector) {
        Random r = new Random();
        vector[0] = 0;
        vector[MAX - 1] = 0;

        for (int i = 1; i < MAX - 1; i++) {
            if (probabilidadNumero > r.nextDouble()) {
                vector[i] = r.nextInt(MAX_VALOR - MIN_VALOR + 1) + MIN_VALOR; 
            } else {
                vector[i] = 0;
            }
        }
    }

    // Obtención de posición de inicio de secuencia
    public static int obtenerInicioSecuencia(int[] vector, int pos) {
        while (pos < MAX && vector[pos] == 0) {
            pos++;
        }
        return pos;
    }

    // Obtención de posición de fin de secuencia 
    public static int obtenerFinSecuencia(int[] vector, int pos) {
        while (pos < MAX && vector[pos] != 0) {
            pos++;
        }
        return pos - 1;
    }

    // Impresión de vector
    public static void imprimirVector(int[] vector) {
        System.out.print("|");
        for (int i = 0; i < MAX; i++) {
            System.out.print(vector[i] + "|");
        }
        System.out.print("\n");
    }
}
