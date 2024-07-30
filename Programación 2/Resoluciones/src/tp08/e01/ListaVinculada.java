package tp08.e01;

public class ListaVinculada implements SimpleList {
    // Atributos
    private Nodo primero;
    private Nodo ultimo;
    private int cantNodos;

    // Constructores
    public ListaVinculada() {
        this.primero = null;
        this.ultimo = null;
        this.cantNodos = 0;
    }

    // Métodos (Implementación de métodos abstractos de la interfaz)
    @Override
    public int size() {
        return cantNodos;
    }

    @Override
    public boolean isEmpty() {
        return cantNodos == 0;
    }

    @Override
    public boolean contains(Object elemento) {
        int i = 0;
        while (i < this.size()) {
            if (this.get(i).equals(elemento))
                return true;
            i++;
        }
        return false;
    }

    @Override
    public void add(Object elemento) {
        Nodo nuevo = new Nodo(elemento);
        if (this.isEmpty()) {
            primero = nuevo;
            ultimo = nuevo;
        } else {
            ultimo.setSiguiente(nuevo);
            ultimo = nuevo;
        }
        cantNodos++;
    }

    @Override
    public Object add(int indice, Object elemento) {
        if (indice >= 0 && indice < this.size()) {
            Nodo nuevo = new Nodo(elemento);
            if (indice == 0) {
                nuevo.setSiguiente(primero);
                primero = nuevo;
            } else {
                Nodo actual = obtenerNodo(indice - 1);
                nuevo.setSiguiente(actual.getSiguiente());
                actual.setSiguiente(nuevo);
            }
            cantNodos++;
            return elemento;
        }
        return null;
    }

    @Override
    public Object set(int indice, Object elemento) {
        if (indice >= 0 && indice < this.size()) {
            Nodo nodo = obtenerNodo(indice);
            Object reemplazado = nodo.getElemento();
            nodo.setElemento(elemento);
            return reemplazado;
        }
        return null;
    }

    @Override
    public boolean remove(Object elemento) {
        int indice = this.indexOf(elemento);
        if (indice == -1)
            return false; // El elemento no se encuentra en la lista

        if (indice == 0) {
            primero = primero.getSiguiente(); // Caso especial: Eliminar el primer elemento
        } else {
            // Caso general: Eliminar cualquier otro elemento
            Nodo anterior = this.obtenerNodo(indice - 1);
            Nodo aEliminar = anterior.getSiguiente();
            anterior.setSiguiente(aEliminar.getSiguiente());
        }

        cantNodos--;
        return true;
    }

    @Override
    public Object remove(int indice) {
        if (indice >= 0 && indice < this.size()) {
            Nodo eliminado;
            if (indice == 0) {
                // Caso especial: Eliminar el primer elemento
                eliminado = primero;
                primero = primero.getSiguiente();
            } else {
                // Caso general: Eliminar cualquier otro elemento
                Nodo anterior = this.obtenerNodo(indice - 1);
                eliminado = anterior.getSiguiente();
                anterior.setSiguiente(eliminado.getSiguiente());
            }

            cantNodos--;
            return eliminado.getElemento();
        }
        return null;
    }

    @Override
    public void addAll(SimpleList otraLista) {
        if (otraLista != null) {
            for (int i = 0; i < otraLista.size(); i++)
                this.add(otraLista.get(i));
        }
    }

    @Override
    public void clear() {
        primero = null;
        ultimo = null;
        cantNodos = 0;
    }

    @Override
    public Object get(int indice) {
        if (indice >= 0 && indice < this.size())
            return this.obtenerNodo(indice).getElemento();

        return null;
    }

    @Override
    public int indexOf(Object elemento) {
        int i = 0;
        while (i < this.size()) {
            if (this.get(i).equals(elemento))
                return i;
            i++;
        }
        return -1;
    }

    @Override
    public String toString() {
        String str = "[";
        if (!this.isEmpty()) {
            for (int i = 0; i < this.size() - 1; i++)
                str += this.obtenerNodo(i).getElemento() + ", ";
            str += ultimo.getElemento();
        }
        str += "]";
        return str;
    }

    public void depurar() {
        Nodo actual = primero;
        for (int i = 0; i < this.size(); i++) {
            System.out.println(i + ": " + actual);
            actual = actual.getSiguiente();
        }
    }

    public Nodo obtenerNodo(int indice) {
        if (indice >= 0 && indice < this.size()) {
            Nodo nodo = primero;
            for (int i = 0; i < indice; i++)
                nodo = nodo.getSiguiente();
            return nodo;
        }
        return null;
    }
}
