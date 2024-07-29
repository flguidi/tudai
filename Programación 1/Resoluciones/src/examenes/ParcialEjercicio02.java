package examenes;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- Parcial - Ejercicio 02 --- */

/*
Para el siguiente fragmento de programa en JAVA, indique el estado final de las variables 'cantidadMayor'
e 'inicioMayor'
*/

public class ParcialEjercicio02 {
    public static final int MAX = 10;
    public static char PATRON = 'a';
    public static final char[] letras = { 'a', 'a', '4', 'a', 'a', ';', 'a', 'a', 'a', 'a' };

    public static void main(String[] args) {
        int cantidad = 0, cantidadMayor = 0, inicioMayor = 0;
        for (int i = 0; i < MAX; i++) {
            if (letras[i] == PATRON) {
                cantidad++;
            } else {
                if (cantidad > cantidadMayor) {
                    cantidadMayor = cantidad;
                    inicioMayor = i - cantidadMayor;
                }
                cantidad = 0;
            }
        }

        System.out.println("'cantidadMayor': " + cantidadMayor);
        System.out.println("'inicioMayor': " + inicioMayor);
    }
}
