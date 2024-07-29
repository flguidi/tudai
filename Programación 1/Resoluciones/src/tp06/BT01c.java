package tp06;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP6 - Bonus Track 01c --- */

/* 
Una refactorización del sistema se ha aplicado sobre la estructura que permite almacenar los tickets para poder
soportar una nueva funcionalidad. En el nuevo esquema por cada día (fila de la matriz) cada secuencia tiene en
primer lugar el id del producto, al lado la cantidad vendida de ese producto para ese ticket. Ese se repite hasta
que no hay más productos y el último lugar lo ocupa el importe total.

Ejemplo:
| 0 | 3 | 24 | 7 | 1 | 203.56 | 0 | 99 | 2 | 87.5 | 0 | 12 | 8 | 3 | 5 | 1233.4 | 0
| 0 | 5 | 4  | 6 | 1 | 435.77 | 0 | 87 | 2 | 91.3 | 0 | 0  | 0 | 0 | 0 | 0      | 0

Para el ejemplo tenemos para un dia (la primera fila) 3 tickets:
    1. en el primero para el producto de id 3 se vendieron 24, para el id 7, 1 solo y el importe de la venta fue de
       $203.56
    2. para el segundo sólo se vendieron 2 productos del id 99 por un importe de $87.5
    3. para el tercero se vendieron 8 del id 12 y 5 del id 3 por un importe total de $1233.4

Para el segundo día (la segunda fila) 2 tickets:
    4. en el primero para el producto de id 5 se vendieron 4, para el id 6, 1 solo y el importe de la venta fue de
        $435.77
    5. para el segundo se vendieron 2 artículos del id 87 por un importe de $91.3

Con este esquema el departamento de ventas pretende conocer cuántos descuentos se aplicaron según el siguiente
criterio: si la cantidad de productos iguales es mayor a 2 y es una cantidad par, el descuento fue del 10% del
valor total del ticket. Tomando en cuenta estos descuentos el departamento de ventas quiere saber:
    a. cuánto fue el total de descuentos aplicados en un día particular para lo cual necesita saber cuánto sumaron
       en pesos todos los descuentos aplicados. Para el ejemplo, en el primer día (primera fila) suma: $152.45
       (redondeado), para el segundo (segunda fila) suma: $52.71(redondeado).
    b. cuántos productos tuvieron descuento un día particular (la cantidad de productos diferentes y no la cantidad
       de unidades). Para el ejemplo, el primer día fueron 3 artículos (el de id 3, id 99 e id 12) y el segundo día
       fueron 2 artículos (de id 5 e id 87).
    c. cuánto fue el total de descuentos aplicados para el mes para lo cual necesita saber cuánto sumaron en pesos
       todos los descuentos aplicados. Para el ejemplo suman $205.16.
*/

