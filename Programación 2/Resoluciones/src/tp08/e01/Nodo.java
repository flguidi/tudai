package tp08.e01;

public class Nodo {
    // Atributos
    private Object elemento;
    private Nodo siguiente; // Puntero al próximo nodo

    // Constructores
    public Nodo(Object elemento) {
        this.elemento = elemento;
        this.siguiente = null;
    }

    // Métodos
    public Object getElemento() {
        return elemento;
    }

    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public String toString() {
        String str = "Elemento: " + elemento + " - ";
        if (siguiente == null)
            str += "Siguiente: " + null;
        else
            str += "Siguiente: " + siguiente.getElemento();
        return str;
    }
}
