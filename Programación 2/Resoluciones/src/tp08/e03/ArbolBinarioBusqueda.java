package tp08.e03;

public class ArbolBinarioBusqueda {
    // Atributos
    private Nodo raiz;
    private AccionEjecutable accion;

    // Constructores
    public ArbolBinarioBusqueda() {
        this.raiz = null;
        this.accion = new ImprimirEnPantalla(); // Acción por defecto
    }

    // Métodos
    public void setAccion(AccionEjecutable accion) {
        this.accion = accion;
    }

    public void insertar(int valor) {
        raiz = insertarRec(raiz, valor);
    }

    private Nodo insertarRec(Nodo nodo, int valor) {
        // Si no existe el nodo dado, se crea y finaliza la función (caso base)
        if (nodo == null)
            return new Nodo(valor);

        // Se determina si se inserta a la izquierda o a la derecha
        if (valor < nodo.getValor()) {
            // Lado izquierdo
            Nodo izquierdo = nodo.getIzquierdo(); // Se obtiene el nodo izquierdo del actual
            nodo.setIzquierdo(insertarRec(izquierdo, valor)); // Llamada recursiva a la función
        } else if (valor > nodo.getValor()) {
            // Lado derecho
            Nodo derecho = nodo.getDerecho();
            nodo.setDerecho(insertarRec(derecho, valor));
        }

        return nodo;
    }

    public void ejecutarEnOrden() {
        ejecutarEnOrdenRec(raiz);
    }

    private void ejecutarEnOrdenRec(Nodo nodo) {
        if (nodo == null)
            return; // Si el nodo no existe, finaliza (Caso base)

        ejecutarEnOrdenRec(nodo.getIzquierdo());
        accion.ejecutarNodo(nodo);
        ejecutarEnOrdenRec(nodo.getDerecho());
    }
}