import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BT01c {
    public static final int MAXF = 31, MAXC = 21, MIN_VALOR = 1, MAX_VALOR = 100,
                            MIN_TOTAL = 200, MAX_TOTAL = 1000, MAX_CANT_ART = 4,
                            SEPARADOR = 0;
    public static final double PROBABILIDAD_TICKET = 0.9, DESCUENTO = 0.1;
    
    public static void main(String[] args) {
        double[][] mes = new double[MAXF][MAXC];
        int dia, cantProductos;
        double descuentoDia, descuentoMes;
        
        // Se carga y se imprime la matriz (el mes)
        cargarMatrizTickets(mes);
        imprimirMatrizTickets(mes);

        // Se solicita el número de día al usuario
        System.out.print("Ingrese el número de día (1 a " + MAXF + "): ");
        dia = leerInt();

        // Procesamiento
        descuentoDia = obtenerTotalDescuentosDia(mes[dia - 1]); // Punto A
        cantProductos = obtenerCantProductosConDescuentoDia(mes[dia - 1]); // Punto B
        descuentoMes = obtenerTotalDescuentosMes(mes); // Punto C

        // Salida
        System.out.printf("Descuento total del día %d: %.2f%n", dia, descuentoDia);
        System.out.println("Cantidad de productos con descuento del día " + dia + ": " + cantProductos);
        System.out.printf("Descuento total del mes: %.2f%n", descuentoMes);
    }

    // Calcula el descuento total en pesos aplicado en un mes
    public static double obtenerTotalDescuentosMes(double[][] mes) {
        double descuentoTotal = 0;
        
        for (int dia = 0; dia < MAXF; dia++) {
            int ini = 0, fin = -1, cantProductos;
            double totalConDescuento, totalSinDescuento, descuento;
    
            while (ini < MAXC) {
                ini = obtenerInicio(mes[dia], fin + 1);
                if (ini < MAXC) {
                    fin = obtenerFin(mes[dia], ini);

                    // Se calcula la cantidad de productos (descartando el último elemento)
                    cantProductos = (fin - ini) / 2;
                    if (cantProductos > 2 && cantProductos % 2 == 0) {
                        totalConDescuento = mes[dia][fin];
                        totalSinDescuento = totalConDescuento / (1 - DESCUENTO);
                        descuento = totalSinDescuento - totalConDescuento;
                        descuentoTotal += descuento;
                    }
                }
            }
        }

        return descuentoTotal;
    }

    // Calcula la cantidad de productos que obtuvieron descuento en un día determinado
    public static int obtenerCantProductosConDescuentoDia(double[] dia) {
        int ini = 0, fin = -1, cantProductos, cantProductosConDescuento = 0;

        while (ini < MAXC) {
            ini = obtenerInicio(dia, fin + 1);
            if (ini < MAXC) {
                fin = obtenerFin(dia, ini);

                // Se calcula la cantidad de productos (descartando el último elemento)
                cantProductos = (fin - ini) / 2;
                if (cantProductos > 2 && cantProductos % 2 == 0) {
                    cantProductosConDescuento += cantProductos;
                }
            }
        }

        return cantProductosConDescuento;
    }

    // Calcula el descuento total en pesos aplicado en un día determinado
    public static double obtenerTotalDescuentosDia(double[] dia) {
        int ini = 0, fin = -1, cantProductos;
        double totalConDescuento, totalSinDescuento, descuento, descuentoTotal = 0;

        while (ini < MAXC) {
            ini = obtenerInicio(dia, fin + 1);
            if (ini < MAXC) {
                fin = obtenerFin(dia, ini);

                // Se calcula la cantidad de productos (descartando el último elemento)
                cantProductos = (fin - ini) / 2;
                if (cantProductos > 2 && cantProductos % 2 == 0) {
                    totalConDescuento = dia[fin];
                    totalSinDescuento = totalConDescuento / (1 - DESCUENTO);
                    descuento = totalSinDescuento - totalConDescuento;
                    descuentoTotal += descuento;
                }
            }
        }

        return descuentoTotal;
    }

    // Devuelve la posición inicial de una secuencia
    public static int obtenerInicio(double[] vector, int pos) {
        while (pos < MAXC && vector[pos] == SEPARADOR) {
            pos++;
        }
        return pos;
    }

    // Devuelve la posición final de una secuencia
    public static int obtenerFin(double[] vector, int pos) {
        while (pos < MAXC && vector[pos] != SEPARADOR) {
            pos++;
        }
        return pos - 1;
    }

    // Carga de manera aleatoria un vector con secuencias (tickets) 
    public static void cargarMatrizTickets(double[][] mes) {
        Random r = new Random();
        int cantArticulos, pos;

        // El proceso de carga se repite para cada día del mes
        for (int dia = 0; dia < MAXF; dia++) {
            mes[dia][0] = SEPARADOR; // Se inicia con un separador
            pos = 1;

            while (pos < MAXC) {
                // Se genera aleatoriamente la cantidad de artículos
                cantArticulos = r.nextInt(MAX_CANT_ART) + 1;
                
                // Se verifica si el ticket aleatorio entrará en el vector
                if ((pos + cantArticulos * 2 + 1) < MAXC) {
                    if (r.nextDouble() < PROBABILIDAD_TICKET) {
                        int col = pos;
                        for (; col < cantArticulos * 2 + pos; col++) {
                            // Generación aleatoria del número de ID y cantidad de productos
                            mes[dia][col] = r.nextInt(MAX_VALOR - MIN_VALOR + 1) + MIN_VALOR;
                        }

                        // Generación aleatoria del total del ticket
                        mes[dia][col] = r.nextDouble(MAX_TOTAL - MIN_TOTAL + 1) + MIN_TOTAL;

                        pos += cantArticulos * 2 + 2;
                    } else {
                        mes[dia][pos] = SEPARADOR;
                    }
                } else {
                    mes[dia][pos] = SEPARADOR;
                    pos++;
                }
            }
        }
    }

    // Imprime el vector de secuencias numéricas
    public static void imprimirMatrizTickets(double[][] mes) {
        for (int i = 0; i < MAXF; i++) {
            System.out.print("| ");
            for (int j = 0; j < MAXC; j++) {
                if (mes[i][j] % 1 == 0) {
                    System.out.printf("%.0f | ", mes[i][j]);
                } else {
                    System.out.printf("%.2f | ", mes[i][j]);
                }
            }
            System.out.println();
        }
    }

    // Obtiene la entrada por teclado de un int
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
}
