package tp02;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP2 - Ejercicio 11 --- */

/*
Escribir un programa que mientras el usuario ingrese un caracter letra minúscula, acumule la cantidad
de vocales que ingresó. Finalmente muestre por pantalla dicha cantidad.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class E11 {
    public static void main(String[] args) {
        int contador = 0;
        char caracter = 'a';
        boolean caracterValido = true;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        while (caracterValido) {
            try {
                // Entrada
                System.out.print("Ingrese una letra minúscula: ");
                caracter = entrada.readLine().charAt(0);

                // Procesamiento
                if (caracter >= 'a' && caracter <= 'z') {
                    switch (caracter) {
                        case 'a', 'e', 'i', 'o', 'u': contador++; break;
                    }
                } else {
                    caracterValido = false;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        // Salida
        System.out.println("Cantidad de vocales ingresadas: " + contador);
    }
}
