package tp07.e04;

public class Ficha {
    // Atributos
    private String nombre;
    private double fortaleza;
    private int espacio;
    private double poderDestruccion;

    // Constructores
    public Ficha(String nombre, double fortaleza, int espacio, double poderDestruccion) {
        this.nombre = nombre;
        this.fortaleza = fortaleza;
        this.espacio = espacio;
        setPoderDestruccion(poderDestruccion);
    }

    // Métodos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getFortaleza() {
        return fortaleza;
    }

    public void setFortaleza(double fortaleza) {
        this.fortaleza = fortaleza;
    }

    public int getEspacio() {
        return espacio;
    }

    public void setEspacio(int espacio) {
        this.espacio = espacio;
    }

    public double getPoderDestruccion() {
        return poderDestruccion;
    }

    public void setPoderDestruccion(double poderDestruccion) {
        this.poderDestruccion = poderDestruccion;
    }

    public String obtenerInformacion() {
        return "FICHA\n" +
                "Nombre: " + nombre + "\n" +
                "Fortaleza: " + fortaleza + "\n" +
                "Espacio: " + espacio + "\n" +
                "Poder de destrucción: " + poderDestruccion;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
