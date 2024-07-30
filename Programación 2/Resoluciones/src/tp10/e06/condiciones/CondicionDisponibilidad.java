package tp10.e06.condiciones;

import tp10.e06.Habitacion;

public class CondicionDisponibilidad extends Condicion {
    @Override
    public boolean esCumplidaPor(Habitacion habitacion) {
        return habitacion.estaDisponible();
    }
}
