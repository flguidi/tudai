package tp01;

public class Main {

    public static void main(String[] args) {
        /*----- EJERCICIO 1 -----*/
        // Se instancia una lista simplemente vinculada de strings
        SimpleLinkedList<String> simpleLinkedList1 = new SimpleLinkedList<>();
        System.out.println("EJERCICIO 1");

        // Inserción de elementos a la lista e impresión por consola
        simpleLinkedList1.insertFront("A");
        simpleLinkedList1.insertFront("B");
        simpleLinkedList1.insertFront("C");
        simpleLinkedList1.insertFront("D");
        simpleLinkedList1.insertFront("E");
        System.out.println("Lista: " + simpleLinkedList1);

        // Eliminación de elementos de la lista e impresión por consola
        String removedElement = simpleLinkedList1.extractFront();
        System.out.println("Elemento eliminado: " + removedElement);
        System.out.println("Lista: " + simpleLinkedList1);

        // Se verifica si la lista está vacía
        System.out.println("Lista vacía: " + simpleLinkedList1.isEmpty());

        // Tamaño de la lista
        System.out.println("Tamaño: " + simpleLinkedList1.size());

        // Se obtiene información de un nodo especificado
        int index = 2;
        System.out.println("Elemento en la posición " + index + ": " + simpleLinkedList1.get(index));


        /*----- EJERCICIO 2 -----*/
        //                                       Array   |   Lista vinculada
        // Insertar al principio:                O(n)    |   O(1)
        // Buscar un elemento en una posición:   O(1)    |   O(n)
        // Determinar la cantidad de elementos:  O(1)    |   O(1) con variable auxiliar
        // Borrar un elemento:                   O(n)    |   O(n)


        /*----- EJERCICIO 3 -----*/
        System.out.println("\nEJERCICIO 3");

        // Búsqueda de índice de un elemento dado
        String element = "A";
        System.out.println(("Posición del elemento " + element + ": ") + simpleLinkedList1.indexOf(element));


        /*----- EJERCICIO 4 -----*/
        System.out.println("\nEJERCICIO 4");
        System.out.print("Lista recorrida con Iterable/Iterator: ");
        for (String vehicle : simpleLinkedList1)
            System.out.print(vehicle + " ");
        System.out.println();


        /*----- EJERCICIO 5 -----*/
        System.out.println("\nEJERCICIO 5");

        // Se crea una segunda lista
        SimpleLinkedList<String> simpleLinkedList2 = new SimpleLinkedList<>();
        simpleLinkedList2.insertFront("A");
        simpleLinkedList2.insertFront("D");
        simpleLinkedList2.insertFront("F");
        simpleLinkedList2.insertFront("C");

        // Combinación y ordenamiento de listas
        System.out.println("a. Combinación de listas desordenadas: ");
        ListUtilities<String> listUtilities = new ListUtilities<>();
        SimpleLinkedList<String> output = listUtilities.intersectionDisorderedLists(simpleLinkedList1, simpleLinkedList2);
        System.out.println("Lista 1: " + simpleLinkedList1);
        System.out.println("Lista 2: " + simpleLinkedList2);
        System.out.println("Combinación: " + output);

        System.out.println("\nb. Combinación de listas ordenadas: ");
        simpleLinkedList1 = simpleLinkedList1.selectionSort();
        simpleLinkedList2 = simpleLinkedList2.selectionSort();
        output = listUtilities.intersectionOrderedLists(simpleLinkedList1, simpleLinkedList2);
        System.out.println("Lista 1: " + simpleLinkedList1);
        System.out.println("Lista 2: " + simpleLinkedList2);
        System.out.println("Combinación: " + output);


        /*----- EJERCICIO 6 -----*/
        System.out.println("\nEJERCICIO 6");

        // Se crea una nueva lista con los elementos de la primera que no están en la segunda
        output = listUtilities.difference(simpleLinkedList1, simpleLinkedList2);
        System.out.println("Lista 1 sin elementos de la lista 2: " + output);


        /*----- EJERCICIO 7 -----*/
        System.out.println("\nEJERCICIO 7");

        // Se instancia una lista doblemente vinculada
        DoubleLinkedList<String> doubleLinkedList = new DoubleLinkedList<>();

        // Se insertan elementos al comienzo y al final de la lista
        doubleLinkedList.insertFront("1");
        doubleLinkedList.insertFront("2");
        doubleLinkedList.insertEnd("3");
        doubleLinkedList.insertEnd("4");
        System.out.println("Lista doblemente vinculada: " + doubleLinkedList);

        // Se eliminan elementos al comienzo y al final de la lista
        removedElement = doubleLinkedList.extractFront();
        System.out.println("Elemento eliminado: " + removedElement);
        removedElement = doubleLinkedList.extractEnd();
        System.out.println("Elemento eliminado: " + removedElement);
        System.out.println("Lista doblemente vinculada: " + doubleLinkedList);

        // Se verifica si la lista está vacía
        System.out.println("Lista vacía: " + doubleLinkedList.isEmpty());

        // Tamaño de la lista
        System.out.println("Tamaño: " + doubleLinkedList.size());

        // Se obtiene información de un nodo especificado
        index = 1;
        System.out.println("Elemento en la posición " + index + ": " + doubleLinkedList.get(index));

        // Búsqueda de índice de un elemento dado
        element = "3";
        System.out.println(("Posición del elemento " + element + ": ") + doubleLinkedList.indexOf(element));
    }

}
