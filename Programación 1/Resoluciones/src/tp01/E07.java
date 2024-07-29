package tp01;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP1 - Ejercicio 07 --- */

/*
Escribir un programa que dado tres números reales ingresados por el usuario, divida el primero por el segundo
y al resultado obtenido le reste el tercero. Muestre por pantalla el resultado obtenido. Puede o no usar variables
auxiliares para los cálculos. Tenga en cuenta posibles errores en las operaciones.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class E07 {
    public static void main(String[] args) {
        float n1, n2, n3, resultado;

        try {
            // Creación de buffer
            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

            // Entrada
            System.out.print("Primer número: ");
            n1 = Float.valueOf(entrada.readLine());
            System.out.print("Segundo número: ");
            n2 = Float.valueOf(entrada.readLine());
            System.out.print("Tercer número: ");
            n3 = Float.valueOf(entrada.readLine());

            // Procesamiento
            resultado = n1 / n2 - n3;

            // Salida
            System.out.println(n1 + " / " + n2 + " - " + n3 + " = " + resultado);
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}
