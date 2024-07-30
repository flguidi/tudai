package tp07.e02.condiciones;

import tp07.e02.Documento;

public class CondicionSinPalabrasClave extends Condicion {
    @Override
    public boolean esCumplidaPor(Documento documento) {
        return !documento.tienePalabrasClave();
    }
}
