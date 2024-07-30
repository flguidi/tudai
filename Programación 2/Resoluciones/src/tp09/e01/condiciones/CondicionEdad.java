package tp09.e01.condiciones;

import tp09.e01.Socio;

public class CondicionEdad extends Condicion {
    // Atributos
    private int edadLimite;

    // Constructores
    public CondicionEdad(int edadLimite) {
        this.edadLimite = edadLimite;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(Socio socio) {
        return socio.getEdad() < edadLimite;
    }
}
