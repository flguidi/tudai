package tp03;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP3 - Ejercicio 05 --- */

/*
Hacer un método que dado un número entero con valor inicial 1, haga una iteración incrementando el número
de a uno hasta un valor MAX = 4 (constante). Mientras itera deberá imprimir el número. Luego invocarlo desde el
programa principal y cuando termina imprimir por pantalla “terminó”.
*/

public class E05 {
    public static final int MAX = 4;

    public static void main(String[] args) {
        imprimirNumeros();
        System.out.println("Terminó");    
    }

    public static void imprimirNumeros() {
        for (int i = 1; i <= MAX; i++) {
            System.out.println(i);
        }
    }
}
