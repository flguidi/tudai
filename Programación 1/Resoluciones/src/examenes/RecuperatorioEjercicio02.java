package examenes;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- Recuperatorio - Ejercicio 02 --- */

/*
Para el siguiente fragmento de programa en JAVA, indique el estado final de las variables 'columnaMayor'
y 'cantidadCaracteres'
*/

public class RecuperatorioEjercicio02 {
    public static void main(String[] args) {
        final int COLUMNAS = 10, FILAS = 4;
        final char[][] caracteres = {
                { 'a', 'a', '4', 'a', 'a', ';', 'a', 'a', 'a', 'a' },
                { 'a', 'a', '4', 'a', 'a', ';', 'a', 'a', 'a', 'a' },
                { 'a', 'a', '4', 'a', 'a', ';', 'a', 'a', 'f', 'a' },
                { 'a', 'a', '4', 'a', 'a', ';', 'a', 'a', 'a', 'a' }
            };

        int columnaMayor = -1, cantidadCaracteres = 0, columna = 0, fila = 0;

        while (columna < COLUMNAS) {
            while (fila < FILAS - 1 && caracteres[fila][columna] == caracteres[fila + 1][columna]) {
                fila++;
            }

            if (fila == FILAS - 1) {
                columnaMayor = columna;
                columna++;
                cantidadCaracteres += FILAS;
                fila = 0;
            } else {
                columna = COLUMNAS;
                cantidadCaracteres += fila + 1;
            }
        }

        System.out.println("'columnaMayor': " + columnaMayor);
        System.out.println("'cantidadCaracteres': " + cantidadCaracteres);
    }
}
