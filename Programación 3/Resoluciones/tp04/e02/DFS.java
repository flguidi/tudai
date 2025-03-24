package tp04.e02;

import tp04.e01.Graph;

import java.util.*;

/**
 * Esta clase implementa el algoritmo de Recorrido en Profundidad (Depth-First Search, DFS) para grafos,
 * tanto en su versión recursiva como iterativa.
 * Complejidad temporal: O(|v| + |a|), donde |v| es el número de vértices y |a| es el número de aristas del grafo.
 */
public class DFS<V, E> {

    private boolean[] visited;      // Arreglo que indica si un vértice ha sido visitado
    private int[] discoveryTimes;   // Arreglo que almacena los tiempos de descubrimiento de cada vértice
    private int[] finishTimes;      // Arreglo que almacena los tiempos de finalización de cada vértice
    private int time;               // Contador global de tiempo


    // ------------------------------- Inicialización de estructuras -------------------------------

    /**
     * Inicializa las estructuras necesarias para realizar el recorrido DFS (Recorrido en Profundidad) en el grafo.
     * Se configura el arreglo de vértices visitados a 'false', el arreglo de tiempos de descubrimiento a '-1' y el
     * arreglo de tiempos de finalización a '-1'.
     *
     * @param vertexCount El número total de vértices en el grafo. Este parámetro se utiliza para inicializar
     *                    los tres arreglos: <code>visited</code>, <code>discoveryTimes</code> y <code>finishTimes</code>.
     */
    private void init(int vertexCount) {
        visited = new boolean[vertexCount];
        Arrays.fill(visited, false);

        discoveryTimes = new int[vertexCount];
        Arrays.fill(discoveryTimes, -1);

        finishTimes = new int[vertexCount];
        Arrays.fill(finishTimes, -1);
    }


    // -------------------------------------- DFS recursivo --------------------------------------

    /**
     * Realiza un recorrido en profundidad (DFS) recursivo sobre el grafo a partir de todos los vértices no visitados.
     * Para cada vértice, se registran los tiempos de descubrimiento y finalización.
     *
     * @param graph El grafo sobre el cual se realiza el DFS.
     * @return Una cadena que representa los tiempos de descubrimiento y finalización de cada vértice.
     */
    public String recursiveTraversal(Graph<V, E> graph) {
        init(graph.getVertexCount()); // Se inicializan estructuras
        time = 0; // Se reinicia el tiempo

        // Se realiza un recorrido recursivo sobre cada vértice del grafo
        Iterator<Integer> vertices = graph.getVertices();
        while (vertices.hasNext()) {
            int vertex = vertices.next();
            if (!visited[vertex]) { // Si no esta visitado
                recursiveVisit(vertex, graph); // Se visita recursivamente
            }
        }

        return printTraversal(graph.getVertexCount());
    }

    /**
     * Realiza un recorrido DFS recursivo a partir de un vértice inicial.
     * Para cada vértice, se registran los tiempos de descubrimiento y finalización.
     *
     * @param graph El grafo sobre el cual se realiza el DFS.
     * @param start El vértice desde el cual comienza el DFS.
     * @return Una cadena que representa los tiempos de descubrimiento y finalización de cada vértice.
     */
    public String recursiveTraversal(Graph<V, E> graph, int start) {
        init(graph.getVertexCount()); // Se inicializan estructuras
        time = 0; // Se reinicia el tiempo

        // Se realiza un recorrido recursivo sobre el vértice de inicio
        recursiveVisit(start, graph);

        return printTraversal(graph.getVertexCount());
    }

    /**
     * Función recursiva auxiliar que realiza el recorrido DFS a partir de un vértice específico.
     *
     * @param currentVertex El vértice actualmente siendo visitado.
     * @param graph         El grafo sobre el cual se realiza el DFS.
     */
    private void recursiveVisit(int currentVertex, Graph<V, E> graph) {
        visited[currentVertex] = true;
        discoveryTimes[currentVertex] = ++time;

        // Se recorren los vértices adyacentes
        Iterator<Integer> adjacents = graph.getAdjacents(currentVertex);
        while (adjacents.hasNext()) {
            int vertex = adjacents.next();
            if (!visited[vertex]) {
                recursiveVisit(vertex, graph);
            }
        }

        finishTimes[currentVertex] = ++time;
    }


    // -------------------------------------- DFS iterativo --------------------------------------

