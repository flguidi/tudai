package tp01;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP1 - Ejercicio 02 --- */

/*
Escribir un programa que declare una variable de tipo double y una constante de tipo double con valor 1.0.
Luego, deberá asignar el doble del valor de la constante a la variable y mostrar ambos por pantalla.
*/

public class E02 {
    public static void main(String[] args) {
        final double CONST = 1.0;
        double var = CONST * 2;

        System.out.println("Constante: " + CONST);
        System.out.println("Variable: " + var);
    }
}
