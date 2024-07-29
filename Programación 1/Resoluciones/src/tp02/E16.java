package tp02;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP2 - Ejercicio 16 --- */

/* Pedir por consola 15 caracteres. Imprimir la mayor cantidad de ‘a’ seguidas que se ingresaron. */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class E16 {
    public static void main(String[] args) {
        final int MAX = 15;
        char caracter;
        int contador = 0, consecutivas = 0;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
    
        for (int i = 1; i <= MAX; i++) {
            try {
                // Entrada
                System.out.print(i + ". Ingrese un carácter: ");
                caracter = entrada.readLine().charAt(0);

                // Procesamiento
                if (caracter == 'a') {
                    contador++;
                    if (contador > consecutivas) {
                        consecutivas = contador;
                    }
                } else {
                    contador = 0;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        // Salida
        System.out.println("Mayor cantidad de 'a' consecutivas: " + consecutivas);
    }
}
