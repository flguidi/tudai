package tp02.e04;

public class Cancha {
    // Atributos
    private String nombre;
    private double precioHora;

    // Constructores
    public Cancha(String nombre, double precioHora) {
        this.nombre = nombre;
        this.precioHora = precioHora;
    }

    // Métodos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioHora() {
        return precioHora;
    }

    public void setPrecioHora(double precioHora) {
        this.precioHora = precioHora;
    }
}
