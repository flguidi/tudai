package tp01;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP1 - Ejercicio 08 --- */

/*
Escribir un programa que imprima por pantalla la tabla de verdad para los operadores lógicos OR y AND
(por separado) para dos valores booleanos. Utilizar los operadores para calcular el resultado.
*/

public class E08 {
    public static void main(String[] args) {
            // Tabla de verdad: AND
            System.out.println("AND:");
            System.out.println("false and false = " + (false && false));
            System.out.println("false and true = " + (false && true));
            System.out.println("true and false = " + (true && false));
            System.out.println("true and true = " + (true && true));

            // Tabla de verdad: OR
            System.out.println("\nOR: ");
            System.out.println("false or false = " + (false || false));
            System.out.println("false or true = " + (false || true));
            System.out.println("true or false = " + (true || false));
            System.out.println("true or true = " + (true || true));
    }
}
