package tp10.e06.condiciones;

import tp10.e06.Habitacion;

public class CondicionMascotas extends Condicion {
    // Atributos
    private boolean acepta;

    // Constructores
    public CondicionMascotas(boolean acepta) {
        this.acepta = acepta;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(Habitacion habitacion) {
        return habitacion.aceptaMascotas() == this.acepta;
    }
}
