package tp06;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP6 - Bonus Track 02b --- */

/* 
Dado el siguiente código, detectar errores y corregirlos:

public class BonusTrack02b {
    public static final int MAX = 10;

    public static void main (String[] args) {
        char[][] mat = new int[MAX][MAX];
        int fila = 6;
        correrIzquierda(mat, fila);
        mostrarArreglo(mat[fila]); // ya implementado
    } 
    
    public static void correrIzquierda(char[][] mat, int pos){
        for (int i = pos; i < MAX - 1; i++) {
            mat[i] = mat[i + 1];
        }
    }
} 
*/

public class BT02b {
    public static final int MAX = 10;
    
    public static void main(String[] args) {
        char[][] mat = new char[MAX][MAX];
        int fila = 6, columna = 3;
        cargarMatriz(mat);
        correrIzquierda(mat[fila], columna);
        mostrarArreglo(mat[fila]);
    }

    public static void correrIzquierda(char[] arr, int pos) {
        for (int i = pos; i < MAX - 1; i++) {
            arr[i] = arr[i + 1];
        }
    }

    // Ya implementado
    public static void cargarMatriz(char[][] mat) {
        // ...
    }

    // Ya implementado
    public static void mostrarArreglo(char[] arr) {
        // ...
    }
}
