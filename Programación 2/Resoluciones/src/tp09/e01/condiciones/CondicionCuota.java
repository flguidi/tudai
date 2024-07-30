package tp09.e01.condiciones;

import tp09.e01.Socio;

public class CondicionCuota extends Condicion {
    // Atributos
    private boolean ultimaCuotaPaga;

    // Constructores
    public CondicionCuota(boolean ultimaCuotaPaga) {
        this.ultimaCuotaPaga = ultimaCuotaPaga;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(Socio socio) {
        return socio.isUltimaCuotaPaga() == ultimaCuotaPaga;
    }
}
