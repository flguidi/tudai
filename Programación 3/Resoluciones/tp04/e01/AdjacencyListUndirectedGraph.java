package tp04.e01;

/**
 * Representa un grafo no dirigido utilizando una lista de adyacencia.
 * En un grafo no dirigido, cada arista se almacena en ambas direcciones, es decir,
 * si existe una arista entre los vértices A y B, también existe entre B y A.
 * Esta implementación extiende de {@link AdjacencyListDirectedGraph} y sobrescribe los métodos
 * para manejar la simetría de las aristas en ambos sentidos.
 *
 * @param <V> El tipo de los valores de los vértices.
 * @param <E> El tipo de los pesos o etiquetas de las aristas.
 */
public class AdjacencyListUndirectedGraph<V, E> extends AdjacencyListDirectedGraph<V, E> {

    /**
     * Agrega una arista entre dos vértices en un grafo no dirigido.
     * La arista se almacena en ambas direcciones (de vertexId1 a vertexId2 y viceversa).
     * Complejidad: O(1).
     *
     * @param vertexId1 El ID del vértice origen.
     * @param vertexId2 El ID del vértice destino.
     * @param label     El peso o etiqueta de la arista.
     */
    @Override
    public void addEdge(Integer vertexId1, Integer vertexId2, E label) {
        if (containsVertex(vertexId1) && containsVertex(vertexId2)) {
            vertices.get(vertexId1).addEdge(new Edge<>(vertexId1, vertexId2, label));
            vertices.get(vertexId2).addEdge(new Edge<>(vertexId2, vertexId1, label));
        }
    }

    /**
     * Elimina una arista entre dos vértices en un grafo no dirigido.
     * La arista se elimina en ambas direcciones (de vertexId1 a vertexId2 y viceversa).
     * Complejidad: O(1).
     *
     * @param vertexId1 El ID del vértice origen.
     * @param vertexId2 El ID del vértice destino.
     */
    @Override
    public void removeEdge(Integer vertexId1, Integer vertexId2) {
        if (containsVertex(vertexId1) && containsVertex(vertexId2)) {
            vertices.get(vertexId1).removeEdge(vertexId2);
            vertices.get(vertexId2).removeEdge(vertexId1);
        }
    }

}
