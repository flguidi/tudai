package tp10.e06.condiciones;

import tp10.e06.Habitacion;

public class CondicionAnd extends Condicion {
    // Atributos
    private Condicion condicion1;
    private Condicion condicion2;

    // Constructores
    public CondicionAnd(Condicion condicion1, Condicion condicion2) {
        this.condicion1 = condicion1;
        this.condicion2 = condicion2;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(Habitacion habitacion) {
        return condicion1.esCumplidaPor(habitacion) && condicion2.esCumplidaPor(habitacion);
    }
}
