package tp02.e03;

public class Impuesto {
    // Atributos
    private String nombre;
    private double importe;

    // Constructores
    public Impuesto(String nombre, double importe) {
        this.nombre = nombre;
        this.importe = importe;
    }

    // Métodos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }
}
