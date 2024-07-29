package examenes;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- Ejercicio tipo prefinal 02 --- */

/* 
Un supermercado almacena los importes de sus ventas anuales en una matriz de NxM, en donde cada fila representa
las ventas de cada mes. Dentro de un mes, la información es almacenada en secuencias separadas por 0 donde cada
secuencia representa las ventas realizadas dentro de un día. Por ejemplo, en la siguiente tabla, en el mes 1 se
realizaron 3 ventas el primer día por $150, $200 y $165.

| 0 | 0   | 150 | 200 | 165 | 0   | 154 | 352 | 240 | 256 | 0   | 900 | 750 | 0   | 0 |
| 0 | 940 | 105 | 265 | 845 | 215 | 0   | 245 | 765 | 348 | 0   | 741 | 125 | 541 | 0 |
| 0 | 851 | 543 | 625 | 845 | 914 | 0   | 754 | 184 | 452 | 637 | 917 | 0   | 0   | 0 |

El gerente desea solicitar distintas estadísticas según el mes que se quiere analizar. En algunos casos le interesa
conocer el promedio mensual de las ventas de mayor importe registradas en cada día y en otros casos, necesita saber
si el promedio diario de ventas fue todos los días superior a X durante el mes. Para ello informa en un arreglo A1
los meses que desea la primera estadística y en un arreglo A2 los de la segunda. A1 y A2 son de tamaño N, rellenados
con 0.

Por ejemplo, si A1 = {1,2,0} y A2 = {3,0,0} para los meses 1 y 2 se informará que el promedio es $484 ((200 + 352 +
900) / 3) y 815.33 ((940 + 765 + 741) / 3), respectivamente. Para el mes 3, dado un X = 600, informará que no se
cumplió.
*/

public class EjercicioTipoPrefinal02 {
    public static int N = 3, M = 15, SEPARADOR = 0, X = 600;

    public static void main(String[] args) {
        int[] A1 = {1, 2, 0};
        int[] A2 = {3, 0, 0};
        int[][] matrizVentas = {
                { 0, 0, 150, 200, 165, 0, 154, 352, 240, 256, 0, 900, 750, 0, 0 },
                { 0, 940, 105, 265, 845, 215, 0, 245, 765, 348, 0, 741, 125, 541, 0 },
                { 0, 381, 543, 625, 845, 914, 0, 754, 184, 452, 637, 917, 0, 0, 0 }
        };

        // Impresión de 'matrizVentas' y arreglos 'A1' y 'A2'
        System.out.println("Matriz de ventas:");
        imprimirMatriz(matrizVentas, M);
        System.out.println("Arreglo A1:");
        imprimirArreglo(A1, N);
        System.out.println("Arreglo A2:");
        imprimirArreglo(A2, N);

        // Procesamiento y salida
        imprimirPromedioMensualVentasMayorImporteMatriz(matrizVentas, A1);
        verificarPromedioDiarioMatriz(matrizVentas, A2);
    }

    // Calcula e imprime el promedio mensual de ventas de mayor importe (utilizando arreglo A1)
    public static void imprimirPromedioMensualVentasMayorImporteMatriz(int[][] matrizVentas, int[] A1) {
        int i = 0;
        while (i < N && A1[i] != SEPARADOR) {
            double promedioVentasMayorImporte = calcularPromedioMensualVentasMayorImporte(matrizVentas[A1[i] - 1]);
            System.out.println("Promedio del día " + A1[i] + ": " + promedioVentasMayorImporte);
            i++;
        }
    }

    // Verifica si el promedio diario de ventas fue todos los días superior a X (utilizando arreglo A2)
    public static void verificarPromedioDiarioMatriz(int[][] matrizVentas, int[] A2) {
        int i = 0;
        boolean promedioDiarioEsSuperior;

        while (i < N && A2[i] != SEPARADOR) {
            promedioDiarioEsSuperior = verificarPromedioDiarioMes(matrizVentas[A2[i] - 1]);
            if (promedioDiarioEsSuperior) {
                System.out.println("El promedio diario del mes " + A2[i] + " es mayor que " + X);
            } else {
                System.out.println("El promedio diario del mes " + A2[i] + " no es mayor que " + X);
            }
            i++;
        }
    }

    // Devuelve el promedio de ventas del mes
    public static boolean verificarPromedioDiarioMes(int[] mes) {
        int ini = 0, fin = -1;
        boolean esSuperior = true;

        while (ini < M && esSuperior) {
            ini = obtenerInicioSecuencia(mes, fin + 1);
            if (ini < M) {
                fin = obtenerFinSecuencia(mes, ini);
                esSuperior = calcularPromedioDia(mes, ini, fin) > X; 
            }
        }

        return esSuperior;
    }

    // Devuelve el promedio de ventas de un día (secuencia) dado
    public static double calcularPromedioDia(int[] mes, int ini, int fin) {
        int importeTotal = 0;
        int cantVentas = fin - ini + 1;
        for (int i = ini; i <= fin; i++) {
            importeTotal += mes[i];
        }
        return (double) importeTotal / cantVentas;
    }

    // Devuelve el promedio mensual de ventas de mayor importe para un mes dado
    public static double calcularPromedioMensualVentasMayorImporte(int[] mes) {
        int ini = 0, fin = -1, dias = 0, importeMayor = 0;
        while (ini < M) {
            ini = obtenerInicioSecuencia(mes, fin + 1);
            if (ini < M) {
                fin = obtenerFinSecuencia(mes, ini);
                dias++;
                importeMayor += obtenerImporteMayorDia(mes, ini, fin);
            }
        }
        return (double) importeMayor / dias;
    }

    // Devuelve el importe mayor de un día (secuencia) dado
    public static int obtenerImporteMayorDia(int[] mes, int ini, int fin) {
        int importeMayor = 0;
        for (int i = ini; i <= fin; i++) {
            if (mes[i] > importeMayor) {
                importeMayor = mes[i];
            }
        }
        return importeMayor;
    }

    // Devuelve la posición inicial de una secuencia
    public static int obtenerInicioSecuencia(int[] arr, int pos) {
        while (pos < M && arr[pos] == SEPARADOR) {
            pos++;
        }
        return pos;
    }

    // Devuelve la posición final de una secuencia
    public static int obtenerFinSecuencia(int[] arr, int pos) {
        while (pos < M && arr[pos] != SEPARADOR) {
            pos++;
        }
        return pos - 1;
    }    

    // Imprime por consola una matriz dada
    public static void imprimirMatriz(int[][] matriz, int cantColumnas) {
        for (int fila = 0; fila < N; fila++) {
            imprimirArreglo(matriz[fila], cantColumnas);
        }
    }

    // Imprime por consola un arreglo dado
    public static void imprimirArreglo(int[] arr, int cantElementos) {
        System.out.print("| ");
        for (int i = 0; i < cantElementos; i++) {
            System.out.print(arr[i] + " | ");
        }
        System.out.println();
    }
}