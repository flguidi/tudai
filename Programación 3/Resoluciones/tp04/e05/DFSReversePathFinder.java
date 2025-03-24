package tp04.e05;

import tp04.e01.Graph;

import java.util.*;

/**
 * Esta clase implementa la búsqueda de vértices desde los cuales es posible llegar a un vértice objetivo
 * en un grafo, utilizando un algoritmo de búsqueda en profundidad (DFS) en el grafo original.
 *
 * @param <V> Tipo de los vértices en el grafo.
 * @param <E> Tipo de las aristas en el grafo.
 */
public class DFSReversePathFinder<V, E> {

    private State[] states; // Arreglo que almacena el estado de cada vértice

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
     * Devuelve una lista con los vértices desde los cuales se puede llegar al vértice objetivo (target).
     *
     * @param target El vértice objetivo al que se quiere llegar.
     * @param graph  El grafo que contiene los vértices y las conexiones.
     * @return Una lista con los vértices que tienen un camino hacia el vértice objetivo.
     */
    public List<Integer> getVerticesToTarget(int target, Graph<V, E> graph) {
        init(graph.getVertexCount());
        List<Integer> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        // Se recorre cada vértice del grafo
        Iterator<Integer> vertices = graph.getVertices();
        while (vertices.hasNext()) {
            int vertex = vertices.next();

            // Se verifica si hay un camino desde el vértice origen hasta el vértice destino
            if (states[vertex] == State.NOT_VISITED && vertex != target) {
                result.addAll(getPathToVertex(vertex, target, path, graph)); // Se agrega el vértice origen a la lista
            }

            init(graph.getVertexCount()); // Se reinicia el estado de los vértices
        }

        return result;
    }

    /**
     * Realiza una búsqueda recursiva para encontrar un camino desde el vértice 'current'
     * hasta el vértice 'target' en el grafo. Si se encuentra un camino, devuelve una lista
     * con los vértices que conforman el camino, de lo contrario, devuelve una lista vacía.
     *
     * @param current El vértice actual desde donde se inicia la búsqueda.
     * @param target  El vértice objetivo al que se quiere llegar.
     * @param path    Una lista que almacena el camino encontrado hasta el momento.
     * @param graph   El grafo que contiene los vértices y las conexiones.
     * @return Una lista con los vértices que conforman el camino desde 'current' hasta 'target',
     *         o una lista vacía si no existe un camino.
     */
    private List<Integer> getPathToVertex(int current, int target, List<Integer> path, Graph<V, E> graph) {
        // Caso base: Si se encuentra el vértice objetivo, se devuelve el camino actual
        if (current == target) {
            return path;
        }

        // Se marca el vértice como en proceso y se agrega al camino actual
        states[current] = State.IN_PROCESS;
        path.add(current);

        // Se recorren los vértices adyacentes
        Iterator<Integer> adjacents = graph.getAdjacents(current);
        while (adjacents.hasNext()) {
            int adjacent = adjacents.next();

            // Si el vértice adyacente no ha sido visitado, se continúa la búsqueda
            if (states[adjacent] == State.NOT_VISITED) {
                return getPathToVertex(adjacent, target, path, graph);
            }
        }

        // Si no se encuentra un camino, se deshace el último paso
        path.removeLast(); // Se elimina el vértice actual del camino
        states[current] = State.VISITED; // Se marca el vértice actual como finalizado

        return new ArrayList<>(); // Se devuelve un camino vacío
    }

    /**
     * Almacena los tres estados posibles de un vértice: NOT_VISITED, IN_PROCESS y FINALIZED.
     */
    private enum State {
        NOT_VISITED, IN_PROCESS, VISITED
    }

}
