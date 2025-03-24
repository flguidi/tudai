package tp04.e02;

import tp04.e01.Graph;

import java.util.*;

/**
 * Esta clase implementa el algoritmo iterativo de Recorrido en Amplitud (Breadth-First Search, BFS) para grafos.
 * Complejidad temporal: O(|v| + |a|), donde |v| es el número de vértices y |a| es el número de aristas del grafo.
 */
public class BFS<V, E> {

    private boolean[] visited;  // Arreglo que indica si un vértice ha sido visitado
    private int[] levels;       // Arreglo que almacena los niveles de cada vértices


    // ------------------------------- Inicialización de estructuras -------------------------------

    /**
     * Inicializa las estructuras necesarias para el recorrido en amplitud (BFS).
     * Se configura el arreglo de vértices visitados a 'false' y el arreglo de niveles a '-1'.
     *
     * @param vertexCount El número total de vértices en el grafo. Se utiliza para
     *                    inicializar los arreglos 'visited' y 'levels'.
     */
    private void init(int vertexCount) {
        visited = new boolean[vertexCount];
        Arrays.fill(visited, false);

        levels = new int[vertexCount];
        Arrays.fill(levels, -1);
    }


    // -------------------------------------- BFS iterativo --------------------------------------

    /**
     * Realiza un recorrido en amplitud (BFS) iterativo sobre el grafo a partir de todos los vértices no visitados.
     * Para cada vértice, se registra su nivel (número de aristas recorridas desde el vértice de inicio hasta dicho
     * vértice).
     *
     * @param graph Grafo sobre el cual se realiza el BFS.
     * @return Una cadena que muestra los niveles de cada vértice.
     */
    public String traverse(Graph<V, E> graph) {
        init(graph.getVertexCount()); // Inicialización de estructuras
        Queue<Integer> queue = new LinkedList<>(); // Cola donde se almacenan los vértices durante el recorrido

        // Se realiza un recorrido iterativo sobre cada vértice del grafo
        Iterator<Integer> vertices = graph.getVertices();
        while (vertices.hasNext()) {
            int vertex = vertices.next();
            if (!visited[vertex]) {
                iterativeTraversal(vertex, queue, graph);
            }
        }

        return printTraversal(graph.getVertexCount());
    }

    /**
     * Realiza un recorrido en amplitud (BFS) iterativo sobre el grafo a partir de un vértice especificado.
     * Para cada vértice, se registra su nivel (número de aristas recorridas desde el vértice de inicio hasta dicho
     * vértice).
     *
     * @param graph Grafo sobre el cual se realiza el BFS.
     * @return Una cadena que muestra los niveles de cada vértice.
     */
    public String traverse(Graph<V, E> graph, int start) {
        init(graph.getVertexCount()); // Inicialización de estructuras
        Queue<Integer> queue = new LinkedList<>(); // Cola donde se almacenan los vértices durante el recorrido

        // Se realiza un recorrido iterativo sobre el vértice de inicio
        iterativeTraversal(start, queue, graph);

        return printTraversal(graph.getVertexCount());
    }

    /**
     * Función auxiliar que realiza un recorrido iterativo en el grafo utilizando un algoritmo de búsqueda en amplitud
     * (BFS), asignando un nivel a cada vértice visitado.
     *
     * @param start El vértice inicial desde el que comienza el recorrido.
     * @param queue La cola utilizada para almacenar los vértices a visitar durante el recorrido.
     * @param graph El grafo sobre el cual se realiza el recorrido.
     */
    private void iterativeTraversal(int start, Queue<Integer> queue, Graph<V, E> graph) {
        int level = 0;
        queue.add(start);
        visited[start] = true;
        levels[start] = level;

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            level = levels[vertex];

            Iterator<Integer> adjacents = graph.getAdjacents(vertex);
            while (adjacents.hasNext()) {
                int adjacent = adjacents.next();
                if (!visited[adjacent]) {
                    visited[adjacent] = true;
                    queue.add(adjacent);
                    levels[adjacent] = level + 1;
                }
            }
        }
    }


    // -------------------------------------- Impresión de BFS --------------------------------------

    /**
     * Genera una cadena con los niveles de todos los vértices.
     *
     * @param vertexCount El número total de vértices en el grafo.
     * @return Una cadena de texto que representa los vértices y sus niveles en el recorrido.
     */
    private String printTraversal(int vertexCount) {
        StringBuilder sb = new StringBuilder();

        // Vértices
        sb.append("V:");
        for (int i = 0; i < vertexCount; i++) {
            sb.append("\t").append(i);
        }

        // Niveles
        sb.append("\nN:");
        for (int i : levels) {
            sb.append("\t").append(i);
        }

        sb.append("\n");
        return sb.toString();
    }

}