    /**
     * Realiza un recorrido en profundidad (DFS) iterativo sobre el grafo a partir de todos los vértices no visitados.
     * Para cada vértice, se registran los tiempos de descubrimiento y finalización.
     *
     * @param graph El grafo sobre el cual se realiza el DFS.
     * @return Una cadena que representa los tiempos de descubrimiento y finalización de cada vértice.
     */
    public String iterativeTraversal(Graph<V, E> graph) {
        init(graph.getVertexCount()); // Se inicializan estructuras
        Stack<Integer> stack = new Stack<>(); // Pila explícita que simula pila de ejecución
        time = 0; // Se reinicia el tiempo

        // Se realiza un recorrido iterativo sobre cada vértice del grafo
        Iterator<Integer> vertices = graph.getVertices();
        while (vertices.hasNext()) {
            int vertex = vertices.next();
            if (!visited[vertex]) {
                iterativeVisit(vertex, stack, graph);
            }
        }

        return printTraversal(graph.getVertexCount());
    }

    /**
     * Realiza un recorrido DFS iterativo a partir de un vértice inicial.
     * Para cada vértice, se registran los tiempos de descubrimiento y finalización.
     *
     * @param graph El grafo sobre el cual se realiza el DFS.
     * @param start El vértice desde el cual comienza el DFS.
     * @return Una cadena que representa los tiempos de descubrimiento y finalización de cada vértice.
     */
    public String iterativeTraversal(Graph<V, E> graph, int start) {
        init(graph.getVertexCount()); // Se inicializan estructuras
        Stack<Integer> stack = new Stack<>(); // Pila explícita que simula pila de ejecución
        time = 0; // Se reinicia el tiempo

        // Se realiza un recorrido iterativo sobre el vértice de inicio
        iterativeVisit(start, stack, graph);

        return printTraversal(graph.getVertexCount());
    }

    /**
     * Función auxiliar que realiza el recorrido DFS iterativo a partir de un vértice específico.
     *
     * @param start El vértice desde el cual comienza el DFS.
     * @param stack La pila usada para el recorrido iterativo.
     * @param graph El grafo sobre el cual se realiza el DFS.
     */
    private void iterativeVisit(int start, Stack<Integer> stack, Graph<V, E> graph) {
        stack.push(start); // Se apila el vértice de inicio
        visited[start] = true; // Se marca como visitado
        discoveryTimes[start] = ++time; // Se registra el tiempo de descubrimiento

        // Mientras la pila no esté vacía
        while (!stack.isEmpty()) {
            int vertex = stack.peek(); // Se toma un vértice de la pila

            // Se recorren los adyacentes del vértice recién extraído
            boolean allAdjVisited = true; // Se asume que todos los adyacentes han sido visitados

            Iterator<Integer> adjacents = graph.getAdjacents(vertex);
            while (adjacents.hasNext() && allAdjVisited) {
                int adjacent = adjacents.next();
                if (!visited[adjacent]) { // Si el vértice adyacente no ha sido visitado
                    stack.push(adjacent); // Se apila
                    visited[adjacent] = true; // Se marca como visitado
                    discoveryTimes[adjacent] = ++time; // Se registra el tiempo de descubrimiento
                    allAdjVisited = false; // No todos los adyacentes han sido visitados
                }
            }

            // Si todos los adyacentes fueron visitados, se finaliza el vértice actual
            if (allAdjVisited) {
                finishTimes[vertex] = ++time; // Se registra el tiempo de finalización
                stack.pop(); // Finalmente se extrae el vértice de la pila
            }
        }
    }


    // -------------------------------------- Impresión de DFS --------------------------------------

    /**
     * Genera una cadena con los tiempos de descubrimiento y finalización de todos los vértices.
     *
     * @param vertexCount El número total de vértices en el grafo.
     * @return Una cadena que muestra los tiempos de descubrimiento y finalización.
     */
    private String printTraversal(int vertexCount) {
        StringBuilder sb = new StringBuilder();

        // Vértices
        sb.append("V:");
        for (int i = 0; i < vertexCount; i++) {
            sb.append("\t").append(i);
        }

        // Tiempos de descubrimiento
        sb.append("\nD:");
        for (int i : discoveryTimes) {
            sb.append("\t").append(i);
        }

        // Tiempos de finalización
        sb.append("\nF:");
        for (int i : finishTimes) {
            sb.append("\t").append(i);
        }

        sb.append("\n");
        return sb.toString();
    }

}
