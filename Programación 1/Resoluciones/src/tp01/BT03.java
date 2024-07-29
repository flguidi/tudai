package tp01;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP1 - Bonus Track 03 --- */

/*
Viendo el éxito de las promociones implementadas por la competencia, el supermercado Soberano decidió aplicar
la misma idea. En Soberano, hay un descuento del 8% si se cumplen las siguientes condiciones: es viernes o sábado,
el número de ticket es par, el importe es a lo sumo de $15.000 y el DNI del cliente termina en un número impar.
Escribir un programa que dado el día, el número de ticket, el importe y el DNI verifique si debe aplicar el descuento
o no. Puede suponer un dato numérico para el día como en el inciso anterior.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BT03 {
    public static void main(String[] args) {
        final int TICKET = (int) (Math.random() * 100000);
        int dia, dniCliente;
        float importe;
        boolean diaCorrecto, ticketImpar, dniPar, importeMaximo, hayDescuento; 

        try {
            // Entrada
            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Ticket Nro: " + TICKET);
            System.out.println("Día:\n1. Viernes\n2. Sábado");
            dia = Integer.valueOf(entrada.readLine());
            System.out.print("Importe: ");
            importe = Float.valueOf(entrada.readLine());
            System.out.print("DNI del cliente: ");
            dniCliente = Integer.valueOf(entrada.readLine());

            // Procesamiento
            diaCorrecto = dia == 1 || dia == 2;
            ticketImpar = TICKET % 2 == 1;
            dniPar = dniCliente % 2 == 0;
            importeMaximo = importe <= 15000;
            hayDescuento = diaCorrecto && ticketImpar && dniPar && importeMaximo;

            // Salida
            System.out.println("¿Hay descuento? " + hayDescuento);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
