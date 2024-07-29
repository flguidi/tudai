package tp06;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP6 - Bonus Track 02a --- */

/* 
Dado el siguiente código, detectar errores y corregirlos:

public class BonusTrack02a {
    public static final int MAXFIL = 10, MAXCOL = 10;
    
    public static void main (String [] args) {
        int[][] matriz = new int[MAXFIL];
        int columna=6, fila=4;
        procesar(matriz[columna], fila);
    }

    // Método ya implementado
    public static void procesar(int[] arr, int pos) {
        ...
    }
} 
*/

public class BT02a {
    public static final int MAXFIL = 10, MAXCOL = 10;

    public static void main(String[] args) {
        int[][] matriz = new int[MAXFIL][MAXCOL];
        int columna = 6, fila = 4;
        procesar(matriz[fila], columna);
    }

    // Método ya implementado
    public static void procesar(int[] arr, int pos) {
        //...
    }
}
