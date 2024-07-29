package tp01;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP1 - Bonus Track 01 --- */

/*
La cadena de supermercados Carrefive debe imprimir el encabezado del ticket de compra de los clientes con cierto
formato para cumplir las exigencias de la Administración Federal de Ingresos PRIVADOS. En el mismo, debe figurar la
fecha y hora, número de ticket, CUIT, nombre del cajero, número de caja, dni del cliente y la leyenda “El precio lo
pone el cliente”.
Escribir un programa con declaración de constantes y variables que pida al usuario el ingreso de los datos necesarios
para imprimir el encabezado del ticket.
*/

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BT01 {
    public static void main(String[] args) {
        final String CUIT = "99-34567833-9";
        final String LEYENDA = "\"El precio lo pone el cliente\"";        
        final String FECHA;
        final int NROTICKET = (int) (Math.random() * 10000000);

        int nroCaja, dniCliente;
        String nombreCajero;

        // Fecha y hora
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy - HH:mm");
        Date date = new Date();
        FECHA = dateFormat.format(date);

        // Entrada
        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Cajero: ");
            nombreCajero = String.valueOf(entrada.readLine());    
            System.out.print("Caja Nro: ");
            nroCaja = Integer.valueOf(entrada.readLine());
            System.out.print("DNI del cliente: ");
            dniCliente = Integer.valueOf(entrada.readLine());            

            // Salida
            System.out.println("------------------------------------------------");
            System.out.println(FECHA + "\tTicket Nro. " + NROTICKET);
            System.out.println("CUIT: " + CUIT);
            System.out.println("Cajero: " + nombreCajero + "\t\tCaja: " + nroCaja);
            System.out.println("DNI: " + dniCliente);
            System.out.println(LEYENDA);
            System.out.println("------------------------------------------------");
        } catch (Exception e) {
            System.out.println(e);
        }        
    }
}
