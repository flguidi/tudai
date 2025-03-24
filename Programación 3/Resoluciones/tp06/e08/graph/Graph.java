package tp06.e08.graph;

import java.util.Iterator;

/**
 * Interfaz que define las operaciones básicas para un grafo, donde los vértices
 * son de tipo genérico V y las aristas (edges) tienen un peso de tipo genérico E.
 * Esta interfaz es común tanto para grafos dirigidos como no dirigidos, y puede
 * ser utilizada para implementaciones que usen representaciones de lista de adyacencia
 * o matriz de adyacencia.
 *
 * @param <V> Tipo de los vértices del grafo.
 * @param <E> Tipo del peso de las aristas.
 */
public interface Graph<V, E> {

    // Agrega un vértice
    void addVertex(V value);

    // Borra un vértice
    void removeVertex(Integer vertexId);

    // Verifica si existe un vértice
    boolean containsVertex(Integer vertexId);

    // Devuelve la cantidad total de vértices en el grafo
    int getVertexCount();

    // Agrega una arista con una etiqueta, que conecta dos vértices dados
    void addEdge(Integer vertexId1, Integer vertexId2, E label);

    // Borra la arista que conecta dos vértices dados
    void removeEdge(Integer vertexId1, Integer vertexId2);

    // Verifica si existe una arista entre dos vértices
    boolean containsEdge(Integer vertexId1, Integer vertexId2);

    // Devuelve la cantidad total de aristas en el grafo
    int getEdgeCount();

    // Obtiene un iterador que permite recorrer el ID de cada vértice del grafo
    Iterator<Integer> getVertices();

    // Obtiene un iterador que permite recorrer todos los vértices adyacentes a un vértice dado
    Iterator<Integer> getAdjacents(Integer vertexId);

    // Obtiene un iterador que permite recorrer todas las aristas del grafo
    Iterator<Edge<E>> getEdges();

    // Obtiene un iterador que permite recorrer todas las aristas que parten desde un vértice dado
    Iterator<Edge<E>> getEdges(Integer vertexId);

}
