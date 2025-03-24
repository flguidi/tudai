package tp04.e01;

/**
 * Representa un grafo no dirigido utilizando una matriz de adyacencia.
 * Esta clase extiende de {@link AdjacencyMatrixDirectedGraph} y sobreescribe los métodos
 * para gestionar aristas no dirigidas, es decir, aquellas en las que la relación
 * entre los vértices es bidireccional.
 *
 * @param <V> El tipo de los valores de los vértices.
 * @param <E> El tipo de los pesos o etiquetas de las aristas.
 */
public class AdjacencyMatrixUndirectedGraph<V, E> extends AdjacencyMatrixDirectedGraph<V, E> {

    /**
     * Agrega una arista no dirigida entre dos vértices dados.
     * En un grafo no dirigido, se agregan dos aristas, una de cada vértice al otro.
     * Esto significa que las posiciones [vertexId1][vertexId2] y [vertexId2][vertexId1]
     * de la matriz de adyacencia se llenan con el mismo peso o etiqueta.
     * Complejidad: O(1).
     *
     * @param vertexId1 El ID del primer vértice (origen).
     * @param vertexId2 El ID del segundo vértice (destino).
     * @param label     El peso o etiqueta de la arista.
     */
    @Override
    public void addEdge(Integer vertexId1, Integer vertexId2, E label) {
        if (containsVertex(vertexId1) && containsVertex(vertexId2)) {
            adjacencyMatrix[vertexId1][vertexId2] = label;
            adjacencyMatrix[vertexId2][vertexId1] = label;
        }
    }

    /**
     * Elimina una arista no dirigida entre dos vértices dados.
     * En un grafo no dirigido, se eliminan ambas aristas, de vertexId1 a vertexId2
     * y de vertexId2 a vertexId1, estableciendo los valores correspondientes a null.
     * Complejidad: O(1).
     *
     * @param vertexId1 El ID del primer vértice (origen).
     * @param vertexId2 El ID del segundo vértice (destino).
     */
    @Override
    public void removeEdge(Integer vertexId1, Integer vertexId2) {
        adjacencyMatrix[vertexId1][vertexId2] = null;
        adjacencyMatrix[vertexId2][vertexId1] = null;
    }

}
