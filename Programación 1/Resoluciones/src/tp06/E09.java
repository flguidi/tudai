package tp06;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP6 - Ejercicio 09 --- */

/*
Hacer un programa que dada una matriz de enteros de tamaño 4x5 que se encuentra precargada, solicite al usuario
el ingreso de una fila y dos números enteros (columnas de la matriz), y ordene de forma creciente la matriz en
la fila indicada entre las dos posiciones columnas ingresadas.
*/

import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class E09 {
    public static final int MAXF = 4, MAXC = 5, MIN_VALOR = 1, MAX_VALOR = 9;

    public static void main(String[] args) {
        int[][] matriz = new int[MAXF][MAXC];
        int fila, inicio, fin;

        // Se carga e imprime la matriz original
        cargarMatrizInt(matriz);

        System.out.println("Matriz original: ");
        imprimirMatrizInt(matriz);

        // Se solicita al usuario la fila en donde buscar el número ingresado
        System.out.print("Ingrese número de fila: ");
        fila = leerInt();

        // Se verifica si el número de fila es correcto
        if (0 <= fila && fila < MAXF) {
            // Se solicita al usuario el número de columnas de inicio y fin
            System.out.print("Ingrese número de columna de inicio: ");
            inicio = leerInt();
            System.out.print("Ingrese número de columna de fin: ");
            fin = leerInt();

            if (inicio < 0) {
                inicio = 0;
            }
            if (fin >= MAXC) {
                fin = MAXC - 1;
            }

            // Se ordena ascendentemente el subvector dado
            ordenamientoAscSubvector(matriz[fila], inicio, fin);

            // Se imprime la matriz modificada
            System.out.println("Matriz modificada:");
            imprimirMatrizInt(matriz);
        } else {
            System.out.println("Fila fuera de los límites de la matriz.");
        }
    }

    // Ordenamiento por burbujeo ascendente de un subvector entre dos posiciones dadas
    public static void ordenamientoAscSubvector(int[] vector, int inicio, int fin) {
        int aux;

        for (int i = inicio; i <= fin; i++) {
            for (int j = inicio; j < fin + inicio - i; j++) {
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
