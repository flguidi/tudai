package tp05;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP5 - Ejercicio 20 --- */

/* Hacer un programa que elimine de un arreglo todas las ocurrencias de una secuencia patrón dada por otro arreglo. */

public class E20 {

    public static final int MAX = 20;

    public static void main(String[] args) {
        int[] vector = { 0, 2, 0, 3, 7, 0, 1, 2, 3, 0, 4, 0, 1, 2, 3, 0, 8, 5, 3, 9, 0 };
        int[] patron = { 1, 2, 3 };        

        imprimirVector(vector);
        eliminarPatronesEnVector(vector, patron);
        imprimirVector(vector);
    }

    // Método que identifica secuencias en un vector y si encuentra un patrón dado lo elimina
    public static void eliminarPatronesEnVector(int[] vector, int[] patron) {
        int inicio = 0, fin = -1, longitudSecuencia;

        while (inicio < MAX) {
            inicio = obtenerInicioSecuencia(vector, fin + 1);
            if (inicio < MAX) {
                fin = obtenerFinSecuencia(vector, inicio);
                longitudSecuencia = fin - inicio + 1;
                if (compararPatronYSecuencia(vector, patron, inicio, longitudSecuencia)) {
                    eliminarSecuencia(vector, inicio, fin);
                    inicio = fin;
                }
            }
        }
    }

    // Obtención de posición de inicio de secuencia
    public static int obtenerInicioSecuencia(int[] vector, int pos) {
        while (pos < MAX && vector[pos] == 0) {
            pos++;
        }
        return pos;
    }

    // Obtención de posición de fin de secuencia
    public static int obtenerFinSecuencia(int[] vector, int pos) {
        while (pos < MAX && vector[pos] != 0) {
            pos++;
        }
        return pos - 1;
    }

    // Método booleano que compara una secuencia y un patrón dados
    public static boolean compararPatronYSecuencia(int[] vector, int[] patron, int inicio, int longitud) {
        int i = 0;
        while (i < longitud && vector[inicio + i] == patron[i]) {
            i++;
        }
        return i == longitud;
    }

    // Eliminación de secuencia, elemento por elemento
    public static void eliminarSecuencia(int[] vector, int inicio, int fin) {
        for (int i = inicio; i <= fin; i++) {
            eliminarElemento(vector, inicio);
        }
    }

    // Eliminación de elemento y corrimiento a izquierda
    public static void eliminarElemento(int[] vector, int pos) {
        for (int i = pos; i < MAX - 1; i++) {
            vector[i] = vector[i + 1];
        }
    }

    // Impresión de vector
    public static void imprimirVector(int[] vector) {
        System.out.print("|");
        for (int i = 0; i < MAX; i++) {
            System.out.print(vector[i] + "|");
        }
        System.out.println();
    }
}
