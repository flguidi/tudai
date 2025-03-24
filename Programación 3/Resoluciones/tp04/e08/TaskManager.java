package tp04.e08;

import tp04.e01.AdjacencyListDirectedGraph;
import tp04.e01.Vertex;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Esta clase gestiona la planificación de tareas en un grafo dirigido, con el objetivo de calcular la secuencia
 * crítica de las tareas a partir de un nodo inicial.
 * La secuencia crítica es el conjunto de tareas que mayor tiempo de procesamiento requiere.
 */
public class TaskManager {

    private boolean[] processed;            // Arreglo que mantiene el estado de las tareas procesadas
    private List<Task> sequence;            // Lista que almacena la secuencia de tareas durante la exploración
    private List<Task> criticalSequence;    // Lista que almacena la secuenia crítica de tareas
    private int time;                       // Tiempo acumulado mientras se procesan las tareas
    private int maxTime;                    // Tiempo máximo alcanzado durante el procesamiento de tareas

    /**
     * Inicializa las estructuras de datos y tiempos de procesamiento.
     *
     * @param vertexCount Cantidad de vértices (tareas) del grafo.
     */
    private void init(int vertexCount) {
        processed = new boolean[vertexCount];
        sequence = new ArrayList<>();
        criticalSequence = new ArrayList<>();
        time = 0;
        maxTime = Integer.MIN_VALUE;
    }

    /**
     * Calcula la secuencia crítica de tareas a partir de una tarea de inicio especificada.
     * La secuencia crítica es el conjunto de tareas que mayor tiempo de procesamiento requiere.
     *
     * @param startTask El ID de la tarea inicial desde la cual comienza el cálculo.
     * @param graph     El grafo dirigido que representa las dependencias entre las tareas.
     * @return La lista de tareas en la secuencia crítica.
     */
    public List<Task> computeCriticalSequence(int startTask, AdjacencyListDirectedGraph<Task, Integer> graph) {
        init(graph.getVertexCount());
        computeCriticalSequenceRec(startTask, graph);
        return criticalSequence;
    }

    /**
     * Recorrido DFS recursivo para calcular la secuencia crítica de tareas.
     * Explora el grafo de tareas y mantiene el tiempo total acumulado.
     * Cuando encuentra una secuencia con mayor tiempo, actualiza la secuencia crítica.
     *
     * @param currentTask El ID de la tarea actual a procesar.
     * @param graph       El grafo dirigido que representa las dependencias entre las tareas.
     */
    private void computeCriticalSequenceRec(int currentTask, AdjacencyListDirectedGraph<Task, Integer> graph) {
        // Se agrega la tarea a la secuencia
        Vertex<Task, Integer> taskVertex = graph.getVertexById(currentTask);
        Task task = taskVertex.getValue();
        sequence.add(task);

        processed[currentTask] = true;      // Se marca la tarea como procesada
        time += task.getDurationInHours();  // Se suma el tiempo de la tarea actual

        // Si el tiempo actual es mayor al tiempo máximo, se actualizan valores
        if (time > maxTime) {
            maxTime = time;
            criticalSequence.clear();
            criticalSequence.addAll(sequence);
        }

        // Se procesan tareas adyacentes
        Iterator<Integer> adjacents = graph.getAdjacents(currentTask);
        while (adjacents.hasNext()) {
            int adjacent = adjacents.next();

            // Se suma el tiempo de espera entre tareas
            int delayTime = taskVertex.getEdgeToVertex(adjacent).getLabel();
            time += delayTime;

            computeCriticalSequenceRec(adjacent, graph); // Llamada recursiva

            // Retroceso
            time -= delayTime; // Se resta el tiempo de espera
        }

        // Retroceso
        processed[currentTask] = false; // Se marca la tarea actual como no procesada
        sequence.removeLast(); // Se elimina de la secuencia actual
        time -= task.getDurationInHours(); // Se resta el tiempo
    }

}
