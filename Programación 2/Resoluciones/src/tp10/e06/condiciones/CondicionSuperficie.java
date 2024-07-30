package tp10.e06.condiciones;

import tp10.e06.Habitacion;

public class CondicionSuperficie extends Condicion {
    // Atributos
    private int superficieMinima;

    // Constructores
    public CondicionSuperficie(int superficieMinima) {
        this.superficieMinima = superficieMinima;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(Habitacion habitacion) {
        return habitacion.getSuperficie() > this.superficieMinima;
    }
}
