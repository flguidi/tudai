package tp10.e06.condiciones;

import tp10.e06.Habitacion;

public class CondicionNot extends Condicion {
    // Atributos
    private Condicion condicion;

    // Constructores
    public CondicionNot(Condicion condicion) {
        this.condicion = condicion;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(Habitacion habitacion) {
        return !this.condicion.esCumplidaPor(habitacion);
    }
}
