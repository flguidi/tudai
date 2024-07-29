package tp04;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP4 - Ejercicio 04b --- */

public class E04b {
    public static void main(String[] args) {
        int num = 4;
        int sumatoria = obtenerSumatoria(num);
        System.out.println("Sumatoria de " + num + ": " + sumatoria);
    }

    public static int obtenerSumatoria(int natural) {
        // Obtiene la sumatoria de los primeros n naturales
        int resultado = 0; // 'resultado = 1' es erróneo

        while (natural > 0)
            resultado += natural--;
        return resultado;
    }
}