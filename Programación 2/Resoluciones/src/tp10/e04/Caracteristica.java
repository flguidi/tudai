package tp10.e04;

public class Caracteristica<T> {
    // Atributos
    private String nombre;
    private T valor;

    // Constructores
    public Caracteristica(String nombre, T valor) {
        this.nombre = nombre;
        this.valor = valor;
    }

    // Métodos
    public String getNombre() {
        return nombre;
    }

    public T getValor() {
        return valor;
    }
}
