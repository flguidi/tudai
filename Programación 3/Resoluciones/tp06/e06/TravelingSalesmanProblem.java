package tp06.e06;


import tp06.e06.graph.UndirectedGraph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Problema del Viajante:
 * Dado un grafo ponderado de ciudades conectadas todas con todas, implementar un algoritmo que brinde una
 * aproximación al problema del viajante.
 */
public class TravelingSalesmanProblem {

    /**
     * Resuelve el Problema del Viajante mediante un enfoque Greedy.
     * El algoritmo comienza desde una ciudad de origen, y en cada paso elige la ciudad más cercana que aún
     * no ha sido visitada, hasta haber visitado todas las ciudades. Finalmente, se regresa a la ciudad de
     * origen para completar el ciclo.
     *
     * @param origin El índice del vértice de origen (ciudad inicial).
     * @param graph  El grafo ponderado no dirigido que representa las ciudades y sus conexiones.
     * @return Una lista de cadenas de texto que representan las ciudades visitadas en orden.
     */
    public List<String> solve(int origin, UndirectedGraph<String, Integer> graph) {
        List<String> solution = new ArrayList<>();
        boolean[] visited = new boolean[graph.getVertexCount()];

        // Se marca la ciudad de origen y se agrega a la solución
        int currentCity = origin;
        visited[currentCity] = true;
        solution.add(graph.getVertexById(currentCity).getValue());

        // Mientras haya ciudades por visitar
        while (solution.size() < graph.getVertexCount()) {
            int nearestCity = -1;
            int minDistance = Integer.MAX_VALUE;

            // Ciudades adyacentes
            Iterator<Integer> adjacents = graph.getAdjacents(currentCity);
            while (adjacents.hasNext()) {
                int adjacentId = adjacents.next();

                if (!visited[adjacentId]) {
                    int distance = graph.getEdge(currentCity, adjacentId).getLabel();

                    if (distance < minDistance) {
                        minDistance = distance;
                        nearestCity = adjacentId;
                    }
                }
            }

            // Se agrega la ciudad más cercana a la solución
            solution.add(graph.getVertexById(nearestCity).getValue());
            visited[nearestCity] = true;

            currentCity = nearestCity; // La ciudad actual se vuelve la más cercana
        }

        // Se vuelve a la ciudad inicial
        solution.add(graph.getVertexById(origin).getValue());

        return solution;
    }

}
