package tp01;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP1 - Bonus Track 02 --- */

/*
En Carrefive, los días martes y jueves hay “PROMO”. En los días martes, si el importe total de la compra supera
los $13.000 el descuento es del 5%, pero si supera los $20.000 es del 7.5%. Los jueves, en cambio, el descuento es
para todos los tickets cuyo importe supere los $25.000 y será el 10% con un tope de reintegro de $3.000 por ticket.
Escribir un programa que dado el día de la semana que se hace la compra y el importe del ticket, verifique si aplica
hacer el descuento o no. Puede suponer un dato numérico para cada día, ejemplo: 1 para el martes y 2 para el jueves.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BT02 {
    public static void main(String[] args) {
        int dia;
        float importe;
        boolean esMartes, esViernes, hayDescuento;

        try {
            // Entrada
            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Ingrese día: \n1. Martes \n2. Jueves");
            dia = Integer.valueOf(entrada.readLine());
            System.out.print("Ingrese importe: ");
            importe = Float.valueOf(entrada.readLine());

            // Procesamiento
            esMartes = dia == 1;
            esViernes = dia == 2;
            hayDescuento = (esMartes && importe > 13000) || (esViernes && importe > 25000);

            // Salida
            System.out.println("¿Hay descuento? " + hayDescuento);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
