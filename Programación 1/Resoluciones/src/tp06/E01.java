package tp06;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP6 - Ejercicio 01 --- */

/*
Hacer un programa que dada una matriz de enteros de tamaño 5x10 que se encuentra precargada, invierta el orden
del contenido por fila. Este intercambio no se debe realizar de manera explícita, hay que hacer un método que
incluya una iteración de intercambio.
*/
import java.util.Random;

public class E01 {
    public static final int MAXF = 5, MAXC = 10, MIN_VALOR = 0, MAX_VALOR = 9;

    public static void main(String[] args) {
        int[][] matriz = new int[MAXF][MAXC];

        cargarMatriz(matriz);
        System.out.println("Matriz original:");
        imprimirMatriz(matriz);

        for (int fila = 0; fila < MAXF; fila++) {
            invertirFila(matriz[fila]);
        }

        System.out.println("Matriz con filas invertidas:");
        imprimirMatriz(matriz);
    }

    // Invierte una fila dada
    public static void invertirFila(int[] fila) {
        int aux;
        
        for (int columna = 0; columna < MAXC / 2; columna++) {
            aux = fila[columna];
            fila[columna] = fila [MAXC - columna - 1];
            fila[MAXC - columna - 1] = aux;
        }
    }

    // Carga una matriz con valores aleatorios entre MIN_VALOR y MAX_VALOR
    public static void cargarMatriz(int[][] matriz) {
        Random r = new Random();
        for (int fila = 0; fila < MAXF; fila++) {
            for (int columna = 0; columna < MAXC; columna++) {
                matriz[fila][columna] = r.nextInt(MAX_VALOR - MIN_VALOR + 1) + MIN_VALOR;
            }
        }
    }

    // Imprime por consola una matriz dada
    public static void imprimirMatriz(int[][] matriz) {
        for (int fila = 0; fila < MAXF; fila++) {
            System.out.print("| ");
            for (int columna = 0; columna < MAXC; columna++) {
                System.out.print(matriz[fila][columna] + " | ");
            }
            System.out.println();
        }
    }
}
