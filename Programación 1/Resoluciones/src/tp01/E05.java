package tp01;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP1 - Ejercicio 05 --- */

/* Escribir un programa que solicite nombre, edad, altura y ocupación, y los imprima por pantalla. */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class E05 {
    public static void main (String[] args) {
        String nombre, ocupacion;
        float altura;
        int edad;

        try {
            // Declaración de buffer
            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
            
            // Entrada por teclado
            System.out.print("Ingrese nombre: ");
            nombre = String.valueOf(entrada.readLine());
            System.out.print("Ingrese edad: ");
            edad = Integer.valueOf(entrada.readLine());
            System.out.print("Ingrese altura: ");
            altura = Float.valueOf(entrada.readLine());
            System.out.print("Ingrese ocupación: ");
            ocupacion = String.valueOf(entrada.readLine());

            // Salida por consola
            System.out.println("Nombre: " + nombre);
            System.out.println("Edad: " + edad);
            System.out.println("Altura: " + altura);
            System.out.println("Ocupación: " + ocupacion);
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}
