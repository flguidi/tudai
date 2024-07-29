package tp06;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP6 - Ejercicio 07 --- */

/*
Hacer un programa que dada una matriz de enteros ordenada creciente por filas de tamaño 4x5 que se encuentra
precargada, solicite al usuario un número entero y una fila, y luego inserte el número en la matriz en la fila
indicada manteniendo su orden.
*/

import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class E07 {
    public static final int MAXF = 4, MAXC = 5, MIN_VALOR = 1, MAX_VALOR = 9;

    public static void main(String[] args) {
        int[][] matriz = new int[MAXF][MAXC];
        int num, fila;

        // Se carga, ordena e imprime la matriz original
        cargarMatrizInt(matriz);

        for (int i = 0; i < MAXF; i++) {
            ordenamientoBurbujeoAscVector(matriz[i]);
        }

        System.out.println("Matriz original, ordenada ascendentemente por filas: ");
        imprimirMatrizInt(matriz);

        // Se solicita al usuario la fila en donde insertar el número ingresado
        System.out.print("Ingrese número de fila: ");
        fila = leerInt();
        
        // Se verifica si el número de fila es correcto
        if (0 <= fila && fila < MAXF) {
            // Se solicita al usuario el número que desea insertar en la matriz
            System.out.print("Ingrese el número a insertar: ");
            num = leerInt();
        
            // Se inserta el número ingresado en la fila indicada
            insertarElementoVectorAsc(matriz[fila], num);
    
            // Se imprime la matriz modificada
            System.out.println("Matriz modificada:");
            imprimirMatrizInt(matriz);
        } else {
            System.out.println("Fila fuera de los límites de la matriz.");

        }
    }

    // Se inserta un número dado en un vector ordenado creciente
    public static void insertarElementoVectorAsc(int[] vector, int num) {
        int pos = 0;

        // Se busca la posición donde colocar el número
        while (pos < MAXC && vector[pos] < num) {
            pos++;
        }

        // Si el número a colocar es el mayor en el vector, reemplaza el último elemento
        if (pos == MAXC) {
            pos--;
        }

        // Corrimiento a derecha e inserción de número
        corrimientoADerechaVector(vector, pos);
        vector[pos] = num;
    }

    // Corrimiento a derecha de elemento en posición dada
    public static void corrimientoADerechaVector(int[] vector, int pos) {
        for (int i = MAXC - 1; i > pos; i--) {
            vector[i] = vector[i - 1];
        }
    }

    // Ordenamiento por burbujeo ascendente de un vector dado
    public static void ordenamientoBurbujeoAscVector(int[] vector) {
        int aux;

        for (int i = 0; i < MAXC; i++) {
            for (int j = 0; j < (MAXC - 1) - i; j++) {
                if (vector[j] > vector[j + 1]) {
                    aux = vector[j];
                    vector[j] = vector[j + 1];
                    vector[j + 1] = aux;        
                }
            }
        }
    }

    // Se obtiene la entrada por teclado de un int
    public static int leerInt() {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        int num = 0;
        boolean esValido = false;

        while (!esValido) {
            try {
                num = Integer.valueOf(entrada.readLine());
                esValido = true;
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        return num;
    }

    // Carga una matriz con valores aleatorios entre MIN_VALOR y MAX_VALOR
    public static void cargarMatrizInt(int[][] matriz) {
        Random r = new Random();
        for (int i = 0; i < MAXF; i++) {
            for (int j = 0; j < MAXC; j++) {
                matriz[i][j] = r.nextInt(MAX_VALOR - MIN_VALOR + 1) + MIN_VALOR;
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
