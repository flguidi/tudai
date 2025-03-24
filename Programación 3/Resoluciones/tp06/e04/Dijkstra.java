package tp06.e04;

import tp06.e04.graph.DirectedGraph;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Algoritmo de Dijkstra:
 * Dado un grafo con pesos no negativos, implementar el algoritmo de Dijkstra para determinar el array de
 * distancias y de predecesores en el camino más corto, desde un vértice origen dado como parámetro hacia
 * el resto de los vértices. Una vez realizado, imprimir el camino más corto que se debe seguir desde el
 * origen hacia cada vértice.
 */
public class Dijkstra<V> {

    public void findShortestPaths(DirectedGraph<V, Integer> graph, int start) {
        int vertexCount = graph.getVertexCount();
        int[] d = new int[vertexCount];
        int[] p = new int[vertexCount];

        // Inicialización
        Arrays.fill(d, Integer.MAX_VALUE); // Infinito
        Arrays.fill(p, -1); // Indefinido
        d[start] = 0;

        // Cola para obtener el nodo con la distancia más corta
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int u = queue.poll(); // Se obtiene el primer vértice de la cola

            // Relajación de aristas salientes de U
            Iterator<Integer> adjacents = graph.getAdjacents(u); // Vértices adyacentes a U
            while (adjacents.hasNext()) {
                int v = adjacents.next(); // Vértice adyacente V

                // Se obtiene la nueva distancia hasta V
                int weight = graph.getEdge(u, v).getLabel(); // Peso de la arista entre U y V
                int newDistance = d[u] + weight; // Se suma la distancia hasta U con la distancia entre U y V

                // Si el camino hacia V es más corto, se actualiza
                if (newDistance < d[v]) {
                    d[v] = newDistance;
                    p[v] = u;
                    queue.add(v);
                }
            }
        }

        printResults(d, p, start, vertexCount);
    }

    private void printResults(int[] distances, int[] predecessors, int start, int vertexCount) {
        System.out.println("Distancias mínimas desde el origen " + start + " hacia cada vértice:");

        // Vértices
        System.out.print("V:");
        for (int i = 0; i < vertexCount; i++) {
            System.out.print("\t" + i);
        }

        // Distancias
        System.out.print("\nD:");
        for (int i = 0; i < vertexCount; i++) {
            System.out.print("\t" + distances[i]);
        }

        // Predecesores
        System.out.print("\nP:");
        for (int i = 0; i < vertexCount; i++) {
            System.out.print("\t" + predecessors[i]);
        }

        System.out.println();
    }

}
