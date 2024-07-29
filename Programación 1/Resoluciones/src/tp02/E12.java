package tp02;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP2 - Ejercicio 12 --- */

/*
Escribir un programa que mientras el usuario ingrese un carácter letra minúscula, se quede con la menor
y la mayor letra ingresada. Finalmente muestre por pantalla dichas letras.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class E12 {
    public static void main(String[] args) {
        char menor = ' ', mayor = ' ', letra;
        boolean caracterValido = true;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        try {
            // Entrada
            System.out.print("Ingresar letra minúscula: ");
            letra = entrada.readLine().charAt(0);
            menor = letra;
            mayor = letra;

            while (caracterValido) {
                // Entrada
                System.out.print("Ingresar letra minúscula: ");
                letra = entrada.readLine().charAt(0);

                // Procesamiento
                if (letra >= 'a' && letra <= 'z') {
                    if (letra < menor) {
                        menor = letra;
                    }
                    if (letra > mayor) {
                        mayor = letra;
                    }
                } else {
                    caracterValido = false;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        // Salida
        System.out.println("Letra menor: " + menor);
        System.out.println("Letra mayor: " + mayor);
    }
}
