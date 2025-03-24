package tp06.e05;

import tp06.e05.graph.*;

import java.util.*;

/**
 * Desde un cierto conjunto grande de ciudades del interior de una provincia, se desean transportar
 * cereales hasta alguno de los 3 puertos pertenecientes al litoral de la provincia. Se pretende
 * efectuar el transporte total con mínimo costo sabiendo que el flete es más caro cuanto más
 * distancia tiene que recorrer. Dé un algoritmo que resuelva este problema, devolviendo para cada
 * ciudad el camino que debería recorrer hacia el puerto de menor costo.
 */
public class CerealShippingProblem {

    /**
     * Asigna a cada ciudad el puerto más cercano con el costo más bajo.
     *
     * @param graph El grafo que representa el mapa de la provincia, donde las ciudades son vértices y las aristas
     *              representan las conexiones con sus respectivos costos de transporte.
     * @return Una lista de listas donde cada lista contiene el camino desde una ciudad hacia el puerto más cercano.
     */
    public List<List<String>> assignPorts(DirectedGraph<String, Integer> graph) {
        List<List<String>> solution = new ArrayList<>();

        Iterator<Integer> vertices = graph.getVertices();
        while (vertices.hasNext()) {
            int vertexId = vertices.next();
            Vertex<String, Integer> vertex = graph.getVertexById(vertexId);
            if (vertex.getValue().contains("C")) {
                solution.add(assignNearestPort(vertexId, graph));
            }
        }

        return solution;
    }

    /**
     * Encuentra el puerto más cercano desde la ciudad de origen utilizando el algoritmo de Dijkstra.
     * El algoritmo calcula las distancias mínimas hacia todos los vértices del grafo y selecciona el
     * puerto más cercano.
     *
     * @param origin El ID del vértice que representa la ciudad de origen.
     * @param graph  El grafo que representa el mapa de la provincia.
     * @return Una lista que contiene el camino desde la ciudad de origen hasta el puerto más cercano.
     */
    public List<String> assignNearestPort(int origin, DirectedGraph<String, Integer> graph) {
        int[] d = new int[graph.getVertexCount()];
        Arrays.fill(d, Integer.MAX_VALUE);
        int[] p = new int[graph.getVertexCount()];
        Arrays.fill(p, -1);

        // Cola de prioridad que almacena las ciudades con distancias más cortas
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(i -> d[i]));

        // Se agrega la ciudad de origen a la cola y se marca como visitada
        pq.add(origin);
        d[origin] = 0;

        while (!pq.isEmpty()) {
            int vertexId = pq.poll(); // Se obtiene la ciudad con distancia más corta
            Vertex<String, Integer> vertex = graph.getVertexById(vertexId);

            // Se visitan vértices adyacentes
            Iterator<Integer> adjacents = graph.getAdjacents(vertexId);
            while (adjacents.hasNext()) {
                int adjacent = adjacents.next();
                int weight = graph.getEdge(vertexId, adjacent).getLabel();
                int newDistance = d[vertexId] + weight;

                // Si se encuentra una distancia más corta, se actualiza la distancia y el camino
                if (newDistance < d[adjacent]) {
                    d[adjacent] = newDistance;
                    p[adjacent] = vertexId;
                    pq.add(adjacent);
                }
            }
        }

        // Una vez procesado el grafo, se busca el puerto más cercano
        int closestPortId = -1;
        int minDistance = Integer.MAX_VALUE;

        // Se itera por todos los vértices y se buscan los puertos
        Iterator<Integer> vertices = graph.getVertices();
        while (vertices.hasNext()) {
            int vertexId = vertices.next();
            Vertex<String, Integer> vertex = graph.getVertexById(vertexId);

            // Se verifica si el vértice es un puerto
            if (vertex.getValue().contains("P")) {
                // Si se encuentra un puerto con una distancia menor, se actualiza
                if (d[vertexId] < minDistance) {
                    minDistance = d[vertexId];
                    closestPortId = vertexId;
                }
            }
        }

        // Si se encuentra el puerto más cercano, se reconstruye el camino hacia él
        if (closestPortId != -1) {
            return reconstructPath(closestPortId, p, graph);
        }

        // Si no se encuentra ningún puerto alcanzable, se devuelve una lista vacía
        return new ArrayList<>();
    }

    /**
     * Reconstruye el camino desde el puerto más cercano hacia la ciudad de origen utilizando el arreglo
     * de predecesores.
     *
     * @param port El ID del puerto de destino.
     * @param p    El arreglo de predecesores utilizado por el algoritmo de Dijkstra.
     * @param graph El grafo que representa el mapa de la provincia.
     * @return Una lista que contiene los vértices (ciudades y puertos) en el camino desde la ciudad de
     *         origen hasta el puerto.
     */
    private List<String> reconstructPath(int port, int[] p, DirectedGraph<String, Integer> graph) {
        List<String> path = new ArrayList<>();
        int currentVertex = port;

        while (currentVertex != -1) {
            String vertex = graph.getVertexById(currentVertex).getValue();
            path.add(vertex);  // Se añade el vértice al camino
            currentVertex = p[currentVertex]; // Se avanza al siguiente vértice
        }

        Collections.reverse(path);  // Se invierte el camino para que vaya de origen a destino
        return path;
    }

}
