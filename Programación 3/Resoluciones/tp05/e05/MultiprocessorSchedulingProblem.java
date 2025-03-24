package tp05.e05;

/**
 * Asignación de tareas a procesadores:
 * Se tienen m procesadores idénticos y n tareas con un tiempo de ejecución dado. Se requiere encontrar una
 * asignación de tareas a procesadores de manera de minimizar el tiempo de ejecución del total de tareas.
 */
public class MultiprocessorSchedulingProblem {

    private int[] solution;
    private int minTime;

    /**
     * Asigna las tareas a los procesadores utilizando un algoritmo de backtracking para minimizar el tiempo máximo de
     * ejecución.
     *
     * @param taskTimes      Arreglo que contiene los tiempos de ejecución de cada tarea.
     * @param processorCount Número de procesadores disponibles para ejecutar las tareas.
     * @return Un arreglo que representa la distribución de tareas entre los procesadores que minimiza el tiempo de
     *         ejecución máximo de los procesadores.
     */
    public int[] assignTasks(int[] taskTimes, int processorCount) {
        solution = new int[processorCount];
        int[] processorsTimes = new int[processorCount];
        minTime = Integer.MAX_VALUE;
        backtrack(0, taskTimes, processorsTimes);
        return solution;
    }

    /**
     * Procedimiento recursivo que implementa el algoritmo de backtracking para asignar tareas a los procesadores.
     * Asigna recursivamente tareas a los procesadores e intenta todas las posibles combinaciones de asignación.
     * Cuando todas las tareas son asignadas, calcula el tiempo máximo de ejecución y actualiza la mejor solución
     * si es necesario.
     *
     * @param taskIndex       Índice de la tarea actual que se está intentando asignar.
     * @param taskTimes       Arreglo con los tiempos de ejecución de las tareas.
     * @param processorsTimes Arreglo que lleva el seguimiento del tiempo acumulado de ejecución de cada procesador.
     */
    private void backtrack(int taskIndex, int[] taskTimes, int[] processorsTimes) {
        // Caso base: Cuando todas las tareas son asignadas, se verifica si el tiempo acumulado es menor
        if (taskIndex == taskTimes.length) {
            int currentTime = calculateExecutionTime(processorsTimes);
            if (currentTime < minTime) {
                minTime = currentTime;
                System.arraycopy(processorsTimes, 0, solution, 0, processorsTimes.length);
            }
            return;
        }

        // Se recorren todos los procesadores para asignar la tarea actual
        for (int i = 0; i < processorsTimes.length; i++) {
            // Se asigna la tarea al procesador i
            processorsTimes[i] += taskTimes[taskIndex];

            if (calculateExecutionTime(processorsTimes) < minTime) { // Poda
                // Llamada recursiva para la siguiente tarea
                backtrack(taskIndex + 1, taskTimes, processorsTimes);
            }

            // Se deshace la asignación (backtracking)
            processorsTimes[i] -= taskTimes[taskIndex];
        }
    }

    /**
     * Calcula el tiempo de ejecución máximo entre todos los procesadores.
     *
     * @param processorsTimes Arreglo con los tiempos de ejecución acumulados de cada procesador.
     * @return El tiempo máximo de ejecución entre todos los procesadores.
     */
    private int calculateExecutionTime(int[] processorsTimes) {
        int maxTime = 0;
        for (int i = 0; i < processorsTimes.length; i++) {
            maxTime = Math.max(maxTime, processorsTimes[i]);
        }
        return maxTime;
    }

}
