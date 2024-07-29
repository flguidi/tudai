package tp01;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP1 - Ejercicio 11 --- */

/* 
Escribir un programa que permita el ingreso de un número entero por teclado e imprima el resultado de determinar:
    a. si es múltiplo de 6 y de 7,
    b. si es mayor a 30 y múltiplo de 2, o es menor igual a 30,
    c. si el cociente de la división de dicho número por 5 es mayor que 10. 
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class E11 {
    public static void main(String[] args) {
        int num;
        boolean condicionA, condicionB, condicionC;
        
        try {
            // Entrada
            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Ingrese un número: ");
            num = Integer.valueOf(entrada.readLine());

            // Procesamiento
            condicionA = (num % 6 == 0) && (num % 7 == 0);
            condicionB = ((num > 30) && (num % 2 == 0)) || (num <= 30);
            condicionC = (num / 5 > 10);

            // Salida
            System.out.println("¿" + num + " es múltiplo de 6 y de 7? " + condicionA);
            System.out.println("¿" + num + " es mayor a 30 y múltiplo de 2, o es menor o igual que 30? " + condicionB);
            System.out.println("¿" + num + " / 5 > 10? " + condicionC);
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}
