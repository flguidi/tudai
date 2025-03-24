package tp02_2;

public class Main {
    public static void main(String[] args) {
        // Se instancia un ABB
        BinarySearchTree tree = new BinarySearchTree();

        /* ==================== EJERCICIO 1 ==================== */
        System.out.println("EJERCICIO 1");

        // Agregar elementos
        tree.add(5);
        tree.add(2);
        tree.add(1);
        tree.add(4);
        tree.add(3);
        tree.add(7);
        tree.add(6);
        tree.add(9);
        tree.add(8);
        tree.add(1); // No se agregan los valores repetidos

        // Eliminar elementos
        int value = 2;
        boolean removed = tree.remove(value);
        if (removed) {
            System.out.println("Se eliminó el elemento " + value);
        }

        // Recorridos
        System.out.print("Pre-orden: " + tree.printPreOrder());
        System.out.print(" En-orden: " + tree.printInOrder());
        System.out.println(" Post-orden: " + tree.printPostOrder());

        // Obtener raíz
        System.out.println("Raíz: " + tree.getRoot());

        // Determinar si el árbol está vacío
        System.out.println("Árbol vacío: " + tree.isEmpty());

        // Búsqueda de valor
        value = 0;
        System.out.println("Búsqueda del valor " + value + ": " + tree.hasValue(value));
        value = 7;
        System.out.println("Búsqueda del valor " + value + ": " + tree.hasValue(value));

        // Valor mínimo y valor máximo
        System.out.println("Valor mínimo: " + tree.getMinValue());
        System.out.println("Valor máximo: " + tree.getMaxValue());

        // Altura
        System.out.println("Altura: " + tree.getHeight());

        // Rama más larga
        System.out.println("Rama más larga: " + tree.getLongestBranch());

        // Lista de nodos externos (hojas)
        System.out.println("Hojas: " + tree.getExternalNodes());

        // Lista de nodos a un nivel determinado
        int level = 2;
        System.out.println("Nodos en el nivel " + level + ": " + tree.getValuesAtLevel(level));


        /* ==================== EJERCICIO 2 ==================== */
        System.out.println("\nEJERCICIO 2");

        // Suma de nodos internos
        System.out.println("Suma de nodos internos: " + tree.sumInternalNodes());


        /* ==================== EJERCICIO 3 ==================== */
        System.out.println("\nEJERCICIO 3");

        // Lista de hojas que superan un número dado
        value = 5;
        System.out.println("Lista de hojas con valor mayor que " + value + ": " + tree.leavesGreaterThan(value));


        /* ==================== EJERCICIO 4 ==================== */
        /*
            Función restaDeNodosHijos() -> vacío:
                restaDeNodosHijos(raíz);


            Función restaDeNodosHijos(actual: Nodo) -> entero:
                Si actual = null:
                    Retornar 0;

                Sino Si actual.esHoja():
                    Retornar actual.valor;

                Sino:
                    resta <- restaDeNodosHijos(actual.hijoIzq) - restaDeNodosHijos(actual.hijoDer);
                    actual.valor <- resta;
                    Retornar resta;
         */


        /* ==================== EJERCICIO 5 ==================== */
        /*
            Función palabrasDeNVocales(cantVocales: int) -> vacío:
                lista <- nueva Lista;
                palabrasDeNVocales(raiz, cantVocales, 0, "", lista);
                Retornar lista;


            Función palabrasDeNVocales(actual: Nodo, cantVocales: entero, contadorVocales: entero,
                                       palabra: cadena, lista: Lista) -> vacío:
                Si actual = null:
                    Retornar;

                palabra <- palabra + actual.valor;

                Si actual.esVocal():
                    contadorVocales <- contadorVocales + 1;

                Si cantVocales >= contadorVocales y actual.esHoja():
                    lista.agregar(palabra);
                    Retornar;
                Si no:
                    palabrasDeNVocales(actual.hijoIzq, cantVocales, contadorVocales, palabra, lista);
                    palabrasDeNVocales(actual.hijoDer, cantVocales, contadorVocales, palabra, lista);
         */


        /* ==================== EJERCICIO 6 ==================== */
        /*
            1) Dado que se necesita insertar, eliminar y acceder a los libros del catálogo, una estructura de datos
               adecuada podría ser un árbol binario de búsqueda, especialmente un árbol AVL o rojo-negro ya que, al
               ser balanceados, proporcionan tiempos logarítmicos para realizar dichas operaciones.

               Cada nodo del árbol contendría un objeto Libro, con un identificador único (clave de bifurcación) y
               datos relacionados (título, autor, género, año de publicación, cantidad de ejemplares, etc.).

            2) Obtener la cantidad de ejemplares:
               Podría buscarse el libro por su identificador único y devolver su atributo "cantidadDeEjemplares".
               Complejidad: O(log2N).

               Obtener todos los libros de un género dado:
               Podría utilizarse otro ABB balanceado que almacene los géneros del catálogo. Cada nodo contendría
               un género, con su identificador único (clave) y una lista simplemente vinculada (lista de factoreo)
               que contenga las referencias a los libros pertenecientes a dicho género. Complejidad: O(Nlog2N).

               Obtener todos los libros publicados entre dos años de publicación dados:
               Podría utilizarse otro ABB balanceado que almacene los años de publicación. Cada nodo contendría un año
               (clave) y una lista simplemente vinculada (lista de factoreo) que contenga las referencias a los libros
               publicados ese año. La búsqueda tendrá en cuenta el rango de años solicitado, lo cual determinará el
               recorrido en el árbol. Complejidad: O(Nlog2N).
         */
    }
}
