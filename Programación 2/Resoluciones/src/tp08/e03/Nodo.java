package tp08.e03;

public class Nodo implements Comparable<Nodo> {
    // Atributos
    private int valor;
    private Nodo izquierdo;
    private Nodo derecho;

    // Constructores
    public Nodo(int valor) {
        this.valor = valor;
        this.izquierdo = null;
        this.derecho = null;
    }

    // Métodos
    public void depurar() {
        String str = "Valor: " + valor + " (";

        // Impresión del nodo izquierdo
        str += "i. ";
        if (izquierdo == null)
            str += null;
        else
            str += izquierdo.getValor();

        // Impresión del nodo derecho
        str += " | d. ";
        if (derecho == null)
            str += null;
        else
            str += derecho.getValor();

        str += ")";
        System.out.println(str);
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Nodo getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(Nodo izquierdo) {
        this.izquierdo = izquierdo;
    }

    public Nodo getDerecho() {
        return derecho;
    }

    public void setDerecho(Nodo derecho) {
        this.derecho = derecho;
    }

    @Override
    public int compareTo(Nodo o) {
        return this.getValor() - o.getValor();
    }

    @Override
    public String toString() {
        return valor + "";
    }
}
