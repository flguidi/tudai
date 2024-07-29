package tp06;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP6 - Bonus Track 02d --- */

/*
Dado el siguiente enunciado, corregir el código propuesto:

Hacer un programa que dada una matriz de enteros de tamaño 10x10 (precargada), imprimir por pantalla el
promedio de cada una de sus columnas.

public class BonusTrack02d {
    public static final int MAXFILA = 10, MAXCOLUMNA = 10;

    public static void main (String[] args) {
        int[][] matriz = new int[MAXFILA][MAXCOLUMNA];
        imprimirPromediosMatriz(matriz);
    } 
    
    public void imprimirPromediosMatriz (int[][] mat) {
        int promedio;
        for (int col = 0; col < MAXCOLUMNA; col++) {
            System.out.println("EL promedio de la columna " + col + " es " + obtenerPromedioColumna(mat, col));
            promedio = 0;
        }
    } 
    
    public int obtenerPromedioColumna(int[][] mat, int col) {
        int promedio, suma = 0;
        for (int fila = 0; fila < MAXFILA; fila++) {
            suma += mat[fila][col] / MAXCOLUMNA;
        } 
        
        return promedio;
    }
} 
*/

public class BT02d {
    public static final int MAXFILA = 10, MAXCOLUMNA = 10;

    public static void main(String[] args) {
        int[][] matriz = new int[MAXFILA][MAXCOLUMNA];
        imprimirPromediosMatriz(matriz);
    }

    public static void imprimirPromediosMatriz(int[][] mat) {
        int promedio;
        for (int col = 0; col < MAXCOLUMNA; col++) {
            promedio = obtenerPromedioColumna(mat, col);
            System.out.println("El proemdio de la columna " + col + " es " + promedio);
        }
    }

    public static int obtenerPromedioColumna(int[][] mat, int col) {
        int promedio, suma = 0;
        for (int fila = 0; fila < MAXFILA; fila++) {
            suma += mat[fila][col];
        }

        promedio = suma / MAXCOLUMNA;
        return promedio;
    }
}
