package tp02;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP2 - Ejercicio 18 --- */

/*
Escribir un programa que mientras que el usuario ingrese un número distinto de 0, pida ingresar otros dos
números e imprima el resultado de la división entre los dos últimos números ingresados.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class E18 {
    public static void main(String[] args) {
        float num = 1, num1, num2, cociente;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        try {
            // Entrada de número condicional
            System.out.print("Ingrese un número (0 para salir): ");
            num = Float.valueOf(entrada.readLine());

            while (num != 0) {
                // Entrada de dos números
                System.out.print("Ingrese el primer número: ");
                num1 = Float.valueOf(entrada.readLine());
                System.out.print("Ingrese el segundo número: ");
                num2 = Float.valueOf(entrada.readLine());

                // Procesamiento
                cociente = num1/num2;

                // Salida
                System.out.println(num1 + " / " + num2 + " = " + cociente);

                // Entrada de número condicional
                System.out.print("Ingrese un número (0 para salir): ");
                num = Float.valueOf(entrada.readLine());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
