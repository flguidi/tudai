package tp05;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP5 - Ejercicio 14 --- */

/* Hacer un programa que elimine los valores pares en un arreglo de tamaño 10. */

import java.util.Random;

public class E14 {
    public static final int MAX = 10, MIN_VALOR = 1, MAX_VALOR = 9;

    public static void main(String[] args) {
        int[] vector = new int[MAX];

        cargarVector(vector);
        imprimirVector(vector);
        eliminarParesVector(vector);
        imprimirVector(vector);
    }

    // Carga aleatoria de vector con valores entre MIN_VALOR y MAX_VALOR
    public static void cargarVector(int[] vector) {
        Random r = new Random();
        
        for (int i = 0; i < MAX; i++) {
            vector[i] = r.nextInt(MAX_VALOR - MIN_VALOR + 1) + MIN_VALOR;
        }
    }

    // Eliminación de números pares en vector
    public static void eliminarParesVector(int[] vector) {
        int pos = 0;
        int elementos = MAX;

        while (pos < elementos) {
            if (vector[pos] % 2 == 0) {
                eliminarElemento(vector, pos, elementos);
                elementos--;
            } else {
                pos++;
            }
        }
    }

    // Eliminación de elemento y corrimiento a izquierda
    public static void eliminarElemento (int[] vector, int pos, int elementos) {
        for (int i = pos; i < elementos - 1; i++) {
            vector[i] = vector[i + 1];
        }
        vector[elementos - 1] = 0; // Se vacía última posición
    }

    // Impresión de vector
    public static void imprimirVector(int[] vector) {
        System.out.print("|  ");
        for (int i = 0; i < MAX; i++) {
            System.out.print(vector[i] + "  |  ");
        }
        System.out.println();
    }
}
