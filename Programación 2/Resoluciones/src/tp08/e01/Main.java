package tp08.e01;

public class Main {
    public static void main(String[] args) {
        // a) LISTAS VINCULADAS
        System.out.println("LISTA VINCULADA");

        // Se instancia una lista vinculada
        ListaVinculada listaVinculada = new ListaVinculada();
        System.out.println(listaVinculada);

        // Se instancian elementos genéricos (animales)
        Elemento a1 = new Elemento("Perro");
        Elemento a2 = new Elemento("Gato");
        Elemento a3 = new Elemento("Paloma");
        Elemento a4 = new Elemento("Tortuga");

        // add(Object element)
        System.out.print("add(Object element): ");
        listaVinculada.add(a1);
        listaVinculada.add(a2);
        listaVinculada.add(a3);
        listaVinculada.add(a4);
        System.out.println(listaVinculada);

        // add(int index, Object element):
        System.out.print("add(int index, Object element): ");
        Elemento a5 = (Elemento) listaVinculada.add(1, new Elemento("Pato"));
        System.out.println(listaVinculada);
        System.out.println("Elemento agregado: " + a5);

        // size()
        System.out.print("size(): ");
        System.out.println(listaVinculada.size());

        // isEmpty()
        System.out.print("isEmpty(): ");
        System.out.println(listaVinculada.isEmpty());

        // contains()
        System.out.print("contains(Object element): ");
        System.out.println(listaVinculada.contains(a5));

        // get(int index)
        System.out.print("get(int index): ");
        System.out.println(listaVinculada.get(0));

        // set(int index, Object element) :
        System.out.print("set(int index, Object element): ");
        Object animalAnterior = listaVinculada.set(3, new Elemento("Tucán"));
        System.out.println(listaVinculada);
        System.out.println("Elemento reemplazado: " + animalAnterior);

        // remove(Object element)
        System.out.print("remove(Object element): ");
        boolean seElimino = listaVinculada.remove(a2);
        System.out.println(listaVinculada);
        System.out.println("¿Se eliminó el elemento " + a2 + "?: " + seElimino);

        // remove(int index)
        System.out.print("remove(int index): ");
        Object animalEliminado = listaVinculada.remove(2);
        System.out.println(listaVinculada);
        System.out.println("Elemento eliminado: " + animalEliminado);

        // addAll(SimpleList otherList)
        System.out.print("addAll(SimpleList otherList): ");
        ListaVinculada otraListaVinculada = new ListaVinculada();
        Elemento a6 = new Elemento("Cocodrilo");
        Elemento a7 = new Elemento("Buho");
        otraListaVinculada.add(a6);
        otraListaVinculada.add(a7);
        listaVinculada.addAll(otraListaVinculada);
        System.out.println(listaVinculada);

        // indexOf(Object element)
        System.out.print("indexOf(Object element): ");
        System.out.println(listaVinculada.indexOf(a6));

        // clear()
        System.out.print("clear(): ");
        listaVinculada.clear();
        System.out.println(listaVinculada);

        // --------------------------------------------------------------------

        // b) LISTA BASADA EN ARREGLOS
        System.out.println("\nLISTA BASADA EN ARREGLOS");

        // Se instancia una lista basada en arreglo
        ListaArreglos listaArreglos = new ListaArreglos();
        System.out.println(listaArreglos);

        // Se instancian elementos genéricos (vehículos)
        Elemento v1 = new Elemento("Auto");
        Elemento v2 = new Elemento("Moto");
        Elemento v3 = new Elemento("Camioneta");
        Elemento v4 = new Elemento("Tren");

        // add(Object element)
        System.out.print("add(Object element): ");
        listaArreglos.add(v1);
        listaArreglos.add(v2);
        listaArreglos.add(v3);
        listaArreglos.add(v4);
        System.out.println(listaArreglos);

        // add(int index, Object element):
        System.out.print("add(int index, Object element): ");
        Elemento v5 = (Elemento) listaArreglos.add(3, new Elemento("Avión"));
        System.out.println(listaArreglos);
        System.out.println("Elemento agregado: " + v5);

        // size()
        System.out.print("size(): ");
        System.out.println(listaArreglos.size());

        // isEmpty()
        System.out.print("isEmpty(): ");
        System.out.println(listaArreglos.isEmpty());

        // contains()
        System.out.print("contains(Object element): ");
        System.out.println(listaArreglos.contains(v5));

        // get(int index)
        System.out.print("get(int index): ");
        System.out.println(listaArreglos.get(0));

        // set(int index, Object element) :
        System.out.print("set(int index, Object element): ");
        Object vehiculoAnterior = listaArreglos.set(2, new Elemento("Camión"));
        System.out.println(listaArreglos);
        System.out.println("Elemento reemplazado: " + vehiculoAnterior);

        // remove(Object element)
        System.out.print("remove(Object element): ");
        seElimino = listaArreglos.remove(v2);
        System.out.println(listaArreglos);
        System.out.println("¿Se eliminó el elemento " + v2 + "?: " + seElimino);

        // remove(int index)
        System.out.print("remove(int index): ");
        Object vehiculoEliminado = listaArreglos.remove(2);
        System.out.println(listaArreglos);
        System.out.println("Elemento eliminado: " + vehiculoEliminado);

        // addAll(SimpleList otherList)
        System.out.print("addAll(SimpleList otherList): ");
        ListaArreglos otraListaArreglos = new ListaArreglos();
        Elemento v6 = new Elemento("Barco");
        Elemento v7 = new Elemento("Helicóptero");
        Elemento v8 = new Elemento("Bicicleta");
        otraListaArreglos.add(v6);
        otraListaArreglos.add(v7);
        otraListaArreglos.add(v8);
        listaArreglos.addAll(otraListaArreglos);
        System.out.println(listaArreglos);

        // indexOf(Object element)
        System.out.print("indexOf(Object element): ");
        System.out.println(listaArreglos.indexOf(v8));

        // clear()
        System.out.print("clear(): ");
        listaArreglos.clear();
        System.out.println(listaArreglos);
    }
}