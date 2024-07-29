package tp04;

/* --- Programación 1 (TUDAI | 2023) --- */
/* --- TP4 - Ejercicio 04f --- */

public class E04f {
    public static void main(String[] args) {
        int num = 1456;
        int digito = 4;
        boolean contieneDigito = buscarDigito(num, digito);
        System.out.println("¿" + num + " contiene el dígito " + digito + "? " + contieneDigito);
    }

    public static boolean buscarDigito(int num, int digito) {
        // Determina si está presente un determinado dígito en un número dado
        boolean encontrado = false;
        int resto;

        while (!encontrado) { // 'while (num > 0)' es incorrecto
            resto = num % 10;
            encontrado = resto == digito;
            num /= 10;
        }

        return encontrado;
    }
}
