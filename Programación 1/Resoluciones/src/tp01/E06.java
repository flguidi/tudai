package tp01;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP1 - Ejercicio 06 --- */

/*
Escribir un programa que pida se ingresen datos necesarios para emitir una factura por la compra de dos
artículos de librería (tipo factura, número, nombre cliente, producto 1, importe 1, producto 2, importe 2,
importe total).
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class E06 {
    public static void main(String[] args) {
        char tipoFactura;
        int numeroFactura;
        String nombreCliente, producto1, producto2;
        float importe1, importe2, total;

        try {
            // Creación de buffer
            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

            // Entrada
            System.out.print("Tipo de factura (A, B o C): ");
            tipoFactura = entrada.readLine().charAt(0);    
            System.out.print("Número de factura: ");
            numeroFactura = Integer.valueOf(entrada.readLine());
            System.out.print("Nombre del cliente: ");
            nombreCliente = String.valueOf(entrada.readLine());
            System.out.print("Producto 1: ");
            producto1 = String.valueOf(entrada.readLine());
            System.out.print("Importe: ");
            importe1 = Float.valueOf(entrada.readLine());
            System.out.print("Producto 2: ");
            producto2 = String.valueOf(entrada.readLine());
            System.out.print("Importe: ");
            importe2 = Float.valueOf(entrada.readLine());

            // Procesamiento
            total = importe1 + importe2;

            // Salida
            System.out.println("Factura\t\t" + tipoFactura + "\tN " + numeroFactura);
            System.out.println("Nombre: " + nombreCliente);
            System.out.println("Producto\t\tImporte");
            System.out.println(producto1 + "\t\t\t" + importe1);
            System.out.println(producto2 + "\t\t\t" + importe2);
            System.out.println("Importe total\t\t" + total);
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}
