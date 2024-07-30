package tp06.e03;

import java.time.LocalDate;

public class Camion extends ElementoComparable {
    // Atributos
    private String id;
    private LocalDate fechaCarga;
    private String cargamento;

    // Constructores
    public Camion(String id, LocalDate fechaCarga, String cargamento) {
        this.id = id;
        this.fechaCarga = fechaCarga;
        this.cargamento = cargamento;
    }

    // Métodos
    public String getId() {
        return id;
    }

    public LocalDate getFechaCarga() {
        return fechaCarga;
    }

    public String getCargamento() {
        return cargamento;
    }

    public void cargar(String cargamento) {
        if (this.cargamento == null)
            this.cargamento = cargamento;
    }

    public void descargar() {
        cargamento = null;
    }

    @Override
    public boolean tieneMayorPrioridadQue(ElementoComparable otro) {
        return fechaCarga.isBefore(((Camion) otro).getFechaCarga());
    }

    @Override
    public String toString() {
        return "ID: " + id + " - " +
                "Cargamento: " + cargamento;
    }
}
