package tp06;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP6 - Bonus Track 02c --- */

/* 
Dado el siguiente código, detectar errores y corregirlos:

public class BonusTrack02c {
    public static final int MAX = 10;

    public static void main (String [] args) {
        int[][] matriz = new int[MAX, MAX];
        int numero = 6;
        int pos = buscarNumero(matriz, numero);
        System.out.println("La posición del número " + número + " es: " + pos);
    } 
    
    public static int buscarNumero(int[][] mat, int numero) {
        int i = 0;

        while (mat[i] != numero)
            i++;
        
        if (i < MAX)
            return i;
        return -1;
    }
}
*/

public class BT02c {
    public static final int MAX = 10;

    public static void main(String[] args) {
        int[][] matriz = new int[MAX][MAX];
        int fila = 4, numero = 6;
        int pos = buscarNumero(matriz[fila], numero);
        System.out.println("La posición del número " + numero + " es: " + pos);        
    }

    public static int buscarNumero(int[] arr, int numero) {
        int i = 0;
        
        while (i < MAX && arr[i] != numero)
            i++;

        if (i < MAX)
            return i;
        
        return -1;
    }
}
