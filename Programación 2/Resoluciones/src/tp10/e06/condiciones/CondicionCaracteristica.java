package tp10.e06.condiciones;

import tp10.e06.Habitacion;

public class CondicionCaracteristica extends Condicion {
    // Atributos
    private String caracteristica;

    // Constructores
    public CondicionCaracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(Habitacion habitacion) {
        return habitacion.tieneCaracteristica(this.caracteristica);
    }
}
