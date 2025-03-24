package tp04.e04;

import tp04.e01.Graph;

import java.util.*;

/**
 * Clase que implementa un buscador de caminos en un grafo.
 * Permite encontrar tanto el camino más corto como el más largo entre dos vértices dados en un grafo dirigido.
 *
 * @param <V> Tipo de los vértices en el grafo.
 * @param <E> Tipo de las aristas en el grafo.
 */
public class DFSPathFinder<V, E> {

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
     * Encuentra el camino más corto entre un vértice de inicio ('start') y otro de destino ('end') en un grafo.
     * Utiliza un enfoque de búsqueda recursiva para explorar todos los caminos posibles y encontrar el más corto.
     *
     * @param start El vértice de inicio.
     * @param end   El vértice de destino.
     * @param graph El grafo en el que se busca el camino.
     * @return Una lista de vértices que representa el camino más corto desde 'start' hasta 'end'.
     */
    public ArrayList<Integer> shortestPath(int start, int end, Graph<V, E> graph) {
        init(graph.getVertexCount());
        ArrayList<Integer> path = new ArrayList<>();
        ArrayList<Integer> shortestPath = new ArrayList<>();

        shortestPathRec(start, end, graph, path, shortestPath);

        return shortestPath;
    }

    /**
     * Búsqueda recursiva para encontrar el camino más corto en el grafo.
     *
     * @param current      El vértice actual durante la búsqueda.
     * @param end          El vértice de destino.
     * @param graph        El grafo en el que se busca el camino.
     * @param path         El camino actual en la búsqueda.
     * @param shortestPath El camino más corto encontrado hasta el momento.
     */
    private void shortestPathRec(int current, int end, Graph<V, E> graph,
                                 ArrayList<Integer> path, ArrayList<Integer> shortestPath) {
        states[current] = State.IN_PROCESS;
        path.add(current);

        if (current == end) {
            if (path.size() < shortestPath.size() || shortestPath.isEmpty()) {
                shortestPath.clear();
                shortestPath.addAll(path);
            }
        } else {
            Iterator<Integer> adjacents = graph.getAdjacents(current);
            while (adjacents.hasNext()) {
                int adjacent = adjacents.next();
                if (states[adjacent] == State.NOT_VISITED) {
                    shortestPathRec(adjacent, end, graph, path, shortestPath);
                }
            }
        }

        // Una vez procesado, se marca el vértice como no visitado y se elimina del camino actual
        states[current] = State.NOT_VISITED;
        path.removeLast();
    }

    /**
     * Encuentra el camino más largo entre un vértice de inicio ('start') y otro de destino ('end') en un grafo.
     * Utiliza un enfoque de búsqueda recursiva para explorar todos los caminos posibles y encontrar el más largo.
     *
     * @param start El vértice de inicio.
     * @param end   El vértice de destino.
     * @param graph El grafo en el que se busca el camino.
     * @return Una lista de vértices que representa el camino más largo desde 'start' hasta 'end'.
     */
    public ArrayList<Integer> longestPath(int start, int end, Graph<V, E> graph) {
        init(graph.getVertexCount());
        ArrayList<Integer> path = new ArrayList<>();
        ArrayList<Integer> longestPath = new ArrayList<>();

        longestPathRec(start, end, graph, path, longestPath);

        return longestPath;
    }

    /**
     * Búsqueda recursiva para encontrar el camino más largo en el grafo.
     *
     * @param current     El vértice actual durante la búsqueda.
     * @param end         El vértice de destino.
     * @param graph       El grafo en el que se busca el camino.
     * @param path        El camino actual en la búsqueda.
     * @param longestPath El camino más largo encontrado hasta el momento.
     */
    private void longestPathRec(int current, int end, Graph<V, E> graph,
                                ArrayList<Integer> path, ArrayList<Integer> longestPath) {
        states[current] = State.IN_PROCESS;
        path.add(current);

        if (current == end) {
            if (path.size() > longestPath.size()) {
                longestPath.clear();
                longestPath.addAll(path);
            }
        } else {
            Iterator<Integer> adjacents = graph.getAdjacents(current);
            while (adjacents.hasNext()) {
                int adjacent = adjacents.next();
                if (states[adjacent] == State.NOT_VISITED) {
                    longestPathRec(adjacent, end, graph, path, longestPath);
                } else if (states[adjacent] == State.IN_PROCESS) {
                    throw new RuntimeException("ERROR: El grafo debe ser acíclico.");
                }
            }
        }

        // Una vez procesado, se marca el vértice como no visitado y se elimina del camino actual
        states[current] = State.NOT_VISITED;
        path.removeLast();
    }

    /**
     * Almacena los tres estados posibles de un vértice: NOT_VISITED, IN_PROCESS y FINALIZED.
     */
    private enum State {
        NOT_VISITED, IN_PROCESS, VISITED
    }

}
