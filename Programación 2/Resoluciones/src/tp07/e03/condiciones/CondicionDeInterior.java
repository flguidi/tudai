package tp07.e03.condiciones;

import tp07.e03.Planta;

public class CondicionDeInterior extends Condicion {
    // Atributos
    private boolean deInterior;

    // Constructores
    public CondicionDeInterior(boolean deInterior) {
        this.deInterior = deInterior;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(Planta planta) {
        return planta.isDeInterior();
    }
}
