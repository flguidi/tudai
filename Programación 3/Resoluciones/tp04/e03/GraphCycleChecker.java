package tp04.e03;

import tp04.e01.Graph;

import java.util.*;

/**
 * Clase que verifica si un grafo tiene un ciclo utilizando un algoritmo de búsqueda en profundidad (DFS).
 *
 * @param <V> Tipo de los vértices en el grafo.
 * @param <E> Tipo de las aristas en el grafo.
 */
public class GraphCycleChecker<V, E> {

    private State[] states;    // Arreglo que almacena el estado de cada vértice

    /**
     * Inicializa los estados de los vértices del grafo.
     * Se establece que todos los vértices no han sido visitados.
     *
     * @param vertexCount El número total de vértices en el grafo.
     */
    private void init(int vertexCount) {
        states = new State[vertexCount];
        Arrays.fill(states, State.NOT_VISITED);
    }

    /**
     * Verifica si el grafo tiene ciclos.
     * Utiliza una búsqueda en profundidad (DFS) para recorrer el grafo y detectar ciclos.
     *
     * @param graph El grafo a evaluar para la presencia de ciclos.
     * @return {@code true} si se detecta un ciclo en el grafo, {@code false} de lo contrario.
     */
    public boolean hasCycle(Graph<V, E> graph) {
        init(graph.getVertexCount());

        Iterator<Integer> vertices = graph.getVertices();
        while (vertices.hasNext()) {
            int vertex = vertices.next();
            if (states[vertex] == State.NOT_VISITED && hasCycleRec(vertex, graph)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Función auxiliar recursiva utilizada para detectar ciclos
     *
     * @param currentVertex Vértice que está siendo visitado.
     * @param graph         El grafo a evaluar para la presencia de ciclos.
     * @return {@code true} si se detecta un ciclo en el grafo, {@code false} de lo contrario.
     */
    private boolean hasCycleRec(int currentVertex, Graph<V, E> graph) {
        states[currentVertex] = State.IN_PROCESS; // Se marca el vértice como en proceso

        // Se itera sobre los vértices adyacentes
        Iterator<Integer> adjacents = graph.getAdjacents(currentVertex);
        while (adjacents.hasNext()) {
            int adjacent = adjacents.next();

            // Si el vértice adyacente no ha sido visitado, se visita recursivamente
            if (states[adjacent] == State.NOT_VISITED && hasCycleRec(adjacent, graph)) { // Llamada recursiva
                return true;
            }
            // Si el vértice adyacente está en proceso, significa que hay un ciclo
            else if (states[adjacent] == State.IN_PROCESS) {
                return true;
            }
        }

        states[currentVertex] = State.VISITED; // Se marca el vértice como visitado
        return false; // No se encontró un ciclo en esta rama
    }

    /**
     * Almacena los tres estados posibles de un vértice: NOT_VISITED, IN_PROCESS y FINALIZED.
     */
    private enum State {
        NOT_VISITED, IN_PROCESS, VISITED
    }

}
