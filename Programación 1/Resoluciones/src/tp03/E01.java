package tp03;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP3 - Ejercicio 01 --- */

/* 
Escribir un diseño de programa que mientras que el usuario ingrese un número distinto de 0, pida ingresar
otro número y lo imprima:

DISEÑO
Declarar variable numérica
Obtener número entero por teclado
Mientras número entero sea distinto de 0:
    Obtener número entero por teclado
    Imprimir número
    Obtener número entero por teclado
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class E01 {
    public static void main(String[] args) {
        int num;
        
        System.out.println("Ingresar un número entero (0) para terminar: ");
        num = ingresarNumero();

        while (num != 0) {
            System.out.print("Ingrese otro número: ");
            num = ingresarNumero();
            System.out.println("El número ingresado fue " + num);
            System.out.print("Ingresar un número entero (0) para terminar: ");
            num = ingresarNumero();
        }
    }

    public static int ingresarNumero() {
        int num = 0;
        boolean esNumero = false;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        
        while (esNumero == false) {
            try {
                num = Integer.valueOf(entrada.readLine());
                esNumero = true;
            } catch (Exception e) {
                System.out.println("¡Ingrese un número entero!");
            }
        }
        
        return num;
    }
}
