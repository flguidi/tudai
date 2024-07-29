package tp02;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP2 - Ejercicio 03 --- */

/*
Escribir un programa que solicite el ingreso de un número mayor a 50 y lo muestre por pantalla en caso
de ser múltiplo de 2 o 3.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class E03 {
    public static void main(String[] args) {
        int num;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.print("Ingrese un número mayor que 50: ");
            num = Integer.valueOf(entrada.readLine());

            if (num > 50 && (num % 2 == 0 || num % 3 == 0)) {
                System.out.println(num);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
