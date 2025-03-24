package tp04.e07;

import tp04.e01.AdjacencyListUndirectedGraph;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        AdjacencyListUndirectedGraph<String, Route> graph = new AdjacencyListUndirectedGraph<>();

        graph.addVertex("Ciudad A");
        graph.addVertex("Ciudad B");
        graph.addVertex("Ciudad C");
        graph.addVertex("Ciudad D");
        graph.addVertex("Ciudad E");

        graph.addEdge(0, 1, new Route("A-B", 200, true));
        graph.addEdge(0, 2, new Route("A-C", 100, false));
        graph.addEdge(0, 3, new Route("A-D", 200, true));
        graph.addEdge(1, 4, new Route("B-E", 260, true));
        graph.addEdge(2, 3, new Route("C-D", 140, true));
        graph.addEdge(2, 4, new Route("C-E", 120, true));
        graph.addEdge(3, 4, new Route("D-E", 250, true));

        System.out.println(graph);

        // ┌── A ──┐
        // │   ┊x  │   <--- Ruta A-C cerrada
        // B   C ─ D
        // │   │   │
        // └── E ──┘

        // Lista de rutas entre dos ciudades
        RouteFinder<String> rf = new RouteFinder<>();
        int start = 0;
        int end = 4;

        System.out.println("Rutas desde " + start + " a " + end + ":");
        List<List<Integer>> routes = rf.findRoutes(start, end, graph);
        if (routes.isEmpty()) {
            System.out.println("No se encontraron rutas.");
        } else {
            for (List<Integer> route : routes) {
                System.out.println(route);
            }
        }
    }

}
