package tp09.e03.condiciones;

import tp09.e03.Voto;

public class CondicionVotoBlanco extends Condicion {
    @Override
    public boolean esCumplidaPor(Voto voto) {
        return voto.getCandidato() == null;
    }
}
