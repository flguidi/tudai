package tp09.e05.condiciones;

import tp09.e05.SeguroSimple;

public class CondicionDni extends Condicion {
    // Atributos
    private int dni;

    // Constructores
    public CondicionDni(int dni) {
        this.dni = dni;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(SeguroSimple seguro) {
        return seguro.getDniDuenio() == this.dni;
    }
}
