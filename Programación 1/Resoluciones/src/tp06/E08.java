package tp06;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP6 - Ejercicio 08 --- */

/*
Hacer un programa que dada una matriz de enteros ordenada creciente por filas de tamaño 4x5 que se encuentra
precargada, solicite al usuario un número entero y una fila, y elimine la primera ocurrencia de número en la
fila indicada si existe.
*/

import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class E08 {
    public static final int MAXF = 4, MAXC = 5, MIN_VALOR = 1, MAX_VALOR = 9;

    public static void main(String[] args) {
        int[][] matriz = new int[MAXF][MAXC];
        int num, fila, posPrimeraOcurrencia;

        // Se carga, ordena e imprime la matriz original
        cargarMatrizInt(matriz);

        for (int i = 0; i < MAXF; i++) {
            ordenamientoBurbujeoAscVector(matriz[i]);
        }

        System.out.println("Matriz original, ordenada ascendentemente por filas: ");
        imprimirMatrizInt(matriz);

        // Se solicita al usuario la fila en donde buscar el número ingresado
        System.out.print("Ingrese número de fila: ");
        fila = leerInt();
        
        // Se verifica si el número de fila es correcto
        if (0 <= fila && fila < MAXF) {
            // Se solicita al usuario el número que desea eliminar de la matriz
            System.out.print("Ingrese el número que desee eliminar: ");
            num = leerInt();

            posPrimeraOcurrencia = buscarPrimeraOcurrenciaVector(matriz[fila], num);

            if (posPrimeraOcurrencia < MAXC) {
                // Se elimina el número dado
                eliminarElementoVector(matriz[fila], posPrimeraOcurrencia);
                
                // Se imprime la matriz modificada
                System.out.println("Matriz modificada:");
                imprimirMatrizInt(matriz);
            } else {
                System.out.println("El número " + num + " no se encuentra en la fila " + fila + ".");
            }
        } else {
            System.out.println("Fila fuera de los límites de la matriz.");
        }
    }

    // Devuelve la posición de un elemento dado. Si no se encuentra, devuelve el largo del vector.
    public static int buscarPrimeraOcurrenciaVector(int[] vector, int num) {
        int pos = 0;
        while (pos < MAXC && vector[pos] != num) {
            pos++;
        }

        return pos;
    }

    // Elimina el elemento en la posición dada, realizando un corrimiento a izquierda
    public static void eliminarElementoVector(int[] vector, int pos) {
        for (int i = pos; i < MAXC - 1; i++) {
            vector[i] = vector[i + 1];
        }

        // Se coloca un 0 en la última posición
        vector[MAXC - 1] = 0;
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
