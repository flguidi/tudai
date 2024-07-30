package tp10.e05;

import tp10.e05.condiciones.Condicion;
import java.time.LocalDate;
import java.util.ArrayList;

public abstract class ElementoDeCarga {
    // Atributos
    private String id, destino;
    private LocalDate fechaPartida;

    // Constructores
    public ElementoDeCarga(String id, String destino, LocalDate fechaPartida) {
        this.id = id;
        this.destino = destino;
        this.fechaPartida = fechaPartida;
    }

    // Métodos
    public String getId() {
        return id;
    }

    public String getDestino() {
        return destino;
    }

    public LocalDate getFechaPartida() {
        return fechaPartida;
    }

    public abstract double getCostoEnvio();

    public abstract double getValorAsegurado();

    public abstract ElementoDeCarga getPaqueteMayorValorAsegurado();

    public abstract int cantidad();

    public abstract ArrayList<ElementoDeCarga> buscar(Condicion condicion);

    public abstract ElementoDeCarga copiar();

    public abstract String listar(int indentacion);

    @Override
    public String toString() {
        return this.id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || this.getClass() != o.getClass())
            return false;

        ElementoDeCarga otro = (ElementoDeCarga) o;
        return this.getId().equals(otro.getId());
    }
}
