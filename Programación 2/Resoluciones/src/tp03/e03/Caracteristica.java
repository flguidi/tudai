package tp03.e03;

public class Caracteristica {
    // Atributos
    private String nombre;
    private int valor;

    // Constructores
    public Caracteristica(String nombre, int valor) {
        this.nombre = nombre;
        this.valor = valor;
    }

    // Métodos
    public String getNombre() {
        return nombre;
    }

    public int getValor() {
        return valor;
    }
}
