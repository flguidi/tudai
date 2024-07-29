package tp03;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP3 - Ejercicio 11 --- */

/*
Escribir un método que retorne el mayor de dos números. Usar ese método para calcular el máximo de una serie
de números ingresados por el usuario (20 números en total).
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class E11 {
    public static void main(String[] args) {
        int num1, num2, mayor, mayorFinal = 0;

        for (int i = 0; i < 10; i++) {
            System.out.print("Ingrese el primer número: ");
            num1= ingresarNumero();
            System.out.print("Ingresar segundo número: ");
            num2 = ingresarNumero();

            mayor = numeroMayor(num1, num2);
            System.out.println("Mayor: " + mayor);
            
            if (mayor > mayorFinal) {
                mayorFinal = mayor;
            }
        }

        System.out.println("Mayor final: " + mayorFinal);
    }

    public static int ingresarNumero() {
        int num = 0;
        boolean esEntero = false;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        while (!esEntero) {
            try {
                num = Integer.valueOf(entrada.readLine());
                esEntero = true;
            } catch (Exception e) {
                System.out.print("Error. Intentar nuevamente: ");
            }
        }

        return num;
    }

    public static int numeroMayor(int a, int b) {
        int mayor;
        if (a > b) {
            mayor = a;
        } else {
            mayor = b;
        }

        return mayor;
    }
}
