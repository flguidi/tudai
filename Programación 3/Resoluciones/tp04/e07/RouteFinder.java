package tp04.e07;

import tp04.e01.AdjacencyListUndirectedGraph;
import tp04.e01.Edge;
import tp04.e01.Vertex;

import java.util.*;

public class RouteFinder<V> {

    /**
     * Genera una lista de rutas posibles entre dos ciudades especificadas, empleando un algoritmo DFS recursivo.
     *
     * @param start ID de la ciudad de origen.
     * @param end   ID de la ciudad de destino.
     * @param graph Grafo en el que se realiza la búsqueda.
     * @return Una lista de rutas posibles entre las dos ciudades especificadas.
     */
    public List<List<Integer>> findRoutes(int start, int end, AdjacencyListUndirectedGraph<V, Route> graph) {
        List<Integer> route = new ArrayList<>();
        List<List<Integer>> allRoutes = new ArrayList<>();
        boolean[] visited = new boolean[graph.getVertexCount()];

        // Se comienza el recorrido desde la ciudad de inicio
        route.add(start);
        findRoutesRec(start, end, route, allRoutes, visited, graph);

        return allRoutes;
    }

    /**
     * Búsqueda recursiva de rutas entre dos ciudades especificadas.
     *
     * @param currentCity ID de la ciudad visitada actualmente.
     * @param endCity     ID de la ciudad de destino
     * @param route       Ruta con el recorrido actual.
     * @param allRoutes   Lista de rutas encontradas hasta el momento.
     * @param visited     Arreglo que almacena
     * @param graph       Grafo en el que se realiza la búsqueda recursiva.
     */
    private void findRoutesRec(int currentCity, int endCity, List<Integer> route, List<List<Integer>> allRoutes,
                               boolean[] visited, AdjacencyListUndirectedGraph<V, Route> graph) {
        // Si se llega a la ciudad destino, se agrega la ruta al conjunto solución
        if (currentCity == endCity) {
            allRoutes.add(new ArrayList<>(route));
            return;
        }

        // Se marca la ciudad actual como visitada
        visited[currentCity] = true;

        // Ciudades adyacentes
        Iterator<Integer> adjacents = graph.getAdjacents(currentCity);
        while (adjacents.hasNext()) {
            int adjacentCity = adjacents.next();

            if (!visited[adjacentCity] && isRouteAvailible(currentCity, adjacentCity, graph)) {
                route.add(adjacentCity); // Se agrega la ciudad adyacente a la ruta
                findRoutesRec(adjacentCity, endCity, route, allRoutes, visited, graph); // Llamado recursivo
                route.removeLast(); // Retroceso
            }
        }

        // Una vez exploradas todas las ciudades adyacentes, se marca la actual como no visitada
        visited[currentCity] = false;
    }

    /**
     * Verifica si es posible viajar entre dos ciudades, basándose en el estado de la ruta que las conecta.
     *
     * @param cityId1 ID de la ciudad de origen.
     * @param cityId2 ID de la ciudad de destino.
     * @param graph   Grafo que almacena los vértices (ciudades) y las aristas (rutas).
     * @return {@code true} si la ruta está disponible, {@code false} en caso contrario.
     */
    private boolean isRouteAvailible(int cityId1, int cityId2, AdjacencyListUndirectedGraph<V, Route> graph) {
        Vertex<V, Route> city1 = graph.getVertexById(cityId1);
        Edge<Route> route = city1.getEdgeToVertex(cityId2);
        return route != null && route.getLabel().isActive();
    }

}
