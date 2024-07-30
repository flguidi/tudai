package tp08.e01;

/**
 * Elemento genérico con un id autoincremental
 */
public class Elemento {
    // Atributos
    private String nombre;

    // Constructores
    public Elemento(String nombre) {
        this.nombre = nombre;
    }

    // Métodos
    public String getNombre() {
        return nombre;
    }

    @Override
    public boolean equals(Object o) {
        try {
            Elemento otro = (Elemento) o;
            return this.getNombre().equals(otro.getNombre());
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public String toString() {
        return nombre;
    }
}
