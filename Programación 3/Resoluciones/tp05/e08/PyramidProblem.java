package tp05.e08;

import java.util.HashSet;
import java.util.Set;

/**
 * Colocar un entero positivo (menor que un cierto valor entero K dado) en cada casilla de una
 * pirámide de base B (valor entero dado) de modo que cada número sea igual a la suma de las
 * casillas sobre las que está apoyado. Los números de todas las casillas deben ser diferentes.
 */
public class PyramidProblem {

    private int[][] pyramid;
    private Set<Integer> usedNumbers;

    /**
     * Resuelve el problema de la pirámide.
     *
     * @param b La base de la pirámide, indicando el número de celdas en el nivel inferior.
     * @param k El valor máximo permitido para los números en las casillas (1 a k-1).
     * @return Una representación en forma de texto de la pirámide si se encuentra una solución.
     *         En caso contrario, devuelve un mensaje indicando que no hay solución.
     */
    public String solve(int b, int k) {
        // Se construye la pirámide
        pyramid = new int[b][];
        for (int i = 0; i < b; i++) {
            pyramid[i] = new int[i + 1];  // El nivel i tiene i+1 celdas
        }

        usedNumbers = new HashSet<>();

        if (backtrack(b - 1, 0, b, k)) {
            return printPyramid(b);
        } else {
            return "No hay solución.";
        }
    }

    /**
     * Función recursiva de backtracking para completar la pirámide.
     *
     * @param level El nivel actual de la pirámide que se está llenando (de arriba hacia abajo).
     * @param index El índice dentro del nivel actual.
     * @param b     La base de la pirámide.
     * @param k     El valor máximo permitido para los números (1 a k-1).
     * @return {@code true} si se encuentra una solución completa; {@code false} en caso contrario.
     */
    private boolean backtrack(int level, int index, int b, int k) {
        // Si se llega a la punta, no hay más casillas que llenar
        if (level < 0) {
            return true;
        }

        // Se intenta asignar un número en la posición actual
        for (int num = 1; num < k; num++) { // Números entre 1 y k-1
            // Se verifica si el número es válido
            if (isValid(level, index, num, b)) {
                // Se inserta el número en la casilla actual
                pyramid[level][index] = num;
                usedNumbers.add(num);

                // Se intenta llenar la siguiente casilla recursivamente
                int nextLevel = (index < level) ? level : level - 1;
                int nextIndex = (index < level) ? index + 1 : 0;
                if (backtrack(nextLevel, nextIndex, b, k)) {
                    return true;
                }

                // Si no se puede, se retrocede
                pyramid[level][index] = 0;
                usedNumbers.remove(num);
            }
        }

        return false;
    }

    /**
     * Verifica si un número es válido para colocar en una casilla.
     *
     * @param level El nivel actual de la pirámide.
     * @param index El índice dentro del nivel actual.
     * @param num   El número que se desea colocar en la casilla.
     * @param b     La base de la pirámide.
     * @return {@code true} si el número es válido, {@code false} en caso contrario.
     */
    private boolean isValid(int level, int index, int num, int b) {
        // Se verifica que el número no se haya usado antes
        if (usedNumbers.contains(num)) {
            return false;
        }

        // Si se está en la base de la pirámide, no se necesita verificar sumas
        if (level == b - 1) {
            return true;
        }

        // Si no se está en la base, se verifica que la suma sea correcta
        int left = pyramid[level + 1][index];
        int right = pyramid[level + 1][index + 1];
        return left + right == num;
    }

    /**
     * Genera una representación en forma de texto de la pirámide.
     *
     * @param base La base de la pirámide.
     * @return Una cadena que representa la pirámide con los números asignados.
     */
    private String printPyramid(int base) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < base; i++) {
            for (int j = 0; j <= i; j++) {
                sb.append(pyramid[i][j]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

}