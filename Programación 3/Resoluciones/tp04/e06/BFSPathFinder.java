package tp04.e06;

import tp04.e01.Graph;

import java.util.*;

/**
 * Esta clase implementa el algoritmo de búsqueda en amplitud (BFS) para encontrar el camino más corto
 * entre dos vértices en un grafo no ponderado. El algoritmo comienza en el vértice de inicio y explora
 * los vértices vecinos en capas, garantizando que se encuentre el camino más corto.
 *
 * @param <V> El tipo de los vértices del grafo.
 * @param <E> El tipo de las aristas del grafo.
 */
public class BFSPathFinder<V, E> {

    /**
     * Encuentra el camino más corto entre el vértice de inicio ('start') y el vértice de destino ('end')
     * utilizando el algoritmo de búsqueda en amplitud (BFS).
     *
     * @param start El vértice de inicio desde el cual se comienza la búsqueda.
     * @param end   El vértice de destino al cual se quiere llegar.
     * @param graph El grafo en el cual se realiza la búsqueda.
     * @return Una lista con los vértices que conforman el camino más corto desde el vértice de inicio
     *         hasta el vértice de destino. Si no existe un camino, devuelve una lista vacía.
     */
    public List<Integer> shortestPath(int start, int end, Graph<V, E> graph) {
        List<Integer> path = new ArrayList<>();

        if (start < 0 || start >= graph.getVertexCount() || end < 0 || end >= graph.getVertexCount()) {
            return path;
        }

        boolean[] visited = new boolean[graph.getVertexCount()];
        int[] parent = new int[graph.getVertexCount()]; // Arreglo de vértices padre para reconstruir el camino
        Queue<Integer> queue = new LinkedList<>();

        Arrays.fill(parent, -1); // Se inicializa el arreglo de padres el valor '-1'

        // Se agrega el vértice de inicio a la cola y se marca como visitado
        queue.add(start);
        visited[start] = true;

        // Mientras la cola no esté vacía
        while (!queue.isEmpty()) {
            // Se extrae de la cola el vértice actual
            int current = queue.poll();

            // Si se encuentra el final, se reconstruye el camino
            if (current == end) {
                int node = end;
                while (node != -1) {
                    path.addFirst(node);
                    node = parent[node];
                }
                return path;
            }

            // De lo contrario, se itera sobre los vértices adyacentes al vértice actual
            Iterator<Integer> adjacets = graph.getAdjacents(current);
            while (adjacets.hasNext()) {
                int adjacent = adjacets.next();

                // Si no está visitado el vértice adyacente
                if (!visited[adjacent]) {
                    queue.add(adjacent); // Se agrega el adyacente a la fila
                    visited[adjacent] = true; // Se marca el adyacente como visitado
                    parent[adjacent] = current; // Se establece como padre del adyacente al vértice actual
                }
            }
        }

        return new ArrayList<>();
    }

}
