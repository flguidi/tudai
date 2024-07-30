package tp10.e05;

import tp10.e05.condiciones.Condicion;
import java.time.LocalDate;
import java.util.ArrayList;

public class Paquete extends ElementoDeCarga {
    // Atributos
    private double costoEnvio, valorAsegurado;

    // Constructores
    public Paquete(String id, String destino, LocalDate fechaPartida, double costoEnvio, double valorAsegurado) {
        super(id, destino, fechaPartida);
        this.costoEnvio = costoEnvio;
        this.valorAsegurado = valorAsegurado;
    }

    // Métodos
    @Override
    public double getCostoEnvio() {
        return this.costoEnvio;
    }

    @Override
    public double getValorAsegurado() {
        return this.valorAsegurado;
    }

    @Override
    public ElementoDeCarga getPaqueteMayorValorAsegurado() {
        return this;
    }

    @Override
    public int cantidad() {
        return 1;
    }

    @Override
    public ArrayList<ElementoDeCarga> buscar(Condicion condicion) {
        ArrayList<ElementoDeCarga> busqueda = new ArrayList<>();
        if (condicion.esCumplidaPor(this))
            busqueda.add(this);
        return busqueda;
    }

    @Override
    public ElementoDeCarga copiar() {
        return new Paquete(
                super.getId(),
                super.getDestino(),
                super.getFechaPartida(),
                this.costoEnvio,
                this.valorAsegurado
        );
    }

    @Override
    public String listar(int nivelIndentacion) {
        String indentacion = "";
        for (int i = 0; i < nivelIndentacion; i++)
            indentacion += "\t";

        return indentacion +
                "Paquete " + this.getId() + " (" +
                this.getDestino() + ", " +
                this.getFechaPartida() + ", " +
                "e: $" + this.getCostoEnvio() + ", " +
                "v: $" + this.getValorAsegurado() + ")";
    }
}
