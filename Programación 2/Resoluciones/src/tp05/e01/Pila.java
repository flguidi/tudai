package tp05.e01;

import java.util.ArrayList;

public class Pila {
    // Atributos
    private ArrayList<Object> elementos;

    // Constructores
    public Pila() {
        this.elementos = new ArrayList<>();
    }

    // Métodos
    public void push(Object objeto) {
        this.elementos.add(objeto);
    }

    public Object pop() {
        if (!this.elementos.isEmpty()) {
            int indiceFinal = this.elementos.size() - 1;
            return this.elementos.remove(indiceFinal);
        }
        return null;
    }

    public Object top() {
        if (!this.elementos.isEmpty()) {
            int indiceFinal = this.elementos.size() - 1;
            return this.elementos.get(indiceFinal);
        }
        return null;
    }

    public int size() {
        return this.elementos.size();
    }

    public ArrayList<Object> copy() {
        return new ArrayList<>(this.elementos);
    }

    public ArrayList<Object> reverse() {
        if (!this.elementos.isEmpty()) {
            ArrayList<Object> elementosAux = new ArrayList<>();
            for(int i = 0; i < this.elementos.size(); i++)
                elementosAux.add(this.elementos.get((this.elementos.size() - 1) - i));
            return elementosAux;
        }
        return null;
    }

    @Override
    public String toString() {
        return this.elementos.toString();
    }
}
