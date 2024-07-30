package tp06.e02;

public class Proceso extends ElementoComparable {
    // Atributos
    private String id;
    private double memoriaRequerida;

    // Constructores
    public Proceso(String id, double memoriaRequerida) {
        this.id = id;
        this.memoriaRequerida = memoriaRequerida;
    }

    // Métodos
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getMemoriaRequerida() {
        return memoriaRequerida;
    }

    public void setMemoriaRequerida(double memoriaRequerida) {
        this.memoriaRequerida = memoriaRequerida;
    }

    @Override
    public boolean esMayor(ElementoComparable otro) {
        return memoriaRequerida > ((Proceso) otro).memoriaRequerida;
    }

    @Override
    public String toString() {
        return  "ID: " + id + " - " +
                "Memoria requerida: " + memoriaRequerida;
    }
}
