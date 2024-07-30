package tp08.e03;

public class Main {
    public static void main(String[] args) {
        // Se instancia un árbol binario de búsqueda (BST)
        ArbolBinarioBusqueda arbol = new ArbolBinarioBusqueda();

        // Se insertan elementos
        arbol.insertar(8); // Se establece como raíz
        arbol.insertar(3);
        arbol.insertar(1);
        arbol.insertar(6);
        arbol.insertar(4);
        arbol.insertar(7);
        arbol.insertar(10);
        arbol.insertar(14);
        arbol.insertar(13);

        // Se asigna una acción para imprimir los nodos por pantalla
        System.out.println("IMPRESIÓN DE NODOS POR PANTALLA");
        arbol.setAccion(new ImprimirEnPantalla());

        // Se ejecuta la acción inorden (izquierda - raiz - derecha)
        arbol.ejecutarEnOrden();

        // Se asigna otra acción (insertar nodos en orden ascendente) y se ejecuta inorden
        System.out.println("\nINSERCIÓN DE NODOS EN LISTA ASCENDENTE");
        AccionEjecutable accionListaAsc = new AgregarAListaAscendente();
        arbol.setAccion(accionListaAsc);
        arbol.ejecutarEnOrden();
        System.out.println(accionListaAsc);

        // Se asigna otra acción (insertar nodos en orden descendente) y se ejecuta en-orden
        System.out.println("INSERCIÓN DE NODOS EN LISTA DESCENDENTE");
        AccionEjecutable accionListaDesc = new AgregarAListaDescendente();
        arbol.setAccion(accionListaDesc);
        arbol.ejecutarEnOrden();
        System.out.println(accionListaDesc);

        // Se asigna otra acción (contador de nodos visitados) y se ejecuta inorden
        System.out.println("CONTADOR DE NODOS RECORRIDOS");
        AccionEjecutable accionContador = new ContarElemento();
        arbol.setAccion(accionContador);
        arbol.ejecutarEnOrden();
        System.out.println("Cantidad de nodos: " + accionContador);
    }
}
