package tp05;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP5 - Bonus Track 01c --- */

/* 
Una refactorización del sistema se ha aplicado sobre la estructura que permite almacenar los tickets para poder
soportar una nueva funcionalidad. En el nuevo esquema cada secuencia tiene en primer lugar el id del producto y
al lado la cantidad vendida de ese producto para ese ticket. Ese esquema se repite hasta que no hay más productos
y, finalmente, el último lugar lo ocupa el importe total.

Ejemplo:
|   | 3 | 24 | 7 | 1 | 203.56 |   | 99 | 2 | 87.5 |   | 12 | 8 | 3 | 5 | 1233.4 |   |

Para este ejemplo tenemos 3 tickets:
      i. el primero para el producto de id 3 se vendieron 24, para el id 7 uno solo y el importe total de la venta
         fue de $203.56
     ii. para el segundo sólo se vendieron 2 productos del id 99 por un importe de $87.5
    iii. para el tercero se vendieron 8 del id 12 y 5 del id 3, con un importe total de $1233.4

Con este esquema el departamento de ventas pretende conocer cuántos descuentos se aplicaron sabiendo que, si la
cantidad de productos iguales es par y mayor o igual a 2, se aplicó un descuento del 10% en el valor total del ticket.
Tomando en cuenta estos descuentos el departamento de ventas quiere saber:
    a. cuánto fue el total de descuentos aplicados en el fin de semana para lo cual necesita saber cuánto sumó en
       pesos todos los descuentos aplicados. Para el ejemplo los descuentos aplicados suman un total de $152.45
       (redondeado)
    b. cuántos productos distintos tuvieron descuento. Para el ejemplo fueron 3 artículos: el de id 3, id 99 e id 12.
*/

import java.util.Random;

public class BT01c {
    public static final int MAX = 22, MIN_VALOR = 1, MAX_VALOR = 100,
                            MIN_TOTAL = 200, MAX_TOTAL = 1000, MAX_CANT_ART = 3;
    public static final int SEPARADOR = 0;
    public static final double PROBABILIDAD_TICKET = 0.8, DESCUENTO = 10;

    public static void main(String[] args) {
        double[] ventas = new double[MAX];
        cargarArregloTickets(ventas);
        imprimirArregloTickets(ventas);
        System.out.printf("\nDescuento total: %.2f%n", obtenerDescuentoTotal(ventas));
        System.out.println("Cantidad de productos con descuento: " + obtenerCantTotalProductosConDescuento(ventas));
    }

    // Devuelve el descuento total de todos productos
    public static double obtenerDescuentoTotal(double[] arr) {
        int inicio = 0, fin = -1;
        double descuentoTotal = 0;

        while (inicio < MAX) {
            inicio = obtenerInicioSecuencia(arr, fin + 1);
            if (inicio < MAX) {
                fin = obtenerFinSecuencia(arr, inicio);
                descuentoTotal += obtenerDescuentoTicket(arr, inicio, fin);
            }
        }

        return descuentoTotal;
    }

    // Devuelve el descuento de un ticket dado
    public static double obtenerDescuentoTicket(double[] arr, int inicio, int fin) {
        double descuento = 0, totalConDescuento = arr[fin];
        int pos = inicio + 1;

        while (pos < fin && (arr[pos] >= 2 && arr[pos] % 2 != 0)) {
            pos += 2;
        }

        if (pos < fin) {
            descuento = (totalConDescuento * 100 / (100 - DESCUENTO)) - totalConDescuento; 
        }

        return descuento;
    }

    // Obtiene la cantidad de productos de distinto ID que obtuvieron descuento
    public static int obtenerCantTotalProductosConDescuento(double[] arr) {
        int inicio = 0, fin = -1;
        int cantTotal = 0;

        while (inicio < MAX) {
            inicio = obtenerInicioSecuencia(arr, fin + 1);
            if (inicio < MAX) {
                fin = obtenerFinSecuencia(arr, inicio);
                
                cantTotal += obtenerCantProductosConDescuento(arr, inicio, fin);
            }
        }

        return cantTotal;
    }

    // Devuelve la cantidad de productos que obtuvieron descuento
    public static int obtenerCantProductosConDescuento(double[] arr, int inicio, int fin) {
        int cantProductos = 0;

        for (int i = inicio + 1; i < fin; i += 2) {
            if (arr[i] >= 2 && arr[i] % 2 == 0) {
                cantProductos++;
            }
        }

        return cantProductos;
    }

    // Devuelve el índice de inicio de una secuencia
    public static int obtenerInicioSecuencia(double[] arr, int pos) {
        while (pos < MAX && arr[pos] == SEPARADOR) {
            pos++;
        }
        return pos;
    }

    // Devuelve el índice de fin de una secuencia
    public static int obtenerFinSecuencia(double[] arr, int pos) {
        while (pos < MAX && arr[pos] != SEPARADOR) {
            pos++;
        }
        return pos - 1;
    }

    // Carga de manera aleatoria un arreglo con secuencias (tickets) 
    public static void cargarArregloTickets(double[] arr) {
        Random r = new Random();
        int cantArticulos = 0;
        int pos = 1;
        arr[0] = SEPARADOR; // Se coloca un separador al final del arreglo

        // Generación aleatoria de cantidad de artículos
        cantArticulos = r.nextInt(MAX_CANT_ART) + 1;
        
        while (pos < MAX) {
            // Se verifica el nuevo ticket no supera los límites del arreglo 
            if ((pos + cantArticulos * 2 + 2) < MAX) {
                if (r.nextDouble() < PROBABILIDAD_TICKET) {
                    int i = pos;

                    // Generación aleatoria del número de ID y cantidad de productos
                    for (; i < cantArticulos * 2 + pos; i++) {
                        arr[i] = r.nextInt(MAX_VALOR - MIN_VALOR + 1) + MIN_VALOR;
                    }

                    // Generación aleatoria del total del ticket
                    arr[i] = r.nextDouble(MAX_TOTAL - MIN_TOTAL + 1) + MIN_TOTAL;

                    pos += cantArticulos * 2 + 2;
                } else {
                    arr[pos] = SEPARADOR;
                }
            } else {
                arr[pos] = SEPARADOR;
                pos++;
            }
        }
    }

    // Imprime el arreglo de secuencias numéricas
    public static void imprimirArregloTickets(double[] arr) {
        System.out.print("| ");
        for (int i = 0; i < MAX; i++) {
            if (arr[i] % 1 == 0) {
                System.out.printf("%.0f | ", arr[i]);
            } else {
                System.out.printf("%.2f | ", arr[i]);
            }
        }
    }
}
