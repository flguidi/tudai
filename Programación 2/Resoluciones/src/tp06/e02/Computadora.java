package tp06.e02;

public class Computadora extends ElementoComparable {
    // Atributos
    private String id;
    private double velocidad;
    private Proceso proceso;

    // Constructores
    public Computadora(String id, double velocidad) {
        this.id = id;
        this.velocidad = velocidad;
        this.proceso = null;
    }

    // Métodos
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public void ejecutarProceso(Proceso proceso) {
        this.proceso = proceso;
    }

    @Override
    public boolean esMayor(ElementoComparable otro) {
        return this.getVelocidad() > ((Computadora) otro).getVelocidad();
    }

    @Override
    public String toString() {
        return  "ID: " + id + " - " +
                "Velocidad: " + velocidad;
    }
}
