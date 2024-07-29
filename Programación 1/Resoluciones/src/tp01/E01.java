package tp01;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP1 - Ejercicio 01 --- */

/*
Escribir un programa que declare variables para los tipos int, double, char y boolean, luego asigne un valor,
a cada una, correspondiente al tipo que tiene la variable, e imprima por pantalla cada una de las variables.
*/

public class E01 {
    public static void main(String[] args) {
        int entero = 10;
        double real = 5.6;
        char caracter = '!';
        boolean bool = true;

        System.out.println("La variable 'entero' vale: " + entero);
        System.out.println("La variable 'real' vale: " + real);
        System.out.println("La variable 'caracter' vale: " + caracter);
        System.out.println("La variable 'bool' vale: " + bool);
    }
}
