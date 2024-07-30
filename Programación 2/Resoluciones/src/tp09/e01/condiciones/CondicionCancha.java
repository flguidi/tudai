package tp09.e01.condiciones;

import tp09.e01.Socio;

public class CondicionCancha extends Condicion {
    // Atributos
    private int idCancha;

    // Constructores
    public CondicionCancha(int idCancha) {
        this.idCancha = idCancha;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(Socio socio) {
        return socio.cantAlquileresCancha(idCancha) > 0;
    }
}
