package tp03;/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP3 - Ejercicio 13 --- */

/* 
Realizar un programa que, dada una opción entera (1,2,3,4), permita realizar operaciones entre tres números
reales (r1,r2,r3) ingresados desde teclado. Para la opción:
    1. Calcular la raíz cuadrada de (r1-r3);
    2. Calcular el promedio de r1, r2 y r3;
    3. Calcular cociente de la raíz cuadrada de (r3 - r2) dividida por r1;
    4. Calcular el cociente del promedio de los tres valores dividido por la raíz cuadrada de r2;

Observación: La raíz cuadrada de un número se calcula con la sentencia Math.sqrt(numero). Hacer uso del diseño
descendente y de la modularización para la solución. Tener en cuenta posibles errores o excepciones como la
división por cero.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class E13 {
    public static void main(String[] args) {
        int opcion;
        float r1, r2, r3, resultado;

        System.out.println("Ingresar tres números reales:");
        System.out.print("r1: ");
        r1 = ingresarNumero();
        System.out.print("r2: ");
        r2 = ingresarNumero();
        System.out.print("r3: ");
        r3 = ingresarNumero();

        System.out.println("Ingrese una opción: ");
        System.out.println("1. Calcular la raíz cuadrada de (r1-r3)");
        System.out.println("2. Calcular el promedio de r1, r2 y r3");
        System.out.println("3. Calcular cociente de la raíz cuadrada de (r3 - r2) dividida por r1");
        System.out.println("4. Calcular el cociente del promedio de los tres valores dividido por la raíz cuadrada de r2");
        opcion = (int) ingresarNumero();

        switch (opcion) {
            case 1:
                if (raizCuadrada(r1-r3) != -1) {
                    resultado = raizCuadrada(r1-r3);
                    System.out.println(resultado);
                } else {
                    System.out.println("Error");
                }
                break;

            case 2:
                resultado = promedio(r1, r2, r3);
                System.out.println(resultado);
                break;
            
            case 3:
                if (raizCuadrada(r3 - r2) != -1 && r1 != 0) {
                    resultado = raizCuadrada(r3 - r2) / r1;
                    System.out.println(resultado);
                } else {
                    System.out.println("Error");
                }
                break;

            case 4:
                if (raizCuadrada(r2) != 0 && raizCuadrada(r2) != -1) {
                    resultado = promedio(r1, r2, r3) / raizCuadrada(r2);
                    System.out.println(resultado);
                } else {
                    System.out.println("Error");
                }
                break;

            default:
                System.out.println("Opción incorrecta.");
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
                System.out.print("Error. Intentar nuevamente: ");
            }
        }

        return num;
    }

    public static float raizCuadrada(float num) {
        if (num >= 0) {
            num = (float) Math.sqrt(num);
        } else {
            num = -1;
        }
        return num;
    }

    public static float promedio(float r1, float r2, float r3) {
        return (r1 + r2 + r3) / 3;
    }
}
