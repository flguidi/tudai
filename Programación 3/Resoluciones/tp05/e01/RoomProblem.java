package tp05.e01;

import tp05.e01.graph.DirectedGraph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Se tiene un conjunto de salas comunicadas entre sí a través de puertas que se abren solamente
 * en un sentido. Una de las salas se denomina 'entrada' y la otra 'salida'. Construir un algoritmo
 * que permita ir desde la entrada a la salida atravesando la máxima cantidad de salas.
 * Idea: podría representar el problema mediante un grafo dirigido, donde cada nodo es una habitación,
 * y cada puerta es un arco dirigido hacia otra habitación.
 */
public class RoomProblem {

    private boolean[] visited;
    private List<Integer> path;
    private List<Integer> longestPath;

    /**
     * Inicializa las estructuras necesarias para resolver el problema.
     *
     * @param vertexCount El número total de habitaciones (nodos) en el grafo.
     */
    private void init(int vertexCount) {
        visited = new boolean[vertexCount];
        path = new ArrayList<>();
        longestPath = new ArrayList<>();
    }

    /**
     * Encuentra el camino más largo desde la habitación de entrada hasta la habitación de salida.
     *
     * @param entry La habitación de entrada (nodo inicial).
     * @param exit  La habitación de salida (nodo final).
     * @param graph El grafo dirigido que representa las habitaciones y puertas.
     * @return Una lista de enteros representando el camino más largo encontrado desde la entrada hasta la salida.
     */
    public List<Integer> findLongestPath(int entry, int exit, DirectedGraph<String, String> graph) {
        init(graph.getVertexCount());
        visited[entry] = true;
        path.add(entry);

        // Se inicia el backtracking desde el nodo de entrada
        backtrack(entry, exit, graph);

        return longestPath;
    }

    /**
     * Procedimiento auxiliar que implementa el algoritmo de backtracking para explorar los caminos posibles.
     *
     * @param current El nodo actual en el recorrido.
     * @param exit    El nodo de salida objetivo.
     * @param graph   El grafo dirigido que representa las habitaciones y puertas.
     */
    private void backtrack(int current, int exit, DirectedGraph<String, String> graph) {
        if (current == exit) {
            if (path.size() > longestPath.size()) {
                longestPath.clear();
                longestPath.addAll(path);
            }
        } else {
            Iterator<Integer> adjacents = graph.getAdjacents(current);
            while (adjacents.hasNext()) {
                int adjacent = adjacents.next();

                if (!visited[adjacent]) {
                    visited[adjacent] = true;
                    path.add(adjacent);

                    backtrack(adjacent, exit, graph);

                    visited[adjacent] = false;
                    path.removeLast();
                }
            }
        }
    }

}
