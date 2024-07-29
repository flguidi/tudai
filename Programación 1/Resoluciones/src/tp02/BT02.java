package tp02;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP2 - Bonus Track 02 --- */

/* 
La cadena de supermercados carrefive desea aplicar descuentos según el día que se realiza la compra:
    a. Los días martes, si el importe total de la compra supera los $13.000 el descuento es del 5%, pero si
       supera los $20.000 es del 7.5%.
    b. Los jueves, en cambio, el descuento es para todos los tickets cuyo importe supere los $25.000 y será el
       10% con un tope de reintegro de $3.000 por ticket.
    c. Si es viernes o sábado, si el número de ticket es par y el importe es a lo sumo de $15.000 se le aplicará
       un descuento del 8% si el DNI es par.
Escribir un programa que dado el día, solicite al usuario losrestantes datos para calcular los descuentos en cada
caso y lo aplique sobre el valor final a pagar. Debe informar el importe final a pagar en cada caso.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BT02 {
    public static void main(String[] args) {
        final int TOPEMAR1 = 13000, TOPEMAR2 = 20000, TOPEJUE = 25000, TOPEVIE = 15000, TOPEREINTEGRO = 3000;
        int dia, nroTicket, dni;
        float importe, reintegro = 0, descuento = 0, importeFinal;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.print("Ingrese importe: ");
            importe = Float.valueOf(entrada.readLine());
            System.out.print("Ingrese número de día (1 a 7): ");
            dia = Integer.valueOf(entrada.readLine());

            switch (dia) {
                case 2:
                    if (importe > TOPEMAR2) {
                        descuento = (float) 0.075;
                    } else if (importe > TOPEMAR1) {
                        descuento = (float) 0.05;
                    }
                    reintegro = importe * descuento;
                    break;
                
                case 4:
                    if (importe > TOPEJUE) {
                        descuento = (float) 0.1;
                        reintegro = importe * descuento;
                        if (reintegro > TOPEREINTEGRO) {
                            reintegro = TOPEREINTEGRO;
                        }
                    }
                    break;

                case 5, 6:
                    System.out.print("Ingrese número de ticket: ");
                    nroTicket = Integer.valueOf(entrada.readLine());
                    System.out.print("Ingrese número de DNI: ");
                    dni = Integer.valueOf(entrada.readLine());

                    if (nroTicket % 2 == 0 && dni % 2 == 0 && importe <= TOPEVIE) {
                        descuento = (float) 0.08;
                    }
                    reintegro = importe * descuento;
                    break;
                    
                default:
                    System.out.println("No se hará descuento");
            }

            // Procesamiento
            importeFinal = importe - reintegro;

            // Salida
            System.out.println("Importe final: " + importeFinal);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
