package tp06.e03;

public class Barco extends ElementoComparable {
    // Atributos
    private String id;
    private double capacidad;
    private String cargamento;

    // Constructores
    public Barco(String id, double capacidad) {
        this.id = id;
        this.capacidad = capacidad;
        this.cargamento = null;
    }

    // Métodos
    public String getId() {
        return id;
    }

    public double getCapacidad() {
        return capacidad;
    }

    public String getCargamento() {
        return cargamento;
    }

    public void cargarCon(Camion camion) {
        this.cargamento = camion.getCargamento();
        camion.descargar();
    }

    @Override
    public boolean tieneMayorPrioridadQue(ElementoComparable otro) {
        return this.capacidad > ((Barco) otro).getCapacidad();
    }

    @Override
    public String toString() {
        return "ID: " + id + " - " +
                "Cargamento: " + cargamento;
    }
}
