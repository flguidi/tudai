package tp07.e01.condiciones;

import tp07.e01.Agroquimico;
import tp07.e01.Enfermedad;

public class CondicionEnfermedad extends Condicion {
    // Atributos
    Enfermedad enfermedad;

    // Constructores
    public CondicionEnfermedad(Enfermedad enfermedad) {
        this.enfermedad = enfermedad;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(Agroquimico agroquimico) {
        return agroquimico.puedeTratar(enfermedad);
    }
}
