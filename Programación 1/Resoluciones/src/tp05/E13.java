package tp05;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP5 - Ejercicio 13 --- */

/* Hacer un programa que inserte un elemento en un arreglo (ordenado decrecientemente) de tamaño 10. */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class E13 {
    public static final int MAX = 10, MIN_VALOR = 0, MAX_VALOR = 9;

    public static void main(String[] args) {
        int[] vector = new int[MAX];
        int num, pos;

        // Carga aleatoria del vector
        cargarVector(vector);
        
        // Método de ordenamiendo decreciente
        ordenarVectorDecr(vector);

        // Impresión del vector original
        System.out.println("Vector original:");
        imprimirVector(vector);

        // Entrada de datos
        System.out.print("Ingrese un número entero para insertar al vector ordenado: ");
        num = leerEntero();
        
        // Obtención de posición de número a colocar en vector ordenado
        pos = obtenerPosicionVectorDecr(vector, num);

        // Inserción de elemento 
        insertarElemento(vector, pos, num);

        // Impresión de vector modificado
        System.out.println("Vector modificado:");
        imprimirVector(vector);
    }

    // Lectura de número entero
    public static int leerEntero() {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        int num = 0;
        boolean esValido = false;

        while (!esValido) {
            try {
                num = Integer.valueOf(entrada.readLine());
                esValido = true;
            } catch (Exception e) {
                System.out.println("Error. Intentar nuevamente.");
            }
        }

        return num;
    }

    // Carga aleatoria de vector con valores entre MIN_VALOR y MAX_VALOR
    public static void cargarVector(int[] vector) {
        Random r = new Random();
        for (int i = 0; i < MAX; i++) {
            vector[i] = r.nextInt(MAX_VALOR - MIN_VALOR + 1) + MIN_VALOR;
        }
    }

    // Ordenamiento decreciente del vector por seleccion
    public static void ordenarVectorDecr(int[] vector) {
        int mayor, pos;
        
        for (int i = 0; i < MAX - 1; i++) {
            mayor = vector[i];
            pos = i;

            for (int j = i + 1; j < MAX; j++) {
                if (vector[j] > mayor) {
                    mayor = vector[j];
                    pos = j;
                }
            }

            if (pos != i) {
                int aux = vector[i];
                vector[i] = vector[pos];
                vector[pos] = aux;
            }
        }
    }

    // Búsqueda de posición para inserción de elemento en vector ordenado
    public static int obtenerPosicionVectorDecr(int[] vector, int num) {
        int pos = 0;
        while (pos < MAX && vector[pos] > num) {
            pos++;
        }
        return pos;
    }

    // Inserción de elemento y corrimiento a derecha
    public static void insertarElemento(int[] vector, int pos, int num) {
        for (int i = MAX - 1; i > pos; i--) {
            vector[i] = vector[i - 1];
        }
        vector[pos] = num;
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
