package tp03;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP3 - Ejercicio 04 --- */

/* 
Escribir un diseño de programa que mientras que el usuario ingrese un número distinto de 0, pida ingresar
otros dos números e imprima el resultado de la multiplicación entre los dos últimos números ingresados:

DISEÑO
Declarar variables numéricas
Obtener número por teclado
Mientras número sea distinto de 0:
    Obtener primero número por teclado
    Obtener segundo número por teclado
    Imprimir resultado de la multiplicación
    Obtener número por teclado
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class E04 {
    public static void main(String[] args) {
        float num, multiplicando, multiplicador;
        
        System.out.print("Ingresar número (0 para terminar): ");
        num = ingresarNumero();

        while (num != 0) {
            System.out.print("Ingresar multiplicando: ");
            multiplicando = ingresarNumero();
            System.out.print("Ingresar multiplicador: ");
            multiplicador = ingresarNumero();
            System.out.println(multiplicando + " * " + multiplicador + " = " + (multiplicando * multiplicador));
            System.out.print("Ingresar número entero (0 para terminar): ");
            num = ingresarNumero();
        }
    }

    public static float ingresarNumero() {
        float num = 0;
        boolean esNumero = false;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        while (!esNumero) {
            try {
                num = Float.valueOf(entrada.readLine());
                esNumero = true;
            } catch (Exception e) {
                System.out.println("Error: no se ingresó un número.");
            }
        }
        
        return num;
    }
}
