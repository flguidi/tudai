package tp04.e08;

import tp04.e01.AdjacencyListDirectedGraph;

public class Main {

    public static void main(String[] args) {
        AdjacencyListDirectedGraph<Task, Integer> graph = new AdjacencyListDirectedGraph<>();

        graph.addVertex(new Task("T0", "Descripción Tarea 0", 0));
        graph.addVertex(new Task("T1", "Descripción Tarea 1", 4));
        graph.addVertex(new Task("T2", "Descripción Tarea 2", 18));
        graph.addVertex(new Task("T3", "Descripción Tarea 3", 4));
        graph.addVertex(new Task("T4", "Descripción Tarea 4", 13));
        graph.addVertex(new Task("T5", "Descripción Tarea 5", 22));
        graph.addVertex(new Task("T6", "Descripción Tarea 6", 18));
        graph.addVertex(new Task("T7", "Descripción Tarea 7", 12));
        graph.addVertex(new Task("T8", "Descripción Tarea 8", 3));
        graph.addVertex(new Task("T9", "Descripción Tarea 9", 2));
        graph.addVertex(new Task("T10", "Descripción Tarea 10", 3));
        graph.addVertex(new Task("T11", "Descripción Tarea 11", 1));
        graph.addVertex(new Task("T12", "Descripción Tarea 12", 5));

        graph.addEdge(0, 1, 0);
        graph.addEdge(0, 2, 0);
        graph.addEdge(1, 3, 3);
        graph.addEdge(2, 5, 1);
        graph.addEdge(2, 7, 12);
        graph.addEdge(3, 4, 5);
        graph.addEdge(3, 6, 8);
        graph.addEdge(4, 11, 3);
        graph.addEdge(5, 6, 2);
        graph.addEdge(6, 12, 2);
        graph.addEdge(6, 10, 6);
        graph.addEdge(7, 8, 7);
        graph.addEdge(8, 9, 4);
        graph.addEdge(9, 10, 1);
        graph.addEdge(11, 12, 9);

        System.out.println(graph);

        // Búsqueda de secuencia de ejecución crítica
        TaskManager tm = new TaskManager();
        System.out.println("Secuencia de ejecución crítica: " + tm.computeCriticalSequence(0, graph));
    }

}
