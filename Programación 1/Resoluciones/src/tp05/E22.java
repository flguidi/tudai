package tp05;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP5 - Ejercicio 22 --- */

/*
Hacer un programa que reemplace de un arreglo A todas las ocurrencias de una secuencia patrón dada en un
arreglo P, por la secuencia contenida en el arreglo R de igual tamaño.
*/

public class E22 {
    public static final int MAX = 20;

    public static void main(String[] args) {
        int[] a = { 0, 4, 3, 0, 2, 2, 2, 0, 5, 1, 4, 0, 2, 2, 2, 0, 1, 4, 2, 0 };
        int[] p = { 2, 2, 2 };
        int[] r = { 9, 9, 9 };

        imprimirArreglo(a);
        reemplazarPatronesEnArreglo(a, p, r);
        imprimirArreglo(a);
    }

    // Método que reemplaza patrones en un vector 
    public static void reemplazarPatronesEnArreglo(int[] arr, int[] patron1, int[] patron2) {
        int inicio = 0, fin = -1;
        while (inicio < MAX) {
            inicio = obtenerInicioSecuencia(arr, fin + 1);
            if (inicio < MAX) {
                fin = obtenerFinSecuencia(arr, inicio);
                if (buscarPatronEnSecuencia(arr, patron1, inicio, fin)) {
                    reemplazarPatron(arr, patron2, inicio, fin);
                }
            }
        }
    }

    // Obtención de posición de inicio de secuencia
    public static int obtenerInicioSecuencia(int[] arr, int pos) {
        while (pos < MAX && arr[pos] == 0) {
            pos++;
        }
        return pos;
    }

    // Obtención de posición de fin de secuencia
    public static int obtenerFinSecuencia(int[] arr, int pos) {
        while (pos < MAX && arr[pos] != 0) {
            pos++;
        }
        return pos - 1;
    }

    // Verifica la existencia de un patrón dado en la secuencia
    public static boolean buscarPatronEnSecuencia(int[] arr, int[] patron1, int inicio, int fin) {
        int pos = 0;
        int longitud = fin - inicio + 1;
        while (pos < longitud && arr[pos + inicio] == patron1[pos]) {
            pos++;
        }
        return pos == longitud;
    }

    // Reemplazo (sobreescritura) de nuevo patrón sobre el anterior
    public static void reemplazarPatron(int[] arr, int[] patron2, int inicio, int fin) {
        for (int i = inicio; i <= fin; i++) {
            arr[i] = patron2[i - inicio];
        }
    }

    // Impresión de arreglo
    public static void imprimirArreglo(int[] arr) {
        System.out.print("|");
        for (int i = 0; i < MAX; i++) {
            System.out.print(arr[i] + "|");
        }
        System.out.print("\n");
    }
}
